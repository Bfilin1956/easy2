package mctech.components.a;

import java.lang.reflect.Field;
import java.util.function.Consumer;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.network.chat.Component;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/Q.class */
public class Q extends ExtendedButton implements mctech.m.d.b.b {
    public Q(int i, int i2, int i3, int i4, Component component, Button.OnPress onPress) {
        super(i, i2, i3, i4, component, onPress);
    }

    public Q a(Component component) {
        setTooltip(Tooltip.create(component));
        return this;
    }

    public Q a(String str, Object... objArr) {
        return a((Component) Component.translatable(str, objArr));
    }

    public Q a(String str) {
        return a((Component) Component.translatable(str));
    }

    @Override // mctech.m.d.b.b
    public void a(mctech.m.d.b bVar, int i, int i2, Consumer<Component> consumer) {
        Tooltip tooltip;
        if (isHoveredOrFocused() && (tooltip = getTooltip()) != null) {
            try {
                Field declaredField = Tooltip.class.getDeclaredField("message");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(tooltip);
                if (obj instanceof Component) {
                    consumer.accept(((Component) obj).copy());
                }
            } catch (IllegalAccessException | NoSuchFieldException e) {
            }
        }
    }
}
