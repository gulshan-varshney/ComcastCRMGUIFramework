package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.BaseTest.BaseClass;

public class RetryAnalyzerSample extends BaseClass {

	@Test(retryAnalyzer = com.comcast.crm.ListnerUtility.RetryImpClass.class)
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
