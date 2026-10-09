package mctech.w;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.client.gui.widget.ExtendedButton;
import net.neoforged.neoforge.items.SlotItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/w/f.class */
public class f extends AbstractContainerScreen<mctech.o.b> {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/gui_atlas_2.png");
    private boolean b;

    @Nullable
    private Slot c;
    private e d;
    private List<ItemStack> e;
    private EditBox f;

    public f(e eVar, Inventory inventory) {
        super((mctech.o.b) eVar.getMenu(), inventory, Component.empty());
        this.e = mctech.utils.a.b.i();
        this.imageWidth = 122;
        this.imageHeight = 132;
        this.d = eVar;
    }

    protected void init() {
        clearWidgets();
        this.minecraft = Minecraft.getInstance();
        this.font = this.minecraft.font;
        super.init();
        this.leftPos = ((this.width - this.imageWidth) / 2) - 175;
        this.topPos = ((this.height - this.imageHeight) / 2) - 54;
        this.f = new EditBox(this.font, this.leftPos + 10, this.topPos + 22, 104, 10, Component.empty());
        this.f.setBordered(false);
        this.f.setResponder(this::a);
        addRenderableWidget(this.f);
    }

    public void render(@Nonnull GuiGraphics guiGraphics, int i, int i2, float f) {
        int i3 = this.leftPos;
        int i4 = this.topPos;
        renderBg(guiGraphics, f, i, i2);
        RenderSystem.disableDepthTest();
        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(i3, i4, 0.0f);
        renderLabels(guiGraphics, i, i2);
        guiGraphics.pose().popPose();
        RenderSystem.enableDepthTest();
        Iterator it = this.renderables.iterator();
        while (it.hasNext()) {
            ((Renderable) it.next()).render(guiGraphics, i, i2, f);
        }
        int i5 = 0;
        ItemStack itemStack = null;
        for (ItemStack itemStack2 : this.e) {
            int i6 = i3 + 9 + ((i5 % 5) * 18);
            int i7 = i4 + 35 + ((i5 / 5) * 18);
            guiGraphics.renderItem(itemStack2, i6, i7);
            if (i >= i6 && i < i6 + 16 && i2 >= i7 && i2 < i7 + 16) {
                itemStack = itemStack2;
            }
            i5++;
        }
        if (itemStack != null) {
            guiGraphics.renderTooltip(this.font, getTooltipFromContainerItem(itemStack), itemStack.getTooltipImage(), itemStack, i, i2);
        }
        renderTooltip(guiGraphics, i, i2);
    }

    protected void renderLabels(@Nonnull GuiGraphics guiGraphics, int i, int i2) {
    }

    protected void renderBg(@Nonnull GuiGraphics guiGraphics, float f, int i, int i2) {
        guiGraphics.blit(a, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight);
    }

    public boolean mouseClicked(double d, double d2, int i) {
        if (!a()) {
            return false;
        }
        for (GuiEventListener guiEventListener : children()) {
            if (guiEventListener.mouseClicked(d, d2, i)) {
                setFocused(guiEventListener);
                if (i == 0) {
                    setDragging(true);
                    return true;
                }
                return true;
            }
        }
        for (Slot slot : ((mctech.o.b) getMenu()).slots) {
            if (slot.x < 999999 && (slot instanceof SlotItemHandler)) {
                int guiLeft = this.d.getGuiLeft() + slot.x;
                int guiTop = this.d.getGuiTop() + slot.y;
                if (d >= guiLeft && d < guiLeft + 16 && d2 >= guiTop && d2 < guiTop + 16) {
                    this.c = slot;
                    ItemStack[] itemStackArrA = this.d.b.a(slot);
                    if (itemStackArrA == null) {
                        break;
                    }
                    this.e.clear();
                    this.e.addAll(Stream.of((Object[]) itemStackArrA).filter(itemStack -> {
                        return itemStack.getItem().getName(itemStack).getString().toLowerCase().contains(this.f.getValue());
                    }).toList());
                    break;
                }
            }
        }
        for (ExtendedButton extendedButton : this.d.c) {
            if (extendedButton.isMouseOver(d, d2)) {
                extendedButton.onPress();
                return true;
            }
        }
        return true;
    }

    private void a(String str) {
        ItemStack[] itemStackArrA;
        this.e.clear();
        if (this.c != null && (itemStackArrA = this.d.b.a(this.c)) != null) {
            this.e.addAll(Stream.of((Object[]) itemStackArrA).filter(itemStack -> {
                return itemStack.getItem().getName(itemStack).getString().toLowerCase().contains(str);
            }).toList());
        }
    }

    public boolean a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public void a(Slot slot) {
        this.c = slot;
    }

    public Slot b() {
        return this.c;
    }
}
