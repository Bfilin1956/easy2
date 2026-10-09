package mctech.c;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.network.codec.NeoForgeStreamCodecs;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/d.class */
public class d {
    public static final StreamCodec<RegistryFriendlyByteBuf, Vec3> a = StreamCodec.composite(ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.x();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.y();
    }, ByteBufCodecs.DOUBLE, (v0) -> {
        return v0.z();
    }, (v1, v2, v3) -> {
        return new Vec3(v1, v2, v3);
    });

    public static void a(b bVar, IPayloadContext iPayloadContext) {
        bVar.c.unwrapKey().ifPresent(resourceKey -> {
            MCTech.AUDIO.a(new mctech.c.a.e(iPayloadContext.player().level(), bVar.g), DeferredHolder.create(BuiltInRegistries.SOUND_EVENT.key(), resourceKey.location()), bVar.d, bVar.e, bVar.f);
        });
    }

    public static void a(a aVar, IPayloadContext iPayloadContext) {
        Entity entity = iPayloadContext.player().level().getEntity(aVar.g);
        if (entity == null) {
            return;
        }
        aVar.c.unwrapKey().ifPresent(resourceKey -> {
            MCTech.AUDIO.a(entity, DeferredHolder.create(BuiltInRegistries.SOUND_EVENT.key(), resourceKey.location()), aVar.d, aVar.e, aVar.f);
        });
    }

    public static void a(c cVar, IPayloadContext iPayloadContext) {
        BlockEntity blockEntity = iPayloadContext.player().level().getBlockEntity(cVar.g);
        if (blockEntity == null) {
            return;
        }
        cVar.c.unwrapKey().ifPresent(resourceKey -> {
            MCTech.AUDIO.a(blockEntity, DeferredHolder.create(BuiltInRegistries.SOUND_EVENT.key(), resourceKey.location()), cVar.d, cVar.e, cVar.f);
        });
    }

    public static void a(CustomPacketPayload customPacketPayload, IPayloadContext iPayloadContext) {
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/d$b.class */
    public static final class b extends Record implements CustomPacketPayload {
        private final Holder<SoundEvent> c;
        private final mctech.c.b.a d;
        private final float e;
        private final float f;
        private final Vec3 g;
        public static final CustomPacketPayload.Type<b> a = new CustomPacketPayload.Type<>(MCTech.loc("sound_simple_payload"));
        public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(SoundEvent.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, NeoForgeStreamCodecs.enumCodec(mctech.c.b.a.class), (v0) -> {
            return v0.b();
        }, ByteBufCodecs.FLOAT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.FLOAT, (v0) -> {
            return v0.d();
        }, d.a, (v0) -> {
            return v0.e();
        }, (v1, v2, v3, v4, v5) -> {
            return new b(v1, v2, v3, v4, v5);
        });

        public b(Holder<SoundEvent> holder, mctech.c.b.a aVar, float f, float f2, Vec3 vec3) {
            this.c = holder;
            this.d = aVar;
            this.e = f;
            this.f = f2;
            this.g = vec3;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "soundEvent;soundType;volume;pitch;position", "FIELD:Lmctech/c/d$b;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$b;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$b;->e:F", "FIELD:Lmctech/c/d$b;->f:F", "FIELD:Lmctech/c/d$b;->g:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "soundEvent;soundType;volume;pitch;position", "FIELD:Lmctech/c/d$b;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$b;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$b;->e:F", "FIELD:Lmctech/c/d$b;->f:F", "FIELD:Lmctech/c/d$b;->g:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "soundEvent;soundType;volume;pitch;position", "FIELD:Lmctech/c/d$b;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$b;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$b;->e:F", "FIELD:Lmctech/c/d$b;->f:F", "FIELD:Lmctech/c/d$b;->g:Lnet/minecraft/world/phys/Vec3;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Holder<SoundEvent> a() {
            return this.c;
        }

        public mctech.c.b.a b() {
            return this.d;
        }

        public float c() {
            return this.e;
        }

        public float d() {
            return this.f;
        }

        public Vec3 e() {
            return this.g;
        }

        @NotNull
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/d$a.class */
    public static final class a extends Record implements CustomPacketPayload {
        private final Holder<SoundEvent> c;
        private final mctech.c.b.a d;
        private final float e;
        private final float f;
        private final int g;
        public static final CustomPacketPayload.Type<a> a = new CustomPacketPayload.Type<>(MCTech.loc("sound_entity_payload"));
        public static final StreamCodec<RegistryFriendlyByteBuf, a> b = StreamCodec.composite(SoundEvent.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, NeoForgeStreamCodecs.enumCodec(mctech.c.b.a.class), (v0) -> {
            return v0.b();
        }, ByteBufCodecs.FLOAT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.FLOAT, (v0) -> {
            return v0.d();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.e();
        }, (v1, v2, v3, v4, v5) -> {
            return new a(v1, v2, v3, v4, v5);
        });

        public a(Holder<SoundEvent> holder, mctech.c.b.a aVar, float f, float f2, int i) {
            this.c = holder;
            this.d = aVar;
            this.e = f;
            this.f = f2;
            this.g = i;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "soundEvent;soundType;volume;pitch;id", "FIELD:Lmctech/c/d$a;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$a;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$a;->e:F", "FIELD:Lmctech/c/d$a;->f:F", "FIELD:Lmctech/c/d$a;->g:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "soundEvent;soundType;volume;pitch;id", "FIELD:Lmctech/c/d$a;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$a;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$a;->e:F", "FIELD:Lmctech/c/d$a;->f:F", "FIELD:Lmctech/c/d$a;->g:I").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "soundEvent;soundType;volume;pitch;id", "FIELD:Lmctech/c/d$a;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$a;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$a;->e:F", "FIELD:Lmctech/c/d$a;->f:F", "FIELD:Lmctech/c/d$a;->g:I").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Holder<SoundEvent> a() {
            return this.c;
        }

        public mctech.c.b.a b() {
            return this.d;
        }

        public float c() {
            return this.e;
        }

        public float d() {
            return this.f;
        }

        public int e() {
            return this.g;
        }

        @NotNull
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/d$c.class */
    public static final class c extends Record implements CustomPacketPayload {
        private final Holder<SoundEvent> c;
        private final mctech.c.b.a d;
        private final float e;
        private final float f;
        private final BlockPos g;
        public static final CustomPacketPayload.Type<c> a = new CustomPacketPayload.Type<>(MCTech.loc("sound_tile_payload"));
        public static final StreamCodec<RegistryFriendlyByteBuf, c> b = StreamCodec.composite(SoundEvent.STREAM_CODEC, (v0) -> {
            return v0.a();
        }, NeoForgeStreamCodecs.enumCodec(mctech.c.b.a.class), (v0) -> {
            return v0.b();
        }, ByteBufCodecs.FLOAT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.FLOAT, (v0) -> {
            return v0.d();
        }, BlockPos.STREAM_CODEC, (v0) -> {
            return v0.e();
        }, (v1, v2, v3, v4, v5) -> {
            return new c(v1, v2, v3, v4, v5);
        });

        public c(Holder<SoundEvent> holder, mctech.c.b.a aVar, float f, float f2, BlockPos blockPos) {
            this.c = holder;
            this.d = aVar;
            this.e = f;
            this.f = f2;
            this.g = blockPos;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "soundEvent;soundType;volume;pitch;pos", "FIELD:Lmctech/c/d$c;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$c;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$c;->e:F", "FIELD:Lmctech/c/d$c;->f:F", "FIELD:Lmctech/c/d$c;->g:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "soundEvent;soundType;volume;pitch;pos", "FIELD:Lmctech/c/d$c;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$c;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$c;->e:F", "FIELD:Lmctech/c/d$c;->f:F", "FIELD:Lmctech/c/d$c;->g:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "soundEvent;soundType;volume;pitch;pos", "FIELD:Lmctech/c/d$c;->c:Lnet/minecraft/core/Holder;", "FIELD:Lmctech/c/d$c;->d:Lmctech/c/b$a;", "FIELD:Lmctech/c/d$c;->e:F", "FIELD:Lmctech/c/d$c;->f:F", "FIELD:Lmctech/c/d$c;->g:Lnet/minecraft/core/BlockPos;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public Holder<SoundEvent> a() {
            return this.c;
        }

        public mctech.c.b.a b() {
            return this.d;
        }

        public float c() {
            return this.e;
        }

        public float d() {
            return this.f;
        }

        public BlockPos e() {
            return this.g;
        }

        @NotNull
        public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
            return a;
        }
    }
}
