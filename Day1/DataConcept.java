package Week6.Day1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataConcept extends BaseL {
	@Test(dataProvider="CreateLead")
    public void CreateLead(String CN, String FN, String LN, String FNL, String DN, String DES, String Email) throws InterruptedException {
	 driver.findElement(By.linkText("Leads")).click();
	 driver.findElement(By.linkText("Create Lead")).click();
	 driver.findElement(By.id("createLeadForm_companyName")).sendKeys(CN);
	 driver.findElement(By.id("createLeadForm_firstName")).sendKeys(FN);
	 driver.findElement(By.id("createLeadForm_lastName")).sendKeys(LN);
	 driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys(FNL);
	 driver.findElement(By.id("createLeadForm_departmentName")).sendKeys(DN);
	 driver.findElement(By.id("createLeadForm_description")).sendKeys(DES);
	 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys(Email);
	 WebElement ele= driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
	 Select dd =new Select(ele);
	 dd.selectByVisibleText("New York");
	 driver.findElement(By.className("smallSubmit")).click();
	 driver.findElement(By.linkText("Edit")).click();
	 driver.findElement(By.id("updateLeadForm_description")).clear();
	 driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("Lead Created Sucessfully");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	 System.out.println("The Title is:" + driver.getTitle());
		
   }
	     @Test(dataProvider="DeleteLead")
	     public void DeleteLead(String Val) throws InterruptedException {
		 driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.linkText("Find Leads")).click();
		 driver.findElement(By.xpath("//span[text()='Phone']")).click();
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		 driver.findElement(By.xpath("//a[text()='Delete']")).click();
		 driver.findElement(By.linkText("Find Leads")).click();
		 driver.findElement(By.xpath("//input[@name='id']")).sendKeys(Val);
		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 Thread.sleep(2000);
		 if(driver.findElement(By.className("x-paging-info")).isDisplayed()) {
				System.out.println("No Records to Display");
			}else {
				System.out.println("Records to Display");
			}
		 
}           
	     @Test(dataProvider="DuplicateLead")
	 	    public void DuplicateLead(String Email, String Name) throws InterruptedException{
	 		 driver.findElement(By.linkText("Leads")).click();
	 		 driver.findElement(By.linkText("Find Leads")).click();
	 		 driver.findElement(By.xpath("//span[text()='Email']")).click();
	 		 driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys(Email);
	 		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	 		 Thread.sleep(2000);
	 		 driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	 		 driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
	 		 driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
	 		 System.out.println("The Title is" +driver.getTitle());
	 		 driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).getText();
	 		 driver.findElement(By.xpath("//input[@name='submitButton']")).click();
	 		 driver.findElement(By.linkText("Find Leads")).click();
	 		 driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen248']/input")).sendKeys(Name);
	 		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	 		 Thread.sleep(1000);
	 		 if(driver.findElement(By.xpath("//div[@class='x-paging-info']")).isDisplayed())
	 		 {
	 			 
	 			 System.out.println("Displaying Duplicate Records");
	 		 }
	 		 else {
	 			 System.out.println("Displaying one records only");
	 			  }
	     }
	 		  
	 	
		   @Test(dataProvider="EditLead")
	           public void EditLead(String NM, String CN) throws InterruptedException {
			     driver.findElement(By.linkText("Leads")).click();
				 driver.findElement(By.linkText("Find Leads")).click();
			     driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys(NM);
			     driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			     Thread.sleep(1000);
			     driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			     System.out.println("The Title is:" + driver.getTitle());
			     driver.findElement(By.xpath("//a[text()='Edit']")).click();
			     driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys(CN);
			     driver.findElement(By.xpath("//input[@class='smallSubmit'][1]")).click();
			     driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		   }		 			
			
		   @Test(enabled=false)
		   public void MergeContact() throws InterruptedException {
		   	driver.findElement(By.linkText("Contacts")).click();
		   	driver.findElement(By.linkText("Merge Contacts")).click();
		   	System.out.println(driver.getTitle());
		   	//1st icon * 7. Click on Widget of From Contact
		   	Thread.sleep(2000);
		   	driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		   	Set<String> windowHandles = driver.getWindowHandles();
		   	List<String> newWindow=new ArrayList<String>(windowHandles);
		   	driver.switchTo().window(newWindow.get(1));
		   	Thread.sleep(2000);
		   	//		 8. Click on First Resulting Contact
		   	driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		   	driver.switchTo().window(newWindow.get(0));
		   	//		//1st icon * 9. Click on Widget of To Contact
		   	Thread.sleep(2000);
		   	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		   	Set<String> windowHandles1 = driver.getWindowHandles();
		   	List<String> newWindow1=new ArrayList<String>(windowHandles1);
		   	driver.switchTo().window(newWindow1.get(1));
		   	//    * 10. Click on Second Resulting Contact
		   	Thread.sleep(2000);
		   	driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a[@class='linktext'])[2]")).click();
		   	driver.switchTo().window(newWindow1.get(0));
		   	//		 * 11. Click on Merge button using Xpath Locator
		   	driver.findElement(By.xpath("//a[text()='Merge']")).click();
		   	//		 * 12. Accept the Alert
		   	Alert alert = driver.switchTo().alert();
		   	alert.accept();
		   	String title = driver.getTitle();
		   	System.out.println(title);
		   	System.out.println("Merge Contact");
		   }
		   @DataProvider(name="CreateLead")
		   public String[][] data() throws IOException {
			   return ReadExcel.readData("Book1");			   
		   }
		   @DataProvider(name="EditLead")
		   public String[][] fetch() throws IOException {
			   return ReadExcel.readData1();			   
		   }
		   @DataProvider(name="DeleteLead")
		   public String[][] deleteData() throws IOException {
			   return ReadExcel.readData2();			   
		   }
		   @DataProvider(name="DuplicateLead")
		   public String[][] DuplicateData() throws IOException {
			   return ReadExcel.readData4();			   
		   }

}
