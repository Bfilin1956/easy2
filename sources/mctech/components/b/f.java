package mctech.components.b;

import java.lang.Comparable;
import java.lang.Number;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/b/f.class */
public class f<N extends Number & Comparable<N>> extends mctech.m.d.a.a {
    private Pattern a;
    private EditBox b;
    private final Function<String, N> c;
    private final Supplier<N> d;
    private final Consumer<N> e;
    private final N f;
    private final N g;
    private final N h;

    private f(mctech.utils.math.geometry.b bVar, Supplier<N> supplier, Consumer<N> consumer, Function<String, N> function, N n, N n2, N n3) {
        super(bVar);
        this.a = Pattern.compile("[0-9]{1,}\\.[0-9]{0,2}");
        this.d = supplier;
        this.e = consumer;
        this.c = function;
        this.f = n;
        this.g = n2;
        this.h = n3;
        this.b = a(bVar, supplier, consumer, function, n, n2, n3);
    }

    public f<N> a(String str) {
        this.a = Pattern.compile(str);
        this.b = a(this.o, this.d, this.e, this.c, this.f, this.g, this.h);
        return this;
    }

    public static f<Integer> a(mctech.utils.math.geometry.b bVar, Supplier<Integer> supplier, Consumer<Integer> consumer) {
        return new f(bVar, supplier, consumer, Integer::parseInt, 1, 9999999, 0).a("[0-9]{1,}");
    }

    public static f<Double> b(mctech.utils.math.geometry.b bVar, Supplier<Double> supplier, Consumer<Double> consumer) {
        return new f(bVar, supplier, consumer, Double::parseDouble, Double.valueOf(1.0d), Double.valueOf(9999999.0d), Double.valueOf(0.0d)).a("[0-9]{1,}\\.[0-9]{0,2}");
    }

    public static f<Float> c(mctech.utils.math.geometry.b bVar, Supplier<Float> supplier, Consumer<Float> consumer) {
        return new f(bVar, supplier, consumer, Float::parseFloat, Float.valueOf(0.01f), Float.valueOf(9999999.0f), Float.valueOf(0.0f)).a("[0-9]{1,}\\.[0-9]{0,2}");
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_INIT);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_TICK);
        set.add(mctech.m.d.a.a.EnumC0027a.GUI_CLOSE);
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
        set.add(mctech.m.d.a.a.EnumC0027a.KEY_INPUT);
        set.add(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(mctech.m.d.b bVar) {
        this.b.setX(bVar.getGuiLeft() + this.o.a());
        this.b.setY((bVar.getGuiTop() + this.o.b()) - 2);
        bVar.a(true);
        bVar.addRenderableWidget(this.b);
    }

    public N a() {
        Matcher matcher = this.a.matcher(this.b.getValue());
        try {
            return this.c.apply(matcher.find() ? matcher.group() : this.b.getValue());
        } catch (NumberFormatException e) {
            return this.d.get();
        }
    }

    public void a(N n) {
        this.b.setValue(String.valueOf(n));
    }

    protected EditBox a(mctech.utils.math.geometry.b bVar, Supplier<N> supplier, Consumer<N> consumer, Function<String, N> function, N n, N n2, N n3) {
        EditBox editBox = new EditBox(Minecraft.getInstance().font, bVar.d(), bVar.c(), Component.empty());
        editBox.setEditable(true);
        editBox.setBordered(false);
        editBox.setFilter(str -> {
            try {
                function.apply(str);
                return true;
            } catch (NumberFormatException e) {
                return a(str, ((Comparable) n).compareTo(n3) < 0);
            }
        });
        editBox.setValue(String.valueOf(supplier.get()));
        editBox.setResponder(str2 -> {
            try {
                Matcher matcher = this.a.matcher(str2);
                Object obj = (Number) function.apply(matcher.find() ? matcher.group() : str2);
                if (((Comparable) obj).compareTo(n) >= 0 && ((Comparable) obj).compareTo(n2) <= 0) {
                    if (!obj.equals(supplier.get())) {
                        consumer.accept(obj);
                    }
                    editBox.setTextColor(14737632);
                    return;
                }
            } catch (NumberFormatException e) {
            }
            editBox.setTextColor(-65536);
        });
        return editBox;
    }

    protected boolean a(String str, boolean z) {
        switch (str) {
            case "":
            case "0":
            case "0x":
            case "0X":
            case "#":
                return true;
            case "-":
            case "-0":
            case "-0x":
            case "-0X":
                return z;
            default:
                return false;
        }
    }
}
