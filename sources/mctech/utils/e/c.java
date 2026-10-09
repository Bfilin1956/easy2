package mctech.utils.e;

import java.util.function.Consumer;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSink;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/c.class */
@OnlyIn(Dist.CLIENT)
public class c {
    public static String a(Component component) {
        a aVar = new a();
        component.getVisualOrderText().accept(aVar);
        return aVar.a().toString();
    }

    public static void a(Component component, Consumer<Component> consumer) {
        for (String str : a(component).split("\n")) {
            consumer.accept(Component.literal(str));
        }
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/utils/e/c$a.class */
    @OnlyIn(Dist.CLIENT)
    public static class a implements FormattedCharSink {
        StringBuilder a = new StringBuilder();
        ChatFormatting b = ChatFormatting.RESET;

        public boolean accept(int i, Style style, int i2) {
            ChatFormatting chatFormattingA = a(style);
            if (chatFormattingA != this.b) {
                this.b = chatFormattingA;
                this.a.append(chatFormattingA.toString());
            }
            this.a.append((char) i2);
            return true;
        }

        protected ChatFormatting a(Style style) {
            ChatFormatting byName = style.getColor() == null ? null : ChatFormatting.getByName(style.getColor().serialize());
            return byName == null ? ChatFormatting.RESET : byName;
        }

        public StringBuilder a() {
            return this.a;
        }
    }
}
