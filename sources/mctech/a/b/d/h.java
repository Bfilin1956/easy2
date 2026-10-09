package mctech.a.b.d;

import java.util.List;
import mctech.blockentities.c.M;
import mctech.blocks.c.C;
import mctech.init.MCTechBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.attachment.IAttachmentHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/d/h.class */
public class h extends mctech.a.b.b.b<M, j, i> {
    public h(IAttachmentHolder iAttachmentHolder) {
        super(iAttachmentHolder);
    }

    @Override // mctech.a.b.b.b
    public ItemLike a() {
        return MCTechBlocks.QUANTUM_WORKBENCH;
    }

    @Override // mctech.a.b.b.b
    public Component b() {
        return Component.translatable(((C) MCTechBlocks.QUANTUM_WORKBENCH.get()).getDescriptionId());
    }

    @Override // mctech.a.b.b.b
    public List<Component> c() {
        return List.of();
    }
}
