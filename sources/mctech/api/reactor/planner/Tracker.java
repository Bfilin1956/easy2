package mctech.api.reactor.planner;

import net.minecraft.nbt.CompoundTag;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/reactor/planner/Tracker.class */
public class Tracker {
    private int total = 0;
    private int count = 0;
    private int change = 0;

    public CompoundTag save(CompoundTag compoundTag) {
        compoundTag.putInt("total", this.total);
        compoundTag.putInt("count", this.count);
        compoundTag.putInt("change", this.change);
        return compoundTag;
    }

    public void load(CompoundTag compoundTag) {
        this.total = compoundTag.getInt("total");
        this.count = compoundTag.getInt("count");
        this.change = compoundTag.getInt("change");
    }

    public void addChange(int i) {
        this.change += i;
    }

    public void commit() {
        this.total += this.change;
        this.change = 0;
        this.count++;
    }

    public void reset() {
        this.total = 0;
        this.count = 0;
        this.change = 0;
    }

    public float getAverage() {
        if (this.count == 0) {
            return 0.0f;
        }
        return this.total / this.count;
    }

    public int getCount() {
        return this.count;
    }

    public int getTotal() {
        return this.total;
    }
}
