package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;

@Listeners(com.comcast.crm.ListnerUtility.ListnerImpClass.class)
public class SampleListner extends BaseClass{

	@Test()
	public void sampleTest() {
		
		System.out.println("execute sampleTest");
		String title = driver.getTitle();
		Assert.assertEquals(title, "Administrator");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	
}
