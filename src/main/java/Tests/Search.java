package Tests;

import org.junit.Test;

import Basf.Form.Generic;
import Pages.Login;
import Pages.Main;
import Pages.TermOfUse;
import junit.framework.Assert;

public class Search extends Generic {

	@Test()
	public void searchingWords()
	{	
		String username ="pgpawelgrabowski@wp.pl";
		String password="lavidaloca";
		String word="propylen";
		
		Login login =new Login(driver);
		login.enterLogin(username);
		login.enterPassword(password);
		login.logIn();
		
		TermOfUse termOfUse =new TermOfUse(driver);
		termOfUse.checkFirstTerm();
		termOfUse.uncheckSecondTerm();
		termOfUse.proceed();
		
		Main main = new Main(driver);
		main.enterWord(word);
		main.search();
		main.waitForValidation();
		Assert.assertTrue(main.checkFirstAbstract().contains(word));
		Assert.assertTrue(main.checkSecondAbstract().contains(word));
		Assert.assertTrue(main.checkThirdAbstract().contains(word));
	}
	
}
