package mctech.integration.jade.core;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import mctech.MCTech;
import mctech.m.e.k;
import mctech.utils.c.c;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec2;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.fluids.FluidStack;
import net.neoforged.neoforge.fluids.capability.IFluidHandler;
import net.neoforged.neoforge.fluids.capability.templates.FluidTank;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.IServerDataProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.JadeIds;
import snownee.jade.api.config.IPluginConfig;
import snownee.jade.api.fluid.JadeFluidObject;
import snownee.jade.api.ui.BoxStyle;
import snownee.jade.api.ui.IBoxElement;
import snownee.jade.api.ui.IDisplayHelper;
import snownee.jade.api.ui.IElement;
import snownee.jade.api.ui.IElementHelper;
import snownee.jade.api.ui.ScreenDirection;
import snownee.jade.impl.ui.HorizontalLineElement;
import snownee.jade.impl.ui.SimpleProgressStyle;
import snownee.jade.impl.ui.SpacerElement;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/core/BlockComponent.class */
public abstract class BlockComponent implements IBlockComponentProvider, IServerDataProvider<BlockAccessor> {
    private static final int PROGRESS_BAR_HEIGHT = 13;
    private static final int MIN_PROGRESS_WIDTH = 100;
    private static final int PROGRESS_LABEL_PADDING = 4;
    private static final Vec2 PROGRESS_DESCRIPTION_OFFSET = new Vec2(0.0f, 3.0f);
    private static final Pattern CAMEL_CASE_WORD_BOUNDARY = Pattern.compile("([a-z])([A-Z])");
    protected final NbtOps nbtOps = NbtOps.INSTANCE;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/core/BlockComponent$Consumer.class */
    @FunctionalInterface
    public interface Consumer<D> {
        void accept(@NotNull ITooltip iTooltip, @NotNull D d);
    }

    public IElement text(Component component) {
        return IElementHelper.get().text(component).message((String) null);
    }

    public IElement text(String str, Object... objArr) {
        return text(Component.translatable(str, objArr));
    }

    public IElement horizontalLine() {
        return new HorizontalLineElement();
    }

    public IElement space(int i, int i2) {
        return new SpacerElement(new Vec2(i, i2));
    }

    public IElement newLine() {
        return space(0, 0);
    }

    public IElement text(Component component, Object... objArr) {
        TranslatableContents contents = component.getContents();
        if (contents instanceof TranslatableContents) {
            return text(Component.translatable(contents.getKey(), objArr));
        }
        return text(component);
    }

