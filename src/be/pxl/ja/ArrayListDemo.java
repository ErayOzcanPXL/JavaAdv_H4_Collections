package be.pxl.ja;

import be.pxl.ja.streamingservice.model.Content;
import be.pxl.ja.streamingservice.model.Documentary;
import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;
import be.pxl.ja.streamingservice.model.TVShow;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListDemo {

	public static void main(String[] args) {
		List<Content> contentList = new ContentRepository().getContentList();

		System.out.println("Size before: " + contentList.size());
		Iterator<Content> contentIterator = contentList.iterator();

		while (contentIterator.hasNext()) {
			Content content = contentIterator.next();

			if (content.getImageUrl() == null) {
				contentIterator.remove();
			}
		}

		System.out.println("Size after: " + contentList.size());
	}
}
