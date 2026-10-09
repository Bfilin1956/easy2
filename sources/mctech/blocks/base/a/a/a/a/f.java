package mctech.blocks.base.a.a.a.a;

import mctech.api.tiles.readers.IProgressMachine;
import net.minecraft.network.chat.Component;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/base/a/a/a/a/f.class */
public class f extends mctech.blocks.base.a.a.a {
    IProgressMachine f;

    public f(String str, Component component, IProgressMachine iProgressMachine) {
        super(str, component);
        this.f = iProgressMachine;
    }

    @Override // mctech.blocks.base.a.a.a
    protected int d() {
        return mctech.blocks.base.a.a.a.a(this.f.getProgress(), this.f.getMaxProgress(), 15);
    }
}
