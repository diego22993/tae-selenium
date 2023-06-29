package com.selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.Utiles.Utiles;

public class SiVoyDestinoPage {
	WebDriver driver;

	@FindBy(xpath = "//div[@id='divDestinos']/div")
	private List<WebElement> destinos;

	public SiVoyDestinoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void obtenerDatosLista() {
		int i = 1;
		for (WebElement e : destinos) {
			if (e.getText().contains("a")) {
				WebElement titulo = driver
						.findElement(By.xpath("//div[@id='divDestinos']/div[" + i + "]/div[1]/div[1]/div[2]/h3"));
				Utiles.escribir(titulo.getText());
			}
		}
	}
}
