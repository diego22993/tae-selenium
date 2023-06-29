package com.selenium.Utiles;


import org.openqa.selenium.WebDriver;
import org.testng.Reporter;



public class Utiles {
	WebDriver driver;
	
	public Utiles(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void escribir(String linea) {
		System.out.println(linea);
		Reporter.log(linea);
	}
}
