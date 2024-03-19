package testscripts;

import com.ally.base.Base;
import com.deque.axe.AXE;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class HaconDemoTest extends Base {
    @Test
    public void haconDemoTest() throws NumberFormatException, IOException, InterruptedException {
        String URL = "https://www.aliexpress.com/";
        if (isRunnable(URL)) {
            Thread.sleep(1000);
            JSONObject responseJSON = new AXE.Builder(driver, scriptUrl).analyze();
            JSONArray violations = responseJSON.getJSONArray("violations");
            if (violations.length() == 0) {
                System.out.println("No violations found");
            } else {
                AXE.writeResults("HaconDemoTest", responseJSON);
                Assert.assertTrue(false, AXE.report(violations));
            }
        }
    }
}
