package mctech.g.d.c;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechMenus;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/f.class */
public class f extends Item {
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> a = (itemStack, r5) -> {
        return new b(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> b = (itemStack, r5) -> {
        return new c(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> c = (itemStack, r5) -> {
        return new g(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> d = (itemStack, r5) -> {
        return new h(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> e = (itemStack, r5) -> {
        return new j(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> f = (itemStack, r5) -> {
        return new l(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> g = (itemStack, r5) -> {
        return new o(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> h = (itemStack, r5) -> {
        return new p(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.d> i = (itemStack, r3) -> {
        return k.a;
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.d> j = (itemStack, r5) -> {
        return new m(itemStack);
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.e> k = (itemStack, r3) -> {
        return i.a;
    };
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.d> l = (itemStack, r3) -> {
        return i.a;
    };
    private final a m;

    public f(Item.Properties properties, a aVar) {
        super((Item.Properties) aVar.a().apply(properties));
        this.m = aVar;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        MenuType<?> menuTypeB = this.m.b();
        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if (menuTypeB != null) {
                a(serverPlayer);
            }
        }
        return super.use(level, player, interactionHand);
    }

    private void a(ServerPlayer serverPlayer) {
        serverPlayer.openMenu(new MenuProvider() { // from class: mctech.g.d.c.f.1
            public Component getDisplayName() {
                return Component.literal("");
            }

            public AbstractContainerMenu createMenu(int i2, Inventory inventory, Player player) {
                return f.this.m.b().create(i2, inventory);
            }
        });
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'b' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:399)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:364)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:349)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:315)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:288)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/c/f$a.class */
    public static final class a {
        public static final a a = new a("NOT", 0, properties -> {
            return properties;
        }, null);
        public static final a b;
        public static final a c;
        public static final a d;
        public static final a e;
        public static final a f;
        public static final a g;
        public static final a h;
        public static final a i;
        public static final a j;
        public static final a k;
        private UnaryOperator<Item.Properties> l;

        @Nullable
        private Supplier<MenuType<?>> m;
        private static final /* synthetic */ a[] n;

        public static a[] values() {
            return (a[]) n.clone();
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        private static /* synthetic */ a[] c() {
            return new a[]{a, b, c, d, e, f, g, h, i, j, k};
        }

        static {
            UnaryOperator unaryOperator = properties -> {
                return properties.component(MCTechDataComponent.REDSTONE_FILTER_DOUBLE_CHANNEL, mctech.g.d.c.a.a);
            };
            DeferredHolder<MenuType<?>, MenuType<e>> deferredHolder = MCTechMenus.REDSTONE_DOUBLE_CHANNEL_FILTER;
            Objects.requireNonNull(deferredHolder);
            b = new a("OR", 1, unaryOperator, deferredHolder::get);
            UnaryOperator unaryOperator2 = properties2 -> {
                return properties2.component(MCTechDataComponent.REDSTONE_FILTER_DOUBLE_CHANNEL, mctech.g.d.c.a.a);
            };
            DeferredHolder<MenuType<?>, MenuType<e>> deferredHolder2 = MCTechMenus.REDSTONE_DOUBLE_CHANNEL_FILTER;
            Objects.requireNonNull(deferredHolder2);
            c = new a("AND", 2, unaryOperator2, deferredHolder2::get);
            UnaryOperator unaryOperator3 = properties3 -> {
                return properties3.component(MCTechDataComponent.REDSTONE_FILTER_DOUBLE_CHANNEL, mctech.g.d.c.a.a);
            };
            DeferredHolder<MenuType<?>, MenuType<e>> deferredHolder3 = MCTechMenus.REDSTONE_DOUBLE_CHANNEL_FILTER;
            Objects.requireNonNull(deferredHolder3);
            d = new a("NOR", 3, unaryOperator3, deferredHolder3::get);
            UnaryOperator unaryOperator4 = properties4 -> {
                return properties4.component(MCTechDataComponent.REDSTONE_FILTER_DOUBLE_CHANNEL, mctech.g.d.c.a.a);
            };
            DeferredHolder<MenuType<?>, MenuType<e>> deferredHolder4 = MCTechMenus.REDSTONE_DOUBLE_CHANNEL_FILTER;
            Objects.requireNonNull(deferredHolder4);
            e = new a("NAND", 4, unaryOperator4, deferredHolder4::get);
            UnaryOperator unaryOperator5 = properties5 -> {
                return properties5.component(MCTechDataComponent.REDSTONE_FILTER_DOUBLE_CHANNEL, mctech.g.d.c.a.a);
            };
            DeferredHolder<MenuType<?>, MenuType<e>> deferredHolder5 = MCTechMenus.REDSTONE_DOUBLE_CHANNEL_FILTER;
            Objects.requireNonNull(deferredHolder5);
            f = new a("XOR", 5, unaryOperator5, deferredHolder5::get);
            UnaryOperator unaryOperator6 = properties6 -> {
                return properties6.component(MCTechDataComponent.REDSTONE_FILTER_DOUBLE_CHANNEL, mctech.g.d.c.a.a);
            };
            DeferredHolder<MenuType<?>, MenuType<e>> deferredHolder6 = MCTechMenus.REDSTONE_DOUBLE_CHANNEL_FILTER;
            Objects.requireNonNull(deferredHolder6);
            g = new a("XNOR", 6, unaryOperator6, deferredHolder6::get);
            h = new a("TLATCH", 7, properties7 -> {
                return properties7.component(MCTechDataComponent.REDSTONE_TLATCH_FILTER, l.a);
            }, null);
            UnaryOperator unaryOperator7 = properties8 -> {
                return properties8.component(MCTechDataComponent.REDSTONE_COUNT_FILTER, c.a);
            };
            DeferredHolder<MenuType<?>, MenuType<d>> deferredHolder7 = MCTechMenus.REDSTONE_COUNT_FILTER;
            Objects.requireNonNull(deferredHolder7);
            i = new a("COUNT", 8, unaryOperator7, deferredHolder7::get);
            j = new a("SENSOR", 9, properties9 -> {
                return properties9;
            }, null);
            UnaryOperator unaryOperator8 = properties10 -> {
                return properties10.component(MCTechDataComponent.REDSTONE_TIMER_FILTER, m.a);
            };
            DeferredHolder<MenuType<?>, MenuType<n>> deferredHolder8 = MCTechMenus.REDSTONE_TIMER_FILTER;
            Objects.requireNonNull(deferredHolder8);
            k = new a("TIMER", 10, unaryOperator8, deferredHolder8::get);
            n = c();
        }

        private a(String str, @Nullable int i2, UnaryOperator unaryOperator, Supplier supplier) {
            super(str, i2);
            this.l = unaryOperator;
            this.m = supplier;
        }

        public UnaryOperator<Item.Properties> a() {
            return this.l;
        }

        @Nullable
        public MenuType<?> b() {
            if (this.m == null) {
                return null;
            }
            return this.m.get();
        }
    }
}
