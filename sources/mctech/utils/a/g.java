package mctech.utils.a;

import it.unimi.dsi.fastutil.longs.LongArrayFIFOQueue;
import it.unimi.dsi.fastutil.longs.LongPriorityQueue;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/a/g.class */
public class g {
    long b;
    int c;
    LongPriorityQueue a = new LongArrayFIFOQueue();
    int d = 0;
    long e = 0;
    double f = 0.0d;

    public g(int i) {
        this.c = i;
    }

    public void a() {
        this.a.clear();
        this.b = 0L;
        this.f = 0.0d;
        this.e = 0L;
        this.d = 0;
    }

    public void a(long[] jArr) {
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            long jDequeueLong = this.a.dequeueLong();
            this.a.enqueue(jDequeueLong);
            if (i < jArr.length) {
                int i2 = i;
                jArr[i2] = jArr[i2] + jDequeueLong;
            }
        }
    }

    public void a(long j) {
        this.b += j;
        this.a.enqueue(j);
        if (this.a.size() > this.c) {
            this.b -= this.a.dequeueLong();
        }
        this.d = (this.d + 1) % (this.c > 16 ? this.c / 16 : this.c);
        if (this.d == 0) {
            b();
        }
    }

    public void b() {
        if (this.b == 0) {
            this.f = 0.0d;
            this.e = 0L;
        } else {
            this.f = this.b / ((double) this.a.size());
            this.e = this.b / ((long) this.a.size());
        }
    }

    public long c() {
        return this.e;
    }

    public double d() {
        return this.f;
    }

    public long e() {
        if (this.b == 0) {
            return 0L;
        }
        return this.b / ((long) this.a.size());
    }

    public double f() {
        if (this.b == 0) {
            return 0.0d;
        }
        return this.b / ((double) this.a.size());
    }
}
