package mctech.api.tiles.readers;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/readers/IProgressMachine.class */
public interface IProgressMachine {
    float getProgress();

    float getMaxProgress();

    default int getSlots() {
        return 1;
    }

    default float getProgressSlot(int i) {
        return getProgress();
    }

    default float getMaxProgressSlot(int i) {
        return getMaxProgress();
    }
}
