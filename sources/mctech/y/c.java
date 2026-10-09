package mctech.y;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.PrimitiveCodec;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/c.class */
public enum c {
    TEXTURED,
    COLORED;

    public static Codec<c> c = new PrimitiveCodec<c>() { // from class: mctech.y.c.1
        public <T> DataResult<c> read(DynamicOps<T> dynamicOps, T t) {
            return dynamicOps.getNumberValue(t).map(number -> {
                return c.values()[number.intValue()];
            });
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public <T> T write(DynamicOps<T> dynamicOps, c cVar) {
            return (T) dynamicOps.createInt(cVar.ordinal());
        }

        public String toString() {
            return "RenderMode";
        }
    };
}
