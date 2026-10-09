package mctech.blockentities.b;

import mctech.api.features.IWrenchableTile;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.blockentities.q;
import mctech.m.b.C0140am;
import mctech.m.b.S;
import mctech.m.f.m;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/g.class */
public class g extends q implements IWrenchableTile, mctech.m.a.k {

    @NetworkInfo(fieldName = "size")
    @GuiField(fieldName = "size")
    public int a;
    public m b;

    @NetworkInfo(fieldName = "enabled")
    @GuiField(fieldName = "enabled")
    public boolean c;

    @NetworkInfo(fieldName = "exploded")
    @GuiField(fieldName = "exploded")
    public boolean d;

    @NetworkInfo(fieldName = "energy")
    @GuiField(fieldName = "energy")
    public double e;

    @NetworkInfo(fieldName = "coolantTank")
    @GuiField(fieldName = "coolantTank")
    public mctech.fluid.h<?> f;

    public g(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
        this.b = new m(66).a(1);
        this.f = new mctech.fluid.h(8000).a(true).b(true);
        addGuiFields(this);
        addNetworkFields(this);
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new C0140am(this, player, i);
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

    @Override // mctech.m.a.k, mctech.m.a.d
    @OnlyIn(Dist.CLIENT)
    public Screen a(Player player, InteractionHand interactionHand, Direction direction, S s) {
        return new mctech.w.j((C0140am) s);
    }
}
