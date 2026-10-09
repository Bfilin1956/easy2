package mctech.m.b;

import mctech.components.AbstractC0115i;
import mctech.m.a.d;
import net.minecraft.world.inventory.Slot;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/at.class */
public class at<T extends mctech.m.a.d, G extends AbstractC0115i<T>> {
    private static final int b = 16;
    public static final int a = 18;
    private final G c;
    private final mctech.utils.math.geometry.b d;
    private final int e;
    private final int f;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/b/at$a.class */
    public interface a {
        Slot createSlot(int i, int i2, int i3);
    }

    public at(G g, mctech.utils.math.geometry.b bVar, int i, int i2) {
        this.c = g;
        this.d = bVar;
        this.e = i;
        this.f = i2;
    }

    public int a(int[] iArr, a aVar) {
        return a(iArr, 2, aVar);
    }

    public int a(int[] iArr, int i, a aVar) {
        int i2 = 0;
        for (int i3 = 0; i3 < iArr.length && i2 < this.e; i3++) {
            int i4 = iArr[i3];
            int iD = (this.d.d() - (i4 * (16 + i))) / 2;
            for (int i5 = 0; i5 < i4 && i2 < this.e; i5++) {
                this.c.addSlot(aVar.createSlot(this.f + i2, this.d.a() + iD + (i5 * (16 + i)) + (i / 2), this.d.b() + (i3 * (16 + i)) + (i / 2)));
                i2++;
            }
        }
        return i2;
    }
}
