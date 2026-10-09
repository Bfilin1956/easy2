package mctech.items.g.b;

import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.init.MCTechDataComponent;
import mctech.init.MCTechSounds;
import mctech.items.base.MCTechElectricItem;
import mctech.items.base.o;
import net.minecraft.client.Minecraft;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/h.class */
public abstract class h extends e implements mctech.items.g.b.b {

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/h$b.class */
    public interface b {
        h a(ItemStack itemStack);
    }

    public abstract boolean c(ItemStack itemStack);

    public abstract boolean d(ItemStack itemStack);

    public abstract boolean e(ItemStack itemStack);

    public abstract boolean f(ItemStack itemStack);

    public abstract float g(ItemStack itemStack);

    public abstract float a(ItemStack itemStack, a aVar);

    public abstract float h(ItemStack itemStack);

    public abstract int a(ItemStack itemStack, int i);

    public abstract int b(ItemStack itemStack);

    public abstract int a(ItemStack itemStack);

    public abstract int i(ItemStack itemStack);

    public abstract int b(ItemStack itemStack, a aVar);

    public abstract void a(Player player, ItemStack itemStack, int i);

    public h(ArmorItem.Type type, @Nullable o oVar) {
        super(type, oVar);
    }

    public boolean j(ItemStack itemStack) {
        return true;
    }

    public mctech.c.g a(ItemStack itemStack, Player player, c cVar) {
        return MCTech.AUDIO.a(player, cVar == c.FULL ? MCTechSounds.TOOL_JETPACK_IDLE : MCTechSounds.TOOL_JETPACK_START, mctech.c.b.a.BACKPACK, 1.0f, true, false);
    }

    @Override // mctech.items.g.b.e
    public Ingredient a() {
        return Ingredient.EMPTY;
    }

