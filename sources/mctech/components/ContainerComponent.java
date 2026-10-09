package mctech.components;

import java.util.ArrayList;
import java.util.List;
import mctech.MCTech;
import mctech.api.features.redstone.IComparable;
import mctech.m.a.d;
import mctech.m.b.AbstractC0160t;
import mctech.utils.math.geometry.Vec2i;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/ContainerComponent.class */
public abstract class ContainerComponent<T extends mctech.m.a.d> extends AbstractC0160t<T> {
    public static final Vec2i DEFAULT_OFFSET = new Vec2i();
    private List<mctech.m.d.a.a> components;
    protected boolean addedPreviewer;
    protected MenuType<ContainerComponent<T>> menuType;

    public ContainerComponent(T t, Player player, int i) {
        super(t, player, i);
        this.components = new ArrayList();
        this.addedPreviewer = false;
        this.menuType = new MenuType<>((i2, inventory) -> {
            return this;
        }, FeatureFlags.DEFAULT_FLAGS);
    }

    @NotNull
    public MenuType<?> getType() {
        return this.menuType;
    }

    @Override // mctech.m.b.AbstractC0160t
    protected void addInternalSlots(Inventory inventory) {
    }

    public Slot addSlot(Slot slot) {
        if ((slot instanceof mctech.m.g.n) && ((mctech.m.g.n) slot).ae_() == mctech.m.g.n.a.NORMAL && !this.addedPreviewer) {
            this.addedPreviewer = true;
        }
        return super.addSlot(slot);
    }

    @Override // mctech.m.b.S
    public int getInventorySize() {
        T holder = getHolder();
        if (holder instanceof mctech.m.a.g) {
            return ((mctech.m.a.g) holder).getSlotCount();
        }
        throw new IllegalStateException("Implement [getInventorySize] in [" + String.valueOf(getClass()));
    }

    @Override // mctech.m.b.S
    public int getUpgradeSlots() {
        T holder = getHolder();
        if (holder instanceof mctech.m.e.e) {
            return ((mctech.m.e.e) holder).getInventoryManager().d();
        }
        return 0;
    }

    @Override // mctech.m.b.AbstractC0160t
    public void removed(Player player) {
        T t = this.gui;
        if (t instanceof IComparable) {
            ((IComparable) t).getManager().b(false);
        }
        super.removed(player);
    }

    @OnlyIn(Dist.CLIENT)
    public void onGuiLoaded(mctech.m.d.b bVar) {
    }

    public void addComponent(mctech.m.d.a.a aVar) {
        this.components.add(0, aVar);
    }

    public List<mctech.m.d.a.a> getComponents() {
        return this.components;
    }

    public <S extends mctech.m.d.a.a> S getComponent(Class<S> cls) {
        for (mctech.m.d.a.a aVar : this.components) {
            if (cls.isInstance(aVar)) {
                return cls.cast(aVar);
            }
        }
        return null;
    }

    public Component getName() {
        Nameable holder = getHolder();
        if (!(holder instanceof Nameable)) {
            throw new RuntimeException("Container[" + String.valueOf(holder.getClass()) + "] needs to implement Nameable or override getName() in [" + String.valueOf(getClass()));
        }
        Nameable nameable = holder;
        return nameable.hasCustomName() ? nameable.getCustomName() : nameable.getName();
    }

    public void disablePreviewer() {
        this.addedPreviewer = true;
    }

    public ResourceLocation getTexture() {
        MCTech.LOGGER.error(String.format("Class %s was not override gui texture location!", getClass().getSimpleName()));
        return null;
    }

    public Vec2i getInventoryOffset() {
        return DEFAULT_OFFSET;
    }

    public Vec2i getInvButtonOffset() {
        return DEFAULT_OFFSET;
    }

    public Vec2i getPreviewOffset() {
        return getInventoryOffset();
    }

    public Vec2i getPreviewButtonOffset() {
        return getInvButtonOffset();
    }

    public Vec2i getComparatorOffset() {
        return getInventoryOffset();
    }

    public Vec2i getComparatorButtonOffset() {
        return getInvButtonOffset();
    }

    public Vec2i getSortButtonTextureOffset() {
        return Vec2i.EMPTY;
    }

    public ResourceLocation getAtlasTexture() {
        return null;
    }

    public Vec2i getFilterButtonTextureOffset() {
        return Vec2i.EMPTY;
    }

    public ResourceLocation getFilterTexture() {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/filter_helper.png");
    }

    public ResourceLocation getInfoTexture() {
        return null;
    }

    public Vec2i getFilterGuiSize() {
        return Vec2i.EMPTY;
    }

    public Vec2i getInfoGuiSize() {
        return Vec2i.EMPTY;
    }

    public Vec2i getFilterScrollOffset() {
        return Vec2i.EMPTY;
    }

    public Vec2i getFilterItemsOffset() {
        return Vec2i.EMPTY;
    }
}
