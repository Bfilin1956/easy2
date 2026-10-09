package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Iterator;
import java.util.List;
import mctech.api.gui.IConfigFolderNode;
import mctech.api.gui.IConfigNode;
import mctech.config.ConfigEntry;
import mctech.config.ConfigSection;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ConfigNode.class */
public class ConfigNode implements IConfigFolderNode {
    ConfigSection section;
    List<IConfigNode> children;

    public ConfigNode(ConfigSection configSection) {
        this.section = configSection;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<IConfigNode> getChildren() {
        if (this.children == null) {
            this.children = new ObjectArrayList();
            Iterator<ConfigSection> it = this.section.getChildren().iterator();
            while (it.hasNext()) {
                this.children.add(new ConfigNode(it.next()));
            }
            for (ConfigEntry<?> configEntry : this.section.getEntries()) {
                if (configEntry.getDataType().isCompound()) {
                    this.children.add(new ConfigCompoundLeaf(configEntry));
                } else {
                    this.children.add(new ConfigLeaf(configEntry));
                }
            }
        }
        return this.children;
    }

    @Override // mctech.api.gui.IConfigNode
    public Component getName() {
        return IConfigNode.createLabel(this.section.getName());
    }
}
