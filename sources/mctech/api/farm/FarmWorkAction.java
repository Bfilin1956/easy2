package mctech.api.farm;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/farm/FarmWorkAction.class */
public enum FarmWorkAction {
    IDLE(0, 0),
    SCAN(-16736001, 0),
    PLANT(-16719776, 20),
    FERTILIZE(-4177665, 16),
    HARVEST(-28624, 8);

    private final int color;
    private final int delayTicks;

    FarmWorkAction(int i, int i2) {
        this.color = i;
        this.delayTicks = i2;
    }

    public int color() {
        return this.color;
    }

    public int delayTicks() {
        return this.delayTicks;
    }

    public boolean shouldRenderHighlight() {
        return (this == IDLE || this == SCAN) ? false : true;
    }

    public static FarmWorkAction byId(int i) {
        FarmWorkAction[] farmWorkActionArrValues = values();
        if (i < 0 || i >= farmWorkActionArrValues.length) {
            return IDLE;
        }
        return farmWorkActionArrValues[i];
    }
}
