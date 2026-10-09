package mctech.api.gui;

import java.util.List;
import mctech.config.utils.ParseResult;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/ICompoundNode.class */
public interface ICompoundNode extends INode {
    List<IValueNode> getValues();

    Component getName(int i);

    boolean isValid();

    String get();

    ParseResult<Boolean> isValid(String str);

    void set(String str);
}
