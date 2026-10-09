package mctech.api.reactor.planner;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/planner/FloatTracker.class */
public class FloatTracker {
    private float total = 0.0f;
    private int count = 0;
    private float change = 0.0f;

    public void addChange(float f) {
        this.change += f;
    }

    public void commit() {
        this.total += this.change;
        this.change = 0.0f;
        this.count++;
    }

    public void reset() {
        this.total = 0.0f;
        this.count = 0;
        this.change = 0.0f;
    }

    public float getAverage() {
        if (this.count == 0) {
            return 0.0f;
        }
        return this.total / this.count;
    }
}
