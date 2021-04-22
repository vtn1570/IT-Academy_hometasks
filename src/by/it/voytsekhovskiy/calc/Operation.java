package by.it.voytsekhovskiy.calc;

interface Operation {

    Var add(Var other) throws Exception;

    Var sub(Var other) throws CalcException;

    Var mul(Var other) throws CalcException;

    Var div(Var other) throws CalcException;
}