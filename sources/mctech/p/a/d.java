package mctech.p.a;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import net.mcskill.msregistry.registry.holder.LBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.pattern.BlockInWorld;
import net.minecraft.world.level.block.state.pattern.BlockPattern;
import net.neoforged.neoforge.registries.DeferredBlock;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/d.class */
public class d {
    private final ResourceLocation a;
    private final BlockPattern b;
    private final Map<Character, Predicate<BlockInWorld>> c;
    private final Map<Character, Supplier<? extends Block>> d;
    private final DeferredBlock<? extends Block> e;
    private final Supplier<Item> f;
    private final boolean g;
    private final int h;
    private final int i;
    private final int j;
    private final String[][] k;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/d$a.class */
    @FunctionalInterface
    public interface a {
        void accept(c cVar);
    }

    /* JADX INFO: renamed from: mctech.p.a.d$d, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/d$d.class */
    @FunctionalInterface
    public interface InterfaceC0031d {
        void a(c cVar, BlockPos blockPos);
    }

    private d(ResourceLocation resourceLocation, String[][] strArr, Map<Character, Predicate<BlockInWorld>> map, Map<Character, Supplier<? extends Block>> map2, DeferredBlock<? extends Block> deferredBlock, Supplier<Item> supplier, boolean z) {
        this.a = resourceLocation;
        this.k = strArr;
        this.c = Map.copyOf(map);
        this.d = Map.copyOf(map2);
        this.e = deferredBlock;
        this.f = supplier;
        this.g = z;
        this.i = strArr.length;
        this.j = this.i > 0 ? strArr[0].length : 0;
        this.h = this.j > 0 ? strArr[0][0].length() : 0;
        this.b = j();
    }

    public static b a(ResourceLocation resourceLocation) {
        return new b(resourceLocation);
    }

    public ResourceLocation a() {
        return this.a;
    }

    public BlockPattern b() {
        return this.b;
    }

    public Map<Character, Supplier<? extends Block>> c() {
        return this.d;
    }

    public DeferredBlock<? extends Block> d() {
        return this.e;
    }

    public Supplier<Item> e() {
        return this.f;
    }

    public boolean f() {
        return this.g;
    }

    public int g() {
        return this.h;
    }

    public int h() {
        return this.i;
    }

