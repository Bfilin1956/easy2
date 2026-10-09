package mctech.utils.a;

import java.util.Iterator;
import java.util.stream.Stream;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/f.class */
public class f<T> implements Iterable<T> {
    Iterator<T> a;

    f(Iterator<T> it) {
        this.a = it;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return this.a;
    }

    public static <T> Iterable<T> a(Iterator<T> it) {
        return new f(it);
    }

    public static <T> Iterable<T> a(Stream<T> stream) {
        return new f(stream.iterator());
    }
}
