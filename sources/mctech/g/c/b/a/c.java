package mctech.g.c.b.a;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mctech.g.d.a.g;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.model.data.ModelProperty;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/a/c.class */
public class c {
    public static final ModelProperty<c> a = new ModelProperty<>();
    private Direction.Axis b;
    private List<Holder<mctech.g.a.a<?, ?>>> c;
    private Map<Holder<mctech.g.a.a<?, ?>>, CompoundTag> d;
    private Map<Direction, List<Holder<mctech.g.a.a<?, ?>>>> e;
    private Map<Direction, Map<Holder<mctech.g.a.a<?, ?>>, d>> f;
    private boolean g;
    private BlockState h;
    private boolean i;

    public static c a(mctech.g.a.c cVar) {
        c cVar2 = new c();
        cVar2.b = g.a(cVar);
        cVar2.c = List.copyOf(cVar.a());
        cVar2.d = new HashMap();
        for (Holder<mctech.g.a.a<?, ?>> holder : cVar2.c) {
            CompoundTag compoundTagC = cVar.c(holder);
            if (compoundTagC != null) {
                cVar2.d.put(holder, compoundTagC.copy());
            }
        }
        cVar2.e = new HashMap();
        for (Direction direction : Direction.values()) {
            cVar2.e.put(direction, cVar.b(direction));
        }
        cVar2.f = new HashMap();
        for (Direction direction2 : Direction.values()) {
            HashMap map = new HashMap();
            for (Holder<mctech.g.a.a<?, ?>> holder2 : cVar2.c) {
                if (cVar.b(holder2, direction2).c()) {
                    map.put(holder2, d.a(cVar.c(holder2, direction2)));
                }
            }
            cVar2.f.put(direction2, map);
        }
        cVar2.g = cVar.e();
        if (cVar2.g) {
            cVar2.h = cVar.f().defaultBlockState();
            cVar2.i = cVar.g().a();
        } else {
            cVar2.h = Blocks.AIR.defaultBlockState();
            cVar2.i = false;
        }
        return cVar2;
    }

    public List<Holder<mctech.g.a.a<?, ?>>> a() {
        return this.c;
    }

    @Nullable
    public CompoundTag a(Holder<mctech.g.a.a<?, ?>> holder) {
        return this.d.get(holder);
    }

    public List<Holder<mctech.g.a.a<?, ?>>> a(Direction direction) {
        return this.e.getOrDefault(direction, List.of());
    }

    public boolean b(Direction direction) {
        return !this.f.get(direction).isEmpty();
    }

    public d a(Direction direction, Holder<mctech.g.a.a<?, ?>> holder) {
        return this.f.get(direction).get(holder);
    }

    public Direction.Axis b() {
        return this.b;
    }

    public ResourceLocation b(Holder<mctech.g.a.a<?, ?>> holder) {
        mctech.g.a.g.a aVarA = mctech.g.c.b.c.a.a(((mctech.g.a.a) holder.value()).d());
        if (aVarA != null) {
            return aVarA.a(holder, a(holder));
        }
        return ((mctech.g.a.a) holder.value()).a();
    }

    public boolean c() {
        return this.g;
    }

    public BlockState d() {
        return this.h;
    }

    public boolean e() {
        return this.i;
    }
}
