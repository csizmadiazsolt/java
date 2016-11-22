import com.ezsocsi.inheritance.Main;
import com.ezsocsi.utils.IntegrationTestUtils;
import org.junit.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class InheritanceTest extends IntegrationTestUtils {
    @Test
    public void prints_error_when_no_arguments() {
        Main.main();

        assertTrue(stdout.toString().contains("Manpower costs: "));
        assertTrue(stdout.toString().contains("CEO tells the vision."));
        assertTrue(stdout.toString().contains("Manager-0 tells the direction."));
        assertTrue(stdout.toString().contains("Secretary-0 orders stuff."));
        assertTrue(stdout.toString().contains("Java Developer-0 develops JAVA."));
        assertTrue(stdout.toString().contains("CPP Developer-0 develops C++."));
        assertTrue(stdout.toString().contains("Java Developer-0 <-- CEO"));
        assertTrue(stdout.toString().contains("CPP Developer-0 <-- CEO"));
        assertEquals("", stderr.toString());
    }
}
