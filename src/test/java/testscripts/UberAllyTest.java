package testscripts;

import com.ally.base.Base;
import com.deque.axe.AXE;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UberAllyTest extends Base {
	@Test
	public void uberAllyTest() throws NumberFormatException, IOException {
		String URL = "https://www.uber.com/";
		if (isRunnable(URL)) {
			JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
			JSONArray violations = responseJSON.getJSONArray("violations");
			if (violations.length() == 0) {
				System.out.println("No violations found");
			}else {
				AXE.writeResults("UberAllyTest", responseJSON);
				Assert.assertTrue(false, AXE.report(violations));
			}
		}
	}
}
