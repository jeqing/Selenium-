import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumExercise {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	System.setProperty("webdriver.gecko.driver","C:\\InstalledSoftware\\geckodriver.exe"); 
    driver = new FirefoxDriver();
    baseUrl = "http://www.gmail.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

//  @Test
  public void testSeleniumExercise() throws Exception {
    driver.get(baseUrl + "/");
//    assertEquals("Digital Transformation, Agile, Business Analysis, Software Testing, DevOps, Tools & Software Education | Assurity Consulting, NZ", driver.getTitle());
    assertEquals("Gmail", driver.getTitle());
  }
  
//  @Test
  public void testGoToWhyPage() {
	  driver.get(baseUrl + "/");
	  driver.findElement(By.linkText("Why")).click();
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  wait.until(ExpectedConditions.titleIs("Making a difference » Assurity"));
  }
  
  @Test
  public void testLogin() {
	  driver.get(baseUrl + "/");
	  driver.findElement(By.id("Email")).sendKeys("christina.kim@assurity.co.nz");
	  driver.findElements(By.id("next")).get(0).click();
	  WebDriverWait wait = new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.elementToBeClickable(By.id("Passwd")));
	  driver.findElement(By.id("Passwd")).sendKeys("tqtq1224");
	  driver.findElement(By.id("signIn")).click();
	  
  }

//  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
