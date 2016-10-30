import com.ezsocsi.quicksort.Main;

import com.ezsocsi.utils.IntegrationTestUtils;
import org.junit.Test;

import static org.testng.Assert.assertEquals;


public class QuickSortIntegrationTest extends IntegrationTestUtils {
    @Test
    public void prints_error_when_no_arguments() {
        Main.main();

        assertEquals("", stdout.toString());
        assertEquals("ERROR: unable to parse arguments, expected: \"<num> <num> <num> ...\"." + System.lineSeparator(),
                stderr.toString());
    }

    @Test
    public void prints_error_when_multiple_arguments() {
        Main.main("1", "2", "2");

        assertEquals("", stdout.toString());
        assertEquals("ERROR: unable to parse arguments, expected: \"<num> <num> <num> ...\"." + System.lineSeparator(),
                stderr.toString());
    }

    @Test
    public void prints_correctly_the_one_input_argument() {
        Main.main("1");

        assertEquals("1" + System.lineSeparator(), stdout.toString());
        assertEquals("", stderr.toString());
    }

    @Test
    public void prints_correctly_sorted_list_from_unsorted_input() {
        Main.main("1 6 8 2 3 3 7 8");

        assertEquals("1 2 3 3 6 7 8 8" + System.lineSeparator(), stdout.toString());
        assertEquals("", stderr.toString());
    }
}
