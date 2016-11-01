import com.ezsocsi.projecteuler1.Main;
import com.ezsocsi.utils.IntegrationTestUtils;
import org.junit.Test;

import static org.testng.Assert.assertEquals;

public class ProjectEuler1IntegrationTest extends IntegrationTestUtils {
    @Test
    public void prints_error_when_no_arguments() {
        Main.main();

        assertEquals("", stdout.toString());
        assertEquals("ERROR: unable to parse arguments, expected: <number>." + System.lineSeparator(),
                stderr.toString());
    }

    @Test
    public void prints_error_when_multiple_arguments() {
        Main.main("1", "2", "3");

        assertEquals("", stdout.toString());
        assertEquals("ERROR: unable to parse arguments, expected: <number>." + System.lineSeparator(),
                stderr.toString());
    }

    @Test
    public void prints_correct_project_euler_value_23_for_input_10() {
        Main.main("10");

        assertEquals("23" + System.lineSeparator(), stdout.toString());
        assertEquals("", stderr.toString());
    }

    @Test
    public void prints_correct_project_euler_value_2318_for_input_100() {
        Main.main("100");

        assertEquals("2318" + System.lineSeparator(), stdout.toString());
        assertEquals("", stderr.toString());
    }

    @Test
    public void prints_correct_project_euler_value_2318_for_input_1000() {
        Main.main("1000");

        assertEquals("233168" + System.lineSeparator(), stdout.toString());
        assertEquals("", stderr.toString());
    }
}
