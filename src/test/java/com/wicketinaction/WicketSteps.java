package com.wicketinaction;

import com.wicketinaction.counting.CountingApplication;
import com.wicketinaction.helloworld.HelloWorldApplication;
import org.apache.wicket.util.tester.WicketTester;

import cuke4duke.Before;
import cuke4duke.Given;
import cuke4duke.Then;

public class WicketSteps {
	private WicketTester tester;

	@Before("@counting")
	public void useCounting() {
		tester = new WicketTester(new CountingApplication());
	}

	@Before("@hello")
	public void useHello() {
		tester = new WicketTester(new HelloWorldApplication());
	}

	@Given("^I am viewing the (.*)$")
	public void iAmViewing(String arg1) {
		if ("home page".equalsIgnoreCase(arg1)) {
			tester.startPage(tester.getApplication().getHomePage());
		}
	}

	@Then("^I should see \"([^\"]*)\"$")
	public void iShouldSee(String arg1) {
		tester.assertContains(arg1);
	}
}
