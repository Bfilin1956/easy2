package mctech.blocks.c;

import java.util.function.Supplier;
import mctech.MCTech;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: renamed from: mctech.blocks.c.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blocks/c/a.class */
public class C0080a extends mctech.blocks.b implements o, mctech.utils.d.b {
    private final mctech.i.a c;
    private final Supplier<? extends BlockEntityType<?>> d;
    private final String e;

    public C0080a(String str, Supplier<? extends BlockEntityType<?>> supplier, @NotNull mctech.i.a aVar) {
        this.e = str;
        this.d = supplier;
        this.c = aVar;
        setDropProvider(aVar.d());
        addTooltip(mctech.utils.e.a.d.d);
        addTooltip(mctech.utils.e.a.d.d(16));
    }

    @Override // mctech.blocks.base.e
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return this.d.get().create(blockPos, blockState);
    }

    @Override // mctech.blocks.c.o
    @NotNull
    public mctech.i.a getAdvancedTier() {
        return this.c;
    }

    @Override // mctech.utils.d.b
    public ResourceLocation b() {
        return ResourceLocation.fromNamespaceAndPath(MCTech.MODID, this.e);
    }

    @Override // mctech.utils.d.b
    public void a(ResourceLocation resourceLocation) {
    }
}
