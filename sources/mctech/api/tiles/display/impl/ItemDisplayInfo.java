package mctech.api.tiles.display.impl;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import mctech.api.tiles.display.IDisplayInfo;
import mctech.api.tiles.display.IMonitorRenderer;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/impl/ItemDisplayInfo.class */
public class ItemDisplayInfo implements IDisplayInfo {
    ItemStack item;
    boolean showCount;
    Supplier<ItemStack> itemProvider;
    BooleanSupplier aliveProvider;

    public ItemDisplayInfo(FriendlyByteBuf friendlyByteBuf) {
        this.showCount = friendlyByteBuf.readBoolean();
        if (this.showCount) {
            this.item.setCount(friendlyByteBuf.readVarInt());
        }
    }

    public ItemDisplayInfo(boolean z, Supplier<ItemStack> supplier, BooleanSupplier booleanSupplier) {
        this.showCount = z;
        this.itemProvider = supplier;
        this.aliveProvider = booleanSupplier;
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    @OnlyIn(Dist.CLIENT)
    public void render(PoseStack poseStack, int i, int i2, int i3, int i4, IDisplayInfo.Alignment alignment, IMonitorRenderer iMonitorRenderer) {
        poseStack.pushPose();
        iMonitorRenderer.renderGuiItems(poseStack, this.item, i, i2);
        if (this.showCount) {
            iMonitorRenderer.renderGuiItemText(poseStack, this.item, i, i2, null);
        }
        poseStack.popPose();
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    @OnlyIn(Dist.CLIENT)
    public int getHeight(int i, IDisplayInfo.Alignment alignment) {
        return 18;
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public boolean isValid() {
        return this.aliveProvider.getAsBoolean();
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public void serialize(FriendlyByteBuf friendlyByteBuf) {
        ItemStack itemStack = this.itemProvider.get();
        friendlyByteBuf.writeBoolean(this.showCount);
        if (this.showCount) {
            friendlyByteBuf.writeVarInt(itemStack.getCount());
        }
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public Tag getServerData() {
        this.itemProvider.get();
        if (this.showCount) {
        }
        return null;
    }
}
