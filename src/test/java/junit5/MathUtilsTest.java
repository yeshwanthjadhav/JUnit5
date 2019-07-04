package junit5;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class MathUtilsTest{

 @Test
 void test(){
	 MathUtils mu = new MathUtils();
	 int expected = 2;
	 int actual = mu.add(1, 1);
	 assertEquals(expected, actual);
	 // fail("Not done"); 
	 
	 //assertEquals(expected, actual);
	 //assertArrayEquals(expecteds, actuals);
	 //assertIterableEquals(expectedArray, actualArray);
	 
	 //https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
 }
 
}
