package mctech.api.heat;

import mctech.api.tiles.IInputMachine;

/* JADX INFO: loaded from: mctech-frozen-2.1.3-client-RELEASE.jar:mctech/api/heat/IHeatingMachine.class */
public interface IHeatingMachine extends IHeatTile, IInputMachine {
    boolean isHeating();

    boolean isOverheating();
}
