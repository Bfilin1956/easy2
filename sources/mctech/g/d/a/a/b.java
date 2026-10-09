package mctech.g.d.a.a;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import it.unimi.dsi.fastutil.longs.LongSet;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.runtime.ObjectMethods;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import mctech.MCTech;
import mctech.components.u;
import mctech.g.a.m;
import mctech.g.d.a.e;
import mctech.g.d.a.f;
import mctech.g.f.k;
import mctech.g.f.l;
import mctech.init.MCTechCodecs;
import mctech.init.MCTechConduitTypes;
import mctech.init.MCTechTiles;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.SectionPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;
import net.minecraft.nbt.Tag;
import net.minecraft.network.Connection;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.Nameable;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.fml.loading.FMLLoader;
import net.neoforged.neoforge.capabilities.BlockCapability;
import net.neoforged.neoforge.capabilities.BlockCapabilityCache;
import net.neoforged.neoforge.capabilities.ICapabilityProvider;
import net.neoforged.neoforge.client.model.data.ModelData;
import net.neoforged.neoforge.common.util.DataComponentUtil;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/b.class */
public class b extends mctech.g.d.a.a.c implements u, mctech.g.a.c, mctech.g.a.h.b, mctech.g.d.a.c.a.c, mctech.g.d.c, Nameable {
    public static final int a = 9;
    public static final HashMap<ResourceLocation, Long2ObjectMap<BlockState>> b = new HashMap<>();
    public static final HashMap<ResourceLocation, Long2ObjectMap<LongSet>> c = new HashMap<>();
    private ItemStack g;
    private List<Holder<mctech.g.a.a<?, ?>>> h;
    private Map<Holder<mctech.g.a.a<?, ?>>, a> i;
    private final Map<Holder<mctech.g.a.a<?, ?>>, mctech.g.d.a.c> j;
    private final Map<Holder<mctech.g.a.a<?, ?>>, c> k;
    private final Map<Holder<mctech.g.a.a<?, ?>>, mctech.g.d.a.c> l;
    private ListTag m;
    private Map<Holder<mctech.g.a.a<?, ?>>, mctech.g.a.h.c> n;
    private final Map<Holder<mctech.g.a.a<?, ?>>, CompoundTag> o;
    private final e p;
    private boolean q;
    private d r;
    private static final String s = "FacadeProvider";
    private static final String t = "Conduits";
    private static final String u = "Connections";
    private static final String v = "NodeData";
    private static final String w = "ConduitWorldData";

    @Nullable
    public Direction d;
    private boolean x;
    private boolean y;
    private boolean z;

    public b(BlockPos blockPos, BlockState blockState) {
        super((BlockEntityType) MCTechTiles.CONDUIT.get(), blockPos, blockState);
        this.g = ItemStack.EMPTY;
        this.h = new ArrayList();
        this.i = new HashMap();
        this.j = new HashMap();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = null;
        this.n = null;
        this.o = new HashMap();
        this.p = new e();
        this.q = false;
        this.r = d.NONE;
        this.x = false;
        this.z = false;
    }

    @Override // mctech.g.d.a.a.c
    public void i() {
        super.i();
        if (this.level != null) {
            this.r = this.r.b();
            if (this.r.a()) {
                a(this.level, getBlockPos(), (BlockPos) null, false);
            }
            if (this.q) {
                this.level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
                setChanged();
                this.q = false;
            }
        }
    }

    public void onLoad() {
        super.onLoad();
        k();
        m();
        if (this.level != null && !this.level.isClientSide()) {
            for (Holder<mctech.g.a.a<?, ?>> holder : this.h) {
                ((mctech.g.a.a) holder.value()).a(this.j.get(holder), this.level, getBlockPos(), (Player) null);
            }
            Iterator<Map.Entry<Holder<mctech.g.a.a<?, ?>>, mctech.g.d.a.c>> it = this.l.entrySet().iterator();
            while (it.hasNext()) {
                Holder<mctech.g.a.a<?, ?>> key = it.next().getKey();
                for (Direction direction : Direction.values()) {
                    a(key, direction, false);
                }
            }
        }
        if (this.level != null && e()) {
            this.level.getLightEngine().checkBlock(getBlockPos());
        }
    }

    private void r() {
        if (this.x) {
            return;
        }
        this.level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
        this.level.updateNeighborsAt(getBlockPos(), getBlockState().getBlock());
        this.level.invalidateCapabilities(getBlockPos());
        setChanged();
        k();
        if (this.level.isClientSide()) {
            l();
        }
    }

    public e j() {
        return this.p;
    }

    public void k() {
        this.p.a(this);
    }

    public void l() {
        LongSet longSet;
        requestModelDataUpdate();
        if (this.level != null) {
            this.level.sendBlockUpdated(this.worldPosition, getBlockState(), getBlockState(), 3);
            ResourceLocation resourceLocationLocation = this.level.dimension().location();
            if (e()) {
                if (b.containsKey(resourceLocationLocation)) {
                    b.get(resourceLocationLocation).put(this.worldPosition.asLong(), f().defaultBlockState());
                } else {
                    Long2ObjectMap<BlockState> long2ObjectOpenHashMap = new Long2ObjectOpenHashMap<>();
                    long2ObjectOpenHashMap.put(this.worldPosition.asLong(), f().defaultBlockState());
                    b.put(resourceLocationLocation, long2ObjectOpenHashMap);
                }
                if (c.containsKey(resourceLocationLocation)) {
                    ((LongSet) c.get(resourceLocationLocation).computeIfAbsent(SectionPos.asLong(this.worldPosition), j -> {
                        return new LongOpenHashSet();
                    })).add(this.worldPosition.asLong());
                    return;
                }
                Long2ObjectMap<LongSet> long2ObjectOpenHashMap2 = new Long2ObjectOpenHashMap<>();
                LongOpenHashSet longOpenHashSet = new LongOpenHashSet();
                longOpenHashSet.add(this.worldPosition.asLong());
                long2ObjectOpenHashMap2.put(SectionPos.asLong(this.worldPosition), longOpenHashSet);
                c.put(resourceLocationLocation, long2ObjectOpenHashMap2);
                return;
            }
            if (b.containsKey(resourceLocationLocation)) {
                b.get(resourceLocationLocation).remove(this.worldPosition.asLong());
            }
            if (c.containsKey(resourceLocationLocation) && (longSet = (LongSet) c.get(resourceLocationLocation).getOrDefault(SectionPos.asLong(this.worldPosition), (Object) null)) != null) {
                longSet.remove(this.worldPosition.asLong());
            }
        }
    }

    @NotNull
    public ModelData getModelData() {
        return ModelData.builder().with(mctech.g.c.b.a.c.a, mctech.g.c.b.a.c.a(this)).build();
    }

    @Override // mctech.g.d.a.c.a.c
    public List<Holder<mctech.g.a.a<?, ?>>> c(Direction direction) {
        return this.h.stream().filter(holder -> {
            return e(holder, direction);
        }).toList();
    }

    @Override // mctech.g.d.a.c.a.c
    public boolean e(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        if (this.level == null || !((mctech.g.a.a) holder.value()).g() || !f(holder) || (this.level.getBlockEntity(getBlockPos().relative(direction)) instanceof b)) {
            return false;
        }
        return ((mctech.g.a.a) holder.value()).b(this.level, getBlockPos(), direction);
    }

