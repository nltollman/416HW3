package compression;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * bamaID:
 *
 * Coverage criteria:
 *
 */

public class FiveBitEncodingTest {

   FiveBitEncoding enc;

   @Before
   public void setUp() {
      enc = new FiveBitEncoding();

   }

   @Test
   public void testExample() {
	   
	   /**
	    * Reason: 
	    */
	   
	   byte[] cod = enc.encode("abcdefgh");
	   
	   byte[] expected = { (byte) 8, (byte) 134, (byte) 66, (byte) 152,
            (byte) 232 };
	   
	   assertArrayEquals(expected, cod);
   }
   
   
   
   @Test
   public void test01() {
	   
	   /**
	    * Reason:
	    */
	   
	   fail("Not yet implemented");
   }   
}

