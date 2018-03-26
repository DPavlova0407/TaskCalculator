/**
 * Created by 13_da on 26.03.2018.
 */
public class Test {
    private Calculator calculator;

    private String input1 = "5";
    private String answer1 = "5.0";

    private String input2 = "-5";
    private String answer2 = "-5.0";

    private String input3 = "-5.0";
    private String answer3 = "-5.0";

    private String input4 = "25";
    private String answer4 = "25.0";

    private String input5 = "4+3";
    private String answer5 = "7.0";

    private String input6 = "4*3";
    private String answer6 = "12.0";

    private String input7 = "4/3";
    private String answer7 = "1.3333333333333333";

    private String input8 = "4^3";
    private String answer8 = "64.0";

    private String input9 = "4-3";
    private String answer9 = "1.0";

    private String input10 = "(4+3)";
    private String answer10 = "7.0";

    private String input11 = "((4+3))";
    private String answer11 = "7.0";

    private String input12 = "(4+3)^(5-3)";
    private String answer12 = "49.0";

    private String input13 = "-5--2";
    private String answer13 = "-3.0";

    private String input14 = "-5*-2";
    private String answer14 = "10.0";

    private String input15 = "3+4*5";
    private String answer15 = "23.0";

    private String input16 = "3+4-5";
    private String answer16 = "2.0";

    private String input17 = "3+4-5/(7+3)";
    private String answer17 = "6.5";

    private String input18 = "5^2-10";
    private String answer18 = "15.0";

    private String input19 = "5-2^10";
    private String answer19 = "-1019.0";

    private String input20 = "(0)";
    private String answer20 = "0.0";

    private String input21 = "-(3+4)";
    private String answer21 = "-7.0";

    private String input22 = "(";
    private String answer22 = "Incorrect expression! Like '(' or '*' or 'u-'";

    private String input23 = "(4+)-5";
    private String answer23 = "Incorrect expression! Like '()' or '*)' or 'u-)' or ')'";

    private String input24 = "4+/3";
    private String answer24 = "Incorrect expression! Like '-/' or '/*' or '/2'";

    private String input25 = "3-";
    private String answer25 = "Incorrect expression! Like '(' or '*' or 'u-'";

    private String input26 = "5-6*7+";
    private String answer26 = "Incorrect expression! Like '(' or '*' or 'u-'";

    private String input27 = "/3";
    private String answer27 = "Incorrect expression! Like '-/' or '/*' or '/2'";

    private String input28 = ")";
    private String answer28 = "Incorrect expression! Like '()' or '*)' or 'u-)' or ')'";

    private String input29 = "12/(5-(3+2))";
    private String answer29 = "Division by zero";

    private String input30 = "12/(5-(3+2a))";
    private String answer30 = "Incorrect expression! The expression contains not only numbers. Like 'fhj7,' or '9с0лов0'";

    public Test(){
        calculator = new Calculator();
    }

    private boolean test(String input, String answer){
        String res = calculator.startTest(input);
        System.out.print(res + " ");
        return (res.equals(answer));
    }
    public void start(){
        System.out.print(input1 + " = ");
        System.out.println(test(input1, answer1));

        System.out.print(input2 + " = ");
        System.out.println(test(input2, answer2));

        System.out.print(input3 + " = ");
        System.out.println(test(input3, answer3));

        System.out.print(input4 + " = ");
        System.out.println(test(input4, answer4));

        System.out.print(input5 + " = ");
        System.out.println(test(input5, answer5));

        System.out.print(input6 + " = ");
        System.out.println(test(input6, answer6));

        System.out.print(input7 + " = ");
        System.out.println(test(input7, answer7));

        System.out.print(input8 + " = ");
        System.out.println(test(input8, answer8));

        System.out.print(input9 + " = ");
        System.out.println(test(input9, answer9));

        System.out.print(input10 + " = ");
        System.out.println(test(input10, answer10));

        System.out.print(input11 + " = ");
        System.out.println(test(input11, answer11));

        System.out.print(input12 + " = ");
        System.out.println(test(input12, answer12));

        System.out.print(input13 + " = ");
        System.out.println(test(input13, answer13));

        System.out.print(input14 + " = ");
        System.out.println(test(input14, answer14));

        System.out.print(input15 + " = ");
        System.out.println(test(input15, answer15));

        System.out.print(input16 + " = ");
        System.out.println(test(input16, answer16));

        System.out.print(input17 + " = ");
        System.out.println(test(input17, answer17));

        System.out.print(input18 + " = ");
        System.out.println(test(input18, answer18));

        System.out.print(input19 + " = ");
        System.out.println(test(input19, answer19));

        System.out.print(input20 + " = ");
        System.out.println(test(input20, answer20));

        System.out.print(input21 + " = ");
        System.out.println(test(input21, answer21));


        System.out.print(input22 + " = ");
        System.out.println(test(input22, answer22));

        System.out.print(input23 + " = ");
        System.out.println(test(input23, answer23));

        System.out.print(input24 + " = ");
        System.out.println(test(input24, answer24));

        System.out.print(input25 + " = ");
        System.out.println(test(input25, answer25));

        System.out.print(input26 + " = ");
        System.out.println(test(input26, answer26));

        System.out.print(input27 + " = ");
        System.out.println(test(input27, answer27));

        System.out.print(input28 + " = ");
        System.out.println(test(input28, answer28));

        System.out.print(input29 + " = ");
        System.out.println(test(input29, answer29));

        System.out.print(input30 + " = ");
        System.out.println(test(input30, answer30));
    }
}
