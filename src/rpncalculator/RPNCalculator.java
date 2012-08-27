package rpncalculator;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class RPNCalculator {

    public Double calculate(String RPNExpression) throws Exception {
        LinkedList<Double> numbers = new LinkedList<>();

        for (StringTokenizer stringTokenizer = new StringTokenizer(RPNExpression); stringTokenizer.hasMoreTokens();) {
            String token = stringTokenizer.nextToken();
            //System.out.println(token);
            if (isOperation(token)) {
                if (numbers.size() < 2) {
                    throw new Exception("Wrong RPN format");
                }
                Double y = numbers.removeLast();
                Double x = numbers.removeLast();

                Double result;
                switch (token) {
                    case "+":
                        result = x + y;
                        break;
                    case "-":
                        result = x - y;
                        break;
                    case "*":
                        result = x * y;
                        break;
                    case "/":
                        result = x / y;
                        break;
                    default:
                        throw new Exception("Wrong operationtoken");
                }
                //System.out.println(x + token + y + " = " + result);
                numbers.add(result);

            } else {
                isNumber(token);
                Double num = Double.parseDouble(token);
                numbers.add(num);
            }
        }
        if(numbers.size()!=1){
            throw new Exception("No last element found in 'numbers'");
        }
        return numbers.getLast();
    }
    public static boolean isNumber(String s) {
        Scanner sc = new Scanner(s);
        if (sc.hasNextDouble() || sc.hasNextInt()) {
            return true;
        }
        return false;
    }
    public static boolean isOperation(String s) {
        return s.trim().matches("\\+|-|\\*|/");
    }
    public static void main(String[] args) throws Exception {   
        String expression = "19 2.14 + 4.5 2 4.3 / - *";
        RPNCalculator calculator = new RPNCalculator();
        System.out.println(expression + "\n = \n" + calculator.calculate(expression));
    }
}
