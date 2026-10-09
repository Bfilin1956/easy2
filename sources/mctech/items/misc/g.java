package mctech.items.misc;

import java.util.List;
import javax.annotation.Nullable;
import mctech.api.items.IAutoEatable;
import mctech.init.MCTechItems;
import mctech.items.base.i;
import mctech.items.base.o;
import mctech.utils.c.h;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/g.class */
public class g extends i implements IAutoEatable {
    public static final mctech.m.c.g a = new a();
    private final int b;
    private final float c;
    private final int d;
    private final boolean e;

    public g() {
        super(new o());
        this.b = 2;
        this.c = 0.95f;
        this.d = 20;
        this.e = false;
    }

    protected String getOrCreateDescriptionId() {
        return "item.mctech.filled_tin_can";
    }

    @Override // mctech.api.items.IAutoEatable
    public int getFoodValue(ItemStack itemStack) {
        return this.b;
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (player.canEat(this.e)) {
            player.startUsingItem(interactionHand);
            return new InteractionResultHolder<>(InteractionResult.SUCCESS, itemInHand);
        }
        return new InteractionResultHolder<>(InteractionResult.FAIL, itemInHand);
    }

    public ItemStack finishUsingItem(ItemStack itemStack, Level level, LivingEntity livingEntity) {
        if (livingEntity instanceof Player) {
            Player player = (Player) livingEntity;
            if (!level.isClientSide()) {
                h.a(player, onEaten(itemStack, level, player));
                itemStack.shrink(1);
            }
        }
        return itemStack;
    }

    public UseAnim getUseAnimation(ItemStack itemStack) {
        return UseAnim.EAT;
    }

    public int a(ItemStack itemStack) {
        return this.d;
    }

    public float a() {
        return this.c;
    }

    public int b() {
        return this.b;
    }

    @Override // mctech.api.items.IAutoEatable
    public boolean canAutoEat(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.api.items.IAutoEatable
    public ItemStack onEaten(ItemStack itemStack, Level level, Player player) {
        player.heal(2.0f);
        player.getFoodData().eat(this.b, this.c);
        level.playSound(player, player.getX(), player.getY(), player.getZ(), SoundEvents.PLAYER_BURP, SoundSource.PLAYERS, 0.5f, (level.random.nextFloat() * 0.1f) + 0.9f);
        player.awardStat(Stats.ITEM_USED.get(this));
        return new ItemStack((ItemLike) MCTechItems.TIN_CAN.get());
    }

    @OnlyIn(Dist.CLIENT)
    public void a(ItemStack itemStack, @Nullable Level level, List<Component> list, TooltipFlag tooltipFlag) {
        list.add(f("tooltip.item.mctech.filled_tin_can"));
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/g$a.class */
    public static class a implements mctech.m.c.g {
        @Override // mctech.m.c.g
        public boolean matches(ItemStack itemStack) {
            return itemStack.getItem() instanceof g;
        }
    }
}
