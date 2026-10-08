package net.mcskill.shop.client.screen.component;

import gg.essential.elementa.UIComponent;
import gg.essential.elementa.components.UIRoundedRectangle;
import gg.essential.elementa.dsl.ComponentsKt;
import gg.essential.elementa.effects.ShadowEffect;
import gg.essential.elementa.state.BasicState;
import gg.essential.elementa.state.State;
import gg.essential.elementa.state.StateKt;
import gg.essential.elementa.utils.ExtensionsKt;
import java.awt.Color;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import net.mcskill.core.client.screen.MSPalette;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: MSShop-1.21.1-2.1.4-neoforge-client.jar:net/mcskill/shop/client/screen/component/BaseButton.class */
@Metadata(mv = {2, 0, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B\u001d\b\u0004\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0001\u0003\f\r\u000e¨\u0006\u000f"}, d2 = {"Lnet/mcskill/shop/client/screen/component/BaseButton;", "Lgg/essential/elementa/components/UIRoundedRectangle;", "radius", "", "shadow", "", "<init>", "(FZ)V", "invisibleColor", "Ljava/awt/Color;", "shadowEffect", "Lgg/essential/elementa/effects/ShadowEffect;", "Lnet/mcskill/shop/client/screen/component/IconButton;", "Lnet/mcskill/shop/client/screen/component/ItemButton;", "Lnet/mcskill/shop/client/screen/component/LabelButton;", "MSShop"})
public abstract class BaseButton extends UIRoundedRectangle {

    @NotNull
    private final Color invisibleColor;

    @NotNull
    private final ShadowEffect shadowEffect;

    public /* synthetic */ BaseButton(float radius, boolean shadow, DefaultConstructorMarker $constructor_marker) {
        this(radius, shadow);
    }

    public /* synthetic */ BaseButton(float f, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 4.0f : f, (i & 2) != 0 ? true : z, null);
    }

    private BaseButton(float radius, boolean shadow) {
        super(radius, false, 2, (DefaultConstructorMarker) null);
        this.invisibleColor = ExtensionsKt.invisible((Color) MSPalette.INSTANCE.getBackground().get());
        this.shadowEffect = new ShadowEffect(0.0f, 0.0f, 0.0f, 0.0f, (ShadowEffect.TextureRegion) null, new BasicState(this.invisibleColor), 31, (DefaultConstructorMarker) null);
        if (!shadow) {
            return;
        }
        State hover = StateKt.hoveredState$default((UIComponent) this, false, false, 3, (Object) null);
        this.shadowEffect.setColor(this.invisibleColor);
        this.shadowEffect.setColorState(hover.map((v1) -> {
            return _init_$lambda$0(r2, v1);
        }));
        ComponentsKt.effect((UIComponent) this, this.shadowEffect);
    }

    private static final Color _init_$lambda$0(BaseButton this$0, boolean it) {
        return (it && this$0.isEnabled()) ? this$0.getColor() : this$0.invisibleColor;
    }
}
