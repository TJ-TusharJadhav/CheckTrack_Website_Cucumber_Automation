package base;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.DashboardPage;
import pages.Forgot_passwordPage;
import pages.LeaveTypesPage;
import pages.LoginPage;
import pages.OrganizationSettingPage;
import pages.ReimbursementPage;
import pages.Team_membersPage;
import pages.TimelinePage;
import utility.Calender;
import utility.Timemethod;

public class BaseClass {
	protected static WebDriver driver;
    protected static WebDriverWait wait;
    public static LoginPage loginPage;
    public static OrganizationSettingPage OrganizationSetting;
    public static DashboardPage Dashboard;
    public static LeaveTypesPage LeaveTypes;
    public static Team_membersPage team;
    public static Calender date;
    public static Timemethod time;
    public static ReimbursementPage Reimbursement;
    public static TimelinePage Timeline;
    public static JavascriptExecutor js;
    public static Forgot_passwordPage forgot;
    public String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());

    public static void initializeDriver() {
//        if (driver == null) { 
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            
            driver.get("https://app.checktrack.dev/#/login");
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            
            
             loginPage = new LoginPage();
             OrganizationSetting = new OrganizationSettingPage();
        	 Dashboard = new DashboardPage();
        	 LeaveTypes =new LeaveTypesPage();
        	 team = new Team_membersPage();
        	 date = new Calender();
        	 time= new Timemethod();
        	 Reimbursement = new ReimbursementPage();
        	  forgot= new Forgot_passwordPage();
        	 
        	 Timeline = new TimelinePage();
        	 js = (JavascriptExecutor) driver;
//        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;  // Avoid memory leaks
            wait = null;    // Reset WebDriverWait
        }
        
       
    }
}