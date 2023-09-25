package utils;

import java.io.*;
import java.util.Map;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverHelper extends Base {
    private WebDriver driver;
    excelReadFile file = new excelReadFile();

    public WebDriverHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void clickElement(By btn) {
        WebElement element = driver.findElement(btn);
        element.click();
    }

    public void sendkeys(By search, String text) {
         WebElement element = driver.findElement(search);
        element.sendKeys(text);
    }
    public void Keyenter(WebElement locator){
        locator.sendKeys(Keys.ENTER);
    }
    public String ReadData(String SheetName, int RowNum, String ColumnName) throws InvalidFormatException, IOException {

   

    	List<Map<String, String>> testData = file.getData("./testdata/Testdata.xlsx", SheetName);

    	String Data=testData.get(RowNum).get(ColumnName);

		log.info("Data Picked from SheetName: "+SheetName+", RowNumber: "+RowNum+"and ColumnName: "+ColumnName+": " +Data);

		log.warning(Data);

		return Data;

    }
    

}
