package testscripts;

import com.ally.base.Base;
import com.deque.axe.AXE;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class AmazonAllyTest extends Base {
	@Test
	public void amazonAllyTest() throws NumberFormatException, IOException, InterruptedException {
		String URL = "https://www.amazon.com/";
		if (isRunnable(URL)) {
			Thread.sleep(1000);
			JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
			JSONArray violations = responseJSON.getJSONArray("violations");
			if (violations.length() == 0) {
				System.out.println("No violations found");
			} else {
				AXE.writeResults("AmazonAllyTest", responseJSON);
				Assert.assertTrue(false, AXE.report(violations));
			}
		}
	}
}
