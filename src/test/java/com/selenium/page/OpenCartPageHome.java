package com.selenium.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenCartPageHome {
	private By me_nu = By.xpath("//div[@id='narbar-menu']/ul/li/a");
	WebDriver driver;

	public OpenCartPageHome(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "narbar-menu")
	private WebElement menu;

	// Identificar el nav menu como una lista
	@FindBy(xpath = "//div[@id='narbar-menu']/ul/li/a")
	private List<WebElement> opcionesMenu;

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a")
	private List<WebElement> menuPrincipal;
	
	public List<WebElement> getLista() {
		return menuPrincipal;
	}
	
	public void obtenerMenu() {
		List <WebElement> opciones = menuPrincipal;
		
		for(WebElement e: opciones) {
			if(e.getText().equals("Demo")) {
				e.click();
				break;
			}
		}
		//return true;
	}
}
