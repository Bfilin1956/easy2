package mctech.g.d.a.c;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import mctech.g.a.c.e;
import mctech.g.b.a.t;
import mctech.g.b.a.y;
import mctech.init.MCTechMenus;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import net.neoforged.neoforge.network.PacketDistributor;
import org.apache.commons.lang3.NotImplementedException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector2i;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/c/a.class */
public class a extends mctech.g.b.b {
    public static final int b = 0;
    public static final int c = 9;
    private final BlockPos d;
    private final Holder<mctech.g.a.a<?, ?>> e;
    private final Direction f;
    private final c g;

    @Nullable
    private final IItemHandlerModifiable h;
    private mctech.g.a.c.c i;
    private CompoundTag j;
    private int k;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/c/a$c.class */
    public interface c {
        List<Holder<mctech.g.a.a<?, ?>>> c(Direction direction);

        mctech.g.a.c.c c(Holder<mctech.g.a.a<?, ?>> holder, Direction direction);

        void a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, mctech.g.a.c.c cVar);

        boolean e(Holder<mctech.g.a.a<?, ?>> holder, Direction direction);

        @Nullable
        CompoundTag a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction);

        boolean a(Player player);
    }

    public static void a(ServerPlayer serverPlayer, mctech.g.d.a.a.b bVar, Direction direction, Holder<mctech.g.a.a<?, ?>> holder) {
        serverPlayer.openMenu(new d(bVar, direction, holder), registryFriendlyByteBuf -> {
            registryFriendlyByteBuf.writeBlockPos(bVar.getBlockPos());
            registryFriendlyByteBuf.writeEnum(direction);
            mctech.g.a.a.c.encode(registryFriendlyByteBuf, holder);
            b.a(bVar, holder, direction, registryFriendlyByteBuf);
        });
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.commons.lang3.NotImplementedException */
    public a(int i, Inventory inventory, mctech.g.d.a.a.b bVar, Holder<mctech.g.a.a<?, ?>> holder, Direction direction) throws NotImplementedException {
        super((MenuType) MCTechMenus.CONDUIT_MENU.get(), i, inventory);
        this.d = bVar.getBlockPos();
        this.f = direction;
        this.e = holder;
        this.g = bVar;
        this.i = ((mctech.g.a.a) holder.value()).f().a();
        this.h = bVar.d(holder, direction);
        j();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.commons.lang3.NotImplementedException */
    public a(int i, Inventory inventory, RegistryFriendlyByteBuf registryFriendlyByteBuf) throws NotImplementedException {
        super((MenuType) MCTechMenus.CONDUIT_MENU.get(), i, inventory);
        this.d = registryFriendlyByteBuf.readBlockPos();
        this.f = registryFriendlyByteBuf.readEnum(Direction.class);
        this.e = (Holder) mctech.g.a.a.c.decode(registryFriendlyByteBuf);
        this.g = new b(registryFriendlyByteBuf);
        if (((mctech.g.a.a) this.e.value()).k() > 0) {
            this.h = new C0014a();
        } else {
            this.h = null;
        }
        j();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: org.apache.commons.lang3.NotImplementedException */
    private void j() throws NotImplementedException {
        if (this.h != null) {
            for (int i = 0; i < ((mctech.g.a.a) this.e.value()).k(); i++) {
                Vector2i vector2iA = ((mctech.g.a.a) this.e.value()).a(i);
                addSlot(new SlotItemHandler(this.h, i, vector2iA.x, vector2iA.y));
            }
        }
        a(33, 127);
    }

    public BlockPos b() {
        return this.d;
    }

    public Direction c() {
        return this.f;
    }

    public Holder<mctech.g.a.a<?, ?>> d() {
        return this.e;
    }

    public List<Holder<mctech.g.a.a<?, ?>>> e() {
        return this.g.c(this.f);
    }

    @Nullable
    public IItemHandler f() {
        return this.h;
    }

    public void a(List<Holder<mctech.g.a.a<?, ?>>> list) {
        c cVar = this.g;
        if (cVar instanceof b) {
            ((b) cVar).a = list;
        }
    }

    public e<?> g() {
        return ((mctech.g.a.a) this.e.value()).f();
    }

    public mctech.g.a.c.c h() {
        return this.g.c(this.e, this.f);
    }

    public <T extends mctech.g.a.c.c> T a(e<T> eVar) {
        T t = (T) h();
        if (t.a() == eVar) {
            return t;
        }
        throw new IllegalStateException("Connection config type mismatch");
    }

    public void a(mctech.g.a.c.c cVar) {
        LocalPlayer localPlayer = a().player;
        if (localPlayer instanceof LocalPlayer) {
            if (!localPlayer.isSpectator()) {
                this.g.a(this.e, this.f, cVar);
                PacketDistributor.sendToServer(new y(this.containerId, cVar), new CustomPacketPayload[0]);
                return;
            }
            return;
        }
        this.g.a(this.e, this.f, cVar);
    }

    public void a(y yVar) {
        this.g.a(this.e, this.f, yVar.b());
    }

    @Nullable
    public CompoundTag i() {
        return this.g.a(this.e, this.f);
    }

    public void a(CompoundTag compoundTag) {
        c cVar = this.g;
        if (cVar instanceof b) {
            ((b) cVar).c = compoundTag;
        }
    }

    public boolean stillValid(@NotNull Player player) {
        return this.g.a(player) && this.g.e(this.e, this.f);
    }

    public boolean clickMenuButton(@NotNull Player player, int i) {
        if (player instanceof ServerPlayer) {
            ServerPlayer serverPlayer = (ServerPlayer) player;
            if (i >= 0 && i <= 18) {
                int i2 = i - 0;
                List<Holder<mctech.g.a.a<?, ?>>> listE = e();
                if (i2 < listE.size()) {
                    c cVar = this.g;
                    if (cVar instanceof mctech.g.d.a.a.b) {
                        a(serverPlayer, (mctech.g.d.a.a.b) cVar, this.f, listE.get(i2));
                    }
                }
            }
        }
        return super.clickMenuButton(player, i);
    }

    @NotNull
    public ItemStack quickMoveStack(@NotNull Player player, int i) {
        return ItemStack.EMPTY;
    }

    public void a(int i) {
        if (this.h == null) {
            return;
        }
        ServerPlayer serverPlayer = a().player;
        if (serverPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = serverPlayer;
            mctech.g.a.e.a aVar = (mctech.g.a.e.a) this.h.getStackInSlot(i).getCapability(mctech.g.a.d.f);
            if (aVar != null) {
                aVar.a(serverPlayer2, this.h, i, () -> {
                    a(serverPlayer2, (mctech.g.d.a.a.b) this.g, this.f, this.e);
                });
                return;
            }
            return;
        }
        PacketDistributor.sendToServer(new t(this.containerId, i), new CustomPacketPayload[0]);
    }

    @Override // mctech.g.b.b
    public void broadcastChanges() {
        super.broadcastChanges();
        ServerPlayer serverPlayer = a().player;
        if (serverPlayer instanceof ServerPlayer) {
            ServerPlayer serverPlayer2 = serverPlayer;
            if (stillValid(serverPlayer2)) {
                if (!Objects.equals(h(), this.i)) {
                    PacketDistributor.sendToPlayer(serverPlayer2, new y(this.containerId, h()), new CustomPacketPayload[0]);
                    this.i = h();
                }
                CompoundTag compoundTagI = i();
                if (!Objects.equals(compoundTagI, this.j)) {
                    PacketDistributor.sendToPlayer(serverPlayer2, new mctech.g.b.a.b(this.containerId, compoundTagI), new CustomPacketPayload[0]);
                    this.j = compoundTagI;
                }
                List<Holder<mctech.g.a.a<?, ?>>> listC = this.g.c(this.f);
                if (this.k != listC.hashCode()) {
                    PacketDistributor.sendToPlayer(serverPlayer2, new mctech.g.b.a.c(this.containerId, listC), new CustomPacketPayload[0]);
                    this.k = listC.hashCode();
                }
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/c/a$b.class */
    private static class b implements c {
        private List<Holder<mctech.g.a.a<?, ?>>> a;
        private mctech.g.a.c.c b;

        @Nullable
        private CompoundTag c;

        public b(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            this.a = (List) mctech.g.a.a.c.apply(ByteBufCodecs.list(9)).decode(registryFriendlyByteBuf);
            this.b = (mctech.g.a.c.c) mctech.g.a.c.c.b.decode(registryFriendlyByteBuf);
            this.c = (CompoundTag) ByteBufCodecs.optional(ByteBufCodecs.COMPOUND_TAG).map(optional -> {
                return (CompoundTag) optional.orElse(null);
            }, (v0) -> {
                return Optional.ofNullable(v0);
            }).decode(registryFriendlyByteBuf);
        }

        private static void a(mctech.g.d.a.a.b bVar, Holder<mctech.g.a.a<?, ?>> holder, Direction direction, RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            mctech.g.a.a.c.apply(ByteBufCodecs.list(9)).encode(registryFriendlyByteBuf, bVar.c(direction));
            mctech.g.a.c.c.b.encode(registryFriendlyByteBuf, bVar.c(holder, direction));
            ByteBufCodecs.optional(ByteBufCodecs.COMPOUND_TAG).map(optional -> {
                return (CompoundTag) optional.orElse(null);
            }, (v0) -> {
                return Optional.ofNullable(v0);
            }).encode(registryFriendlyByteBuf, bVar.a(holder, direction));
        }

        @Override // mctech.g.d.a.c.a.c
        public List<Holder<mctech.g.a.a<?, ?>>> c(Direction direction) {
            return this.a;
        }

        @Override // mctech.g.d.a.c.a.c
        public mctech.g.a.c.c c(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
            return this.b;
        }

        @Override // mctech.g.d.a.c.a.c
        public void a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, mctech.g.a.c.c cVar) {
            this.b = cVar;
        }

        @Override // mctech.g.d.a.c.a.c
        public boolean e(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
            return true;
        }

        @Override // mctech.g.d.a.c.a.c
        public CompoundTag a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
            return this.c;
        }

        @Override // mctech.g.d.a.c.a.c
        public boolean a(Player player) {
            return true;
        }
    }

    /* JADX INFO: renamed from: mctech.g.d.a.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/c/a$a.class */
    private class C0014a extends ItemStackHandler {
        private C0014a() {
            super(((mctech.g.a.a) a.this.e.value()).k());
        }

        public boolean isItemValid(int i, @NotNull ItemStack itemStack) {
            return ((mctech.g.a.a) a.this.e.value()).a(i, itemStack);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/c/a$d.class */
    private static final class d extends Record implements MenuProvider {
        private final mctech.g.d.a.a.b a;
        private final Direction b;
        private final Holder<mctech.g.a.a<?, ?>> c;

        private d(mctech.g.d.a.a.b bVar, Direction direction, Holder<mctech.g.a.a<?, ?>> holder) {
            this.a = bVar;
            this.b = direction;
            this.c = holder;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, d.class), d.class, "conduitBundle;side;conduit", "FIELD:Lmctech/g/d/a/c/a$d;->a:Lmctech/g/d/a/a/b;", "FIELD:Lmctech/g/d/a/c/a$d;->b:Lnet/minecraft/core/Direction;", "FIELD:Lmctech/g/d/a/c/a$d;->c:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, d.class), d.class, "conduitBundle;side;conduit", "FIELD:Lmctech/g/d/a/c/a$d;->a:Lmctech/g/d/a/a/b;", "FIELD:Lmctech/g/d/a/c/a$d;->b:Lnet/minecraft/core/Direction;", "FIELD:Lmctech/g/d/a/c/a$d;->c:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, d.class, Object.class), d.class, "conduitBundle;side;conduit", "FIELD:Lmctech/g/d/a/c/a$d;->a:Lmctech/g/d/a/a/b;", "FIELD:Lmctech/g/d/a/c/a$d;->b:Lnet/minecraft/core/Direction;", "FIELD:Lmctech/g/d/a/c/a$d;->c:Lnet/minecraft/core/Holder;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public mctech.g.d.a.a.b a() {
            return this.a;
        }

        public Direction b() {
            return this.b;
        }

        public Holder<mctech.g.a.a<?, ?>> c() {
            return this.c;
        }

        @NotNull
        public Component getDisplayName() {
            return ((mctech.g.a.a) this.c.value()).b();
        }

        public AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory, @NotNull Player player) {
            return new a(i, inventory, this.a, this.c, this.b);
        }

        public boolean shouldTriggerClientSideContainerClosingOnOpen() {
            return false;
        }
    }
}
