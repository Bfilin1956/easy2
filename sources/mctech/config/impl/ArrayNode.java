package mctech.config.impl;

import com.google.common.base.Objects;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.List;
import mctech.api.gui.DataType;
import mctech.api.gui.IArrayNode;
import mctech.api.gui.INode;
import mctech.api.gui.IValueNode;
import mctech.config.ConfigEntry;
import mctech.config.utils.ParseResult;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ArrayNode.class */
public class ArrayNode implements IArrayNode {
    ConfigEntry<?> entry;
    ConfigEntry.IArrayConfig config;
    DataType type;
    List<String> currentValues;
    List<String> defaults;
    List<WrappedEntry> values = new ObjectArrayList();
    ObjectArrayList<List<String>> previous = new ObjectArrayList<>();

    public ArrayNode(ConfigEntry<?> configEntry, ConfigEntry.IArrayConfig iArrayConfig, DataType dataType) {
        this.entry = configEntry;
        this.config = iArrayConfig;
        this.type = dataType;
        this.previous.push(iArrayConfig.getEntries());
        this.currentValues = iArrayConfig.getEntries();
        this.defaults = iArrayConfig.getDefaults();
        reload();
    }

    public void save() {
        this.config.setArray(this.currentValues);
    }

    protected void reload() {
        this.values.clear();
        int i = 0;
        while (i < this.currentValues.size()) {
            this.values.add(new WrappedEntry(this, this.config, this.currentValues, i, i >= this.defaults.size() ? null : this.defaults.get(i)));
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
    public IValueNode get(int i) {
        return this.values.get(i);
    }

    @Override // mctech.api.gui.IArrayNode
    public int indexOf(INode iNode) {
        return this.values.indexOf(iNode);
    }

    @Override // mctech.api.gui.IArrayNode
    public void createNode() {
        this.currentValues.add(this.type.getDefaultValue());
        this.values.add(new WrappedEntry(this, this.config, this.currentValues, this.values.size(), null));
    }

    @Override // mctech.api.gui.IArrayNode
    public void removeNode(int i) {
        this.values.remove(i);
        this.currentValues.remove(i);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ArrayNode$WrappedEntry.class */
    public static class WrappedEntry implements IValueNode {
        IArrayNode owner;
        ConfigEntry.IArrayConfig array;
        List<String> values;
        String defaultValue;
        ObjectArrayList<String> previous = new ObjectArrayList<>();

        public WrappedEntry(IArrayNode iArrayNode, ConfigEntry.IArrayConfig iArrayConfig, List<String> list, int i, String str) {
            this.owner = iArrayNode;
            this.array = iArrayConfig;
            this.values = list;
            this.defaultValue = str;
            this.previous.add(list.get(i));
        }

        private int getIndex() {
            return this.owner.indexOf(this);
        }

        @Override // mctech.api.gui.IValueNode
        public String get() {
            return this.values.get(getIndex());
        }

        @Override // mctech.api.gui.IValueNode
        public void set(String str) {
            this.values.set(getIndex(), str);
        }

        @Override // mctech.api.gui.IValueNode
        public ParseResult<Boolean> isValid(String str) {
            return this.array.canSetArray(ObjectLists.singleton(str));
        }

        @Override // mctech.api.gui.IValueNode
        public boolean isCompoundNode() {
            return false;
        }

        @Override // mctech.api.gui.INode
        public boolean isDefault() {
            return this.defaultValue == null || Objects.equal(this.defaultValue, this.values.get(getIndex()));
        }

        @Override // mctech.api.gui.INode
        public boolean isChanged() {
            return !Objects.equal(this.previous.top(), this.values.get(getIndex()));
        }

        @Override // mctech.api.gui.INode
        public void setDefault() {
            this.values.set(getIndex(), this.defaultValue == null ? "" : this.defaultValue);
        }

        @Override // mctech.api.gui.INode
        public void setPrevious() {
            this.values.set(getIndex(), (String) this.previous.top());
            if (this.previous.size() > 1) {
                this.previous.pop();
            }
        }

        @Override // mctech.api.gui.INode
        public void createTemp() {
            this.previous.push(this.values.get(getIndex()));
        }

        @Override // mctech.api.gui.INode
        public void apply() {
            if (this.previous.size() > 1) {
                this.previous.pop();
            }
        }
    }
}
