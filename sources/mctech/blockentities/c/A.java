package mctech.blockentities.c;

import mctech.MCTech;
import mctech.api.util.DirectionList;
import mctech.init.MCTechTiles;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/A.class */
public class A extends mctech.blockentities.t {
    private final mctech.m.e.j<A> f;

    public A(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.ITEM_DUPLICATOR.get(), blockPos, blockState);
    }

    public A(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 2);
        this.f = new mctech.m.e.j<>(this);
        this.f.a(new mctech.m.g.y(mctech.m.e.k.b, 0).a(DirectionList.ALL).a(mctech.m.e.a.DISABLED).a(mctech.m.c.r.d));
        this.f.a(new mctech.m.g.y(mctech.m.e.k.l, 1).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        this.f.i();
        addGuiFields(this);
        addNetworkFields(this);
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.ITEM_DUPLICATOR.get();
    }

    @Override // mctech.blockentities.t
    public void a() {
        this.c = this.f.g();
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.R(this, player, i);
    }

    public ResourceLocation d() {
        return MCTech.loc("textures/gui/container/gui_item_duplicator.png");
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.NONE;
    }

    @Override // mctech.blockentities.q
    public boolean isActive() {
        return true;
    }
}
