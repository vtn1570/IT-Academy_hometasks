package by.it.voytsekhovskiy.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private final double[] value;

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double[] resultVector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                resultVector[i] = resultVector[i] + ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        }

        if (other instanceof Vector) {
            double[] secondVector = ((Vector) other).value;
            double[] resultVector = Arrays.copyOf(this.value, this.value.length);
            if (secondVector.length == resultVector.length) {
                for (int i = 0; i < resultVector.length; i++) {
                    resultVector[i] = resultVector[i] + secondVector[i];
                }
                return new Vector(resultVector);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double[] resultVector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < resultVector.length; i++) {
                resultVector[i] = resultVector[i] - ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        }
        if(other instanceof Vector) {
            double[] resultVector = Arrays.copyOf(this.value, this.value.length);
            double[] secondVector = ((Vector) other).value;
            if (secondVector.length == resultVector.length) {
                for (int i = 0; i < resultVector.length; i++) {
                    resultVector[i] = resultVector[i] - secondVector[i];
                }
                return new Vector(resultVector);
            }
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double[] resultVector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                resultVector[i] = resultVector[i] * ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        }
        if (other instanceof Vector) {
            double sum = 0;
            double[] secondVector = ((Vector) other).value;
            if (secondVector.length == this.value.length) {
                for (int i = 0; i < this.value.length; i++) {
                    sum+=this.value[i] * secondVector[i];
                }
            }
            return new Scalar(sum);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar) {
            if(((Scalar) other).getValue() == 0) {
                return super.add(other);
            }
            double[] resultVector = Arrays.copyOf(this.value, this.value.length);
            for (int i = 0; i < this.value.length; i++) {
                resultVector[i] = resultVector[i] / ((Scalar) other).getValue();
            }
            return new Vector(resultVector);
        }
        return super.div(other);
    }

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector otherVector) {
        this(otherVector.value); // вызов конструктора Vector(double[])
    }

    Vector(String strVector) {
        StringBuilder newStr = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(newStr);
        while (matcher.find()) {
            int start = matcher.start();
            newStr.deleteCharAt(start);
            matcher.reset();
        }

        String[] arrayFromString = newStr.toString().split(",");
        double[] doubleArray = new double[arrayFromString.length];
        for (int i = 0; i < arrayFromString.length; i++) {
            doubleArray[i] = Double.parseDouble(arrayFromString[i]);
        }
        this.value = doubleArray;
    }

    public double[] getValue() {
        return value;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{");
        for (int i = 0; i < value.length; i++) {
            resultString.append(value[i]);
            if (i != value.length - 1) {
                resultString.append(", ");
            }
        }
        resultString.append("}");
        return resultString.toString();
    }
}
