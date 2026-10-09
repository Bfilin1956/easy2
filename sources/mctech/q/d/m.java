package mctech.q.d;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import mctech.MCTech;
import mctech.blockentities.p;
import mctech.m.b.AbstractC0160t;
import mctech.m.b.C0150j;
import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/q/d/m.class */
public final class m extends Record implements CustomPacketPayload {
    private final BlockPos c;
    private final String d;
    private final String e;
    public static final CustomPacketPayload.Type<m> a = new CustomPacketPayload.Type<>(ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "teleport_setup"));
    public static final StreamCodec<RegistryFriendlyByteBuf, m> b = StreamCodec.composite(BlockPos.STREAM_CODEC, (v0) -> {
        return v0.a();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.b();
    }, ByteBufCodecs.STRING_UTF8, (v0) -> {
        return v0.c();
    }, m::new);

    public m(BlockPos blockPos, String str, String str2) {
        this.c = blockPos;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, m.class), m.class, "tilePosition;networkName;teleportName", "FIELD:Lmctech/q/d/m;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/m;->d:Ljava/lang/String;", "FIELD:Lmctech/q/d/m;->e:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, m.class), m.class, "tilePosition;networkName;teleportName", "FIELD:Lmctech/q/d/m;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/m;->d:Ljava/lang/String;", "FIELD:Lmctech/q/d/m;->e:Ljava/lang/String;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, m.class, Object.class), m.class, "tilePosition;networkName;teleportName", "FIELD:Lmctech/q/d/m;->c:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/q/d/m;->d:Ljava/lang/String;", "FIELD:Lmctech/q/d/m;->e:Ljava/lang/String;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public BlockPos a() {
        return this.c;
    }

    public String b() {
        return this.d;
    }

    public String c() {
        return this.e;
    }

    @NotNull
    public CustomPacketPayload.Type<? extends CustomPacketPayload> type() {
        return a;
    }

    public static void a(@NotNull m mVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            Player player = iPayloadContext.player();
            Level level = player.level();
            if (a(level, player, mVar.a())) {
                return;
            }
            mctech.m.a.d blockEntity = level.getBlockEntity(mVar.a());
            AbstractContainerMenu abstractContainerMenu = player.containerMenu;
            if ((!(abstractContainerMenu instanceof AbstractC0160t) || ((AbstractC0160t) abstractContainerMenu).getHolder() == blockEntity || (blockEntity instanceof p)) && (blockEntity instanceof p)) {
                p pVar = (p) blockEntity;
                AbstractContainerMenu abstractContainerMenu2 = player.containerMenu;
                if (abstractContainerMenu2 instanceof C0150j) {
                    pVar.a(mVar.b());
                    pVar.b(mVar.c());
                }
            }
        });
    }

    public static void b(@NotNull m mVar, IPayloadContext iPayloadContext) {
        iPayloadContext.enqueueWork(() -> {
            ServerPlayer serverPlayerPlayer = iPayloadContext.player();
            Level level = serverPlayerPlayer.level();
            if (level.isLoaded(mVar.a())) {
                BlockEntity blockEntity = level.getBlockEntity(mVar.a());
                if (blockEntity instanceof p) {
                    p pVar = (p) blockEntity;
                    if (pVar.b((Player) serverPlayerPlayer)) {
                        String strA = pVar.a();
                        pVar.a(mVar.b());
                        pVar.b(mVar.c());
                        pVar.e();
                        PacketDistributor.sendToPlayer(serverPlayerPlayer, mVar, new CustomPacketPayload[0]);
                        if (!strA.equals(mVar.b())) {
                            mctech.blockentities.f.g.a().e(strA).forEach(eVar -> {
                                BlockEntity blockEntity2 = level.getBlockEntity(eVar.c());
                                if (blockEntity2 instanceof p) {
                                    ((p) blockEntity2).c();
                                }
                            });
                        }
                        mctech.blockentities.f.g.a().e(mVar.b()).forEach(eVar2 -> {
                            BlockEntity blockEntity2 = level.getBlockEntity(eVar2.c());
                            if (blockEntity2 instanceof p) {
                                ((p) blockEntity2).c();
                            }
                        });
                        pVar.c();
                        pVar.setChanged();
                    }
                }
            }
        });
    }

    private static boolean a(Level level, Player player, BlockPos blockPos) {
        return (level.isLoaded(blockPos) && player.containerMenu.stillValid(player)) ? false : true;
    }
}
