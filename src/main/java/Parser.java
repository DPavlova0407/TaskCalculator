import java.util.*;

/**
 * Created by 13_da on 26.03.2018.
 */
public class Parser {
    private static String operators = "+-*/^";
    private static String delimiters = "()+-*/^";
    private boolean isCorrect = true;
    private String status = "";

    // является ли символ разделительным (в том числе знаки операции)
    private boolean isDelimiter(String string){
        if (string.length() != 1)
            return false;
        for (int i = 0; i < delimiters.length(); i++){
            if (string.charAt(0) == delimiters.charAt(i))
                return true;
        }
        return false;
    }
    // является ли символ знаком операции
    private boolean isOperator(String string){
        if (string.equals("u-")) // унарный минус
            return true;
        if (string.length() != 1)
            return false;
        for (int i = 0; i < operators.length(); i++){
            if (string.charAt(0) == operators.charAt(i))
                return true;
        }
        return false;
    }
    // задается приоритет операций
    private static int priority(String string){
        char c = string.charAt(0);
        switch (c){
            case '(':
                return 1;
            case '+':
                return 2;
            case '-':
                return 2;
            case '*':
                return 3;
            case '/':
                return 3;
            default:
                return 4;
        }
    }
    // парсим считанное выражение в польскуй обратную запись
    private List<String> parse(String input){
        List<String> result = new ArrayList<String>();
        Deque<String> stack = new ArrayDeque<String>();
        StringTokenizer stringTokenizer = new StringTokenizer(input, delimiters, true);

        String prev = "";
        String cur;
        while (stringTokenizer.hasMoreTokens()){
            cur = stringTokenizer.nextToken();
            if (!stringTokenizer.hasMoreTokens() && (isDelimiter(cur) || isOperator(cur)) && !cur.equals(")")){
                //System.out.println("Incorrect expression! Like '(' or '*' or 'u-'");
                status = "Incorrect expression! Like '(' or '*' or 'u-'";
                isCorrect = false;
                return result;
            }
            if (cur.equals(" "))
                continue;
            if (isDelimiter(cur)){
                if (cur.equals("("))
                    stack.push(cur);
                else {
                    if (cur.equals(")")){
                        if ((isDelimiter(prev) || isOperator(prev) || prev.equals("")) && !prev.equals(")")){
                            //System.out.println("Incorrect expression! Like '()' or '*)' or 'u-)' or ')'");
                            status = "Incorrect expression! Like '()' or '*)' or 'u-)' or ')'";
                            isCorrect = false;
                            return result;
                        }
                        while (!stack.peek().equals("(")){
                            result.add(stack.pop());
                            if (stack.isEmpty()){
                                //System.out.println("Brackets are not consistent!");
                                status = "Brackets are not consistent!";
                                isCorrect = false;
                                return result;
                            }
                        }
                        stack.pop();//?
                    } // )
                    else {
                        if (cur.equals("-") &&
                                (prev.equals("") ||
                                        (isDelimiter(prev) && !prev.equals(")"))))
                            cur = "u-";
                        else{
                            if ((isOperator(prev) || prev.equals("")) && isDelimiter(cur)){
                                //System.out.println("Incorrect expression! Like '-/' or '/*' or '/2'");
                                status = "Incorrect expression! Like '-/' or '/*' or '/2'";
                                isCorrect = false;
                                return result;
                            }
                            while (!stack.isEmpty() &&
                                    (priority(cur) <= priority(stack.peek())))
                                result.add(stack.pop());
                        }
                        stack.push(cur);
                    } // ) else
                } // ( else
            } // isDelimiter
            else{
                if (!isNumber(cur)){
                    //System.out.println("Incorrect expression! The expression contains not only numbers. Like 'fhj7,' or '9с0лов0'");
                    status = "Incorrect expression! The expression contains not only numbers. Like 'fhj7,' or '9с0лов0'";
                    isCorrect = false;
                    return result;
                }
                result.add(cur);
            }
            prev = cur;
        } //while hasmoretokens
        while (!stack.isEmpty()){
            if (isOperator(stack.peek()))
                result.add(stack.pop());
            else {
                //System.out.println("Brackets are not consistent!!!");
                status = "Brackets are not consistent!!!";
                isCorrect = false;
                return result;
            }
        }
        if (result.size() == 0) {
            //System.out.println("Empty expression!");
            status = "Empty expression!";
            isCorrect = false;
        }
        return result;
    }
    public List<String> start(String input){
        //String input = read();
        //System.out.println(input);
        return parse(input);
    }
    public boolean getFlag(){
        return isCorrect;
    }
    private boolean isNumber(String string) {
        try {
            Double.parseDouble(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    public String getStatus(){
        return status;
    }
}
