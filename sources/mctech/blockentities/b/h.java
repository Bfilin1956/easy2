package mctech.blockentities.b;

import java.util.Random;
import mctech.MCTech;
import mctech.api.network.buffer.NetworkInfo;
import mctech.init.MCTechItems;
import mctech.m.b.S;
import mctech.m.b.as;
import mctech.m.g.y;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/h.class */
public class h extends mctech.blockentities.g {
    int h;
    boolean i;

    @NetworkInfo(fieldName = "maxFuel")
    int j;

    public h(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 3);
        this.h = 0;
        this.j = 0;
        this.e = 2;
        this.d = MCTech.CONFIG.slagGenOutput.get();
        this.c = 8000;
        this.h = 80 + new Random().nextInt(160);
        this.inventoryManager.a().a(y.c(0)).a(y.a(1).a(mctech.m.c.a.f.a).b(mctech.m.c.a.f.c)).a(y.d(2)).i();
        addGuiFields(this);
    }

    @Override // mctech.api.tiles.readers.IFuelStorage
    public int getMaxFuel() {
        return this.j;
    }

    @Override // mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new as(this, player, i);
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

    @Override // mctech.blockentities.g
    public boolean e() {
        if (super.e()) {
            if (this.i) {
                return true;
            }
            int i = this.h - 1;
            this.h = i;
            if (i <= 0) {
                this.h = j();
                setOrGrow(2, new ItemStack((ItemLike) MCTechItems.SCRAP.get()), true);
                return true;
            }
            return true;
        }
        return false;
    }

    public int j() {
        return 80 + this.level.random.nextInt(160);
    }
}
