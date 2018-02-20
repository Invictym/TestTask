package framework.browser;

import framework.utils.FileWorker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BrowserFactoru {

  private static WebDriver driver;
  private static FirefoxProfile profile;
  private static FirefoxOptions options = new FirefoxOptions();
  private static ChromeOptions optionsChrome = new ChromeOptions();
  private static Map<String, Object> prefs = new HashMap<>();
  private static FileWorker fileWorker = new FileWorker("config.properties");

  private BrowserFactoru() {}

  protected static WebDriver init() {
    String os = System.getProperty("os.name").toLowerCase();
    switch (fileWorker.getProperties("browser")) {
      case "chrome":
        if (os.indexOf("win") >= 0) {
          System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver.exe");
        } else {
          System.setProperty("webdriver.chrome.driver", "src/resources/chromedriver");
        }
        driver = new ChromeDriver(optionsChrome);
        driver.manage().window().maximize();
        break;
      case "firefox":
        if (os.indexOf("win") >= 0) {
          System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver.exe");
        } else {
          System.setProperty("webdriver.gecko.driver", "src/resources/geckodriver");
        }
        driver = new FirefoxDriver(options);
        break;
    }
    driver.manage().timeouts().implicitlyWait(Integer.parseInt(fileWorker.getProperties("timeout")), TimeUnit.SECONDS);
    return driver;
  }
}
