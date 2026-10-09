package mctech.items.e;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import mctech.api.items.electric.IElectricItem;
import mctech.items.base.MCTechElectricItem;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/i.class */
public class i extends MCTechElectricItem implements mctech.m.a.e {
    public i() {
        this.tier = 4;
        this.capacity = 1000000;
        this.transferLimit = 20000;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }

    @Override // mctech.items.base.MCTechElectricItem
    protected int getEnergyCost(ItemStack itemStack) {
        return 500;
    }

    @Override // mctech.m.a.e
    public mctech.m.a.i a(Player player, InteractionHand interactionHand, ItemStack itemStack) {
        return new mctech.m.f.l(player, this, itemStack, null).a(itemStack);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/i$a.class */
    public static final class a extends Record {
        private final int d;
        private final List<b> e;
        private final boolean f;
        private final boolean g;
        private final boolean h;
        public static final a a = new a(0, mctech.utils.a.b.i(), false, false, false);
        public static final Codec<a> b = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("selected").forGetter((v0) -> {
                return v0.a();
            }), Codec.list(b.a).fieldOf("schemes").forGetter((v0) -> {
                return v0.b();
            }), Codec.BOOL.fieldOf("useDurability").forGetter((v0) -> {
                return v0.c();
            }), Codec.BOOL.fieldOf("fakeInstall").forGetter((v0) -> {
                return v0.d();
            }), Codec.BOOL.fieldOf("saveToEmpty").forGetter((v0) -> {
                return v0.e();
            })).apply(instance, (v1, v2, v3, v4, v5) -> {
                return new a(v1, v2, v3, v4, v5);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, a> c = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
            return v0.a();
        }, b.b.apply(ByteBufCodecs.list()), (v0) -> {
            return v0.b();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.d();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.e();
        }, (v1, v2, v3, v4, v5) -> {
            return new a(v1, v2, v3, v4, v5);
        });

        public a(int i, List<b> list, boolean z, boolean z2, boolean z3) {
            this.d = i;
            this.e = list;
            this.f = z;
            this.g = z2;
            this.h = z3;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, a.class), a.class, "selected;schemes;useDurability;fakeInstall;saveToEmpty", "FIELD:Lmctech/items/e/i$a;->d:I", "FIELD:Lmctech/items/e/i$a;->e:Ljava/util/List;", "FIELD:Lmctech/items/e/i$a;->f:Z", "FIELD:Lmctech/items/e/i$a;->g:Z", "FIELD:Lmctech/items/e/i$a;->h:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, a.class), a.class, "selected;schemes;useDurability;fakeInstall;saveToEmpty", "FIELD:Lmctech/items/e/i$a;->d:I", "FIELD:Lmctech/items/e/i$a;->e:Ljava/util/List;", "FIELD:Lmctech/items/e/i$a;->f:Z", "FIELD:Lmctech/items/e/i$a;->g:Z", "FIELD:Lmctech/items/e/i$a;->h:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, a.class, Object.class), a.class, "selected;schemes;useDurability;fakeInstall;saveToEmpty", "FIELD:Lmctech/items/e/i$a;->d:I", "FIELD:Lmctech/items/e/i$a;->e:Ljava/util/List;", "FIELD:Lmctech/items/e/i$a;->f:Z", "FIELD:Lmctech/items/e/i$a;->g:Z", "FIELD:Lmctech/items/e/i$a;->h:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int a() {
            return this.d;
        }

        public List<b> b() {
            return this.e;
        }

        public boolean c() {
            return this.f;
        }

        public boolean d() {
            return this.g;
        }

        public boolean e() {
            return this.h;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/i$b.class */
    public static final class b extends Record {
        private final int c;
        private final int d;
        private final int e;
        private final int f;
        private final Map<ItemStack, List<Integer>> g;
        private final boolean h;
        public static final Codec<b> a = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf(mctech.g.a.a.b.a).forGetter((v0) -> {
                return v0.c();
            }), Codec.INT.fieldOf("width").forGetter((v0) -> {
                return v0.d();
            }), Codec.INT.fieldOf("height").forGetter((v0) -> {
                return v0.e();
            }), Codec.INT.fieldOf("size").forGetter((v0) -> {
                return v0.f();
            }), Codec.BOOL.fieldOf("locked").forGetter((v0) -> {
                return v0.h();
            }), Codec.unboundedMap(Codec.STRING, Codec.list(Codec.INT)).fieldOf("slots").forGetter((v0) -> {
                return v0.a();
            })).apply(instance, (v1, v2, v3, v4, v5, v6) -> {
                return new b(v1, v2, v3, v4, v5, v6);
            });
        });
        public static final StreamCodec<RegistryFriendlyByteBuf, b> b = StreamCodec.composite(ByteBufCodecs.INT, (v0) -> {
            return v0.c();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.d();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.e();
        }, ByteBufCodecs.INT, (v0) -> {
            return v0.f();
        }, ByteBufCodecs.map(HashMap::new, ItemStack.STREAM_CODEC, ByteBufCodecs.INT.apply(ByteBufCodecs.list())), (v0) -> {
            return v0.g();
        }, ByteBufCodecs.BOOL, (v0) -> {
            return v0.h();
        }, (v1, v2, v3, v4, v5, v6) -> {
            return new b(v1, v2, v3, v4, v5, v6);
        });

        public b(int i, int i2, int i3, int i4, Map<ItemStack, List<Integer>> map, boolean z) {
            this.c = i;
            this.d = i2;
            this.e = i3;
            this.f = i4;
            this.g = map;
            this.h = z;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, b.class), b.class, "id;width;height;size;slots;locked", "FIELD:Lmctech/items/e/i$b;->c:I", "FIELD:Lmctech/items/e/i$b;->d:I", "FIELD:Lmctech/items/e/i$b;->e:I", "FIELD:Lmctech/items/e/i$b;->f:I", "FIELD:Lmctech/items/e/i$b;->g:Ljava/util/Map;", "FIELD:Lmctech/items/e/i$b;->h:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, b.class), b.class, "id;width;height;size;slots;locked", "FIELD:Lmctech/items/e/i$b;->c:I", "FIELD:Lmctech/items/e/i$b;->d:I", "FIELD:Lmctech/items/e/i$b;->e:I", "FIELD:Lmctech/items/e/i$b;->f:I", "FIELD:Lmctech/items/e/i$b;->g:Ljava/util/Map;", "FIELD:Lmctech/items/e/i$b;->h:Z").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, b.class, Object.class), b.class, "id;width;height;size;slots;locked", "FIELD:Lmctech/items/e/i$b;->c:I", "FIELD:Lmctech/items/e/i$b;->d:I", "FIELD:Lmctech/items/e/i$b;->e:I", "FIELD:Lmctech/items/e/i$b;->f:I", "FIELD:Lmctech/items/e/i$b;->g:Ljava/util/Map;", "FIELD:Lmctech/items/e/i$b;->h:Z").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public int c() {
            return this.c;
        }

        public int d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public int f() {
            return this.f;
        }

        public Map<ItemStack, List<Integer>> g() {
            return this.g;
        }

        public boolean h() {
            return this.h;
        }

        public b(int i, int i2, int i3, int i4, boolean z, Map<String, List<Integer>> map) {
            this(i, i2, i3, i4, (Map<ItemStack, List<Integer>>) map.entrySet().stream().collect(Collectors.toMap(entry -> {
                return new ItemStack((ItemLike) BuiltInRegistries.ITEM.get(ResourceLocation.parse((String) entry.getKey())));
            }, (v0) -> {
                return v0.getValue();
            })), z);
        }

        public Map<String, List<Integer>> a() {
            return (Map) g().entrySet().stream().collect(Collectors.toMap(entry -> {
                return BuiltInRegistries.ITEM.getKey(((ItemStack) entry.getKey()).getItem()).toString();
            }, (v0) -> {
                return v0.getValue();
            }));
        }

        public boolean b() {
            return this.g.isEmpty();
        }
    }
}
