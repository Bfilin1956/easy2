package mctech.utils.e;

import com.google.common.collect.ObjectArrays;
import mctech.MCTech;
import mctech.utils.c.g;
import net.minecraft.ChatFormatting;
import net.minecraft.client.KeyMapping;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/b.class */
public interface b {
    default MutableComponent A() {
        return Component.empty();
    }

    default MutableComponent e(String str) {
        return Component.literal(str);
    }

    default MutableComponent c(String str, ChatFormatting... chatFormattingArr) {
        return Component.literal(str).withStyle(chatFormattingArr);
    }

    default MutableComponent f(String str) {
        return Component.translatable(str);
    }

    default MutableComponent d(String str, ChatFormatting... chatFormattingArr) {
        return Component.translatable(str).withStyle(chatFormattingArr);
    }

    default MutableComponent c(String str, Object... objArr) {
        return Component.translatable(str, objArr);
    }

    default MutableComponent a(String str, ChatFormatting chatFormatting, Object... objArr) {
        return Component.translatable(str, objArr).withStyle(chatFormatting);
    }

    default MutableComponent B() {
        return Component.translatable("tooltip.item.mctech.error");
    }

    default MutableComponent b(BlockPos blockPos) {
        return Component.translatable("tooltip.item.mctech.pos", new Object[]{Integer.valueOf(blockPos.getX()), Integer.valueOf(blockPos.getY()), Integer.valueOf(blockPos.getZ())});
    }

    default MutableComponent d(Level level, BlockPos blockPos) {
        return a(level.dimension(), blockPos);
    }

    default MutableComponent a(ResourceKey<Level> resourceKey, BlockPos blockPos) {
        return Component.translatable("tooltip.item.mctech.dim_pos", new Object[]{g.b(resourceKey.location().getPath()), Integer.valueOf(blockPos.getX()), Integer.valueOf(blockPos.getY()), Integer.valueOf(blockPos.getZ())});
    }

    default MutableComponent e(boolean z) {
        return Component.translatable(z ? "misc.mctech.yes" : "misc.mctech.no");
    }

    default MutableComponent h(int i) {
        return Component.translatable("misc.mctech.eu", new Object[]{mctech.utils.c.c.c.format(i)});
    }

    default MutableComponent a(mctech.s.a aVar, Object... objArr) {
        return a(ObjectArrays.concat(MCTech.KEYBOARD.a(aVar).withStyle(ChatFormatting.GOLD), objArr));
    }

    default MutableComponent a(mctech.s.a aVar, String str, Object... objArr) {
        return a(MCTech.KEYBOARD.a(aVar).withStyle(ChatFormatting.GOLD), c(str, objArr).withStyle(ChatFormatting.UNDERLINE));
    }

    default MutableComponent a(mctech.s.a aVar, mctech.s.a aVar2, Object... objArr) {
        return a(ObjectArrays.concat(a(aVar, aVar2), objArr));
    }

    default MutableComponent a(mctech.s.a aVar, mctech.s.a aVar2, String str, Object... objArr) {
        return a(a(aVar, aVar2), c(str, objArr).withStyle(ChatFormatting.UNDERLINE));
    }

    default MutableComponent a(mctech.s.a[] aVarArr, Object... objArr) {
        return a(ObjectArrays.concat(a(aVarArr), objArr));
    }

    default MutableComponent a(mctech.s.a[] aVarArr, String str, Object... objArr) {
        return a(a(aVarArr), c(str, objArr).withStyle(ChatFormatting.UNDERLINE));
    }

    default MutableComponent a(Object... objArr) {
        return Component.translatable("tooltip.mctech.press_key_description", objArr);
    }

    @OnlyIn(Dist.CLIENT)
    default MutableComponent a(KeyMapping... keyMappingArr) {
        MutableComponent mutableComponentEmpty = Component.empty();
        int length = keyMappingArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                mutableComponentEmpty.append(" & ");
            }
            mutableComponentEmpty.append(keyMappingArr[i].getKey().getDisplayName().copy().withStyle(ChatFormatting.GOLD));
        }
        return mutableComponentEmpty;
    }

    default MutableComponent a(mctech.s.a... aVarArr) {
        MutableComponent mutableComponentEmpty = Component.empty();
        int length = aVarArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                mutableComponentEmpty.append(" & ");
            }
            mutableComponentEmpty.append(MCTech.KEYBOARD.a(aVarArr[i]).withStyle(ChatFormatting.GOLD));
        }
        return mutableComponentEmpty;
    }
}
