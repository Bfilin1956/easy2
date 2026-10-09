package mctech.a.b.b;

import appeng.api.crafting.IPatternDetails;
import appeng.api.crafting.PatternDetailsTooltip;
import appeng.api.stacks.AEItemKey;
import appeng.api.stacks.AEKey;
import appeng.api.stacks.GenericStack;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import mctech.a.b.b.a;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/b/c.class */
public class c<Pattern extends mctech.a.b.b.a> implements IPatternDetails {
    private final DataComponentType<Pattern> d;
    private final Pattern e;
    private final AEItemKey f;
    public final List<GenericStack> a;
    public final List<GenericStack> b;
    public final List<GenericStack> c;
    private final a<Pattern>[] g;

    public c(AEItemKey aEItemKey, DataComponentType<Pattern> dataComponentType, Level level) {
        this.d = dataComponentType;
        this.f = aEItemKey;
        this.e = (Pattern) aEItemKey.get(dataComponentType);
        if (this.e == null) {
            throw new IllegalArgumentException("Given item does not encode a assembly station pattern: " + String.valueOf(aEItemKey));
        }
        if (this.e.f()) {
            throw new IllegalArgumentException("Pattern references missing content");
        }
        this.a = new ArrayList();
        this.a.addAll(this.e.a().stream().map((v0) -> {
            return v0.a();
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList());
        this.a.addAll(this.e.c().stream().map((v0) -> {
            return v0.a();
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList());
        this.c = this.e.b().stream().map((v0) -> {
            return v0.a();
        }).filter((v0) -> {
            return Objects.nonNull(v0);
        }).toList();
        this.b = List.of(mctech.a.b.b.a.a(this.e.d()));
        this.g = (a[]) this.a.stream().map(genericStack -> {
            return new a(this.e, genericStack);
        }).toList().toArray(new a[0]);
    }

    public DataComponentType<Pattern> a() {
        return this.d;
    }

    public AEItemKey getDefinition() {
        return this.f;
    }

    public IPatternDetails.IInput[] getInputs() {
        return this.g;
    }

    public List<GenericStack> getOutputs() {
        return this.b;
    }

    public boolean supportsPushInputsToExternalInventory() {
        return false;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == getClass() && ((c) obj).f.equals(this.f);
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/a/b/b/c$a.class */
    private static class a<Pattern extends mctech.a.b.b.a> implements IPatternDetails.IInput {
        private final GenericStack[] a;
        private final long b;

        private a(Pattern pattern, GenericStack genericStack) {
            this.a = new GenericStack[]{new GenericStack(genericStack.what(), 1L)};
            this.b = genericStack.amount();
        }

        public GenericStack[] getPossibleInputs() {
            return this.a;
        }

        public long getMultiplier() {
            return this.b;
        }

        public boolean isValid(AEKey aEKey, Level level) {
            return aEKey.matches(this.a[0]);
        }

        @Nullable
        public AEKey getRemainingKey(AEKey aEKey) {
            return null;
        }
    }

    public static PatternDetailsTooltip a(ItemStack itemStack, Level level, @Nullable Exception exc, TooltipFlag tooltipFlag) {
        return new PatternDetailsTooltip(PatternDetailsTooltip.OUTPUT_TEXT_CRAFTS);
    }
}
