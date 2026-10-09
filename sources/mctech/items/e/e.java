package mctech.items.e;

import java.text.DecimalFormat;
import java.util.Objects;
import mctech.MCTech;
import mctech.api.items.armor.IArmorModule;
import mctech.api.items.readers.IEUReader;
import mctech.api.network.buffer.INetworkDataBuffer;
import mctech.api.network.item.INetworkItemBufferEvent;
import mctech.init.MCTechDataComponent;
import mctech.m.b.C0164x;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/e.class */
public class e extends mctech.items.base.i implements IEUReader, INetworkItemBufferEvent<mctech.q.a.a.b>, mctech.items.g.b.c, mctech.m.a.e {
    public static final DecimalFormat a = new DecimalFormat("###,###.##");

    public e() {
        super(new Item.Properties());
    }

    @Override // mctech.api.items.readers.IEUReader
    public boolean isEUReader(ItemStack itemStack) {
        return true;
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        dVar.a(c("tooltip.item.mctech.eu_reader.active_mode", a.a(((Integer) itemStack.getOrDefault(MCTechDataComponent.MODE, 0)).intValue()).b()).withStyle(ChatFormatting.GRAY));
        dVar.b(a(mctech.s.a.MODE_KEY, "tooltip.item.mctech.eu_reader.switch_mode", new Object[0]));
        dVar.b(a(mctech.s.a.BLOCK_CLICK, "tooltip.item.mctech.eu_reader.scan", new Object[0]));
        Objects.requireNonNull(dVar);
        Objects.requireNonNull(dVar);
        handleToolTip(itemStack, dVar::a);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        ItemStack itemInHand = player.getItemInHand(interactionHand);
        if (MCTech.PLATFORM.g() && MCTech.KEYBOARD.d(player)) {
            a aVarA = a.a(((Integer) itemInHand.getOrDefault(MCTechDataComponent.MODE, 0)).intValue() + 1);
            itemInHand.set(MCTechDataComponent.MODE, Integer.valueOf(aVarA.a()));
            player.displayClientMessage(c("tooltip.item.mctech.eu_reader.active_mode", aVarA.b()), false);
        }
        return InteractionResultHolder.success(itemInHand);
    }

    public InteractionResult onItemUseFirst(ItemStack itemStack, UseOnContext useOnContext) {
        return InteractionResult.PASS;
    }

    public void inventoryTick(ItemStack itemStack, Level level, Entity entity, int i, boolean z) {
    }

    @Override // mctech.m.a.e
    public mctech.m.a.i a(Player player, InteractionHand interactionHand, ItemStack itemStack) {
        return new mctech.m.f.b(player, this, itemStack, null).a(itemStack);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // mctech.api.network.item.INetworkItemBufferEvent
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onDataBufferReceived(ItemStack itemStack, Player player, String str, mctech.q.a.a.b bVar, Dist dist) {
        if ((player.containerMenu instanceof C0164x) && str.equals("EU_INFO")) {
            ((mctech.m.f.b) ((C0164x) player.containerMenu).getHolder()).a(bVar);
        }
    }

    @Override // mctech.api.items.armor.IArmorModule
    public IArmorModule.ModuleType getType(ItemStack itemStack) {
        return IArmorModule.ModuleType.HUD;
    }

    @Override // mctech.items.g.b.c, mctech.api.items.armor.IArmorModule
    public boolean canInstallInArmor(ItemStack itemStack, ItemStack itemStack2, EquipmentSlot equipmentSlot) {
        return equipmentSlot == EquipmentSlot.HEAD;
    }

    @Override // mctech.items.g.b.c, mctech.api.items.armor.IArmorModule
    public void onInstall(ItemStack itemStack, ItemStack itemStack2, IArmorModule.IArmorModuleHolder iArmorModuleHolder) {
        iArmorModuleHolder.addAddModifier(itemStack2, IArmorModule.ArmorMod.EU_READER, 1);
    }

    @Override // mctech.items.g.b.c, mctech.api.items.armor.IArmorModule
    public void onUninstall(ItemStack itemStack, ItemStack itemStack2, IArmorModule.IArmorModuleHolder iArmorModuleHolder) {
        iArmorModuleHolder.removeAddModifier(itemStack2, IArmorModule.ArmorMod.EU_READER, 1);
    }

    @Override // mctech.api.items.armor.IArmorModule
    public boolean handlePacket(Player player, ItemStack itemStack, ItemStack itemStack2, String str, INetworkDataBuffer iNetworkDataBuffer, Dist dist) {
        return false;
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/e/e$a.class */
    public enum a implements mctech.utils.a.b.InterfaceC0041b {
        POWER_FLOW(0, "power_flow"),
        POWER_STATS(1, "power_stats"),
        REAL_TIME_STAT(2, "real_time_stats");

        public static final a[] d = (a[]) mctech.utils.a.b.a((mctech.utils.a.b.InterfaceC0041b[]) values());
        int e;
        String f;

        a(int i, String str) {
            this.e = i;
            this.f = str;
        }

        @Override // mctech.utils.a.b.InterfaceC0041b
        public int a() {
            return this.e;
        }

        public Component b() {
            return Component.translatable("tooltip.item.mctech.eu_reader." + this.f);
        }

        public static a a(int i) {
            return d[i % d.length];
        }
    }
}
