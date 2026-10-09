package mctech.c;

import com.mojang.blaze3d.audio.Library;
import com.mojang.blaze3d.audio.SoundBuffer;
import it.unimi.dsi.fastutil.longs.Long2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMaps;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectMaps;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import it.unimi.dsi.fastutil.objects.ObjectListIterator;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import mctech.MCTech;
import mctech.init.MCTechItems;
import mctech.mixin.client.audio.SoundEngineMixin;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.client.sounds.SoundBufferLibrary;
import net.minecraft.client.sounds.SoundManager;
import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.entity.EntityJoinLevelEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/c.class */
@OnlyIn(Dist.CLIENT)
public class c extends b {
    static final Function<h, List<e>> a = hVar -> {
        return mctech.utils.a.b.i();
    };
    ChannelAccess b;
    SoundBufferLibrary c;
    List<mctech.c.b.d> f = mctech.utils.a.b.i();
    Long2ObjectMap<EnumMap<b.a, mctech.c.a>> g = new Long2ObjectLinkedOpenHashMap();
    Object2ObjectMap<h, List<e>> h = mctech.utils.a.b.f();
    RandomSource i = SoundInstance.createUnseededRandom();
    boolean d = true;
    boolean e = false;
    boolean j = false;

    @Override // mctech.c.b
    public void a() {
        super.a();
        NeoForge.EVENT_BUS.register(this);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void a(EntityJoinLevelEvent entityJoinLevelEvent) {
        Player entity = entityJoinLevelEvent.getEntity();
        if (entity instanceof Player) {
            Player player = entity;
            a((mctech.c.b.d) new mctech.c.b.b(player));
            a((mctech.c.b.d) new mctech.c.b.e(player));
            a((mctech.c.b.d) new mctech.c.b.c(player, (Item) MCTechItems.CHAINSAW.get()));
            a((mctech.c.b.d) new mctech.c.b.a(player, (Item) MCTechItems.ADVANCED_CHAINSAW.get()));
        }
    }

    @Override // mctech.c.b
    public void a(mctech.c.b.d dVar) {
        this.f.add(dVar);
    }

    @Override // mctech.c.b
    public void a(BlockPos blockPos, EnumMap<b.a, mctech.c.a> enumMap) {
        if (enumMap.isEmpty()) {
            return;
        }
        this.g.put(blockPos.asLong(), enumMap);
        this.j = true;
    }

    @Override // mctech.c.b
    public void a(BlockPos blockPos) {
        this.g.remove(blockPos.asLong());
        this.j = true;
    }

    public boolean e() {
        return this.j;
    }

    public float a(b.a aVar, Vec3 vec3) {
        float fA = 1.0f;
        BlockPos.MutableBlockPos mutableBlockPos = new BlockPos.MutableBlockPos();
        ObjectIterator it = Long2ObjectMaps.fastIterable(this.g).iterator();
        while (it.hasNext()) {
            Long2ObjectMap.Entry entry = (Long2ObjectMap.Entry) it.next();
            mctech.c.a aVar2 = (mctech.c.a) ((EnumMap) entry.getValue()).get(aVar);
            if (aVar2 != null) {
                mutableBlockPos.set(entry.getLongKey());
                if (Math.sqrt(mutableBlockPos.distToCenterSqr(vec3)) > aVar2.b() + 0.5f) {
                    continue;
                } else {
                    fA *= aVar2.a();
                    if (fA <= 0.0f) {
                        return 0.0f;
                    }
                }
            }
        }
        return fA;
    }

    public boolean f() {
        return (!this.d || this.b == null || this.c == null) ? false : true;
    }

    @Override // mctech.c.b
    public g b(Object obj, DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        return a(obj, deferredHolder, b.a.STATIC, 1.0f, true, false);
    }

    @Override // mctech.c.b
    public g a(Object obj, DeferredHolder<SoundEvent, SoundEvent> deferredHolder, b.a aVar, float f, boolean z, boolean z2) {
        if (!this.d || deferredHolder == null || Math.min(c(), Math.min(a(aVar), f)) <= 0.0f) {
            return null;
        }
        if (!f()) {
            i();
            if (!f()) {
                return null;
            }
        }
        SoundEvent soundEventCreateVariableRangeEvent = (SoundEvent) deferredHolder.get();
        WeighedSoundEvents soundEvent = Minecraft.getInstance().getSoundManager().getSoundEvent(soundEventCreateVariableRangeEvent.getLocation());
        if (soundEvent != null) {
            Sound sound = soundEvent.getSound(this.i);
            soundEventCreateVariableRangeEvent = sound == SoundManager.EMPTY_SOUND ? soundEventCreateVariableRangeEvent : SoundEvent.createVariableRangeEvent(sound.getPath());
        }
        if (Minecraft.getInstance().getResourceManager().getResource(soundEventCreateVariableRangeEvent.getLocation()).isEmpty()) {
            MCTech.LOGGER.info("Couldn't find the Sound File: {}", soundEventCreateVariableRangeEvent.getLocation());
            return null;
        }
        h hVarA = a(obj, aVar);
        if (hVarA == null) {
            MCTech.LOGGER.info("Couldn't create a Provider: {}", obj);
            return null;
        }
        e eVar = new e(this, soundEventCreateVariableRangeEvent.getLocation(), hVarA.a(), aVar, f, 1.0f, z, z2);
        ((List) this.h.computeIfAbsent(hVarA, a)).add(eVar);
        return eVar;
    }

    @Override // mctech.c.b
    public void a(Object obj, DeferredHolder<SoundEvent, SoundEvent> deferredHolder) {
        a(obj, deferredHolder, b.a.STATIC);
    }

    @Override // mctech.c.b
    public void a(Object obj, DeferredHolder<SoundEvent, SoundEvent> deferredHolder, b.a aVar) {
        a(obj, deferredHolder, aVar, 1.0f, 1.0f);
    }

    @Override // mctech.c.b
    public void a(Object obj, DeferredHolder<SoundEvent, SoundEvent> deferredHolder, b.a aVar, float f, float f2) {
        if (!this.d || deferredHolder == null || Math.min(c(), Math.min(a(aVar), f)) <= 0.0f) {
            return;
        }
        if (!f()) {
            i();
            if (!f()) {
                return;
            }
        }
        float fC = f * c() * a(aVar);
        SoundEvent soundEventCreateVariableRangeEvent = (SoundEvent) deferredHolder.get();
        WeighedSoundEvents soundEvent = Minecraft.getInstance().getSoundManager().getSoundEvent(soundEventCreateVariableRangeEvent.getLocation());
        if (soundEvent != null) {
            Sound sound = soundEvent.getSound(this.i);
            soundEventCreateVariableRangeEvent = sound == SoundManager.EMPTY_SOUND ? soundEventCreateVariableRangeEvent : SoundEvent.createVariableRangeEvent(sound.getPath());
        }
        if (Minecraft.getInstance().getResourceManager().getResource(soundEventCreateVariableRangeEvent.getLocation()).isEmpty()) {
            MCTech.LOGGER.info("Couldn't find the Sound File: " + String.valueOf(deferredHolder));
            return;
        }
        h hVarA = a(obj, aVar);
        if (hVarA == null) {
            MCTech.LOGGER.info("Couldn't create a Provider: " + String.valueOf(obj));
            return;
        }
        float fA = fC * a(aVar, hVarA.a().b());
        SoundEvent soundEvent2 = soundEventCreateVariableRangeEvent;
        j().thenAccept(channelHandle -> {
            channelHandle.execute(channel -> {
                channel.attachStaticBuffer(b(soundEvent2.getLocation()));
                channel.setLooping(false);
                channel.linearAttenuation(16.0f * Math.max(0.2f, fA));
                channel.setRelative(false);
                channel.setSelfPosition(hVarA.a().b());
                channel.setVolume(fA);
                channel.setPitch(f2);
                channel.play();
            });
        });
    }

    public ResourceLocation a(ResourceLocation resourceLocation) {
        WeighedSoundEvents soundEvent = Minecraft.getInstance().getSoundManager().getSoundEvent(resourceLocation);
        if (soundEvent == null) {
            return resourceLocation;
        }
        Sound sound = soundEvent.getSound(this.i);
        return sound == SoundManager.EMPTY_SOUND ? resourceLocation : sound.getPath();
    }

    private h a(Object obj, b.a aVar) {
        if (obj instanceof h) {
            return (h) obj;
        }
        if (obj instanceof mctech.c.a.e) {
            return new mctech.c.a.d((f) obj);
        }
        if (obj instanceof BlockEntity) {
            return new mctech.c.a.c((BlockEntity) obj);
        }
        if (obj instanceof Entity) {
            return new mctech.c.a.b((Entity) obj, aVar);
        }
        return null;
    }

    @Override // mctech.c.b
    public float c() {
        return (float) MCTech.CONFIG.masterVolume.get();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
    @Override // mctech.c.b
    public float a(b.a aVar) throws MatchException {
        switch (aVar) {
            case BACKPACK:
                return (float) MCTech.CONFIG.backVolume.get();
            case ITEM:
                return (float) MCTech.CONFIG.itemVolume.get();
            case STATIC:
                return (float) MCTech.CONFIG.blockVolume.get();
            default:
                throw new MatchException((String) null, (Throwable) null);
        }
    }

    @Override // mctech.c.b
    public void a(Object obj) {
        List list;
        if (!f() || (list = (List) this.h.remove(a(obj, b.a.STATIC))) == null) {
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((e) it.next()).l();
        }
    }

    @Override // mctech.c.b
    public void d() {
        this.e = true;
    }

    public void g() {
        Minecraft minecraft = Minecraft.getInstance();
        Level level = minecraft.level;
        Player player = minecraft.player;
        if (!f()) {
            return;
        }
        if (this.e || level == null || player == null) {
            ObjectListIterator it = new ObjectArrayList(this.h.keySet()).iterator();
            while (it.hasNext()) {
                a((h) it.next());
            }
            this.e = false;
            return;
        }
        ObjectArrayList objectArrayList = new ObjectArrayList();
        ObjectArrayList<e> objectArrayList2 = new ObjectArrayList();
        ObjectIterator it2 = Object2ObjectMaps.fastIterable(this.h).iterator();
        while (it2.hasNext()) {
            Object2ObjectMap.Entry entry = (Object2ObjectMap.Entry) it2.next();
            if (!((h) entry.getKey()).a(level) || ((List) entry.getValue()).isEmpty()) {
                objectArrayList.add((h) entry.getKey());
            } else {
                Iterator it3 = ((List) entry.getValue()).iterator();
                while (it3.hasNext()) {
                    e eVar = (e) it3.next();
                    if (!eVar.a()) {
                        it3.remove();
                    } else {
                        eVar.q();
                        eVar.a(player);
                        if (eVar.b() && (eVar.c() || eVar.d())) {
                            if (eVar.p().a(level)) {
                                objectArrayList2.add(eVar);
                            }
                        }
                    }
                }
            }
        }
        this.j = false;
        Iterator it4 = objectArrayList.iterator();
        while (it4.hasNext()) {
            a((h) it4.next());
        }
        objectArrayList2.sort(a.a);
        int i = 0;
        for (e eVar2 : objectArrayList2) {
            if (i < 20) {
                eVar2.o();
            } else {
                eVar2.m();
            }
            i++;
        }
    }

    public void h() {
        Level level = Minecraft.getInstance().level;
        Iterator<mctech.c.b.d> it = this.f.iterator();
        while (it.hasNext()) {
            mctech.c.b.d next = it.next();
            if (next.a(level)) {
                next.a();
            } else {
                it.remove();
            }
        }
    }

    public void i() {
        SoundEngineMixin soundEngine = Minecraft.getInstance().getSoundManager().getSoundEngine();
        if (soundEngine == null) {
            return;
        }
        this.b = soundEngine.getChannels();
        this.c = soundEngine.getAudioBuffers();
    }

    protected CompletableFuture<ChannelAccess.ChannelHandle> j() {
        return this.b.createHandle(Library.Pool.STATIC);
    }

    protected SoundBuffer b(ResourceLocation resourceLocation) {
        return (SoundBuffer) this.c.getCompleteBuffer(resourceLocation).join();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/c$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements Comparator<e> {
        public static final a a = new a();

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(e eVar, e eVar2) {
            int iCompare = Boolean.compare(eVar2.e(), eVar.e());
            return iCompare != 0 ? iCompare : Float.compare(eVar2.g(), eVar.g());
        }
    }
}
