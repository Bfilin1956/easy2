package mctech.components.b;

import java.util.Set;
import java.util.function.Consumer;
import mctech.integration.emi.plugin.core.EMICompat;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/e.class */
public class e extends mctech.m.d.a.a {
    private BlockEntity a;
    private int b;

    public e(BlockEntity blockEntity, mctech.utils.math.geometry.b bVar) {
        this(blockEntity, bVar, 0);
    }

    public e(BlockEntity blockEntity, mctech.utils.math.geometry.b bVar, int i) {
        super(bVar);
        this.a = blockEntity;
        this.b = i;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
    }

    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        super.a(guiGraphics, i, i2, consumer);
        if (a(i, i2) && EMICompat.isRegistered(this.a)) {
            consumer.accept(Component.literal("Отобразить рецепты"));
        }
    }

    @Override // mctech.m.d.a.a
    public boolean a(int i, int i2, int i3) {
        return EMICompat.openRecipeCategory(this.a, this.b);
    }
}
