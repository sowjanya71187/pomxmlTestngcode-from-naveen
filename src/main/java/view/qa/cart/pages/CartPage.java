package view.qa.cart.pages;

import org.openqa.selenium.By;

public class CartPage {
	private By cart = By.id("cart");
	
	public void cartpage() {
		System.out.println("this is my cart page");
	}
	public void clickoncart() {
		System.out.println("click on cart"+cart);
	}

}
