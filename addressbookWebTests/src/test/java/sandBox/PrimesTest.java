package sandBox;

import org.testng.Assert;
import org.testng.annotations.Test;
import sandbox.Primes;

/**
 * Created by Антон on 03.09.2016.
 */
public class PrimesTest {
  @Test
  public void testPrime(){
    Assert.assertTrue(Primes.isPrime(Integer.MAX_VALUE));
  }

  @Test
  public void testnonPrime(){
    Assert.assertFalse(Primes.isPrime(Integer.MAX_VALUE - 2));
  }
  @Test
  public void testPrimeLong(){
    long n = Integer.MAX_VALUE;
    Assert.assertTrue(Primes.isPrime(n));}
    @Test
    public void testPrimeFast(){
     int n = Integer.MAX_VALUE;
      Assert.assertTrue(Primes.isPrimeFast(n));
    }

}
