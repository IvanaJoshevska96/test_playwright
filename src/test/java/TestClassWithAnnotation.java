import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.junit.Options;
import com.microsoft.playwright.junit.OptionsFactory;
import com.microsoft.playwright.junit.UsePlaywright;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

@UsePlaywright(TestClassWithAnnotation.MyCustomOptions.class)
public class TestClassWithAnnotation {
    public static class MyCustomOptions implements OptionsFactory {
        @Override
        public Options getOptions() {
            return new Options()
                    .setHeadless(false)
                    .setLaunchOptions(
                            new BrowserType.LaunchOptions()
                                    .setArgs(Arrays.asList(
                                            "--disable-extensions"))
                    );
        }
    }

    @Test
    void searchForImage(Page page) {
        page.navigate("https://practicesoftwaretesting.com/");
        Locator bannerImage = page.locator("//img[@alt='Banner']");
        Assertions.assertTrue(bannerImage.isVisible());
    }
}
