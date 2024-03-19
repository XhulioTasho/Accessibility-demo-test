package testscripts;

import org.testng.annotations.Test;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import java.io.IOException;
import com.ally.base.Base;
import com.deque.axe.AXE;

public class LyftAllyTest extends Base {
	@Test
	public void lyftAllyTest() throws NumberFormatException, IOException {
		String URL = "https://www.lyft.com/rider/cities";
		if (isRunnable(URL)) {
			JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
			JSONArray violations = responseJSON.getJSONArray("violations");
			if (violations.length() == 0) {
				System.out.println("No violations found");
			}else {
				AXE.writeResults("LyftAllyTest", responseJSON);
				Assert.assertTrue(false, AXE.report(violations));
			}
		}
	}
}
