package mctech.api.gui;

import java.util.List;
import mctech.config.ConfigEntry;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IConfigFolderNode.class */
public interface IConfigFolderNode extends IConfigNode {
    @Override // mctech.api.gui.IConfigNode
    default List<ConfigEntry.Suggestion> getValidValues() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    default IValueNode asValue() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    default IArrayNode asArray() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    default ICompoundNode asCompound() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    default boolean isArray() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    default List<DataType> getDataType() {
        return null;
    }

    @Override // mctech.api.gui.IConfigNode
    default boolean isLeaf() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    default boolean isRoot() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    default boolean isChanged() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    default void save() {
    }

    @Override // mctech.api.gui.IConfigNode
    default void setPrevious() {
    }

    @Override // mctech.api.gui.IConfigNode
    default void setDefault() {
    }

    @Override // mctech.api.gui.IConfigNode
    default boolean requiresRestart() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    default boolean requiresReload() {
        return false;
    }

    @Override // mctech.api.gui.IConfigNode
    default Component getTooltip() {
        return Component.empty();
    }
}
