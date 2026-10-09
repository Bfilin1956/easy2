package mctech.items.misc;

import mctech.api.items.ITagItem;
import mctech.items.base.i;
import mctech.utils.c.h;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/f.class */
public class f extends i implements ITagItem {
    public f() {
        super(new Item.Properties());
    }

    @Override // mctech.items.base.i, mctech.utils.e.a
    @OnlyIn(Dist.CLIENT)
    public void addToolTip(ItemStack itemStack, Player player, TooltipFlag tooltipFlag, mctech.utils.e.d dVar) {
        super.addToolTip(itemStack, player, tooltipFlag, dVar);
        ResourceLocation resourceLocationA = a(itemStack);
        Object[] objArr = new Object[1];
        objArr[0] = resourceLocationA == null ? "minecraft:empty" : resourceLocationA.toString();
        dVar.a("tooltip.item.mctech.full_tag", objArr);
    }

    public Component getName(ItemStack itemStack) {
        ResourceLocation resourceLocationA = a(itemStack);
        Object[] objArr = new Object[1];
        objArr[0] = resourceLocationA == null ? e("empty") : e(resourceLocationA.getPath());
        return Component.translatable("item.mctech.tag_item", objArr);
    }

    public void a(CreativeModeTab creativeModeTab, NonNullList<ItemStack> nonNullList) {
    }

    public int a(ItemStack itemStack, LivingEntity livingEntity) {
        return 0;
    }

    @Override // mctech.api.items.ITagItem
    public boolean matches(ItemStack itemStack, ItemStack itemStack2) {
        ResourceLocation resourceLocationA = a(itemStack);
        return resourceLocationA != null && itemStack2.is(ItemTags.create(resourceLocationA));
    }

    public static void a(ItemStack itemStack, ResourceLocation resourceLocation) {
        h.a(itemStack).putString("tag", resourceLocation.toString());
    }

    public static ResourceLocation a(ItemStack itemStack) {
        return ResourceLocation.tryParse(h.a(itemStack).getString("tag"));
    }
}