    public int i() {
        return this.j;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/d$c.class */
    public static final class c extends Record {
        private final int a;
        private final int b;
        private final int c;
        private final char d;
        private final Predicate<BlockInWorld> e;
        private final Supplier<? extends Block> f;

        public c(int i, int i2, int i3, char c, Predicate<BlockInWorld> predicate, Supplier<? extends Block> supplier) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = c;
            this.e = predicate;
            this.f = supplier;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, c.class), c.class, "x;y;z;symbol;predicate;requiredBlock", "FIELD:Lmctech/p/a/d$c;->a:I", "FIELD:Lmctech/p/a/d$c;->b:I", "FIELD:Lmctech/p/a/d$c;->c:I", "FIELD:Lmctech/p/a/d$c;->d:C", "FIELD:Lmctech/p/a/d$c;->e:Ljava/util/function/Predicate;", "FIELD:Lmctech/p/a/d$c;->f:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, c.class), c.class, "x;y;z;symbol;predicate;requiredBlock", "FIELD:Lmctech/p/a/d$c;->a:I", "FIELD:Lmctech/p/a/d$c;->b:I", "FIELD:Lmctech/p/a/d$c;->c:I", "FIELD:Lmctech/p/a/d$c;->d:C", "FIELD:Lmctech/p/a/d$c;->e:Ljava/util/function/Predicate;", "FIELD:Lmctech/p/a/d$c;->f:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, c.class, Object.class), c.class, "x;y;z;symbol;predicate;requiredBlock", "FIELD:Lmctech/p/a/d$c;->a:I", "FIELD:Lmctech/p/a/d$c;->b:I", "FIELD:Lmctech/p/a/d$c;->c:I", "FIELD:Lmctech/p/a/d$c;->d:C", "FIELD:Lmctech/p/a/d$c;->e:Ljava/util/function/Predicate;", "FIELD:Lmctech/p/a/d$c;->f:Ljava/util/function/Supplier;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int b() {
            return this.a;
        }

        public int c() {
            return this.b;
        }

        public int d() {
            return this.c;
        }

        public char e() {
            return this.d;
        }

        public Predicate<BlockInWorld> f() {
            return this.e;
        }

        public Supplier<? extends Block> g() {
            return this.f;
        }

        public boolean a() {
            return this.d == ' ';
        }
    }

    public void a(a aVar) {
        for (int i = 0; i < this.i; i++) {
            for (int i2 = 0; i2 < this.j; i2++) {
                for (int i3 = 0; i3 < this.h; i3++) {
                    char cCharAt = this.k[(this.i - 1) - i][i3].charAt(i2);
                    aVar.accept(new c(i3, i, i2, cCharAt, this.c.getOrDefault(Character.valueOf(cCharAt), blockInWorld -> {
                        return true;
                    }), this.d.get(Character.valueOf(cCharAt))));
                }
            }
        }
    }

    public BlockState a(char c2) {
        Supplier<? extends Block> supplier = this.d.get(Character.valueOf(c2));
        return supplier != null ? supplier.get().defaultBlockState() : Blocks.AIR.defaultBlockState();
    }

    private BlockPattern j() {
        Predicate[][][] predicateArr = new Predicate[this.j][this.i][this.h];
        for (int i = 0; i < this.i; i++) {
            for (int i2 = 0; i2 < this.j; i2++) {
                for (int i3 = 0; i3 < this.h; i3++) {
                    predicateArr[i2][i][i3] = this.c.getOrDefault(Character.valueOf(this.k[i][i2].charAt(i3)), blockInWorld -> {
                        return true;
                    });
                }
            }
        }
        return new BlockPattern(predicateArr);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/p/a/d$b.class */
    public static class b {
        private final ResourceLocation a;
        private DeferredBlock<? extends Block> e;
        private Supplier<Item> f;
        private final List<String[]> b = new ArrayList();
        private final Map<Character, Predicate<BlockInWorld>> c = new HashMap();
        private final Map<Character, Supplier<? extends Block>> d = new HashMap();
        private boolean g = false;
        private int h = 0;
        private int i = 0;

        private b(ResourceLocation resourceLocation) {
            this.a = resourceLocation;
            this.c.put(' ', blockInWorld -> {
                return true;
            });
        }

        public b a(String... strArr) {
            b(strArr);
            if (this.b.isEmpty()) {
                this.h = strArr[0].length();
                this.i = strArr.length;
            } else {
                c(strArr);
            }
            d(strArr);
            this.b.add(strArr);
            return this;
        }

        public b a(char c, Predicate<BlockInWorld> predicate) {
            if (c == ' ' || c == '_') {
                throw new IllegalArgumentException("Symbol '" + c + "' is reserved");
            }
            this.c.put(Character.valueOf(c), predicate);
            return this;
        }

        public b a(char c, Block block) {
            this.d.put(Character.valueOf(c), () -> {
                return block;
            });
            return a(c, blockInWorld -> {
                return blockInWorld.getState().is(block);
            });
        }

        public <B extends Block> b a(char c, Supplier<B> supplier) {
            this.d.put(Character.valueOf(c), supplier);
            return a(c, blockInWorld -> {
                return blockInWorld.getState().is((Block) supplier.get());
            });
        }

        public <B extends Block> b a(char c, DeferredBlock<B> deferredBlock) {
            this.d.put(Character.valueOf(c), deferredBlock);
            return a(c, blockInWorld -> {
                return blockInWorld.getState().is((Block) deferredBlock.get());
            });
        }

        public <B extends Block> b a(char c, LBlock<B> lBlock) {
            this.d.put(Character.valueOf(c), lBlock);
            return a(c, blockInWorld -> {
                return blockInWorld.getState().is((Block) lBlock.get());
            });
        }

        public b a(DeferredBlock<? extends Block> deferredBlock) {
            this.e = deferredBlock;
            return this;
        }

        public b a(Supplier<Item> supplier) {
            this.f = supplier;
            return this;
        }

        public b a(boolean z) {
            this.g = z;
            return this;
        }

        public d a() {
            b();
            String[][] strArr = new String[this.b.size()][];
            for (int i = 0; i < this.b.size(); i++) {
                strArr[i] = this.b.get(i);
            }
            return new d(this.a, strArr, this.c, this.d, this.e, this.f, this.g);
        }

        private void b(String[] strArr) {
            if (strArr == null || strArr.length == 0) {
                throw new IllegalArgumentException("Pattern layer cannot be empty");
            }
            int length = strArr[0].length();
            if (length == 0) {
                throw new IllegalArgumentException("Pattern rows cannot be empty strings");
            }
            for (String str : strArr) {
                if (str.length() != length) {
                    throw new IllegalArgumentException("Row width mismatch");
                }
            }
        }

        private void c(String[] strArr) {
            if (strArr[0].length() != this.h) {
                throw new IllegalArgumentException("Width mismatch");
            }
            if (strArr.length != this.i) {
                throw new IllegalArgumentException("Depth mismatch");
            }
        }

        private void d(String[] strArr) {
            for (String str : strArr) {
                for (char c : str.toCharArray()) {
                    if (!this.c.containsKey(Character.valueOf(c))) {
                        this.c.put(Character.valueOf(c), null);
                    }
                }
            }
        }

        private void b() {
            if (this.b.isEmpty()) {
                throw new IllegalStateException("No pattern layers defined");
            }
            if (this.e == null) {
                throw new IllegalStateException("Structure block not defined");
            }
            ArrayList arrayList = new ArrayList();
            for (Map.Entry<Character, Predicate<BlockInWorld>> entry : this.c.entrySet()) {
                if (entry.getValue() == null) {
                    arrayList.add(entry.getKey());
                }
            }
            if (!arrayList.isEmpty()) {
                throw new IllegalStateException("Missing predicates for: " + String.valueOf(arrayList));
            }
        }
    }
}
