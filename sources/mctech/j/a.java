package mctech.j;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Optional;
import mctech.api.util.DirectionList;
import mctech.init.MCTechRenderTypes;
import mctech.v.x;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.RenderHighlightEvent;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoAnimatable;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.constant.dataticket.DataTicket;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/j/a.class */
public class a {
    public static final a a = new a();

    private a() {
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void a(PlayerInteractEvent.LeftClickBlock leftClickBlock) {
        a(leftClickBlock.getItemStack(), leftClickBlock.getLevel(), leftClickBlock.getPos());
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void a(PlayerInteractEvent.RightClickBlock rightClickBlock) {
        a(rightClickBlock.getItemStack(), rightClickBlock.getLevel(), rightClickBlock.getPos());
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void a(PlayerTickEvent.Post post) {
        if (!post.getEntity().level().isClientSide()) {
            return;
        }
        ItemStack mainHandItem = post.getEntity().getMainHandItem();
        if (!b(mainHandItem)) {
            mainHandItem = post.getEntity().getOffhandItem();
        }
        if (!b(mainHandItem)) {
            return;
        }
        a(mainHandItem).ifPresent(animatableManager -> {
            int iIntValue = ((Integer) a(animatableManager, mctech.v.g.b).orElse(0)).intValue();
            if (iIntValue > 0) {
                animatableManager.setData(mctech.v.g.b, Integer.valueOf(iIntValue - 1));
            } else {
                animatableManager.setData(mctech.v.g.a, false);
            }
        });
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void a(RenderHighlightEvent.Block block) {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer == null) {
            return;
        }
        BlockHitResult target = block.getTarget();
        if (target.getType() != HitResult.Type.BLOCK) {
            return;
        }
        BlockPos blockPos = target.getBlockPos();
        ItemStack mainHandItem = localPlayer.getMainHandItem();
        if (!b(mainHandItem)) {
            mainHandItem = localPlayer.getOffhandItem();
        }
        if (!b(mainHandItem)) {
            return;
        }
        a(mainHandItem).ifPresent(animatableManager -> {
            int iIntValue;
            if (((Boolean) a(animatableManager, mctech.v.g.a).orElse(false)).booleanValue() && (iIntValue = ((Integer) a(animatableManager, mctech.v.g.b).orElse(0)).intValue()) > 0) {
                PoseStack poseStack = block.getPoseStack();
                poseStack.pushPose();
                Vec3 position = block.getCamera().getPosition();
                poseStack.translate(-position.x(), -position.y(), -position.z());
                AABB aabb = new AABB(blockPos);
                float map = 1.0f - Mth.map(iIntValue, 0.0f, 4.0f, 0.0f, 1.0f);
                x.b(DirectionList.ALL, aabb.inflate(0.05d * ((double) map)), (mctech.utils.math.a.a(8388736, 16711935, map) & 16777215) | (((int) (map * 120.0f)) << 24), block.getMultiBufferSource().getBuffer(MCTechRenderTypes.POS_COLOR_TRANSLUCENT), poseStack);
                poseStack.popPose();
            }
        });
    }

    private void a(ItemStack itemStack, Level level, BlockPos blockPos) {
        if (!b(itemStack)) {
            return;
        }
        a(level, blockPos, 4);
        a(itemStack).ifPresent(animatableManager -> {
            animatableManager.setData(mctech.v.g.a, true);
            animatableManager.setData(mctech.v.g.b, 4);
        });
    }

    private void a(Level level, BlockPos blockPos, int i) {
        RandomSource random = level.getRandom();
        for (int i2 = 0; i2 < i; i2++) {
            double x = ((double) blockPos.getX()) + 0.5d + ((random.nextDouble() - 0.5d) * 1.2d);
            double y = ((double) blockPos.getY()) + 0.5d + ((random.nextDouble() - 0.5d) * 1.2d);
            double z = ((double) blockPos.getZ()) + 0.5d + ((random.nextDouble() - 0.5d) * 1.2d);
            double dNextDouble = (random.nextDouble() - 0.5d) * 0.1d;
            double dNextDouble2 = random.nextDouble() * 0.1d;
            double dNextDouble3 = (random.nextDouble() - 0.5d) * 0.1d;
            level.addParticle(ParticleTypes.FLAME, x, y, z, dNextDouble, dNextDouble2, dNextDouble3);
            if (random.nextFloat() < 0.3f) {
                level.addParticle(ParticleTypes.LAVA, x, y, z, dNextDouble, dNextDouble2, dNextDouble3);
            }
        }
    }

    private <D> Optional<D> a(AnimatableManager<GeoAnimatable> animatableManager, DataTicket<D> dataTicket) {
        return Optional.ofNullable(animatableManager.getData(dataTicket));
    }

    private Optional<AnimatableManager<GeoAnimatable>> a(@NotNull ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (item instanceof mctech.items.e.a.h) {
            return Optional.of(((mctech.items.e.a.h) item).getAnimatableInstanceCache().getManagerForId(GeoItem.getId(itemStack)));
        }
        Item item2 = itemStack.getItem();
        if (item2 instanceof mctech.items.e.a.g) {
            return Optional.of(((mctech.items.e.a.g) item2).getAnimatableInstanceCache().getManagerForId(GeoItem.getId(itemStack)));
        }
        return Optional.empty();
    }

    private boolean b(ItemStack itemStack) {
        Item item = itemStack.getItem();
        if (item instanceof mctech.items.e.a.h) {
            mctech.items.e.a.h hVar = (mctech.items.e.a.h) item;
            return hVar.getCharge(itemStack) > hVar.getEnergyCost(itemStack);
        }
        Item item2 = itemStack.getItem();
        if (!(item2 instanceof mctech.items.e.a.g)) {
            return false;
        }
        mctech.items.e.a.g gVar = (mctech.items.e.a.g) item2;
        return gVar.getCharge(itemStack) > gVar.getEnergyCost(itemStack);
    }
}
