package mctech.g.b.a.a;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/a/a/i.class */
public abstract class i<T extends Recipe<?>> implements m {
    private final RecipeType<T> a;
    private RecipeHolder<T> b;

    @Nullable
    public abstract RecipeHolder<T> a();

    public abstract void a(@Nullable RecipeHolder<T> recipeHolder);

    public static <T extends Recipe<?>> i<T> a(RecipeType<T> recipeType) {
        return (i<T>) new i<T>(recipeType) { // from class: mctech.g.b.a.a.i.1

            @Nullable
            private RecipeHolder<T> a;

            @Override // mctech.g.b.a.a.i
            @Nullable
            public RecipeHolder<T> a() {
                return this.a;
            }

            @Override // mctech.g.b.a.a.i
            public void a(@Nullable RecipeHolder<T> recipeHolder) {
                this.a = recipeHolder;
            }
        };
    }

    public static <T extends Recipe<?>> i<T> a(RecipeType<T> recipeType, final Supplier<RecipeHolder<T>> supplier, final Consumer<RecipeHolder<T>> consumer) {
        return (i<T>) new i<T>(recipeType) { // from class: mctech.g.b.a.a.i.2
            @Override // mctech.g.b.a.a.i
            @Nullable
            public RecipeHolder<T> a() {
                return (RecipeHolder) supplier.get();
            }

            @Override // mctech.g.b.a.a.i
            public void a(@Nullable RecipeHolder<T> recipeHolder) {
                consumer.accept(recipeHolder);
            }
        };
    }

    public static <T extends Recipe<?>> i<T> a(RecipeType<T> recipeType, final Supplier<RecipeHolder<T>> supplier) {
        return (i<T>) new i<T>(recipeType) { // from class: mctech.g.b.a.a.i.3
            @Override // mctech.g.b.a.a.i
            @Nullable
            public RecipeHolder<T> a() {
                return (RecipeHolder) supplier.get();
            }

            @Override // mctech.g.b.a.a.i
            public void a(@Nullable RecipeHolder<T> recipeHolder) {
                throw new UnsupportedOperationException("Attempt to set a read-only sync slot.");
            }
        };
    }

    public i(RecipeType<T> recipeType) {
        this.a = recipeType;
    }

    @Override // mctech.g.b.a.a.m
    public m.a c() {
        RecipeHolder<T> recipeHolderA = a();
        m.a aVar = Objects.equals(recipeHolderA, this.b) ? m.a.NONE : m.a.FULL;
        this.b = recipeHolderA;
        return aVar;
    }

    @Override // mctech.g.b.a.a.m
    public mctech.g.b.a.a.a.l a(Level level, m.a aVar) {
        RecipeHolder<T> recipeHolderA = a();
        if (recipeHolderA == null) {
            return new mctech.g.b.a.a.a.i();
        }
        return new mctech.g.b.a.a.a.k(recipeHolderA.id());
    }

    @Override // mctech.g.b.a.a.m
    public void a(Level level, mctech.g.b.a.a.a.l lVar) {
        if (lVar instanceof mctech.g.b.a.a.a.k) {
            a((RecipeHolder) level.getRecipeManager().byKey(((mctech.g.b.a.a.a.k) lVar).b()).map(recipeHolder -> {
                if (recipeHolder.value().getType() == this.a) {
                    return recipeHolder;
                }
                return null;
            }).orElse(null));
        } else if (lVar instanceof mctech.g.b.a.a.a.i) {
            a((RecipeHolder) null);
        }
    }
}
