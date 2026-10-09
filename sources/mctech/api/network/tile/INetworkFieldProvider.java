package mctech.api.network.tile;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import mctech.MCTech;
import mctech.api.network.buffer.GuiField;
import mctech.api.network.buffer.NetworkInfo;
import mctech.q.b;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/network/tile/INetworkFieldProvider.class */
public interface INetworkFieldProvider {
    boolean isDefaultData(String str);

    default List<String> getNetworkFields() {
        return b.a(getClass());
    }

    default boolean hasNetworkField(@Nonnull String str) {
        return getNetworkFields().contains(str);
    }

    default void addNetworkField(@Nonnull String str) {
        List<String> networkFields = getNetworkFields();
        if (networkFields.contains(str)) {
            MCTech.LOGGER.debug("@NetworkInfo of '{}' already registered in {}, skipping", str, getClass().getSimpleName());
        } else {
            networkFields.add(str);
        }
    }

    default void addNetworkFields(String... strArr) {
        for (String str : strArr) {
            if (str != null && !str.isEmpty()) {
                addNetworkField(str);
            }
        }
    }

    default <Provider extends INetworkFieldProvider> void addNetworkFields(@Nonnull Provider provider) {
        addNetworkFields((String[]) Stream.iterate(provider.getClass(), cls -> {
            return cls != null && BlockEntity.class.isAssignableFrom(cls);
        }, (v0) -> {
            return v0.getSuperclass();
        }).flatMap(cls2 -> {
            return Arrays.stream(cls2.getDeclaredFields());
        }).filter(field -> {
            return field.isAnnotationPresent(NetworkInfo.class);
        }).map(field2 -> {
            return ((NetworkInfo) field2.getAnnotation(NetworkInfo.class)).fieldName();
        }).filter(str -> {
            return !hasNetworkField(str);
        }).distinct().toList().toArray(new String[0]));
    }

    default <Provider extends BlockEntity & INetworkFieldProvider> void updateNetworkField(@Nonnull Provider provider, @Nonnull String str) {
        MCTech.NETWORKING.updateTileField(provider, str);
    }

    default <Provider extends BlockEntity & INetworkFieldProvider> void updateNetworkFields(@Nonnull Provider provider) {
        getNetworkFields().forEach(str -> {
            updateNetworkField(provider, str);
        });
    }

    default List<String> getGuiFields() {
        return b.b(getClass());
    }

    default boolean hasGuiField(@Nonnull String str) {
        return getGuiFields().contains(str);
    }

    default void addGuiField(@Nonnull String str) {
        List<String> guiFields = getGuiFields();
        if (guiFields.contains(str)) {
            return;
        }
        guiFields.add(str);
    }

    default void addGuiFields(String... strArr) {
        for (String str : strArr) {
            if (str != null && !str.isEmpty()) {
                addGuiField(str);
            }
        }
    }

    default <Provider extends INetworkFieldProvider> void addGuiFields(@Nonnull Provider provider) {
        addGuiFields((String[]) Stream.iterate(provider.getClass(), cls -> {
            return cls != null && BlockEntity.class.isAssignableFrom(cls);
        }, (v0) -> {
            return v0.getSuperclass();
        }).flatMap(cls2 -> {
            return Arrays.stream(cls2.getDeclaredFields());
        }).filter(field -> {
            return field.isAnnotationPresent(GuiField.class);
        }).map(field2 -> {
            return ((GuiField) field2.getAnnotation(GuiField.class)).fieldName();
        }).filter(str -> {
            return !hasGuiField(str);
        }).distinct().toList().toArray(new String[0]));
    }

    default <Provider extends BlockEntity & INetworkFieldProvider> void updateGuiField(@Nonnull Provider provider, @Nonnull String str) {
        MCTech.NETWORKING.updateGuiField(provider, str);
    }

    default <Provider extends BlockEntity & INetworkFieldProvider> void updateGuiFields(@Nonnull Provider provider) {
        LinkedHashSet linkedHashSet = new LinkedHashSet(getGuiFields());
        linkedHashSet.addAll(getNetworkFields());
        linkedHashSet.forEach(str -> {
            updateGuiField(provider, str);
        });
    }

    default <Provider extends BlockEntity & INetworkFieldProvider> void updateAll(@Nonnull Provider provider) {
        updateNetworkFields(provider);
        updateGuiFields(provider);
    }
}
