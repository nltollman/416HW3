package compression;


/**
 * This class implements a simple string compression algorithm using a 5-bit encoding system.
 * 
 * Adapted from:
 * www.codeproject.com/Articles/223610/A-Simple-String-Compression-Algorithm
 */

public class FiveBitEncoding {
   final static public int FIVE_BIT = 5;

   /**
    * Encodes each character of txt using 5 bits and then pack them into a byte array (8 bits). 
    * @param txt The text to be compressed, a String composed by lower case letters ('a' to 'z') or spaces ('').
    * @return The byte array containing the resulting compressed text.
    */
   public byte[] encode(String txt) {
      int length = txt.length();
      
      float tmpRet1 = 5.0f, tmpRet2 = 8.0f;
      
      byte encoded[] = new byte[(int) (tmpRet1 * Math.ceil(length / tmpRet2))];
      char str[] = new char[length];
      txt.getChars(0, length, str, 0);

      String temp;
      String strBinary = new String("");
      for (int i = 0; i < length; i++) {
         temp = Integer.toBinaryString(toValue(str[i]));
         while (temp.length() % FIVE_BIT != 0) {
            temp = "0" + temp;
         }
         strBinary = strBinary + temp;
      }
      while (strBinary.length() % 8 != 0) {
         strBinary = strBinary + "0";
      }
      
      Integer tempInt = new Integer(0);
      for (int i = 0; i < strBinary.length(); i = i + 8) {
         tempInt = Integer.valueOf(strBinary.substring(i, i + 8), 2);
         encoded[i / 8] = tempInt.byteValue();
      }
      return encoded;
   }
    

   /**
    * Returns the value that represents a given character in the 5-bit encoding system.
    * @param ch The character to be encoded.
    * @return The value for ch in the 5-bit encoding system.
    */
    int toValue(char ch){
        int charVal = 0;
        switch(ch){
            case' ':charVal=0;break; case'a':charVal=1;break;
            case'b':charVal=2;break; case'c':charVal=3;break;
            case'd':charVal=4;break; case'e':charVal=5;break;
            case'f':charVal=6;break; case'g':charVal=7;break;
            case'h':charVal=8;break; case'i':charVal=9;break;
            case'j':charVal=10;break; case'k':charVal=11;break;
            case'l':charVal=12;break; case'm':charVal=13;break;
            case'n':charVal=14;break; case'o':charVal=15;break;
            case'p':charVal=16;break; case'q':charVal=17;break;
            case'r':charVal=18;break; case's':charVal=19;break;
            case't':charVal=20;break; case'u':charVal=21;break;
            case'v':charVal=22;break; case'w':charVal=23;break;
            case'x':charVal=24;break; case'y':charVal=25;break;
            case'z':charVal=26;break;  
            default:charVal=0;
        }
        return charVal;
    }
    
}

