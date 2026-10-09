package mctech.blockentities;

import javax.annotation.Nonnull;
import mctech.api.tiles.IMachine;
import mctech.api.tiles.readers.IProgressMachine;
import net.minecraft.core.Direction;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/blockentities/s.class */
public interface s extends IMachine, IProgressMachine, mctech.blocks.c.o {
    boolean isAutoExport();

    boolean isAutoSort();

    @Nonnull
    Direction getFrontDirection();
}
