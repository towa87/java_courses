package javaqa.sandBox;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Антон on 20.08.2016.
 */
public class TestSquare {
  @Test
  public void testArea()

  { Square s = new Square(5);

    Assert.assertEquals(s.area(), 25.0);
  }
}
