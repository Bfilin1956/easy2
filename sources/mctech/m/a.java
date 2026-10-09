package mctech.m;

import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.m.a.d;
import mctech.m.b.AbstractC0160t;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/a.class */
public class a {
    public static final Supplier<String> a = () -> {
        return "container";
    };
    public static final Supplier<String> b = () -> {
        return "components";
    };

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, MachineTier machineTier) {
        return a(abstractC0160t, machineTier.asIntegerString());
    }

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, int i) {
        return a(abstractC0160t, String.valueOf(i));
    }

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, String str) {
        return a(abstractC0160t, str, (Supplier<String>) null);
    }

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, MachineTier machineTier, @Nullable Supplier<String> supplier) {
        return a(abstractC0160t, machineTier.asIntegerString(), supplier);
    }

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, MachineTier machineTier, @Nullable String str) {
        return a(abstractC0160t, machineTier, (Supplier<String>) () -> {
            return str;
        });
    }

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, int i, @Nullable String str) {
        return a(abstractC0160t, i, (Supplier<String>) () -> {
            return str;
        });
    }

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, int i, @Nullable Supplier<String> supplier) {
        return a(abstractC0160t, String.valueOf(i), supplier);
    }

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, String str, @Nullable String str2) {
        return a(abstractC0160t, str, (Supplier<String>) () -> {
            return str2;
        });
    }

    @Nullable
    public static <Gui extends d> ResourceLocation a(@Nonnull AbstractC0160t<Gui> abstractC0160t, String str, @Nullable Supplier<String> supplier) {
        BlockEntity holder = abstractC0160t.getHolder();
        if (holder instanceof BlockEntity) {
            String strReplaceAll = BuiltInRegistries.BLOCK.getKey(holder.getBlockState().getBlock()).getPath().replaceAll("_?t[0-9]{1,}_?", "").replaceAll("_?[0-9]{1,}_?", "").replaceAll("_?stone_?", "");
            if (supplier != null) {
                strReplaceAll = supplier.get();
            }
            return MCTech.loc(String.format("textures/gui/container/t%s/gui_%s_t%s.png", str, strReplaceAll, str));
        }
        return null;
    }

    public static ResourceLocation a(String str, MachineTier machineTier) {
        return a(str, machineTier.asIntegerString());
    }

    public static ResourceLocation a(String str, int i) {
        return a(str, String.valueOf(i));
    }

    public static ResourceLocation a(String str, String str2) {
        return MCTech.loc(String.format("textures/gui/container/t%s/gui_%s_t%s.png", str2, str, str2));
    }

    public static ResourceLocation a(@Nonnull Supplier<String> supplier, @Nonnull String str, MachineTier machineTier) {
        return a(supplier, str, machineTier.asIntegerString());
    }

    public static ResourceLocation a(@Nonnull Supplier<String> supplier, @Nonnull String str, int i) {
        return a(supplier, str, String.valueOf(i));
    }

    public static ResourceLocation a(@Nonnull Supplier<String> supplier, @Nonnull String str, @Nonnull String str2) {
        return MCTech.loc(String.format("textures/gui/%s/%s_t%s.png", supplier.get(), str, str2));
    }
}
