import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    //Uncomment this class once you've created your Palindrome class.

    @Test
    public void TestisPalindrome(){
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("abba"));
//        assertTrue(palindrome.isPalindrome("1122"));

        CharacterComparator offByN = new OffByN(4);
        assertTrue(palindrome.isPalindrome("ae",offByN));
        assertTrue(palindrome.isPalindrome("ea",offByN));
        assertTrue(palindrome.isPalindrome("AE",offByN));
    }


}


