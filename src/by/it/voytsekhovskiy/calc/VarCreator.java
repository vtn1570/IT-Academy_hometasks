package by.it.voytsekhovskiy.calc;

import java.util.Objects;

public class VarCreator {
    Var createVar(String strExp) throws CalcException {
        strExp = strExp.replace(" ", "");
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
        throw new CalcException(ConsoleRunner.logger.log("Can't define as Var!"));
    }
}
