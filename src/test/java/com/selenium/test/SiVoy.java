package com.selenium.test;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.Utiles.Utiles;
import com.selenium.driver.DriverFactory;
import com.selenium.page.SiVoyDestinoPage;
import com.selenium.page.SiVoyHomePage;

import org.openqa.selenium.support.ui.Select;

public class SiVoy {
	WebDriver driver;

	@BeforeMethod
	public void preCondicion(ITestContext context) {
		DriverFactory.LevantarBrowser(driver, context);
	}

	// @Test(description="Validacion de tipo de lugares y destinos")
	public void ValidacionTipoDestino() throws Exception {
		Utiles.escribir("Localizar elementos de la lista");

		List<WebElement> lista = driver.findElements(By.xpath("//ul[@id='menu-main-navigation-1']/li"));

		Utiles.escribir("Validamos si está visible botón Buscar Experiencias");

		WebElement btnExp = driver.findElement(By.id("slide-1-layer-3"));
		Thread.sleep(5000);
		Assert.assertTrue(btnExp.isDisplayed(), "No se encuentra visible");
		Utiles.escribir("Realizamos click en btn Buscar Experiencias");
		btnExp.click();

		Utiles.escribir("Validamos si está visible select box tipo lugares");
		// falta assercion
		Select tipoLugar = new Select(driver.findElement(By.id("tipoLugares")));

		Utiles.escribir("Validamos si está visible select box ciudades");
		// falta asersion
		Select destino = new Select(driver.findElement(By.id("ciudades")));

		Utiles.escribir("Validamos si está visible btn Buscar");
		WebElement btnBuscar = driver.findElement(By.id("Buscar"));
		Assert.assertTrue(btnBuscar.isDisplayed(), "No se encuentra visible el btn");

		Utiles.escribir("Listamos todos los tipos de lugares: ");
		for (WebElement e : tipoLugar.getOptions()) {
			Utiles.escribir(e.getText());
		}

		Utiles.escribir("#### Listamos todos los destinos #### ");
		for (WebElement e : destino.getOptions()) {
			Utiles.escribir(e.getText());
		}
	}

	@Test(description = "Validando GRID-ELEMENTS")
	public void ValidacionDestinosGrid() throws Exception {

		SiVoyHomePage home;
		home = new SiVoyHomePage(this.driver);
		Thread.sleep(10000);
		home.validarVisualizacionBtnExp();

		// home.click_btn_buscar_exp();

		SiVoyDestinoPage des;
		des = new SiVoyDestinoPage(driver);
		// des.obtenerDatosLista();
		Utiles.escribir("objeto page res creado: [" + des.toString() + "]");
		/*
		 * List <WebElement> destinos =
		 * driver.findElements(By.xpath("//div[@id='divDestinos']/div"));
		 * System.out.println("Cantidad de grid-element: "+destinos.size());
		 * 
		 * int i=1;
		 * 
		 * for(WebElement e: destinos) { if(e.getText().contains("a")) { WebElement
		 * titulo = driver.findElement(By.xpath("//div[@id='divDestinos']/div[" + i +
		 * "]/div[1]/div[1]/div[2]/h3")); Utiles.escribir(titulo.getText()); } }
		 */
	}

	@AfterMethod
	public void postCondicion() {
		Utiles.escribir("Cerrar browser");
		DriverFactory.Finalizar(driver);
	}
}
