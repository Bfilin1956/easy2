package mctech.components.a;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import mctech.api.blocks.IMultiblock;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/H.class */
public class H extends M<H> {
    private boolean a;
    private final mctech.components.b.l b;
    private final mctech.components.w<?> c;

    public H(mctech.m.e.e eVar, @NotNull InterfaceC0102o interfaceC0102o) {
        this(eVar, 1, 31, interfaceC0102o);
    }

    public H(mctech.m.e.e eVar, int i, int i2, @NotNull InterfaceC0102o interfaceC0102o) {
        this(eVar, i, i2, new Vec2i(-1, 0), interfaceC0102o);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public H(mctech.m.e.e eVar, int i, int i2, Vec2i vec2i, @NotNull InterfaceC0102o interfaceC0102o) {
        super(i, i2, C0101n.a.d, C0101n.a.e, interfaceC0102o);
        ArrayList arrayList = new ArrayList();
        if (eVar instanceof mctech.p.b.b) {
            mctech.p.b.b bVar = (mctech.p.b.b) eVar;
            BlockPos blockPosE = bVar.e();
            for (int i3 = 0; i3 < bVar.g().getX(); i3++) {
                for (int i4 = 0; i4 < bVar.g().getY(); i4++) {
                    for (int i5 = 0; i5 < bVar.g().getZ(); i5++) {
                        arrayList.add(blockPosE.offset(i3, i4, i5));
                    }
                }
            }
        } else if (eVar instanceof IMultiblock) {
            Objects.requireNonNull(arrayList);
            ((IMultiblock) eVar).forStructureBlocks((v1) -> {
                r1.add(v1);
            });
        } else {
            arrayList.add(((BlockEntity) eVar).getBlockPos());
        }
        this.c = new mctech.components.w<>(eVar, (-108) + vec2i.getX(), vec2i.getY() + 37, 94, 94, arrayList);
        this.c.g(50);
        this.c.a_(false);
        this.b = new mctech.components.b.l(eVar, vec2i, Vec2i.EMPTY, this.c);
        d("gui.mctech.inventory.button");
    }

    @Override // mctech.components.a.R, mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        super.a(set);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        super.a(bVar);
        if (bVar instanceof mctech.m.d.a) {
            mctech.m.d.a aVar = (mctech.m.d.a) bVar;
            aVar.a(this.b);
            aVar.a(this.c);
        }
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public boolean b_(int i) {
        if (this.a && i == 256) {
            this.a = false;
        }
        return super.b_(i);
    }

    @Override // mctech.components.a.R
    @OnlyIn(Dist.CLIENT)
    public void Z_() {
        super.Z_();
        this.q.b();
        if (this.a) {
            this.b.c(this.q);
            this.c.a_(false);
            this.a = false;
        } else {
            this.b.a_(true);
            this.c.a_(true);
            this.b.b(this.q);
            this.a = true;
        }
    }
}
