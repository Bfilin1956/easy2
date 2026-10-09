package mctech.c;

import com.mojang.blaze3d.audio.Channel;
import net.minecraft.client.sounds.ChannelAccess;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/c/e.class */
@OnlyIn(Dist.CLIENT)
public class e implements g {
    private static final float t = 16.0f;
    public static final int a = 1;
    public static final int b = 2;
    public static final int c = 4;
    public static final int d = 8;
    public static final int e = 16;
    public static final int f = 32;
    public static final int g = 64;
    public static final int h = 128;
    c i;
    ResourceLocation j;
    f k;
    ChannelAccess.ChannelHandle l;
    Vec3 m;
    b.a n;
    float p;
    float q;
    float r;
    float o = 1.0f;
    int s = 65;

    public e(c cVar, ResourceLocation resourceLocation, f fVar, b.a aVar, float f2, float f3, boolean z, boolean z2) {
        this.i = cVar;
        this.j = resourceLocation;
        this.k = fVar;
        this.m = fVar.b();
        this.n = aVar;
        this.p = f2;
        this.r = f3;
        if (z) {
            a(4);
        }
        if (z2) {
            a(8);
        }
    }

    public e(c cVar) {
        this.i = cVar;
    }

    protected void a(int i) {
        this.s |= i;
    }

    protected boolean b(int i) {
        return (this.s & i) == i;
    }

    protected boolean c(int i) {
        return (this.s & i) != i;
    }

    protected void d(int i) {
        this.s &= i ^ (-1);
    }

    @Override // mctech.c.g
    public boolean a() {
        return b(1);
    }

    @Override // mctech.c.g
    public boolean b() {
        return b(64);
    }

    @Override // mctech.c.g
    public boolean c() {
        return b(16) && c(32);
    }

    @Override // mctech.c.g
    public boolean d() {
        return b(32);
    }

    @Override // mctech.c.g
    public boolean e() {
        return b(8);
    }

    @Override // mctech.c.g
    public float f() {
        return this.p;
    }

    @Override // mctech.c.g
    public float g() {
        return this.q;
    }

    @Override // mctech.c.g
    public float h() {
        return this.r;
    }

    @Override // mctech.c.g
    public void a(float f2) {
        if (c(1)) {
            return;
        }
        this.p = f2;
        a(2);
    }

    @Override // mctech.c.g
    public void b(float f2) {
        if (c(1)) {
            return;
        }
        this.r = f2;
        a(2);
    }

    @Override // mctech.c.g
    public void i() {
        if (c(1)) {
            return;
        }
        d(32);
        a(16);
        if (this.l != null && b(64)) {
            this.l.execute((v0) -> {
                v0.play();
            });
        }
    }

    @Override // mctech.c.g
    public void j() {
        if (c(1)) {
            return;
        }
        a(32);
        if (this.l != null && b(64)) {
            this.l.execute((v0) -> {
                v0.pause();
            });
        }
    }

    @Override // mctech.c.g
    public void k() {
        if (c(1)) {
            return;
        }
        d(48);
        if (this.l != null && b(64)) {
            this.l.execute((v0) -> {
                v0.stop();
            });
        }
    }

    @Override // mctech.c.g
    public void l() {
        k();
        d(1);
    }

    @Override // mctech.c.g
    public void m() {
        if (c(65)) {
            return;
        }
        if (b(16)) {
            k();
            a(16);
        }
        d(64);
    }

    @Override // mctech.c.g
    public void n() {
        if (c(1) || b(64)) {
            return;
        }
        a(64);
        o();
    }

    public void o() {
        if (c(65)) {
            return;
        }
        if (this.l != null && this.l.isStopped()) {
            this.l = null;
            if (c(4)) {
                d(48);
            }
        }
        if (this.l == null && c(128)) {
            a(128);
            this.i.j().thenAccept(channelHandle -> {
                this.l = channelHandle;
                d(128);
                this.l.execute(channel -> {
                    channel.attachStaticBuffer(this.i.b(this.j));
                    a(channel, true);
                    if (b(16) && c(32)) {
                        channel.play();
                    }
                });
            });
        }
    }

    @Override // mctech.c.g
    public f p() {
        return this.k;
    }

    @Override // mctech.c.g
    public void q() {
        if (c(1)) {
            return;
        }
        this.m = this.k.b();
        if (this.l != null) {
            this.l.execute(channel -> {
                channel.setSelfPosition(this.m);
            });
        }
    }

    @Override // mctech.c.g
    public void a(Player player) {
        if (c(1)) {
            this.q = 0.0f;
            return;
        }
        if (this.i.e()) {
            this.o = this.i.a(this.n, this.m);
        }
        float fA = (((this.p * this.i.a(this.n)) * this.i.c()) * this.o) / this.p;
        if (Double.isNaN(fA)) {
            fA = 1.0f;
        }
        double dMax = fA > 1.0f ? 16.0f * fA * Math.max(this.p, 0.2f) : 16.0f * Math.max(this.p, 0.2f);
        double dMax2 = 1.0d;
        Vec3 vec3Position = player.position();
        if (this.k.a(player.level())) {
            dMax2 = Math.max(1.0d, this.k.b().distanceTo(vec3Position));
        }
        if (dMax2 > dMax) {
            this.q = 0.0f;
            m();
            return;
        }
        a(64);
        double d2 = ((double) this.p) * (1.0d - (dMax2 / dMax)) * ((double) fA);
        if (d2 > 0.10000000149011612d) {
            Vec3 vec3A = mctech.utils.math.c.a(this.k.b().subtract(vec3Position), dMax2);
            for (int i = 0; i < dMax2; i++) {
                BlockPos blockPos = new BlockPos((int) vec3Position.x, (int) vec3Position.y, (int) vec3Position.z);
                BlockState blockState = player.level().getBlockState(blockPos);
                if (blockState.getBlock() != Blocks.AIR) {
                    d2 *= blockState.isSolidRender(player.level(), blockPos) ? 0.6d : 0.8d;
                }
                vec3Position = vec3Position.add(vec3A);
            }
        }
        this.q = (float) d2;
        if (this.q <= 1.0E-4f) {
            this.q = 0.0f;
            m();
        } else if (this.l != null) {
            if (b(2)) {
                d(2);
                this.l.execute(channel -> {
                    a(channel, false);
                });
            } else {
                this.l.execute(channel2 -> {
                    channel2.setVolume(this.q);
                });
            }
        }
    }

    public void a(Channel channel, boolean z) {
        if (z) {
            channel.setLooping(b(4));
            channel.disableAttenuation();
            channel.setRelative(false);
            channel.setSelfPosition(this.m);
        }
        channel.setVolume(this.q);
        channel.setPitch(this.r);
    }
}
