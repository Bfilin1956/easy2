package mctech.a.b.d;

import java.util.List;
import mctech.blockentities.c.C0057d;
import mctech.blocks.c.C0083d;
import mctech.init.MCTechBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.ItemLike;
import net.neoforged.neoforge.attachment.IAttachmentHolder;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/d/a.class */
public class a extends mctech.a.b.b.b<C0057d, c, b> {
    public a(IAttachmentHolder iAttachmentHolder) {
        super(iAttachmentHolder);
    }

    @Override // mctech.a.b.b.b
    public ItemLike a() {
        return MCTechBlocks.ASSEMBLY_STATION;
    }

    @Override // mctech.a.b.b.b
    public Component b() {
        return Component.translatable(((C0083d) MCTechBlocks.ASSEMBLY_STATION.get()).getDescriptionId());
    }

    @Override // mctech.a.b.b.b
    public List<Component> c() {
        return List.of();
    }
}
