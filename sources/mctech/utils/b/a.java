package mctech.utils.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/b/a.class */
public class a implements ThreadFactory {
    String b;
    AtomicInteger a = new AtomicInteger(1);
    ThreadGroup c = Thread.currentThread().getThreadGroup();

    public a(String str) {
        this.b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        return new Thread(this.c, runnable, this.b + this.a.getAndIncrement(), 0L);
    }
}
