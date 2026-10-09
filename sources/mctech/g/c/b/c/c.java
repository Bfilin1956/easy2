package mctech.g.c.b.c;

import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/c/c.class */
public class c implements mctech.g.a.g.a {
    @Override // mctech.g.a.g.a
    public ResourceLocation a(Holder<mctech.g.a.a<?, ?>> holder, @Nullable CompoundTag compoundTag) {
        mctech.g.d.a.d.g.a aVar = (mctech.g.d.a.d.g.a) holder.value();
        if (compoundTag != null) {
            if (compoundTag.contains("IsActive") && compoundTag.getBoolean("IsActive")) {
                return aVar.o();
            }
            return aVar.a();
        }
        return aVar.a();
    }
}
