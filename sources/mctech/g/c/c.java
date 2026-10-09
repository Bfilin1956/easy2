package mctech.g.c;

import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/c.class */
public class c implements BlockColor, ItemColor {
    public static final c a = new c();

    private c() {
    }

    public int getColor(BlockState blockState, @Nullable BlockAndTintGetter blockAndTintGetter, @Nullable BlockPos blockPos, int i) {
        int color;
        if (i >= 0) {
            return DyeColor.values()[i].getTextureDiffuseColor();
        }
        int iB = b(i);
        if (blockAndTintGetter != null && blockPos != null) {
            BlockEntity blockEntity = blockAndTintGetter.getBlockEntity(blockPos);
            if (blockEntity instanceof mctech.g.d.a.a.b) {
                mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
                if (bVar.e()) {
                    Block blockF = bVar.f();
                    if (mctech.g.c.b.b.a.a() && (color = Minecraft.getInstance().getBlockColors().getColor(blockF.defaultBlockState(), blockAndTintGetter, blockPos, iB)) != -1) {
                        return color;
                    }
                    return 16777215;
                }
                return 16777215;
            }
            return 16777215;
        }
        return 16777215;
    }

    public int getColor(ItemStack itemStack, int i) {
        return 0;
    }

    public static int a(int i) {
        return (-i) - 2;
    }

    public static int b(int i) {
        if (i > 0) {
            return i;
        }
        return (-i) - 2;
    }
}
