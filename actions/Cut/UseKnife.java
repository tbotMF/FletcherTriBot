package scripts.actions.Cut;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;

import scripts.Globals;
import scripts.sbf.action.Action;
import scripts.sbf.graphics.UserSelections;
import scripts.sbf.util.ABC;

public class UseKnife extends Action {
	private final ABC abc = manager.getABC();

	@Override
	public void execute() {
		if (Inventory.find("Knife")[0].click("Use"))
			this.abc.waitItemInteractionDelay();
		else
			return;

		if (Inventory.find(UserSelections.getInstance().get("ItemToUse"))[0]
				.click("Use"))
			this.abc.waitItemInteractionDelay();
		else
			return;

		Timing.waitCondition(new Condition() {

			@Override
			public boolean active() {
				General.sleep(100, 200);
				return Interfaces.get(skillManager.getMasterIndex()) != null;
			}

		}, General.random(3000, 4000));

	}

	@Override
	public boolean isValid() {

		return Globals.USE_KNIFE.getStatus();
	}

}
