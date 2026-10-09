package mctech.api.tiles.readers;

import com.google.common.base.Function;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import java.util.Map;
import net.minecraft.world.level.block.entity.BlockEntity;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/readers/ReaderProvider.class */
public class ReaderProvider {
    static final Map<Class<?>, Function<BlockEntity, IFuelStorage>> FUEL_PROVIDER = new Object2ObjectOpenHashMap();
    static final Map<Class<?>, Function<BlockEntity, IActivityProvider>> ACTIVE_PROVIDER = new Object2ObjectOpenHashMap();
    static final Map<Class<?>, Function<BlockEntity, IProgressMachine>> PROGRESS_PROVIDER = new Object2ObjectOpenHashMap();

    public static void registerActiveProvider(Class<?> cls, Function<BlockEntity, IActivityProvider> function) {
        ACTIVE_PROVIDER.put(cls, function);
    }

    public static void registerFuelProvider(Class<?> cls, Function<BlockEntity, IFuelStorage> function) {
        FUEL_PROVIDER.put(cls, function);
    }

    public static void registerProgressProvider(Class<?> cls, Function<BlockEntity, IProgressMachine> function) {
        PROGRESS_PROVIDER.put(cls, function);
    }

    public static IFuelStorage getFuelProvider(BlockEntity blockEntity) {
        if (blockEntity == null) {
            return null;
        }
        if (blockEntity instanceof IFuelStorage) {
            return (IFuelStorage) blockEntity;
        }
        Class<?> superclass = blockEntity.getClass();
        while (true) {
            Class<?> cls = superclass;
            if (cls != BlockEntity.class) {
                Function<BlockEntity, IFuelStorage> function = FUEL_PROVIDER.get(cls);
                if (function == null) {
                    superclass = cls.getSuperclass();
                } else {
                    if (cls != blockEntity.getClass()) {
                        FUEL_PROVIDER.put(blockEntity.getClass(), function);
                    }
                    return (IFuelStorage) function.apply(blockEntity);
                }
            } else {
                return null;
            }
        }
    }

    public static IProgressMachine getProgressProvider(BlockEntity blockEntity) {
        if (blockEntity == null) {
            return null;
        }
        if (blockEntity instanceof IProgressMachine) {
            return (IProgressMachine) blockEntity;
        }
        Class<?> superclass = blockEntity.getClass();
        while (true) {
            Class<?> cls = superclass;
            if (cls != BlockEntity.class) {
                Function<BlockEntity, IProgressMachine> function = PROGRESS_PROVIDER.get(cls);
                if (function == null) {
                    superclass = cls.getSuperclass();
                } else {
                    if (cls != blockEntity.getClass()) {
                        PROGRESS_PROVIDER.put(blockEntity.getClass(), function);
                    }
                    return (IProgressMachine) function.apply(blockEntity);
                }
            } else {
                return null;
            }
        }
    }

    public static IActivityProvider getActivityProvider(BlockEntity blockEntity) {
        if (blockEntity == null) {
            return null;
        }
        if (blockEntity instanceof IActivityProvider) {
            return (IActivityProvider) blockEntity;
        }
        Class<?> superclass = blockEntity.getClass();
        while (true) {
            Class<?> cls = superclass;
            if (cls != BlockEntity.class) {
                Function<BlockEntity, IActivityProvider> function = ACTIVE_PROVIDER.get(cls);
                if (function == null) {
                    superclass = cls.getSuperclass();
                } else {
                    if (cls != blockEntity.getClass()) {
                        ACTIVE_PROVIDER.put(blockEntity.getClass(), function);
                    }
                    return (IActivityProvider) function.apply(blockEntity);
                }
            } else {
                return null;
            }
        }
    }
}
