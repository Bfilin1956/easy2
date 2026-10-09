package mctech.components.b;

import java.util.Set;
import mctech.MCTech;
import net.minecraft.client.gui.components.Button;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/b.class */
public class b extends mctech.m.d.a.a {
    a a;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/b$a.class */
    public interface a {
        boolean a();

        boolean b();
    }

    public b(a aVar) {
        super(mctech.utils.math.geometry.b.a);
        this.a = aVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        int guiLeft = bVar.getGuiLeft();
        int guiTop = bVar.getGuiTop();
        bVar.a(0, new mctech.components.a.v(guiLeft + 123, guiTop + 20, 20, 20, button -> {
            a(button, 0);
        }, new ItemStack(Items.CLOCK), this.a.a()).a("gui.mctech.buffer_box.tick"));
        bVar.a(1, new mctech.components.a.v(guiLeft + 123, guiTop + 45, 20, 20, button2 -> {
            a(button2, 1);
        }, new ItemStack(Items.REDSTONE), this.a.b()).a("gui.mctech.buffer_box.notify"));
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void b(mctech.m.d.b bVar) {
        bVar.a(0, mctech.components.a.v.class).a(this.a.a());
        bVar.a(1, mctech.components.a.v.class).a(this.a.b());
    }

    @OnlyIn(Dist.CLIENT)
    public void a(Button button, int i) {
        MCTech.NETWORKING.sendClientTileEvent((BlockEntity) this.a, 1 + i, ((mctech.components.a.v) button).a() ? 0 : 1);
    }
}
