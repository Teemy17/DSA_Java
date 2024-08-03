package solutions.pack5;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class MyRPN {
    public static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null)
            return false;
        return pattern.matcher(strNum).matches();
        }

    public static double computeRPN(String rpn) {
        MyStackA stack = new MyStackA();
        Scanner in = new Scanner(rpn);
        String rpn2 = in.nextLine();
        StringTokenizer st = new StringTokenizer(rpn2);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double op2 = stack.pop();
                double op1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(op1 + op2);
                        break;
                    case "-":
                        stack.push(op1 - op2);
                        break;
                    case "*":
                        stack.push(op1 * op2);
                        break;
                    case "/":
                        stack.push(op1 / op2);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid operator: " + token);
                }
            }
        }
        return stack.pop();
    }
}
