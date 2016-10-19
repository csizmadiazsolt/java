import com.ezsocsi.fizzbuzz.Main;
import com.ezsocsi.utils.IntegrationTestUtils;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FizzBuzzIntegrationTest extends IntegrationTestUtils {
    @Test
    public void successful_fizz_buzz_execution() {
        Main.main("4", "7");

        assertEquals("4, Buzz, Fizz, 7" + System.lineSeparator(), stdout.toString());
        assertEquals("", stderr.toString());
    }

    @Test
    public void unsuccessful_fizz_buzz_execution_due_to_wrong_arguments() {
        Main.main("4");

        assertEquals("", stdout.toString());
        assertEquals("ERROR: unable to parse arguments, expected: <int> <int>." + System.lineSeparator(), stderr.toString());
    }
}
