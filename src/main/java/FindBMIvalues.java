import static java.lang.Math.abs;

public class FindBMIvalues {

    public static void main(String[] args) {
        double BMI = 18.49;
        double result = 0;
        double close = 0.5;
        double closestCm = 0;
        int closestKg = 0;
        double closestBMI = 0;


        for (double cm = 100; cm <250.01; cm=cm+0.01){
            for (int kg =20; kg <301; kg++){
                result = kg / ((cm/100)*(cm/100));
                if(result == BMI){
                    System.out.println("MATCH!  kg: " + kg + " cm: "+ cm);
                }
                if (0<=(BMI - result)&&(BMI-result)<close){
                    close = abs(result - BMI);
                    closestCm = cm;
                    closestKg = kg;
                    closestBMI = result;
                }
               //System.out.println(kg +" "+ cm + " " + result);
            }
        }
        System.out.println("closest values: " + closestBMI + " kg: "+ closestKg + " cm: " + closestCm);

    }
}
