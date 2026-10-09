package mctech.utils.a;

import java.util.Iterator;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/h.class */
public class h {
    public static <T extends Tag> Iterable<T> a(final ListTag listTag, Class<T> cls) {
        return f.a(new Iterator<T>() { // from class: mctech.utils.a.h.1
            Iterator<Tag> a;

            {
                this.a = listTag.iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.a.hasNext();
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Tag next() {
                return this.a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.a.remove();
            }
        });
    }
}
