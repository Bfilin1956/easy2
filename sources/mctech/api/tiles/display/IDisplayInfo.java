package mctech.api.tiles.display;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.nbt.Tag;
import net.minecraft.network.FriendlyByteBuf;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/IDisplayInfo.class */
public interface IDisplayInfo {
    public static final IDisplayRegistry REGISTRY = new IDisplayRegistry.DelegateRegistry();

    @OnlyIn(Dist.CLIENT)
    void render(PoseStack poseStack, int i, int i2, int i3, int i4, Alignment alignment, IMonitorRenderer iMonitorRenderer);

    @OnlyIn(Dist.CLIENT)
    int getHeight(int i, Alignment alignment);

    boolean isValid();

    void serialize(FriendlyByteBuf friendlyByteBuf);

    Tag getServerData();

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/IDisplayInfo$Alignment.class */
    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT;

        public int getXOffset(int i) {
            if (this == CENTER) {
                return i >> 1;
            }
            if (this == RIGHT) {
                return i;
            }
            return 0;
        }
    }
}
