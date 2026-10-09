package mctech.g.c.b.a;

import com.mojang.math.Axis;
import com.mojang.math.Transformation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import mctech.g.c.b.f;
import mctech.g.d.a.g;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.Vec3i;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.client.ChunkRenderTypeSet;
import net.neoforged.neoforge.client.model.IDynamicBakedModel;
import net.neoforged.neoforge.client.model.IQuadTransformer;
import net.neoforged.neoforge.client.model.QuadTransformers;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.client.model.data.ModelProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Vector3f;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/a/b.class */
public class b implements IDynamicBakedModel {
    public static final ModelProperty<ModelData> a = new ModelProperty<>();
    private static final ChunkRenderTypeSet b = ChunkRenderTypeSet.of(new RenderType[]{RenderType.cutout()});

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @NotNull
    public List<BakedQuad> getQuads(@Nullable BlockState blockState, @Nullable Direction direction, @NotNull RandomSource randomSource, ModelData modelData, @Nullable RenderType renderType) throws MatchException {
        ArrayList arrayList = new ArrayList();
        c cVar = (c) modelData.get(c.a);
        if (cVar != null) {
            if (mctech.g.c.b.b.a.a() && cVar.c() && cVar.e()) {
                return arrayList;
            }
            Direction.Axis axisB = cVar.b();
            HashMap map = new HashMap();
            for (Direction direction2 : Direction.values()) {
                boolean zB = cVar.b(direction2);
                Direction directionA = a(direction2, direction);
                IQuadTransformer iQuadTransformerApplying = QuadTransformers.applying(a(direction2));
                if (zB) {
                    arrayList.addAll(iQuadTransformerApplying.process(mctech.g.c.b.c.a(mctech.g.c.b.c.a).getQuads(blockState, directionA, randomSource, modelData, renderType)));
                }
                List<Holder<mctech.g.a.a<?, ?>>> listA = cVar.a(direction2);
                for (int i = 0; i < listA.size(); i++) {
                    Holder<mctech.g.a.a<?, ?>> holder = listA.get(i);
                    CompoundTag compoundTagA = cVar.a(holder);
                    Vec3i vec3iA = g.a(direction2.getAxis(), g.a(i, listA.size()));
                    ((List) map.computeIfAbsent(holder, holder2 -> {
                        return new ArrayList();
                    })).add(vec3iA);
                    IQuadTransformer iQuadTransformerAndThen = iQuadTransformerApplying.andThen(QuadTransformers.applying(a(vec3iA)));
                    arrayList.addAll(new f(a(cVar.b(holder)), 0).andThen(iQuadTransformerAndThen).process(mctech.g.c.b.c.a(mctech.g.c.b.c.c).getQuads(blockState, directionA, randomSource, modelData, renderType)));
                    mctech.g.a.g.a aVarA = mctech.g.c.b.c.a.a(((mctech.g.a.a) holder.value()).d());
                    if (aVarA != null) {
                        arrayList.addAll(iQuadTransformerAndThen.process(aVarA.a(holder, compoundTagA, direction, direction2, randomSource, renderType)));
                    }
                    if (zB) {
                        arrayList.addAll(iQuadTransformerAndThen.process(mctech.g.c.b.c.a(mctech.g.c.b.c.f).getQuads(blockState, directionA, randomSource, modelData, renderType)));
                        d dVarA = cVar.a(direction2, holder);
                        if (dVarA != null) {
                            IQuadTransformer iQuadTransformerAndThen2 = iQuadTransformerAndThen.andThen(new mctech.g.c.b.b(dVarA.c(), dVarA.e()));
                            BakedModel bakedModelA = null;
                            if (dVarA.b() && dVarA.d()) {
                                bakedModelA = mctech.g.c.b.c.a(mctech.g.c.b.c.h);
                            } else if (dVarA.b()) {
                                bakedModelA = mctech.g.c.b.c.a(mctech.g.c.b.c.g);
                            } else if (dVarA.d()) {
                                bakedModelA = mctech.g.c.b.c.a(mctech.g.c.b.c.i);
                            }
                            if (bakedModelA != null) {
                                arrayList.addAll(iQuadTransformerAndThen2.process(bakedModelA.getQuads(blockState, directionA, randomSource, modelData, renderType)));
                            }
                            if (dVarA.f()) {
                                arrayList.addAll(iQuadTransformerAndThen.andThen(new mctech.g.c.b.b(null, dVarA.g())).process(mctech.g.c.b.c.a(mctech.g.c.b.c.j).getQuads(blockState, directionA, randomSource, modelData, renderType)));
                            }
                        }
                    }
                }
            }
            List<Holder<mctech.g.a.a<?, ?>>> listA2 = cVar.a();
            mctech.g.d.a aVar = null;
            HashMap map2 = new HashMap();
            ArrayList<Holder<mctech.g.a.a<?, ?>>> arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < listA2.size(); i2++) {
                Holder<mctech.g.a.a<?, ?>> holder3 = listA2.get(i2);
                List list = (List) map.get(holder3);
                if (list == null) {
                    map2.put(holder3, Integer.valueOf(i2));
                } else if (list.stream().distinct().count() == 1) {
                    arrayList2.add(holder3);
                } else if (aVar == null) {
                    aVar = new mctech.g.d.a((Vec3i[]) list.toArray(new Vec3i[0]));
                } else {
                    mctech.g.d.a aVar2 = aVar;
                    Objects.requireNonNull(aVar2);
                    list.forEach(aVar2::a);
                }
            }
            HashSet hashSet = new HashSet();
            Stream stream = arrayList2.stream();
            Objects.requireNonNull(map);
            for (Vec3i vec3i : stream.map((v1) -> {
                return r1.get(v1);
            }).map((v0) -> {
                return v0.getFirst();
            }).filter(vec3i2 -> {
                return !hashSet.add(vec3i2);
            }).toList()) {
                if (aVar == null) {
                    aVar = new mctech.g.d.a(vec3i);
                } else {
                    aVar.a(vec3i);
                }
            }
            for (Holder<mctech.g.a.a<?, ?>> holder4 : arrayList2) {
                List list2 = (List) map.get(holder4);
                if (aVar == null || !aVar.b((Vec3i) list2.getFirst())) {
                    arrayList.addAll(new f(a(cVar.b(holder4)), 0).andThen(QuadTransformers.applying(a((Vec3i) list2.getFirst()))).process(mctech.g.c.b.c.a(mctech.g.c.b.c.d).getQuads(blockState, direction, randomSource, modelData, renderType)));
                }
            }
            if (aVar != null) {
                for (Map.Entry entry : map2.entrySet()) {
                    Vec3i vec3iA2 = g.a(axisB, g.a(((Integer) entry.getValue()).intValue(), listA2.size()));
                    if (!aVar.b(vec3iA2)) {
                        arrayList.addAll(new f(a(cVar.b((Holder<mctech.g.a.a<?, ?>>) entry.getKey())), 0).andThen(QuadTransformers.applying(a(vec3iA2))).process(mctech.g.c.b.c.a(mctech.g.c.b.c.d).getQuads(blockState, direction, randomSource, modelData, renderType)));
                    }
                }
                arrayList.addAll(new mctech.g.c.b.a(aVar.c()).andThen(QuadTransformers.applying(a(aVar.a()))).process(mctech.g.c.b.c.a(mctech.g.c.b.c.e).getQuads(blockState, direction, randomSource, modelData, renderType)));
            } else {
                for (Map.Entry entry2 : map2.entrySet()) {
                    arrayList.addAll(new f(a(cVar.b((Holder<mctech.g.a.a<?, ?>>) entry2.getKey())), 0).andThen(QuadTransformers.applying(a(g.a(axisB, g.a(((Integer) entry2.getValue()).intValue(), listA2.size()))))).process(mctech.g.c.b.c.a(mctech.g.c.b.c.d).getQuads(blockState, direction, randomSource, modelData, renderType)));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Nullable
    public static Direction a(Direction direction, @Nullable Direction direction2) throws MatchException {
        if (direction2 == null) {
            return null;
        }
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 1:
                return direction2;
            case 2:
                return direction2.getClockWise(Direction.Axis.Z).getClockWise(Direction.Axis.Z);
            case 3:
                return direction2.getCounterClockWise(Direction.Axis.X);
            case 4:
                return direction2.getClockWise(Direction.Axis.X);
            case 5:
                return direction2.getCounterClockWise(Direction.Axis.Z);
            case 6:
                return direction2.getClockWise(Direction.Axis.Z);
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    /* JADX INFO: renamed from: mctech.g.c.b.a.b$1, reason: invalid class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/c/b/a/b$1.class */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a = new int[Direction.values().length];

        static {
            try {
                a[Direction.DOWN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[Direction.UP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[Direction.NORTH.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[Direction.SOUTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                a[Direction.WEST.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                a[Direction.EAST.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
        }
    }

    public static Transformation a(Direction direction) {
        Quaternionf quaternionf = new Quaternionf();
        switch (AnonymousClass1.a[direction.ordinal()]) {
            case 2:
                quaternionf.mul(Axis.ZP.rotationDegrees(180.0f));
                break;
            case 3:
                quaternionf.mul(Axis.XP.rotationDegrees(90.0f));
                break;
            case 4:
                quaternionf.mul(Axis.XN.rotationDegrees(90.0f));
                break;
            case 5:
                quaternionf.mul(Axis.ZN.rotationDegrees(90.0f));
                break;
            case 6:
                quaternionf.mul(Axis.ZP.rotationDegrees(90.0f));
                break;
        }
        return new Transformation((Vector3f) null, quaternionf, (Vector3f) null, (Quaternionf) null).applyOrigin(new Vector3f(0.5f, 0.5f, 0.5f));
    }

    private static Transformation a(Vec3i vec3i) {
        return new Transformation(a(vec3i, 0.1875f), (Quaternionf) null, (Vector3f) null, (Quaternionf) null);
    }

    private static Transformation a(Vector3f vector3f) {
        return new Transformation(vector3f, (Quaternionf) null, (Vector3f) null, (Quaternionf) null);
    }

    private static Vector3f a(Vec3i vec3i, float f) {
        return new Vector3f(vec3i.getX() * f, vec3i.getY() * f, vec3i.getZ() * f);
    }

    public boolean useAmbientOcclusion() {
        return true;
    }

    public boolean isGui3d() {
        return false;
    }

    public boolean usesBlockLight() {
        return false;
    }

    public boolean isCustomRenderer() {
        return false;
    }

    @NotNull
    public TextureAtlasSprite getParticleIcon() {
        return mctech.g.e.f.a();
    }

    @NotNull
    public TextureAtlasSprite getParticleIcon(@NotNull ModelData modelData) {
        return (TextureAtlasSprite) a(modelData, c.a).map(cVar -> {
            if (cVar.c() && mctech.g.c.b.b.a.a()) {
                return (TextureAtlasSprite) a(modelData, a).map(modelData2 -> {
                    return Minecraft.getInstance().getBlockRenderer().getBlockModel(cVar.d()).getParticleIcon(modelData2);
                }).orElse(mctech.g.e.f.a());
            }
            if (cVar.a().isEmpty()) {
                return mctech.g.e.f.a();
            }
            return a(cVar.b((Holder<mctech.g.a.a<?, ?>>) cVar.a().getFirst()));
        }).orElse(mctech.g.e.f.a());
    }

    @NotNull
    public ItemOverrides getOverrides() {
        return ItemOverrides.EMPTY;
    }

    @NotNull
    public ChunkRenderTypeSet getRenderTypes(@NotNull BlockState blockState, @NotNull RandomSource randomSource, @NotNull ModelData modelData) {
        return b;
    }

    @NotNull
    public ModelData getModelData(@NotNull BlockAndTintGetter blockAndTintGetter, @NotNull BlockPos blockPos, @NotNull BlockState blockState, @NotNull ModelData modelData) {
        ModelData modelData2 = super.getModelData(blockAndTintGetter, blockPos, blockState, modelData);
        ModelData.Builder builderDerive = modelData2.derive();
        c cVar = (c) modelData2.get(c.a);
        if (cVar != null && cVar.c()) {
            BlockState blockStateD = cVar.d();
            builderDerive.with(a, Minecraft.getInstance().getBlockRenderer().getBlockModel(blockStateD).getModelData(blockAndTintGetter, blockPos, blockStateD, ModelData.EMPTY));
        }
        return builderDerive.build();
    }

    private static TextureAtlasSprite a(ResourceLocation resourceLocation) {
        return Minecraft.getInstance().getModelManager().getAtlas(InventoryMenu.BLOCK_ATLAS).getSprite(resourceLocation);
    }

    private static boolean a(BakedModel bakedModel) {
        return bakedModel == Minecraft.getInstance().getModelManager().getMissingModel();
    }

    private <T> Optional<T> a(ModelData modelData, ModelProperty<T> modelProperty) {
        if (modelData.has(modelProperty)) {
            return Optional.ofNullable(modelData.get(modelProperty));
        }
        return Optional.empty();
    }
}
