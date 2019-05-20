package fp.topic4.generic.media;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestLibrary
{
	public static void main(String args[])
	{
		// Library of Media can have subclasses
		Library<Media> mediaLib = new Library<Media>();
		mediaLib.add(new Video());
		mediaLib.add(new Book());

		List<Media> mediaList = new ArrayList<Media>();
		mediaList.add(new Video());
		mediaList.add(new Book());

		Iterator<Media> i = mediaList.iterator();
		while (i.hasNext())
		{
			Media media = i.next();
			media.print();
		}

		for (Media mm : mediaList)
			mm.print();

		Library<Book> myBooks = new Library<Book>();
		myBooks.add(new Book());
		// compiler won't allow us to accidentally add a Video
		// myBooks.add(new Video());
		Media lastBook = myBooks.retrieveLast();
		lastBook.print();

		Library<Video> myVideos = new Library<Video>();
		myVideos.add(new Video());
		myVideos.add(new Video());
		// myVideos.add(new Book());
		Video lastVideo = myVideos.retrieveLast();
		lastVideo.print();
	}
}
