import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import java.util.Arrays;

public class SharedBrowserContext {
    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;

    Page page;

    @BeforeAll
    public static void setup() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions()
                        .setHeadless(false)
                        .setArgs(Arrays.asList(
                                "--no-sandbox"
                        ))
        );
        // page = browser.newPage();
        //instead of page here is defined browserContext instance
        browserContext = browser.newContext();

    }

    //and then for each test is defined new page
    @BeforeEach
    public void beforeEachTestSetupPage() {
        page = browserContext.newPage();
    }

    @AfterAll
    public static void teardown() {
        browser.close();
        playwright.close();
    }

    @Test
    public void checkIfSortOptionIsVisible() {
        page.navigate("https://practicesoftwaretesting.com/");
        Locator sortOption = page.locator("//h4[normalize-space()='Sort']");
        Assertions.assertTrue(sortOption.isVisible(), "The sort option is not visible on the page.");

    }

    @Test
    public void checkIfSortOptionIsCorrect() {
        page.navigate("https://practicesoftwaretesting.com/");
        Locator sortOption = page.locator("//h4[normalize-space()='Sort']");
        String text = sortOption.textContent();
        Assertions.assertEquals("Sort", text.trim(), "The text of the element is not as expected!");
    }
}
