package mctech.components.a;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mctech.init.MCTechLang;
import mctech.m.b.ap;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a/F.class */
public class F extends mctech.m.d.a.a {
    private static final Comparator<Map.Entry<ItemStack, List<Integer>>> a = new Comparator<Map.Entry<ItemStack, List<Integer>>>() { // from class: mctech.components.a.F.1
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<ItemStack, List<Integer>> entry, Map.Entry<ItemStack, List<Integer>> entry2) {
            int iCompare = Integer.compare(entry.getValue().size(), entry2.getValue().size());
            if (iCompare != 0) {
                return iCompare;
            }
            return entry.getKey().getItem().getName(entry.getKey()).getString().compareTo(entry2.getKey().getItem().getName(entry2.getKey()).getString());
        }
    };
    private ap b;
    private List<ItemStack> c;

    public F(ap apVar) {
        super(mctech.utils.math.geometry.b.a);
        this.b = apVar;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.m.d.a.a
    public void a(GuiGraphics guiGraphics, int i, int i2) {
        mctech.items.e.i.a aVar = ((mctech.m.f.l) this.b.getHolder()).a;
        if (this.c == null || this.b.a()) {
            this.b.a(false);
            this.c = mctech.utils.a.b.i();
            for (int i3 = 0; i3 < aVar.b().size(); i3++) {
                List list = aVar.b().get(i3).g().entrySet().stream().sorted(a).map(entry -> {
                    return (ItemStack) entry.getKey();
                }).toList();
                this.c.add(list.isEmpty() ? ItemStack.EMPTY : (ItemStack) list.getFirst());
            }
        }
        for (int i4 = 0; i4 < this.c.size(); i4++) {
            ItemStack itemStack = this.c.get(i4);
            if (!itemStack.isEmpty()) {
                guiGraphics.renderFakeItem(itemStack, 12 + (i4 * 24), 14);
            }
        }
        mctech.items.e.i.b bVar = aVar.b().get(this.b.d);
        int i5 = (bVar.d() == 0 || bVar.e() == 0) ? -6710887 : -1;
        this.q.a(guiGraphics, (Component) MCTechLang.GUI_MCTECH_SCHEME_INSTALLER_WIDTH.get(), 12, 39, i5);
        this.q.b(guiGraphics, (Component) Component.literal(String.valueOf(bVar.d())), 135, 39, i5);
        this.q.a(guiGraphics, (Component) MCTechLang.GUI_MCTECH_SCHEME_INSTALLER_HEIGHT.get(), 12, 53, i5);
        this.q.b(guiGraphics, (Component) Component.literal(String.valueOf(bVar.e())), 135, 53, i5);
        this.q.a(guiGraphics, (Component) MCTechLang.GUI_MCTECH_SCHEME_INSTALLER_LOCK.get(), 12, 67, i5);
        this.q.a(guiGraphics, (Component) MCTechLang.GUI_MCTECH_SCHEME_INSTALLER_EMPTY.get(), 12, 81, -1);
        this.q.a(guiGraphics, (Component) MCTechLang.GUI_MCTECH_SCHEME_INSTALLER_FILTER.get(), 12, 95, -1);
        this.q.a(guiGraphics, (Component) MCTechLang.GUI_MCTECH_SCHEME_INSTALLER_DURABILITY.get(), 12, 109, -1);
    }
}
