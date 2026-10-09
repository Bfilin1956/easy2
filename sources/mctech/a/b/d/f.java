package mctech.a.b.d;

import java.util.List;
import mctech.blockentities.c.C0077x;
import mctech.blocks.c.p;
import mctech.init.MCTechBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.attachment.IAttachmentHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/d/f.class */
public class f extends mctech.a.b.b.b<C0077x, d, g> {
    public f(IAttachmentHolder iAttachmentHolder) {
        super(iAttachmentHolder);
    }

    @Override // mctech.a.b.b.b
    public ItemLike a() {
        return MCTechBlocks.INDUSTRIAL_FORGE;
    }

    @Override // mctech.a.b.b.b
    public Component b() {
        return Component.translatable(((p) MCTechBlocks.INDUSTRIAL_FORGE.get()).getDescriptionId());
    }

    @Override // mctech.a.b.b.b
    public List<Component> c() {
        return List.of();
    }
}
