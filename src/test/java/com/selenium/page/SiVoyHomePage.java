package com.selenium.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SiVoyHomePage {
	WebDriver driver;
	
	//@FindBy(id="slide-1-layer-3")
	@FindBy(xpath="//span[contains(text(),'Buscar experiencias')]")
	private WebElement btnExp;
	
	@FindBy(xpath="//a[@id='']")
	private WebElement divDestino;
	
	public SiVoyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this.driver);
	}
	
	public void validarVisualizacionBtnExp() {
		btnExp.isDisplayed();
	}
	
	public void click_btn_buscar_exp() {
		validarVisualizacionBtnExp();
		btnExp.click();
		}
	}

