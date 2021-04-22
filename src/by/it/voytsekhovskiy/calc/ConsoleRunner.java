package by.it.voytsekhovskiy.calc;


import java.util.Scanner;

public class ConsoleRunner {
    static Language language = Language.INSTANCE;
    static Logger logger = Logger.INSTANCE;
    static VarCreator varCreator = new VarCreator();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parser calc = new Parser(varCreator);
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
