package sandBox;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.Equation;

/**
 * Created by Антон on 28.08.2016.
 */
public class EquationTests {
    @Test
    public void equationTest(){
      Equation quation = new Equation(1.0, 1.0 , 1.0);
      Assert.assertEquals(quation.rootNumber(),0);
    }

    @Test
    public void equationTest1() {
      Equation quation = new Equation(1.0, 2.0, 1.0);
      Assert.assertEquals(quation.rootNumber(), 1);
    }


      @Test
      public void equationTest2() {
        Equation quation = new Equation(1.0, 5.0, 1.0);
        Assert.assertEquals(quation.rootNumber(), 2);
      }
  @Test
  public void testLinear() {
    Equation quation = new Equation(0, 1.0, 1.0);
    Assert.assertEquals(quation.rootNumber(), 1);
  }
  @Test
  public void testConstant() {
    Equation quation = new Equation(0, 0, 1.0);
    Assert.assertEquals(quation.rootNumber(), 0);
  }
  @Test
  public void testZerro() {
    Equation quation = new Equation(0, 0, 0);
    Assert.assertEquals(quation.rootNumber(), -1);
  }
    }
