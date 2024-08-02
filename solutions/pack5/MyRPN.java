package solutions.pack5;

import java.util.regex.Pattern;

public class MyRPN {
    public static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
        }

    public static double computeRPN(String rpn) {
    }

}
