package by.it.voytsekhovskiy.jd02_04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

abstract class Var implements Operation {
    static Map<String, Var> vars = new HashMap<>();

    static Var save(String key, Var value) {
        vars.put(key, value);
        return value;
    }

    static Var load(String key) {
        return vars.get(key);
    }

    static void getVar() {
        vars.entrySet().forEach(System.out::println);
    }

    static void sortVars() {
        vars.entrySet().forEach(System.out::println);
    }

    @Override
    public String toString() {
        return ("abstract Var");
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s + %s is impossible\n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s - %s is impossible\n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s * %s is impossible\n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Operation %s / %s is impossible\n", this, other));
    }

    static Var createVar(String strExp) throws CalcException {
        if (strExp.matches(Patterns.SCALAR)) {
            return new Scalar(strExp);
        } else if (strExp.matches(Patterns.VECTOR)) {
            return new Vector(strExp);
        } else if (strExp.matches(Patterns.MATRIX)) {
            return new Matrix(strExp);
        } else {
            Var var = Var.load(strExp);
            if(Objects.nonNull(var)) {
                return var;
            }
        }
        throw new CalcException("Can't define as Var!");
    }
}
