package scripts.actions.StringBow;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;

import scripts.Globals;
import scripts.sbf.action.Action;
import scripts.sbf.util.ABC;

public class UseBowString extends Action {
	private final ABC abc = manager.getABC();

	@Override
	public void execute() {
		if (Inventory.find("Bow string")[0].click("Use"))
			this.abc.waitItemInteractionDelay();
		else
			return;
		if (Inventory.find(selections.get("Product"))[0].click("Use"))
			this.abc.waitItemInteractionDelay();
		else
			return;
		Timing.waitCondition(new Condition() {

			@Override
			public boolean active() {
				General.sleep(100, 200);
				return Interfaces.get(309) != null;
			}

		}, General.random(5000, 6000));

	}

	@Override
	public boolean isValid() {
		return Globals.USE_BS.getStatus();
	}

}
