package mctech.api.tiles.display;

import java.util.function.Function;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/IDisplayRegistry.class */
public interface IDisplayRegistry {
    void register(ResourceLocation resourceLocation, Class<? extends IDisplayInfo> cls, Function<FriendlyByteBuf, IDisplayInfo> function);

    void serialize(IDisplayInfo iDisplayInfo, FriendlyByteBuf friendlyByteBuf);

    IDisplayInfo deserialize(FriendlyByteBuf friendlyByteBuf);

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/display/IDisplayRegistry$DelegateRegistry.class */
    public static class DelegateRegistry implements IDisplayRegistry {
        IDisplayRegistry registry;

        public void setRegistry(IDisplayRegistry iDisplayRegistry) {
            this.registry = iDisplayRegistry;
        }

        @Override // mctech.api.tiles.display.IDisplayRegistry
        public void register(ResourceLocation resourceLocation, Class<? extends IDisplayInfo> cls, Function<FriendlyByteBuf, IDisplayInfo> function) {
            if (this.registry == null) {
                throw new UnsupportedOperationException();
            }
            this.registry.register(resourceLocation, cls, function);
        }

        @Override // mctech.api.tiles.display.IDisplayRegistry
        public void serialize(IDisplayInfo iDisplayInfo, FriendlyByteBuf friendlyByteBuf) {
            if (this.registry == null) {
                throw new UnsupportedOperationException();
            }
            this.registry.serialize(iDisplayInfo, friendlyByteBuf);
        }

        @Override // mctech.api.tiles.display.IDisplayRegistry
        public IDisplayInfo deserialize(FriendlyByteBuf friendlyByteBuf) {
            if (this.registry == null) {
                throw new UnsupportedOperationException();
            }
            return this.registry.deserialize(friendlyByteBuf);
        }
    }
}
