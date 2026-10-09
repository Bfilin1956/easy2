package mctech.blocks.base.a.a;

import java.util.List;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.items.e.j;
import mctech.m.a.h;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/e.class */
public class e implements INetworkDataBuffer, h {
    static final b a = new b(f.f);
    c b;
    Direction c;
    List<b> d = mctech.utils.a.b.i();
    int e;
    byte f;

    public e(c cVar, Direction direction) {
        this.b = cVar;
        this.c = direction;
    }

    public void a(b bVar) {
        this.d.add(bVar);
        bVar.h = this.c;
        bVar.a();
        a();
    }

    public void a(int i) {
        b bVarRemove;
        if (i >= 0 && i < this.d.size() && (bVarRemove = this.d.remove(i)) != null) {
            bVarRemove.b();
            a();
        }
    }

    public boolean a() {
        if (this.d.isEmpty()) {
            boolean z = this.e > 0;
            this.e = 0;
            return z;
        }
        long j = this.e;
        if (this.f == 0) {
            this.e = 15;
            int size = this.d.size();
            for (int i = 0; i < size; i++) {
                this.e = Math.min(this.e, this.d.get(i).f());
            }
        } else if (this.f == 1) {
            this.e = 0;
            int size2 = this.d.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.e = Math.max(this.e, this.d.get(i2).f());
            }
        } else if (this.f == 2) {
            this.e = 0;
            int size3 = this.d.size();
            for (int i3 = 0; i3 < size3; i3++) {
                this.e += this.d.get(i3).f();
            }
            this.e /= this.d.size();
        }
        return j != ((long) this.e);
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.d.size();
    }

    public b b(int i) {
        return this.d.isEmpty() ? a : this.d.get(i);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeByte(this.f);
        if (this.d.isEmpty()) {
            registryFriendlyByteBuf.writeByte(0);
            return;
        }
        registryFriendlyByteBuf.writeByte(this.d.size());
        for (b bVar : this.d) {
            registryFriendlyByteBuf.writeUtf(bVar.d.b());
            registryFriendlyByteBuf.writeByte((byte) (((bVar.g() & 15) << 4) | (bVar.f() & 15)));
            registryFriendlyByteBuf.writeByte(bVar.e());
        }
        registryFriendlyByteBuf.writeByte(this.e);
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        this.f = registryFriendlyByteBuf.readByte();
        this.d.clear();
        this.e = 0;
        byte b = registryFriendlyByteBuf.readByte();
        if (b > 0) {
            for (int i = 0; i < b; i++) {
                String utf = registryFriendlyByteBuf.readUtf();
                byte b2 = registryFriendlyByteBuf.readByte();
                byte b3 = registryFriendlyByteBuf.readByte();
                a aVar = this.b.a.get(utf);
                if (aVar != null) {
                    b bVar = new b(aVar);
                    this.d.add(bVar);
                    bVar.h = this.c;
                    bVar.e = (b2 >> 4) & 15;
                    bVar.f = b2 & 15;
                    bVar.g = b3;
                }
            }
            this.e = registryFriendlyByteBuf.readByte();
        }
    }

    @Override // mctech.m.a.h
    public Tag c(HolderLookup.Provider provider, CompoundTag compoundTag) {
        mctech.utils.c.e.a(compoundTag, "max", (int) this.f, 0);
        ListTag listTag = new ListTag();
        int size = this.d.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.d.get(i);
            CompoundTag compoundTag2 = new CompoundTag();
            compoundTag2.putString(mctech.g.a.a.b.a, bVar.d.b());
            compoundTag2.putByte(j.a, (byte) bVar.g);
            listTag.add(compoundTag2);
        }
        mctech.utils.c.e.a(compoundTag, "data", listTag);
        return compoundTag;
    }

    @Override // mctech.m.a.h
    public void b(HolderLookup.Provider provider, CompoundTag compoundTag) {
        this.f = compoundTag.getByte("max");
        for (CompoundTag compoundTag2 : mctech.utils.a.h.a(compoundTag.getList("data", 10), CompoundTag.class)) {
            String string = compoundTag2.getString(mctech.g.a.a.b.a);
            int i = compoundTag2.getInt(j.a);
            a aVar = this.b.a.get(string);
            if (aVar != null) {
                b bVar = new b(aVar);
                bVar.h = this.c;
                bVar.g = i;
                this.d.add(bVar);
                bVar.a();
            }
        }
    }

    public int d() {
        return this.f;
    }

    public void e() {
        byte b = (byte) (this.f + 1);
        this.f = b;
        this.f = (byte) (b % 3);
        a();
    }
}
