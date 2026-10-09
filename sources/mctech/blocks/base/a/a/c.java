package mctech.blocks.base.a.a;

import it.unimi.dsi.fastutil.objects.ObjectList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.m.a.h;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/c.class */
public class c implements INetworkDataBuffer, h {
    Map<String, a> a = mctech.utils.a.b.e();
    List<a> b = mctech.utils.a.b.i();
    List<a> c = mctech.utils.a.b.i();
    e[] d = {new e(this, Direction.DOWN), new e(this, Direction.UP), new e(this, Direction.NORTH), new e(this, Direction.SOUTH), new e(this, Direction.WEST), new e(this, Direction.EAST), new e(this, null)};
    boolean e = false;
    boolean f = true;
    BlockEntity g;

    public c(BlockEntity blockEntity) {
        this.g = blockEntity;
    }

    public void a(a aVar) {
        if (this.a.putIfAbsent(aVar.b(), aVar) != null) {
            return;
        }
        this.b.add(aVar);
        aVar.a(this);
    }

    public boolean a(boolean z) {
        if (!z && c(10)) {
            return false;
        }
        List<a> list = this.e ? this.b : this.c;
        if (list.isEmpty()) {
            return false;
        }
        long gameTime = this.g.getLevel().getGameTime();
        boolean z2 = false;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i).a(gameTime, this.e)) {
                z2 = true;
            }
        }
        if (z2 || this.f) {
            boolean z3 = false;
            for (int i2 = 0; i2 < 7; i2++) {
                if (this.d[i2].a()) {
                    z3 = true;
                }
            }
            if (z3 && !this.f) {
                this.g.getLevel().updateNeighbourForOutputSignal(this.g.getBlockPos(), this.g.getBlockState().getBlock());
                return true;
            }
            return true;
        }
        return false;
    }

    public void a(int i, int i2) {
        if (i < 0 || i >= this.b.size()) {
            return;
        }
        this.d[i2].a(new b(this.b.get(i)));
        a(true);
        this.g.getLevel().updateNeighbourForOutputSignal(this.g.getBlockPos(), this.g.getBlockState().getBlock());
    }

    public void b(int i, int i2) {
        this.d[i2].a(i);
        a(true);
        this.g.getLevel().updateNeighbourForOutputSignal(this.g.getBlockPos(), this.g.getBlockState().getBlock());
    }

    public void a(int i, int i2, int i3) {
        e eVar = this.d[i2];
        if (eVar.c() <= 0) {
            return;
        }
        b bVarB = eVar.b(i);
        bVarB.g ^= 1 << i3;
        bVarB.c();
        eVar.a();
        a(true);
        this.g.getLevel().updateNeighbourForOutputSignal(this.g.getBlockPos(), this.g.getBlockState().getBlock());
    }

    public void a(int i) {
        this.d[i].e();
        a(true);
        this.g.getLevel().updateNeighbourForOutputSignal(this.g.getBlockPos(), this.g.getBlockState().getBlock());
    }

    @OnlyIn(Dist.CLIENT)
    public e b(int i) {
        return this.d[i];
    }

    public int a(Direction direction) {
        return this.d[direction == null ? 6 : direction.get3DDataValue()].b();
    }

    boolean c(int i) {
        return (this.g.getLevel().getGameTime() ^ this.g.getBlockPos().asLong()) % ((long) i) != 0;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().write(registryFriendlyByteBuf);
        }
        for (int i = 0; i < 7; i++) {
            this.d[i].write(registryFriendlyByteBuf);
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        Iterator<a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().read(registryFriendlyByteBuf);
        }
        for (int i = 0; i < 7; i++) {
            this.d[i].read(registryFriendlyByteBuf);
        }
    }

    @Override // mctech.m.a.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public CompoundTag c(HolderLookup.Provider provider, CompoundTag compoundTag) {
        ListTag listTag = new ListTag();
        for (int i = 0; i < 7; i++) {
            CompoundTag compoundTagC = this.d[i].c(provider, new CompoundTag());
            if (!compoundTagC.isEmpty()) {
                compoundTagC.putByte("slot", (byte) i);
                listTag.add(compoundTagC);
            }
        }
        mctech.utils.c.e.a(compoundTag, "comparator_data", listTag);
        return compoundTag;
    }

    @Override // mctech.m.a.h
    public void b(HolderLookup.Provider provider, CompoundTag compoundTag) {
        this.f = true;
        for (CompoundTag compoundTag2 : mctech.utils.a.h.a(compoundTag.getList("comparator_data", 10), CompoundTag.class)) {
            this.d[compoundTag2.getInt("slot")].b(provider, compoundTag2);
        }
    }

    public boolean a() {
        return this.b.size() > 0;
    }

    public int b() {
        return this.b.size();
    }

    public List<a> c() {
        ObjectList objectListI = mctech.utils.a.b.i();
        for (int i = 0; i < this.b.size(); i++) {
            a aVar = this.b.get(i);
            if (aVar.a()) {
                objectListI.add(aVar);
            }
        }
        return objectListI;
    }

    public int b(a aVar) {
        return this.b.indexOf(aVar);
    }

    public a d(int i) {
        if (i < 0 || i >= this.b.size()) {
            return null;
        }
        return this.b.get(i);
    }

    public boolean d() {
        return this.e;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public void e() {
        this.e = true;
        a(true);
        this.e = false;
        this.f = false;
    }
}
