package mctech.blockentities.b;

import mctech.MCTech;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.DirectionList;
import mctech.m.b.G;
import mctech.m.b.S;
import mctech.m.g.y;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/b.class */
public class b extends mctech.blockentities.g {

    @NetworkInfo(fieldName = "maxFuel")
    int h;

    public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 2);
        this.h = 0;
        this.c = 4000;
        this.d = MCTech.CONFIG.generatorOutput.get();
        this.inventoryManager.a().a(new y(mctech.m.e.k.q, 0).a(DirectionList.ALL).a(mctech.m.e.a.BOTH).a(mctech.m.c.a.c.a)).a(y.a(1).a(mctech.m.e.a.BOTH).a(mctech.m.c.a.f.a).b(mctech.m.c.a.f.c)).i();
        addGuiFields(this);
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return this.h;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new G(this, player, i);
    }

    @Override // mctech.blockentities.g
    public boolean d() {
        return this.a > 0;
    }

    @Override // mctech.api.tiles.readers.IEUProducer
    public float getEUProduction() {
        if (this.a > 0) {
            return this.d;
        }
        return 0.0f;
    }
}
