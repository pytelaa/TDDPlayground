import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    static Calculator calculator;

    @BeforeAll
    public static void setup(){
        calculator=new Calculator();
    }

    @Test
    void test01() {
        //given
        String input= "0";
        //when
        String result = calculator.calculate(input);
        //then
        Assertions.assertEquals("0,0", result);
    }

    @Test
    void test02() {
        //given
        String input= "1111";
        //when
        String result = calculator.calculate(input);
        //then
        Assertions.assertEquals("1111,0", result);
    }

    @Test
    void test03() {
        //given
        String input= "tre";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(input), "Not valid expression.");
    }

    @Test
    void test04() {
        //given
        String input= "0,9867";
        //when
        String result = calculator.calculate(input);
        //then
        Assertions.assertEquals("0,9867", result);
    }

    @Test
    void test05() {
        //given
        String input= "7*764#";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(input), "Not valid expression.");
    }

    @Test
    void test06() {
        //given
        String input= "1 6543, 6477";
        //when
        String result = calculator.calculate(input);
        //then
        Assertions.assertEquals("16543,6477", result);
    }


    @Test
    void test07() {
        //given
        String input="1 567 6543, 647,7";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(input), "Not valid expression.");
    }

    @Test
    void test08() {
        //given
        String input="2 + 3 ";
        //when
        String result = calculator.calculate(input);
        //then
        Assertions.assertEquals("5,0", result);
    }

    @Test
    void test09() {
        //given
        String s = "12+3";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("15,0", result);
    }

    @Test
    void test10() {
        //given
        String s = "2,5+3";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("5,5", result);
    }

    @Test
    void test11() {
        //given
        String s = "2-   3,1";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("-1,1", result);
    }

    @Test
    void test12() {
        //given
        String s = "2 *   -3,1";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("-6,2", result);
    }

    @Test
    void test13() {
        //given
        String s = "7/2";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("3,5", result);
    }

    @Test
    void test14() {
        //given
        String s = "2 ,7   ,8 -   3,1";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(s), "Not valid expression.");
    }

    @Test
    void test15() {
        //given
        String s = "1.25 + 1,25";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(s), "Not valid expression.");
    }

    @Test
    void test16() {
        //given
        String s = "(-5)";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("-5,0", result);
    }

    @Test
    void test17() {
        //given
        String s = "-5)()";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(s), "Not valid expression.");
    }

    @Test
    void test18() {
        //given
        String s = "2/0";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(s), "It is not possible to divide by 0.");
    }

    @Test
    void test19() {
        //given
        String s = "2.90";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(s), "Not valid expression.");
    }

    @Test
    void test20() {
        //given
        String s = "2-(-2)";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("4,0", result);
    }

    @Test
    void test21() {
        //given
        String s = "(-2";
        //when + then
        Assertions.assertThrows(IllegalStateException.class,() -> calculator.calculate(s), "Not valid expression.");

    }

    @Test
    void test22() {
        //given
        String s = "e * 2";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("5,43656", result);
    }

    @Test
    void test23() {
        //given
        String s = "e ";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("2,71828", result);
    }

    @Test
    void test24() {
        //given
        String s = "1^0";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("1,0", result);
    }

    @Test
    void test25() {
        //given
        String s = "5^3";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("125,0", result);
    }

    @Test
    void test26() {
        //given
        String s = "5,2^3,6";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("378,104666243201", result);
    }

    @Test
    void test27() {
        //given
        String s = "15,1^-0,6";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("0,19616152611931284", result);
    }

    @Test
    void test28() {
        //given
        String s = "4 + 2 - 6 ";
        //when
        String result = calculator.calculate(s);
        //then
        Assertions.assertEquals("0,0", result);
    }


}