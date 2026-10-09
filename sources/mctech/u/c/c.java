package mctech.u.c;

import com.google.common.collect.ImmutableMap;
import java.util.function.BiFunction;
import mctech.api.recipes.ingridients.queue.IInputter;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/c/c.class */
public interface c {
    public static final ImmutableMap<String, BiFunction<HolderLookup.Provider, CompoundTag, c>> a = ImmutableMap.builder().put("single", f::new).put("multi", d::new).build();

    boolean a(@NotNull IInputter iInputter);

    @NotNull
    ItemStack a();

    void a(@NotNull HolderLookup.Provider provider, @NotNull CompoundTag compoundTag);

    String b();

    @Nullable
    static c b(HolderLookup.Provider provider, @NotNull CompoundTag compoundTag) {
        BiFunction biFunction = (BiFunction) a.get(compoundTag.getString("type"));
        if (biFunction != null) {
            return (c) biFunction.apply(provider, compoundTag);
        }
        return null;
    }

    @NotNull
    static CompoundTag a(HolderLookup.Provider provider, @NotNull c cVar) {
        CompoundTag compoundTag = new CompoundTag();
        compoundTag.putString("type", cVar.b());
        cVar.a(provider, compoundTag);
        return compoundTag;
    }
}
