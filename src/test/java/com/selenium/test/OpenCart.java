package com.selenium.test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import com.selenium.Utiles.Utiles;
import com.selenium.driver.DriverFactory;
import com.selenium.page.*;

public class OpenCart {
	WebDriver driver;

	@BeforeMethod
	public void setUp(ITestContext e) {
		driver = DriverFactory.LevantarBrowser(driver, e);
	}

	@Test(description = "Validando el Cambio de Menu a Lista")
	public void Validacion_Tranf_Menu_To_List() throws InterruptedException {
		OpenCartPageHome home = new OpenCartPageHome(driver);

		Utiles.escribir("Lista de opciones : " + home.getLista().toString());
		System.out.println("Lista:::"+home.getLista().toString());
		Thread.sleep(15000);
		home.obtenerMenu();
		// Assert.assertTrue(home.obtenerMenu(),"No se encuentra la opcion para
		// TAE-Demo");
		
	}

	@AfterMethod
	public void tearDown() {
		DriverFactory.Finalizar(driver);
	}
}