    @Override // mctech.items.g.b.f, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        if (this instanceof mctech.m.a.e) {
            dVar.b("", new Object[0]);
            dVar.b(a(mctech.s.a.RIGHT_CLICK, mctech.s.a.SIDE_INV_KEY, "tooltip.mctech.open_item_inventory", new Object[0]));
        }
    }

    @Override // mctech.items.g.b.b
    @OnlyIn(Dist.CLIENT)
    public void a(ItemStack itemStack, ItemStack itemStack2, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
    }

    public c a(ItemStack itemStack, Player player, mctech.s.d dVar, a aVar, Entity entity) {
        if (player != null && Minecraft.getInstance().screen != null) {
            return c.NONE;
        }
        int iB = b(itemStack);
        if (iB <= 0) {
            return c.NONE;
        }
        c cVar = c.NONE;
        boolean zF = f(itemStack);
        float fG = g(itemStack);
        float fH = h(itemStack);
        if (((double) iB) / ((double) a(itemStack)) <= fH) {
            fG *= (float) (((double) iB) / ((double) (a(itemStack) * fH)));
            cVar = c.DROPPED;
        }
        boolean zIsFallFlying = player.isFallFlying();
        if (dVar.t && !zIsFallFlying) {
            float fA = fG * a(itemStack, aVar) * 2.0f;
            if (fA > 0.0f) {
                float f = 0.02f;
                if (dVar.m && c(itemStack)) {
                    f = 0.02f * 10.0f;
                }
                entity.moveRelative(f, new Vec3(0.0d, 0.0d, 0.4d * ((double) fA)));
            }
        }
        int iA = a(itemStack, player.level().getMaxBuildHeight());
        double y = entity.getY();
        if (y > iA - 25) {
            if (y > iA) {
                y = iA;
            }
            fG *= (float) ((((double) iA) - y) / 25.0d);
        }
        Vec3 deltaMovement = entity.getDeltaMovement();
        if (zIsFallFlying) {
            float fA2 = fG * a(itemStack, aVar) * 2.0f;
            if (fA2 > 0.0f) {
                entity.moveRelative(0.1f, new Vec3(0.0d, 0.0d, 0.4d * ((double) Math.min(fA2, 0.7f))));
            }
        } else {
            entity.setDeltaMovement(deltaMovement.x, Math.min(deltaMovement.y + ((double) (fG * 0.2f)), 0.6000000238418579d), deltaMovement.z);
        }
        if (aVar != a.NONE) {
            float f2 = aVar == a.BASIC ? -0.2f : 0.0f;
            if (!player.isShiftKeyDown() || !dVar.s) {
                f2 = (aVar == a.BASIC || player.isShiftKeyDown()) ? -0.2f : 0.0f;
                if (zF && dVar.s) {
                    f2 = aVar == a.BASIC ? 0.1f : 0.3f;
                }
            }
            Vec3 deltaMovement2 = entity.getDeltaMovement();
            if (deltaMovement2.y > f2) {
                entity.setDeltaMovement(deltaMovement2.x, Math.max(deltaMovement.y, f2), deltaMovement2.z);
            }
        }
        if (o(itemStack) != a.NONE) {
            entity.fallDistance = 0.0f;
            entity.walkDist = 0.0f;
        }
        if (cVar != c.NONE) {
            float f3 = zIsFallFlying ? 0.2f : 0.75f;
            Vec2 vec2A = a(player, -0.65f, zIsFallFlying);
            entity.level().addParticle(ParticleTypes.SMALL_FLAME, player.getX() + ((double) vec2A.x), player.getY() + ((double) f3), player.getZ() + ((double) vec2A.y), 0.0d, 0.0d, 0.0d);
            Vec2 vec2A2 = a(player, 0.65f, zIsFallFlying);
            entity.level().addParticle(ParticleTypes.SMALL_FLAME, player.getX() + ((double) vec2A2.x), player.getY() + ((double) f3), player.getZ() + ((double) vec2A2.y), 0.0d, 0.0d, 0.0d);
        }
        if (cVar == c.NONE && (dVar.s || aVar != a.NONE)) {
            cVar = c.FULL;
        }
        return cVar;
    }

    private Vec2 a(Player player, float f, boolean z) {
        float degrees = player.yBodyRot - ((float) Math.toDegrees(f));
        float f2 = z ? 0.1f : 0.25f;
        return new Vec2(Mth.sin(((-degrees) * 0.017453292f) - 3.1415927f) * f2, Mth.cos(((-degrees) * 0.017453292f) - 3.1415927f) * f2);
    }

    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean z) {
        if (!(entity instanceof Player)) {
            return;
        }
        Player player = (Player) entity;
        if (i == 38) {
            a(itemStack, level, player);
        }
    }

    public static boolean k(ItemStack itemStack) {
        return ((Boolean) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.JETPACK_ENABLED.get(), false)).booleanValue();
    }

    public static void a(ItemStack itemStack, boolean z) {
        itemStack.set((DataComponentType) MCTechDataComponent.JETPACK_ENABLED.get(), Boolean.valueOf(z));
    }

    public static byte l(ItemStack itemStack) {
        return ((Byte) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.JETPACK_TICKER.get(), (byte) 0)).byteValue();
    }

    public static void a(ItemStack itemStack, byte b2) {
        itemStack.set((DataComponentType) MCTechDataComponent.JETPACK_TICKER.get(), Byte.valueOf(b2));
    }

    public static byte m(ItemStack itemStack) {
        return ((Byte) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.JETPACK_TIMER.get(), (byte) 0)).byteValue();
    }

    public static void b(ItemStack itemStack, byte b2) {
        itemStack.set((DataComponentType) MCTechDataComponent.JETPACK_TIMER.get(), Byte.valueOf(b2));
    }

    public static c n(ItemStack itemStack) {
        return c.a(((Byte) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.JETPACK_USE_MODE.get(), (byte) 0)).byteValue());
    }

    public static void a(ItemStack itemStack, c cVar) {
        itemStack.set((DataComponentType) MCTechDataComponent.JETPACK_USE_MODE.get(), Byte.valueOf(cVar.d));
    }

    public static a o(ItemStack itemStack) {
        return a.a(((Byte) itemStack.getOrDefault((DataComponentType) MCTechDataComponent.JETPACK_HOVER_MODE.get(), (byte) 0)).byteValue());
    }

    public static void c(ItemStack itemStack, a aVar) {
        itemStack.set((DataComponentType) MCTechDataComponent.JETPACK_HOVER_MODE.get(), Byte.valueOf(aVar.d));
    }

    public void a(ItemStack itemStack, Level level, Player player) {
        boolean zK = k(itemStack);
        byte bL = l(itemStack);
        byte bM = m(itemStack);
        mctech.s.d dVarA = mctech.s.d.a(player);
        Entity rootVehicle = player.getRootVehicle();
        if (!zK) {
            if (bL > 0) {
                a(itemStack, (byte) (bL - 1));
                return;
            } else {
                if (dVarA.n && !dVarA.u) {
                    a(itemStack, (byte) 10);
                    a(itemStack, true);
                    return;
                }
                return;
            }
        }
        if (j(itemStack) && dVarA.n && !dVarA.u && bL <= 0) {
            a(itemStack, (byte) 10);
            a(itemStack, false);
            a(itemStack, c.NONE);
            return;
        }
        if (bL > 0) {
            a(itemStack, (byte) (bL - 1));
        }
        a aVarO = o(itemStack);
        c cVarA = c.NONE;
        if (dVarA.s && dVarA.o && !dVarA.l && bM <= 0) {
            bM = 10;
            aVarO = aVarO.a(d(itemStack), e(itemStack));
            c(itemStack, aVarO);
        }
        if (dVarA.s || (aVarO != a.NONE && ((aVarO == a.ADV && !rootVehicle.onGround()) || (aVarO == a.BASIC && !rootVehicle.onGround() && rootVehicle.getDeltaMovement().y < -0.15d)))) {
            cVarA = a(itemStack, player, dVarA, aVarO, rootVehicle);
        }
        if (bM > 0) {
            b(itemStack, (byte) (bM - 1));
        }
        a(itemStack, cVarA);
    }

    public boolean isDamaged(ItemStack itemStack) {
        return true;
    }

    public int getBarWidth(ItemStack itemStack) {
        return (int) Math.round((((double) b(itemStack)) / ((double) a(itemStack))) * 13.0d);
    }

    public int getBarColor(ItemStack itemStack) {
        if (f(itemStack)) {
            return MCTechElectricItem.getRGBDurability(itemStack);
        }
        return super.getBarColor(itemStack);
    }

    public boolean isBarVisible(ItemStack itemStack) {
        return true;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/h$a.class */
    public enum a implements mctech.utils.a.b.InterfaceC0041b {
        NONE(0),
        BASIC(1),
        ADV(2);

        byte d;
        static final a[] e = (a[]) mctech.utils.a.b.a((mctech.utils.a.b.InterfaceC0041b[]) values());

        a(int i) {
            this.d = (byte) i;
        }

        @Override // mctech.utils.a.b.InterfaceC0041b
        public int a() {
            return this.d;
        }

        public static a a(int i) {
            return e[i % e.length];
        }

        public a a(boolean z, boolean z2) {
            if (this == NONE) {
                if (z2) {
                    return ADV;
                }
                if (z) {
                    return BASIC;
                }
            }
            return NONE;
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/g/b/h$c.class */
    public enum c implements mctech.utils.a.b.InterfaceC0041b {
        FULL(0),
        DROPPED(1),
        NONE(2);

        byte d;
        static final c[] e = (c[]) mctech.utils.a.b.a((mctech.utils.a.b.InterfaceC0041b[]) values());

        c(int i) {
            this.d = (byte) i;
        }

        @Override // mctech.utils.a.b.InterfaceC0041b
        public int a() {
            return this.d;
        }

        public static c a(int i) {
            return e[i % e.length];
        }
    }
}
