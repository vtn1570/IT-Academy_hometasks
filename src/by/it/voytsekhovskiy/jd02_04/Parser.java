package by.it.voytsekhovskiy.jd02_04;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression) throws CalcException {
        return checkingBrackets(expression);
    }

    Var checkingBrackets(String expression) throws CalcException {
        StringBuilder sb = new StringBuilder(expression);
        Matcher matcher = Pattern.compile(Patterns.BRACKETS).matcher(sb);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            Var result = checkingBrackets(sb.substring(start + 1, end - 1));
            sb.replace(start, end, result.toString());
            matcher.reset(); // ??
        }
        return calcExpression(sb.toString());
    }

    Var calcExpression(String expression) throws CalcException {
        expression = expression.replace(" ", "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Matcher matcher = Pattern.compile(Patterns.OPERATION).matcher(expression);
        while (matcher.find()) {
            operations.add(matcher.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String left = operands.remove(index);
            String right = operands.remove(index);
            Var result = oneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return Var.createVar(operands.get(0));
    }

    Map<String, Integer> priorityOfOperation = new HashMap<>() {{
        this.put("=", 0);
        this.put("+", 1);
        this.put("-", 1);
        this.put("*", 2);
        this.put("/", 2);
    }};

    private int getIndex(List<String> operations) {
        int index = -1;
        int best = -1;
        for (int i = 0; i < operations.size(); i++) {
            int priorityValue = priorityOfOperation.get(operations.get(i));
            if (priorityValue > best) {
                index = i;
                best = priorityValue;
            }
        }
        return index;
    }

    Var oneOperation(String left, String operation, String right) throws CalcException {
        operation = operation.replace(" ", "");
        if (operation.equals("=")) {
            return Var.save(left, Var.createVar(right));
        }
        Var firstOperand = Var.createVar(left);
        Var secondOperand = Var.createVar(right);
        switch (operation) {
            case ("+"):
                return firstOperand.add(secondOperand);
            case ("-"):
                return firstOperand.sub(secondOperand);
            case ("*"):
                return firstOperand.mul(secondOperand);
            case ("/"):
                return firstOperand.div(secondOperand);
            default:
                throw new CalcException("Something wrong");
        }

    }
}
