package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectLists;
import java.util.List;
import mctech.api.gui.DataType;
import mctech.api.gui.IArrayNode;
import mctech.api.gui.ICompoundNode;
import mctech.api.gui.IConfigNode;
import mctech.api.gui.IValueNode;
import mctech.config.ConfigEntry;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.apache.logging.log4j.util.Strings;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ConfigLeaf.class */
public class ConfigLeaf implements IConfigNode {
    ConfigEntry<?> entry;
    ValueNode value;
    ArrayNode arrayValue;

    public ConfigLeaf(ConfigEntry<?> configEntry) {
        this.entry = configEntry;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<IConfigNode> getChildren() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public IValueNode asValue() {
        if (isArray()) {
            return null;
        }
        if (this.value == null) {
            this.value = new ValueNode(this.entry);
        }
        return this.value;
    }

    @Override // mctech.api.gui.IConfigNode
    public IArrayNode asArray() {
        if (!isArray()) {
            return null;
        }
        if (this.arrayValue == null) {
            this.arrayValue = new ArrayNode(this.entry, (ConfigEntry.IArrayConfig) this.entry, DataType.bySimple(this.entry.getDataType().asDataType()));
        }
        return this.arrayValue;
    }

    @Override // mctech.api.gui.IConfigNode
    public ICompoundNode asCompound() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<DataType> getDataType() {
        return ObjectLists.singleton(DataType.bySimple(this.entry.getDataType().asDataType()));
    }

    @Override // mctech.api.gui.IConfigNode
    public List<ConfigEntry.Suggestion> getValidValues() {
        return this.entry.getSuggestions();
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isLeaf() {
        return true;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isArray() {
        return this.entry instanceof ConfigEntry.IArrayConfig;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isRoot() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isChanged() {
        return (this.value != null && this.value.isChanged()) || (this.arrayValue != null && this.arrayValue.isChanged());
    }

    @Override // mctech.api.gui.IConfigNode
    public void save() {
        if (this.value != null) {
            this.value.save();
        }
        if (this.arrayValue != null) {
            this.arrayValue.save();
        }
    }

    @Override // mctech.api.gui.IConfigNode
    public void setPrevious() {
        if (this.value != null) {
            this.value.setPrevious();
        }
        if (this.arrayValue != null) {
            this.arrayValue.setPrevious();
        }
    }

    @Override // mctech.api.gui.IConfigNode
    public void setDefault() {
        if (isArray()) {
            if (this.arrayValue == null) {
                asArray();
            }
            this.arrayValue.setDefault();
        } else {
            if (this.value == null) {
                asValue();
            }
            this.value.setDefault();
        }
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean requiresRestart() {
        return this.entry.getReloadState() == ReloadMode.GAME;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean requiresReload() {
        return this.entry.getReloadState() == ReloadMode.WORLD;
    }

    @Override // mctech.api.gui.IConfigNode
    public Component getName() {
        return IConfigNode.createLabel(this.entry.getKey());
    }

    @Override // mctech.api.gui.IConfigNode
    public Component getTooltip() {
        MutableComponent mutableComponentEmpty = Component.empty();
        mutableComponentEmpty.append(Component.literal(this.entry.getKey()).withStyle(ChatFormatting.YELLOW));
        String[] comment = this.entry.getComment();
        if (comment != null && comment.length > 0) {
            int i = 0;
            while (i < comment.length) {
                int i2 = i;
                i++;
                mutableComponentEmpty.append("\n").append(comment[i2]).withStyle(ChatFormatting.GRAY);
            }
        }
        String limitations = this.entry.getLimitations();
        if (!Strings.isBlank(limitations)) {
            mutableComponentEmpty.append("\n").append(Component.literal(limitations).withStyle(ChatFormatting.BLUE));
        }
        return mutableComponentEmpty;
    }
}
