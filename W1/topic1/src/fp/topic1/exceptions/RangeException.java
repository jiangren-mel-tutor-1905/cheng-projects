package fp.topic1.exceptions;

class RangeException extends Exception
{
   // constructors are not inherited
   RangeException()
   {
      super();
   }

   RangeException(String message)
   {
      super(message);
   }
}
