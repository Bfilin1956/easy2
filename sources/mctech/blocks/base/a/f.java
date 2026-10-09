package mctech.blocks.base.a;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/f.class */
public interface f {
    float a(BlockState blockState);

    VoxelShape[] a(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos);

    int b(BlockState blockState);

    DyeColor c(BlockState blockState);

    static Direction a(Vec3 vec3, Direction direction, float f) {
        float f2 = 0.5f - f;
        float f3 = 0.5f + f;
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= f2 && vec3.z <= f3) {
            return direction;
        }
        if (vec3.x >= 0.0d && vec3.x <= f2 && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= f2 && vec3.z <= f3) {
            return Direction.WEST;
        }
        if (vec3.x >= f3 && vec3.x <= 1.0d && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= f2 && vec3.z <= f3) {
            return Direction.EAST;
        }
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= 0.0d && vec3.y <= f2 && vec3.z >= f2 && vec3.z <= f3) {
            return Direction.DOWN;
        }
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= f3 && vec3.y <= 1.0d && vec3.z >= f2 && vec3.z <= f3) {
            return Direction.UP;
        }
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= 0.0d && vec3.z <= f2) {
            return Direction.NORTH;
        }
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= f3 && vec3.z <= 1.0d) {
            return Direction.SOUTH;
        }
        return null;
    }

    static AABB b(Vec3 vec3, Direction direction, float f) {
        float f2 = 0.5f - f;
        float f3 = 0.5f + f;
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= f2 && vec3.z <= f3) {
            return new AABB(f2, f2, f2, f3, f3, f3);
        }
        if (vec3.x >= 0.0d && vec3.x <= f2 && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= f2 && vec3.z <= f3) {
            return new AABB(0.0d, f2, f2, f2, f3, f3);
        }
        if (vec3.x >= f3 && vec3.x <= 1.0d && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= f2 && vec3.z <= f3) {
            return new AABB(f3, f2, f2, 1.0d, f3, f3);
        }
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= 0.0d && vec3.y <= f2 && vec3.z >= f2 && vec3.z <= f3) {
            return new AABB(f2, 0.0d, f2, f3, f2, f3);
        }
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= f3 && vec3.y <= 1.0d && vec3.z >= f2 && vec3.z <= f3) {
            return new AABB(f2, f3, f2, f3, 1.0d, f3);
        }
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= 0.0d && vec3.z <= f2) {
            return new AABB(f2, f2, 0.0d, f3, f3, f2);
        }
        if (vec3.x >= f2 && vec3.x <= f3 && vec3.y >= f2 && vec3.y <= f3 && vec3.z >= f3 && vec3.z <= 1.0d) {
            return new AABB(f2, f2, f3, f3, f3, 1.0d);
        }
        return null;
    }
}
