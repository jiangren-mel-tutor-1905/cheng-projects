package fp.topic3.delegation;

// Advanced Example for FP
// demonstrate delegation to simulate multiple inheritance
// Author: Caspar Ryan 

// unused variables are intentional so suppress warnings
@SuppressWarnings("unused")
public class TestDelegation
{
   public static void main(String[] args)
   {
      // create an instance of ConcreteC (which implements A and B interfaces)
      ConcreteC c = new ConcreteC();

      // C is an A and a B so we can call both method_a() and method_b() and
      // get the default implementations from AbstractA and AbstractB respectively
      System.out.println(c.method_a());
      System.out.println(c.method_b());

      // note we can assign variable c to A, B, AbstractA but not AbstractB
      // this is not a problem since we expect to call through interface rather than Abstract types anyway

      A a = c;
      AbstractA aa = c;
      B b = c;
      //AbstractB ab=c; // compile error
   }

}
