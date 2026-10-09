package mctech.api.tiles;

import java.util.EnumSet;
import mctech.api.items.IUpgradeItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.IItemHandler;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/FakePlayerMachine.class */
public class FakePlayerMachine implements IMachine {
    static final EnumSet<IUpgradeItem.UpgradeType> DEFAULT = EnumSet.allOf(IUpgradeItem.UpgradeType.class);
    EnumSet<IUpgradeItem.UpgradeType> type;
    Player player;

    public FakePlayerMachine(Player player) {
        this(player, DEFAULT);
    }

    public FakePlayerMachine(Player player, EnumSet<IUpgradeItem.UpgradeType> enumSet) {
        this.player = player;
        this.type = enumSet;
    }

    @Override // mctech.api.tiles.IInputMachine
    public int getValidRoom(ItemStack itemStack) {
        return 0;
    }

    @Override // mctech.api.tiles.IMachine
    public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
        return this.type;
    }

    @Override // mctech.api.tiles.IMachine
    public int getAvailableEnergy() {
        return 0;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isMachineWorking() {
        return false;
    }

    @Override // mctech.api.tiles.IMachine
    public boolean isRedstoneSensitive() {
        return false;
    }

    @Override // mctech.api.tiles.IMachine
    public void setRedstoneSensitive(boolean z) {
    }

    @Override // mctech.api.tiles.IMachine
    public IItemHandler getConnectedInventory(Direction direction) {
        return null;
    }

    @Override // mctech.api.util.ILocation
    public Level getLevel() {
        return this.player.getCommandSenderWorld();
    }

    @Override // mctech.api.util.ILocation
    public BlockPos getPosition() {
        return this.player.blockPosition();
    }

    /* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/tiles/FakePlayerMachine$FakeMachine.class */
    public static class FakeMachine implements IMachine {
        EnumSet<IUpgradeItem.UpgradeType> type;
        Level world;
        BlockPos pos;

        public FakeMachine(Level level, BlockPos blockPos) {
            this(FakePlayerMachine.DEFAULT, level, blockPos);
        }

        public FakeMachine(EnumSet<IUpgradeItem.UpgradeType> enumSet, Level level, BlockPos blockPos) {
            this.type = enumSet;
            this.world = level;
            this.pos = blockPos;
        }

        @Override // mctech.api.tiles.IInputMachine
        public int getValidRoom(ItemStack itemStack) {
            return 0;
        }

        @Override // mctech.api.tiles.IMachine
        public EnumSet<IUpgradeItem.UpgradeType> getSupportedUpgradeTypes() {
            return this.type;
        }

        @Override // mctech.api.tiles.IMachine
        public int getAvailableEnergy() {
            return 0;
        }

        @Override // mctech.api.tiles.IMachine
        public boolean isMachineWorking() {
            return false;
        }

        @Override // mctech.api.tiles.IMachine
        public boolean isRedstoneSensitive() {
            return false;
        }

        @Override // mctech.api.tiles.IMachine
        public void setRedstoneSensitive(boolean z) {
        }

        @Override // mctech.api.tiles.IMachine
        public IItemHandler getConnectedInventory(Direction direction) {
            return null;
        }

        @Override // mctech.api.util.ILocation
        public Level getLevel() {
            return this.world;
        }

        @Override // mctech.api.util.ILocation
        public BlockPos getPosition() {
            return this.pos;
        }
    }
}
