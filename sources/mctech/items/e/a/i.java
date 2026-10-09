package mctech.items.e.a;

import java.util.List;
import mctech.MCTech;
import mctech.api.events.RetextureEvent;
import mctech.api.items.IFoamOverrider;
import mctech.api.items.electric.ElectricItem;
import mctech.api.items.electric.IElectricItem;
import mctech.api.network.item.INetworkItemBufferEvent;
import mctech.api.util.DirectionList;
import mctech.blockentities.c.C0074u;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechStats;
import mctech.items.base.MCTechElectricItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockModelShaper;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.common.NeoForge;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/a/i.class */
public class i extends MCTechElectricItem implements IFoamOverrider, INetworkItemBufferEvent<mctech.q.a.a.d> {
    public static final int a = 10000;
    public static final int b = 1500;

    public i() {
        this.capacity = C0074u.e;
        this.tier = 2;
        this.transferLimit = 250;
    }

    @Override // mctech.items.base.MCTechElectricItem
    protected int getEnergyCost(ItemStack itemStack) {
        return 100;
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        RetextureEvent.TextureContainer textureContainerB = b(itemStack);
        if (textureContainerB != null) {
            int iA = a(itemStack);
            dVar.d("tooltip.item.mctech.obscurator.block", textureContainerB.getState().getBlock().getName());
            dVar.d("tooltip.item.mctech.obscurator.side", DirectionList.getName(textureContainerB.getSide()));
            dVar.d("tooltip.item.mctech.obscurator.layers", Integer.valueOf(textureContainerB.getRotations().length));
            dVar.d("tooltip.item.mctech.obscurator.layer", Integer.valueOf(iA));
            dVar.d("tooltip.item.mctech.obscurator.rotation", Integer.valueOf(textureContainerB.getRotations()[iA].getRotation()));
        }
        dVar.a(c("tooltip.item.mctech.painter.range", Integer.valueOf((mctech.utils.c.h.a(itemStack).getByte("range") * 2) + 1)));
        dVar.b(a(mctech.s.a.SNEAK_KEY, mctech.s.a.BLOCK_CLICK, "tooltip.item.mctech.obscurator.change.copy", new Object[0]));
        dVar.b(a(mctech.s.a.RIGHT_CLICK, "tooltip.item.mctech.obscurator.change.paste", new Object[0]));
        dVar.b(a(mctech.s.a.MODE_KEY, mctech.s.a.SNEAK_KEY, "tooltip.item.mctech.obscurator.change.layer", new Object[0]));
        dVar.b(a(mctech.s.a.MODE_KEY, "tooltip.item.mctech.obscurator.change.rotation", new Object[0]));
        dVar.b(a(mctech.s.a.ALT_KEY, "tooltip.item.mctech.obscurator.change.paste_all_sides", new Object[0]));
        dVar.b(a(mctech.s.a.SNEAK_KEY, mctech.s.a.RIGHT_CLICK, "tooltip.item.mctech.obscurator.change.range", new Object[0]));
    }

    public int a(ItemStack itemStack, int i) {
        int iA = (a(itemStack) + 1) % i;
        b(itemStack, iA);
        return iA;
    }

    public int a(ItemStack itemStack) {
        return ((Byte) itemStack.getOrDefault(MCTechDataComponent.LAYER, (byte) 0)).byteValue();
    }

    public void b(ItemStack itemStack, int i) {
        itemStack.set(MCTechDataComponent.LAYER, Byte.valueOf((byte) i));
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        if (!level.isClientSide) {
            ItemStack itemInHand = player.getItemInHand(interactionHand);
            if (MCTech.KEYBOARD.h(player)) {
                int iIntValue = ((Integer) itemInHand.getOrDefault(MCTechDataComponent.RADIUS, 0)).intValue() + 1;
                if (iIntValue > 2) {
                    iIntValue = 0;
                }
                itemInHand.set(MCTechDataComponent.RADIUS, Integer.valueOf(iIntValue));
                player.displayClientMessage(c("tooltip.item.mctech.obscurator.range", Integer.valueOf((iIntValue * 2) + 1)), false);
            } else if (MCTech.KEYBOARD.d(player)) {
                if (!itemInHand.has(MCTechDataComponent.BLOCK)) {
                    return InteractionResultHolder.fail(player.getItemInHand(interactionHand));
                }
                RetextureEvent.TextureContainer textureContainerB = b(itemInHand);
                if (player.isShiftKeyDown()) {
                    player.displayClientMessage(c("tooltip.item.mctech.obscurator.layer", Integer.valueOf(a(itemInHand, textureContainerB.getRotations().length))), false);
                } else {
                    RetextureEvent.Rotation[] rotations = textureContainerB.getRotations();
                    int iA = a(itemInHand);
                    if (iA >= rotations.length) {
                        iA = rotations.length - 1;
                        b(itemInHand, iA);
                    }
                    rotations[iA] = rotations[iA].getNext();
                    itemInHand.set(MCTechDataComponent.BLOCK, textureContainerB.save());
                    player.displayClientMessage(c("tooltip.item.mctech.obscurator.rotation", Integer.valueOf(rotations[iA].getRotation())), false);
                }
            }
            return InteractionResultHolder.success(itemInHand);
        }
        return super.use(level, player, interactionHand);
    }

