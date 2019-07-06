package junit5;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIf;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class MathUtilsTest {

	/**
	 * https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
	 */
	
	/*
	 * @EnabledOnOs(OS.LINUX)
	 * 
	 * @EnabledOnJre(JRE.JAVA_11)
	 * 
	 * @EnabledIf
	 * 
	 * @EnabledIfSystemProperty
	 * 
	 * @EnabledIfEnvironmentVariable
	 */
	
	MathUtils mu;

	@BeforeAll
	static void beforeAllInit() {
		System.out.println("Run before all....");
	}

	@BeforeEach
	void init() {
		mu = new MathUtils();
		System.out.println("Run before each method....");
	}

	@AfterEach
	void cleanUp() {
		System.out.println("Clean up......");
	}

	@Test
	@DisplayName("Divide two numbers")
	void testDivide() {
		Assertions.assertThrows(ArithmeticException.class, () -> mu.divide(1, 0), "Divide ");
	}

	@Test
	void testAssertAll() {
		assertAll(() -> assertEquals(2, mu.divide(4, 2)), () -> assertEquals(5, mu.divide(10, 2)));
	}

	@Test
	void testAdd() {
		int expected = 2;
		int actual = mu.add(1, 1);
		Assertions.assertEquals(expected, actual);
		// fail("Not done");

		Assertions.assertTimeout(Duration.ofMillis(100), () -> {
			Thread.sleep(20);
			return "result";
		});

	}

	@Test
	@Disabled
	void testDisabled() {
		fail("Fail this method");
	}
	
	
	@RepeatedTest(4)
	void testAddPositive(RepetitionInfo info) {
		info.getCurrentRepetition();
		info.getTotalRepetitions();
		Assertions.assertEquals(4, mu.add(2, 2));
	}
	
	@Nested
	@DisplayName("Add Numbers")
	class AddTest{
	
		@Test
		void testAddPositive() {
			Assertions.assertEquals(4, mu.add(2, 2));
		}
		
		@Test
		void testAddNegative() {
			Assertions.assertEquals(-4, mu.add(-2, -2));
		}
		
	}

}
