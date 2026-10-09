package mctech.u.c;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.stream.Stream;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechIngredients;
import net.minecraft.core.Holder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.crafting.ICustomIngredient;
import net.neoforged.neoforge.common.crafting.IngredientType;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/u/c/a.class */
public class a implements ICustomIngredient {
    public static final MapCodec<a> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(mctech.g.a.a.b.fieldOf("conduit_type").forGetter((v0) -> {
            return v0.a();
        }), Codec.INT.optionalFieldOf("count", 1).forGetter(aVar -> {
            return Integer.valueOf(aVar.c);
        })).apply(instance, (v1, v2) -> {
            return new a(v1, v2);
        });
    });
    private final Holder<mctech.g.a.a<?, ?>> b;
    private final int c;

    private a(Holder<mctech.g.a.a<?, ?>> holder) {
        this(holder, 1);
    }

    private a(Holder<mctech.g.a.a<?, ?>> holder, int i) {
        this.b = holder;
        this.c = i;
    }

    public static Ingredient a(Holder<mctech.g.a.a<?, ?>> holder) {
        return new a(holder).toVanilla();
    }

    public static Ingredient a(Holder<mctech.g.a.a<?, ?>> holder, int i) {
        return new a(holder).toVanilla();
    }

    public Holder<mctech.g.a.a<?, ?>> a() {
        return this.b;
    }

    public boolean test(ItemStack itemStack) {
        Holder holder;
        return itemStack.is(MCTechBlocks.CONDUIT.asItem()) && itemStack.has(MCTechDataComponent.CONDUIT) && (holder = (Holder) itemStack.get(MCTechDataComponent.CONDUIT)) != null && this.b.is(holder) && itemStack.getCount() >= this.c;
    }

    @NotNull
    public Stream<ItemStack> getItems() {
        return Stream.of(mctech.g.a.b.a(this.b, this.c));
    }

    public boolean isSimple() {
        return false;
    }

    @NotNull
    public IngredientType<?> getType() {
        return (IngredientType) MCTechIngredients.CONDUIT_INGREDIENT_TYPE.get();
    }
}
