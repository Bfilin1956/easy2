package mctech.api.gui;

import mctech.config.utils.ParseResult;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IValueNode.class */
public interface IValueNode extends INode {
    String get();

    void set(String str);

    ParseResult<Boolean> isValid(String str);

    boolean isCompoundNode();
}