    public InteractionResult onItemUseFirst(ItemStack itemStack, UseOnContext useOnContext) {
        LivingEntity player = useOnContext.getPlayer();
        if (player == null || MCTech.KEYBOARD.d(player)) {
            return InteractionResult.FAIL;
        }
        Level level = useOnContext.getLevel();
        BlockPos clickedPos = useOnContext.getClickedPos();
        if (player.isShiftKeyDown() && MCTech.PLATFORM.h()) {
            if (level.isEmptyBlock(clickedPos)) {
                return InteractionResult.FAIL;
            }
            if (!ElectricItem.MANAGER.canUse(useOnContext.getItemInHand(), 10000)) {
                return InteractionResult.FAIL;
            }
            BlockState blockState = level.getBlockState(clickedPos);
            if (blockState.getRenderShape() != RenderShape.MODEL) {
                return InteractionResult.FAIL;
            }
            if (!a(blockState, useOnContext.getClickedFace(), clickedPos)) {
                return InteractionResult.FAIL;
            }
            MCTech.NETWORKING.sendClientItemBuffer(useOnContext.getItemInHand(), "", new mctech.q.a.a.d(blockState, useOnContext.getClickedFace(), a(level, clickedPos, blockState, useOnContext.getClickedFace()), useOnContext.getHand() != InteractionHand.OFF_HAND));
            return InteractionResult.SUCCESS;
        }
        if (player.isShiftKeyDown()) {
            return InteractionResult.PASS;
        }
        RetextureEvent.TextureContainer textureContainerB = b(useOnContext.getItemInHand());
        if (textureContainerB == null) {
            return InteractionResult.PASS;
        }
        if (MCTech.PLATFORM.h()) {
            return InteractionResult.SUCCESS;
        }
        Direction clickedFace = useOnContext.getClickedFace();
        mctech.utils.math.geometry.a aVarA = mctech.utils.math.geometry.a.a(clickedPos, 0).a(clickedFace.getAxis(), mctech.utils.c.h.a(itemStack).getByte("range"));
        DirectionList directionListOfFacing = MCTech.KEYBOARD.a((Player) player) ? DirectionList.ALL : DirectionList.ofFacing(clickedFace);
        InteractionResult interactionResult = InteractionResult.FAIL;
        for (BlockPos blockPos : aVarA) {
            for (Direction direction : directionListOfFacing) {
                if (!ElectricItem.MANAGER.canUse(itemStack, b)) {
                    return interactionResult;
                }
                RetextureEvent retextureEvent = new RetextureEvent(level, blockPos, direction, player, textureContainerB);
                NeoForge.EVENT_BUS.post(retextureEvent);
                if (retextureEvent.isApplied()) {
                    player.awardStat((ResourceLocation) MCTechStats.TEXTURES_STOLEN.get());
                    if (!player.isCreative()) {
                        ElectricItem.MANAGER.use(itemStack, b, player);
                    }
                    interactionResult = InteractionResult.SUCCESS;
                }
            }
        }
        return interactionResult;
    }

    @OnlyIn(Dist.CLIENT)
    public int[] a(Level level, BlockPos blockPos, BlockState blockState, Direction direction) {
        List quads = Minecraft.getInstance().getBlockRenderer().getBlockModelShaper().getBlockModel(blockState).getQuads(blockState, direction, RandomSource.create(blockState.getSeed(blockPos)), ModelData.EMPTY, (RenderType) null);
        int[] iArr = new int[quads.size()];
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        for (int i = 0; i < quads.size(); i++) {
            BakedQuad bakedQuad = (BakedQuad) quads.get(i);
            iArr[i] = bakedQuad.isTinted() ? blockColors.getColor(blockState, level, blockPos, bakedQuad.getTintIndex()) : -1;
        }
        return iArr;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean a(BlockState blockState, Direction direction, BlockPos blockPos) {
        BlockModelShaper blockModelShaper = Minecraft.getInstance().getBlockRenderer().getBlockModelShaper();
        BakedModel blockModel = blockModelShaper.getBlockModel(blockState);
        if (blockModel.isCustomRenderer() || blockModel == blockModelShaper.getModelManager().getMissingModel()) {
            return false;
        }
        List quads = blockModel.getQuads(blockState, direction, RandomSource.create(blockState.getSeed(blockPos)), ModelData.EMPTY, (RenderType) null);
        return quads.size() > 0 && quads.size() <= 10;
    }

    @Override // mctech.api.network.item.INetworkItemBufferEvent
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onDataBufferReceived(ItemStack itemStack, Player player, String str, mctech.q.a.a.d dVar, Dist dist) {
        if (dist.isClient()) {
            return;
        }
        ItemStack itemStackA = dVar.a(player);
        if (itemStack.isEmpty() || !ItemStack.matches(itemStack, itemStackA)) {
            return;
        }
        if (!itemStackA.has(MCTechDataComponent.BLOCK)) {
            itemStackA.set(MCTechDataComponent.BLOCK, dVar.a().save());
            if (!player.isCreative()) {
                ElectricItem.MANAGER.use(itemStackA, 10000, player);
                return;
            }
            return;
        }
        RetextureEvent.TextureContainer textureContainerA = dVar.a();
        if (textureContainerA.equals(new RetextureEvent.TextureContainer((CompoundTag) itemStackA.getOrDefault(MCTechDataComponent.BLOCK, new CompoundTag())))) {
            return;
        }
        itemStackA.set(MCTechDataComponent.BLOCK, textureContainerA.save());
        itemStackA.set(MCTechDataComponent.LAYER, (byte) 0);
    }

    public static RetextureEvent.TextureContainer b(ItemStack itemStack) {
        if (itemStack.has(MCTechDataComponent.BLOCK)) {
            return new RetextureEvent.TextureContainer((CompoundTag) itemStack.get(MCTechDataComponent.BLOCK));
        }
        return null;
    }

    @Override // mctech.api.items.electric.IElectricItem
    public IElectricItem.ElectricType getElectricType(ItemStack itemStack) {
        return IElectricItem.ElectricType.TOOL;
    }
}
