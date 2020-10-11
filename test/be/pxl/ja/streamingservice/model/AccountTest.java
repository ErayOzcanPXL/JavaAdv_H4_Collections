package be.pxl.ja.streamingservice.model;

import be.pxl.ja.streamingservice.exception.TooManyProfilesException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AccountTest {
    private Account account;

    @BeforeEach
    public void init() {
        account = new Account("test@test.com", "T3stPassword");
        account.setStreamingPlan(StreamingPlan.PREMIUM);
    }

    @Test
    public void shouldReturnProfile() {
        Profile profile = account.getProfile("Profile1");

        assertNotNull(profile);
    }

    @Test
    public void shouldAddProfile() {
        account.addProfile(new Profile("Profile2"));
        Profile profile = account.getProfile("Profile2");

        assertNotNull(profile);
    }

    @Test
    public void shouldThrowTooManyProfilesException() {
        account.addProfile(new Profile("Profile2"));
        account.addProfile(new Profile("Profile3"));
        account.addProfile(new Profile("Profile4"));

        assertThrows(TooManyProfilesException.class, () -> {
            account.addProfile(new Profile("Profile5"));
        });
    }
}
