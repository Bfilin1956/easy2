package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.Arrays;
import java.util.List;
import mctech.api.gui.DataType;
import mctech.api.gui.IArrayNode;
import mctech.api.gui.ICompoundNode;
import mctech.api.gui.INode;
import mctech.api.gui.IValueNode;
import mctech.config.ConfigEntry;
import mctech.config.utils.Helpers;
import mctech.config.utils.ParseResult;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/CompoundArrayNode.class */
public class CompoundArrayNode implements IArrayNode {
    ConfigEntry<?> entry;
    ConfigEntry.IArrayConfig config;
    String[] names;
    List<DataType> dataTypes;
    List<ICompoundNode> values = new ObjectArrayList();
    ObjectArrayList<List<String>> previous = new ObjectArrayList<>();
    List<String> currentValues;
    List<String> defaults;
    String defaultEmptyValue;

    public CompoundArrayNode(ConfigEntry<?> configEntry, ConfigEntry.IArrayConfig iArrayConfig, List<DataType> list, String[] strArr) {
        this.entry = configEntry;
        this.config = iArrayConfig;
        this.dataTypes = list;
        this.names = strArr;
        this.previous.push(iArrayConfig.getEntries());
        this.currentValues = iArrayConfig.getEntries();
        this.defaults = iArrayConfig.getDefaults();
        String[] strArr2 = new String[list.size()];
        int size = list.size();
        for (int i = 0; i < size; i++) {
            strArr2[i] = list.get(i).getDefaultValue();
        }
        this.defaultEmptyValue = Helpers.mergeCompound(strArr2);
    }

    public void save() {
        this.config.setArray(this.currentValues);
    }

    protected void reload() {
        this.values.clear();
        int i = 0;
        while (i < this.currentValues.size()) {
            this.values.add(new CompoundEntry(this, this.config, this.currentValues, i >= this.defaults.size() ? this.defaultEmptyValue : this.defaults.get(i), i, this.dataTypes, this.names));
            i++;
        }
    }

    protected List<String> getPrev() {
        return (List) this.previous.top();
    }

    @Override // mctech.api.gui.INode
    public boolean isChanged() {
        return !getPrev().equals(this.currentValues);
    }

    @Override // mctech.api.gui.INode
    public boolean isDefault() {
        return this.currentValues.equals(this.defaults);
    }

    @Override // mctech.api.gui.INode
    public void setPrevious() {
        this.currentValues.clear();
        this.currentValues.addAll(getPrev());
        if (this.previous.size() > 1) {
            this.previous.pop();
        }
        reload();
    }

    @Override // mctech.api.gui.INode
    public void setDefault() {
        this.currentValues.clear();
        this.currentValues.addAll(this.defaults);
        reload();
    }

    @Override // mctech.api.gui.INode
    public void createTemp() {
        this.previous.push(new ObjectArrayList(this.currentValues));
        reload();
    }

    @Override // mctech.api.gui.INode
    public void apply() {
        if (this.previous.size() > 1) {
            this.previous.pop();
        }
    }

    @Override // mctech.api.gui.IArrayNode
    public int size() {
        return this.values.size();
    }

    @Override // mctech.api.gui.IArrayNode
    public ICompoundNode get(int i) {
        return this.values.get(i);
    }

    @Override // mctech.api.gui.IArrayNode
    public int indexOf(INode iNode) {
        return this.values.indexOf(iNode);
    }

    @Override // mctech.api.gui.IArrayNode
    public void createNode() {
        this.currentValues.add(this.defaultEmptyValue);
        this.values.add(new CompoundEntry(this, this.config, this.currentValues, this.defaultEmptyValue, this.values.size(), this.dataTypes, this.names));
    }

    @Override // mctech.api.gui.IArrayNode
    public void removeNode(int i) {
        this.values.remove(i);
        this.currentValues.remove(i);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/CompoundArrayNode$CompoundEntry.class */
    public static class CompoundEntry implements ICompoundNode, ICompoundProvider {
        ConfigEntry.IArrayConfig config;
        IArrayNode node;
        List<DataType> types;
        String[] names;
        List<String> results;
        String[] current;
        String[] defaultValues;
        List<IValueNode> values = new ObjectArrayList();
        ObjectArrayList<String[]> previous = new ObjectArrayList<>();

        public CompoundEntry(IArrayNode iArrayNode, ConfigEntry.IArrayConfig iArrayConfig, List<String> list, String str, int i, List<DataType> list2, String[] strArr) {
            this.node = iArrayNode;
            this.config = iArrayConfig;
            this.types = list2;
            this.results = list;
            this.names = strArr;
            String[] strArrSplitArray = Helpers.splitArray(list.get(i), ";");
            this.current = strArrSplitArray;
            this.previous.push((String[]) Arrays.copyOf(strArrSplitArray, strArrSplitArray.length));
            this.defaultValues = Helpers.splitArray(str, ";");
            reload();
        }

        public void reload() {
            this.values.clear();
            int i = 0;
            int size = this.types.size();
            while (i < size) {
                this.values.add(new CompoundNode.CompoundValue(this.types.get(i), i, this, this.current, i >= this.defaultValues.length ? "" : this.defaultValues[i]));
                i++;
            }
        }

        @Override // mctech.api.gui.ICompoundNode
        public void set(String str) {
            this.current = Helpers.splitArray(str, ";");
        }

        @Override // mctech.api.gui.ICompoundNode
        public ParseResult<Boolean> isValid(String str) {
            return this.config.canSetArray(ObjectLists.singleton(str));
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
            return this.config.canSetArray(ObjectLists.singleton(Helpers.mergeCompound(this.current))).getValue().booleanValue();
        }

        @Override // mctech.config.impl.ICompoundProvider
        public ParseResult<Boolean> isValid(String str, int i) {
            return canSkip(str, i) ? ParseResult.success(true) : this.config.canSetArray(ObjectLists.singleton(buildValue(str, i)));
        }

        private boolean canSkip(String str, int i) {
            if (!this.types.get(i).isAllowEmptyValue() && str.trim().isEmpty()) {
                return true;
            }
            int length = this.current.length;
            for (int i2 = 0; i2 < length; i2++) {
                if (i2 != i && !this.types.get(i).isAllowEmptyValue() && this.current[i2].trim().isEmpty()) {
                    return true;
                }
            }
            return false;
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
            this.results.set(this.node.indexOf(this), Helpers.mergeCompound(this.current));
        }

        @Override // mctech.api.gui.ICompoundNode
        public List<IValueNode> getValues() {
            return this.values;
        }

        @Override // mctech.api.gui.ICompoundNode
        public Component getName(int i) {
            return Component.literal(this.names[i]);
        }
    }
}
