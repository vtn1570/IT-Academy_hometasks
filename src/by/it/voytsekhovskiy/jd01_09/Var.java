package by.it.voytsekhovskiy.jd01_09;

abstract class Var implements Operation {

    static Var createVar(String strExp) {
        if (strExp.matches(Patterns.SCALAR)) {
            return new Scalar(strExp);
        } else if (strExp.matches(Patterns.VECTOR)) {
            return new Vector(strExp);
        } else if (strExp.matches(Patterns.MATRIX)) {
            return new Matrix(strExp);
        }
        return null; //TODO change to error
    }

    @Override
    public String toString() {
        return ("abstract Var");
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s is impossible\n", this, other);
        return null; //TODO replace throw exception
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s is impossible\n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s is impossible\n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s is impossible\n", this, other);
        return null;
    }
}
