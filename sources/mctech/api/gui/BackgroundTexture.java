package mctech.api.gui;

import mctech.config.utils.Helpers;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/BackgroundTexture.class */
public class BackgroundTexture {
    public static final BackgroundTexture DEFAULT = of().build();
    ResourceLocation backgroundTexture;
    ResourceLocation foregroundTexture;
    int backgroundBrightness = 32;
    int foregroundBrightness = 64;
    boolean disableBackgroundInLevel = true;

    private BackgroundTexture() {
    }

    public static Builder of() {
        return new Builder().withTexture("minecraft:textures/block/oak_planks.png").withBrightness(192);
    }

    public static Builder of(String str) {
        return new Builder().withTexture(str);
    }

    public static Builder of(String str, String str2) {
        return new Builder().withTexture(str, str2);
    }

    public static Builder of(ResourceLocation resourceLocation) {
        return new Builder().withTexture(resourceLocation);
    }

    public ResourceLocation getBackgroundTexture() {
        return this.backgroundTexture;
    }

    public ResourceLocation getForegroundTexture() {
        return this.foregroundTexture;
    }

    public boolean shouldDisableInLevel() {
        return this.disableBackgroundInLevel;
    }

    public int getBackgroundBrightness() {
        return this.backgroundBrightness;
    }

    public int getForegroundBrightness() {
        return this.foregroundBrightness;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/gui/BackgroundTexture$Builder.class */
    public static class Builder {
        BackgroundTexture texture = new BackgroundTexture();

        public Builder withBackground(String str) {
            return withBackground(ResourceLocation.parse(str));
        }

        public Builder withBackground(String str, String str2) {
            return withBackground(ResourceLocation.fromNamespaceAndPath(str, str2));
        }

        public Builder withBackground(ResourceLocation resourceLocation) {
            this.texture.backgroundTexture = resourceLocation;
            return this;
        }

        public Builder withForeground(String str) {
            return withForeground(ResourceLocation.parse(str));
        }

        public Builder withForeground(String str, String str2) {
            return withForeground(ResourceLocation.fromNamespaceAndPath(str, str2));
        }

        public Builder withForeground(ResourceLocation resourceLocation) {
            this.texture.foregroundTexture = resourceLocation;
            return this;
        }

        public Builder withTexture(String str) {
            return withTexture(ResourceLocation.parse(str));
        }

        public Builder withTexture(String str, String str2) {
            return withTexture(ResourceLocation.fromNamespaceAndPath(str, str2));
        }

        public Builder withTexture(ResourceLocation resourceLocation) {
            this.texture.backgroundTexture = resourceLocation;
            this.texture.foregroundTexture = resourceLocation;
            return this;
        }

        public Builder withBrightness(int i) {
            int iClamp = Helpers.clamp(i, 0, 255);
            return withBrightness(iClamp, iClamp / 2);
        }

        public Builder withBrightness(int i, int i2) {
            this.texture.backgroundBrightness = Helpers.clamp(i2, 0, 255);
            this.texture.foregroundBrightness = Helpers.clamp(i, 0, 255);
            return this;
        }

        public Builder withBackground(int i) {
            this.texture.backgroundBrightness = Helpers.clamp(i, 0, 255);
            return this;
        }

        public Builder withForeground(int i) {
            this.texture.foregroundBrightness = Helpers.clamp(i, 0, 255);
            return this;
        }

        public Builder withBackgroundPresentIngame(boolean z) {
            this.texture.disableBackgroundInLevel = !z;
            return this;
        }

        public BackgroundTexture build() {
            BackgroundTexture backgroundTexture = this.texture;
            this.texture = null;
            return backgroundTexture;
        }
    }
}
