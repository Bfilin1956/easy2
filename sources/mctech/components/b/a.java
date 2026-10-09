package mctech.components.b;

import java.util.Set;
import mctech.api.features.IAreaOfEffect;
import mctech.components.a.K;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/a.class */
public class a extends mctech.m.d.a.a {
    BlockEntity a;
    IAreaOfEffect b;
    private final int c;
    private final int d;

    public <T extends BlockEntity & IAreaOfEffect> a(T t) {
        this(t, 96, 77);
    }

    public <T extends BlockEntity & IAreaOfEffect> a(T t, int i, int i2) {
        super(mctech.utils.math.geometry.b.a);
        this.a = t;
        this.b = t;
        this.c = i;
        this.d = i2;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        bVar.addRenderableWidget(new K(bVar.getGuiLeft() + this.c, bVar.getGuiTop() + this.d, 52, 10, bVar.h(), mctech.utils.math.geometry.b.a, button -> {
            a();
        }));
    }

    @OnlyIn(Dist.CLIENT)
    public void a() {
        if (this.b.getVisualizationId() != -1) {
            this.b.setVisualizationId(-1);
        } else {
            this.b.setVisualizationId(this.a.getLevel().getRandom().nextInt());
            mctech.v.j.a.a.a.a(this.a.getBlockPos(), 500, this.b.getAreaOfEffectColor(), true, c0050a -> {
                c0050a.d = this.b.getAreaOfEffect();
                if (c0050a.a == 1) {
                    this.b.setVisualizationId(-1);
                }
                return (this.b.getVisualizationId() == -1 || this.a.isRemoved()) ? false : true;
            });
        }
    }
}
