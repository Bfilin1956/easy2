package mctech.api.gui;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/INode.class */
public interface INode {
    boolean isDefault();

    boolean isChanged();

    void setDefault();

    void setPrevious();

    void createTemp();

    void apply();
}
