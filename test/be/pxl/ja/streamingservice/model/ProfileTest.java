package be.pxl.ja.streamingservice.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest {
    private Profile profile;
    private Content content;

    @BeforeEach
    public void init() {
        profile = new Profile("test_profile");
        content = new Movie("test_movie", Rating.MATURE);
    }

    @Test
    public void contentShouldBeAddedToCurrentlyWatchingCollection() {
        profile.startWatching(content);

        int size = profile.getCurrentlyWatching().size();

        assertEquals(1, size);
    }

    @Test
    public void shouldNotContainDoublesInCurrentlyWatchingCollection() {
        profile.startWatching(content);
        profile.startWatching(content);
        profile.startWatching(new Movie("test_movie", Rating.MATURE));

        int size = profile.getCurrentlyWatching().size();

        assertEquals(1, size);
    }

    @Test
    public void shouldAddAtBeginningOfCurrentlyWatchingCollection() {
        profile.startWatching(new Movie("test_movie1", Rating.MATURE));
        profile.startWatching(new Movie("test_movie2", Rating.TEENS));
        profile.startWatching(content);

        assertEquals(content, profile.getCurrentlyWatching().getFirst());
    }

    @Test
    public void contentShouldBeRemovedFromCurrentlyWatchingCollection() {
        profile.startWatching(new Movie("test_movie1", Rating.MATURE));
        profile.startWatching(content);
        profile.startWatching(new Movie("test_movie2", Rating.TEENS));
        profile.finishWatching(content);

        int size = profile.getCurrentlyWatching().size();

        assertEquals(2, size);
    }

    @Test
    public void contentShouldBeAddedToRecentlyWatchedCollection() {
        profile.startWatching(content);
        profile.finishWatching(content);

        int size = profile.getRecentlyWatchted().size();

        assertEquals(1, size);
    }
}
