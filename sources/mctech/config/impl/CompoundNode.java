package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Arrays;
import java.util.List;
import mctech.api.gui.DataType;
import mctech.api.gui.ICompoundNode;
import mctech.api.gui.IValueNode;
import mctech.config.ConfigEntry;
import mctech.config.utils.Helpers;
import mctech.config.utils.ParseResult;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/CompoundNode.class */
public class CompoundNode implements ICompoundNode, ICompoundProvider {
    ConfigEntry<?> entry;
    List<DataType> types;
    String[] names;
    List<IValueNode> values = new ObjectArrayList();
    ObjectArrayList<String[]> previous = new ObjectArrayList<>();
    String[] current;
    String[] defaultValues;

    public CompoundNode(ConfigEntry<?> configEntry, List<DataType> list, String[] strArr) {
        this.entry = configEntry;
        this.types = list;
        this.names = strArr;
        String[] strArrSplitArray = Helpers.splitArray(configEntry.serialize(), ";");
        this.current = strArrSplitArray;
        this.previous.push((String[]) Arrays.copyOf(strArrSplitArray, strArrSplitArray.length));
        this.defaultValues = Helpers.splitArray(configEntry.serializeDefault(), ";");
        reload();
    }

    public void save() {
        this.entry.deserializeValue(Helpers.mergeCompound(this.current));
    }

    private void reload() {
        this.values.clear();
        int i = 0;
        int size = this.types.size();
        while (i < size) {
            this.values.add(new CompoundValue(this.types.get(i), i, this, this.current, i >= this.defaultValues.length ? "" : this.defaultValues[i]));
            i++;
        }
    }

    @Override // mctech.api.gui.ICompoundNode
    public Component getName(int i) {
        return Component.literal(this.names[i]);
    }

    @Override // mctech.api.gui.ICompoundNode
    public void set(String str) {
        this.current = Helpers.splitArray(str, ";");
    }

    @Override // mctech.api.gui.ICompoundNode
    public ParseResult<Boolean> isValid(String str) {
        return this.entry.canSetValue(str);
    }

    @Override // mctech.api.gui.ICompoundNode
    public String get() {
        return Helpers.mergeCompound(this.current);
    }

    private String[] getPrev() {
        return (String[]) this.previous.top();
    }

    @Override // mctech.api.gui.INode
    public boolean isDefault() {
        return Arrays.equals(this.defaultValues, this.current);
    }

    @Override // mctech.api.gui.INode
    public boolean isChanged() {
        return !Arrays.equals(getPrev(), this.current);
    }

    @Override // mctech.api.gui.INode
    public void setDefault() {
        this.current = (String[]) Arrays.copyOf(this.defaultValues, this.defaultValues.length);
    }

    @Override // mctech.api.gui.INode
    public void setPrevious() {
        String[] prev = getPrev();
        this.current = (String[]) Arrays.copyOf(prev, prev.length);
        if (this.previous.size() > 1) {
            this.previous.pop();
        }
    }

    @Override // mctech.api.gui.ICompoundNode
    public boolean isValid() {
        return this.entry.canSetValue(Helpers.mergeCompound(this.current)).getValue().booleanValue();
    }

    @Override // mctech.config.impl.ICompoundProvider
    public ParseResult<Boolean> isValid(String str, int i) {
        return this.entry.canSetValue(buildValue(str, i));
    }

    private String buildValue(String str, int i) {
        String[] strArr = (String[]) Arrays.copyOf(this.current, this.current.length);
        strArr[i] = str;
        return Helpers.mergeCompound(strArr);
    }

    @Override // mctech.api.gui.INode
    public void createTemp() {
        this.previous.push((String[]) Arrays.copyOf(this.current, this.current.length));
        reload();
    }

    @Override // mctech.api.gui.INode
    public void apply() {
        if (this.previous.size() > 1) {
            this.previous.pop();
        }
    }

    @Override // mctech.api.gui.ICompoundNode
    public List<IValueNode> getValues() {
        return this.values;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/CompoundNode$CompoundValue.class */
    public static class CompoundValue implements IValueNode {
        DataType type;
        int index;
        ICompoundProvider compound;
        String[] values;
        String defaultValue;
        ObjectArrayList<String> startingValue = new ObjectArrayList<>();

        public CompoundValue(DataType dataType, int i, ICompoundProvider iCompoundProvider, String[] strArr, String str) {
            this.type = dataType;
            this.index = i;
            this.compound = iCompoundProvider;
            this.values = strArr;
            this.startingValue.push(strArr[i]);
            this.defaultValue = str;
        }

        @Override // mctech.api.gui.INode
        public boolean isDefault() {
            return this.values[this.index].equals(this.defaultValue);
        }

        @Override // mctech.api.gui.INode
        public boolean isChanged() {
            return !this.values[this.index].equals(this.startingValue.top());
        }

        @Override // mctech.api.gui.IValueNode
        public boolean isCompoundNode() {
            return true;
        }

        @Override // mctech.api.gui.INode
        public void setDefault() {
            this.values[this.index] = this.defaultValue;
        }

        @Override // mctech.api.gui.INode
        public void setPrevious() {
            this.values[this.index] = (String) this.startingValue.top();
            if (this.startingValue.size() > 1) {
                this.startingValue.pop();
            }
        }

        @Override // mctech.api.gui.INode
        public void createTemp() {
            this.startingValue.push(this.values[this.index]);
        }

        @Override // mctech.api.gui.INode
        public void apply() {
            if (this.startingValue.size() > 1) {
                this.startingValue.pop();
            }
        }

        @Override // mctech.api.gui.IValueNode
        public String get() {
            return this.values[this.index];
        }

        @Override // mctech.api.gui.IValueNode
        public void set(String str) {
            this.values[this.index] = str;
        }

        @Override // mctech.api.gui.IValueNode
        public ParseResult<Boolean> isValid(String str) {
            return this.compound.isValid(str, this.index);
        }
    }
}
