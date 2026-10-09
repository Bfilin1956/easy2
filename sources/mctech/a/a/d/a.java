package mctech.a.a.d;

import appeng.client.gui.implementations.UpgradeableScreen;
import appeng.client.gui.style.PaletteColor;
import appeng.client.gui.style.ScreenStyle;
import com.glodblock.github.extendedae.client.button.HighlightButton;
import com.glodblock.github.extendedae.client.button.TooltipIcon;
import com.glodblock.github.extendedae.client.gui.widget.WorldDisplay;
import com.glodblock.github.extendedae.common.me.wireless.WirelessStatus;
import com.glodblock.github.extendedae.util.MessageUtil;
import java.util.Objects;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Tooltip;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/a/d/a.class */
public class a extends UpgradeableScreen<mctech.a.a.e.a> {
    public static final int a = 8;
    public static final int b = 6;
    private final TooltipIcon c;
    private final HighlightButton d;
    private final WorldDisplay e;
    private BlockPos f;

    public a(mctech.a.a.e.a aVar, Inventory inventory, Component component, ScreenStyle screenStyle) {
        super(aVar, inventory, component, screenStyle);
        this.f = null;
        this.e = new WorldDisplay(this, 0, 0, 158, 63);
        this.c = addToLeftToolbar(new TooltipIcon());
        this.d = addToLeftToolbar(new HighlightButton());
        this.d.setTooltip(Tooltip.create(Component.translatable("gui.wireless_connect.highlight.tooltip")));
    }

    public void init() {
        super.init();
        this.c.setPosition(this.leftPos - this.c.getWidth(), (this.topPos + 6) - 1);
        this.d.setPosition(this.leftPos - this.d.getWidth(), this.topPos + 6 + 21);
        this.e.setPosition(this.leftPos + 16, this.topPos + 91);
        this.e.refreshBounds();
        addRenderableOnly(this.c);
        addRenderableWidget(this.e);
        addRenderableWidget(this.d);
    }

    protected void updateBeforeRender() {
        super.updateBeforeRender();
        if (this.menu.f != WirelessStatus.WORKING) {
            this.e.unload();
            this.d.setVisibility(false);
            return;
        }
        BlockPos blockPosOf = BlockPos.of(this.menu.e);
        if (!Objects.equals(blockPosOf, this.f)) {
            this.e.locate(blockPosOf);
            this.f = blockPosOf;
        }
        this.d.setTarget(blockPosOf, getPlayer().clientLevel.dimension());
        this.d.setMultiplier(a(blockPosOf));
        this.d.setSuccessJob(() -> {
            if (getPlayer() == null) {
                return;
            }
            getPlayer().displayClientMessage(MessageUtil.createEnhancedHighlightMessage(getPlayer(), blockPosOf, getPlayer().clientLevel.dimension(), "chat.wireless.highlight"), false);
        });
        this.d.setVisibility(true);
    }

    private double a(BlockPos blockPos) {
        if (blockPos == null) {
            return 0.0d;
        }
        return blockPos.distSqr(getPlayer().getOnPos());
    }

    public void drawFG(GuiGraphics guiGraphics, int i, int i2, int i3, int i4) {
        int argb = this.style.getColor(PaletteColor.DEFAULT_TEXT_COLOR).toARGB();
        this.c.setTooltip(Tooltip.create(this.menu.f.getDesc()));
        guiGraphics.drawString(this.font, ((mctech.a.a.a.a) this.menu.getHost()).getName(), 8, 6, argb, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.wireless_connect.status", new Object[]{this.menu.f.getTranslation()}), 8, 6 + 12, argb, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.wireless_connect.power", new Object[]{String.format("%.2f", Double.valueOf(this.menu.b))}), 8, 6 + (12 * 2), argb, false);
        guiGraphics.drawString(this.font, Component.translatable("gui.wireless_connect.channel", new Object[]{Integer.valueOf(this.menu.c), Integer.valueOf(this.menu.d)}), 8, 6 + (12 * 3), argb, false);
        if (this.menu.f != WirelessStatus.WORKING) {
            return;
        }
        BlockPos blockPosOf = BlockPos.of(this.menu.e);
        guiGraphics.drawString(this.font, Component.translatable("gui.wireless_connect.remote", new Object[]{Integer.valueOf(blockPosOf.getX()), Integer.valueOf(blockPosOf.getY()), Integer.valueOf(blockPosOf.getZ())}), 8, 78, argb, false);
    }

    public boolean mouseDragged(double d, double d2, int i, double d3, double d4) {
        if (this.e.mouseDragged(d, d2, i, d3, d4)) {
            return true;
        }
        return super.mouseDragged(d, d2, i, d3, d4);
    }

    public boolean mouseScrolled(double d, double d2, double d3, double d4) {
        if (this.e.mouseScrolled(d, d2, d3, d4)) {
            return true;
        }
        return super.mouseScrolled(d, d2, d3, d4);
    }
}
