package mctech.m.b;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import mctech.MCTech;
import mctech.components.AbstractC0111e;
import mctech.components.C0109c;
import mctech.components.a.C0089b;
import mctech.components.a.C0093f;
import mctech.components.a.C0097j;
import mctech.m.g.C0167a;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.apache.commons.lang3.BooleanUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.m.b.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/e.class */
public class C0145e extends AbstractC0111e<mctech.blockentities.c.Q> {
    public C0145e(mctech.blockentities.c.Q q, Player player, int i) {
        super(q, player, i);
        int iB = this.a.b();
        aG aGVarA = a();
        int iG = aGVarA.g();
        int iC = aGVarA.c();
        int iC2 = aGVarA.c() / 2;
        int i2 = (93 - (iG * (iB / 2))) + iC2;
        q.getLevel();
        for (int i3 = 0; i3 < iB; i3++) {
            addSlot(new mctech.m.g.g(q, i3, i2, 26, itemStack -> {
                return true;
            }));
            addSlot(new mctech.m.g.B(q, iB + i3, i2, 69));
            i2 += iG;
        }
        List<Integer> listB = q.inventoryManager.b(mctech.m.e.k.c);
        for (int i4 = 0; i4 < listB.size(); i4++) {
            addSlot(new C0167a(q, listB.get(i4).intValue(), 189 + iC, 17 + (i4 * 17)).a((ResourceLocation) null));
        }
        addPlayerInventoryWithOffset(player.getInventory(), 13 + iC2, 31 + aGVarA.d());
        getComponents().clear();
        int i5 = (93 - (iG * (iB / 2))) + iC2;
        for (int i6 = 0; i6 < iB; i6++) {
            addComponent(new C0109c(q, i6, new mctech.utils.math.geometry.b(i5 - 2, 47, 16, 19), new Vec2i(aGVarA.e().getX(), aGVarA.e().getY() + 4), true));
            i5 += iG;
        }
        addComponent(new C0093f(aGVarA.h().getX() - 1, aGVarA.h().getY() - 1, q, b().e()).a(false).b(() -> {
            return new Vec2i(aGVarA.f() + 2, 5);
        }));
        Objects.requireNonNull(q);
        addComponent(new C0089b(3, 57, q::isAutoSort).a(p -> {
            MCTech.NETWORKING.sendClientTileEvent(q, 4095, BooleanUtils.toInteger(!q.isAutoSort()));
        }).b((Component) Component.literal("Авто-распределение: ").append(Component.literal("вкл").withStyle(ChatFormatting.GREEN))).a((Component) Component.literal("Авто-распределение: ").append(Component.literal("выкл").withStyle(ChatFormatting.RED))));
        addComponent(new mctech.components.a.u(q, 3, 17, b().e()).a(EnumSet.allOf(mctech.components.a.u.a.class)).a(() -> {
            return Integer.valueOf(this.a == mctech.i.a.SINGULAR ? 190 : 160);
        }).d("gui.mctech.info.button").c(false));
        addComponent(new C0097j(this, 3, 28, this.a.e()).d("gui.mctech.filter.button").c(false));
        addComponent(new mctech.components.a.H(q, 3, 39, this.a.e()).d("gui.mctech.inventory.button").c(false));
    }

    @Override // mctech.components.AbstractC0111e, mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return mctech.m.a.a(this, b().a(), "recycler");
    }

    @Override // mctech.components.AbstractC0111e
    @NotNull
    protected aG a() {
        switch (this.a) {
            case NANO:
            case QUANTUM:
                return new aG(208, 197, 24, 0, 0, new Vec2i(13, 198), 86, new Vec2i(58, 94), new Vec2i(101, 99));
            case SINGULAR:
                return new aG(254, 197, 23, 46, 0, new Vec2i(36, 198), 151, new Vec2i(52, 93), new Vec2i(44, 91));
            default:
                throw new IllegalStateException();
        }
    }
}
