package fp.topic4.generic.pair;

// refactored by Caspar
// the pairs must contain Comparable objects and are also themselves comparable to other pairs of the same type
public class ComparablePair<T extends Comparable<T>> implements Comparable<ComparablePair<T>>
{
   private T first;
   private T second;

   public ComparablePair(T first, T second)
   {
      this.first = first;
      this.second = second;
   }

   public T max()
   {
      if (first.compareTo(second) >= 0)
         return first;
      else
         return second;
   }

   @Override
   // NOTE: unlike Object.equals() compareTo() is parameterized
   public int compareTo(ComparablePair<T> otherPair)
   {
      return first.compareTo(otherPair.first) + second.compareTo(otherPair.second);
   }

   @Override
   public String toString()
   {
      return String.format("<%s,%s>", first, second);
   }
}
