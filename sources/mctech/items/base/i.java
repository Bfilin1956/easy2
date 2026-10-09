package mctech.items.base;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import mctech.api.items.IItemVariant;
import net.minecraft.client.Minecraft;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/base/i.class */
public class i extends Item implements IItemVariant, mctech.utils.e.a, mctech.utils.e.b {
    static final Predicate<Entity> PREDICATE = EntitySelector.NO_SPECTATORS.and(entity -> {
        return entity != null && entity.isPickable() && ((entity instanceof LivingEntity) || (entity instanceof EnderDragonPart) || (entity instanceof EndCrystal));
    });
    public static final RandomSource RANDOM = RandomSource.create();
    Boolean foiled;
    List<mctech.utils.e.a.d> providers;

    public i(o oVar) {
        this((oVar == null ? new o() : oVar).g());
        this.providers = null;
    }

    public i(Item.Properties properties) {
        super(properties);
        this.providers = null;
    }

    public i addTooltip(mctech.utils.e.a.d dVar) {
        if (dVar == null) {
            Thread.dumpStack();
            return this;
        }
        if (this.providers == null) {
            this.providers = mctech.utils.a.b.i();
        }
        this.providers.add(dVar);
        return this;
    }

    @Override // mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        if (this.providers == null) {
            return;
        }
        BlockGetter blockGetter = Minecraft.getInstance().level;
        Iterator<mctech.utils.e.a.d> it = this.providers.iterator();
        while (it.hasNext()) {
            it.next().a(itemStack, blockGetter, dVar.e(), tooltipFlag);
        }
    }

    public boolean isFoil(@NotNull ItemStack itemStack) {
        if (this.foiled != null) {
            return this.foiled.booleanValue();
        }
        return super.isFoil(itemStack);
    }

    public static HitResult rayTrace(Level level, LivingEntity livingEntity, boolean z, double d) {
        float xRot = livingEntity.getXRot();
        float yRot = livingEntity.getYRot();
        Vec3 vec3 = new Vec3(livingEntity.getX(), livingEntity.getY() + ((double) livingEntity.getEyeHeight()), livingEntity.getZ());
        float fCos = Mth.cos(((-yRot) * 0.017453292f) - 3.1415927f);
        float fSin = Mth.sin(((-yRot) * 0.017453292f) - 3.1415927f);
        float f = -Mth.cos((-xRot) * 0.017453292f);
        return level.clip(new ClipContext(vec3, vec3.add(((double) (fSin * f)) * d, ((double) Mth.sin((-xRot) * 0.017453292f)) * d, ((double) (fCos * f)) * d), ClipContext.Block.COLLIDER, z ? ClipContext.Fluid.SOURCE_ONLY : ClipContext.Fluid.NONE, livingEntity));
    }

    public static EntityHitResult rayTraceEntities(Level level, LivingEntity livingEntity, boolean z, double d) {
        return rayTraceEntities(level, livingEntity, d);
    }

    public static EntityHitResult rayTraceEntities(Level level, LivingEntity livingEntity, double d) {
        Vec3 lookAngle = livingEntity.getLookAngle();
        Vec3 eyePosition = livingEntity.getEyePosition(1.0f);
        Vec3 vec3Add = eyePosition.add(lookAngle.x * d, lookAngle.y * d, lookAngle.z * d);
        Entity entity = null;
        Vec3 vec3 = null;
        double d2 = d;
        List entities = level.getEntities(livingEntity, livingEntity.getBoundingBox().expandTowards(lookAngle.x * d, lookAngle.y * d, lookAngle.z * d).inflate(1.0d), PREDICATE);
        for (int i = 0; i < entities.size(); i++) {
            Entity entity2 = (Entity) entities.get(i);
            Optional optionalClip = entity2.getBoundingBox().inflate(entity2.getPickRadius()).clip(eyePosition, vec3Add);
            if (optionalClip.isPresent()) {
                double dDistanceTo = eyePosition.distanceTo((Vec3) optionalClip.get());
                if (dDistanceTo < d2 && (entity2.getRootVehicle() != livingEntity.getRootVehicle() || livingEntity.canRiderInteract())) {
                    entity = entity2;
                    vec3 = (Vec3) optionalClip.get();
                    d2 = dDistanceTo;
                }
            }
        }
        if (entity != null) {
            return new EntityHitResult(entity, vec3);
        }
        return null;
    }

    public Collection<ItemStack> getVariants() {
        return Collections.singleton(new ItemStack(this));
    }
}
