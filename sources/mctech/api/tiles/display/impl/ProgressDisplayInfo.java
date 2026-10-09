package mctech.api.tiles.display.impl;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import mctech.api.tiles.display.IDisplayInfo;
import mctech.api.tiles.display.IMonitorRenderer;
import mctech.utils.math.a;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.LongArrayTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/impl/ProgressDisplayInfo.class */
public class ProgressDisplayInfo implements IDisplayInfo {
    Progress progress;
    Supplier<Progress> progressProvider;
    BooleanSupplier aliveProvider;

    public ProgressDisplayInfo(FriendlyByteBuf friendlyByteBuf) {
        this.progress = new Progress(friendlyByteBuf);
    }

    public ProgressDisplayInfo(Supplier<Progress> supplier, BooleanSupplier booleanSupplier) {
        this.progressProvider = supplier;
        this.aliveProvider = booleanSupplier;
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    @OnlyIn(Dist.CLIENT)
    public void render(PoseStack poseStack, int i, int i2, int i3, int i4, IDisplayInfo.Alignment alignment, IMonitorRenderer iMonitorRenderer) {
        Objects.requireNonNull(iMonitorRenderer.getFont());
        if (i4 <= 11) {
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void drawColorFrame(PoseStack poseStack, VertexConsumer vertexConsumer, float f, float f2, float f3, float f4, int i) {
        poseStack.last().pose();
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        int i5 = (i >> 24) & 255;
    }

    public static int darker(int i, float f) {
        return (i & a.f) | ((Math.max(0, (int) (((i >> 16) & 255) * f)) & 255) << 16) | ((Math.max(0, (int) (((i >> 8) & 255) * f)) & 255) << 8) | (Math.max(0, (int) ((i & 255) * f)) & 255);
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    @OnlyIn(Dist.CLIENT)
    public int getHeight(int i, IDisplayInfo.Alignment alignment) {
        Objects.requireNonNull(Minecraft.getInstance().font);
        return 14;
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public boolean isValid() {
        return this.aliveProvider.getAsBoolean();
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public void serialize(FriendlyByteBuf friendlyByteBuf) {
        this.progressProvider.get().serialize(friendlyByteBuf);
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public Tag getServerData() {
        Progress progress = this.progressProvider.get();
        return new LongArrayTag(new long[]{Double.doubleToLongBits(progress.progress), progress.mainColor, progress.secondaryColor});
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/impl/ProgressDisplayInfo$Progress.class */
    public static class Progress {
        double progress;
        int mainColor;
        int secondaryColor;

        public Progress(FriendlyByteBuf friendlyByteBuf) {
            this.progress = friendlyByteBuf.readDouble();
            this.mainColor = friendlyByteBuf.readInt();
            this.secondaryColor = friendlyByteBuf.readInt();
        }

        public Progress(double d, int i) {
            this(d, i, i);
        }

        public Progress(double d, int i, int i2) {
            this.progress = d;
            this.mainColor = i;
            this.secondaryColor = i2;
        }

        public void serialize(FriendlyByteBuf friendlyByteBuf) {
            friendlyByteBuf.writeDouble(this.progress);
            friendlyByteBuf.writeInt(this.mainColor);
            friendlyByteBuf.writeInt(this.secondaryColor);
        }
    }
}
