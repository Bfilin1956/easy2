package mctech.m.d;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import mctech.components.ContainerComponent;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/m/d/a.class */
@OnlyIn(Dist.CLIENT)
public class a extends b {
    private List<mctech.m.d.a.a>[] A;
    private List<mctech.m.d.a.a> B;
    private List<mctech.m.d.b.a> C;

    public a(ContainerComponent<?> containerComponent) {
        super(containerComponent, containerComponent.getPlayer().getInventory(), containerComponent.getName());
        this.A = mctech.utils.a.b.a(mctech.m.d.a.a.EnumC0027a.values().length);
        this.B = mctech.utils.a.b.i();
        this.C = mctech.utils.a.b.i();
        a(containerComponent.getTexture());
        a(containerComponent.getComponents());
        containerComponent.onGuiLoaded(this);
    }

    public void a(List<mctech.m.d.a.a> list) {
        Iterator<mctech.m.d.a.a> it = list.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a(mctech.m.d.a.a aVar) {
        aVar.d(this);
        Iterator<mctech.m.d.a.a.EnumC0027a> it = aVar.x().iterator();
        while (it.hasNext()) {
            this.A[it.next().a()].add(aVar);
        }
        this.B.add(aVar);
        if (aVar instanceof mctech.m.d.b.a) {
            this.C.add((mctech.m.d.b.a) aVar);
        }
        Iterator<mctech.m.d.a.a> it2 = aVar.p.iterator();
        while (it2.hasNext()) {
            a(it2.next());
        }
    }

    public List<mctech.m.d.a.a> a(mctech.m.d.a.a.EnumC0027a enumC0027a) {
        return this.A[enumC0027a.a()];
    }

    public List<Component> getTooltipFromContainerItem(ItemStack itemStack) {
        List<Component> tooltipFromContainerItem = super.getTooltipFromContainerItem(itemStack);
        Slot slotUnderMouse = getSlotUnderMouse();
        Iterator<mctech.m.d.a.a> it = a(mctech.m.d.a.a.EnumC0027a.ITEM_TOOLTIP).iterator();
        while (it.hasNext()) {
            it.next().a(slotUnderMouse, itemStack, tooltipFromContainerItem);
        }
        return tooltipFromContainerItem;
    }

    public List<mctech.m.d.a.a> a() {
        return this.B;
    }

    public <T extends mctech.m.d.a.a> T a(Class<T> cls) {
        Iterator<mctech.m.d.a.a> it = this.B.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (cls.isInstance(t)) {
                return t;
            }
        }
        return null;
    }

    @Override // mctech.m.d.b
    public void b() {
        int size = this.C.size();
        for (int i = 0; i < size; i++) {
            this.C.get(i).c(this);
        }
    }

    @Override // mctech.m.d.b
    protected void init() {
        super.init();
        Iterator<mctech.m.d.a.a> it = a(mctech.m.d.a.a.EnumC0027a.GUI_INIT).iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    @Override // mctech.m.d.b
    public void removed() {
        Iterator<mctech.m.d.a.a> it = a(mctech.m.d.a.a.EnumC0027a.GUI_CLOSE).iterator();
        while (it.hasNext()) {
            it.next().X_();
        }
        super.removed();
    }

    private List<mctech.m.d.a.a> b(mctech.m.d.a.a.EnumC0027a enumC0027a) {
        return a(enumC0027a).stream().sorted(Comparator.comparingInt(aVar -> {
            return aVar.r;
        })).filter(aVar2 -> {
            return aVar2.r() && aVar2.w();
        }).toList();
    }

    @Override // mctech.m.d.b
    protected void renderBg(GuiGraphics guiGraphics, float f, int i, int i2) {
        if (d(64)) {
            c(64);
            a(((ContainerComponent) b(ContainerComponent.class)).getTexture());
        }
        int guiLeft = i - getGuiLeft();
        int guiTop = i2 - getGuiTop();
        b(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND_PRE).stream().sorted(Comparator.comparingInt(aVar -> {
            return aVar.r;
        })).forEach(aVar2 -> {
            aVar2.b(guiGraphics, guiLeft, guiTop, f);
            aVar2.a(guiGraphics, guiLeft, guiTop, f);
        });
        super.renderBg(guiGraphics, f, i, i2);
        b(mctech.m.d.a.a.EnumC0027a.DRAW_BACKGROUND).stream().sorted(Comparator.comparingInt(aVar3 -> {
            return aVar3.r;
        })).forEach(aVar4 -> {
            aVar4.a(guiGraphics, guiLeft, guiTop, f);
        });
    }

    @Override // mctech.m.d.b
    protected void renderLabels(GuiGraphics guiGraphics, int i, int i2) {
        super.renderLabels(guiGraphics, i, i2);
        int guiLeft = i - getGuiLeft();
        int guiTop = i2 - getGuiTop();
        b(mctech.m.d.a.a.EnumC0027a.DRAW_FOREGROUND).stream().sorted(Comparator.comparingInt(aVar -> {
            return aVar.r;
        })).forEach(aVar2 -> {
            aVar2.a(guiGraphics, guiLeft, guiTop);
        });
    }

    @Override // mctech.m.d.b
    public void a(GuiGraphics guiGraphics, float f, int i, int i2) {
        int guiLeft = i - getGuiLeft();
        int guiTop = i2 - getGuiTop();
        b(mctech.m.d.a.a.EnumC0027a.DRAW_POST).stream().sorted(Comparator.comparingInt(aVar -> {
            return aVar.r;
        })).forEach(aVar2 -> {
            aVar2.c(guiGraphics, guiLeft, guiTop, f);
        });
    }

    @Override // mctech.m.d.b
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        int guiLeft = i - getGuiLeft();
        int guiTop = i2 - getGuiTop();
        for (mctech.m.d.a.a aVar : a(mctech.m.d.a.a.EnumC0027a.TOOLTIP)) {
            if (aVar.r() && aVar.w()) {
                aVar.a(guiGraphics, guiLeft, guiTop, consumer);
            }
        }
    }

