package scripts.actions.Make;

import org.tribot.api.General;
import org.tribot.api.Timing;
import org.tribot.api.types.generic.Condition;
import org.tribot.api2007.Interfaces;
import org.tribot.api2007.Inventory;

import scripts.Globals;
import scripts.sbf.action.Action;
import scripts.sbf.util.ABC;

public class UseItemOneWithTwo extends Action {
	private final ABC abc = manager.getABC();
	private final String product = selections.get("Product");
	private final String itemToUse = selections.get("ItemToUse");
	private final String secondItemToUse = itemToUse
			.equalsIgnoreCase("Headless arrow") ? product.concat("tips")
			: "Feather";

	@Override
	public void execute() {
		if (Inventory.find(itemToUse)[0].click("Use"))
			this.abc.waitItemInteractionDelay();
		else
			return;
		if (Inventory.find(secondItemToUse)[0].click("Use"))
			this.abc.waitItemInteractionDelay();
		else
			return;

		Timing.waitCondition(new Condition() {

			@Override
			public boolean active() {
				General.sleep(100, 200);
				return Interfaces.get(582) != null;
			}

		}, General.random(5000, 6000));

	}

	@Override
	public boolean isValid() {
		return Globals.USE_ITEM_ONE_WITH_TWO.getStatus();
	}

}
