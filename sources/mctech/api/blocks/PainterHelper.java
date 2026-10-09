package mctech.api.blocks;

import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BedBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.ShulkerBoxBlockEntity;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BedPart;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.Vec3;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/PainterHelper.class */
public class PainterHelper {
    Map<Block, IPaintable> paintable = Object2ObjectMaps.synchronize(new Object2ObjectOpenHashMap());
    public static DyeableMap BEDS;
    public static DyeableMap WOOL;
    public static DyeableMap CARPETS;
    public static DyeableMap CONCRETE;
    public static DyeableMap CONCRETE_DUST;
    public static DyeableMap GLASS;
    public static DyeableMap GLASS_PANE;
    public static DyeableMap TERRACOTTA;
    public static DyeableMap GLAZED_TERRACOTTA;
    public static DyeableMap SHULKER;
    public static final PainterHelper INSTANCE = new PainterHelper();
    public static final BiFunction<BlockState, BlockState, BlockState> DEFAULT_MAPPER = (blockState, blockState2) -> {
        return blockState2;
    };
    public static final BiFunction<BlockState, BlockState, BlockState> DEFAULT_COPY_MAPPER = PainterHelper::copyProperties;

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/PainterHelper$IPaintable.class */
    public interface IPaintable {
        boolean recolor(BlockState blockState, Level level, BlockPos blockPos, Vec3 vec3, Direction direction, DyeColor dyeColor);

        DyeColor getColor(BlockState blockState);
    }

    public static void init() {
        PainterHelper painterHelper = INSTANCE;
        DyeableMap bedColors = getBedColors();
        BEDS = bedColors;
        painterHelper.registerPaintHelper((Collection<Block>) bedColors.getBlocks(), (IPaintable) new BedPainter());
        INSTANCE.registerPaintHelper(getSigns(), new SignPainter());
        PainterHelper painterHelper2 = INSTANCE;
        DyeableMap carpetColors = getCarpetColors();
        CARPETS = carpetColors;
        painterHelper2.registerPaintHelper(carpetColors, DEFAULT_MAPPER);
        PainterHelper painterHelper3 = INSTANCE;
        DyeableMap concreteColor = getConcreteColor();
        CONCRETE = concreteColor;
        painterHelper3.registerPaintHelper(concreteColor, DEFAULT_MAPPER);
        PainterHelper painterHelper4 = INSTANCE;
        DyeableMap concreteDustColor = getConcreteDustColor();
        CONCRETE_DUST = concreteDustColor;
        painterHelper4.registerPaintHelper(concreteDustColor, DEFAULT_MAPPER);
        PainterHelper painterHelper5 = INSTANCE;
        DyeableMap glassColors = getGlassColors();
        GLASS = glassColors;
        painterHelper5.registerPaintHelper(glassColors, DEFAULT_MAPPER);
        PainterHelper painterHelper6 = INSTANCE;
        DyeableMap glassPaneColors = getGlassPaneColors();
        GLASS_PANE = glassPaneColors;
        painterHelper6.registerPaintHelper(glassPaneColors, DEFAULT_COPY_MAPPER);
        PainterHelper painterHelper7 = INSTANCE;
        DyeableMap glazedTerracottaColors = getGlazedTerracottaColors();
        GLAZED_TERRACOTTA = glazedTerracottaColors;
        painterHelper7.registerPaintHelper(glazedTerracottaColors, DEFAULT_MAPPER);
        PainterHelper painterHelper8 = INSTANCE;
        DyeableMap shulkerColors = getShulkerColors();
        SHULKER = shulkerColors;
        painterHelper8.registerPaintHelper((Collection<Block>) shulkerColors.getBlocks(), (IPaintable) new ShulkerPainter());
        PainterHelper painterHelper9 = INSTANCE;
        DyeableMap terracottaColors = getTerracottaColors();
        TERRACOTTA = terracottaColors;
        painterHelper9.registerPaintHelper(terracottaColors, DEFAULT_MAPPER);
        PainterHelper painterHelper10 = INSTANCE;
        DyeableMap woolColors = getWoolColors();
        WOOL = woolColors;
        painterHelper10.registerPaintHelper(woolColors, DEFAULT_MAPPER);
    }

    public void registerPaintHelper(DyeableMap dyeableMap, BiFunction<BlockState, BlockState, BlockState> biFunction) {
        registerPaintHelper((Collection<Block>) dyeableMap.getBlocks(), (IPaintable) new Colorable(dyeableMap, biFunction));
    }

    public <T extends Block & IPaintable> void registerPaintHelper(T t) {
        this.paintable.put(t, t);
    }

