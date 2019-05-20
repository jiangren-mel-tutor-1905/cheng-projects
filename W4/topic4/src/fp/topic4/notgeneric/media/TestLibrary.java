package fp.topic4.notgeneric.media;

public class TestLibrary
{
	public static void main(String args[])
	{
		Library myBooks = new Library();
		myBooks.add(new Book());
		myBooks.add(new Book());
		// accidentally put a video in the collection
		myBooks.add(new Video());
		Book last = (Book) myBooks.retrieveLast();
		// Media last = (Media) myBooks.retrieveLast();
		last.print();
	}
}