package mctech.init;

import mctech.MCTech;
import mctech.a.b.d.a;
import mctech.a.b.d.f;
import mctech.a.b.d.h;
import mctech.i.i;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/init/MCTechAttachments.class */
public class MCTechAttachments {
    private static final DeferredRegister<AttachmentType<?>> ATTACHMENTS = DeferredRegister.create(NeoForgeRegistries.ATTACHMENT_TYPES, MCTech.MODID);
    static final DeferredHolder<AttachmentType<?>, AttachmentType<a>> ATTACHMENT_ASSEMBLY_STATION = ATTACHMENTS.register("assembly_station", () -> {
        return AttachmentType.builder(a::new).build();
    });
    static final DeferredHolder<AttachmentType<?>, AttachmentType<f>> ATTACHMENT_INDUSTRIAL_FORGE = ATTACHMENTS.register("industrial_forge", () -> {
        return AttachmentType.builder(f::new).build();
    });
    static final DeferredHolder<AttachmentType<?>, AttachmentType<h>> ATTACHMENT_QUANTUM_WORKBENCH = ATTACHMENTS.register(i.QUANTUM_WORKBENCH.getSerializedName(), () -> {
        return AttachmentType.builder(h::new).build();
    });

    public static void register(IEventBus iEventBus) {
        ATTACHMENTS.register(iEventBus);
    }
}
