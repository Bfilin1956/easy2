package mctech.items;

import java.util.List;
import java.util.function.Consumer;
import mctech.MCTech;
import mctech.blockentities.c.C0070q;
import mctech.init.MCTechDataComponent;
import net.mcskill.msregistry.core.IMachineTier;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.fluids.SimpleFluidContent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/i.class */
public class i extends BlockItem implements IMachineTier, GeoItem {
    private final AnimatableInstanceCache a;
    private final MachineTier b;

    public i(mctech.blocks.c.j jVar, Item.Properties properties) {
        super(jVar, properties);
        this.a = GeckoLibUtil.createInstanceCache(this);
        this.b = jVar.machineTier();
        SingletonGeoAnimatable.registerSyncedAnimatable(this);
    }

    protected boolean updateCustomBlockEntityTag(@NotNull BlockPos blockPos, @NotNull Level level, @Nullable Player player, @NotNull ItemStack itemStack, @NotNull BlockState blockState) {
        BlockEntity blockEntity = level.getBlockEntity(blockPos);
        if (blockEntity instanceof C0070q) {
            ((C0070q) blockEntity).i().setFluid(((SimpleFluidContent) itemStack.getOrDefault(MCTechDataComponent.TANK_CONTENT, SimpleFluidContent.EMPTY)).copy());
        }
        return super.updateCustomBlockEntityTag(blockPos, level, player, itemStack, blockState);
    }

    @NotNull
    public Component getName(@NotNull ItemStack itemStack) {
        return super.getName(itemStack);
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        SimpleFluidContent simpleFluidContent = (SimpleFluidContent) itemStack.getOrDefault(MCTechDataComponent.TANK_CONTENT, SimpleFluidContent.EMPTY);
        if (!simpleFluidContent.isEmpty()) {
            list.add(Component.translatable("gui.mctech.tank.fluid", new Object[]{simpleFluidContent.copy().getHoverName(), mctech.utils.c.c.c.format(simpleFluidContent.getAmount())}));
        }
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.a;
    }

    public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
        consumer.accept(MCTech.REGISTRY.getGeckoModel(mctech.i.i.FLUID_TANK.getSerializedName()).itemProvider());
    }

    public MachineTier machineTier() {
        return this.b;
    }
}
