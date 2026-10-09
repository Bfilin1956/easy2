package mctech.components;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Stream;
import mctech.MCTech;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: renamed from: mctech.components.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/components/a.class */
public abstract class AbstractC0087a extends mctech.m.d.a.a {
    public static final ResourceLocation a = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/gui/components/tooltip_bg2.png");
    private List<Item> b;
    private List<MutableComponent> c;
    private final int d = -1;

    public AbstractC0087a(mctech.utils.math.geometry.b bVar, String str, Item... itemArr) {
        super(bVar);
        this.b = new ArrayList();
        this.d = -1;
        this.b = Arrays.asList(itemArr);
        this.c = Stream.of((Object[]) Component.translatable(str).getString().split("\\\\n")).map(Component::translatable).toList();
    }

    protected boolean a() {
        return true;
    }

    protected List<MutableComponent> b() {
        return this.c;
    }

    protected List<Item> c() {
        return this.b;
    }

    @Override // mctech.m.d.a.a
    protected void a(Set<mctech.m.d.a.a.EnumC0027a> set) {
        set.add(mctech.m.d.a.a.EnumC0027a.TOOLTIP);
    }

    @Override // mctech.m.d.a.a
    @OnlyIn(Dist.CLIENT)
    public void a(GuiGraphics guiGraphics, int i, int i2, Consumer<Component> consumer) {
        if (a(i, i2) && a()) {
            Minecraft minecraft = Minecraft.getInstance();
            PoseStack poseStackPose = guiGraphics.pose();
            poseStackPose.pushPose();
            poseStackPose.translate(0.0f, 0.0f, 350.0f);
            RenderSystem.setShaderColor(1.0f, 1.0f, 1.0f, 1.0f);
            int i3 = 0;
            Iterator<MutableComponent> it = b().iterator();
            while (it.hasNext()) {
                int iWidth = minecraft.font.width(it.next()) - 25;
                if (i3 < iWidth) {
                    i3 = iWidth;
                }
            }
            Iterator<Item> it2 = c().iterator();
            while (it2.hasNext()) {
                int iWidth2 = minecraft.font.width(new ItemStack(it2.next()).getDisplayName().getString().replaceAll("[\\[\\]]", ""));
                if (iWidth2 > i3) {
                    i3 = iWidth2;
                }
            }
            int guiLeft = this.q.getGuiLeft() + this.o.a();
            int guiTop = this.q.getGuiTop() + this.o.b();
            guiGraphics.blit(a, guiLeft + 18, guiTop + 18, i3 + 36, (c().size() * 20) + (b().size() * 11), 0.0f, 0.0f, 300, 120, 300, 120);
            RenderSystem.disableDepthTest();
            int i4 = 0;
            Iterator<MutableComponent> it3 = b().iterator();
            while (it3.hasNext()) {
                guiGraphics.drawString(minecraft.font, it3.next(), guiLeft + 25, guiTop + 25 + i4, -1);
                i4 += 10;
            }
            int i5 = 0;
            int size = guiTop + ((b().size() - 1) * 10);
            Iterator<Item> it4 = c().iterator();
            while (it4.hasNext()) {
                ItemStack itemStack = new ItemStack(it4.next());
                String strReplaceAll = itemStack.getDisplayName().getString().replaceAll("[\\[\\]]", "");
                guiGraphics.renderItem(itemStack, guiLeft + 25, size + 35 + (18 * i5));
                guiGraphics.drawString(minecraft.font, strReplaceAll, guiLeft + 45, size + 41 + (18 * i5), -1);
                i5++;
            }
            poseStackPose.popPose();
        }
    }
}
