package mctech.m.b;

import mctech.MCTech;
import mctech.api.items.IXrayUpgrade;
import mctech.api.tiles.readers.IEUStorage;
import mctech.components.a.C0093f;
import mctech.components.a.C0097j;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/aN.class */
public class aN extends P<mctech.m.f.r> {
    public aN(mctech.m.f.r rVar, Player player, int i, int i2) {
        super(rVar, player, i, i2);
        addSlot(new mctech.m.g.g(rVar, 0, 26, 17, itemStack -> {
            return itemStack.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 1, 49, 17, itemStack2 -> {
            return itemStack2.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 2, 72, 17, itemStack3 -> {
            return itemStack3.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 3, 95, 17, itemStack4 -> {
            return itemStack4.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 4, 118, 17, itemStack5 -> {
            return itemStack5.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 5, 141, 17, itemStack6 -> {
            return itemStack6.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 6, 164, 17, itemStack7 -> {
            return itemStack7.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 7, 187, 17, itemStack8 -> {
            return itemStack8.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 8, 26, 54, itemStack9 -> {
            return itemStack9.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 9, 49, 54, itemStack10 -> {
            return itemStack10.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 10, 164, 54, itemStack11 -> {
            return itemStack11.getItem() instanceof IXrayUpgrade;
        }));
        addSlot(new mctech.m.g.g(rVar, 11, 187, 54, itemStack12 -> {
            return itemStack12.getItem() instanceof IXrayUpgrade;
        }));
        addPlayerInventoryAt(player.getInventory(), 35, 90);
        final ItemStack itemStackA = rVar.a();
        addComponent(new C0097j(this, 1, 12, () -> {
            return 9;
        }));
        mctech.items.g.a.a.a item = itemStackA.getItem();
        if (item instanceof mctech.items.g.a.a.a) {
            final mctech.items.g.a.a.a aVar = item;
            addComponent(new C0093f(78, 41, new IEUStorage(this) { // from class: mctech.m.b.aN.1
                @Override // mctech.api.tiles.readers.IEUStorage
                public int getStoredEU() {
                    return aVar.getCharge(itemStackA);
                }

                @Override // mctech.api.tiles.readers.IEUStorage
                public int getMaxEU() {
                    return aVar.getCapacity(itemStackA);
                }

                @Override // mctech.api.tiles.readers.IEUStorage
                public int getTier() {
                    return aVar.getTier(itemStackA);
                }
            }, () -> {
                return 9;
            }));
        }
    }

    @Override // mctech.components.ContainerComponent
    public ResourceLocation getTexture() {
        return MCTech.loc("textures/gui/container/gui_advanced_xray_goggles.png");
    }

    @Override // mctech.components.ContainerComponent
    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
        bVar.c(1);
        bVar.c(2);
        bVar.e(218, 172);
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
}
