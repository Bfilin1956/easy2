package mctech.blockentities.c;

import appeng.api.config.Actionable;
import appeng.api.crafting.IPatternDetails;
import appeng.api.crafting.PatternDetailsHelper;
import appeng.api.networking.GridFlags;
import appeng.api.networking.GridHelper;
import appeng.api.networking.IGridNode;
import appeng.api.networking.IManagedGridNode;
import appeng.api.networking.crafting.ICraftingProvider;
import appeng.api.networking.security.IActionSource;
import appeng.api.networking.ticking.IGridTickable;
import appeng.api.networking.ticking.TickRateModulation;
import appeng.api.networking.ticking.TickingRequest;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.GenericStack;
import appeng.api.stacks.KeyCounter;
import appeng.api.util.AECableType;
import appeng.core.definitions.AEItems;
import appeng.core.definitions.ItemDefinition;
import appeng.core.settings.TickRates;
import appeng.helpers.patternprovider.PatternProviderReturnInventory;
import appeng.hooks.ticking.TickHandler;
import appeng.me.helpers.BlockEntityNodeListener;
import appeng.me.helpers.IGridConnectedBlockEntity;
import appeng.me.helpers.MachineSource;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import mctech.MCTech;
import mctech.api.util.DirectionList;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechItems;
import mctech.init.MCTechLang;
import mctech.init.MCTechRecipes;
import mctech.init.MCTechTiles;
import mctech.m.b.aI;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/ae.class */
public class ae extends mctech.blockentities.i implements ICraftingProvider, IGridTickable, IGridConnectedBlockEntity, mctech.m.a.k, GeoBlockEntity {
    public static final int a = 36;
    public static final int b = 9;
    public static final int c = 9;
    public static final int d = 3;
    public static final int e = 36;
    public static final int f = 39;
    public static final mctech.m.e.k g = mctech.m.e.k.a("transformation_assembler_patterns", MCTechLang.TOOLTIP_ASSEMBLY_STORAGE_SLOTS, mctech.m.e.k.b);
    private static final String h = "returnInv";
    private final AnimatableInstanceCache i;
    private final mctech.m.c.g j;
    private final mctech.m.c.g k;
    private final IManagedGridNode l;
    private final IActionSource m;
    private final List<IPatternDetails> n;
    private final PatternProviderReturnInventory o;

    public ae(BlockPos blockPos, BlockState blockState) {
        this((BlockEntityType) MCTechTiles.TRANSFORMATION_ASSEMBLER.get(), blockPos, blockState);
    }

    public ae(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 40);
        this.i = GeckoLibUtil.createInstanceCache(this);
        this.j = itemStack -> {
            return itemStack.is((Item) MCTechItems.TRANSFORMATION_ASSEMBLER_PATTERN.get());
        };
        ItemDefinition itemDefinition = AEItems.CAPACITY_CARD;
        Objects.requireNonNull(itemDefinition);
        this.k = itemDefinition::is;
        this.l = GridHelper.createManagedNode(this, BlockEntityNodeListener.INSTANCE).setFlags(new GridFlags[]{GridFlags.REQUIRE_CHANNEL}).setVisualRepresentation(MCTechBlocks.TRANSFORMATION_ASSEMBLER).setInWorldNode(true).setExposedOnSides(EnumSet.allOf(Direction.class)).setTagName("ae2node").addService(ICraftingProvider.class, this).addService(IGridTickable.class, this);
        this.m = new MachineSource(this);
        this.n = new ArrayList();
        this.o = new PatternProviderReturnInventory(() -> {
            this.l.ifPresent((iGrid, iGridNode) -> {
                iGrid.getTickManager().alertDevice(iGridNode);
            });
            setChanged();
        });
        int[] iArr = new int[36];
        for (int i = 0; i < 36; i++) {
            iArr[i] = i;
        }
        int[] iArr2 = new int[3];
        for (int i2 = 0; i2 < 3; i2++) {
            iArr2[i2] = 36 + i2;
        }
        this.inventoryManager.a().a(new mctech.m.g.y(g, iArr).a(mctech.m.e.a.DISABLED).a(this.j).a(DirectionList.ALL)).a(new mctech.m.g.y(mctech.m.e.k.c, iArr2).a(mctech.m.e.a.DISABLED).a(this.k).a(DirectionList.ALL).a(1)).a(mctech.m.g.y.d(39).a(mctech.m.e.a.DISABLED)).i();
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public int getMaxStackSize(int i) {
        if (b(i)) {
            return 1;
        }
        return super.getMaxStackSize(i);
    }

