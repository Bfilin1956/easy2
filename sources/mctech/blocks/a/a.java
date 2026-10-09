package mctech.blocks.a;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/a/a.class */
public class a extends LiquidBlock {
    private final List<c> a;
    private final List<b> b;
    private Function<BlockState, Integer> c;

    /* JADX INFO: renamed from: mctech.blocks.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/a/a$a.class */
    @FunctionalInterface
    public interface InterfaceC0003a {
        boolean test(Level level, BlockPos blockPos);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/a/a$b.class */
    @FunctionalInterface
    public interface b {
        void apply(Level level, BlockPos blockPos, BlockState blockState, Entity entity);
    }

    public a(FlowingFluid flowingFluid, BlockBehaviour.Properties properties) {
        super(flowingFluid, properties);
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = null;
    }

    public a a(c cVar) {
        this.a.add(cVar);
        return this;
    }

    public a a(b bVar) {
        this.b.add(bVar);
        return this;
    }

    public a a(Function<BlockState, Integer> function) {
        this.c = function;
        return this;
    }

    protected void entityInside(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull Entity entity) {
        super.entityInside(blockState, level, blockPos, entity);
        Iterator<b> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().apply(level, blockPos, blockState, entity);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(@NotNull BlockState blockState, @NotNull Level level, @NotNull BlockPos blockPos, @NotNull RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);
        if (level.isEmptyBlock(blockPos.above())) {
            double dClamp = Mth.clamp(((double) blockPos.getX()) + randomSource.nextDouble(), blockPos.getX(), blockPos.getX() + 1);
            double dClamp2 = Mth.clamp(((double) blockPos.getZ()) + randomSource.nextDouble(), blockPos.getZ(), blockPos.getZ() + 1);
            double dNextDouble = randomSource.nextDouble() * 0.1d;
            for (c cVar : this.a) {
                if (cVar.d().test(level, blockPos)) {
                    level.addParticle(cVar.a(), dClamp + cVar.b().x, ((double) blockPos.getY()) + cVar.b().y, dClamp2 + cVar.b().z, cVar.c().x, dNextDouble + cVar.c().y, cVar.c().z);
                }
            }
        }
    }

    public int getLightEmission(@NotNull BlockState blockState, @NotNull BlockGetter blockGetter, @NotNull BlockPos blockPos) {
        if (this.c != null) {
            return this.c.apply(blockState).intValue();
        }
        return super.getLightEmission(blockState, blockGetter, blockPos);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/a/a$c.class */
    public static final class c {
        public static InterfaceC0003a a = (level, blockPos) -> {
            return true;
        };
        public static InterfaceC0003a b = (level, blockPos) -> {
            return false;
        };
        private final ParticleOptions c;
        private final Vec3 d;
        private final Vec3 e;
        private final InterfaceC0003a f;

        public c(ParticleOptions particleOptions, Vec3 vec3, Vec3 vec4, InterfaceC0003a interfaceC0003a) {
            this.c = particleOptions;
            this.d = vec3;
            this.e = vec4;
            this.f = interfaceC0003a;
        }

        public c(ParticleOptions particleOptions, InterfaceC0003a interfaceC0003a) {
            this(particleOptions, Vec3.ZERO, Vec3.ZERO, interfaceC0003a);
        }

        public c(ParticleOptions particleOptions, Vec3 vec3, InterfaceC0003a interfaceC0003a) {
            this(particleOptions, vec3, Vec3.ZERO, interfaceC0003a);
        }

        public c(ParticleOptions particleOptions, Vec3 vec3) {
            this(particleOptions, vec3, Vec3.ZERO, a);
        }

        public c(ParticleOptions particleOptions, Vec3 vec3, Vec3 vec4) {
            this(particleOptions, vec3, vec4, a);
        }

        public ParticleOptions a() {
            return this.c;
        }

        public Vec3 b() {
            return this.d;
        }

        public Vec3 c() {
            return this.e;
        }

        public InterfaceC0003a d() {
            return this.f;
        }
    }

    public static a a(FlowingFluid flowingFluid) {
        return new a(flowingFluid, BlockBehaviour.Properties.ofFullCopy(Blocks.WATER)).a(new c((ParticleOptions) ParticleTypes.SMOKE, Vec3.ZERO.add(0.5d, 0.0d, 0.5d))).a(new c((ParticleOptions) ParticleTypes.WHITE_SMOKE, Vec3.ZERO.add(0.5d, 0.0d, 0.5d))).a(new c((ParticleOptions) ParticleTypes.SMALL_FLAME, Vec3.ZERO.add(0.5d, 0.0d, 0.5d), (level, blockPos) -> {
            return !level.isRaining();
        })).a(new c((ParticleOptions) ParticleTypes.FLAME, Vec3.ZERO.add(0.5d, 0.0d, 0.5d), (level2, blockPos2) -> {
            return !level2.isRaining();
        })).a((level3, blockPos3, blockState, entity) -> {
            if (!entity.fireImmune()) {
                entity.igniteForSeconds(5.0f);
                if (entity.hurt(entity.damageSources().lava(), 4.0f)) {
                    entity.playSound(SoundEvents.GENERIC_BURN, 0.4f, 0.2f + (level3.random.nextFloat() * 0.4f));
                }
            }
        }).a(blockState2 -> {
            return Integer.valueOf((int) Mth.map(((Integer) blockState2.getValue(LEVEL)).intValue(), 0.0f, 8.0f, 15.0f, 0.0f));
        });
    }
}
