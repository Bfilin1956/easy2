package mctech.y;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.world.level.block.state.BlockState;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/y/e.class */
public class e {
    private int a;
    private final List<a> b;
    private final Map<BlockState, Optional<a>> c;
    private boolean d;

    public e() {
        this.a = 32;
        this.c = new ConcurrentHashMap();
        this.a = 0;
        this.d = false;
        this.b = new ArrayList();
    }

    public e(int i, List<a> list, boolean z) {
        this.a = 32;
        this.c = new ConcurrentHashMap();
        this.a = i;
        this.d = z;
        this.b = List.copyOf(list);
    }

    public int a() {
        return this.a;
    }

    public void a(int i) {
        this.a = Math.max(1, Math.min(64, i));
    }

    public boolean b() {
        return this.d;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean a(BlockState blockState) {
        if (this.d) {
            return this.b.stream().anyMatch(aVar -> {
                return aVar.a(blockState);
            });
        }
        return false;
    }

    public Optional<a> b(BlockState blockState) {
        return !this.d ? Optional.empty() : this.c.computeIfAbsent(blockState, blockState2 -> {
            return this.b.stream().filter(aVar -> {
                return aVar.a(blockState2);
            }).findFirst();
        });
    }
}
