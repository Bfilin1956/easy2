package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import mctech.api.gui.DataType;
import mctech.api.gui.IArrayNode;
import mctech.api.gui.ICompoundNode;
import mctech.api.gui.IConfigNode;
import mctech.api.gui.IValueNode;
import mctech.config.Config;
import mctech.config.ConfigEntry;
import mctech.config.ConfigSection;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ConfigRoot.class */
public class ConfigRoot implements IConfigNode {
    Config config;
    List<IConfigNode> children;

    public ConfigRoot(Config config) {
        this.config = config;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<IConfigNode> getChildren() {
        if (this.children == null) {
            this.children = new ObjectArrayList();
            Iterator<ConfigSection> it = this.config.getChildren().iterator();
            while (it.hasNext()) {
                this.children.add(new ConfigNode(it.next()));
            }
        }
        return this.children;
    }

    @Override // mctech.api.gui.IConfigNode
    public IValueNode asValue() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public IArrayNode asArray() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public ICompoundNode asCompound() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<ConfigEntry.Suggestion> getValidValues() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<DataType> getDataType() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isArray() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isLeaf() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isRoot() {
        return true;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isChanged() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    public void save() {
    }

    @Override // mctech.api.gui.IConfigNode
    public void setPrevious() {
    }

    @Override // mctech.api.gui.IConfigNode
    public void setDefault() {
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean requiresRestart() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean requiresReload() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    public Component getName() {
        return IConfigNode.createLabel(this.config.getName());
    }

    @Override // mctech.api.gui.IConfigNode
    public Component getTooltip() {
        return null;
    }
}
