package scripts.actions.Make;

import org.tribot.api2007.Inventory;

import scripts.Globals;
import scripts.sbf.action.Action;
import scripts.sbf.util.ABC;

public class MakeUnf extends Action{
	private final ABC abc = manager.getABC();
	private final String itemToUse = selections.get("ItemToUse");
	private final String secondItemToUse = "Feather";
	@Override
	public void execute() {
		while (Globals.MAKE_UNF.getStatus()) {
			Inventory.find(itemToUse)[0].click("Use");
			this.abc.waitItemInteractionDelay();
			Inventory.find(secondItemToUse)[0].click("Use");
			this.abc.waitItemInteractionDelay();
		}
		
	}

	@Override
	public boolean isValid() {
		return Globals.MAKE_UNF.getStatus();
	}

}
