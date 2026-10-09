package mctech.api.gui;

import java.util.List;
import mctech.config.ConfigEntry;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IConfigNode.class */
public interface IConfigNode {
    List<IConfigNode> getChildren();

    IValueNode asValue();

    IArrayNode asArray();

    ICompoundNode asCompound();

    List<DataType> getDataType();

    List<ConfigEntry.Suggestion> getValidValues();

    boolean isArray();

    boolean isLeaf();

    boolean isRoot();

    boolean isChanged();

    void setPrevious();

    void setDefault();

    void save();

    boolean requiresRestart();

    boolean requiresReload();

    Component getName();

    Component getTooltip();

    static MutableComponent createLabel(String str) {
        MutableComponent mutableComponentEmpty = Component.empty();
        for (String str2 : str.split("(?=\\p{Lu})|\\_|\\-")) {
            String string = Character.toString(str2.charAt(0));
            mutableComponentEmpty.append(str2.replaceFirst(string, string.toUpperCase())).append(" ");
        }
        return mutableComponentEmpty;
    }
}
