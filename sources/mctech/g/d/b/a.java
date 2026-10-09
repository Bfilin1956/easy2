package mctech.g.d.b;

import java.util.List;
import java.util.Optional;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/b/a.class */
public abstract class a<T> extends Item implements mctech.g.a.e.a {
    public static final ICapabilityProvider<ItemStack, Void, mctech.g.a.e.a> b = (itemStack, r3) -> {
        return (a) itemStack.getItem();
    };

    protected abstract DataComponentType<T> a();

    protected abstract T c();

    protected abstract AbstractContainerMenu a(int i, Inventory inventory, mctech.g.d.a.b.a.InterfaceC0013a interfaceC0013a);

    public a(Item.Properties properties) {
        super(properties);
    }

    protected T a(ItemStack itemStack) {
        return (T) itemStack.getOrDefault(a(), c());
    }

    @NotNull
    public InteractionResultHolder<ItemStack> use(@NotNull Level level, Player player, @NotNull InteractionHand interactionHand) {
        if (player.isSteppingCarefully() && (player instanceof ServerPlayer)) {
            final ItemStack itemInHand = player.getItemInHand(interactionHand);
            ((ServerPlayer) player).openMenu(new MenuProvider() { // from class: mctech.g.d.b.a.1
                @NotNull
                public Component getDisplayName() {
                    return a.this.getName(itemInHand);
                }

                public AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player2) {
                    return a.this.a(i, inventory, new mctech.g.d.a.b.a.b(player2, itemInHand));
                }
            });
        }
        return super.use(level, player, interactionHand);
    }

    @Override // mctech.g.a.e.a
    public void a(ServerPlayer serverPlayer, final IItemHandlerModifiable iItemHandlerModifiable, final int i, @Nullable final Runnable runnable) {
        final ItemStack stackInSlot = iItemHandlerModifiable.getStackInSlot(i);
        serverPlayer.openMenu(new MenuProvider() { // from class: mctech.g.d.b.a.2
            @NotNull
            public Component getDisplayName() {
                return a.this.getName(stackInSlot);
            }

            public AbstractContainerMenu createMenu(int i2, @NotNull Inventory inventory, @NotNull Player player) {
                return a.this.a(i2, inventory, new mctech.g.d.a.b.a.c(stackInSlot, iItemHandlerModifiable, i, runnable));
            }

            public boolean shouldTriggerClientSideContainerClosingOnOpen() {
                return false;
            }
        });
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    public void appendHoverText(@NotNull ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) throws MatchException {
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
        Object orDefault = itemStack.getOrDefault(a(), c());
        if (!orDefault.equals(c())) {
            if (orDefault instanceof mctech.g.d.a.b.b.a) {
                mctech.g.d.a.b.b.a aVar = (mctech.g.d.a.b.b.a) orDefault;
                try {
                    aVar.a();
                    boolean zB = aVar.b();
                    boolean zC = aVar.c();
                    mctech.g.d.a.b.b bVarD = aVar.d();
                    list.add(Component.literal("Сравнивает NBT: ").withStyle(ChatFormatting.GRAY).append(zC ? Component.literal("Да").withStyle(ChatFormatting.DARK_GREEN) : Component.literal("Нет").withStyle(ChatFormatting.DARK_RED)));
                    list.add(Component.literal("Сравнение NBT: ").withStyle(ChatFormatting.GRAY).append(bVarD.a().copy().withStyle(ChatFormatting.LIGHT_PURPLE)));
                    list.add(Component.literal("Список: ").withStyle(ChatFormatting.GRAY).append(zB ? Component.literal("Черный").withStyle(ChatFormatting.DARK_GRAY) : Component.literal("Белый").withStyle(ChatFormatting.WHITE)));
                    return;
                } catch (Throwable th) {
                    throw new MatchException(th.toString(), th);
                }
            }
            if (orDefault instanceof mctech.g.d.a.b.a.a) {
                mctech.g.d.a.b.a.a aVar2 = (mctech.g.d.a.b.a.a) orDefault;
                list.add(Component.literal("Сравнивает NBT: ").withStyle(ChatFormatting.GRAY).append(aVar2.c() ? Component.literal("Да").withStyle(ChatFormatting.DARK_GREEN) : Component.literal("Нет").withStyle(ChatFormatting.DARK_RED)));
                list.add(Component.literal("Список: ").withStyle(ChatFormatting.GRAY).append(aVar2.b() ? Component.literal("Черный").withStyle(ChatFormatting.DARK_GRAY) : Component.literal("Белый").withStyle(ChatFormatting.WHITE)));
            }
        }
    }

    @NotNull
    public Optional<TooltipComponent> getTooltipImage(@NotNull ItemStack itemStack) {
        Object orDefault = itemStack.getOrDefault(a(), c());
        if (!orDefault.equals(c())) {
            if (orDefault instanceof mctech.g.d.a.b.b.a) {
                return Optional.of(new mctech.v.i.b.C0049b(((mctech.g.d.a.b.b.a) orDefault).a()));
            }
            if (orDefault instanceof mctech.g.d.a.b.a.a) {
                return Optional.of(new mctech.v.i.b.a(((mctech.g.d.a.b.a.a) orDefault).a()));
            }
        }
        return super.getTooltipImage(itemStack);
    }
}
