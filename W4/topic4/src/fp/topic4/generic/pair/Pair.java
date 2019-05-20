package fp.topic4.generic.pair;

//refactored by Caspar
public class Pair<T>
{
   private T first;
   private T second;

   public Pair(T first, T second)
   {
      this.first = first;
      this.second = second;
   }

   @Override
   public boolean equals(Object otherObject)
   {
      // NOTE: due to type erasure pair<X> and pair <Y> are the same type
      // which means we can compare to any other type of pair using equals()
      if (otherObject == null || (otherObject != null && getClass() != otherObject.getClass()))
         return false;
      // wildcard avoids unchecked cast warning
      Pair<?> otherPair = (Pair<?>) otherObject;
      return (first.equals(otherPair.first) && second.equals(otherPair.second));
   }

   // this is especially important if you want to use a Pair<> as a
   // key in a Map or Set .. the type of the pair elements can also override equals and
   // hashCode for more flexible comparison
   @Override
   public int hashCode()
   {
      // equals() uses first and second attributes so this hashCode() impl is compatible
      return (first != null ? first.hashCode() : 0) + (second != null ? second.hashCode() : 0);
   }

   // ADVANCED: This causes type erasure error (since generics are compile
   // time) with method below .. see
   // http://docs.oracle.com/javase/tutorial/java/generics/erasure.html
   // public boolean equals(Pair<?> otherPair)
   // {
   // if (otherPair == null)
   // return false;
   // return (first.equals(otherPair.first) && second
   // .equals(otherPair.second));
   // }

   // a stricter equals where we can only compare to a pair of the same <T> type
   // (since it is checked at compile time)
   // note this is NOT an override and uncommenting following line causes compile error
   // @Override
   public boolean equals(Pair<T> otherPair)
   {
      return (otherPair == null) ? false
         : (first.equals(otherPair.first) && second.equals(otherPair.second));
   }
}
