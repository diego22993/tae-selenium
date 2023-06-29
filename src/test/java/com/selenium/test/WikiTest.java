package com.selenium.test;
import java.util.List;

import org.openqa.selenium.*; 
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.selenium.Utiles.*;



public class WikiTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void preCondicion() {
		System.setProperty("webdriver.chrome.driver", "src/resources/Recursos/chromedriver112.exe");
		Utiles.escribir("Inicializando Browser");
		driver = new ChromeDriver(); 
		Utiles.escribir("Ir a la pagina http://wikipedia.org");
		driver.get("http://wikipedia.org");
	}
	
	
	@Test (description="Validar Visualizacion de todos los web elements")
	public void ValidarVisualizacionAllElements() throws Exception{
		Utiles.escribir("Localizar elemento textbox de búsqueda");
		WebElement tbxSearch = driver.findElement(By.id("searchInput"));
		Assert.assertTrue(tbxSearch.isDisplayed(),"No se encuentra el tbx Busqueda");
		
		Utiles.escribir("Localizando elemento link Espaniol");
		WebElement lnkEsp = driver.findElement(By.id("js-link-box-es"));
		Assert.assertTrue(lnkEsp.isDisplayed(),"No se encuentra el link Espaniol");
		
		Utiles.escribir("Localizando elemento link ingles");
		WebElement lnkEng = driver.findElement(By.id("js-link-box-en"));
		Assert.assertTrue(lnkEng.isDisplayed(),"No se encuentra el link ingles");
		
		Utiles.escribir("Localizando elemento link italiano");
		WebElement lnkIta = driver.findElement(By.id("js-link-box-it"));
		Assert.assertTrue(lnkIta.isDisplayed(),"No se encuentra el link italiano");
		
		Utiles.escribir("Localizando elemento link Espaniol");
		WebElement lnkFra = driver.findElement(By.id("js-link-box-fr"));
		Assert.assertTrue(lnkFra.isDisplayed(),"No se encuentra el link Espaniol");
		
		Utiles.escribir("Localizando elemento link portugiez");
		WebElement lnkPor = driver.findElement(By.id("js-link-box-pt"));
		Assert.assertTrue(lnkPor.isDisplayed(),"No se encuentra el link portugiez");
		
		Utiles.escribir("Localizando elemento link japones");
		WebElement lnkJap = driver.findElement(By.id("js-link-box-ja"));
		Assert.assertTrue(lnkJap.isDisplayed(),"No se encuentra el link japones");
		
		Utiles.escribir("Localizando elemento link ruso");
		WebElement lnkRu = driver.findElement(By.id("js-link-box-ru"));
		Assert.assertTrue(lnkRu.isDisplayed(),"No se encuentra el link ruso");
		
		Utiles.escribir("Localizando elemento link aleman");
		WebElement lnkAle = driver.findElement(By.id("js-link-box-de"));
		Assert.assertTrue(lnkAle.isDisplayed(),"No se encuentra el link aleman");
		
		Utiles.escribir("Localizando elemento link Arabe");
		WebElement lnkAra = driver.findElement(By.id("js-link-box-fa"));
		Assert.assertTrue(lnkAra.isDisplayed(),"No se encuentra el link Arabe");
		
		Utiles.escribir("Localizando elemento link Lenguage");
		WebElement lnkReadOwn = driver.findElement(By.xpath("//span[contains(text(),'Read Wikipedia in your language')]"));
		Assert.assertTrue(lnkReadOwn.isDisplayed(),"No se visualiza el link read own lenguage");
		
		Utiles.escribir("Localizando elemento link Footers: creative commons attribution");
		WebElement lnkCreative = driver.findElement(By.xpath("//span[contains(text(),'Creative')]"));
		Assert.assertTrue(lnkCreative.isDisplayed(),"No se visualiza el link creative commons attribution");
		
		Utiles.escribir("Localizando elemento link Footers: terms of use");
		WebElement lnkTerm = driver.findElement(By.xpath("//a[contains(text(),'Terms of Use')]"));
		Assert.assertTrue(lnkTerm.isDisplayed(),"No se visualiza el link terms of use");	
	}
	
	//@Test (description="Validar que las Busquedas funcionan OK ")
	public void ValidarBusquedaFuncionaOK() throws Exception{
		Utiles.escribir("Localizar elemento textbox de búsqueda");
		WebElement tbxSearch = driver.findElement(By.id("searchInput"));
		
		Utiles.escribir("Validar que esté desplegada la caja de búsqueda");
		Assert.assertTrue(tbxSearch.isDisplayed(),"No se encuentra desplegada");
		//Utiles.escribir("El valor del txtbx es: "+tbxSearch.getText().toString());
		
		Utiles.escribir("Ingresar como input la palabra:  Selenium");
		tbxSearch.sendKeys("Selenium");
		Assert.assertTrue(tbxSearch.getText().isEmpty(),"El txtbox no está vacio");
		tbxSearch.submit();
		
		
		WebElement validarTitulo = driver.findElement(By.id("firstHeading"));
		Utiles.escribir("Buscar el titulo: " + validarTitulo.getText());
		Assert.assertTrue(validarTitulo.getText().contains("Selenium"),"No contiene la palabra Selenium");
		Assert.assertTrue(validarTitulo.isDisplayed(), "No se visualiza");
	}
	
	@DataProvider(name = "data")
	public Object[][] createData() {
	 return new Object[][] {
	   { "Selenium","Selenium"},
	   {  "TDD", "TDD"},
	   {"DATA DRIVEN TESTING","Data-driven testing"},
	   {"jenkins","Jenkins"}
	};
	}
	
	@DataProvider(name = "dataIdiomas")
	public Object[][] createDataIdioma() {
	 return new Object[][] {
	   { "af","Selenium","Seleen"},
	   { "es","Selenium","Selenium"},
	   { "pt","Selenium","Selênio"},
	   { "ch","Selenium","硒"},
	   { "ja","Selenium","セレン"},
	   { "de","Selenium","Selenium"},
	   
	};
	}
	
	//@Test (dataProvider = "dataIdiomas", description="Validar que funcionen búsquedas con diferentes idiomas - TDD")
	public void BusquedaConDiferentesIdiomasTDD(String vIdioma, String vBusqueda, String resultado) throws Exception{			
			
		WebElement searchBox = driver.findElement(By.id("searchInput"));
		Select selectIdiomas = new Select (driver.findElement(By.id("searchLanguage")));
			
		for(WebElement e : selectIdiomas.getOptions()) {
			if(e.getAttribute("lang").equals(vIdioma)) {
					
				Utiles.escribir("Seleccionamos idioma del SelectBox");
				e.click();
				Utiles.escribir("Ingresamos dato de busqueda proveniente de TDD ["+vBusqueda+"]");
				searchBox.sendKeys(vBusqueda);
				Utiles.escribir("Realizamos Enter en búsqueda");
				searchBox.submit();
					
				Utiles.escribir("Obtenemos el lenguaje de la página actual");
				String language = driver.findElement(By.tagName("html")).getAttribute("lang");
				Utiles.escribir("El idioma de la pagina es ["+language+"]");
					
				Utiles.escribir("Validamos que coincida lenguaje de la pagina y seleccionado");
				Assert.assertTrue(language.contains(vIdioma) ,"No coinciden lenguajes de la pagina y previamente seleccionado");
					
				Utiles.escribir("Obtenemos el titulo buscado");
				WebElement tituloBuscado = driver.findElement(By.id("firstHeading"));
				Utiles.escribir("El titulo es ["+tituloBuscado.getText()+"]");
					
				Utiles.escribir("Validamos que el valor de búsqueda coincida con el pasado por TDD");
				Assert.assertEquals(tituloBuscado.getText(),resultado, "No coinciden el valor buscado con TDD");
					
				break;
			}	
		}
	}
		
		
	// Obteniendo listado de TOOLS
	//@Test(description="Obtenemos valores de selectbox TOOLS")
	public void ValidarElementosTools() throws Exception{
			
		WebElement searchBox = driver.findElement(By.id("searchInput"));
		searchBox.sendKeys("selenium");
		searchBox.submit();
			
		//List <WebElement> listaTools = driver.findElements(By.xpath("//ul[@id='ca-more-view']/li")); 
		List <WebElement> listaTools = driver.findElements(By.xpath("//ul[@class='vector-menu-content-list']/li")); 
		
		driver.findElement(By.id("vector-page-tools-dropdown-checkbox")).click();
			
		for(WebElement e : listaTools) {
			//if(e.getText().contains("Algo")) {
				//e.click();
				Utiles.escribir(e.getText());
				Thread.sleep(1000);
			//}
		}
	}
	
	//@Test
	public void ValidarToolsGrids() {
		List <WebElement> lista = driver.findElements(By.id("#p-tb"));
		
	}
		
		
	// Test con listas
	//@Test(description="Validar busqueda en wikipedia buscando el idioma por manejo de listas")
	public void ValidarBusquedaWikipediaChromeConLista(/*String valor, String resultado*/) throws Exception{
		Utiles.escribir("Localizar elementos links de lenguajes disponibles...");
		
		List <WebElement> lista = driver.findElements(By.xpath("//ul[@id='menu-main-navigation-1']/li"));
	
	
	}
	// Test con listas, validando listbox idiomas...
	//@Test(description="Validamos el listado de lenguajes y seleccionamos el que coincida")

	
	@AfterMethod
	public void postCondicion() {
		Utiles.escribir("Cerrar browser");
		driver.close(); 
		
	}
	
}
