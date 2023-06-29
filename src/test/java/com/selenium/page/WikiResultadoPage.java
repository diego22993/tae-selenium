package com.selenium.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.selenium.Utiles.Utiles;

public class WikiResultadoPage {
	WebDriver driver = null;

	@FindBy(id = "firstHeading")
	private WebElement titulo;

	@FindBy(xpath = "//input[@id='p-lang-btn-checkbox']")
	private WebElement cboLenguaje;

	public WikiResultadoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean tituloEsVisible() {
		return this.titulo.isDisplayed();
	}

	public String getTitulo() {
		return titulo.getText();
	}

	public String getIdioma() {
		return titulo.getText();
	}

	public String getIdiomaPagina() {
		return driver.findElement(By.tagName("html")).getAttribute("lang");
	}
	
	// TO DO: Reemplazar data provider , chequear cada palabra en google traslate****
	public void validacion_Texto_Lenguaje(String p_idioma, String p_texto) {

		Select listadoIdioma = new Select(cboLenguaje);
		
		for (WebElement e : listadoIdioma.getOptions()) {
			if (e.getText().equalsIgnoreCase(getIdiomaPagina())) {
				Utiles.escribir("Coinciden los idiomas de pag actual y enviado por parametro");
			} else {
				Utiles.escribir("NO COINCIDEN los idiomas de pag actual y enviado por parametro");
			}
		}
	}
	
	public String getLangURL() {
		return driver.getCurrentUrl().substring(8, 10);
	}
	
	public boolean validarIdiomaCorrecto(String vIdioma) {
		if(getLangURL().equals(vIdioma)) {
			Utiles.escribir("[ COINCIDEN]");
			return true;
		}else { 
			Utiles.escribir("[NO COINCIDEN]");
			return false;
		}
	}

	public boolean lenguajeTituloCoincide(String vIdioma) {
		return vIdioma.contains(titulo.getText());
	}
	
	public boolean validarTxt(String vResultado) {
		if(titulo.getText().equals(vResultado) && driver.getCurrentUrl().contains(vResultado)) {
			Utiles.escribir("[COINCIDEN]");
			return true;
		}else
			Utiles.escribir("[NO COINCIDEN] [posee caracteres especiales, acentos, etc]");
			return false;
	}
}