    public void registerPaintHelper(Collection<Block> collection, IPaintable iPaintable) {
        Iterator<Block> it = collection.iterator();
        while (it.hasNext()) {
            this.paintable.put(it.next(), iPaintable);
        }
    }

    public void registerPaintHelper(Block block, IPaintable iPaintable) {
        this.paintable.put(block, iPaintable);
    }

    public IPaintable getPaintable(Block block) {
        IPaintable iPaintable = this.paintable.get(block);
        if (iPaintable != null) {
            return iPaintable;
        }
        if (block instanceof IPaintable) {
            return (IPaintable) block;
        }
        return null;
    }

    public IPaintable getPaintable(BlockState blockState) {
        return getPaintable(blockState.getBlock());
    }

    public DyeColor getColor(BlockState blockState) {
        IPaintable paintable = getPaintable(blockState);
        if (paintable == null) {
            return null;
        }
        return paintable.getColor(blockState);
    }

    public static <T extends Property<V>, V extends Comparable<V>> BlockState copyProperties(BlockState blockState, BlockState blockState2) {
        for (Property property : blockState.getProperties()) {
            if (blockState2.hasProperty(property)) {
                blockState2 = (BlockState) blockState2.setValue(property, blockState.getValue(property));
            }
        }
        return blockState2;
    }

