package mctech.blocks.e;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import mctech.MCTech;
import mctech.init.MCTechItems;
import mctech.v.r;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/a.class */
public class a extends mctech.blocks.base.d implements mctech.v.c.a.a {
    private final String d;
    private final IntProvider e;
    private final EnumC0004a f;

    public a(String str, float f, float f2, boolean z, IntProvider intProvider, EnumC0004a enumC0004a) {
        super(BlockBehaviour.Properties.of().sound(SoundType.STONE).mapColor(z ? MapColor.DEEPSLATE : MapColor.STONE).strength(f, f2).requiresCorrectToolForDrops());
        this.d = str;
        this.e = intProvider;
        this.f = enumC0004a;
    }

    @Override // mctech.blocks.base.d
    public ItemStack a(BlockState blockState, ItemStack itemStack, RandomSource randomSource, @Nullable BlockEntity blockEntity) {
        HolderLookup.RegistryLookup registryLookupLookupOrThrow = blockEntity.getLevel().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
        return EnchantmentHelper.getTagEnchantmentLevel(registryLookupLookupOrThrow.getOrThrow(Enchantments.SILK_TOUCH), itemStack) > 0 ? new ItemStack(this) : new ItemStack(this.f.a(), a(randomSource, EnchantmentHelper.getTagEnchantmentLevel(registryLookupLookupOrThrow.getOrThrow(Enchantments.FORTUNE), itemStack)));
    }

    private int a(RandomSource randomSource, int i) {
        return this.e.sample(randomSource) * (Math.max(0, randomSource.nextInt(i + 2) - 1) + 1);
    }

    @Override // mctech.blocks.base.a
    public mctech.items.base.g createItem() {
        return new mctech.items.base.g(this, new Item.Properties());
    }

    @Override // mctech.v.c.a.a
    public List<BlockState> a() {
        return Collections.singletonList(defaultBlockState());
    }

    @Override // mctech.v.c.a.a
    @OnlyIn(Dist.CLIENT)
    public TextureAtlasSprite a(BlockState blockState, Direction direction) {
        return r.c(MCTech.MODID, "resources/ore").get(this.d);
    }

    /* JADX INFO: renamed from: mctech.blocks.e.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/e/a$a.class */
    public enum EnumC0004a {
        RUBIDIUM_ORE,
        TITANIUM_ORE;

        /* JADX INFO: Thrown type has an unknown type hierarchy: java.lang.MatchException */
        public Item a() throws MatchException {
            switch (this) {
                case RUBIDIUM_ORE:
                    return MCTechItems.RAW_RUBIDIUM.asItem();
                case TITANIUM_ORE:
                    return MCTechItems.RAW_TITANIUM.asItem();
                default:
                    throw new MatchException((String) null, (Throwable) null);
            }
        }
    }
}
