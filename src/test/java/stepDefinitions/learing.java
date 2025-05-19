//package stepDefinitions;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.time.Duration;
//import java.util.Scanner;
//
//import org.apache.pdfbox.pdmodel.PDDocument;
//import org.apache.pdfbox.text.PDFTextStripper;
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//import utility.WebScrollUtils;
//
//public class learing {
//	private  WebDriver driver;
//    protected static WebDriverWait wait;
//    private JavascriptExecutor js;
//    
//    
//    
//	private By usernameField  = By.xpath("//input[@aria-label='Email']");
//    private By passwordField  = By.xpath("//input[@aria-label='Password']");
//    private By loginButton  = By.xpath("//flt-semantics[@aria-label='LOGIN']");
//    
////    String URL = "http://localhost:59822/#/login";
//    String URL = "https://app.checktrack.dev/#/login";
//    String IDpass = "asfdgzq345df@yopmail.com";
//    
//    @BeforeMethod
//    public void before() throws InterruptedException {
//    	driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        
//        driver.get(URL);
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//       	
//           WebElement userField = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
//           driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//           Thread.sleep(3000);
//           userField.sendKeys(IDpass);
//           Thread.sleep(1000);
//
//           
//           WebElement passField = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
//           passField.sendKeys(IDpass);
//           Thread.sleep(2000);
//           
//           WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//           loginBtn.click();
//           Thread.sleep(3000);
//           driver.findElement(By.xpath("//flt-semantics[@aria-label='Open navigation menu']")).click();Thread.sleep(1000);
//    }
//    @AfterMethod
//    public void after() throws InterruptedException {
//    	driver.quit();
//    }
//    	@Test
//    	public void Valid_teamMemberName() throws InterruptedException {
//	    driver.findElement(By.xpath("//flt-semantics[@aria-label='Team members']")).click();Thread.sleep(1000);
//        driver.findElement(By.xpath("(//flt-semantics[@role='img'])[5]")).click();Thread.sleep(1000);
//        driver.findElement(By.xpath("(//flt-semantics[@role='img'])[2]")).click();
//        String name= driver.findElement(By.xpath("(//input[@data-semantics-role='text-field'])[1]")).getDomAttribute("aria-label");
////        System.out.println("Full Name: "+name);
//        String firstWord = name.split("\\s+")[0];
//        System.out.println("First word: " + firstWord);
//        }
//    	
//    	@Test
//        public void reportValidation() throws FileNotFoundException, InterruptedException {
//    		WebElement report= driver.findElement(By.xpath("//flt-semantics[@aria-label='Reports']"));
//    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", report);
//    		report.click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("//flt-semantics[@aria-label='Timesheet report']")).click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("//flt-semantics[@aria-label='DOWNLOAD']")).click();Thread.sleep(1000);
//    		
//            File file = new File("D:\\Download\\timesheet_report_2025-04-27_2025-05-03");
//            Scanner scanner = new Scanner(file);
//
//            boolean isFirstLine = true;
//
//            while (scanner.hasNextLine()) {
//                String line = scanner.nextLine();
//                if (isFirstLine) {
//                    isFirstLine = false; // Skip header
//                    continue;
//                }
//
//                // Split using TAB character \t
//                String[] values = line.split("\t");
//
//                // Validation: Paid Leave Balance should be 49
//                String employeeName = values[0].trim();
//                int paidLeaveBalance = Integer.parseInt(values[3].trim()); // 4th column (index 3)
//
//                System.out.println("Employee: " + employeeName + ", Paid Leave Balance: " + paidLeaveBalance);
//
//                Assert.assertEquals(paidLeaveBalance, 49, "Paid Leave Balance is incorrect for " + employeeName);
//            }
//
//            scanner.close();
//        }
//    	@Test
//        public void readPDFContentTest() throws IOException, InterruptedException {
////    		WebElement report= driver.findElement(By.xpath("//flt-semantics[@aria-label='Payslips']"));
////    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", report);
////    		report.click();Thread.sleep(1000);
////    		driver.findElement(By.xpath("//input[@aria-label='Select month']")).click();Thread.sleep(1000);
////    		driver.findElement(By.xpath("(//flt-semantics[@role='text'])[1]")).click();Thread.sleep(1000);
////    		driver.findElement(By.xpath("//flt-semantics[@aria-label='OK']")).click();Thread.sleep(1000);
////    		driver.findElement(By.xpath("(//flt-semantics[@role='button'])[3]")).click();Thread.sleep(1000);
//    		
////    		String sucessmessage = driver.findElement(By.xpath("")).getText(); //sucess xpath not present 
////    		Assert.assertEquals(sucessmessage, "");
//    		
//        	File file = new File("D:\\Download\\payslip_September_2025 (2).pdf"); // for pass
////    		File file = new File("D:\\Download\\payslip_January_2025.pdf"); // for fail
//
//            // Load the PDF document
//            PDDocument document = PDDocument.load(file);
//
//            // Extract text
//            PDFTextStripper pdfStripper = new PDFTextStripper();
//            String pdfText = pdfStripper.getText(document);
//
//            // Split the PDF text into lines
//            String[] lines = pdfText.split("\\r?\\n");
//
//            // Store each line into variables
//            String companyName = lines[0].trim();
//            String address = lines[1].trim();
//            String payslipHeader = lines[2].trim();
//            String monthYear = lines[3].trim();
//            String employeeSummary = lines[4].trim();
//            String employeeNameLabel = lines[5].trim();
//            String jobTitleLabel = lines[6].trim();
//            String dateOfJoiningLabel = lines[7].trim();
//            String payPeriodLabel = lines[8].trim();
//            String processedOnLabel = lines[9].trim();
//            String employeeName = lines[10].replace(":", "").trim();
//            String jobTitle = lines[11].replace(":", "").trim();
//            String dateOfJoining = lines[12].replace(":", "").trim();
//            String payPeriod = lines[13].replace(":", "").trim();
//            String processedOn = lines[14].replace(":", "").trim();
//            String inHandPayLabel = lines[15].trim();
//            String inHandPayAmount = lines[16].trim();
//
//            // Validate parts
//            Assert.assertEquals(companyName, "Mahiraj Tech");
//            Assert.assertEquals(address, "Mumbai, Maharashtra, India, Fayzabad, Badakhshan, Afghanistan, 123456");
//            Assert.assertEquals(payslipHeader, "Pay slip for the month");
//            Assert.assertEquals(monthYear, "September, 2025");
//            Assert.assertEquals(employeeSummary, "Employee Summary");
//            Assert.assertEquals(employeeNameLabel, "Employee name");
//            Assert.assertEquals(jobTitleLabel, "Job title");
//            Assert.assertEquals(dateOfJoiningLabel, "Date of joining");
//            Assert.assertEquals(payPeriodLabel, "Pay period");
//            Assert.assertEquals(processedOnLabel, "Processed on");
//            Assert.assertEquals(employeeName, "Atul Patil");
//            Assert.assertEquals(jobTitle, "1");
//            Assert.assertEquals(dateOfJoining, "01/04/2025");
//            Assert.assertEquals(payPeriod, "September, 2025");
//            Assert.assertEquals(processedOn, "30/04/2025");
//            Assert.assertEquals(inHandPayLabel, "In Hand Pay");
//            Assert.assertEquals(inHandPayAmount, "Rs.1,667.00");
//        }
//    	
//    		
//    		
//    	
//    	@Test
//    	public void color() throws InterruptedException {
//    		driver.findElement(By.xpath("//flt-semantics[@aria-label='Tasks']")).click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("//flt-semantics[@aria-label='ADD TASK']")).click();Thread.sleep(1000);
//    		WebElement scrollable= driver.findElement(By.xpath("//flt-semantics[@aria-label='Selected color No color selected']"));
//    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", scrollable);
//    		scrollable.click();Thread.sleep(1000);
//    		
//    		WebElement colorInput =driver.findElement(By.xpath("//flt-semantics[@aria-label='Color selection slider. Drag your finger to pick a color.\n"
//    				+ "R\n"
//    				+ "0\n"
//    				+ "G\n"
//    				+ "0\n"
//    				+ "B\n"
//    				+ "0']"));Thread.sleep(1000);
//    				
//    				
//
//    				// Move to the color palette and click at a specific offset
////    				Actions actions = new Actions(driver);
////    				actions.moveToElement(colorInput, 50, 30).click().build().perform();
//    				
//    				JavascriptExecutor js = (JavascriptExecutor) driver;
//    				js.executeScript("document.getElementById('colorInput').value = 'rgb(255, 99, 71)';");
//    				
//    				Thread.sleep(5000);
//    				
//    				
//    		
//    	}
//    	
//    	@Test
//        public void timezoneselection() throws InterruptedException {
//    		WebScrollUtils.setDriver(driver);
//    		driver.findElement(By.xpath("//flt-semantics[@aria-label='Organization settings']")).click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("(//flt-semantics[@role='button'])[4]")).click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("(//flt-semantics[@role='button'])[4]")).click();Thread.sleep(1000);
//    		
//    		 WebElement dropdown = driver.findElement(By.xpath("//input[@aria-label='Search']"));
////    	        dropdown.click();
//    	        Thread.sleep(1000); // Wait for dropdown to open
//
//    	        // 2. Use keyboard actions to navigate
//    	        Actions actions = new Actions(driver);
//
//    	        // You can press DOWN multiple times to reach desired timezone
//    	        for (int i = 0; i < 5; i++) {  // adjust i based on where your timezone is
//    	            actions.sendKeys(Keys.ARROW_DOWN).perform();
//    	            Thread.sleep(300);  // wait for UI to update
//    	        }
//
//    	        // 3. Press ENTER to select the highlighted timezone
//    	        actions.sendKeys(Keys.ENTER).perform();
//
//    	        // Optional: confirm selection or submit form
//    	        Thread.sleep(1000);
//    	        driver.quit();
//
//    		
//    		
//    		
//    	    }
//    	@Test
//    	public void checkbox() throws InterruptedException {
//    		driver.findElement(By.xpath("//flt-semantics[@aria-label='Leave management']")).click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("(//flt-semantics[@aria-label='Modify leave balances']/flt-semantics-container/flt-semantics)[2]")).click();Thread.sleep(1000);
//    		
//    		
//    		driver.findElement(By.xpath("//flt-semantics[@aria-label='fgd wsdgf']")).click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("//flt-semantics[@aria-label='Paid Leave']")).click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("(//flt-semantics[@role='button'])[2]")).click();Thread.sleep(1000);
//    		driver.findElement(By.xpath("(//flt-semantics[@aria-label='Set'])")).click();Thread.sleep(1000);
//    		
//    		 WebElement dropdown =driver.findElement(By.xpath("(//input[@data-semantics-role='text-field'])[2]"));
//    		 dropdown.clear();
//    		 dropdown.sendKeys("1");
//    		Thread.sleep(1000);
//    		
//    		driver.findElement(By.xpath("//input[@aria-label='Search team member']")).sendKeys("Tushar");
//    		Thread.sleep(1000);
//    		
//    	}
//    	
//    	
//    	
//    	
//}
