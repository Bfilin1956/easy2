package mctech.components;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import javax.annotation.Nonnull;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/y.class */
public final class y extends Record implements TooltipComponent {
    private final String a;

    @Nonnull
    private final ItemStack[] b;

    public y(String str, @Nonnull ItemStack... itemStackArr) {
        this.a = str;
        this.b = itemStackArr;
    }

    @Override // java.lang.Record
    public final String toString() {
        return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, y.class), y.class, "tooltip;items", "FIELD:Lmctech/components/y;->a:Ljava/lang/String;", "FIELD:Lmctech/components/y;->b:[Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final int hashCode() {
        return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, y.class), y.class, "tooltip;items", "FIELD:Lmctech/components/y;->a:Ljava/lang/String;", "FIELD:Lmctech/components/y;->b:[Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this) /* invoke-custom */;
    }

    @Override // java.lang.Record
    public final boolean equals(Object obj) {
        return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, y.class, Object.class), y.class, "tooltip;items", "FIELD:Lmctech/components/y;->a:Ljava/lang/String;", "FIELD:Lmctech/components/y;->b:[Lnet/minecraft/world/item/ItemStack;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
    }

    public String a() {
        return this.a;
    }

    @Nonnull
    public ItemStack[] b() {
        return this.b;
    }
}
