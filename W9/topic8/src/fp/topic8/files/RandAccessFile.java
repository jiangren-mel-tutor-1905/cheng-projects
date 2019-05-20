package fp.topic8.files;

import java.io.IOException;
import java.io.RandomAccessFile;

// original author unknown, modified by Caspar
// NOTE: We couldn't call this class RandomAccessFile.java since it conflicts with an import!
public class RandAccessFile
{
   public static void main(String[] args) throws IOException
   {
      // we use .dat to indicate this is not a text file (naming convention only)
      try (RandomAccessFile rafile = new RandomAccessFile("random.dat", "rw"))
      {
         final int[] SOME_INTS = new int[] { 1, 2, 3 };
         // writing NUM_INTS int elements to array
         for (int num : SOME_INTS)
            rafile.writeInt(num); // each int occupies Integer.BYTES (Integer.BYTES) in the file

         // reading and updating values (using Integer.BYTES for positioning)
         // move from end of file (current position) to start of previous integer
         rafile.seek(rafile.getFilePointer() - Integer.BYTES);
         // read and update the value (+TEST_INCREMENT)
         final int ARBITRARY_INCREMENT = 20;
         int last = rafile.readInt() + ARBITRARY_INCREMENT;
         // move back and overwrite last value
         rafile.seek(rafile.getFilePointer() - Integer.BYTES);
         rafile.writeInt(last);

         // back to the start of the file to print all
         rafile.seek(0);
         for (int i = 0; i < SOME_INTS.length; i++)
            System.out.println(rafile.readInt());
      }
      // throw exceptions to console .. maybe you didn't know you could do a try without a catch ;)
   }
}
