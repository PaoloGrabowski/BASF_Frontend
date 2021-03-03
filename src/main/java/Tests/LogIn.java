package Tests;

import org.junit.Test;

import Basf.Form.Generic;
import Pages.Login;
import Pages.Main;
import Pages.TermOfUse;
import junit.framework.Assert;

public class LogIn extends Generic {

	@Test()
	public void loginSuccessful()
	{	
		String username ="pgpawelgrabowski@wp.pl";
		String password="lavidaloca";
	
		
		Login login =new Login(driver);
		login.enterLogin(username);
		login.enterPassword(password);
		login.logIn();
		
		TermOfUse termOfUse =new TermOfUse(driver);
		termOfUse.checkFirstTerm();
		termOfUse.uncheckSecondTerm();
		termOfUse.proceed();
	
		Main main = new Main(driver);
		Assert.assertTrue(main.getLogoName().contains("QKnows"));
	}
	
}