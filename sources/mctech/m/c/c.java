package mctech.m.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import mctech.api.tiles.IRecipeMachine;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/c/c.class */
public abstract class c<Machine extends BlockEntity & IRecipeMachine> implements h {
    protected final Machine a;
    protected final Map<l, Boolean> b = new HashMap();
    protected static final int c = 512;

    protected abstract Set<Ingredient> b();

    protected abstract void c();

    protected c(Machine machine) {
        this.a = machine;
    }

    @Override // mctech.m.c.h
    public void a() {
        this.b.clear();
        c();
    }

    protected boolean a(ItemStack itemStack) {
        Set<Ingredient> setB;
        if (itemStack.isEmpty() || (setB = b()) == null || setB.isEmpty()) {
            return false;
        }
        l lVar = new l(itemStack);
        Boolean bool = this.b.get(lVar);
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z = false;
        Iterator<Ingredient> it = setB.iterator();
        while (it.hasNext()) {
            if (it.next().test(itemStack)) {
                z = true;
                break;
            }
        }
        if (this.b.size() >= 512) {
            this.b.clear();
        }
        this.b.put(lVar, Boolean.valueOf(z));
        return z;
    }
}
