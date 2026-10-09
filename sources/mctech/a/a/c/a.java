package mctech.a.a.c;

import appeng.api.parts.IPartCollisionHelper;
import appeng.api.util.AECableType;
import appeng.items.parts.ColoredPartItem;
import appeng.parts.networking.CablePart;
import appeng.parts.networking.IUsedChannelProvider;
import java.util.function.Predicate;
import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/a/c/a.class */
public class a extends CablePart implements IUsedChannelProvider, mctech.a.a {
    private final int a;

    public a(ColoredPartItem<?> coloredPartItem, int i) {
        super(coloredPartItem);
        this.a = i;
    }

    public AECableType getCableConnectionType() {
        return AECableType.COVERED;
    }

    @Override // mctech.a.a
    public int a() {
        return this.a;
    }

    public void getBoxes(IPartCollisionHelper iPartCollisionHelper, Predicate<Direction> predicate) {
        updateConnections();
        addNonDenseBoxes(iPartCollisionHelper, predicate, 5.0d, 11.0d);
    }
}
