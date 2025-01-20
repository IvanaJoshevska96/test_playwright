import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@UsePlaywright
public class SimplePlaywrightTest {
    @Test
    public void verifyPageTitleIsDisplayed(Page page) {
        page.navigate("https://practicesoftwaretesting.com/");
        String title = page.title();
        Assertions.assertTrue(title.contains("Practice"));
    }

    @Test
    void searchByKeyword(Page page) {
        page.navigate("https://practicesoftwaretesting.com/");
        page.locator("[placeholder=Search]").fill("Pliers");
        page.locator("button:has-text('Search')").click();
        int matchingSearchResults = page.locator(".card").count();
        Assertions.assertTrue(matchingSearchResults > 0);
    }
}
