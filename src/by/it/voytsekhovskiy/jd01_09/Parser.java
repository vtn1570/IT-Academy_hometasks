package by.it.voytsekhovskiy.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        expression = expression.replace(" ", "");
        String[] operands = expression.split(Patterns.OPERATION);
        Var firstOperand = Var.createVar(operands[0]);
        Var secondOperand = Var.createVar(operands[1]);

        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if(m.find()) {
            String result = m.group();
            switch (result) {
                case ("+"):
                    return firstOperand.add(secondOperand);
                case("-"):
                    return firstOperand.sub(secondOperand);
                case("*"):
                    return firstOperand.mul(secondOperand);
                case("/"):
                    return firstOperand.div(secondOperand);
                default:
                    return null;
            }
        }
        return null;
    }
}
