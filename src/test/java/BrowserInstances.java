import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.junit.UsePlaywright;

import java.lang.reflect.Array;
import java.util.Arrays;

@UsePlaywright
public class BrowserInstances {
    Playwright playwright;
    Browser browser = playwright.chromium().launch(
            new BrowserType.LaunchOptions()
                    .setArgs(Arrays.asList("--no-sandbox",
                            "--disable-gpu"))
    );
}
