package mctech.g.d.e;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.contents.TranslatableContents;
import net.minecraft.resources.ResourceLocation;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/g/d/e/h.class */
public class h {
    private static final Pattern a = Pattern.compile("^([^:]+: )(.*)$");

    public static MutableComponent a(MutableComponent mutableComponent, Object... objArr) {
        MutableComponent mutableComponentPlainCopy;
        TranslatableContents contents = mutableComponent.getContents();
        if (contents instanceof TranslatableContents) {
            mutableComponentPlainCopy = Component.translatable(contents.getKey(), objArr).copy().plainCopy();
        } else {
            mutableComponentPlainCopy = mutableComponent.plainCopy();
        }
        Matcher matcher = a.matcher(mutableComponentPlainCopy.getString());
        if (matcher.matches()) {
            return a(mutableComponentPlainCopy, matcher.group(1), matcher.group(2));
        }
        return mutableComponentPlainCopy;
    }

    private static MutableComponent a(MutableComponent mutableComponent, String str, String str2) {
        MutableComponent mutableComponentEmpty = Component.empty();
        int i = 0;
        ArrayList<Component> arrayList = new ArrayList();
        arrayList.add(mutableComponent);
        arrayList.addAll(mutableComponent.getSiblings());
        for (Component component : arrayList) {
            String string = component.getString();
            if (!string.isEmpty()) {
                int length = string.length();
                int length2 = str.length();
                int i2 = i;
                if (i + length <= length2) {
                    mutableComponentEmpty.append(a(component, ChatFormatting.GRAY));
                } else if (i2 >= length2) {
                    mutableComponentEmpty.append(a(component, ChatFormatting.GOLD));
                } else {
                    int i3 = length2 - i2;
                    MutableComponent mutableComponentWithStyle = Component.literal(string.substring(0, i3)).withStyle(ChatFormatting.GRAY).withStyle(component.getStyle());
                    MutableComponent mutableComponentWithStyle2 = Component.literal(string.substring(i3)).withStyle(ChatFormatting.GOLD).withStyle(component.getStyle());
                    mutableComponentEmpty.append(mutableComponentWithStyle);
                    mutableComponentEmpty.append(mutableComponentWithStyle2);
                }
                i += length;
            }
        }
        for (Component component2 : mutableComponent.getSiblings()) {
            if (!arrayList.contains(component2)) {
                mutableComponentEmpty.append(component2);
            }
        }
        return mutableComponentEmpty;
    }

    private static MutableComponent a(Component component, ChatFormatting chatFormatting) {
        MutableComponent mutableComponentLiteral;
        if (component instanceof MutableComponent) {
            mutableComponentLiteral = component.plainCopy();
        } else {
            mutableComponentLiteral = Component.literal(component.getString());
        }
        mutableComponentLiteral.withStyle(component.getStyle().withColor(chatFormatting));
        return mutableComponentLiteral;
    }

    public static Component a(MutableComponent mutableComponent) {
        return mutableComponent.withStyle(ChatFormatting.GRAY);
    }

    public static Component b(MutableComponent mutableComponent, Object... objArr) {
        return a(a(mutableComponent, objArr));
    }

    public static Component a(ResourceLocation resourceLocation, Object... objArr) {
        return a(Component.translatable(resourceLocation.toLanguageKey(), objArr));
    }
}
