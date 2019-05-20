package fp.topic3.multiple.java8;

// example of pseudo multiple implementation inheritance in Java 8 by Caspar
// class PseudoMultInheritanceClass inherits ImplementsInterfaceClass.foo() and InterfaceB.foo() and calls both!
public class PseudoMultInheritanceClass extends ImplementsInterfaceClass implements InterfaceB
{
   @Override
   // we have inherited two foo() methods!
   public void foo()
   {
      System.out.println("PseudoMultInheritanceClass.foo()");
      super.foo(); // ImplementInterfaceClass.foo() via InterfaceA
      InterfaceB.super.foo(); // InterfaceB.foo();
   }
}