    @Override // mctech.g.d.c
    public ItemInteractionResult a(@NotNull UseOnContext useOnContext) {
        if (this.level == null) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        Direction clickedFace = useOnContext.getClickedFace();
        Holder<mctech.g.a.a<?, ?>> holderB = this.p.b(useOnContext.getClickedPos(), useOnContext.getHitResult());
        if (holderB == null) {
            return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }
        Player player = useOnContext.getPlayer();
        if (player != null && player.isSteppingCarefully()) {
            a(holderB, itemStack -> {
                if (!player.getAbilities().instabuild) {
                    b(itemStack);
                }
            });
            if (b()) {
                this.level.setBlock(getBlockPos(), getBlockState().getFluidState().createLegacyBlock(), this.level.isClientSide ? 11 : 3);
            }
            return ItemInteractionResult.sidedSuccess(this.level.isClientSide());
        }
        Pair<Direction, Holder<mctech.g.a.a<?, ?>>> pairC = this.p.c(useOnContext.getClickedPos(), useOnContext.getHitResult());
        if (pairC != null) {
            a(pairC);
            return ItemInteractionResult.sidedSuccess(this.level.isClientSide());
        }
        if (!b(holderB, clickedFace).b()) {
            a(holderB, clickedFace, true);
            return ItemInteractionResult.sidedSuccess(this.level.isClientSide());
        }
        return ItemInteractionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x003a, code lost:
    
        r0 = (mctech.g.d.a.a.b) r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(com.mojang.datafixers.util.Pair<net.minecraft.core.Direction, net.minecraft.core.Holder<mctech.g.a.a<?, ?>>> r6) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mctech.g.d.a.a.b.a(com.mojang.datafixers.util.Pair):void");
    }

    public static <TCap, TContext> ICapabilityProvider<b, TContext, TCap> a(BlockCapability<TCap, TContext> blockCapability) {
        return (bVar, obj) -> {
            Iterator<Holder<mctech.g.a.a<?, ?>>> it = bVar.a().iterator();
            while (it.hasNext()) {
                Object objA = a((BlockCapability<Object, Object>) blockCapability, bVar, it.next(), obj);
                if (objA != null) {
                    return objA;
                }
            }
            return null;
        };
    }

    @Nullable
    private static <TCap, TContext> TCap a(BlockCapability<TCap, TContext> blockCapability, b bVar, Holder<mctech.g.a.a<?, ?>> holder, @Nullable TContext tcontext) {
        if (bVar.level == null) {
            return null;
        }
        mctech.g.d.a.c cVar = bVar.j.get(holder);
        if (cVar != null && !cVar.b()) {
            return null;
        }
        return (TCap) ((mctech.g.a.a) holder.value()).a(bVar.level, cVar, blockCapability, tcontext);
    }

    @Override // mctech.g.a.c
    public List<Holder<mctech.g.a.a<?, ?>>> a() {
        return Collections.unmodifiableList(this.h);
    }

    @Override // mctech.g.a.c
    public boolean d(Holder<mctech.g.a.a<?, ?>> holder) {
        return this.h.stream().anyMatch(holder2 -> {
            return mctech.g.d.b.a(holder, holder2);
        });
    }

    @Override // mctech.g.a.c
    public boolean a(m<?> mVar) {
        return this.h.stream().anyMatch(holder -> {
            return ((mctech.g.a.a) holder.value()).d() == mVar;
        });
    }

    @Override // mctech.g.a.c
    public boolean f(Holder<mctech.g.a.a<?, ?>> holder) {
        return this.h.contains(holder);
    }

    @Override // mctech.g.a.c
    @Nullable
    public Holder<mctech.g.a.a<?, ?>> b(m<?> mVar) {
        return this.h.stream().filter(holder -> {
            return ((mctech.g.a.a) holder.value()).d() == mVar;
        }).findFirst().orElse(null);
    }

    @Override // mctech.g.a.c
    @Nullable
    public Holder<mctech.g.a.a<?, ?>> e(Holder<mctech.g.a.a<?, ?>> holder) {
        return this.h.stream().filter(holder2 -> {
            return mctech.g.d.b.a(holder2, holder);
        }).findFirst().orElse(null);
    }

    @Override // mctech.g.a.c
    public boolean b() {
        return this.h.isEmpty() && !e();
    }

    @Override // mctech.g.a.c
    public boolean c() {
        return this.h.size() == 9;
    }

    private Optional<Holder<mctech.g.a.a<?, ?>>> j(Holder<mctech.g.a.a<?, ?>> holder) {
        return this.h.stream().filter(holder2 -> {
            return mctech.g.d.b.b(holder, holder2);
        }).findFirst();
    }

    private boolean k(Holder<mctech.g.a.a<?, ?>> holder) {
        return this.h.stream().allMatch(holder2 -> {
            return (((mctech.g.a.a) holder2.value()).d() == ((mctech.g.a.a) holder.value()).d() || mctech.g.d.b.a(holder, holder2)) ? false : true;
        });
    }

