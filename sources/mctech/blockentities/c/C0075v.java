package mctech.blockentities.c;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import mctech.MCTech;
import mctech.api.items.IUpgradeItem;
import mctech.api.network.buffer.NetworkInfo;
import mctech.api.util.DirectionList;
import mctech.blockentities.BasicMachineTileEntity;
import mctech.u.C0198z;
import net.mcskill.msregistry.core.MachineTier;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

/* JADX INFO: renamed from: mctech.blockentities.c.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/c/v.class */
public class C0075v extends BasicMachineTileEntity implements mctech.v.f.b, GeoBlockEntity {
    private final AnimatableInstanceCache f;
    private static final int g = 1;
    private static final int h = 3;

    @NetworkInfo(fieldName = "inputStack")
    public String b;
    private String i;
    private ItemStack j;
    public float c;
    private static final ResourceLocation d = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "geo/greenhouse.geo.json");
    private static final ResourceLocation[] e = new ResourceLocation[2];
    public static final Set<Item> a = new HashSet();

    static {
        e[0] = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/machine/custom/greenhouse/greenhouse_off.png");
        e[1] = ResourceLocation.fromNamespaceAndPath(MCTech.MODID, "textures/block/machine/custom/greenhouse/greenhouse_on.png");
    }

    public C0075v(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState, 4, 4, mctech.h.a.b.k.a, 1200, mctech.h.a.b.k.b, mctech.h.a.b.k.c);
        this.f = GeckoLibUtil.createInstanceCache(this);
        this.j = ItemStack.EMPTY;
        this.b = "";
        this.i = "";
        this.inventoryManager = new mctech.m.e.j<>(this, 4);
        this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.g, IntStream.range(0, 1).toArray()).a(DirectionList.ALL).a(mctech.m.e.a.IMPORT).a(new mctech.m.c.m(this)));
        this.inventoryManager.a(new mctech.m.g.y(mctech.m.e.k.l, IntStream.range(1, 4).toArray()).a(DirectionList.ALL).a(mctech.m.e.a.EXPORT).a(mctech.m.c.r.c).b(mctech.m.c.r.d));
        this.inventoryManager.a(this);
        this.inventoryManager.i();
        addNetworkFields(this);
    }

    public static void a(RecipeManager recipeManager) {
        a.clear();
        ((List) recipeManager.getAllRecipesFor((RecipeType) mctech.u.E.o.get()).stream().map(recipeHolder -> {
            return Arrays.asList(((C0198z) recipeHolder.value()).h().getItems());
        }).collect(Collectors.toList())).forEach(list -> {
            for (int i = 0; i < list.size(); i++) {
                a.add(((ItemStack) list.get(i)).getItem());
            }
        });
    }

    @NotNull
    public MachineTier machineTier() {
        return MachineTier.T3;
    }

    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
    }

    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.f;
    }

    @Override // mctech.api.tiles.IRecipeMachine
    public <I extends RecipeInput, T extends Recipe<I>> RecipeType<T> getRecipeType() {
        return (RecipeType) mctech.u.E.m.get();
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.m.a.d
    public mctech.m.b.S createContainer(Player player, InteractionHand interactionHand, Direction direction, int i) {
        return new mctech.m.b.M(this, player, i);
    }

    @Override // mctech.api.features.redstone.IComparable
    public boolean isAllowingUI() {
        return false;
    }

    @Override // mctech.blockentities.i, mctech.m.e.e
    public boolean allowsUI() {
        return false;
    }

    @Override // mctech.blockentities.q, mctech.api.network.tile.INetworkClientEventListener
    public void onClientDataReceived(Player player, int i, int i2) {
    }

    @Override // mctech.v.f.b
    public ResourceLocation c() {
        return d;
    }

    @Override // mctech.v.f.b
    public ResourceLocation a(BlockState blockState) {
        return e[(blockState == null || !((Boolean) blockState.getValue(mctech.blocks.c.m.ACTIVE)).booleanValue()) ? (char) 0 : (char) 1];
    }

    @Override // mctech.blockentities.BasicMachineTileEntity, mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return EnumSet.of(IUpgradeItem.UpgradeType.SPEED_MOD, IUpgradeItem.UpgradeType.ENERGY_MOD, IUpgradeItem.UpgradeType.SPEED_MOD_COMPOSITE, IUpgradeItem.UpgradeType.SPEED_MOD_NANO, IUpgradeItem.UpgradeType.SPEED_MOD_QUANT, IUpgradeItem.UpgradeType.SPEED_MOD_TITAN, IUpgradeItem.UpgradeType.SPEED_MOD_RUBIDIUM, IUpgradeItem.UpgradeType.COMPLEX_HANDLER_MOD, IUpgradeItem.UpgradeType.AUDIO_MOD, IUpgradeItem.UpgradeType.ADMIN_MOD, IUpgradeItem.UpgradeType.TRANSFORMER_MOD);
    }

    public ItemStack a() {
        if (!this.i.equals(this.b)) {
            this.i = this.b;
            BuiltInRegistries.ITEM.getOptional(ResourceLocation.parse(this.b)).ifPresentOrElse(item -> {
                this.j = new ItemStack(item);
            }, () -> {
                this.j = ItemStack.EMPTY;
            });
        }
        return this.j;
    }
}
