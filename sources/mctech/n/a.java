package mctech.n;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.MapCodec;
import java.util.Collections;
import java.util.List;
import mctech.init.MCTechLootTableFunctions;
import mctech.m.a.g;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;
import net.minecraft.world.level.storage.loot.functions.LootItemFunctionType;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/n/a.class */
public class a extends LootItemConditionalFunction {
    public static final a a = new a(Collections.emptyList());
    public static final MapCodec<a> b = MapCodec.unit(a);

    public a(List<LootItemCondition> list) {
        super(list);
    }

    @NotNull
    protected ItemStack run(ItemStack itemStack, @NotNull LootContext lootContext) {
        return itemStack;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public LootItemFunctionType<? extends LootItemConditionalFunction> getType() {
        return MCTechLootTableFunctions.DROP_INVENTORY.get();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/n/a$b.class */
    public enum b implements StringRepresentable {
        INVENTORY("inventory");

        private final String b;

        b(String str) {
            this.b = str;
        }

        public List<ItemStack> a(LootContext lootContext) {
            return a((BlockEntity) lootContext.getParamOrNull(LootContextParams.BLOCK_ENTITY));
        }

        public List<ItemStack> a(LootParams.Builder builder) {
            return a((BlockEntity) builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY));
        }

        public List<ItemStack> a(BlockEntity blockEntity) {
            if (blockEntity instanceof g) {
                return ((g) blockEntity).U_().toList();
            }
            return ImmutableList.of();
        }

        @NotNull
        public String getSerializedName() {
            return this.b;
        }
    }

    /* JADX INFO: renamed from: mctech.n.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/n/a$a.class */
    public static class C0030a extends LootItemConditionalFunction.Builder<C0030a> {
        /* JADX INFO: Access modifiers changed from: protected */
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0030a getThis() {
            return this;
        }

        @NotNull
        public LootItemFunction build() {
            return a.a;
        }
    }
}
