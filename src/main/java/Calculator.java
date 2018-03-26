import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 13_da on 26.03.2018.
 */
public class Calculator {
    private boolean isError = false;
    private String status = "";
    private Double result;
    private Scanner scanner = new Scanner(System.in);

    private String read(){
        String s = scanner.nextLine();
        return s;
    }

    private void calculate(List<String> input){
        Deque<Double> stack = new ArrayDeque<Double>();
        for (String x : input){
            if (x.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else {
                if (x.equals("-")){
                    Double b = stack.pop(), a = stack.pop();
                    stack.push(a - b);
                }
                else {
                    if (x.equals("*"))
                        stack.push(stack.pop() * stack.pop());
                    else {
                        if (x.equals("/")){
                            Double b = stack.pop(), a = stack.pop();
                            if (b == 0){
                                //System.out.println("Division by zero");
                                status = "Division by zero";
                                isError = true;
                            }
                            stack.push(a / b);
                        }
                        else {
                            if (x.equals("u-"))
                                stack.push(-stack.pop());
                            else {
                                if (x.equals("^")){
                                    Double b = stack.pop(), a = stack.pop();
                                    stack.push(Math.pow(a, b));
                                }
                                else
                                    stack.push(Double.valueOf(x));
                            }
                        }
                    }
                }
            }
        }
        result = stack.pop();
    }
    public String start(){
        Parser parser = new Parser();
        List<String> input = parser.start(read());
        if (parser.getFlag()) {
            /*for (String s : input) {
                System.out.println(s);
            }
            System.out.println();*/

            calculate(input);
            if (!isError)
                return result.toString();
            else
                return status;
        }
        return parser.getStatus();
    }
    public String startTest(String expr){
        Parser parser = new Parser();
        List<String> input = parser.start(expr);
        if (parser.getFlag()) {

            calculate(input);
            if (!isError)
                return result.toString();
            else
                return status;
        }
        return parser.getStatus();
    }
}
