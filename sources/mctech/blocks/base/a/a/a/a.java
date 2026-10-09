package mctech.blocks.base.a.a.a;

import java.util.Iterator;
import mctech.api.util.DirectionList;
import net.minecraft.core.Direction;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a.class */
public abstract class a extends mctech.blocks.base.a.a.a {
    private int[] f;

    protected abstract int b(Direction direction);

    public a(String str, Component component) {
        super(str, component);
        this.f = new int[7];
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return 0;
    }

    @Override // mctech.blocks.base.a.a.a
    public int a(Direction direction) {
        return this.f[direction == null ? 6 : direction.get3DDataValue()];
    }

    @Override // mctech.blocks.base.a.a.a
    public boolean a(long j, boolean z) {
        if (this.b >= j) {
            return false;
        }
        this.b = j;
        if (!z && this.a.isEmpty()) {
            return false;
        }
        boolean zC = c(null);
        Iterator<Direction> it = DirectionList.ALL.iterator();
        while (it.hasNext()) {
            zC |= c(it.next());
        }
        if (zC) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                this.a.get(i).c();
            }
            return true;
        }
        return false;
    }

    protected boolean c(Direction direction) {
        int iClamp = Mth.clamp(b(direction), 0, 15);
        if (iClamp != this.f[direction == null ? 6 : direction.get3DDataValue()]) {
            this.f[direction == null ? 6 : direction.get3DDataValue()] = iClamp;
            return true;
        }
        return false;
    }

    @Override // mctech.blocks.base.a.a.a, mctech.api.network.buffer.INetworkDataBuffer
    public void write(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (int i = 0; i < 7; i++) {
            registryFriendlyByteBuf.writeByte((byte) this.f[i]);
        }
    }

    @Override // mctech.blocks.base.a.a.a, mctech.api.network.buffer.INetworkDataBuffer
    public void read(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        for (int i = 0; i < 7; i++) {
            this.f[i] = registryFriendlyByteBuf.readByte();
        }
    }
}
