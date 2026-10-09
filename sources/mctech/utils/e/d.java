package mctech.utils.e;

import java.util.List;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.Mth;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/d.class */
public class d {
    List<Component> a;
    List<Component>[] b = mctech.utils.a.b.a(3);
    int c = 1;
    int d = 1;
    int e = 1;
    int f = 0;
    int g = 0;

    public d(List<Component> list) {
        this.a = list;
        this.f |= Screen.hasControlDown() ? 1 : 0;
        this.f |= Screen.hasShiftDown() ? 2 : 0;
        this.f |= Screen.hasAltDown() ? 4 : 0;
    }

    public boolean a() {
        return (this.f & 4) != 0;
    }

    public boolean b() {
        return (this.f & 2) != 0;
    }

    public boolean c() {
        return (this.f & 1) != 0;
    }

    public void d() {
        if (this.b[0].size() > 0) {
            if (c()) {
                this.a.addAll(this.d, this.b[0]);
                this.d += this.b[0].size();
            } else {
                List<Component> list = this.a;
                int i = this.d;
                this.d = i + 1;
                list.add(i, Component.translatable("tooltip.mctech.press_ctrl.name").withStyle(ChatFormatting.GOLD));
            }
        }
        if (this.b[1].size() > 0) {
            if (b()) {
                this.a.addAll(this.d, this.b[1]);
                this.d += this.b[1].size();
            } else {
                List<Component> list2 = this.a;
                int i2 = this.d;
                this.d = i2 + 1;
                list2.add(i2, Component.translatable("tooltip.mctech.press_shift.name").withStyle(ChatFormatting.GOLD));
            }
        }
        if (this.b[2].size() > 0) {
            if (a()) {
                this.a.addAll(this.d, this.b[2]);
                this.d += this.b[2].size();
            } else {
                List<Component> list3 = this.a;
                int i3 = this.d;
                this.d = i3 + 1;
                list3.add(i3, Component.translatable("tooltip.mctech.press_alt.name").withStyle(ChatFormatting.GOLD));
            }
        }
    }

    public void a(int i) {
        this.e = Mth.clamp(i, 0, this.a.size());
    }

    public void b(int i) {
        this.d = Mth.clamp(i, 0, this.a.size());
    }

    public List<Component> e() {
        return this.a;
    }

    public d a(MutableComponent mutableComponent) {
        List<Component> list = this.a;
        int i = this.e;
        this.e = i + 1;
        list.add(i, mutableComponent);
        this.d++;
        Style style = mutableComponent.getStyle();
        if (style.getColor() == null) {
            mutableComponent.setStyle(style.applyFormat(ChatFormatting.GRAY));
        }
        return this;
    }

    public d a(String str, Object... objArr) {
        return a(Component.translatable(str, objArr));
    }

    public d b(MutableComponent mutableComponent) {
        this.b[0].add(mutableComponent);
        Style style = mutableComponent.getStyle();
        if (style.getColor() == null) {
            mutableComponent.setStyle(style.applyFormat(ChatFormatting.GRAY));
        }
        return this;
    }

    public d b(String str, Object... objArr) {
        return b(Component.translatable(str, objArr));
    }

    public d c(MutableComponent mutableComponent) {
        this.b[1].add(mutableComponent);
        Style style = mutableComponent.getStyle();
        if (style.getColor() == null) {
            mutableComponent.setStyle(style.applyFormat(ChatFormatting.GRAY));
        }
        return this;
    }

    public d c(String str, Object... objArr) {
        return c(Component.translatable(str, objArr));
    }

    public d d(MutableComponent mutableComponent) {
        this.b[2].add(mutableComponent);
        Style style = mutableComponent.getStyle();
        if (style.getColor() == null) {
            mutableComponent.setStyle(style.applyFormat(ChatFormatting.GRAY));
        }
        return this;
    }

    public d d(String str, Object... objArr) {
        return d(Component.translatable(str, objArr));
    }
}