    @Override // mctech.m.d.b
    public void containerTick() {
        for (mctech.m.d.a.a aVar : a(mctech.m.d.a.a.EnumC0027a.GUI_TICK)) {
            if (aVar.r()) {
                aVar.b(this);
            }
        }
        super.containerTick();
    }

    @Override // mctech.m.d.b
    public boolean mouseClicked(double d, double d2, int i) {
        int guiLeft = (int) (d - ((double) getGuiLeft()));
        int guiTop = (int) (d2 - ((double) getGuiTop()));
        ArrayList<mctech.m.d.a.a> arrayList = new ArrayList(a(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT));
        arrayList.sort(Comparator.comparingInt(aVar -> {
            return aVar.r;
        }).reversed());
        for (mctech.m.d.a.a aVar2 : arrayList) {
            if (aVar2.r() && aVar2.w() && aVar2.a(guiLeft, guiTop) && aVar2.a(guiLeft, guiTop, i)) {
                return true;
            }
        }
        return super.mouseClicked(d, d2, i);
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        int guiLeft = (int) (d - ((double) getGuiLeft()));
        int guiTop = (int) (d2 - ((double) getGuiTop()));
        for (mctech.m.d.a.a aVar : a(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT)) {
            if (aVar.r() && aVar.w() && aVar.c(guiLeft, guiTop, i)) {
                return true;
            }
        }
        return super.mouseDragged(d, d2, i, d3, d4);
    }

    @Override // mctech.m.d.b
    public boolean mouseReleased(double d, double d2, int i) {
        int guiLeft = (int) (d - ((double) getGuiLeft()));
        int guiTop = (int) (d2 - ((double) getGuiTop()));
        for (mctech.m.d.a.a aVar : a(mctech.m.d.a.a.EnumC0027a.MOUSE_INPUT)) {
            if (aVar.r() && aVar.w() && aVar.d(guiLeft, guiTop, i)) {
                return true;
            }
        }
        return super.mouseReleased(d, d2, i);
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        int guiLeft = (int) (d - ((double) getGuiLeft()));
        int guiTop = (int) (d2 - ((double) getGuiTop()));
        for (mctech.m.d.a.a aVar : a(mctech.m.d.a.a.EnumC0027a.MOUSE_SCROLL)) {
            if (aVar.r() && aVar.w() && aVar.a(guiLeft, guiTop) && aVar.b(guiLeft, guiTop, (int) d4)) {
                return true;
            }
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }

    public boolean keyPressed(int i, int i2, int i3) {
        for (mctech.m.d.a.a aVar : a(mctech.m.d.a.a.EnumC0027a.KEY_INPUT)) {
            if (aVar.r() && aVar.b_(i)) {
                return true;
            }
        }
        return super.keyPressed(i, i2, i3);
    }

    public boolean charTyped(char c, int i) {
        for (mctech.m.d.a.a aVar : a(mctech.m.d.a.a.EnumC0027a.KEY_INPUT)) {
            if (aVar.r() && aVar.a(c, i)) {
                return true;
            }
        }
        return super.charTyped(c, i);
    }
}
