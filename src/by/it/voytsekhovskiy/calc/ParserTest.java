package by.it.voytsekhovskiy.calc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParserTest {
    private VarCreator varCreator;
    private Parser parser;

    @Before
    public void setUp() {
        VarCreator varCreator = new VarCreator();
        this.parser = new Parser(varCreator);
    }

    @Test
    public void scalarTest() throws CalcException {
         /*
            A=2+5.3 (выведет на экран 7.3)
            B=A*3.5 (выведет на экран 25.55)
            B1=B+0.11*-5  (выведет на экран 25)
            B2=A/2-1 (выведет на экран 2.65)
        */
        scalarAssert("A=2+5.3", 7.3);
        scalarAssert("B=A*3.5", 25.55);
        scalarAssert("B1=B+0.11*-5", 25);
        scalarAssert("B2=A/2-1", 2.65);
        scalarAssert("C=B+(A*2)", 40.15);
        scalarAssert(" D=((C-0.15)-20)/(7-5)", 10);
        vectorAssert("E={2,3}*(D/2)", "{10,15}");

    }

    public void scalarAssert(String exp, double expected) throws CalcException {
        Var actualResult = parser.calc(exp);
        double actual = Double.parseDouble(actualResult.toString());
        Assert.assertEquals(expected, actual, 1e-10);
    }

    /*
        C=B+(A*2) (выведет на экран 40.15).
        D=((C-0.15)-20)/(7-5) (выведет на экран 10)
        E={2,3}*(D/2) (выведет на экран {10,15} ).
     */

    public void vectorAssert(String exp, String expected) throws CalcException {
        Var expectedVar = varCreator.createVar(expected);
        Var result = parser.calc(exp);
        Assert.assertEquals(expectedVar.toString(), result.toString());
    }
}