package com.selenium.page;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.selenium.Utiles.Utiles;

public class WikiHomePage {
	WebDriver driver = null;

	public WikiHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='typeahead-suggestions']//a")
	private List<WebElement> listaRecomendacion;

	@FindBy(id = "typeahead-suggestions")
	private WebElement recomendazion;

	@FindBy(xpath = "//@id=typeahead-suggestions //body/div[3]/form[1]/fieldset[1]/div[1]/div[2]/div[1]")
	private WebElement recomendacion;

	@FindBy(xpath = "//input[@id='searchInput']")
	private WebElement txtBox;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement btnSearch;

	@FindBy(id = "js-link-box-es")
	private WebElement lnkEsp;

	@FindBy(id = "js-link-box-en")
	private WebElement lnkEng;

	@FindBy(id = "js-link-box-it")
	private WebElement lnkIta;

	@FindBy(id = "js-link-box-fr")
	private WebElement lnkFra;

	@FindBy(id = "js-link-box-pt")
	private WebElement lnkPor;

	@FindBy(id = "js-link-box-ru")
	private WebElement lnkRu;

	@FindBy(id = "js-link-box-de")
	private WebElement lnkAle;

	@FindBy(id = "js-link-box-fa")
	private WebElement lnkAra;

	@FindBy(id = "js-lang-list-button")
	private WebElement lnkReadOwn;

	@FindBy(xpath = "//a[contains(text(),'Terms of Use')]")
	private WebElement lnkTerm;

	@FindBy(id = "searchLanguage")
	private WebElement comboLenguaje;

	public boolean searchSearch() {
		Utiles.escribir("Validar que exista el elemento button Search");
		if (btnSearch.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchInputSearch() {
		Utiles.escribir("Validar que exista el elemento search input");
		if (txtBox.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkEsp() {
		Utiles.escribir("Validar que exista el elemento link Español");
		if (lnkEsp.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkEng() {
		Utiles.escribir("Validar que exista el elemento link Ingles");
		if (lnkEng.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkIta() {
		Utiles.escribir("Validar que exista el elemento link Italiano");
		if (lnkIta.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkFra() {
		Utiles.escribir("Validar que exista el elemento link Frances");
		if (lnkFra.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkPor() {
		Utiles.escribir("Validar que exista el elemento link Portugues");
		if (lnkPor.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkRu() {
		Utiles.escribir("Validar que exista el elemento link Ruso");
		if (lnkRu.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkAle() {
		Utiles.escribir("Validar que exista el elemento link Aleman");
		if (lnkAle.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkAra() {
		Utiles.escribir("Validar que exista el elemento link Arabe");
		if (lnkAra.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkReadOwn() {
		Utiles.escribir("Validar que exista el elemento link ReadOwn");
		if (lnkReadOwn.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchLinkTerm() {
		Utiles.escribir("Validar que exista el elemento link Terms");
		if (lnkTerm.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}
	}

	public boolean searchCombo() {
		Utiles.escribir("Validar que exista el elemento combo-box");
		if (comboLenguaje.isDisplayed()) {
			Utiles.escribir("Existe");
			return true;
		} else {
			Utiles.escribir("No existe wE search");
			return false;
		}

	}

	public void ClickEnglish() {
		Utiles.escribir("Seleccionamos idioma inglés");
		lnkEng.click();
	}

	public String GetSelect() {
		Utiles.escribir("Obtiene el dato del select box");
		return comboLenguaje.getDomAttribute("value").toString();
	}

	@FindBy(xpath = "//select[@id='searchLanguage']/option")
	private List<WebElement> grillaLenguaje;

	public boolean validarVisualizacion() {
		if (searchSearch() && searchInputSearch() && searchLinkEsp() && searchLinkEng() && searchLinkIta()
				&& searchLinkFra() && searchLinkPor() && searchLinkRu() && searchLinkAle() && searchLinkAra()
				&& searchLinkTerm() /*&& searchCombo()*/) {
			return true;
		} else {
			return false;
		}
	}

	public WikiResultadoPage ingresarBusquedaV1(String key1, String key2) throws InterruptedException {

		Utiles.escribir("Ingresar valor de busqueda [" + key1 + "]");
		txtBox.sendKeys(key1);

		Utiles.escribir("Ingresamos ENTER");
		txtBox.submit();

		WikiResultadoPage res;
		res = new WikiResultadoPage(driver);

		Utiles.escribir("Comparamos los valores y validamos que coincidan");
		Assert.assertTrue(res.validarTxt(key2));

		return res;
	}

	// Patron POM full
	public WikiResultadoPage ingresarBusquedaV2(String vIdioma, String vBusqueda, String vResultado)
			throws InterruptedException {

		Utiles.escribir("Ingresar idioma [" + vIdioma + "]");
		comboLenguaje.sendKeys(vIdioma);

		Utiles.escribir("Ingresar valor de busqueda [" + vBusqueda + "]");
		txtBox.sendKeys(vBusqueda);

		Utiles.escribir("Ingresamos ENTER");
		btnSearch.submit();

		WikiResultadoPage res;
		res = new WikiResultadoPage(driver);

		Utiles.escribir("Idioma de URL actual [" + res.getLangURL() + "]");
		Utiles.escribir("Titulo resultado  [" + res.getTitulo() + "]");

		Utiles.escribir("Comparamos los valores y validamos que coincidan");
		Assert.assertTrue(res.validarTxt(vResultado));

		Utiles.escribir("Validamos idioma previamente seleccionado y pasado por parametro");
		Assert.assertTrue(res.validarIdiomaCorrecto(vIdioma));
		return res;
	}

	//// select[@id='searchLanguage']/option/*[@value='af']

	// Utilizamos el selector Recomendacion, seleccionamos el 1er dato filtrado y
	// SUBMIT
	public WikiResultadoPage ingresarBusquedaV3(String vIdioma, String vBusqueda, String vResultado)
			throws InterruptedException {
		Assert.assertTrue(searchInputSearch(), "No se encuentra caja de texto");
		Utiles.escribir("Ingresar idioma [" + vIdioma + "]");
		comboLenguaje.sendKeys(vIdioma);
		Utiles.escribir("Ingresar valor de busqueda [" + vBusqueda + "]");
		txtBox.sendKeys(vBusqueda);

		Utiles.escribir("Obtenemos valores recomendados");
		Thread.sleep(2000);

		String first = listaRecomendacion.get(0).getText();
		Utiles.escribir("Seleccionamos el 1er elemento recomendado: [ " + first + " ]");

		// Thread.sleep(5000);
		listaRecomendacion.get(0).click();

		WikiResultadoPage res;
		res = new WikiResultadoPage(driver);
		Utiles.escribir("Comparamos los valores y corroboramos que coincidan");
		Assert.assertTrue(res.validarTxt(first),
				"No coincide el titulo [" + first + "] con el valor pasado por parametro [" + vBusqueda + "]");
		Utiles.escribir("Comparamos los valores del idioma previamente seleccionado y pasado por parámetro");
		Assert.assertTrue(res.validarIdiomaCorrecto(vIdioma), "No coincide el idioma previamente seleccionado");
		return res;
	}

	// draft version - wip
	public boolean buscarTextoPorIdioma(String vIdioma, String vBusqueda) throws InterruptedException {
		Select selectIdiomas = new Select(comboLenguaje);

		Utiles.escribir("Seleccionamos idioma del SelectBox");
		selectIdiomas.selectByValue(vIdioma);

		Utiles.escribir(selectIdiomas.getOptions().toString());

		Utiles.escribir("Ingresar dato de busqueda proveniente de TDD [" + vIdioma + "]");
		Utiles.escribir("Ingresar dato de busqueda proveniente de TDD [" + vBusqueda + "]");
		txtBox.sendKeys(vBusqueda);

		Utiles.escribir("Realizamos Enter en búsqueda");
		txtBox.submit();

		Utiles.escribir("Creamos instancia de Wiki Res Page....");
		WikiResultadoPage wrp = new WikiResultadoPage(this.driver);

		Utiles.escribir("Validamos que coincida el idioma y el txt buscado");
		// boolean coincide = wrp.lenguajeTituloCoincide(vIdioma, vBusqueda);

		// Assert.assertTrue(coincide, "No coincide");
		return true;
	}
}
