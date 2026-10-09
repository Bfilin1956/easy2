package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.MCTech;
import mctech.blockentities.c.C0056c;
import mctech.components.AbstractC0111e;
import mctech.components.a.C0089b;
import mctech.components.a.C0093f;
import mctech.components.a.C0096i;
import mctech.components.a.C0097j;
import mctech.components.a.C0099l;
import mctech.init.MCTechRecipes;
import mctech.integration.emi.plugin.core.EMIPlugin;
import mctech.m.g.C0167a;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.apache.commons.lang3.BooleanUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.m.b.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/f.class */
public class C0146f extends AbstractC0111e<C0056c> {
    public C0146f(final C0056c c0056c, Player player, int i) {
        super(c0056c, player, i);
        int iB = this.a.b();
        aG aGVarA = a();
        int iG = aGVarA.g();
        int iC = aGVarA.c();
        int iC2 = aGVarA.c() / 2;
        int i2 = (93 - (iG * (iB / 2))) + iC2;
        Level level = c0056c.getLevel();
        int i3 = this.a == mctech.i.a.NANO ? i2 + 1 : i2;
        for (int i4 = 0; i4 < iB; i4++) {
            addSlot(new mctech.m.g.g(c0056c, i4, i2, 92, itemStack -> {
                return level.getRecipeManager().getAllRecipesFor((RecipeType) MCTechRecipes.REFINERY.get()).stream().anyMatch(recipeHolder -> {
                    return ((mctech.u.W) recipeHolder.value()).d().test(itemStack);
                });
            }));
            addSlot(new mctech.m.g.B(c0056c, iB + i4, i2, 135));
            i2 += iG;
        }
        List<Integer> listB = c0056c.f.b(mctech.m.e.k.c);
        for (int i5 = 0; i5 < listB.size(); i5++) {
            addSlot(new C0167a(c0056c, listB.get(i5).intValue(), 189 + iC, 17 + (i5 * 17)).a((ResourceLocation) null));
        }
        addPlayerInventoryWithOffset(player.getInventory(), 13 + iC2, 97 + aGVarA.d());
        getComponents().clear();
        int i6 = (93 - (iG * (iB / 2))) + iC2;
        for (int i7 = 0; i7 < iB; i7++) {
            int i8 = i7;
            int i9 = i6 + (this.a == mctech.i.a.NANO ? 2 : 1);
            addComponent(new mctech.components.a.N(i9, 113, () -> {
                return Integer.valueOf((int) c0056c.getProgressSlot(i8));
            }, () -> {
                return Integer.valueOf((int) c0056c.getMaxProgressSlot(i8));
            }, b().e()));
            addComponent(new C0096i(i9, 113, new C0096i.a(this) { // from class: mctech.m.b.f.1
                @Override // mctech.components.a.C0096i.a
                public void openCategory() {
                    EMIPlugin.showTypes(c0056c);
                }

                @Override // mctech.components.a.C0096i.a
                public boolean a() {
                    return true;
                }
            }));
            i6 += iG;
        }
        addComponent(new C0093f(aGVarA.h().getX() - 1, aGVarA.h().getY() - 1, c0056c, b().e()).a(false).b(() -> {
            return new Vec2i(aGVarA.f() + 2, 5);
        }));
        Objects.requireNonNull(c0056c);
        addComponent(new C0089b(3, 57, c0056c::isAutoSort).a(p -> {
            MCTech.NETWORKING.sendClientTileEvent(c0056c, 4095, BooleanUtils.toInteger(!c0056c.isAutoSort()));
        }).b((Component) Component.literal("Авто-распределение: ").append(Component.literal("вкл").withStyle(ChatFormatting.GREEN))).a((Component) Component.literal("Авто-распределение: ").append(Component.literal("выкл").withStyle(ChatFormatting.RED))));
        addComponent(new mctech.components.a.u(c0056c, 3, 17, b().e()).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return Integer.valueOf(this.a == mctech.i.a.SINGULAR ? 190 : 160);
        }).d("gui.mctech.info.button").c(false));
        addComponent(new C0097j(this, 3, 28, this.a.e()).d("gui.mctech.filter.button").c(false));
        addComponent(new mctech.components.a.H(c0056c, 3, 39, this.a.e()).d("gui.mctech.inventory.button").c(false));
        int i10 = 23 + (this.a == mctech.i.a.SINGULAR ? 7 : 0) + 15;
        addComponent(new C0099l(c0056c, i10, 24, 0, c0056c.a, this.a.e()).a((Component) Component.literal("Первичный бак:")).a());
        int i11 = i10 + 28;
        addComponent(new C0099l(c0056c, i11, 24, 1, c0056c.b, this.a.e()).a((Component) Component.literal("Вторичный бак:")).a());
        addComponent(new C0099l(c0056c, i11 + 80 + (this.a == mctech.i.a.SINGULAR ? 32 : 0), 24, 2, c0056c.c, this.a.e()).a((Component) Component.literal("Выходной бак:")).a());
    }

    @Override // mctech.components.AbstractC0111e, mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, b().a(), "refinery");
    }

    @Override // mctech.components.AbstractC0111e
    @NotNull
    protected aG a() {
        switch (this.a) {
            case NANO:
            case QUANTUM:
                return new aG(208, 263, 24, 0, 0, new Vec2i(13, 264), 86, new Vec2i(58, 160), new Vec2i(101, 165));
            case SINGULAR:
                return new aG(254, 266, 23, 46, 3, new Vec2i(36, 267), 158, new Vec2i(45, 160), new Vec2i(131, 165));
            default:
                throw new IllegalStateException();
        }
    }

    @Override // mctech.o.f
    @OnlyIn(Dist.CLIENT)
    public int c() {
        return 300;
    }

    @Override // mctech.o.f
    @OnlyIn(Dist.CLIENT)
    public int d() {
        return 300;
    }
}
