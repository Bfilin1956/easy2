package mctech.blocks.base.a.a;

import java.util.List;
import java.util.function.BooleanSupplier;
import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.core.Direction;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a.class */
public abstract class a implements INetworkDataBuffer {
    private c f;
    protected long b;
    private int g;
    String c;
    Component d;
    protected List<b> a = mctech.utils.a.b.i();
    BooleanSupplier e = null;

    protected abstract int d();

    public a(String str, Component component) {
        this.c = str;
        this.d = component;
    }

    void a(c cVar) {
        this.f = cVar;
    }

    public a a(BooleanSupplier booleanSupplier) {
        this.e = booleanSupplier;
        return this;
    }

    void a(b bVar) {
        this.a.add(bVar);
        if (this.a.size() == 1) {
            this.f.c.add(this);
        }
    }

    boolean b(b bVar) {
        if (this.a.remove(bVar)) {
            if (this.a.isEmpty()) {
                this.f.c.remove(this);
                return true;
            }
            return true;
        }
        return false;
    }

    public boolean a() {
        return this.e == null || this.e.getAsBoolean();
    }

    public final String b() {
        return this.c;
    }

    public final Component c() {
        return this.d;
    }

    public int a(Direction direction) {
        return this.g;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeByte(this.g);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.g = registryFriendlyByteBuf.readByte();
    }

    public boolean a(long j, boolean z) {
        int iClamp;
        if (this.b >= j) {
            return false;
        }
        this.b = j;
        if ((z || !this.a.isEmpty()) && (iClamp = Mth.clamp(d(), 0, 15)) != this.g) {
            this.g = iClamp;
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                this.a.get(i).c();
            }
            return true;
        }
        return false;
    }

    public static final int a(float f, float f2, int i) {
        return (int) ((f / f2) * i);
    }
}