    @Override // mctech.g.a.c
    public boolean a(Holder<mctech.g.a.a<?, ?>> holder) {
        if (this.level == null || c() || f(holder)) {
            return false;
        }
        if (j(holder).isPresent()) {
            return true;
        }
        if (d(holder)) {
            return false;
        }
        return k(holder);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // mctech.g.a.c
    public mctech.g.a.b.a a(Holder<mctech.g.a.a<?, ?>> holder, @Nullable Direction direction, @Nullable Player player) throws MatchException {
        mctech.g.a.b.a bVar;
        mctech.g.d.a.c cVar;
        if (this.level == null) {
            return new mctech.g.a.b.a.C0006a();
        }
        if (c()) {
            return new mctech.g.a.b.a.C0006a();
        }
        if (f(holder)) {
            return new mctech.g.a.b.a.C0006a();
        }
        Optional<Holder<mctech.g.a.a<?, ?>>> optionalJ = j(holder);
        if (optionalJ.isPresent()) {
            this.h.set(this.h.indexOf(optionalJ.get()), holder);
            this.i.put(holder, this.i.remove(optionalJ.get()).a(holder));
            this.k.remove(optionalJ.get());
            if (!this.level.isClientSide()) {
                mctech.g.d.a.c cVarRemove = this.j.remove(optionalJ.get());
                if (cVarRemove != null) {
                    cVar = new mctech.g.d.a.c(holder, getBlockPos(), cVarRemove.f());
                    ((mctech.g.a.a) holder.value()).a(cVarRemove, this.level, getBlockPos());
                    cVarRemove.l().e(cVarRemove);
                    cVarRemove.g();
                } else {
                    cVar = new mctech.g.d.a.c(holder, getBlockPos());
                }
                a(holder, cVar);
                ((mctech.g.a.a) holder.value()).a(cVar, this.level, getBlockPos(), player);
            }
            bVar = new mctech.g.a.b.a.c(optionalJ.get());
        } else {
            if (d(holder)) {
                return new mctech.g.a.b.a.C0006a();
            }
            if (!k(holder)) {
                return new mctech.g.a.b.a.C0006a();
            }
            int iA = f.a(holder);
            Optional<Holder<mctech.g.a.a<?, ?>>> optionalFindFirst = this.h.stream().filter(holder2 -> {
                return f.a((Holder<mctech.g.a.a<?, ?>>) holder2) > iA;
            }).findFirst();
            if (optionalFindFirst.isPresent()) {
                this.h.add(this.h.indexOf(optionalFindFirst.get()), holder);
            } else {
                this.h.add(holder);
            }
            this.i.put(holder, new a(holder));
            if (!this.level.isClientSide()) {
                mctech.g.d.a.c cVar2 = new mctech.g.d.a.c(holder, getBlockPos());
                a(holder, cVar2);
                if (this.h.size() != 1) {
                    ((mctech.g.a.a) holder.value()).a(cVar2, this.level, getBlockPos(), player);
                }
            }
            bVar = new mctech.g.a.b.a.b();
        }
        if (direction != null) {
            a(holder, direction, false);
        }
        for (Direction direction2 : Direction.values()) {
            if (direction2 != direction) {
                a(holder, direction2, false);
            }
        }
        ServerLevel serverLevel = this.level;
        if (serverLevel instanceof ServerLevel) {
            mctech.g.d.a.d.a(serverLevel, b(holder).l());
        }
        if (bVar instanceof mctech.g.a.b.a.c) {
            try {
                Holder<mctech.g.a.a<?, ?>> holderB = ((mctech.g.a.b.a.c) bVar).b();
                if (!mctech.g.d.b.a(holder, holderB)) {
                    g(holderB);
                }
            } catch (Throwable th) {
                throw new MatchException(th.toString(), th);
            }
        }
        r();
        return bVar;
    }

    @Override // mctech.g.a.c
    public void a(Holder<mctech.g.a.a<?, ?>> holder, @Nullable Consumer<ItemStack> consumer) {
        if (this.level == null) {
            return;
        }
        if (!f(holder)) {
            if (!FMLLoader.isProduction()) {
                throw new IllegalArgumentException("Conduit: " + holder.getRegisteredName() + " is not present in conduit bundle " + Arrays.toString(this.h.stream().map((v0) -> {
                    return v0.getRegisteredName();
                }).toArray()));
            }
            return;
        }
        if (!this.level.isClientSide() && consumer != null) {
            consumer.accept(mctech.g.a.b.a(holder, 1));
            for (Direction direction : Direction.values()) {
                IItemHandlerModifiable iItemHandlerModifiableD = d(holder, direction);
                if (iItemHandlerModifiableD != null) {
                    for (int i = 0; i < iItemHandlerModifiableD.getSlots(); i++) {
                        ItemStack stackInSlot = iItemHandlerModifiableD.getStackInSlot(i);
                        if (!stackInSlot.isEmpty()) {
                            consumer.accept(stackInSlot);
                            iItemHandlerModifiableD.setStackInSlot(i, ItemStack.EMPTY);
                        }
                    }
                }
            }
        }
        if (!this.level.isClientSide()) {
            mctech.g.d.a.c cVarB = b(holder);
            ((mctech.g.a.a) holder.value()).a(cVarB, this.level, getBlockPos());
            cVarB.g();
            if (cVarB.j()) {
                cVarB.l().a(cVarB, bVar -> {
                    mctech.g.d.a.d.a(this.level, bVar);
                });
            }
        }
        this.h.remove(holder);
        this.i.remove(holder);
        this.j.remove(holder);
        this.k.remove(holder);
        g(holder);
        if (((mctech.g.a.a) holder.value()).d() == MCTechConduitTypes.REDSTONE.get()) {
            for (Direction direction2 : Direction.values()) {
                d(direction2);
            }
        }
        r();
    }

    public void g(Holder<mctech.g.a.a<?, ?>> holder) {
        for (Direction direction : Direction.values()) {
            f(holder, direction);
        }
    }

    private void f(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        if (this.level == null) {
            return;
        }
        BlockEntity blockEntity = this.level.getBlockEntity(getBlockPos().relative(direction));
        if (!(blockEntity instanceof b)) {
            return;
        }
        ((b) blockEntity).i(holder, direction.getOpposite());
    }

    private void b(ItemStack itemStack) {
        if (this.level != null) {
            Vec3 center = getBlockPos().getCenter();
            this.level.addFreshEntity(new ItemEntity(this.level, center.x, center.y, center.z, itemStack.copy()));
        }
    }

    @Override // mctech.g.a.c
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public mctech.g.d.a.c b(Holder<mctech.g.a.a<?, ?>> holder) {
        if (!f(holder)) {
            throw new IllegalStateException("Conduit not found in bundle.");
        }
        return this.j.get(holder);
    }

    @Override // mctech.g.a.c
    @Nullable
    public CompoundTag c(Holder<mctech.g.a.a<?, ?>> holder) {
        if (this.level != null && !this.level.isClientSide()) {
            return ((mctech.g.a.a) holder.value()).a(this, b(holder));
        }
        return this.o.get(holder);
    }

    @Override // mctech.g.a.c, mctech.g.d.a.c.a.c
    @Nullable
    public CompoundTag a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        return ((mctech.g.a.a) holder.value()).a(this, b(holder), direction);
    }

    private void a(Holder<mctech.g.a.a<?, ?>> holder, mctech.g.d.a.c cVar) {
        this.j.put(holder, cVar);
        cVar.a(this, holder);
    }

    @Override // mctech.g.a.c
    public List<Holder<mctech.g.a.a<?, ?>>> b(Direction direction) {
        return this.i.entrySet().stream().filter(entry -> {
            return ((a) entry.getValue()).b(direction).b();
        }).map((v0) -> {
            return v0.getKey();
        }).sorted(Comparator.comparingInt(f::a)).toList();
    }

    @Override // mctech.g.a.c, mctech.g.a.h.b
    @Nullable
    public IItemHandlerModifiable d(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        if (!f(holder)) {
            throw new IllegalStateException("Conduit not found in bundle.");
        }
        return this.i.computeIfAbsent(holder, holder2 -> {
            return new a(holder2);
        }).a(direction);
    }

    @Override // mctech.g.a.c, mctech.g.a.h.b
    public mctech.g.a.c.f b(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        return this.i.computeIfAbsent(holder, holder2 -> {
            return new a(holder2);
        }).b(direction);
    }

    @Override // mctech.g.a.c, mctech.g.a.h.b, mctech.g.d.a.c.a.c
    public mctech.g.a.c.c c(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        return this.i.get(holder).c(direction);
    }

