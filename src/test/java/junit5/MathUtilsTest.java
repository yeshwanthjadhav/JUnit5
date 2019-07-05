package junit5;


import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class MathUtilsTest {

	MathUtils mu;
	
	@BeforeEach
	void init(){
		mu = new MathUtils();		
	}
	
	@Test
	void testDivide() {
		Assertions.assertThrows(ArithmeticException.class, () -> mu.divide(1, 0), "Divide ");

	}

	@Test
	void test() {
		int expected = 2;
		int actual = mu.add(1, 1);
		Assertions.assertEquals(expected, actual);
		// fail("Not done");

		Assertions.assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(20);
			return "result";
		});

		// assertEquals(expected, actual);
		// assertArrayEquals(expecteds, actuals);
		// assertIterableEquals(expectedArray, actualArray);

		// https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
	}

}
