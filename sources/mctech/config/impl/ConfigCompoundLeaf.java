package mctech.config.impl;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.List;
import java.util.Map;
import mctech.api.gui.DataType;
import mctech.api.gui.IArrayNode;
import mctech.api.gui.ICompoundNode;
import mctech.api.gui.IConfigNode;
import mctech.api.gui.IValueNode;
import mctech.config.ConfigEntry;
import mctech.config.utils.Helpers;
import mctech.config.utils.IEntryDataType;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import org.apache.logging.log4j.util.Strings;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/config/impl/ConfigCompoundLeaf.class */
public class ConfigCompoundLeaf implements IConfigNode {
    ConfigEntry<?> entry;
    CompoundNode value;
    CompoundArrayNode array;

    public ConfigCompoundLeaf(ConfigEntry<?> configEntry) {
        this.entry = configEntry;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<IConfigNode> getChildren() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public IValueNode asValue() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    public IArrayNode asArray() {
        if (!isArray()) {
            return null;
        }
        if (this.array == null) {
            this.array = new CompoundArrayNode(this.entry, (ConfigEntry.IArrayConfig) this.entry, getDataType(), generateNames());
        }
        return this.array;
    }

    @Override // mctech.api.gui.IConfigNode
    public ICompoundNode asCompound() {
        if (isArray()) {
            return null;
        }
        if (this.value == null) {
            this.value = new CompoundNode(this.entry, getDataType(), generateNames());
        }
        return this.value;
    }

    private String[] generateNames() {
        List<Map.Entry<String, IEntryDataType.EntryDataType>> compound = this.entry.getDataType().asCompound().getCompound();
        String[] strArr = new String[compound.size()];
        int size = compound.size();
        for (int i = 0; i < size; i++) {
            strArr[i] = compound.get(i).getKey();
        }
        return strArr;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<DataType> getDataType() {
        IEntryDataType.CompoundDataType compoundDataTypeAsCompound = this.entry.getDataType().asCompound();
        ObjectArrayList objectArrayList = new ObjectArrayList();
        for (Map.Entry<String, IEntryDataType.EntryDataType> entry : compoundDataTypeAsCompound.getCompound()) {
            objectArrayList.add(DataType.byConfig(entry.getValue(), compoundDataTypeAsCompound.getVariant(entry.getKey())));
        }
        return objectArrayList;
    }

    @Override // mctech.api.gui.IConfigNode
    public List<ConfigEntry.Suggestion> getValidValues() {
        return this.entry.getSuggestions();
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isArray() {
        return this.entry instanceof ConfigEntry.IArrayConfig;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isLeaf() {
        return true;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isRoot() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    public boolean isChanged() {
        return (this.value != null && this.value.isChanged()) || (this.array != null && this.array.isChanged());
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
    public void save() {
        if (this.value != null) {
            this.value.save();
        }
        if (this.array != null) {
            this.array.save();
        }
    }

    @Override // mctech.api.gui.IConfigNode
    public void setPrevious() {
        if (this.value != null) {
            this.value.setPrevious();
        }
        if (this.array != null) {
            this.array.setPrevious();
        }
    }

    @Override // mctech.api.gui.IConfigNode
    public void setDefault() {
        if (isArray()) {
            if (this.array == null) {
                asArray();
            }
            this.array.setDefault();
        } else {
            if (this.value == null) {
                asCompound();
            }
            this.value.setDefault();
        }
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
            mutableComponentEmpty.append("\n");
            int i = 0;
            while (i < comment.length) {
                int i2 = i;
                i++;
                mutableComponentEmpty.append(comment[i2]).append("\n");
            }
        }
        String limitations = this.entry.getLimitations();
        if (!Strings.isBlank(limitations)) {
            String[] strArrSplitArray = Helpers.splitArray(limitations, ",");
            int i3 = 0;
            int length = strArrSplitArray.length;
            while (i3 < length) {
                int i4 = i3;
                i3++;
                mutableComponentEmpty.append("\n").append(Component.literal(strArrSplitArray[i4]).withStyle(ChatFormatting.GRAY));
            }
        }
        return mutableComponentEmpty;
    }
}
