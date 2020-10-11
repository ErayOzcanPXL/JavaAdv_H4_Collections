package be.pxl.ja;

import be.pxl.ja.streamingservice.model.Content;
import be.pxl.ja.streamingservice.model.Movie;
import be.pxl.ja.streamingservice.model.Rating;
import java.util.Set;
import java.util.HashSet;

public class HashSetDemoContentRepository {
    public static void main(String[] args) {
        ContentRepository contentRepository = new ContentRepository();
        Set<Content> contentSet = contentRepository.getContentSet();

        System.out.println(contentSet.size());
        contentSet.add(new Movie("Iron Fist", Rating.MATURE));
        System.out.println(contentSet.size());

        System.out.println(contentSet);
    }
}
