package mctech.blockentities.c;

import java.util.UUID;
import mctech.MCTech;
import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.network.tile.INetworkDataEventListener;
import mctech.api.network.tile.INetworkEventListener;
import mctech.api.util.DirectionList;
import mctech.init.MCTechTiles;
import mctech.m.b.aK;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.items.ItemStackHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/ag.class */
public class ag extends mctech.blockentities.i implements IWrenchableTile, INetworkDataEventListener, INetworkEventListener, mctech.m.a.k {
    private static final String m = "fakeSlot";
    private static final String n = "ownerUuid";
    private static final String o = "ownerName";
    private static final String p = "tradeMode";
    private static final String q = "showInventory";
    private static final String r = "previewMode";
    private static final String s = "op_shop";
    private static final String t = "disabled";
    private static final String u = "value_0";
    private static final String v = "value_1";

    @NetworkInfo(fieldName = "owner")
    public UUID a;

    @NetworkInfo(fieldName = o)
    public String b;

    @NetworkInfo(fieldName = "mode")
    public int c;

    @NetworkInfo(fieldName = q)
    public boolean d;

    @NetworkInfo(fieldName = "preview")
    public boolean e;

    @NetworkInfo(fieldName = "opShop")
    public boolean f;

    @NetworkInfo(fieldName = t)
    public boolean g;

    @NetworkInfo(fieldName = "busy")
    public boolean h;

    @NetworkInfo(fieldName = "value")
    public float[] i;

    @NetworkInfo(fieldName = "tradeCount")
    public int j;
    public ItemStackHandler k;
    public mctech.m.f.d l;
    private final mctech.m.e.j<ag> w;
    private long x;

    public ag(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.VENDING_MACHINE.get(), blockPos, blockState, 40);
        this.i = new float[2];
        this.k = new ItemStackHandler(2);
        this.l = new mctech.m.f.d(this.k);
        this.x = 0L;
        this.c = 0;
        this.w = new mctech.m.e.j<>(this);
        this.w.a(new mctech.m.g.y(mctech.m.e.k.z, mctech.utils.math.c.a(0, 40)).a(DirectionList.ALL).a(mctech.m.e.a.BOTH));
        this.w.i();
        addNetworkFields(this);
        addGuiFields(q, "value", "opShop", "tradeCount");
    }

    public boolean b(Player player) {
        return player.getUUID().equals(this.a) || MCTech.PLATFORM.a(player.getUUID());
    }

    public boolean a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis < this.x) {
            return false;
        }
        this.x = jCurrentTimeMillis + 500;
        return true;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aK(this, player, i);
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canSetFacing(Direction direction) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public boolean canRemoveBlock(Player player) {
        return true;
    }

    @Override // mctech.api.features.IWrenchableTile
    public double getDropRate(Player player) {
        return 1.0d;
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    private void a(CompoundTag compoundTag, HolderLookup.Provider provider) {
        this.k.deserializeNBT(provider, compoundTag.getCompound(m));
        if (compoundTag.contains(n)) {
            this.a = UUID.fromString(compoundTag.getString(n));
            this.b = compoundTag.getString(o);
        } else {
            this.b = "";
        }
        this.c = compoundTag.getInt(p);
        this.d = compoundTag.getBoolean(q);
        this.e = compoundTag.getBoolean(r);
        this.f = compoundTag.getBoolean(s);
        this.g = compoundTag.getBoolean(t);
    }

    @Override // mctech.blockentities.i
    public void handleUpdateTag(CompoundTag compoundTag, HolderLookup.Provider provider) {
        a(compoundTag, provider);
        super.handleUpdateTag(compoundTag, provider);
    }

    @Override // mctech.api.network.tile.INetworkEventListener
    public void onServerDataReceived(int i, int i2) {
        AbstractContainerMenu abstractContainerMenu = Minecraft.getInstance().player.containerMenu;
        if (abstractContainerMenu instanceof aK) {
            ((aK) abstractContainerMenu).a(i2);
        }
    }

    @Override // mctech.api.network.tile.INetworkDataEventListener
    public void onDataBufferReceived(Player player, String str, INetworkDataBuffer iNetworkDataBuffer, Dist dist) {
        if (iNetworkDataBuffer instanceof a) {
            a aVar = (a) iNetworkDataBuffer;
            this.i[0] = aVar.a;
            this.i[1] = aVar.b;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/ag$a.class */
    public static class a implements INetworkDataBuffer {
        private float a;
        private float b;

        public a(float f, float f2) {
            this.a = f <= 0.0f ? 1.0f : f;
            this.b = f2 <= 0.0f ? 1.0f : f2;
        }

        public a() {
            this(1.0f, 1.0f);
        }

        @Override // mctech.api.network.buffer.INetworkDataBuffer
        public void write(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            registryFriendlyByteBuf.writeFloat(this.a);
            registryFriendlyByteBuf.writeFloat(this.b);
        }

        @Override // mctech.api.network.buffer.INetworkDataBuffer
        public void read(RegistryFriendlyByteBuf registryFriendlyByteBuf) {
            float f = registryFriendlyByteBuf.readFloat();
            float f2 = registryFriendlyByteBuf.readFloat();
            this.a = f <= 0.0f ? 1.0f : f;
            this.b = f2 <= 0.0f ? 1.0f : f2;
        }
    }
}
