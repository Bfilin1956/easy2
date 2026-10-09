package mctech.g.f;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import mctech.init.MCTechConduitTypes;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.DyeColor;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/f/j.class */
@Deprecated(since = "8.0.0")
public class j implements a<j> {
    public static final MapCodec<j> a = RecordCodecBuilder.mapCodec(instance -> {
        return instance.group(Codec.BOOL.fieldOf("is_active").forGetter(jVar -> {
            return Boolean.valueOf(jVar.d);
        }), Codec.unboundedMap(DyeColor.CODEC, Codec.INT).fieldOf("active_colors").forGetter(jVar2 -> {
            return jVar2.e;
        })).apply(instance, (v1, v2) -> {
            return new j(v1, v2);
        });
    });
    public static final StreamCodec<RegistryFriendlyByteBuf, j> b = StreamCodec.composite(ByteBufCodecs.BOOL, jVar -> {
        return Boolean.valueOf(jVar.d);
    }, ByteBufCodecs.map(HashMap::new, DyeColor.STREAM_CODEC, ByteBufCodecs.INT), jVar2 -> {
        return jVar2.e;
    }, (z, obj) -> {
        return new j(z, (Map) obj);
    });
    private boolean d;
    private final EnumMap<DyeColor, Integer> e;

    public j() {
        this.d = false;
        this.e = new EnumMap<>(DyeColor.class);
    }

    private j(boolean z, Map<DyeColor, Integer> map) {
        this.d = false;
        this.e = new EnumMap<>(DyeColor.class);
        this.d = z;
        this.e.putAll(map);
    }

    @Override // mctech.g.f.a
    public d<j> b() {
        return MCTechConduitTypes.Data.REDSTONE.get();
    }

    @Override // mctech.g.f.a
    @Nullable
    public mctech.g.a.h.c g() {
        return null;
    }

    public boolean a() {
        return this.d;
    }

    public boolean a(DyeColor dyeColor) {
        return this.e.containsKey(dyeColor);
    }

    public int b(DyeColor dyeColor) {
        return ((Integer) this.e.getOrDefault(dyeColor, 0)).intValue();
    }

    public Map<DyeColor, Integer> c() {
        return this.e;
    }

    public void d() {
        this.e.clear();
        this.d = false;
    }

    public void a(DyeColor dyeColor, int i) {
        if (this.e.containsKey(dyeColor)) {
            return;
        }
        this.d = true;
        this.e.put(dyeColor, Integer.valueOf(i));
    }

    @Override // mctech.g.f.a
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public j h() {
        return new j(this.d, new EnumMap((EnumMap) this.e));
    }

    public int hashCode() {
        return Objects.hash(Boolean.valueOf(this.d), this.e);
    }
}
