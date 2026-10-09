package mctech.g.d.b;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import mctech.MCTech;
import mctech.g.a.d;
import mctech.g.a.l;
import mctech.g.d.e.h;
import mctech.init.MCTechBlocks;
import mctech.init.MCTechCreativeTabs;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechLang;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/b/b.class */
@EventBusSubscriber(modid = MCTech.MODID)
public class b extends BlockItem {
    private static boolean a = false;

    public b(Block block, Item.Properties properties) {
        super(block, properties);
    }

    @NotNull
    public Component getName(ItemStack itemStack) {
        Holder holder = (Holder) itemStack.get(MCTechDataComponent.CONDUIT);
        if (holder == null) {
            return super.getName(itemStack);
        }
        return ((mctech.g.a.a) holder.value()).b();
    }

    @NotNull
    public String getDescriptionId() {
        return getOrCreateDescriptionId();
    }

    @NotNull
    public InteractionResult place(BlockPlaceContext blockPlaceContext) {
        Level level = blockPlaceContext.getLevel();
        Player player = blockPlaceContext.getPlayer();
        BlockPos clickedPos = blockPlaceContext.getClickedPos();
        BlockState blockState = level.getBlockState(clickedPos);
        if (!blockState.canBeReplaced()) {
            return blockState.useItemOn(blockPlaceContext.getItemInHand(), level, player, blockPlaceContext.getHand(), blockPlaceContext.getHitResult().withPosition(clickedPos)).result();
        }
        return super.place(blockPlaceContext);
    }

    protected boolean placeBlock(BlockPlaceContext blockPlaceContext, @NotNull BlockState blockState) {
        mctech.g.a.d.a aVar;
        ItemStack itemInHand = blockPlaceContext.getItemInHand();
        if (!itemInHand.has(MCTechDataComponent.CONDUIT) && ((aVar = (mctech.g.a.d.a) itemInHand.getCapability(d.a)) == null || !aVar.a())) {
            return false;
        }
        boolean zPlaceBlock = super.placeBlock(blockPlaceContext, blockState);
        if (zPlaceBlock) {
            Level level = blockPlaceContext.getLevel();
            BlockEntity blockEntity = level.getBlockEntity(blockPlaceContext.getClickedPos());
            if (blockEntity instanceof mctech.g.d.a.a.b) {
                mctech.g.d.a.a.b bVar = (mctech.g.d.a.a.b) blockEntity;
                Direction clickedFace = blockPlaceContext.getClickedFace();
                Direction horizontalDirection = blockPlaceContext.getHorizontalDirection();
                if (level.getBlockState(blockPlaceContext.getClickedPos().relative(clickedFace.getOpposite())).is((Block) MCTechBlocks.CONDUIT.get())) {
                    bVar.d = clickedFace.getOpposite();
                } else if (level.getBlockState(blockPlaceContext.getClickedPos().relative(horizontalDirection.getOpposite())).is((Block) MCTechBlocks.CONDUIT.get())) {
                    bVar.d = horizontalDirection.getOpposite();
                }
            }
        }
        return zPlaceBlock;
    }

    public void appendHoverText(ItemStack itemStack, @NotNull Item.TooltipContext tooltipContext, @NotNull List<Component> list, @NotNull TooltipFlag tooltipFlag) {
        Holder holder = (Holder) itemStack.get(MCTechDataComponent.CONDUIT);
        if (holder != null) {
            mctech.g.a.a aVar = (mctech.g.a.a) holder.value();
            Objects.requireNonNull(list);
            aVar.addToTooltip(tooltipContext, (v1) -> {
                r2.add(v1);
            }, tooltipFlag);
            boolean z = !tooltipFlag.hasShiftDown() && (((mctech.g.a.a) holder.value()).l() || ((mctech.g.a.a) holder.value()).m());
            if (((mctech.g.a.a) holder.value()).m() && tooltipFlag.hasShiftDown()) {
                list.add(h.b(MCTechLang.TOOLTIP_GRAPH_TICK_RATE, Integer.valueOf(20 / ((mctech.g.a.a) holder.value()).c())));
            }
            if (z) {
                list.add(MCTechLang.TOOLTIP_SHIFT.withStyle(new ChatFormatting[]{ChatFormatting.GRAY, ChatFormatting.ITALIC}));
            }
        }
        super.appendHoverText(itemStack, tooltipContext, list, tooltipFlag);
    }

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void a(BuildCreativeModeTabContentsEvent buildCreativeModeTabContentsEvent) {
        if (buildCreativeModeTabContentsEvent.getTab() == MCTechCreativeTabs.CONDUITS_TAB.get()) {
            CreativeModeTab tab = buildCreativeModeTabContentsEvent.getTab();
            List list = buildCreativeModeTabContentsEvent.getParameters().holders().lookupOrThrow(l.a.f).listElements().toList();
            List<Class> list2 = list.stream().map(reference -> {
                return ((mctech.g.a.a) reference.value()).getClass();
            }).sorted(Comparator.comparing((v0) -> {
                return v0.getName();
            })).distinct().toList();
            if (!a) {
                tab.iconItemStack = mctech.g.a.b.a((Holder<mctech.g.a.a<?, ?>>) list.getFirst(), 1);
                a = true;
            }
            for (Class cls : list2) {
                Iterator it = list.stream().filter(reference2 -> {
                    return ((mctech.g.a.a) reference2.value()).getClass() == cls;
                }).sorted((reference3, reference4) -> {
                    return mctech.g.a.b.a((mctech.g.a.a) reference3.value(), (mctech.g.a.a<?, ?>) reference4.value());
                }).toList().iterator();
                while (it.hasNext()) {
                    buildCreativeModeTabContentsEvent.accept(mctech.g.a.b.a((Holder<mctech.g.a.a<?, ?>>) it.next(), 1), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
                }
            }
        }
    }
}
