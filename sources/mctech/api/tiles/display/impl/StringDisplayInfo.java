package mctech.api.tiles.display.impl;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.Objects;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import mctech.api.tiles.display.IDisplayInfo;
import mctech.api.tiles.display.IMonitorRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSequence;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/impl/StringDisplayInfo.class */
public class StringDisplayInfo implements IDisplayInfo {
    Component comp;
    Supplier<Component> textProvider;
    BooleanSupplier aliveProvider;

    public StringDisplayInfo(Supplier<Component> supplier, BooleanSupplier booleanSupplier) {
        this.textProvider = supplier;
        this.aliveProvider = booleanSupplier;
    }

    public StringDisplayInfo(FriendlyByteBuf friendlyByteBuf) {
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    @OnlyIn(Dist.CLIENT)
    public void render(PoseStack poseStack, int i, int i2, int i3, int i4, IDisplayInfo.Alignment alignment, IMonitorRenderer iMonitorRenderer) {
        Font font = iMonitorRenderer.getFont();
        int i5 = 0;
        for (FormattedCharSequence formattedCharSequence : font.split(this.comp, i3)) {
            int i6 = i4 - i5;
            Objects.requireNonNull(font);
            if (i6 < 9) {
                return;
            }
            Objects.requireNonNull(font);
            i5 += 9;
        }
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    @OnlyIn(Dist.CLIENT)
    public int getHeight(int i, IDisplayInfo.Alignment alignment) {
        Font font = Minecraft.getInstance().font;
        int size = font.getSplitter().splitLines(this.comp, i, Style.EMPTY).size();
        Objects.requireNonNull(font);
        return size * 9;
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public boolean isValid() {
        return this.aliveProvider.getAsBoolean();
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public Tag getServerData() {
        return StringTag.valueOf(this.textProvider.get().getString());
    }

    @Override // mctech.api.tiles.display.IDisplayInfo
    public void serialize(FriendlyByteBuf friendlyByteBuf) {
    }
}
