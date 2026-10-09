package mctech.api.gui;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/IArrayNode.class */
public interface IArrayNode extends INode {
    int size();

    INode get(int i);

    void createNode();

    void removeNode(int i);

    int indexOf(INode iNode);

    default IValueNode asValue(int i) {
        INode iNode = get(i);
        if (iNode instanceof IValueNode) {
            return (IValueNode) iNode;
        }
        return null;
    }

    default ICompoundNode asCompound(int i) {
        INode iNode = get(i);
        if (iNode instanceof ICompoundNode) {
            return (ICompoundNode) iNode;
        }
        return null;
    }
}
