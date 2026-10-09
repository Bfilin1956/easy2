package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Objects;
import mctech.api.gui.IValueNode;
import mctech.config.ConfigEntry;
import mctech.config.utils.ParseResult;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ValueNode.class */
public class ValueNode implements IValueNode {
    ObjectArrayList<String> previous = new ObjectArrayList<>();
    String current;
    String defaultValue;
    ConfigEntry<?> entry;

    public ValueNode(ConfigEntry<?> configEntry) {
        this.entry = configEntry;
        String strSerialize = configEntry.serialize();
        this.previous.push(strSerialize);
        this.current = strSerialize;
        this.defaultValue = configEntry.serializeDefault();
    }

    public void save() {
        this.entry.deserializeValue(this.current);
    }

    @Override // mctech.api.gui.IValueNode
    public String get() {
        return this.current;
    }

    @Override // mctech.api.gui.IValueNode
    public void set(String str) {
        this.current = str;
    }

    @Override // mctech.api.gui.IValueNode
    public ParseResult<Boolean> isValid(String str) {
        return this.entry.canSetValue(str);
    }

    @Override // mctech.api.gui.INode
    public boolean isDefault() {
        return Objects.equals(this.defaultValue, this.current);
    }

    @Override // mctech.api.gui.INode
    public boolean isChanged() {
        return !Objects.equals(this.previous.top(), this.current);
    }

    @Override // mctech.api.gui.IValueNode
    public boolean isCompoundNode() {
        return false;
    }

    @Override // mctech.api.gui.INode
    public void setDefault() {
        this.current = this.defaultValue;
    }

    @Override // mctech.api.gui.INode
    public void setPrevious() {
        this.current = (String) this.previous.top();
        if (this.previous.size() > 1) {
            this.previous.pop();
        }
    }

    @Override // mctech.api.gui.INode
    public void createTemp() {
        this.previous.push(this.current);
    }

    @Override // mctech.api.gui.INode
    public void apply() {
        if (this.previous.size() > 1) {
            this.previous.pop();
        }
    }
}
