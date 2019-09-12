package com.qa.Utilities;




	

	import java.io.FileNotFoundException;

	import org.testng.ITestContext;
	import org.testng.ITestListener;
	import org.testng.ITestResult;

import com.qa.Testbase.Testbase;
import com.qa.Utilities.Utilities;

	public class CustomListner extends Testbase implements ITestListener{

		public CustomListner() throws FileNotFoundException {
			super();
			// TODO Auto-generated constructor stub
		}

		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailure(ITestResult result) {
			
			
			System.out.println("Failed");
			failed(result.getMethod().getMethodName());
			
		}

		

		
		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
			
		}

	}