    @Override // mctech.g.a.c, mctech.g.a.h.b
    public <T extends mctech.g.a.c.c> T a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, mctech.g.a.c.e<T> eVar) {
        T t2 = (T) this.i.get(holder).c(direction);
        if (t2.a() != eVar) {
            throw new IllegalStateException("Connection config type mismatch.");
        }
        return t2;
    }

    @Override // mctech.g.a.c, mctech.g.a.h.b, mctech.g.d.a.c.a.c
    public void a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, mctech.g.a.c.c cVar) {
        if (cVar.a() != ((mctech.g.a.a) holder.value()).f()) {
            throw new IllegalArgumentException("Connection config is not the right type for this conduit.");
        }
        this.i.get(holder).a(direction, cVar);
        if (cVar.ac_() && b(holder, direction) != mctech.g.a.c.f.CONNECTED_BLOCK) {
            a(holder, direction, mctech.g.a.c.f.CONNECTED_BLOCK);
        } else if (!cVar.ac_()) {
            a(holder, direction, mctech.g.a.c.f.DISABLED);
        } else if (this.level != null && !this.level.isClientSide()) {
            b(holder).h();
        }
        r();
    }

    public void a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, mctech.g.a.c.f fVar) {
        if (!f(holder)) {
            throw new IllegalArgumentException("Conduit is not present in this bundle.");
        }
        this.i.get(holder).a(direction, fVar);
        i(holder);
        r();
    }

    public boolean a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, mctech.g.d.a.c cVar, boolean z) {
        Holder<mctech.g.a.a<?, ?>> holderE;
        if (this.level == null || (holderE = e(holder)) == null) {
            return false;
        }
        if ((((mctech.g.a.a) holderE.value()).h() || ((mctech.g.a.a) holder.value()).h()) && (this.level.isClientSide() || !((mctech.g.a.a) holderE.value()).a(this.j.get(holderE), cVar))) {
            return false;
        }
        return z || this.i.get(holderE).b(direction) != mctech.g.a.c.f.DISABLED;
    }

    @Override // mctech.g.a.c
    public boolean a(Holder<mctech.g.a.a<?, ?>> holder, Direction direction, boolean z) {
        Holder<mctech.g.a.a<?, ?>> holderE;
        if (this.level == null) {
            return false;
        }
        if (!f(holder)) {
            throw new IllegalArgumentException("Conduit is not present in this bundle.");
        }
        mctech.g.a.c.f fVarB = this.i.get(holder).b(direction);
        if (!z && fVarB == mctech.g.a.c.f.DISABLED) {
            return false;
        }
        BlockEntity blockEntity = this.level.getBlockEntity(getBlockPos().relative(direction));
        if (blockEntity instanceof b) {
            b bVar = (b) blockEntity;
            mctech.g.d.a.c cVar = this.j.get(holder);
            if (bVar.a(holder, direction.getOpposite(), cVar, z)) {
                g(holder, direction);
                bVar.g(holder, direction.getOpposite());
                if (!this.level.isClientSide() && (holderE = bVar.e(holder)) != null) {
                    mctech.g.d.a.c cVarB = bVar.b(holderE);
                    ((mctech.g.a.a) holder.value()).b(cVar, cVarB);
                    ((mctech.g.a.a) holderE.value()).b(cVarB, cVar);
                    cVar.l().a(cVar, cVarB, bVar2 -> {
                        mctech.g.d.a.d.b(this.level, bVar2);
                    });
                    return true;
                }
                return true;
            }
            i(holder, direction);
            return false;
        }
        if (((mctech.g.a.a) holder.value()).a(this.level, getBlockPos(), direction) || (z && ((mctech.g.a.a) holder.value()).b(this.level, getBlockPos(), direction))) {
            h(holder, direction);
            return true;
        }
        return false;
    }

    public void i(Holder<mctech.g.a.a<?, ?>> holder) {
        if (this.level != null && !this.level.isClientSide) {
            mctech.g.d.a.c cVarB = b(holder);
            ((mctech.g.a.a) holder.value()).a(cVarB, this.level, getBlockPos(), (Set<Direction>) Arrays.stream(Direction.values()).filter(direction -> {
                return b((Holder<mctech.g.a.a<?, ?>>) holder, direction).b();
            }).collect(Collectors.toSet()));
            cVarB.l().a(cVarB);
        }
    }

    private void g(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        Holder<mctech.g.a.a<?, ?>> holderE = e(holder);
        if (holderE == null) {
            return;
        }
        this.i.computeIfAbsent(holderE, holder2 -> {
            return new a(holder2);
        }).a(direction, mctech.g.a.c.f.CONNECTED_CONDUIT);
        i(holderE);
        r();
    }

    private void h(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        this.i.computeIfAbsent(holder, holder2 -> {
            return new a(holder2);
        }).a(direction, mctech.g.a.c.f.CONNECTED_BLOCK);
        i(holder);
        r();
    }

    private void i(Holder<mctech.g.a.a<?, ?>> holder, Direction direction) {
        boolean z = false;
        for (Holder<mctech.g.a.a<?, ?>> holder2 : this.h) {
            if (mctech.g.d.b.a(holder, holder2)) {
                this.i.computeIfAbsent(holder2, holder3 -> {
                    return new a(holder3);
                }).a(direction, mctech.g.a.c.f.DISCONNECTED);
                i(holder2);
                z = true;
            }
        }
        if (z) {
            r();
        }
    }

    public void a(Level level, BlockPos blockPos, @Nullable BlockPos blockPos2, boolean z) {
        if (blockPos2 != null && (level.getBlockEntity(blockPos2) instanceof b)) {
            return;
        }
        for (Direction direction : Direction.values()) {
            for (Holder<mctech.g.a.a<?, ?>> holder : this.h) {
                if (z && ((mctech.g.a.a) holder.value()).j()) {
                    this.r = this.r.c();
                } else {
                    mctech.g.a.c.f fVarB = b(holder, direction);
                    if (fVarB.a()) {
                        a(holder, direction, false);
                    } else if (fVarB.c() && !((mctech.g.a.a) holder.value()).b(level, getBlockPos(), direction)) {
                        i(holder, direction);
                        i(holder);
                    }
                }
            }
        }
    }

    @Override // mctech.g.a.h.b
    public void h() {
        this.q = true;
    }

    @Override // mctech.g.a.h.b
    @Nullable
    public <TCapability> TCapability a(Holder<mctech.g.a.a<?, ?>> holder, BlockCapability<TCapability, Direction> blockCapability, Direction direction) {
        ServerLevel serverLevel = this.level;
        if (serverLevel instanceof ServerLevel) {
            return (TCapability) this.k.computeIfAbsent(holder, holder2 -> {
                return new c();
            }).a(blockCapability, serverLevel, getBlockPos(), direction);
        }
        return null;
    }

    @Override // mctech.g.a.h.b
    @Nullable
    public <TCapability> TCapability b(Holder<mctech.g.a.a<?, ?>> holder, BlockCapability<TCapability, Void> blockCapability, Direction direction) {
        ServerLevel serverLevel = this.level;
        if (serverLevel instanceof ServerLevel) {
            return (TCapability) this.k.computeIfAbsent(holder, holder2 -> {
                return new c();
            }).b(blockCapability, serverLevel, getBlockPos(), direction);
        }
        return null;
    }

    public void m() {
        if (this.level == null) {
            this.y = false;
        } else {
            this.y = this.level.hasNeighborSignal(getBlockPos());
        }
        if (this.level != null && !this.level.isClientSide()) {
            Iterator<mctech.g.d.a.c> it = this.j.values().iterator();
            while (it.hasNext()) {
                it.next().i();
            }
        }
    }

    @Override // mctech.g.a.h.b
    public boolean a(@Nullable DyeColor dyeColor) {
        Holder<mctech.g.a.a<?, ?>> holderB;
        mctech.g.d.a.b bVarK;
        mctech.g.d.a.d.g.c cVar;
        if (this.y) {
            return true;
        }
        if (dyeColor == null || (holderB = b(MCTechConduitTypes.REDSTONE.get())) == null || (bVarK = b(holderB).l()) == null || (cVar = (mctech.g.d.a.d.g.c) bVarK.b(MCTechConduitTypes.ContextTypes.REDSTONE.get())) == null) {
            return false;
        }
        return cVar.a(dyeColor);
    }

    @Override // mctech.g.a.c
    public boolean e() {
        return (this.g.isEmpty() || this.g.getCapability(mctech.g.a.d.a) == null) ? false : true;
    }

    @Override // mctech.g.a.c
    public Block f() {
        if (this.g.isEmpty()) {
            throw new IllegalStateException("This bundle has no facade provider.");
        }
        mctech.g.a.d.a aVar = (mctech.g.a.d.a) this.g.getCapability(mctech.g.a.d.a);
        if (aVar == null) {
            return Blocks.BEDROCK;
        }
        return aVar.b();
    }

    @Override // mctech.g.a.c
    public mctech.g.a.d.b g() {
        if (this.g.isEmpty()) {
            throw new IllegalStateException("This bundle has no facade provider.");
        }
        mctech.g.a.d.a aVar = (mctech.g.a.d.a) this.g.getCapability(mctech.g.a.d.a);
        if (aVar == null) {
            return mctech.g.a.d.b.BASIC;
        }
        return aVar.c();
    }

    @Override // mctech.g.a.c
    public ItemStack d() {
        return this.g;
    }

    @Override // mctech.g.a.c
    public void a(ItemStack itemStack) {
        this.g = itemStack.copyWithCount(1);
        r();
    }

    public void n() {
        b(this.g);
    }

    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override // mctech.g.d.a.a.c
    public CompoundTag getUpdateTag(HolderLookup.Provider provider) {
        CompoundTag updateTag = super.getUpdateTag(provider);
        ListTag listTag = new ListTag();
        for (Holder<mctech.g.a.a<?, ?>> holder : this.h) {
            CompoundTag compoundTagA = ((mctech.g.a.a) holder.value()).a(this, b(holder));
            if (compoundTagA != null && !compoundTagA.isEmpty()) {
                CompoundTag compoundTag = new CompoundTag();
                compoundTag.put("Conduit", (Tag) mctech.g.a.a.b.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), holder).getOrThrow());
                compoundTag.put(mctech.g.d.a.a.c.e, compoundTagA);
                listTag.add(compoundTag);
            }
        }
        updateTag.put(w, listTag);
        return updateTag;
    }

    @Override // mctech.g.d.a.a.c
    public void handleUpdateTag(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.handleUpdateTag(compoundTag, provider);
        if (compoundTag.contains(w)) {
            this.o.clear();
            ListTag list = compoundTag.getList(w, 10);
            RegistryOps registryOpsCreateSerializationContext = provider.createSerializationContext(NbtOps.INSTANCE);
            for (int i = 0; i < list.size(); i++) {
                CompoundTag compound = list.getCompound(i);
                this.o.put((Holder) mctech.g.a.a.b.parse(registryOpsCreateSerializationContext, compound.get("Conduit")).getOrThrow(), compound.getCompound(mctech.g.d.a.a.c.e));
            }
        }
        k();
        t();
    }

    public void onDataPacket(Connection connection, ClientboundBlockEntityDataPacket clientboundBlockEntityDataPacket, HolderLookup.Provider provider) {
        CompoundTag tag = clientboundBlockEntityDataPacket.getTag();
        if (!tag.isEmpty()) {
            handleUpdateTag(tag, provider);
        }
    }

    public void setLevel(Level level) {
        super.setLevel(level);
        if (!level.isClientSide()) {
            this.x = true;
            s();
            this.x = false;
        }
    }

    private void s() {
        ServerLevel serverLevel = this.level;
        if (!(serverLevel instanceof ServerLevel)) {
            return;
        }
        mctech.g.d.a.d dVarA = mctech.g.d.a.d.a(serverLevel);
        for (int i = 0; i < this.h.size(); i++) {
            a(dVarA, this.h.get(i), i);
        }
        this.n = null;
        this.m = null;
    }

    private void a(mctech.g.d.a.d dVar, Holder<mctech.g.a.a<?, ?>> holder, int i) {
        mctech.g.d.a.c cVar;
        if (this.level == null || this.level.isClientSide()) {
            return;
        }
        mctech.g.d.a.c cVarA = dVar.a(holder, this.worldPosition);
        if (cVarA != null || this.j.get(holder) != null) {
            if (cVarA != null) {
                a(holder, cVarA);
                return;
            }
            return;
        }
        mctech.g.a.h.c cVarRemove = null;
        if (this.n != null && this.n.containsKey(holder)) {
            cVarRemove = this.n.remove(holder);
        }
        if (cVarRemove == null) {
            mctech.g.f.c cVarA2 = null;
            if (this.m != null && i < this.m.size()) {
                cVarA2 = mctech.g.f.c.a(this.level.registryAccess(), this.m.getCompound(i));
            }
            if (cVarA2 != null) {
                cVar = new mctech.g.d.a.c(holder, getBlockPos(), cVarA2);
            } else {
                cVar = new mctech.g.d.a.c(holder, getBlockPos());
            }
        } else {
            cVar = new mctech.g.d.a.c(holder, getBlockPos(), cVarRemove);
        }
        a(holder, cVar);
        this.l.put(holder, cVar);
        mctech.g.d.a.d.a(this.level, cVar.l());
    }

    public void onChunkUnloaded() {
        super.onChunkUnloaded();
        this.z = true;
        if (this.level == null) {
            return;
        }
        ServerLevel serverLevel = this.level;
        if (serverLevel instanceof ServerLevel) {
            mctech.g.d.a.d dVarA = mctech.g.d.a.d.a(serverLevel);
            for (Holder<mctech.g.a.a<?, ?>> holder : this.h) {
                mctech.g.d.a.c cVar = this.j.get(holder);
                ((mctech.g.a.a) holder.value()).a(cVar, this.level, getBlockPos());
                cVar.g();
                dVarA.a(holder, this.worldPosition, cVar);
            }
            return;
        }
        ResourceLocation resourceLocationLocation = this.level.dimension().location();
        if (c.containsKey(resourceLocationLocation)) {
            c.get(resourceLocationLocation).remove(SectionPos.asLong(this.worldPosition));
        }
        if (b.containsKey(resourceLocationLocation)) {
            b.get(resourceLocationLocation).remove(this.worldPosition.asLong());
        }
    }

    public void setRemoved() {
        super.setRemoved();
        if (!this.z) {
            Iterator it = List.copyOf(a()).iterator();
            while (it.hasNext()) {
                a((Holder<mctech.g.a.a<?, ?>>) it.next(), this::b);
            }
            a(ItemStack.EMPTY);
        }
        if (this.level != null && this.level.isClientSide) {
            ResourceLocation resourceLocationLocation = this.level.dimension().location();
            if (b.containsKey(resourceLocationLocation)) {
                b.get(resourceLocationLocation).remove(this.worldPosition.asLong());
            }
        }
    }

    @Override // mctech.g.d.a.a.c
    protected void saveAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        mctech.g.a.h.c cVarF;
        super.saveAdditional(compoundTag, provider);
        RegistryOps registryOpsCreateSerializationContext = provider.createSerializationContext(NbtOps.INSTANCE);
        ListTag listTag = new ListTag();
        for (Holder<mctech.g.a.a<?, ?>> holder : this.h) {
            if (this.j.containsKey(holder) && (cVarF = this.j.get(holder).f()) != null && cVarF.a().a()) {
                CompoundTag compoundTag2 = new CompoundTag();
                compoundTag2.put("Conduit", (Tag) mctech.g.a.a.b.encodeStart(registryOpsCreateSerializationContext, holder).getOrThrow());
                compoundTag2.put(mctech.g.d.a.a.c.e, (Tag) mctech.g.a.h.c.a.encodeStart(registryOpsCreateSerializationContext, cVarF).getOrThrow());
                listTag.add(compoundTag2);
            }
        }
        compoundTag.put(v, listTag);
    }

    @Override // mctech.g.d.a.a.c
    protected void a(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.a(compoundTag, provider);
        if (!this.h.isEmpty()) {
            ListTag listTag = new ListTag();
            Iterator<Holder<mctech.g.a.a<?, ?>>> it = this.h.iterator();
            while (it.hasNext()) {
                listTag.add((Tag) mctech.g.a.a.b.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), it.next()).getOrThrow());
            }
            compoundTag.put(t, listTag);
            ListTag listTag2 = new ListTag();
            for (Holder<mctech.g.a.a<?, ?>> holder : this.h) {
                ListTag listTag3 = new ListTag();
                for (Direction direction : Direction.values()) {
                    CompoundTag compoundTag2 = new CompoundTag();
                    compoundTag2.putString("Side", direction.getSerializedName());
                    compoundTag2.putString("Status", b(holder, direction).getSerializedName());
                    mctech.g.a.c.c cVar = this.i.get(holder).d.get(direction);
                    if (cVar != null && !cVar.equals(cVar.a().a())) {
                        compoundTag2.put("Config", (Tag) mctech.g.a.c.c.a.encodeStart(provider.createSerializationContext(NbtOps.INSTANCE), cVar).getOrThrow());
                    }
                    a.C0011a c0011a = this.i.get(holder).e.get(direction);
                    if (c0011a != null) {
                        ListTag listTag4 = new ListTag();
                        boolean z = false;
                        for (int i = 0; i < c0011a.getSlots(); i++) {
                            ItemStack stackInSlot = c0011a.getStackInSlot(i);
                            z |= !stackInSlot.isEmpty();
                            listTag4.add(stackInSlot.isEmpty() ? new CompoundTag() : DataComponentUtil.wrapEncodingExceptions(stackInSlot, MCTechCodecs.UNLIMITED_ITEM_STACK.codec(), provider, new CompoundTag()));
                        }
                        if (z) {
                            compoundTag2.put("Inventory", listTag4);
                        }
                    }
                    listTag3.add(compoundTag2);
                }
                listTag2.add(listTag3);
            }
            compoundTag.put(u, listTag2);
        }
        if (!this.g.isEmpty()) {
            compoundTag.put(s, this.g.save(provider));
        }
    }

    protected void loadAdditional(CompoundTag compoundTag, HolderLookup.Provider provider) {
        super.loadAdditional(compoundTag, provider);
        if (compoundTag.contains(mctech.g.a.a)) {
            a(C0012b.a(provider, compoundTag.getCompound(mctech.g.a.a)));
        } else {
            this.h.clear();
            if (compoundTag.contains(t, 9)) {
                Iterator it = compoundTag.get(t).iterator();
                while (it.hasNext()) {
                    this.h.add((Holder) mctech.g.a.a.b.parse(provider.createSerializationContext(NbtOps.INSTANCE), (Tag) it.next()).getOrThrow());
                }
            }
            this.i.clear();
            if (compoundTag.contains(u)) {
                ListTag list = compoundTag.getList(u, 9);
                for (int i = 0; i < list.size(); i++) {
                    ListTag list2 = list.getList(i);
                    Holder<mctech.g.a.a<?, ?>> holder = this.h.get(i);
                    a aVar = new a(holder);
                    for (int i2 = 0; i2 < list2.size(); i2++) {
                        CompoundTag compound = list2.getCompound(i2);
                        Direction directionByName = Direction.byName(compound.getString("Side"));
                        mctech.g.a.c.f fVarA = mctech.g.a.c.f.a(compound.getString("Status"));
                        if (fVarA == null) {
                            fVarA = mctech.g.a.c.f.DISCONNECTED;
                        }
                        if (directionByName != null) {
                            aVar.a(directionByName, fVarA);
                            if (compound.contains("Config")) {
                                aVar.a(directionByName, (mctech.g.a.c.c) mctech.g.a.c.c.a.parse(provider.createSerializationContext(NbtOps.INSTANCE), compound.get("Config")).getOrThrow());
                            }
                            if (compound.contains("Inventory")) {
                                ListTag list3 = compound.getList("Inventory", 10);
                                IItemHandlerModifiable iItemHandlerModifiableA = aVar.a(directionByName);
                                if (iItemHandlerModifiableA != null) {
                                    if (iItemHandlerModifiableA.getSlots() < list3.size()) {
                                    }
                                    for (int i3 = 0; i3 < list3.size() && i3 < iItemHandlerModifiableA.getSlots(); i3++) {
                                        iItemHandlerModifiableA.setStackInSlot(i3, (ItemStack) MCTechCodecs.UNLIMITED_ITEM_STACK.codec().parse(provider.createSerializationContext(NbtOps.INSTANCE), list3.getCompound(i3)).resultOrPartial(str -> {
                                            MCTech.LOGGER.error("Tried to load invalid item: '{}'", str);
                                        }).orElse(ItemStack.EMPTY));
                                    }
                                }
                            }
                        }
                    }
                    this.i.put(holder, aVar);
                }
            }
            if (compoundTag.contains(s)) {
                this.g = ItemStack.parseOptional(provider, compoundTag.getCompound(s));
            } else {
                this.g = ItemStack.EMPTY;
            }
        }
        if (compoundTag.contains(mctech.g.a.b)) {
            this.m = compoundTag.getList(mctech.g.a.b, 10);
        } else if (compoundTag.contains(v)) {
            ListTag list4 = compoundTag.getList(v, 10);
            this.n = new HashMap();
            RegistryOps registryOpsCreateSerializationContext = provider.createSerializationContext(NbtOps.INSTANCE);
            for (int i4 = 0; i4 < list4.size(); i4++) {
                CompoundTag compound2 = list4.getCompound(i4);
                DataResult dataResult = mctech.g.a.a.b.parse(registryOpsCreateSerializationContext, compound2.get("Conduit"));
                if (!dataResult.isError()) {
                    DataResult dataResult2 = mctech.g.a.h.c.a.parse(registryOpsCreateSerializationContext, compound2.get(mctech.g.d.a.a.c.e));
                    if (!dataResult2.isError()) {
                        this.n.put((Holder) dataResult.getOrThrow(), (mctech.g.a.h.c) dataResult2.getOrThrow());
                    }
                }
            }
        }
        t();
    }

    private void t() {
        if (this.level == null || !this.level.isClientSide()) {
            return;
        }
        for (Direction direction : Direction.values()) {
            BlockEntity blockEntity = this.level.getBlockEntity(getBlockPos().relative(direction));
            if (blockEntity instanceof b) {
                b bVar = (b) blockEntity;
                for (Holder<mctech.g.a.a<?, ?>> holder : this.h) {
                    mctech.g.a.c.f fVarB = b(holder, direction);
                    mctech.g.a.c.f fVarB2 = bVar.b(holder, direction.getOpposite());
                    if (fVarB == mctech.g.a.c.f.CONNECTED_CONDUIT && fVarB2 == mctech.g.a.c.f.DISCONNECTED) {
                        bVar.g(holder, direction.getOpposite());
                    }
                }
            }
        }
        l();
    }

    private void d(Direction direction) {
        if (this.level != null) {
            if (!this.level.getBlockState(getBlockPos().relative(direction)).is(getBlockState().getBlock())) {
                this.level.updateNeighborsAt(getBlockPos().relative(direction), getBlockState().getBlock());
            }
        }
    }

    @Override // mctech.components.u
    public ItemStack a(Direction direction) {
        List<Holder<mctech.g.a.a<?, ?>>> listB = b(direction);
        if (listB.isEmpty()) {
            return ItemStack.EMPTY;
        }
        return mctech.g.a.b.a((Holder<mctech.g.a.a<?, ?>>) listB.getFirst(), 1);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/b$a.class */
    private class a {
        private final Holder<mctech.g.a.a<?, ?>> b;
        private final Map<Direction, mctech.g.a.c.f> c = new EnumMap(Direction.class);
        private final Map<Direction, mctech.g.a.c.c> d = new EnumMap(Direction.class);
        private final Map<Direction, C0011a> e = new EnumMap(Direction.class);

        public a(Holder<mctech.g.a.a<?, ?>> holder) {
            this.b = holder;
            mctech.g.a.c.c cVarA = ((mctech.g.a.a) holder.value()).f().a();
            for (Direction direction : Direction.values()) {
                this.c.put(direction, mctech.g.a.c.f.DISCONNECTED);
                this.d.put(direction, cVarA);
            }
        }

        public a a(Holder<mctech.g.a.a<?, ?>> holder) {
            a aVar = b.this.new a(holder);
            aVar.c.putAll(this.c);
            if (((mctech.g.a.a) this.b.value()).f() == ((mctech.g.a.a) holder.value()).f()) {
                aVar.d.putAll(this.d);
            }
            if (((mctech.g.a.a) this.b.value()).k() > 0 && ((mctech.g.a.a) holder.value()).k() > 0) {
                for (Direction direction : Direction.values()) {
                    if (this.e.containsKey(direction)) {
                        C0011a c0011a = this.e.get(direction);
                        IItemHandlerModifiable iItemHandlerModifiable = (IItemHandlerModifiable) Objects.requireNonNull(aVar.a(direction));
                        for (int i = 0; i < Math.max(c0011a.getSlots(), iItemHandlerModifiable.getSlots()); i++) {
                            iItemHandlerModifiable.setStackInSlot(i, c0011a.getStackInSlot(i));
                        }
                    }
                }
            }
            return aVar;
        }

        @Nullable
        public IItemHandlerModifiable a(Direction direction) {
            if (((mctech.g.a.a) this.b.value()).k() <= 0) {
                return null;
            }
            return this.e.computeIfAbsent(direction, direction2 -> {
                return new C0011a();
            });
        }

        public mctech.g.a.c.f b(Direction direction) {
            return this.c.getOrDefault(direction, mctech.g.a.c.f.DISCONNECTED);
        }

        public void a(Direction direction, mctech.g.a.c.f fVar) {
            this.c.put(direction, fVar);
            if (fVar == mctech.g.a.c.f.CONNECTED_BLOCK && this.d.containsKey(direction)) {
                mctech.g.a.c.c cVar = this.d.get(direction);
                if (!cVar.ac_()) {
                    this.d.put(direction, cVar.c());
                }
            }
            if (((mctech.g.a.a) this.b.value()).d() == MCTechConduitTypes.REDSTONE.get()) {
                b.this.d(direction);
            }
        }

        public mctech.g.a.c.c c(Direction direction) {
            mctech.g.a.c.c cVarA = ((mctech.g.a.a) this.b.value()).f().a();
            mctech.g.a.c.c orDefault = this.d.getOrDefault(direction, cVarA);
            if (orDefault.a() != ((mctech.g.a.a) this.b.value()).f()) {
                orDefault = cVarA;
                this.d.put(direction, orDefault);
                b.this.r();
            }
            if (this.c.get(direction) != mctech.g.a.c.f.CONNECTED_BLOCK && orDefault.ac_()) {
                return orDefault.d();
            }
            return orDefault;
        }

        public void a(Direction direction, mctech.g.a.c.c cVar) {
            this.d.put(direction, cVar);
            if (((mctech.g.a.a) this.b.value()).d() == MCTechConduitTypes.REDSTONE.get()) {
                b.this.d(direction);
            }
        }

        /* JADX INFO: renamed from: mctech.g.d.a.a.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/b$a$a.class */
        private class C0011a extends ItemStackHandler {
            public C0011a() {
                super(((mctech.g.a.a) a.this.b.value()).k());
            }

            public boolean isItemValid(int i, ItemStack itemStack) {
                return ((mctech.g.a.a) a.this.b.value()).a(i, itemStack);
            }

            protected void onContentsChanged(int i) {
                if (b.this.level != null) {
                    b.this.r();
                }
            }
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/b$c.class */
    private static class c {
        private final Map<Direction, Map<BlockCapability<?, Direction>, BlockCapabilityCache<?, Direction>>> a = new EnumMap(Direction.class);
        private final Map<Direction, Map<BlockCapability<?, Void>, BlockCapabilityCache<?, Void>>> b = new EnumMap(Direction.class);

        private c() {
        }

        @Nullable
        public <TCapability> TCapability a(BlockCapability<TCapability, Direction> blockCapability, ServerLevel serverLevel, BlockPos blockPos, Direction direction) {
            return (TCapability) this.a.computeIfAbsent(direction, direction2 -> {
                return new HashMap();
            }).computeIfAbsent(blockCapability, blockCapability2 -> {
                return BlockCapabilityCache.create(blockCapability2, serverLevel, blockPos.relative(direction), direction.getOpposite());
            }).getCapability();
        }

        @Nullable
        public <TCapability> TCapability b(BlockCapability<TCapability, Void> blockCapability, ServerLevel serverLevel, BlockPos blockPos, Direction direction) {
            return (TCapability) this.b.computeIfAbsent(direction, direction2 -> {
                return new HashMap();
            }).computeIfAbsent(blockCapability, blockCapability2 -> {
                return BlockCapabilityCache.create(blockCapability2, serverLevel, blockPos.relative(direction), (Object) null);
            }).getCapability();
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/b$d.class */
    public enum d {
        NONE,
        NEXT_NEXT,
        NEXT,
        INITIALIZED;

        public boolean a() {
            return this == INITIALIZED;
        }

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public d b() throws MatchException {
            switch (this) {
                case NONE:
                case INITIALIZED:
                    return NONE;
                case NEXT_NEXT:
                    return NEXT;
                case NEXT:
                    return INITIALIZED;
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }

        public d c() {
            return NEXT_NEXT;
        }
    }

    /* JADX INFO: renamed from: mctech.g.d.a.a.b$b, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/b$b.class */
    private static final class C0012b extends Record {
        private final BlockPos b;
        private final List<Holder<mctech.g.a.a<?, ?>>> c;
        private final Map<Direction, a> d;
        private final ItemStack e;
        private final Map<Holder<mctech.g.a.a<?, ?>>, mctech.g.d.a.c> f;
        public static final Codec<C0012b> a = RecordCodecBuilder.create(instance -> {
            return instance.group(BlockPos.CODEC.fieldOf("pos").forGetter(c0012b -> {
                return c0012b.b;
            }), mctech.g.a.a.b.listOf().fieldOf("conduits").forGetter(c0012b2 -> {
                return c0012b2.c;
            }), Codec.unboundedMap(Direction.CODEC, a.a).fieldOf("connections").forGetter(c0012b3 -> {
                return c0012b3.d;
            }), ItemStack.OPTIONAL_CODEC.optionalFieldOf("facade", ItemStack.EMPTY).forGetter(c0012b4 -> {
                return c0012b4.e;
            }), Codec.unboundedMap(mctech.g.a.a.b, mctech.g.d.a.c.a).fieldOf("nodes").forGetter(c0012b5 -> {
                return c0012b5.f;
            })).apply(instance, C0012b::new);
        });

        private C0012b(BlockPos blockPos, List<Holder<mctech.g.a.a<?, ?>>> list, Map<Direction, a> map, ItemStack itemStack, Map<Holder<mctech.g.a.a<?, ?>>, mctech.g.d.a.c> map2) {
            this.b = blockPos;
            this.c = list;
            this.d = map;
            this.e = itemStack;
            this.f = map2;
        }

        @Override // java.lang.Record
        public final String toString() {
            return (String) ObjectMethods.bootstrap(MethodHandles.lookup(), "toString", MethodType.methodType(String.class, C0012b.class), C0012b.class, "pos;conduits;connections;facadeItem;conduitNodes", "FIELD:Lmctech/g/d/a/a/b$b;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/d/a/a/b$b;->c:Ljava/util/List;", "FIELD:Lmctech/g/d/a/a/b$b;->d:Ljava/util/Map;", "FIELD:Lmctech/g/d/a/a/b$b;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/d/a/a/b$b;->f:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final int hashCode() {
            return (int) ObjectMethods.bootstrap(MethodHandles.lookup(), "hashCode", MethodType.methodType(Integer.TYPE, C0012b.class), C0012b.class, "pos;conduits;connections;facadeItem;conduitNodes", "FIELD:Lmctech/g/d/a/a/b$b;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/d/a/a/b$b;->c:Ljava/util/List;", "FIELD:Lmctech/g/d/a/a/b$b;->d:Ljava/util/Map;", "FIELD:Lmctech/g/d/a/a/b$b;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/d/a/a/b$b;->f:Ljava/util/Map;").dynamicInvoker().invoke(this) /* invoke-custom */;
        }

        @Override // java.lang.Record
        public final boolean equals(Object obj) {
            return (boolean) ObjectMethods.bootstrap(MethodHandles.lookup(), "equals", MethodType.methodType(Boolean.TYPE, C0012b.class, Object.class), C0012b.class, "pos;conduits;connections;facadeItem;conduitNodes", "FIELD:Lmctech/g/d/a/a/b$b;->b:Lnet/minecraft/core/BlockPos;", "FIELD:Lmctech/g/d/a/a/b$b;->c:Ljava/util/List;", "FIELD:Lmctech/g/d/a/a/b$b;->d:Ljava/util/Map;", "FIELD:Lmctech/g/d/a/a/b$b;->e:Lnet/minecraft/world/item/ItemStack;", "FIELD:Lmctech/g/d/a/a/b$b;->f:Ljava/util/Map;").dynamicInvoker().invoke(this, obj) /* invoke-custom */;
        }

        public BlockPos a() {
            return this.b;
        }

        public List<Holder<mctech.g.a.a<?, ?>>> b() {
            return this.c;
        }

        public Map<Direction, a> c() {
            return this.d;
        }

        public ItemStack d() {
            return this.e;
        }

        public Map<Holder<mctech.g.a.a<?, ?>>, mctech.g.d.a.c> e() {
            return this.f;
        }

        public static C0012b a(HolderLookup.Provider provider, Tag tag) {
            return (C0012b) ((Pair) a.decode(provider.createSerializationContext(NbtOps.INSTANCE), tag).getOrThrow()).getFirst();
        }

        /* JADX INFO: renamed from: mctech.g.d.a.a.b$b$a */
        /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/a/a/b$b$a.class */
        public static final class a {
            public static final Codec<a> a = mctech.g.f.e.a.listOf(0, 9).xmap(a::new, aVar -> {
                return Arrays.stream(aVar.b).toList();
            });
            private final mctech.g.f.e[] b = (mctech.g.f.e[]) Util.make(() -> {
                mctech.g.f.e[] eVarArr = new mctech.g.f.e[9];
                Arrays.fill(eVarArr, l.DISCONNECTED);
                return eVarArr;
            });

            private a(List<mctech.g.f.e> list) {
                if (list.size() > 9) {
                    throw new IllegalArgumentException("Cannot store more than 9 conduit types per bundle.");
                }
                for (int i = 0; i < list.size(); i++) {
                    this.b[i] = list.get(i);
                }
            }

            public mctech.g.f.e a(int i) {
                return this.b[i];
            }
        }
    }

    private void a(C0012b c0012b) {
        this.h = new ArrayList();
        this.h.addAll(c0012b.c);
        this.g = c0012b.e.copy();
        this.i = new HashMap();
        for (Holder<mctech.g.a.a<?, ?>> holder : this.h) {
            int iIndexOf = this.h.indexOf(holder);
            a aVarComputeIfAbsent = this.i.computeIfAbsent(holder, holder2 -> {
                return new a(holder2);
            });
            for (Direction direction : Direction.values()) {
                mctech.g.f.e eVarA = c0012b.d.get(direction).a(iIndexOf);
                if (eVarA == l.CONNECTED || eVarA == l.CONNECTED_ACTIVE) {
                    aVarComputeIfAbsent.a(direction, mctech.g.a.c.f.CONNECTED_CONDUIT);
                } else if (eVarA == l.DISCONNECTED) {
                    aVarComputeIfAbsent.a(direction, mctech.g.a.c.f.DISCONNECTED);
                } else if (eVarA == l.DISABLED) {
                    aVarComputeIfAbsent.a(direction, mctech.g.a.c.f.DISABLED);
                } else if (eVarA instanceof mctech.g.f.f) {
                    mctech.g.f.f fVar = (mctech.g.f.f) eVarA;
                    aVarComputeIfAbsent.a(direction, mctech.g.a.c.f.CONNECTED_BLOCK);
                    aVarComputeIfAbsent.a(direction, ((mctech.g.a.a) holder.value()).a(fVar.c(), fVar.e(), fVar.d(), fVar.f(), fVar.g(), fVar.h()));
                    IItemHandlerModifiable iItemHandlerModifiableD = d(holder, direction);
                    if (iItemHandlerModifiableD != null) {
                        int iA = ((mctech.g.a.a) holder.value()).a(k.FILTER_INSERT);
                        int iA2 = ((mctech.g.a.a) holder.value()).a(k.FILTER_EXTRACT);
                        if (iA >= 0) {
                            iItemHandlerModifiableD.setStackInSlot(iA, fVar.i());
                        }
                        if (iA2 >= 0) {
                            iItemHandlerModifiableD.setStackInSlot(iA2, fVar.j());
                        }
                    }
                }
            }
        }
    }

    @Override // mctech.g.d.a.c.a.c
    public boolean a(Player player) {
        if (this.level == null || this.level.getBlockEntity(this.worldPosition) != this) {
            return false;
        }
        return player.canInteractWithBlock(this.worldPosition, 1.5d);
    }

    @NotNull
    public Component getName() {
        return Component.translatable(getBlockState().getBlock().getDescriptionId());
    }
}
