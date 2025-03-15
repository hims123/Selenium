package selenium.assignment;

import org.junit.Assert;
import org.junit.Test;

/*
 * W.a.junit program to handled Assert class with all method to check its pass or fail
 */

public class Que11 {

	@Test
    public void testAssertEquals() {
        // Test for equality of two values
        int expected = 5;
        int actual = 5;
        Assert.assertEquals("Test failed: The values are not equal", expected, actual);
        System.out.println("assertEquals Test Passed!");
    }

    @Test
    public void testAssertTrue() {
        // Test for boolean expression, expecting true
        boolean condition = (5 > 3); // This is true
        Assert.assertTrue("Test failed: Condition is not true", condition);
        System.out.println("assertTrue Test Passed!");
    }

    @Test
    public void testAssertFalse() {
        // Test for boolean expression, expecting false
        boolean condition = (5 < 3); // This is false
        Assert.assertFalse("Test failed: Condition is not false", condition);
        System.out.println("assertFalse Test Passed!");
    }

    @Test
    public void testAssertNotNull() {
        // Test for non-null object
        String str = "Hello, World!";
        Assert.assertNotNull("Test failed: Object is null", str);
        System.out.println("assertNotNull Test Passed!");
    }

    @Test
    public void testAssertNull() {
        // Test for null object
        String str = null;
        Assert.assertNull("Test failed: Object is not null", str);
        System.out.println("assertNull Test Passed!");
    }

    @Test
    public void testAssertArrayEquals() {
        // Test for equality of two arrays
        int[] expectedArray = {1, 2, 3, 4};
        int[] actualArray = {1, 2, 3, 4};
        Assert.assertArrayEquals("Test failed: Arrays are not equal", expectedArray, actualArray);
        System.out.println("assertArrayEquals Test Passed!");
    }

    @Test
    public void testAssertSame() {
        // Test to check if both references point to the same object
        String str1 = "Test String";
        String str2 = str1; // Both references point to the same object
        Assert.assertSame("Test failed: Objects are not the same", str1, str2);
        System.out.println("assertSame Test Passed!");
    }

    @Test
    public void testAssertNotSame() {
        // Test to check if two references do not point to the same object
        String str1 = new String("Test String");
        String str2 = new String("Test String");
        Assert.assertNotSame("Test failed: Objects are the same", str1, str2);
        System.out.println("assertNotSame Test Passed!");
    }

	
}
