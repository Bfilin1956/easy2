package mctech.g.d.a.b;

import com.mojang.serialization.Codec;
import io.netty.buffer.ByteBuf;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import mctech.init.MCTechLang;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ByIdMap;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b.class */
public enum b implements StringRepresentable {
    IGNORE(0, "ignore", itemStack -> {
        return true;
    }),
    UP_TO_25(1, "up_to_25", itemStack2 -> {
        return Boolean.valueOf(((float) itemStack2.getDamageValue()) <= ((float) itemStack2.getMaxDamage()) * 0.25f);
    }),
    MORE_THAN_25(2, "more_than_25", itemStack3 -> {
        return Boolean.valueOf(((float) itemStack3.getDamageValue()) > ((float) itemStack3.getMaxDamage()) * 0.25f);
    }),
    UP_TO_50(3, "up_to_50", itemStack4 -> {
        return Boolean.valueOf(((float) itemStack4.getDamageValue()) <= ((float) itemStack4.getMaxDamage()) * 0.5f);
    }),
    MORE_THAN_50(4, "more_than_50", itemStack5 -> {
        return Boolean.valueOf(((float) itemStack5.getDamageValue()) > ((float) itemStack5.getMaxDamage()) * 0.5f);
    }),
    UP_TO_75(5, "up_to_75", itemStack6 -> {
        return Boolean.valueOf(((float) itemStack6.getDamageValue()) <= ((float) itemStack6.getMaxDamage()) * 0.75f);
    }),
    MORE_THAN_75(6, "more_than_75", itemStack7 -> {
        return Boolean.valueOf(((float) itemStack7.getDamageValue()) > ((float) itemStack7.getMaxDamage()) * 0.75f);
    }),
    NOT_DAMAGED(7, "not_damaged", itemStack8 -> {
        return Boolean.valueOf(!itemStack8.isDamaged());
    }),
    ONLY_DAMAGED(8, "only_damaged", (v0) -> {
        return v0.isDamaged();
    }),
    IS_DAMAGEABLE(9, "is_damageable", (v0) -> {
        return v0.isDamageableItem();
    }),
    NOT_DAMAGEABLE(10, "not_damageable", itemStack9 -> {
        return Boolean.valueOf(!itemStack9.isDamageableItem());
    });

    public static final Codec<b> l = StringRepresentable.fromEnum(b::values);
    public static final IntFunction<b> m = ByIdMap.continuous(bVar -> {
        return bVar.o;
    }, values(), ByIdMap.OutOfBoundsStrategy.ZERO);
    public static final StreamCodec<ByteBuf, b> n = ByteBufCodecs.idMapper(m, bVar -> {
        return bVar.o;
    });
    private final int o;
    private final String p;
    private final Function<ItemStack, Boolean> q;

    b(int i, String str, Function function) {
        this.o = i;
        this.p = str;
        this.q = function;
    }

    public boolean a(ItemStack itemStack) {
        return this.q.apply(itemStack).booleanValue();
    }

    public String getSerializedName() {
        return this.p;
    }

    public MutableComponent a() {
        return (MutableComponent) Objects.requireNonNull(MCTechLang.DAMAGE_FILTER_MODE.get(this).copy());
    }
}
