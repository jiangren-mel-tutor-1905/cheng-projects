package sadi.tutelab00.part1;

// TuteLab 00 solution by Caspar 2018
public class LibrarySystem
{
   public static void main(String[] args)
   {
      // 2A
      Book b1 = new Book("B001", "Divergent", "Veronica Roth");
      Book b2 = new Book("B002", "Green Eggs and Ham", "Dr Seuss");

      // used by 2E
      Book[] books = new Book[] { b1, b2 };

      // 2B
      System.out.printf("ID: %s, TITLE: %s\n", b1.getBookId(), b1.getTitle());
      System.out.printf("ID: %s, TITLE: %s\n", b2.getBookId(), b2.getTitle());

      // 2C
      System.out.printf("borrowed=%b\n", b1.borrow("m1234"));

      // 2D
      System.out.printf("Book %s\n", b1.returnBook() ? "returned" : "not on loan");

      // 2E
      System.out.println();
      for (Book book : books)
         System.out.println(book); // implicitly calls book.toString()!
   }
}
