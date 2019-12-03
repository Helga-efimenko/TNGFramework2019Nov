package com.hubspot.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ExtendReportListener implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println(result.getName() + " test case has started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	  System.out.println(result.getName() + " test case passed successfully.");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("The test case failed is "+ result.getName());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("The test case skipped is "+ result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	
		
	}

	@Override
	public void onStart(ITestContext context) {
		Reporter.log(context.getName(), true);
		
	}

	@Override
	public void onFinish(ITestContext context) {
	    System.out.println("Test is completed");
		
	}

}
