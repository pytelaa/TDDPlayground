import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
    public String calculate(String s){
        String numberComa = "([\\(][-]?\\d+[,]?\\d*[\\)]|[-]?\\d+[,]?\\d*)";
        String numberDot = "([\\(][-]?\\d+[.]?\\d*[\\)]|[-]?\\d+[.]?\\d*)";
        String signs = "([+/*\\-])";

        Pattern numberDotPattern = Pattern.compile(numberDot);
        Pattern equationDotPattern = Pattern.compile(numberDot+signs+numberDot);

        if (s.contains(".")) {throw new IllegalStateException("Not valid expression.");}

        s=s.replaceAll("[ ]+", "");
        s=s.replaceAll(",", ".");
        Matcher equationMatcher = equationDotPattern.matcher(s);
        Matcher numberMatcher = numberDotPattern.matcher(s);

        if(numberMatcher.matches()){
            s=s.replaceAll("[\\(\\)]", "");
            numberMatcher = numberDotPattern.matcher(s);
            numberMatcher.find();
            Double number = Double.parseDouble(numberMatcher.group(1));
            return number.toString().replaceAll("[.]", ",");
        }
        else if(equationMatcher.matches()){
            s=s.replaceAll("[\\(\\)]", "");
            equationMatcher = equationDotPattern.matcher(s);
            equationMatcher.find();
            Double number1 = Double.parseDouble(equationMatcher.group(1));
            Double number2 = Double.parseDouble(equationMatcher.group(3));
            Double result = 0.0;

            switch (equationMatcher.group(2)){
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "/":
                    if(number2==0) throw new IllegalStateException("It is not possible to divide by 0.");
                    result = number1 / number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
            }
            return result.toString().replaceAll("[.]", ",");
        }
        else {throw new IllegalStateException("Not valid expression.");}

    }
}
