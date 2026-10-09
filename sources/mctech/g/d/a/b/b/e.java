package mctech.g.d.a.b.b;

import java.util.List;
import java.util.Objects;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.component.TypedDataComponent;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/b/b/e.class */
public class e {
    private static final List<DataComponentType<?>> a = List.of(DataComponents.DAMAGE);

    public static boolean a(ItemStack itemStack, ItemStack itemStack2) {
        for (TypedDataComponent typedDataComponent : itemStack.getComponents()) {
            if (!a.contains(typedDataComponent.type()) && !Objects.equals(itemStack2.get(typedDataComponent.type()), typedDataComponent.value())) {
                return false;
            }
        }
        for (TypedDataComponent typedDataComponent2 : itemStack2.getComponents()) {
            if (!a.contains(typedDataComponent2.type()) && !Objects.equals(itemStack.get(typedDataComponent2.type()), typedDataComponent2.value())) {
                return false;
            }
        }
        return true;
    }
}
