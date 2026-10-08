package net.mcskill.shop.client.screen;

import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.utils.ResourcesKt;
import kotlin.Metadata;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: States.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/States.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001f\u0010\u0004\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001f\u0010\n\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u001f\u0010\f\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\tR\u001f\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\tR\u001f\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2 = {"Lnet/mcskill/shop/client/screen/States;", "", "<init>", "()V", "closeIcon", "Lgg/essential/elementa/state/BasicState;", "Lnet/minecraft/resources/ResourceLocation;", "kotlin.jvm.PlatformType", "getCloseIcon", "()Lgg/essential/elementa/state/BasicState;", "rubleIcon", "getRubleIcon", "emeraldIcon", "getEmeraldIcon", "rubleGrayIcon", "getRubleGrayIcon", "emeraldGrayIcon", "getEmeraldGrayIcon", "MSShop"})
public final class States {

    @NotNull
    public static final States INSTANCE = new States();

    @NotNull
    private static final BasicState<ResourceLocation> closeIcon = ResourcesKt.asResourceState$default("textures/close.png", (String) null, 1, (Object) null);

    @NotNull
    private static final BasicState<ResourceLocation> rubleIcon = ResourcesKt.asResourceState$default("textures/ruble_20x20.png", (String) null, 1, (Object) null);

    @NotNull
    private static final BasicState<ResourceLocation> emeraldIcon = ResourcesKt.asResourceState$default("textures/emerald_20x20.png", (String) null, 1, (Object) null);

    @NotNull
    private static final BasicState<ResourceLocation> rubleGrayIcon = ResourcesKt.asResourceState$default("textures/ruble_gray_20x20.png", (String) null, 1, (Object) null);

    @NotNull
    private static final BasicState<ResourceLocation> emeraldGrayIcon = ResourcesKt.asResourceState$default("textures/emerald_gray_20x20.png", (String) null, 1, (Object) null);

    private States() {
    }

    @NotNull
    public final BasicState<ResourceLocation> getCloseIcon() {
        return closeIcon;
    }

    @NotNull
    public final BasicState<ResourceLocation> getRubleIcon() {
        return rubleIcon;
    }

    @NotNull
    public final BasicState<ResourceLocation> getEmeraldIcon() {
        return emeraldIcon;
    }

    @NotNull
    public final BasicState<ResourceLocation> getRubleGrayIcon() {
        return rubleGrayIcon;
    }

    @NotNull
    public final BasicState<ResourceLocation> getEmeraldGrayIcon() {
        return emeraldGrayIcon;
    }
}
