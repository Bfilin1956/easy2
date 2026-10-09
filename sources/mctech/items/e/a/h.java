package mctech.items.e.a;

import java.util.List;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.api.items.electric.IElectricItem;
import mctech.blocks.c.G;
import mctech.init.MCTechItems;
import mctech.init.MCTechLang;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Unbreakable;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.state.BlockState;
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

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/h.class */
public class h extends mctech.items.base.e implements GeoItem {
    public final AnimatableInstanceCache b;
    protected mctech.h.a.e.b c;

    public h(Item.Properties properties, mctech.h.a.e.b bVar) {
        super(properties.component(DataComponents.TOOL, new Tool(List.of(Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_PICKAXE, bVar.e), Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_SHOVEL, bVar.e), Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_HOE, bVar.e), Tool.Rule.minesAndDrops(BlockTags.MINEABLE_WITH_AXE, bVar.e)), 1.0f, 1)).component(DataComponents.UNBREAKABLE, new Unbreakable(false)), bVar.e);
        this.b = GeckoLibUtil.createInstanceCache(this);
        GeckoLibUtil.SYNCED_ANIMATABLES.put(h.class.getName(), this);
        this.c = bVar;
        this.capacity = bVar.a;
        this.transferLimit = bVar.b;
        this.tier = 3;
    }

    @Override // mctech.items.base.e
    public float getDestroySpeed(@NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        if (blockState.hasProperty(G.d) && ((Boolean) blockState.getOptionalValue(G.d).orElse(false)).booleanValue()) {
            return 0.0f;
        }
        return super.getDestroySpeed(itemStack, blockState);
    }

    @Override // mctech.items.base.MCTechElectricItem
    public int getEnergyCost(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) {
            return 0;
        }
        return this.c.c;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }

    @NotNull
    public InteractionResult onItemUseFirst(@NotNull ItemStack itemStack, @NotNull UseOnContext useOnContext) {
        return MCTech.KEYBOARD.d(useOnContext.getPlayer()) ? InteractionResult.PASS : super.onItemUseFirst(itemStack, useOnContext);
    }

    @NotNull
    public InteractionResult useOn(@NotNull UseOnContext useOnContext) {
        return InteractionResult.SUCCESS;
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.a(mctech.g.d.e.h.a(MCTechLang.TOOLTIP_DESTROYER_CONSUMPTION, Integer.valueOf(getEnergyCost(itemStack))));
    }

    public boolean onEntitySwing(@NotNull ItemStack itemStack, @NotNull LivingEntity livingEntity, @NotNull InteractionHand interactionHand) {
        return true;
    }

    public void registerControllers(@NotNull AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController(this, "destroyer", 2, animationState -> {
            if (animationState.getData(DataTickets.ITEM_RENDER_PERSPECTIVE) == ItemDisplayContext.GUI) {
                return PlayState.STOP;
            }
            return PlayState.CONTINUE;
        }).triggerableAnim("idle", RawAnimation.begin().then("animation.destroyer.afk", Animation.LoopType.PLAY_ONCE)).triggerableAnim("use", RawAnimation.begin().then("animation.destroyer.lcm", Animation.LoopType.PLAY_ONCE)));
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.b;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(MCTech.REGISTRY.getGeckoItemModel(MCTechItems.DESTROYER).itemProvider());
    }
}
