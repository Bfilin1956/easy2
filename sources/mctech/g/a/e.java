package mctech.g.a;

import com.mojang.blaze3d.platform.Lighting;
import dev.emi.emi.EmiPort;
import dev.emi.emi.EmiRenderHelper;
import dev.emi.emi.api.render.EmiRender;
import dev.emi.emi.api.stack.EmiStack;
import dev.emi.emi.api.stack.serializer.EmiStackSerializer;
import dev.emi.emi.platform.EmiAgnos;
import dev.emi.emi.runtime.EmiDrawContext;
import dev.emi.emi.screen.StackBatcher;
import java.util.List;
import java.util.Optional;
import mctech.init.MCTechDataComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/e.class */
public class e extends EmiStack implements StackBatcher.Batchable {
    private static final Minecraft a = Minecraft.getInstance();
    private boolean b;
    private final ResourceKey<mctech.g.a.a<?, ?>> c;

    public e(ResourceLocation resourceLocation) {
        this(resourceLocation, 1L);
    }

    public e(ResourceLocation resourceLocation, long j) {
        this((ResourceKey<mctech.g.a.a<?, ?>>) ResourceKey.create(l.a.f, resourceLocation), j);
    }

    public e(ResourceKey<mctech.g.a.a<?, ?>> resourceKey) {
        this(resourceKey, 1L);
    }

    public e(ResourceKey<mctech.g.a.a<?, ?>> resourceKey, long j) {
        this.c = resourceKey;
        this.amount = j;
        this.comparison = EmiPort.compareStrict();
    }

    public ItemStack getItemStack() {
        return a.level == null ? ItemStack.EMPTY : b.a((HolderLookup.Provider) a.level.registryAccess(), this.c, Math.min(1, Math.toIntExact(this.amount)));
    }

    /* JADX INFO: renamed from: copy, reason: merged with bridge method [inline-methods] */
    public EmiStack m245copy() {
        return new e(this.c, this.amount).setChance(this.chance).setRemainder(getRemainder().copy()).comparison(this.comparison);
    }

    public boolean isEmpty() {
        return this.amount == 0 || getItemStack().isEmpty();
    }

    public DataComponentPatch getComponentChanges() {
        return getItemStack().getComponentsPatch();
    }

    public Object getKey() {
        return this.c;
    }

    public ResourceLocation getId() {
        return this.c.location();
    }

    public List<Component> getTooltipText() {
        if (a.level == null) {
            return List.of();
        }
        if (a.isSameThread()) {
            return getItemStack().getTooltipLines(Item.TooltipContext.of(a.level), a.player, TooltipFlag.NORMAL);
        }
        return getItemStack().getTooltipLines(Item.TooltipContext.of(a.level.registryAccess()), (Player) null, TooltipFlag.NORMAL);
    }

    public Component getName() {
        if (isEmpty()) {
            return EmiPort.literal("");
        }
        return getItemStack().getHoverName();
    }

    public boolean isSideLit() {
        return a.getItemRenderer().getModel(getItemStack(), (Level) null, (LivingEntity) null, 0).usesBlockLight();
    }

    public boolean isUnbatchable() {
        ItemStack itemStack = getItemStack();
        return this.b || itemStack.hasFoil() || itemStack.isDamaged() || !EmiAgnos.canBatch(itemStack) || a.getItemRenderer().getModel(getItemStack(), (Level) null, (LivingEntity) null, 0).isCustomRenderer();
    }

    public void setUnbatchable() {
        this.b = true;
    }

    public void renderForBatch(MultiBufferSource multiBufferSource, GuiGraphics guiGraphics, int i, int i2, int i3, float f) {
        EmiDrawContext emiDrawContextWrap = EmiDrawContext.wrap(guiGraphics);
        ItemStack itemStack = getItemStack();
        ItemRenderer itemRenderer = a.getItemRenderer();
        BakedModel model = itemRenderer.getModel(itemStack, (Level) null, (LivingEntity) null, 0);
        emiDrawContextWrap.push();
        try {
            emiDrawContextWrap.matrices().translate(i, i2, i3 + 100.0f + (model.isGui3d() ? 50 : 0));
            emiDrawContextWrap.matrices().translate(8.0d, 8.0d, 0.0d);
            emiDrawContextWrap.matrices().scale(16.0f, -16.0f, 16.0f);
            itemRenderer.render(itemStack, ItemDisplayContext.GUI, false, emiDrawContextWrap.matrices(), multiBufferSource, 15728880, OverlayTexture.NO_OVERLAY, model);
            emiDrawContextWrap.pop();
        } finally {
            emiDrawContextWrap.pop();
        }
    }

    public void render(GuiGraphics guiGraphics, int i, int i2, float f, int i3) {
        int i4;
        int i5;
        EmiDrawContext emiDrawContextWrap = EmiDrawContext.wrap(guiGraphics);
        ItemStack itemStack = getItemStack();
        if ((i3 & 1) != 0) {
            Lighting.setupFor3DItems();
            guiGraphics.renderFakeItem(itemStack, i, i2);
            i4 = i;
            i5 = i2;
            guiGraphics.renderItemDecorations(a.font, itemStack, i4, i5, "");
        } else {
            i4 = i;
            i5 = i2;
        }
        if ((i3 & 2) != 0) {
            EmiRenderHelper.renderAmount(emiDrawContextWrap, i4, i5, EmiPort.literal(this.amount != 1 ? this.amount : ""));
        }
        if ((i3 & 8) != 0) {
            EmiRender.renderRemainderIcon(this, emiDrawContextWrap.raw(), i4, i5);
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/a/e$a.class */
    public static class a implements EmiStackSerializer<e> {
        public String getType() {
            return "conduit";
        }

        public EmiStack create(ResourceLocation resourceLocation, DataComponentPatch dataComponentPatch, long j) {
            Optional optional = dataComponentPatch.get((DataComponentType) MCTechDataComponent.CONDUIT.get());
            if (optional != null && optional.isPresent()) {
                return new e((ResourceKey<mctech.g.a.a<?, ?>>) ((Holder) optional.get()).getKey(), j);
            }
            return EmiStack.EMPTY;
        }
    }
}
