import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class TutorialsPointTest{

    public ChromeDriver webDriver;

    @Before
    public void setUp() {
        System.setProperty("webserver.chrome.driver", "C:\\Programs\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://www.tutorialspoint.com");
    }

    @Test
    public void verifyTitle() {
        System.out.println("In Verify Title Test Case");
        String title = webDriver.getTitle();
        Assert.assertTrue(title.contains("Library"));
    }

    @Test
    public void verifyHeading(){
        System.out.println("In Verify Heading Text Above Search Test Case");
        String expectedHeading = "Simply Easy Learning at your fingertips";
        String actualHeading = webDriver.findElement(By.xpath("/html/body/main/section[1]/div/div/div[1]/h1")).getText();
        Assert.assertEquals(expectedHeading, actualHeading);
    }

    @After
    public void closeWebDriver() throws InterruptedException {
        Thread.sleep(5000);
        webDriver.quit();
    }
}
