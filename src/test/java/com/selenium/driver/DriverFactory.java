package com.selenium.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import com.selenium.Utiles.Utiles;
import org.openqa.selenium.firefox.*;

public class DriverFactory {
	private enum browsers {
		FIREFOX, CHROME, EDGE;
	}
	
	public static WebDriver LevantarBrowser(WebDriver driver, ITestContext context) {
		String browserName = context.getCurrentXmlTest().getParameter("nombreNavegador");
		String urlName = context.getCurrentXmlTest().getParameter("urlNavegador");
		
		switch (browsers.valueOf(browserName)) {
		case CHROME: {
			System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
			Utiles.escribir("Abriendo Browser...");
			//ChromeOptions op = new ChromeOptions();
			//op.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
			driver = new ChromeDriver();
			break;
		}
		case FIREFOX: {
			Utiles.escribir("Abriendo Browser...");
			String exe = "C:/Program Files/Mozilla Firefox/driver/firefox.exe";
			FirefoxOptions options = new FirefoxOptions();
            options.setBinary(exe);
            driver = new FirefoxDriver(options);
			break;
		}
		case EDGE: {
			System.setProperty("webdriver.edge.driver", "src/resources/driver/msedgedriver.exe");
			Utiles.escribir("Abriendo Browser...");
			driver = new EdgeDriver();
			break;
		}
			
		default:
			Utiles.escribir("No seleccionó ningun browser correcto, se le asignará Chrome por defecto");
			System.setProperty("webdriver.chrome.driver", "src/resources/driver/chromedriver.exe");
			Utiles.escribir("Abriendo Browser...");
			driver = new ChromeDriver();
			break;
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(urlName);
		return driver;
	}

	public static void Finalizar(WebDriver driver) {
		Utiles.escribir("Cerrando Browser...");
		driver.quit();
		driver = null;
	}
}
