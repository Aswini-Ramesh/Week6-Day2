package Week5day2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AttributeTest extends BaseCl {
	    @Test(description="First TestCase CreatLead", invocationCount=3)
	     public void CreateLead() throws InterruptedException {
		 driver.findElement(By.linkText("Leads")).click();
		 driver.findElement(By.linkText("Create Lead")).click();
		 driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		 driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Haja");
		 driver.findElement(By.id("createLeadForm_lastName")).sendKeys("J");
		 driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Aswini");
		 driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Production");
		 driver.findElement(By.id("createLeadForm_description")).sendKeys("Production is the significant part of organization ");
		 driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("rameshsumathi003@gmail.com");
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
		     @Test(description="Third TestCase DeleteLead", priority=2)
		     public void DeleteLead() throws InterruptedException {
			 driver.findElement(By.linkText("Leads")).click();
			 driver.findElement(By.linkText("Find Leads")).click();
			 driver.findElement(By.xpath("//span[text()='Phone']")).click();
			 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			 Thread.sleep(2000);
			 driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
			 driver.findElement(By.xpath("//a[text()='Delete']")).click();
			 driver.findElement(By.linkText("Find Leads")).click();
			 driver.findElement(By.xpath("//input[@name='id']")).sendKeys("12605");
			 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
			 Thread.sleep(2000);
			 if(driver.findElement(By.className("x-paging-info")).isDisplayed()) {
					System.out.println("No Records to Display");
				}else {
					System.out.println("Records to Display");
				}
			 
	}           
		     @Test(description="Fourth TestCase DuplicateLead", dependsOnMethods= {"DeleteLead","EditLead"})
		 	    public void DuplicateLead() throws InterruptedException{
		 		 driver.findElement(By.linkText("Leads")).click();
		 		 driver.findElement(By.linkText("Find Leads")).click();
		 		 driver.findElement(By.xpath("//span[text()='Email']")).click();
		 		 driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("babu@testleaf.com");
		 		 driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		 		 Thread.sleep(2000);
		 		 driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		 		 driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		 		 driver.findElement(By.xpath("//a[text()='Duplicate Lead']")).click();
		 		 System.out.println("The Title is" +driver.getTitle());
		 		 driver.findElement(By.xpath("//input[@id='createLeadForm_companyName']")).getText();
		 		 driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		 		 driver.findElement(By.linkText("Find Leads")).click();
		 		 driver.findElement(By.xpath("//div[@id='x-form-el-ext-gen248']/input")).sendKeys("Babu");
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
		 		  
		 	
			   @Test(priority=1, description="Second TestCase EditLead", invocationCount=2)
		           public void EditLead() throws InterruptedException {
				     driver.findElement(By.linkText("Leads")).click();
					 driver.findElement(By.linkText("Find Leads")).click();
				     driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Babu");
				     driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
				     Thread.sleep(1000);
				     driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
				     System.out.println("The Title is:" + driver.getTitle());
				     driver.findElement(By.xpath("//a[text()='Edit']")).click();
				     driver.findElement(By.xpath("//input[@id='updateLeadForm_companyName']")).sendKeys("Live TestLeaf");
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
			   }

