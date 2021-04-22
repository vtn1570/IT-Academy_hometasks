package by.it.voytsekhovskiy.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser calc = new Parser();
        Printer print = new Printer();
        for (; ; ) {
            String expression = sc.nextLine();
            if (!expression.equals("end")) {
                if(expression.equals("printvar")) {
                    Var.getVar();
                    continue;
                }
                if(expression.equals("sortvar")) {
                    Var.sortVars();
                    continue;
                }
                try {
                    Var result = calc.calc(expression);
                    print.print(result);
                } catch (CalcException e) {
                    print.print(e);
                }
            } else {
                break;
            }
        }
    }
}
