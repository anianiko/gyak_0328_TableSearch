import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TablePage {

    WebDriver driver;

    public TablePage(WebDriver driver) {
        this.driver = driver;
    }

    private final String URL = "https://demo.seleniumeasy.com/table-search-filter-demo.html";

    private final By InputBox = By.id("task-table-filter");

    private final By TableRows = By.xpath("//*[@id=\"task-table\"]/tbody/tr");
//"//*[@id=\"task-table\"]/tbody/tr[@style=\"display: table-row;\"]"
    public void navigate() {
        driver.navigate().to(URL);
    }

    public void giveInput(String word) {
        driver.findElement(InputBox).sendKeys(word);
    }

    public String[] getTasks() throws InterruptedException {
        Thread.sleep(1000);
        List<WebElement> rows = driver.findElements(TableRows);

        List<String> result = new ArrayList<String>();

        for (WebElement row : rows) {
            String value = row.getAttribute("style");
            if(!value.equals("display: none;")){
                String text = row.findElement(By.xpath("./td[2]")).getText();
                result.add(text);
            }

        }
        String[] array = new String[result.size()];
        array = result.toArray(array);
        return array;
    }

}
