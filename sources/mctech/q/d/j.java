package mctech.q.d;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.List;
import mctech.MCTech;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/j.class */
public final class j implements CustomPacketPayload {
    public static final CustomPacketPayload.Type<j> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "send_particles"));
    public static final StreamCodec<RegistryFriendlyByteBuf, j> b = StreamCodec.ofMember((v0, v1) -> {
        v0.a(v1);
    }, j::new);
    private final List<b> c;

    public j(@NotNull List<b> list) {
        this.c = list;
    }

    public j(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        int varInt = registryFriendlyByteBuf.readVarInt();
        this.c = new ArrayList(varInt);
        for (int i = 0; i < varInt; i++) {
            this.c.add(new b((ParticleOptions) ParticleTypes.STREAM_CODEC.decode(registryFriendlyByteBuf), registryFriendlyByteBuf.readDouble(), registryFriendlyByteBuf.readDouble(), registryFriendlyByteBuf.readDouble(), registryFriendlyByteBuf.readDouble(), registryFriendlyByteBuf.readDouble(), registryFriendlyByteBuf.readDouble()));
        }
    }

    private void a(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeVarInt(this.c.size());
        for (b bVar : this.c) {
            ParticleTypes.STREAM_CODEC.encode(registryFriendlyByteBuf, bVar.a);
            registryFriendlyByteBuf.writeDouble(bVar.b);
            registryFriendlyByteBuf.writeDouble(bVar.c);
            registryFriendlyByteBuf.writeDouble(bVar.d);
            registryFriendlyByteBuf.writeDouble(bVar.e);
            registryFriendlyByteBuf.writeDouble(bVar.f);
            registryFriendlyByteBuf.writeDouble(bVar.g);
        }
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(@NotNull j jVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            for (b bVar : jVar.c) {
                iPayloadContext.player().level().addParticle(bVar.a, bVar.b, bVar.c, bVar.d, bVar.e, bVar.f, bVar.g);
            }
        });
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/j$b.class */
    public static final class b extends Record {
        private final ParticleOptions a;
        private final double b;
        private final double c;
        private final double d;
        private final double e;
        private final double f;
        private final double g;

        public b(ParticleOptions particleOptions, double d, double d2, double d3, double d4, double d5, double d6) {
            this.a = particleOptions;
            this.b = d;
            this.c = d2;
            this.d = d3;
            this.e = d4;
            this.f = d5;
            this.g = d6;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "particle;x;y;z;velocityX;velocityY;velocityZ", "FIELD:Lmctech/q/d/j$b;->a:Lnet/minecraft/core/particles/ParticleOptions;", "FIELD:Lmctech/q/d/j$b;->b:D", "FIELD:Lmctech/q/d/j$b;->c:D", "FIELD:Lmctech/q/d/j$b;->d:D", "FIELD:Lmctech/q/d/j$b;->e:D", "FIELD:Lmctech/q/d/j$b;->f:D", "FIELD:Lmctech/q/d/j$b;->g:D").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "particle;x;y;z;velocityX;velocityY;velocityZ", "FIELD:Lmctech/q/d/j$b;->a:Lnet/minecraft/core/particles/ParticleOptions;", "FIELD:Lmctech/q/d/j$b;->b:D", "FIELD:Lmctech/q/d/j$b;->c:D", "FIELD:Lmctech/q/d/j$b;->d:D", "FIELD:Lmctech/q/d/j$b;->e:D", "FIELD:Lmctech/q/d/j$b;->f:D", "FIELD:Lmctech/q/d/j$b;->g:D").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "particle;x;y;z;velocityX;velocityY;velocityZ", "FIELD:Lmctech/q/d/j$b;->a:Lnet/minecraft/core/particles/ParticleOptions;", "FIELD:Lmctech/q/d/j$b;->b:D", "FIELD:Lmctech/q/d/j$b;->c:D", "FIELD:Lmctech/q/d/j$b;->d:D", "FIELD:Lmctech/q/d/j$b;->e:D", "FIELD:Lmctech/q/d/j$b;->f:D", "FIELD:Lmctech/q/d/j$b;->g:D").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public ParticleOptions a() {
            return this.a;
        }

        public double b() {
            return this.b;
        }

        public double c() {
            return this.c;
        }

        public double d() {
            return this.d;
        }

        public double e() {
            return this.e;
        }

        public double f() {
            return this.f;
        }

        public double g() {
            return this.g;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/j$a.class */
    public static class a {
        private final List<b> a = new ArrayList();

        public a a(ParticleOptions particleOptions, double d, double d2, double d3, double d4, double d5, double d6) {
            this.a.add(new b(particleOptions, d, d2, d3, d4, d5, d6));
            return this;
        }

        public j a() {
            return new j(this.a);
        }
    }
}
