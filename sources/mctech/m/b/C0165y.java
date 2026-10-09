package mctech.m.b;

import dev.emi.emi.api.EmiApi;
import mctech.api.tiles.readers.IEUStorage;
import mctech.blockentities.c.C0060g;
import mctech.blockentities.i;
import mctech.components.ContainerComponent;
import mctech.components.a.C0093f;
import mctech.components.a.C0095h;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.InterfaceC0102o;
import mctech.init.MCTechRecipes;
import mctech.integration.emi.plugin.core.EMIRecipeCategory;
import mctech.m.a.k;
import mctech.u.C0189q;
import mctech.utils.math.geometry.Vec2i;
import net.mcskill.msregistry.core.IMachineTier;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.m.b.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/y.class */
public class C0165y<T extends mctech.blockentities.i & mctech.m.a.k & IEUStorage & IMachineTier> extends ContainerComponent<T> {
    /* JADX WARN: Multi-variable type inference failed */
    public C0165y(T t, Player player, int i) {
        super(t, player, i);
        addSlot(new mctech.m.g.g(t, 0, 68, 41, itemStack -> {
            return t.getLevel() != null && a(t.getLevel(), itemStack, true);
        }));
        addSlot(new mctech.m.g.g(t, 1, 160, 41, itemStack2 -> {
            return t.getLevel() != null && a(t.getLevel(), itemStack2, false);
        }));
        addSlot(mctech.m.g.g.d(t, 2, 114, 41));
        addPlayerInventoryAt(player.getInventory(), 42, 110);
        getComponents().clear();
        InterfaceC0102o interfaceC0102o = () -> {
            return ((IMachineTier) t).machineTier().ordinal();
        };
        addComponent(new C0093f(85, 78, t, interfaceC0102o));
        addComponent(new C0095h(119, 86, t, interfaceC0102o));
        addComponent(new C0097j(this, interfaceC0102o));
        addComponent(new mctech.components.a.H(t, interfaceC0102o).d("gui.mctech.inventory.button"));
        addComponent(new mctech.components.a.u(t, interfaceC0102o).a(mctech.components.a.u.a));
        addComponent(new C0096i(139, 41, new C0096i.a(this) { // from class: mctech.m.b.y.1
            @Override // mctech.components.a.C0096i.a
            public void openCategory() {
                EmiApi.displayRecipeCategory(EMIRecipeCategory.ELECTROLYZER_DISCHARGE);
            }

            @Override // mctech.components.a.C0096i.a
            public boolean a() {
                return true;
            }
        }).b().b((Component) Component.literal("Отобразить рецепты разрядки")).a(90.0f));
        addComponent(new C0096i(92, 41, new C0096i.a(this) { // from class: mctech.m.b.y.2
            @Override // mctech.components.a.C0096i.a
            public void openCategory() {
                EmiApi.displayRecipeCategory(EMIRecipeCategory.ELECTROLYZER_CHARGE);
            }

            @Override // mctech.components.a.C0096i.a
            public boolean a() {
                return true;
            }
        }).b().b((Component) Component.literal("Отобразить рецепты зарядки")).a(-90.0f));
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, getHolder().machineTier(), getHolder() instanceof C0060g ? "electrolyzer_charged" : "electrolyzer");
    }

    public boolean a(Level level, ItemStack itemStack, boolean z) {
        return level.getRecipeManager().getRecipeFor((RecipeType) MCTechRecipes.ELECTROLYZER.get(), new C0189q.a(itemStack, 2.147483647E9d, z), level).isPresent();
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(mctech.utils.c.h.i);
        bVar.f(222);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterGuiSize() {
        return new Vec2i(122, 132);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterScrollOffset() {
        return new Vec2i(-2, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getFilterItemsOffset() {
        return new Vec2i(3, -2);
    }

    @Override // mctech.components.ContainerComponent
    public Vec2i getInfoGuiSize() {
        return new Vec2i(198, 51);
    }
}
