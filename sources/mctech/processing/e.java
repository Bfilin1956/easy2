package mctech.processing;

import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.tile.INetworkFieldProvider;
import mctech.blockentities.k;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/processing/e.class */
public class e<RI extends RecipeInput, R extends Recipe<RI>, BE extends k & INetworkFieldProvider> implements INetworkDataBuffer {
    public a<RI, R, BE> a;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/processing/e$a.class */
    public interface a<RI extends RecipeInput, R extends Recipe<RI>, BE extends k & INetworkFieldProvider> {
        ProcessingBlock<RI, R, BE> a(int i);

        int a();
    }

    public e(a<RI, R, BE> aVar) {
        this.a = aVar;
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void write(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        registryFriendlyByteBuf.writeInt(this.a.a());
        for (int i = 0; i < this.a.a(); i++) {
            this.a.a(i).write(registryFriendlyByteBuf);
        }
    }

    @Override // mctech.api.network.buffer.INetworkDataBuffer
    public void read(@NotNull RegistryFriendlyByteBuf registryFriendlyByteBuf) {
        int i = registryFriendlyByteBuf.readInt();
        if (i != this.a.a()) {
            throw new RuntimeException("Read byteBuf size mismatch");
        }
        for (int i2 = 0; i2 < i; i2++) {
            this.a.a(i2).read(registryFriendlyByteBuf);
        }
    }
}
