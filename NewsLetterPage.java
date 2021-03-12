package view.qa.cart.pages;

import org.openqa.selenium.By;

public class NewsLetterPage {
	private By letter = By.id("letter");
	
	public NewsLetterPage() {
		System.out.println("this is my cart page");
	}
	public void clickonletter() {
		System.out.println("click on cart"+letter);
	}

}
