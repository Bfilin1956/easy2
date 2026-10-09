package mctech.blockentities.b;

import java.util.HashMap;
import java.util.Map;
import mctech.m.b.S;
import mctech.m.b.Y;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/d.class */
public abstract class d extends mctech.blockentities.b.a {
    public int y;
    public Map<int[], Integer> z;
    public int[] A;
    public int[] B;
    public int[] C;

    public d(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState, int i) {
        super(blockEntityType, blockPos, blockState, i);
        this.z = new HashMap();
        this.w = true;
    }

    @Override // mctech.blockentities.b.a, mctech.m.a.d
    public S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new Y(this, player, i);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/d$a.class */
    public static class a extends d {
        public a(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 9);
            this.i = 1;
            this.y = 3;
            this.z.put(new int[]{93, 73}, 3);
            this.A = new int[]{160, 73};
            this.B = new int[]{13, 20};
            this.C = new int[]{208, 186};
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T4;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/d$b.class */
    public static class b extends d {
        public b(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 9);
            this.i = 2;
            this.y = 6;
            this.z.put(new int[]{30, 73}, 6);
            this.A = new int[]{160, 73};
            this.B = new int[]{13, 26};
            this.C = new int[]{208, 192};
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T5;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/d$c.class */
    public static class c extends d {
        public c(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 13);
            this.i = 3;
            this.y = 9;
            this.z.put(new int[]{30, 73}, 7);
            this.z.put(new int[]{51, 94}, 1);
            this.z.put(new int[]{135, 94}, 1);
            this.A = new int[]{93, 97};
            this.B = new int[]{13, 50};
            this.C = new int[]{208, 216};
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T6;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/d$e.class */
    public static class e extends d {
        public e(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 17);
            this.i = 4;
            this.y = 12;
            this.z.put(new int[]{30, 73}, 3);
            this.z.put(new int[]{30, 94}, 3);
            this.z.put(new int[]{114, 73}, 3);
            this.z.put(new int[]{114, 94}, 3);
            this.A = new int[]{93, 94};
            this.B = new int[]{13, 50};
            this.C = new int[]{208, 216};
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T7;
        }
    }

    /* JADX INFO: renamed from: mctech.blockentities.b.d$d, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/b/d$d.class */
    public static class C0002d extends d {
        public C0002d(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
            super(blockEntityType, blockPos, blockState, 21);
            this.i = 5;
            this.y = 15;
            this.z.put(new int[]{30, 73}, 7);
            this.z.put(new int[]{30, 94}, 7);
            this.z.put(new int[]{156, 115}, 1);
            this.A = new int[]{135, 115};
            this.B = new int[]{13, 60};
            this.C = new int[]{208, 226};
        }

        @NotNull
        public MachineTier machineTier() {
            return MachineTier.T8;
        }
    }
}
