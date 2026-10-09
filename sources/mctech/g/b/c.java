package mctech.g.b;

import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/b/c.class */
public abstract class c extends AbstractWidget implements e {
    public c(int i, int i2, int i3, int i4, Component component) {
        super(i, i2, i3, i4, component);
    }

    public void a(boolean z) {
        this.visible = z;
    }

    @Override // mctech.g.b.e
    public Object a() {
        return Boolean.valueOf(this.visible);
    }

    @Override // mctech.g.b.e
    public void a(Object obj) {
        if (obj instanceof Boolean) {
            this.visible = ((Boolean) obj).booleanValue();
        }
    }

    public int b() {
        return 0;
    }
}
