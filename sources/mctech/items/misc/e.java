package mctech.items.misc;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import mctech.api.items.ITagBlock;
import mctech.items.base.i;
import mctech.utils.c.h;
import net.minecraft.core.HolderSet;
import net.minecraft.core.NonNullList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.block.Block;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/items/misc/e.class */
public class e extends i implements ITagBlock {
    public e() {
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
        return Component.translatable("item.mctech.tag_block", objArr);
    }

    public void a(CreativeModeTab creativeModeTab, NonNullList<ItemStack> nonNullList) {
    }

    public int a(ItemStack itemStack, LivingEntity livingEntity) {
        return 0;
    }

    @Override // mctech.api.items.ITagBlock
    public boolean matches(ItemStack itemStack, Block block) {
        ResourceLocation resourceLocationA = a(itemStack);
        return resourceLocationA != null && block.builtInRegistryHolder().is(BlockTags.create(resourceLocationA));
    }

    @Override // mctech.api.items.ITagBlock
    public List<Block> getBlocks(ItemStack itemStack) {
        ResourceLocation resourceLocationA = a(itemStack);
        if (resourceLocationA == null) {
            return Collections.emptyList();
        }
        HolderSet holderSet = (HolderSet) BuiltInRegistries.BLOCK.getTag(BlockTags.create(resourceLocationA)).orElse(null);
        return holderSet == null ? Collections.emptyList() : (List) holderSet.stream().map((v0) -> {
            return v0.value();
        }).collect(Collectors.toList());
    }

    public static void a(ItemStack itemStack, ResourceLocation resourceLocation) {
        h.a(itemStack).putString("tag", resourceLocation.toString());
    }

    public static ResourceLocation a(ItemStack itemStack) {
        return ResourceLocation.tryParse(h.a(itemStack).getString("tag"));
    }
}
