package com.selenium.test;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.Utiles.Utiles;
import com.selenium.driver.DriverFactory;
import com.selenium.page.WikiHomePage;
import com.selenium.page.WikiResultadoPage;

import AccesoADato.ExcelUtils;

public class WikiTest2 {
	WebDriver driver = null;
	// private WebDriverWait wait;

	@BeforeMethod
	public void abrirBrowser(ITestContext context) throws Exception {
		driver = DriverFactory.LevantarBrowser(driver, context);
	}

	@DataProvider(name = "dataIdiomas")
	public Object[][] createDataIdioma() {
		return new Object[][] { { "da", "Selenium", "Selen" }, { "af", "Selenium", "Seleen" },
				{ "es", "Selenium", "Selenium" }, { "pl", "Selenium", "Selenium" }

		};
	}

	@DataProvider(name = "data")
	public Object[][] createData() {
		return new Object[][] { { "selenium", "Selenium" }, { "tdd", "TDD" }, { "data-driven", "Data-driven" },
				{ "jenkins", "Jenkins" }, { "mongodb", "MongoDB" } };
	}

	//@Test(description = "Validar búsqueda con data provider funciona OK", dataProvider = "data")
	public void ValidarBusquedaTDD(String key1, String key2) throws InterruptedException {
		WikiHomePage homePage = PageFactory.initElements(driver, WikiHomePage.class);
		homePage.ingresarBusquedaV1(key1, key2);
	}

	//@Test(description = "Validar Visualizacion de todos los web elements de wiki homepage")
	public void ValidarVisualizacionAllElementsHome() throws Exception {
		WikiHomePage homePage = PageFactory.initElements(driver, WikiHomePage.class);
		Assert.assertTrue(homePage.validarVisualizacion(), "Algun elemento de wiki home [NO DISPONIBLE]");
	}

	// Busqueda v2
	//@Test(description = "Validar búsqueda por idioma funciona OK", dataProvider = "dataIdiomas")
	public void BusquedaVersion2(String vIdioma, String vBusqueda, String vResultado) throws Exception {
		WikiHomePage homePage = PageFactory.initElements(driver, WikiHomePage.class);
		homePage.ingresarBusquedaV2(vIdioma, vBusqueda, vResultado);
	}

	// Busqueda utilizando recomendaciones de Wikipedia
	// @Test(description = "Validar busqueda Recomendada funciona bien",
	// dataProvider = "dataIdiomas")
	public void BusquedaVersion3(String vIdioma, String vBusqueda, String vResultado) throws Exception {
		WikiHomePage homePage = PageFactory.initElements(driver, WikiHomePage.class);
		homePage.ingresarBusquedaV3(vIdioma, vBusqueda, vResultado);
	}

	@DataProvider(name = "DatosNuevos")
	public Object[][] DatosNuevos() throws Exception {

		String excelPath = "C:\\Users\\diego.heredia\\curso\\test\\src\\resources\\data\\TestData.xlsx";
		String hoja = "Sheet1";
		ExcelUtils.setExcelFile(excelPath, hoja);
		int iTestCaseRow = ExcelUtils.getRowUsed();
		Object[][] testObjArray = ExcelUtils.getTableArray(excelPath, hoja, iTestCaseRow, 3);

		return (testObjArray);
	}

	// Validamos TDD partir de un archivo externo , ej: Excel
	@Test(priority = 1, description = "Validar busqueda funciona ok recibiendo como entrada un archivo excel-TDD", dataProvider = "DatosNuevos")
	public void Busqueda_Version_TDD_Excel(String vIdioma, String vBusqueda, String vResultado) throws Exception {
		WikiHomePage homePage = PageFactory.initElements(driver, WikiHomePage.class);
		homePage.ingresarBusquedaV2(vIdioma, vBusqueda, vResultado);
	}

	@AfterMethod
	public void postCondicion() {
		DriverFactory.Finalizar(driver);
	}
}
