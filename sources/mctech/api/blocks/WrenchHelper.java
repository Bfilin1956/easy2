package mctech.api.blocks;

import mctech.api.items.readers.IWrenchTool;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/WrenchHelper.class */
public class WrenchHelper {
    public static boolean hasWrench(Player player) {
        return isWrench(player.getMainHandItem()) || isWrench(player.getOffhandItem());
    }

    public static boolean isWrench(ItemStack itemStack) {
        IWrenchTool item = itemStack.getItem();
        if ((item instanceof IWrenchTool) && item.shouldRenderOverlay(itemStack)) {
            return true;
        }
        return false;
    }

    public static int getDirectionIndex(BlockHitResult blockHitResult) {
        return getDirectionIndex(blockHitResult.getDirection(), blockHitResult.getLocation().subtract(Vec3.atLowerCornerOf(blockHitResult.getBlockPos())));
    }

    public static int getDirectionIndex(UseOnContext useOnContext) {
        return getDirectionIndex(useOnContext.getClickedFace(), useOnContext.getClickLocation().subtract(Vec3.atLowerCornerOf(useOnContext.getClickedPos())));
    }

    /* JADX INFO: renamed from: mctech.api.blocks.WrenchHelper$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/WrenchHelper$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$net$minecraft$core$Direction$Axis = new int[Direction.Axis.values().length];

        static {
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.X.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.Y.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$net$minecraft$core$Direction$Axis[Direction.Axis.Z.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static int getDirectionIndex(Direction direction, Vec3 vec3) {
        switch (AnonymousClass1.$SwitchMap$net$minecraft$core$Direction$Axis[direction.getAxis().ordinal()]) {
            case 1:
                return calculateIndex(direction == Direction.EAST ? 1.0d - vec3.z() : vec3.z(), 1.0d - vec3.y());
            case 2:
                return calculateIndex(vec3.x(), direction == Direction.DOWN ? 1.0d - vec3.z() : vec3.z());
            case 3:
                return calculateIndex(direction == Direction.NORTH ? 1.0d - vec3.x() : vec3.x(), 1.0d - vec3.y());
            default:
                return 0;
        }
    }

    public static Direction getFacingFromIndex(Direction direction, int i, Player player) {
        if (direction.getAxis().isHorizontal()) {
            switch (i) {
                case 1:
                    return player.isShiftKeyDown() ? direction.getOpposite() : direction;
                case 2:
                    return Direction.DOWN;
                case 4:
                    return Direction.UP;
                case 8:
                    return direction.getClockWise();
                case 16:
                    return direction.getCounterClockWise();
                default:
                    return null;
            }
        }
        switch (i) {
            case 1:
                return player.isShiftKeyDown() ? direction.getOpposite() : direction;
            case 2:
                return direction == Direction.DOWN ? Direction.NORTH : Direction.SOUTH;
            case 4:
                return direction == Direction.DOWN ? Direction.SOUTH : Direction.NORTH;
            case 8:
                return Direction.WEST;
            case 16:
                return Direction.EAST;
            default:
                return null;
        }
    }

    private static int calculateIndex(double d, double d2) {
        if (d >= 0.2d && d <= 0.8d && d2 >= 0.2d && d2 <= 0.8d) {
            return 1;
        }
        if (d < 0.2d || d > 0.8d) {
            if (d2 < 0.2d || d2 > 0.8d) {
                if (d > 0.8d) {
                    if (d2 > 0.5d) {
                        if (d2 <= d) {
                            return d < 0.5d ? 8 : 16;
                        }
                    } else if (d2 >= 1.0d - d) {
                        return d < 0.5d ? 8 : 16;
                    }
                }
                if (d < 0.2d) {
                    if (d2 > 0.5d) {
                    }
                }
            }
            return d < 0.5d ? 8 : 16;
        }
        if (d2 >= 0.2d && d2 <= 0.8d) {
            return 0;
        }
        if (d < 0.2d || d > 0.8d) {
            if (d2 > 0.8d) {
                if (d > 0.5d) {
                    if (d <= d2) {
                        return d2 < 0.5d ? 4 : 2;
                    }
                } else if (d >= 1.0d - d2) {
                    return d2 < 0.5d ? 4 : 2;
                }
            }
            if (d2 >= 0.2d) {
                return 0;
            }
            if (d > 0.5d) {
                if (d > 1.0d - d2) {
                    return 0;
                }
            } else if (d < d2) {
                return 0;
            }
        }
        return d2 < 0.5d ? 4 : 2;
    }
}