    private static DyeableMap getWoolColors() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_WOOL, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_WOOL, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_WOOL, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_WOOL, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_WOOL, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_WOOL, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_WOOL, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_WOOL, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_WOOL, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_WOOL, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_WOOL, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_WOOL, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_WOOL, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_WOOL, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_WOOL, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_WOOL, DyeColor.BLACK);
        return dyeableMap;
    }

    private static DyeableMap getTerracottaColors() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_TERRACOTTA, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_TERRACOTTA, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_TERRACOTTA, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_TERRACOTTA, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_TERRACOTTA, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_TERRACOTTA, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_TERRACOTTA, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_TERRACOTTA, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_TERRACOTTA, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_TERRACOTTA, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_TERRACOTTA, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_TERRACOTTA, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_TERRACOTTA, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_TERRACOTTA, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_TERRACOTTA, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_TERRACOTTA, DyeColor.BLACK);
        return dyeableMap;
    }

    private static DyeableMap getGlazedTerracottaColors() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_GLAZED_TERRACOTTA, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_GLAZED_TERRACOTTA, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_GLAZED_TERRACOTTA, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_GLAZED_TERRACOTTA, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_GLAZED_TERRACOTTA, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_GLAZED_TERRACOTTA, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_GLAZED_TERRACOTTA, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_GLAZED_TERRACOTTA, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_GLAZED_TERRACOTTA, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_GLAZED_TERRACOTTA, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_GLAZED_TERRACOTTA, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_GLAZED_TERRACOTTA, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_GLAZED_TERRACOTTA, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_GLAZED_TERRACOTTA, DyeColor.BLACK);
        return dyeableMap;
    }

    private static DyeableMap getConcreteColor() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_CONCRETE, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_CONCRETE, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_CONCRETE, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_CONCRETE, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_CONCRETE, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_CONCRETE, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_CONCRETE, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_CONCRETE, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_CONCRETE, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_CONCRETE, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_CONCRETE, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_CONCRETE, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_CONCRETE, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_CONCRETE, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_CONCRETE, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_CONCRETE, DyeColor.BLACK);
        return dyeableMap;
    }

    private static DyeableMap getConcreteDustColor() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_CONCRETE_POWDER, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_CONCRETE_POWDER, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_CONCRETE_POWDER, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_CONCRETE_POWDER, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_CONCRETE_POWDER, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_CONCRETE_POWDER, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_CONCRETE_POWDER, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_CONCRETE_POWDER, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_CONCRETE_POWDER, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_CONCRETE_POWDER, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_CONCRETE_POWDER, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_CONCRETE_POWDER, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_CONCRETE_POWDER, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_CONCRETE_POWDER, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_CONCRETE_POWDER, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_CONCRETE_POWDER, DyeColor.BLACK);
        return dyeableMap;
    }

    private static DyeableMap getShulkerColors() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_SHULKER_BOX, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_SHULKER_BOX, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_SHULKER_BOX, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_SHULKER_BOX, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_SHULKER_BOX, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_SHULKER_BOX, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_SHULKER_BOX, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_SHULKER_BOX, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_SHULKER_BOX, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_SHULKER_BOX, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_SHULKER_BOX, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_SHULKER_BOX, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_SHULKER_BOX, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_SHULKER_BOX, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_SHULKER_BOX, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_SHULKER_BOX, DyeColor.BLACK);
        return dyeableMap;
    }

    private static DyeableMap getBedColors() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_BED, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_BED, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_BED, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_BED, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_BED, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_BED, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_BED, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_BED, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_BED, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_BED, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_BED, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_BED, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_BED, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_BED, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_BED, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_BED, DyeColor.BLACK);
        return dyeableMap;
    }

    public static List<Block> getSigns() {
        ObjectArrayList objectArrayList = new ObjectArrayList();
        objectArrayList.add(Blocks.ACACIA_SIGN);
        objectArrayList.add(Blocks.ACACIA_WALL_SIGN);
        objectArrayList.add(Blocks.BIRCH_SIGN);
        objectArrayList.add(Blocks.BIRCH_WALL_SIGN);
        objectArrayList.add(Blocks.DARK_OAK_SIGN);
        objectArrayList.add(Blocks.DARK_OAK_WALL_SIGN);
        objectArrayList.add(Blocks.JUNGLE_SIGN);
        objectArrayList.add(Blocks.JUNGLE_WALL_SIGN);
        objectArrayList.add(Blocks.OAK_SIGN);
        objectArrayList.add(Blocks.OAK_WALL_SIGN);
        objectArrayList.add(Blocks.SPRUCE_SIGN);
        objectArrayList.add(Blocks.SPRUCE_WALL_SIGN);
        objectArrayList.add(Blocks.CRIMSON_SIGN);
        objectArrayList.add(Blocks.CRIMSON_WALL_SIGN);
        objectArrayList.add(Blocks.WARPED_SIGN);
        objectArrayList.add(Blocks.WARPED_WALL_SIGN);
        return objectArrayList;
    }

    private static DyeableMap getGlassColors() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_STAINED_GLASS, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_STAINED_GLASS, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_STAINED_GLASS, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_STAINED_GLASS, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_STAINED_GLASS, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_STAINED_GLASS, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_STAINED_GLASS, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_STAINED_GLASS, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_STAINED_GLASS, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_STAINED_GLASS, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_STAINED_GLASS, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_STAINED_GLASS, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_STAINED_GLASS, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_STAINED_GLASS, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_STAINED_GLASS, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_STAINED_GLASS, DyeColor.BLACK);
        return dyeableMap;
    }

    private static DyeableMap getGlassPaneColors() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_WOOL, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_STAINED_GLASS_PANE, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_STAINED_GLASS_PANE, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_STAINED_GLASS_PANE, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_STAINED_GLASS_PANE, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_STAINED_GLASS_PANE, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_STAINED_GLASS_PANE, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_STAINED_GLASS_PANE, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_STAINED_GLASS_PANE, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_STAINED_GLASS_PANE, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_STAINED_GLASS_PANE, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_STAINED_GLASS_PANE, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_STAINED_GLASS_PANE, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_STAINED_GLASS_PANE, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_STAINED_GLASS_PANE, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_STAINED_GLASS_PANE, DyeColor.BLACK);
        return dyeableMap;
    }

    private static DyeableMap getCarpetColors() {
        DyeableMap dyeableMap = new DyeableMap();
        dyeableMap.addBlock(Blocks.WHITE_CARPET, DyeColor.WHITE);
        dyeableMap.addBlock(Blocks.ORANGE_CARPET, DyeColor.ORANGE);
        dyeableMap.addBlock(Blocks.MAGENTA_CARPET, DyeColor.MAGENTA);
        dyeableMap.addBlock(Blocks.LIGHT_BLUE_CARPET, DyeColor.LIGHT_BLUE);
        dyeableMap.addBlock(Blocks.YELLOW_CARPET, DyeColor.YELLOW);
        dyeableMap.addBlock(Blocks.LIME_CARPET, DyeColor.LIME);
        dyeableMap.addBlock(Blocks.PINK_CARPET, DyeColor.PINK);
        dyeableMap.addBlock(Blocks.GRAY_CARPET, DyeColor.GRAY);
        dyeableMap.addBlock(Blocks.LIGHT_GRAY_CARPET, DyeColor.LIGHT_GRAY);
        dyeableMap.addBlock(Blocks.CYAN_CARPET, DyeColor.CYAN);
        dyeableMap.addBlock(Blocks.PURPLE_CARPET, DyeColor.PURPLE);
        dyeableMap.addBlock(Blocks.BLUE_CARPET, DyeColor.BLUE);
        dyeableMap.addBlock(Blocks.BROWN_CARPET, DyeColor.BROWN);
        dyeableMap.addBlock(Blocks.GREEN_CARPET, DyeColor.GREEN);
        dyeableMap.addBlock(Blocks.RED_CARPET, DyeColor.RED);
        dyeableMap.addBlock(Blocks.BLACK_CARPET, DyeColor.BLACK);
        return dyeableMap;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/PainterHelper$SignPainter.class */
    public static class SignPainter implements IPaintable {
        @Override // mctech.api.blocks.PainterHelper.IPaintable
        public boolean recolor(BlockState blockState, Level level, BlockPos blockPos, Vec3 vec3, Direction direction, DyeColor dyeColor) {
            if (level.getBlockEntity(blockPos) instanceof SignBlockEntity) {
                return true;
            }
            return false;
        }

        @Override // mctech.api.blocks.PainterHelper.IPaintable
        public DyeColor getColor(BlockState blockState) {
            return null;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/PainterHelper$ShulkerPainter.class */
    public static class ShulkerPainter extends Colorable {
        public ShulkerPainter() {
            super(PainterHelper.getShulkerColors(), null);
        }

        @Override // mctech.api.blocks.PainterHelper.Colorable, mctech.api.blocks.PainterHelper.IPaintable
        public boolean recolor(BlockState blockState, Level level, BlockPos blockPos, Vec3 vec3, Direction direction, DyeColor dyeColor) {
            Block block;
            DyeColor color = this.map.getColor(blockState.getBlock());
            if (color == null || color == dyeColor || (block = this.map.getBlock(dyeColor)) == null) {
                return false;
            }
            ShulkerBoxBlockEntity blockEntity = level.getBlockEntity(blockPos);
            if (!(blockEntity instanceof ShulkerBoxBlockEntity)) {
                return false;
            }
            ShulkerBoxBlockEntity shulkerBoxBlockEntity = blockEntity;
            if (!level.setBlockAndUpdate(blockPos, PainterHelper.copyProperties(blockState, block.defaultBlockState()))) {
                return false;
            }
            ShulkerBoxBlockEntity blockEntity2 = level.getBlockEntity(blockPos);
            if (!(blockEntity2 instanceof ShulkerBoxBlockEntity)) {
                return false;
            }
            blockEntity2.loadCustomOnly(shulkerBoxBlockEntity.saveWithoutMetadata(level.registryAccess()), level.registryAccess());
            return true;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/PainterHelper$BedPainter.class */
    public static class BedPainter extends Colorable {
        public BedPainter() {
            super(PainterHelper.getBedColors(), null);
        }

        @Override // mctech.api.blocks.PainterHelper.Colorable, mctech.api.blocks.PainterHelper.IPaintable
        public boolean recolor(BlockState blockState, Level level, BlockPos blockPos, Vec3 vec3, Direction direction, DyeColor dyeColor) {
            Block block;
            DyeColor color = this.map.getColor(blockState.getBlock());
            if (color == null || color == dyeColor || (block = this.map.getBlock(dyeColor)) == null) {
                return false;
            }
            level.setBlock(blockPos, PainterHelper.copyProperties(blockState, block.defaultBlockState()), 17);
            BlockPos blockPosRelative = blockPos.relative(blockState.getValue(BedBlock.PART) == BedPart.HEAD ? blockState.getValue(BedBlock.FACING).getOpposite() : blockState.getValue(BedBlock.FACING));
            level.setBlock(blockPosRelative, PainterHelper.copyProperties(level.getBlockState(blockPosRelative), block.defaultBlockState()), 17);
            return true;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/blocks/PainterHelper$Colorable.class */
    public static class Colorable implements IPaintable {
        DyeableMap map;
        BiFunction<BlockState, BlockState, BlockState> mapper;

        public Colorable(DyeableMap dyeableMap, BiFunction<BlockState, BlockState, BlockState> biFunction) {
            this.map = dyeableMap;
            this.mapper = biFunction;
        }

        @Override // mctech.api.blocks.PainterHelper.IPaintable
        public boolean recolor(BlockState blockState, Level level, BlockPos blockPos, Vec3 vec3, Direction direction, DyeColor dyeColor) {
            Block block;
            DyeColor color = this.map.getColor(blockState.getBlock());
            return (color == null || color == dyeColor || (block = this.map.getBlock(dyeColor)) == null || !level.setBlockAndUpdate(blockPos, this.mapper.apply(blockState, block.defaultBlockState()))) ? false : true;
        }

        @Override // mctech.api.blocks.PainterHelper.IPaintable
        public DyeColor getColor(BlockState blockState) {
            return this.map.getColor(blockState.getBlock());
        }
    }
}