    @Override // mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new aI(this, player, i);
    }

    @Override // mctech.blockentities.q
    public void onLoaded() {
        super.onLoaded();
        if (isSimulating()) {
            GridHelper.onFirstTick(this, aeVar -> {
                aeVar.getMainNode().create(aeVar.getLevel(), aeVar.getBlockPos());
            });
            i();
        }
    }

    @Override // mctech.blockentities.i, mctech.blockentities.q
    public void onUnloaded(boolean z) {
        this.l.destroy();
        super.onUnloaded(z);
    }

    @Override // mctech.blockentities.i, mctech.api.features.IDropProvider
    public void addDrops(List<ItemStack> list) {
        super.addDrops(list);
        Level level = getLevel();
        if (level != null) {
            this.o.addDrops(list, level, getBlockPos());
        }
        this.o.clear();
    }

    public void saveChanges() {
        setChanged();
    }

    public IManagedGridNode getMainNode() {
        return this.l;
    }

    public void a() {
        getMainNode().setExposedOnSides(EnumSet.allOf(Direction.class));
    }

    public AECableType getCableConnectionType(Direction direction) {
        return AECableType.SMART;
    }

    public List<IPatternDetails> getAvailablePatterns() {
        return this.n;
    }

    public boolean isBusy() {
        return (this.l.isActive() && this.o.isEmpty()) ? false : true;
    }

    public boolean pushPattern(IPatternDetails iPatternDetails, KeyCounter[] keyCounterArr) {
        Level level = getLevel();
        if (level == null || level.isClientSide() || !this.l.isActive()) {
            return false;
        }
        return a(iPatternDetails, keyCounterArr);
    }

    public TickingRequest getTickingRequest(IGridNode iGridNode) {
        return new TickingRequest(TickRates.Interface, !g());
    }

    public TickRateModulation tickingRequest(IGridNode iGridNode, int i) {
        if (!this.l.isActive()) {
            return TickRateModulation.SLEEP;
        }
        boolean zH = h();
        if (g()) {
            return zH ? TickRateModulation.URGENT : TickRateModulation.SLOWER;
        }
        return TickRateModulation.SLEEP;
    }

    @Override // mctech.blockentities.i, mctech.m.a.g
    public void setStackInSlot(int i, ItemStack itemStack) {
        boolean z = i >= 0 && i < 36;
        boolean zB = b(i);
        int iD = d();
        super.setStackInSlot(i, itemStack);
        if (zB) {
            c(iD);
            i();
        } else if (z) {
            i();
        }
    }

    public ResourceLocation b() {
        return MCTech.loc("textures/gui/container/gui_transformation_assembler.png");
    }

    public int c() {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            ItemStack stackInSlot = getStackInSlot(36 + i);
            if (AEItems.CAPACITY_CARD.is(stackInSlot)) {
                count += stackInSlot.getCount();
            }
        }
        return Math.min(3, count);
    }

    public int d() {
        return Math.min(36, 9 + (c() * 9));
    }

    public boolean a(int i) {
        return i >= 0 && i < d();
    }

    public boolean b(int i) {
        return i >= 36 && i < 39;
    }

    public boolean a(ItemStack itemStack) {
        mctech.a.b.d.e eVar = (mctech.a.b.d.e) itemStack.get((DataComponentType) MCTechDataComponent.ENCODED_TRANSFORMATION_ASSEMBLER_PATTERN.get());
        if (eVar == null) {
            return false;
        }
        int iD = d();
        for (int i = 0; i < iD; i++) {
            ItemStack stackInSlot = getStackInSlot(i);
            if (!stackInSlot.isEmpty() && eVar.equals((mctech.a.b.d.e) stackInSlot.get((DataComponentType) MCTechDataComponent.ENCODED_TRANSFORMATION_ASSEMBLER_PATTERN.get()))) {
                return true;
            }
        }
        return false;
    }

    public boolean a(IPatternDetails iPatternDetails, KeyCounter[] keyCounterArr) {
        Level level = getLevel();
        if (level == null || level.isClientSide() || !(iPatternDetails instanceof mctech.a.b.d.k)) {
            return false;
        }
        mctech.a.b.d.k kVar = (mctech.a.b.d.k) iPatternDetails;
        AEItemKey definition = kVar.getDefinition();
        mctech.a.b.d.e eVar = (mctech.a.b.d.e) definition.get(kVar.a());
        if (eVar == null || !a(definition.toStack())) {
            return false;
        }
        Optional<RecipeHolder<mctech.u.I>> optionalA = a(level, eVar);
        if (optionalA.isEmpty()) {
            return false;
        }
        mctech.u.I i = (mctech.u.I) optionalA.get().value();
        List<GenericStack> outputs = iPatternDetails.getOutputs();
        if (outputs.isEmpty() || !a(keyCounterArr, eVar, i) || !a(outputs)) {
            return false;
        }
        a(keyCounterArr);
        b(List.copyOf(outputs));
        return true;
    }

    public mctech.m.c.g e() {
        return this.j;
    }

    public mctech.m.c.g f() {
        return this.k;
    }

    private boolean g() {
        return !this.o.isEmpty();
    }

    private boolean h() {
        return (this.o.isEmpty() || this.l.getGrid() == null || !this.o.injectIntoNetwork(this.l.getGrid().getStorageService().getInventory(), this.m, genericStack -> {
        })) ? false : true;
    }

    private boolean a(List<GenericStack> list) {
        for (GenericStack genericStack : list) {
            if (genericStack.what() == null || genericStack.amount() <= 0 || this.o.insert(genericStack.what(), genericStack.amount(), Actionable.SIMULATE, this.m) < genericStack.amount()) {
                return false;
            }
        }
        return true;
    }

    private void b(List<GenericStack> list) {
        TickHandler.instance().addCallable((LevelAccessor) null, level -> {
            if (isRemoved()) {
                return;
            }
            c((List<GenericStack>) list);
        });
    }

    private void c(List<GenericStack> list) {
        Level level;
        boolean z = false;
        for (GenericStack genericStack : list) {
            AEItemKey aEItemKeyWhat = genericStack.what();
            long jAmount = genericStack.amount();
            if (aEItemKeyWhat != null && jAmount > 0) {
                if (this.l.getGrid() != null) {
                    jAmount -= this.l.getGrid().getStorageService().getInventory().insert(aEItemKeyWhat, jAmount, Actionable.MODULATE, this.m);
                }
                if (jAmount > 0) {
                    long jInsert = this.o.insert(aEItemKeyWhat, jAmount, Actionable.MODULATE, this.m);
                    long j = jAmount - jInsert;
                    if (jInsert > 0) {
                        z = true;
                    }
                    if (j > 0 && (level = getLevel()) != null && (aEItemKeyWhat instanceof AEItemKey)) {
                        Containers.dropItemStack(level, getBlockPos().getX(), getBlockPos().getY(), getBlockPos().getZ(), aEItemKeyWhat.toStack((int) Math.min(2147483647L, j)));
                    }
                }
            }
        }
        if (z) {
            this.l.ifPresent((iGrid, iGridNode) -> {
                iGrid.getTickManager().alertDevice(iGridNode);
            });
        }
        setChanged();
    }

    private void i() {
        IPatternDetails iPatternDetailsDecodePattern;
        this.n.clear();
        Level level = getLevel();
        if (level == null) {
            return;
        }
        int iD = d();
        for (int i = 0; i < iD; i++) {
            ItemStack stackInSlot = getStackInSlot(i);
            if (!stackInSlot.isEmpty() && (iPatternDetailsDecodePattern = PatternDetailsHelper.decodePattern(stackInSlot, level)) != null) {
                this.n.add(iPatternDetailsDecodePattern);
            }
        }
        ICraftingProvider.requestUpdate(this.l);
    }

    private void c(int i) {
        Level level;
        int iD = d();
        if (iD >= i || (level = getLevel()) == null || level.isClientSide()) {
            return;
        }
        BlockPos blockPos = getBlockPos();
        for (int i2 = iD; i2 < i; i2++) {
            ItemStack stackInSlot = getStackInSlot(i2);
            if (!stackInSlot.isEmpty()) {
                Containers.dropItemStack(level, blockPos.getX(), blockPos.getY(), blockPos.getZ(), stackInSlot);
                setStackInSlotSilent(i2, ItemStack.EMPTY);
            }
        }
        setChanged();
    }

    private Optional<RecipeHolder<mctech.u.I>> a(Level level, mctech.a.b.d.e eVar) {
        ItemStack itemStack = (ItemStack) eVar.a().stream().map((v0) -> {
            return v0.c();
        }).filter(itemStack2 -> {
            return !itemStack2.isEmpty();
        }).findFirst().orElse(ItemStack.EMPTY);
        if (itemStack.isEmpty()) {
            return Optional.empty();
        }
        return level.getRecipeManager().getAllRecipesFor(MCTechRecipes.type(mctech.i.i.MATRIX_CONVERTER.getSerializedName())).stream().filter(recipeHolder -> {
            return ((mctech.u.I) recipeHolder.value()).a(itemStack);
        }).filter(recipeHolder2 -> {
            return ItemStack.isSameItemSameComponents(eVar.d().copyWithCount(1), ((mctech.u.I) recipeHolder2.value()).d().copyWithCount(1));
        }).filter(recipeHolder3 -> {
            return ((mctech.u.I) recipeHolder3.value()).a() == itemStack.getCount();
        }).findFirst();
    }

    private boolean a(KeyCounter[] keyCounterArr, mctech.a.b.d.e eVar, mctech.u.I i) {
        if (i.a() > 0 && a(keyCounterArr, i.c()) < i.a()) {
            return false;
        }
        for (mctech.a.b.e.d dVar : eVar.a()) {
            if (!dVar.c().isEmpty() && a(keyCounterArr, dVar.c(), eVar.e()) < dVar.c().getCount()) {
                return false;
            }
        }
        return true;
    }

    private long a(KeyCounter[] keyCounterArr, mctech.u.c.b bVar) {
        long j = 0;
        for (KeyCounter keyCounter : keyCounterArr) {
            for (AEItemKey aEItemKey : keyCounter.keySet()) {
                if ((aEItemKey instanceof AEItemKey) && bVar.a(aEItemKey.toStack())) {
                    j += keyCounter.get(aEItemKey);
                }
            }
        }
        return j;
    }

    private long a(KeyCounter[] keyCounterArr, ItemStack itemStack, boolean z) {
        boolean zIsSameItemSameComponents;
        long j = 0;
        for (KeyCounter keyCounter : keyCounterArr) {
            for (AEItemKey aEItemKey : keyCounter.keySet()) {
                if (aEItemKey instanceof AEItemKey) {
                    ItemStack stack = aEItemKey.toStack();
                    if (z) {
                        zIsSameItemSameComponents = ItemStack.isSameItem(stack, itemStack);
                    } else {
                        zIsSameItemSameComponents = ItemStack.isSameItemSameComponents(stack, itemStack);
                    }
                    if (zIsSameItemSameComponents) {
                        j += keyCounter.get(aEItemKey);
                    }
                }
            }
        }
        return j;
    }

    private void a(KeyCounter[] keyCounterArr) {
        for (KeyCounter keyCounter : keyCounterArr) {
            keyCounter.clear();
        }
    }

    @NotNull
    public BlockEntityType<?> getType() {
        return (BlockEntityType) MCTechTiles.TRANSFORMATION_ASSEMBLER.get();
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.i;
    }
}
