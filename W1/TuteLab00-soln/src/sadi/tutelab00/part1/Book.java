package sadi.tutelab00.part1;
public class Book
{
	// 1A
	private String borrowerID;
	private String bookId;
	private String title;
	private String author;
	
	// 1B
	public Book(String bookID, String title, String author)
	{
		this.bookId = bookID;
		this.title = title;
		this.author = author;
	}

	// 1C
	public String getBookId()
	{
		return bookId;
	}

	public String getTitle()
	{
		return title;
	}

	// 1D
	public boolean borrow(String borrowerID) 
	{
		if(this.borrowerID==null)
		{
			this.borrowerID=borrowerID;
			return true;
		}
		
		return false;
	}
	
	// method which allows the Book to be "returned" if it has been borrowed
	public boolean returnBook()
	{
		// if borrower ID has been set (ie. book has been borrowed)
		if (this.borrowerID != null)
		{
			// reset borrowerID to null and return true result
			this.borrowerID = null;
			return true;
		} else
		{
			// otherwise book is not currently borrowed so return false result
			return false;
		}
	}

	// format Book details to a String (useful for printing!)
	public String toString()
	{
		return String.format(
				"Book ID: %s\nTitle: %s\nAuthor: %s\nBorrowed by: %s\n",
				this.bookId, this.title, this.author,
				this.borrowerID != null ? this.borrowerID : "Available");
	}
}
