package br.ce.fegodinho.runners;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/inserir_conta.feature",
		glue = "br.ce.fegodinho.steps",
		tags = {"~@ignore"},
		plugin = {"pretty", "html:target/report-html", "json:target/report.json"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		dryRun = false,
		strict = false)
public class Runner {
	
	@BeforeClass
	public static void reset() {
		WebDriver driver = new ChromeDriver();
	    driver.get("http://srbarriga.herokuapp.com/login");
	    driver.findElement(By.id("email")).sendKeys("felipe@godinho");
	    driver.findElement(By.id("senha")).sendKeys("123456");
	    driver.findElement(By.tagName("button")).click();
	    driver.findElement(By.linkText("reset")).click();
	    driver.quit();		
	}

}