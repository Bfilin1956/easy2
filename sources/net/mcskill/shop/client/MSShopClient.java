package net.mcskill.shop.client;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.mcskill.shop.client.listener.InputEventListener;
import net.mcskill.shop.common.network.ChannelHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MSShopClient.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/MSShopClient.class */
@Mod(value = "msshop", dist = {Dist.CLIENT})
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lnet/mcskill/shop/client/MSShopClient;", "", "modBus", "Lnet/neoforged/bus/api/IEventBus;", "container", "Lnet/neoforged/fml/ModContainer;", "<init>", "(Lnet/neoforged/bus/api/IEventBus;Lnet/neoforged/fml/ModContainer;)V", "Companion", "MSShop"})
public final class MSShopClient {

    @NotNull
    public static final String MOD_ID = "msshop";

    @NotNull
    public static final String NAME = "McSkill Shop";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String dustInfo = "\"%dust%&f\" необходима для покупки на &9/warp npc.";
    private static boolean enableDiscountColors = true;

    @NotNull
    private static String guarantInfo = "За каждые %g_first% прокрутов вы получаете предмет красной категории. За каждые %g_second% прокрутов вы получаете предмет золотой категории";
    private static boolean emeraldsPriority = true;

    public MSShopClient(@NotNull IEventBus modBus, @NotNull ModContainer container) {
        Intrinsics.checkNotNullParameter(modBus, "modBus");
        Intrinsics.checkNotNullParameter(container, "container");
        ChannelHandler.INSTANCE.register$MSShop(modBus);
        NeoForge.EVENT_BUS.register(new InputEventListener());
    }

    /* JADX INFO: compiled from: MSShopClient.kt */
    /* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/MSShopClient$Companion.class */
    @Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR\u001a\u0010\u0015\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u0018"}, d2 = {"Lnet/mcskill/shop/client/MSShopClient$Companion;", "", "<init>", "()V", "MOD_ID", "", "NAME", "dustInfo", "getDustInfo$MSShop", "()Ljava/lang/String;", "setDustInfo$MSShop", "(Ljava/lang/String;)V", "enableDiscountColors", "", "getEnableDiscountColors$MSShop", "()Z", "setEnableDiscountColors$MSShop", "(Z)V", "guarantInfo", "getGuarantInfo$MSShop", "setGuarantInfo$MSShop", "emeraldsPriority", "getEmeraldsPriority$MSShop", "setEmeraldsPriority$MSShop", "MSShop"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final String getDustInfo$MSShop() {
            return MSShopClient.dustInfo;
        }

        public final void setDustInfo$MSShop(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            MSShopClient.dustInfo = str;
        }

        public final boolean getEnableDiscountColors$MSShop() {
            return MSShopClient.enableDiscountColors;
        }

        public final void setEnableDiscountColors$MSShop(boolean z) {
            MSShopClient.enableDiscountColors = z;
        }

        @NotNull
        public final String getGuarantInfo$MSShop() {
            return MSShopClient.guarantInfo;
        }

        public final void setGuarantInfo$MSShop(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            MSShopClient.guarantInfo = str;
        }

        public final boolean getEmeraldsPriority$MSShop() {
            return MSShopClient.emeraldsPriority;
        }

        public final void setEmeraldsPriority$MSShop(boolean z) {
            MSShopClient.emeraldsPriority = z;
        }
    }
}
