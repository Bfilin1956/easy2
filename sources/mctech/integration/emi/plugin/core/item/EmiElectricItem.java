package mctech.integration.emi.plugin.core.item;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.Lighting;
import dev.emi.emi.EmiPort;
import dev.emi.emi.EmiRenderHelper;
import dev.emi.emi.api.render.EmiRender;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.platform.EmiAgnos;
import dev.emi.emi.runtime.EmiDrawContext;
import dev.emi.emi.screen.StackBatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import mctech.api.items.electric.ICustomElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.utils.math.a;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/emi/plugin/core/item/EmiElectricItem.class */
public class EmiElectricItem extends EmiStack implements StackBatcher.Batchable {
    private static final Minecraft client;
    private final Item item;
    private final DataComponentPatch componentChanges;
    private boolean unbatchable;
    static final /* synthetic */ boolean $assertionsDisabled;

    static {
        $assertionsDisabled = !EmiElectricItem.class.desiredAssertionStatus();
        client = Minecraft.getInstance();
    }

    public EmiElectricItem(ItemStack itemStack) {
        this(itemStack, itemStack.getCount());
    }

    public EmiElectricItem(ItemStack itemStack, long j) {
        this(itemStack.getItem(), itemStack.getComponentsPatch(), j);
    }

    public EmiElectricItem(Item item, DataComponentPatch dataComponentPatch, long j) {
        this.item = item;
        this.componentChanges = dataComponentPatch;
        this.amount = j;
    }

    public ItemStack getItemStack() {
        return new ItemStack(EmiPort.getItemRegistry().wrapAsHolder(this.item), (int) this.amount, this.componentChanges);
    }

    /* JADX INFO: renamed from: copy, reason: merged with bridge method [inline-methods] */
    public EmiStack m477copy() {
        EmiElectricItem emiElectricItem = new EmiElectricItem(this.item, this.componentChanges, this.amount);
        emiElectricItem.setChance(this.chance);
        emiElectricItem.setRemainder(getRemainder().copy());
        emiElectricItem.comparison = this.comparison;
        return emiElectricItem;
    }

    public boolean isEmpty() {
        return this.amount == 0 || this.item == Items.AIR;
    }

    public DataComponentPatch getComponentChanges() {
        return this.componentChanges;
    }

    @Nullable
    public <T> T get(DataComponentType<? extends T> dataComponentType) {
        Optional optional = this.componentChanges.get(dataComponentType);
        if (optional != null && optional.isPresent()) {
            return (T) optional.orElse(null);
        }
        return (T) this.item.components().get(dataComponentType);
    }

    public Object getKey() {
        return this.item;
    }

    public ResourceLocation getId() {
        return EmiPort.getItemRegistry().getKey(this.item);
    }

    public void render(GuiGraphics guiGraphics, int i, int i2, float f, int i3) {
        EmiDrawContext emiDrawContextWrap = EmiDrawContext.wrap(guiGraphics);
        ItemStack itemStack = getItemStack();
        if ((this.item instanceof IElectricItem) || (this.item instanceof ICustomElectricItem)) {
            emiDrawContextWrap.push();
            emiDrawContextWrap.matrices().translate(0.0f, 0.0f, 100.0f);
            if (itemStack.isBarVisible()) {
                int barWidth = itemStack.getBarWidth();
                int barColor = itemStack.getBarColor();
                int i4 = i + 2;
                int i5 = i2 + 13;
                guiGraphics.fill(RenderType.guiOverlay(), i4, i5, i4 + 13, i5 + 2, a.f);
                guiGraphics.fill(RenderType.guiOverlay(), i4, i5, i4 + barWidth, i5 + 1, barColor | a.f);
            }
            emiDrawContextWrap.pop();
        }
        if ((i3 & 1) != 0) {
            Lighting.setupFor3DItems();
            guiGraphics.renderFakeItem(itemStack, i, i2);
            guiGraphics.renderItemDecorations(client.font, itemStack, i, i2, "");
        }
        if ((i3 & 2) != 0) {
            String str = "";
            if (this.amount != 1) {
                str = str + this.amount;
            }
            EmiRenderHelper.renderAmount(emiDrawContextWrap, i, i2, EmiPort.literal(str));
        }
        if ((i3 & 8) != 0) {
            EmiRender.renderRemainderIcon(this, emiDrawContextWrap.raw(), i, i2);
        }
    }

    public boolean isSideLit() {
        return client.getItemRenderer().getModel(getItemStack(), (Level) null, (LivingEntity) null, 0).usesBlockLight();
    }

    public boolean isUnbatchable() {
        ItemStack itemStack = getItemStack();
        return this.unbatchable || itemStack.hasFoil() || itemStack.isDamaged() || !EmiAgnos.canBatch(itemStack) || client.getItemRenderer().getModel(getItemStack(), (Level) null, (LivingEntity) null, 0).isCustomRenderer();
    }

    public void setUnbatchable() {
        this.unbatchable = true;
    }

    public void renderForBatch(MultiBufferSource multiBufferSource, GuiGraphics guiGraphics, int i, int i2, int i3, float f) {
    }

    public List<Component> getTooltipText() {
        if (client.isSameThread()) {
            return getItemStack().getTooltipLines(Item.TooltipContext.of(client.level), client.player, TooltipFlag.NORMAL);
        }
        if ($assertionsDisabled || client.level != null) {
            return getItemStack().getTooltipLines(Item.TooltipContext.of(client.level.registryAccess()), (Player) null, TooltipFlag.NORMAL);
        }
        throw new AssertionError();
    }

    public List<ClientTooltipComponent> getTooltip() {
        ItemStack itemStack = getItemStack();
        ArrayList arrayListNewArrayList = Lists.newArrayList();
        if (!isEmpty()) {
            arrayListNewArrayList.addAll(EmiAgnos.getItemTooltip(itemStack));
            arrayListNewArrayList.addAll(super.getTooltip());
        }
        return arrayListNewArrayList;
    }

    public Component getName() {
        if (isEmpty()) {
            return EmiPort.literal("");
        }
        return getItemStack().getHoverName();
    }
}
