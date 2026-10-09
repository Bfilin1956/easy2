package mctech.items.e.a;

import java.util.List;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.items.electric.IElectricItem;
import mctech.init.MCTechItems;
import mctech.init.MCTechLang;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Unbreakable;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.animation.Animation;
import software.bernie.geckolib.animation.AnimationController;
import software.bernie.geckolib.animation.PlayState;
import software.bernie.geckolib.animation.RawAnimation;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/c.class */
public class c extends mctech.items.base.e implements GeoItem {
    public final AnimatableInstanceCache b;
    protected mctech.h.a.e.a c;

    public c(Item.Properties properties, mctech.h.a.e.a aVar) {
        super(properties.component(DataComponents.TOOL, new Tool(List.of(Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_AXE, aVar.e), Tool.Rule.minesAndDrops(BlockTags.SWORD_EFFICIENT, aVar.e)), 1.0f, 1)).component(DataComponents.UNBREAKABLE, new Unbreakable(false)), aVar.e);
        this.b = GeckoLibUtil.createInstanceCache(this);
        GeckoLibUtil.SYNCED_ANIMATABLES.put(c.class.getName(), this);
        this.c = aVar;
        this.capacity = aVar.a;
        this.transferLimit = aVar.b;
        this.tier = 3;
    }

    @Override // mctech.items.base.MCTechElectricItem
    protected int getEnergyCost(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) {
            return 0;
        }
        return this.c.c;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.a(mctech.g.d.e.h.a(MCTechLang.TOOLTIP_CHAINSAW_CONSUMPTION, Integer.valueOf(getEnergyCost(itemStack))));
        if (this.c.d) {
            dVar.a(MCTechLang.TOOLTIP_CHAINSAW_RMB_ACTION);
        }
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, this.c.d ? "advanced_chainsaw" : "chainsaw", 2, animationState -> {
            if (animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE) == ItemDisplayContext.GUI) {
                return PlayState.STOP;
            }
            return PlayState.CONTINUE;
        }).triggerableAnim("use", RawAnimation.begin().then("animation.working", Animation.LoopType.PLAY_ONCE)));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.b;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(MCTech.REGISTRY.getGeckoItemModel(this.c.d ? MCTechItems.ADVANCED_CHAINSAW : MCTechItems.CHAINSAW).itemProvider());
    }
}
