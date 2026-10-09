package mctech.components;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.fluids.IFluidTank;
import net.neoforged.neoforge.items.ItemHandlerHelper;
import net.neoforged.neoforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/v.class */
public interface v {
    int a();

    @NotNull
    IFluidTank b();

    @OnlyIn(Dist.CLIENT)
    default boolean c() {
        LocalPlayer localPlayer = Minecraft.getInstance().player;
        if (localPlayer != null && localPlayer.containerMenu != null && !mctech.utils.n.a(localPlayer.containerMenu.getCarried()).isEmpty()) {
            PacketDistributor.sendToServer(new mctech.q.d.a(this), new CustomPacketPayload[0]);
            return true;
        }
        return false;
    }

    default void a(@NotNull ServerPlayer serverPlayer) {
        mctech.utils.n.a aVarA = mctech.utils.n.a(serverPlayer.containerMenu.getCarried(), b());
        if (aVarA.b) {
            int i = 0;
            if (aVarA.c.isEmpty()) {
                serverPlayer.containerMenu.setCarried((ItemStack) aVarA.d.getFirst());
                i = 1;
            } else {
                serverPlayer.containerMenu.setCarried(aVarA.c);
            }
            for (int i2 = i; i2 < aVarA.d.size(); i2++) {
                ItemStack itemStack = aVarA.d.get(i2);
                if (!itemStack.isEmpty()) {
                    ItemHandlerHelper.giveItemToPlayer(serverPlayer, itemStack);
                }
            }
        }
    }
}
