package by.it.voytsekhovskiy.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser calc = new Parser();
        Printer print = new Printer();
        for (; ; ) {
            String expression = sc.nextLine();
            if(!expression.equals("end")) {
                Var result = calc.calc(expression);
                print.print(result);
            } else{
                break;
            }
        }
    }
}
