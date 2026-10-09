package mctech.blocks.base.a;

import mctech.api.network.buffer.INetworkDataBuffer;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/g.class */
public class g implements INetworkDataBuffer, mctech.m.a.h {
    int a = -1;
    int b;

    public boolean a() {
        return this.a == -1;
    }

    public void a(int i) {
        this.a = i;
    }

    public boolean b(int i) {
        if (this.a <= 0) {
            return false;
        }
        this.b += this.a;
        return this.b > i;
    }

    public void c(int i) {
        this.b += i;
    }

    public int a(int i, boolean z) {
        int i2 = this.b / i;
        if (i2 > 0 && z) {
            this.b -= i2 * i;
        }
        return i2;
    }

    public int b() {
        return this.a;
    }

    public float a(float f) {
        return this.a / f;
    }

    public float a(float f, float f2) {
        return (this.a - f) / f2;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeVarInt(this.b);
        registryFriendlyByteBuf.writeVarInt(this.a);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.b = registryFriendlyByteBuf.readVarInt();
        this.a = registryFriendlyByteBuf.readVarInt();
    }

    @Override // mctech.m.a.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompoundTag c(HolderLookup.Provider provider, CompoundTag compoundTag) {
        mctech.utils.c.e.c(compoundTag, "stored", this.b, 0);
        mctech.utils.c.e.c(compoundTag, "production", this.a, 0);
        return compoundTag;
    }

    @Override // mctech.m.a.h
    public void b(HolderLookup.Provider provider, CompoundTag compoundTag) {
        this.b = compoundTag.getInt("stored");
        this.a = compoundTag.getInt("production");
    }
}
