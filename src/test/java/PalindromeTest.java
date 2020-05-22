import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {
    static Palindrome palindromes;

    @BeforeAll
    public static void setup(){
         palindromes=new Palindrome();
    }

    @Test
    @DisplayName("single character")
    void test(){
        //given
        String s  = "a";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("two characters not a palindrome")
    void test2(){
        //given
        String s  = "ab";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("two characters a palindrome")
    void test3(){
        //given
        String s  = "aa";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("long palindrome")
    void test4(){
        //given
        String s  = "aabbccpccbbaa";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("long palindrome with special characters")
    void test5(){
        //given
        String s  = "aa -) aa .?";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("long not palindrome with special characters")
    void test6(){
        //given
        String s  = "aa bb) aa .v?";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("not a palindrome with numbers")
    void test7(){
        //given
        String s  = "a1 n 45 a";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("palindrome from numbers with special characters")
    void test8(){
        //given
        String s  = "12?, 34 . 321!!!";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("palindrome from numbers with polish letters")
    void test9(){
        //given
        String s  = "ąęćśńłółńśćęą";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("palindrome from numbers with polish letters")
    void test10(){
        //given
        String s  = "a d fda          !";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("palindrome from numbers with polish letters")
    void test11(){
        //given
        String s  = "Ej, Żyrafa RyŻ " +
                "\nje ";
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("palindrome from numbers with polish letters")
    void test12(){
        //given
        String s  = null;
        //when
        boolean result = palindromes.isPalindrome(s);
        //then
        Assertions.assertFalse(result);
    }

}