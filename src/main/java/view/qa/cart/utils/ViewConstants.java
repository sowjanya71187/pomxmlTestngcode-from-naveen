package view.qa.cart.utils;

import java.util.ArrayList;
import java.util.List;

public class ViewConstants {
	public static final String LOGIN_PAGE_TITLE = "Account Login";
	public static final String ACC_PAGE_TITLE = "My Account";
	public static final int HEADER_PAGE_COUNT = 5;
	public static final int PRODUCT_IMAGES_COUNT = 4;
	public static final String ACCOUNT_CREATION_SUCCESS_MESSG = "Your Account Has Been Created!";
	//********************************SheetNames***************************
	public static final String REGISTOR_SHEET_NAME = "register";
	
	
	
	
	public static List<String> expectedlist() {
		List<String> expList = new ArrayList<String>();
		expList.add("My Account");
		expList.add("My Orders");
		expList.add("My Affiliate Account");
		expList.add("Newsletter");
		System.out.println(expList);
		return expList;
	}

}