    public void recipeProgress(ITooltip iTooltip, float f, float f2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            return;
        }
        recipeProgress(iTooltip, f, f2, Component.literal("Прогресс: " + Mth.floor(Mth.clamp(f / f2, 0.0f, 1.0f) * 100.0f) + "%").withStyle(ChatFormatting.WHITE));
    }

    public void recipeProgress(ITooltip iTooltip, float f, float f2, MutableComponent mutableComponent) {
        if (f <= 0.0f || f2 <= 0.0f) {
            return;
        }
        float fClamp = Mth.clamp(f / f2, 0.0f, 1.0f);
        IDisplayHelper iDisplayHelper = IDisplayHelper.get();
        MutableComponent mutableComponentWithStyle = Component.literal(String.format(" (%s/%s)", iDisplayHelper.humanReadableNumber(f, "", false), iDisplayHelper.humanReadableNumber(f2, "", false))).withStyle(ChatFormatting.GRAY);
        BoxStyle.GradientBorder gradientBorderClone = BoxStyle.GradientBorder.DEFAULT_NESTED_BOX.clone();
        int iMax = Math.max(100, Minecraft.getInstance().font.width(mutableComponent) + 4);
        gradientBorderClone.borderColor = uniformBorder(144);
        iTooltip.add(IElementHelper.get().progress(fClamp, mutableComponent, new SimpleProgressStyle().color(255, 144).fitContentX(true).fitContentY(false), gradientBorderClone, true).size(new Vec2(iMax, 13.0f)));
        appendProgressDescription(iTooltip, mutableComponentWithStyle);
    }

    public void progressWithTime(ITooltip iTooltip, int i, int i2) {
        if (i2 > 360000) {
            recipeProgress(iTooltip, i / 72000.0f, i2 / 72000.0f, Component.literal(String.format("Прогресс: %s /%.1f ч", Integer.valueOf(i), Float.valueOf(i2 / 72000.0f))));
            return;
        }
        if (i2 > 6000) {
            recipeProgress(iTooltip, i / 1200.0f, i2 / 1200.0f, Component.literal(String.format("Прогресс: %s / %.1f м", Integer.valueOf(i), Float.valueOf(i2 / 1200.0f))));
        } else if (i2 <= 800) {
            recipeProgress(iTooltip, i, i2, Component.literal(String.format("Прогресс: %s / %d t", Integer.valueOf(i), Integer.valueOf(i2))));
        } else {
            recipeProgress(iTooltip, i / 20.0f, i2 / 20.0f, Component.literal(String.format("Прогресс: %s / %d с", Integer.valueOf(i), Integer.valueOf(i2 / 20))));
        }
    }

    public void genericProgress(ITooltip iTooltip, float f, float f2, MutableComponent mutableComponent, int i, int i2) {
        if (f <= 0.0f || f2 <= 0.0f) {
            return;
        }
        float fClamp = Mth.clamp(f / f2, 0.0f, 1.0f);
        IDisplayHelper iDisplayHelper = IDisplayHelper.get();
        MutableComponent mutableComponentWithStyle = Component.literal(String.format(" (%s/%s)", iDisplayHelper.humanReadableNumber(f, "", false), iDisplayHelper.humanReadableNumber(f2, "", false))).withStyle(ChatFormatting.GRAY);
        BoxStyle.GradientBorder gradientBorderClone = BoxStyle.GradientBorder.DEFAULT_NESTED_BOX.clone();
        int iMax = Math.max(100, Minecraft.getInstance().font.width(mutableComponent) + 4);
        gradientBorderClone.borderColor = uniformBorder(i2);
        iTooltip.add(IElementHelper.get().progress(fClamp, mutableComponent, new SimpleProgressStyle().color(i, i2).fitContentX(true).fitContentY(false), gradientBorderClone, true).size(new Vec2(iMax, 13.0f)));
        appendProgressDescription(iTooltip, mutableComponentWithStyle);
    }

    public void slotType(ITooltip iTooltip, ItemsHolder itemsHolder) {
        k kVarSlotType = itemsHolder.slotType();
        List<ItemStack> listItems = itemsHolder.items();
        tooltipGroup(iTooltip, kVarSlotType.b(), (iTooltip2, list) -> {
            int i = 0;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ItemStack itemStack = (ItemStack) it.next();
                if (!itemStack.isEmpty()) {
                    if (i == 0) {
                        iTooltip2.add(IElementHelper.get().item(itemStack));
                    } else {
                        iTooltip2.append(IElementHelper.get().item(itemStack));
                    }
                    i = (i + 1) % 8;
                }
            }
        }, listItems, !listItems.isEmpty());
    }

    public void energyStorage(ITooltip iTooltip, int i, int i2, String str) {
        MutableComponent mutableComponentWithStyle;
        boolean zEquals = str.equals("EU");
        if (zEquals) {
            mutableComponentWithStyle = Component.translatable("mctech.probe.eu.storage.name", new Object[]{c.c.format(i)}).withStyle(ChatFormatting.WHITE);
        } else {
            mutableComponentWithStyle = Component.literal(String.format("Топливо: %s", c.c.format(i))).withStyle(ChatFormatting.WHITE);
        }
        MutableComponent mutableComponent = mutableComponentWithStyle;
        IDisplayHelper iDisplayHelper = IDisplayHelper.get();
        MutableComponent mutableComponentLiteral = Component.literal(String.format(" (%s/%s %s) %s%%", iDisplayHelper.humanReadableNumber(i, "", false), iDisplayHelper.humanReadableNumber(i2, "", false), str, Integer.valueOf(percentOf(i, i2))));
        BoxStyle.GradientBorder gradientBorderClone = BoxStyle.GradientBorder.DEFAULT_NESTED_BOX.clone();
        int i3 = zEquals ? 16711680 : 16284771;
        int i4 = zEquals ? 9437184 : 16284771;
        int iMax = Math.max(100, Minecraft.getInstance().font.width(mutableComponent) + 4);
        gradientBorderClone.borderColor = uniformBorder(i4);
        iTooltip.add(IElementHelper.get().progress(ratio(i, i2), mutableComponent, new SimpleProgressStyle().fitContentX(true).color(i3, i4).fitContentY(false), gradientBorderClone, true).size(new Vec2(iMax, 13.0f)));
        appendProgressDescription(iTooltip, mutableComponentLiteral);
    }

    public void fluidTank(ITooltip iTooltip, FluidStack fluidStack, int i) {
        if (fluidStack.isEmpty() || fluidStack.getFluid() == Fluids.EMPTY) {
            return;
        }
        MutableComponent mutableComponentCopy = fluidStack.getHoverName().copy();
        int amount = fluidStack.getAmount();
        IDisplayHelper iDisplayHelper = IDisplayHelper.get();
        MutableComponent mutableComponentLiteral = Component.literal(String.format(" (%s/%s мВ) %s%%", iDisplayHelper.humanReadableNumber(amount, "", false), iDisplayHelper.humanReadableNumber(i, "", false), Integer.valueOf(percentOf(amount, i))));
        BoxStyle.GradientBorder gradientBorderClone = BoxStyle.GradientBorder.DEFAULT_NESTED_BOX.clone();
        int tintColor = IClientFluidTypeExtensions.of(fluidStack.getFluid()).getTintColor(fluidStack);
        int iMax = Math.max(100, Minecraft.getInstance().font.width(mutableComponentCopy) + 4);
        gradientBorderClone.borderColor = uniformBorder(tintColor);
        iTooltip.add(IElementHelper.get().progress(ratio(amount, i), mutableComponentCopy.withStyle(ChatFormatting.WHITE), new SimpleProgressStyle().fitContentX(true).fitContentY(false).overlay(IElementHelper.get().fluid(JadeFluidObject.of(fluidStack.getFluid()))), gradientBorderClone, true).size(new Vec2(iMax, 13.0f)));
        appendProgressDescription(iTooltip, mutableComponentLiteral);
    }

    public void append(ITooltip iTooltip, BlockAccessor blockAccessor, CompoundTag compoundTag) {
    }

    public CompoundTag write(BlockAccessor blockAccessor) {
        return new CompoundTag();
    }

    public final void appendTooltip(@NotNull ITooltip iTooltip, @NotNull BlockAccessor blockAccessor, @NotNull IPluginConfig iPluginConfig) {
        iTooltip.remove(JadeIds.CORE_MOD_NAME);
        iTooltip.remove(JadeIds.UNIVERSAL_ITEM_STORAGE);
        iTooltip.remove(JadeIds.UNIVERSAL_ITEM_STORAGE_DEFAULT);
        iTooltip.remove(JadeIds.UNIVERSAL_ITEM_STORAGE_DETAILED_AMOUNT);
        iTooltip.remove(JadeIds.UNIVERSAL_ITEM_STORAGE_NORMAL_AMOUNT);
        iTooltip.remove(JadeIds.UNIVERSAL_ITEM_STORAGE_SHOW_NAME_AMOUNT);
        iTooltip.remove(JadeIds.UNIVERSAL_ITEM_STORAGE_ITEMS_PER_LINE);
        iTooltip.remove(JadeIds.UNIVERSAL_FLUID_STORAGE);
        iTooltip.remove(JadeIds.UNIVERSAL_FLUID_STORAGE_DEFAULT);
        iTooltip.remove(JadeIds.UNIVERSAL_FLUID_STORAGE_DETAILED);
        iTooltip.remove(JadeIds.UNIVERSAL_FLUID_STORAGE_STYLE);
        iTooltip.remove(JadeIds.UNIVERSAL_ENERGY_STORAGE);
        iTooltip.remove(JadeIds.UNIVERSAL_ENERGY_STORAGE_DEFAULT);
        iTooltip.remove(JadeIds.UNIVERSAL_ENERGY_STORAGE_DETAILED);
        iTooltip.remove(JadeIds.UNIVERSAL_ENERGY_STORAGE_STYLE);
        CompoundTag serverData = blockAccessor.getServerData();
        if (requireEUReader() && !hasEUReader(serverData)) {
            return;
        }
        if ((!requireThermometer() || hasThermometer(serverData)) && serverData.contains(getUid().getPath())) {
            append(iTooltip, blockAccessor, serverData.getCompound(getUid().getPath()));
        }
    }

    public final void appendServerData(@NotNull CompoundTag compoundTag, @NotNull BlockAccessor blockAccessor) {
    }

    private boolean hasEUReader(CompoundTag compoundTag) {
        return compoundTag.contains("hasEuReader") && compoundTag.getBoolean("hasEuReader");
    }

    private boolean hasThermometer(CompoundTag compoundTag) {
        return compoundTag.contains("hasThermometer") && compoundTag.getBoolean("hasThermometer");
    }

    public boolean requireEUReader() {
        return false;
    }

    public boolean requireThermometer() {
        return false;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/core/BlockComponent$ItemsHolder.class */
    public static final class ItemsHolder extends Record {
        private final k slotType;
        private final List<ItemStack> items;
        public static final Codec<ItemsHolder> CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.STRING.xmap(k::a, (v0) -> {
                return v0.a();
            }).fieldOf("slotType").forGetter((v0) -> {
                return v0.slotType();
            }), Codec.list(ItemStack.OPTIONAL_CODEC).fieldOf("items").forGetter((v0) -> {
                return v0.items();
            })).apply(instance, ItemsHolder::new);
        });

        public ItemsHolder(k kVar, List<ItemStack> list) {
            this.slotType = kVar;
            this.items = list;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, ItemsHolder.class), ItemsHolder.class, "slotType;items", "FIELD:Lmctech/integration/jade/core/BlockComponent$ItemsHolder;->slotType:Lmctech/m/e/k;", "FIELD:Lmctech/integration/jade/core/BlockComponent$ItemsHolder;->items:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, ItemsHolder.class), ItemsHolder.class, "slotType;items", "FIELD:Lmctech/integration/jade/core/BlockComponent$ItemsHolder;->slotType:Lmctech/m/e/k;", "FIELD:Lmctech/integration/jade/core/BlockComponent$ItemsHolder;->items:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, ItemsHolder.class, Object.class), ItemsHolder.class, "slotType;items", "FIELD:Lmctech/integration/jade/core/BlockComponent$ItemsHolder;->slotType:Lmctech/m/e/k;", "FIELD:Lmctech/integration/jade/core/BlockComponent$ItemsHolder;->items:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public k slotType() {
            return this.slotType;
        }

        public List<ItemStack> items() {
            return this.items;
        }

        public boolean isEmpty() {
            return this.items.isEmpty() || this.items.stream().allMatch((v0) -> {
                return v0.isEmpty();
            });
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/integration/jade/core/BlockComponent$FluidsHolder.class */
    public static final class FluidsHolder extends Record {
        private final List<FluidTank> fluidTanks;
        private static final Codec<FluidTank> FLUID_TANK_CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.INT.fieldOf("capacity").forGetter((v0) -> {
                return v0.getCapacity();
            }), Codec.INT.fieldOf("amount").forGetter((v0) -> {
                return v0.getFluidAmount();
            }), FluidStack.OPTIONAL_CODEC.fieldOf("fluid").forGetter((v0) -> {
                return v0.getFluid();
            })).apply(instance, (num, num2, fluidStack) -> {
                FluidTank fluidTank = new FluidTank(num.intValue());
                fluidTank.setFluid(fluidStack.copyWithAmount(num2.intValue()));
                return fluidTank;
            });
        });
        public static final Codec<FluidsHolder> CODEC = RecordCodecBuilder.create(instance -> {
            return instance.group(Codec.list(FLUID_TANK_CODEC).fieldOf("items").forGetter((v0) -> {
                return v0.fluidTanks();
            })).apply(instance, FluidsHolder::new);
        });

        public FluidsHolder(List<FluidTank> list) {
            this.fluidTanks = list;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, FluidsHolder.class), FluidsHolder.class, "fluidTanks", "FIELD:Lmctech/integration/jade/core/BlockComponent$FluidsHolder;->fluidTanks:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, FluidsHolder.class), FluidsHolder.class, "fluidTanks", "FIELD:Lmctech/integration/jade/core/BlockComponent$FluidsHolder;->fluidTanks:Ljava/util/List;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, FluidsHolder.class, Object.class), FluidsHolder.class, "fluidTanks", "FIELD:Lmctech/integration/jade/core/BlockComponent$FluidsHolder;->fluidTanks:Ljava/util/List;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public List<FluidTank> fluidTanks() {
            return this.fluidTanks;
        }

        public static FluidsHolder of(@Nullable IFluidHandler iFluidHandler) {
            if (iFluidHandler == null) {
                return new FluidsHolder(new ArrayList());
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < iFluidHandler.getTanks(); i++) {
                FluidStack fluidInTank = iFluidHandler.getFluidInTank(i);
                if (!fluidInTank.isEmpty()) {
                    FluidTank fluidTank = new FluidTank(iFluidHandler.getTankCapacity(i));
                    fluidTank.setFluid(fluidInTank);
                    arrayList.add(fluidTank);
                }
            }
            return new FluidsHolder(arrayList);
        }

        public static FluidsHolder of(FluidTank... fluidTankArr) {
            return new FluidsHolder(Arrays.asList(fluidTankArr));
        }

        public boolean isEmpty() {
            return this.fluidTanks.isEmpty() || this.fluidTanks.stream().allMatch(fluidTank -> {
                if (fluidTank.getFluidAmount() <= 0) {
                    return true;
                }
                FluidStack fluid = fluidTank.getFluid();
                return fluid.isEmpty() || fluid.getFluid() == Fluids.EMPTY;
            });
        }
    }

    public <O> void tooltipGroup(ITooltip iTooltip, Consumer<O> consumer, O o, boolean z) {
        if (z) {
            ITooltip iTooltip2 = IElementHelper.get().tooltip();
            consumer.accept(iTooltip2, o);
            addBoxedGroup(iTooltip, iTooltip2, BoxStyle.getViewGroup().clone());
        }
    }

    public <O> void tooltipGroup(ITooltip iTooltip, Component component, Consumer<O> consumer, O o, boolean z) {
        if (z) {
            ITooltip iTooltip2 = IElementHelper.get().tooltip();
            consumer.accept(iTooltip2, o);
            prependTitleIfNonEmpty(iTooltip2, component);
            addBoxedGroup(iTooltip, iTooltip2, BoxStyle.getViewGroup().clone());
        }
    }

    public <O> void tooltipGroup(ITooltip iTooltip, Component component, int i, Consumer<O> consumer, O o, boolean z) {
        if (z) {
            ITooltip iTooltip2 = IElementHelper.get().tooltip();
            consumer.accept(iTooltip2, o);
            prependTitleIfNonEmpty(iTooltip2, component);
            addBoxedGroup(iTooltip, iTooltip2, boxStyle(i));
        }
    }

    public BoxStyle boxStyle(int i) {
        BoxStyle.GradientBorder gradientBorderClone = BoxStyle.GradientBorder.DEFAULT_VIEW_GROUP.clone();
        gradientBorderClone.bgColor = i;
        gradientBorderClone.borderColor = new int[]{i, i, i, i};
        return gradientBorderClone;
    }

    public static ResourceLocation makeId(Object obj) {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "jade_" + CAMEL_CASE_WORD_BOUNDARY.matcher(obj.getClass().getSimpleName()).replaceAll("$1 $2").toLowerCase().replace(" ", "_"));
    }

    private void appendProgressDescription(ITooltip iTooltip, Component component) {
        iTooltip.append(text(component).translate(PROGRESS_DESCRIPTION_OFFSET).align(IElement.Align.RIGHT));
    }

    private static int[] uniformBorder(int i) {
        return new int[]{i, i, i, i};
    }

    private static float ratio(int i, int i2) {
        if (i2 > 0) {
            return Mth.clamp(i / i2, 0.0f, 1.0f);
        }
        return 0.0f;
    }

    private static int percentOf(int i, int i2) {
        if (i2 > 0) {
            return Mth.floor(((double) (i / i2)) * 100.0d);
        }
        return 0;
    }

    private void prependTitleIfNonEmpty(ITooltip iTooltip, Component component) {
        if (!iTooltip.isEmpty()) {
            iTooltip.add(0, newLine());
            iTooltip.add(0, text(component));
        }
    }

    private void addBoxedGroup(ITooltip iTooltip, ITooltip iTooltip2, BoxStyle boxStyle) {
        if (iTooltip2.isEmpty()) {
            return;
        }
        IBoxElement iBoxElementBox = IElementHelper.get().box(iTooltip2, boxStyle);
        iTooltip.add(iBoxElementBox);
        if (iBoxElementBox.getStyle().hasRoundCorner()) {
            iTooltip.setLineMargin(-1, ScreenDirection.UP, 3);
            iTooltip.setLineMargin(-1, ScreenDirection.DOWN, 3);
        }
    }

    private String formatTimeLeft(long j) {
        if (j <= 0) {
            return "";
        }
        long j2 = j / 20;
        long j3 = j2 / 3600;
        long j4 = (j2 % 3600) / 60;
        long j5 = j2 % 60;
        if (j3 > 0) {
            return String.format("~%dh %02dm", Long.valueOf(j3), Long.valueOf(j4));
        }
        if (j4 > 0) {
            return String.format("~%dm %02ds", Long.valueOf(j4), Long.valueOf(j5));
        }
        return String.format("~%ds", Long.valueOf(j5));
    }
}
