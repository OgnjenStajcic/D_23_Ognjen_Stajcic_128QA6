//Napraviti aplikaciju pomocu Selenium-a koji ce otvoriti sajt kupujemprodajem.com,
// izlistati sve kategorije (Stvari) sa leve strane i njihove linkove (kao spoken tekst “kategorija: link”),
// kliknuti iz te liste na Bicikli (bez hardkodovanja, posto imate listu, iskoristiti element iz nje da se klikne),
// kliknuti na Električni (mozete hardcodovati). Ostati na toj strani kao kraj zadatka.
// Uspavati program na 5 sekundi kako bi se video rezultat i posle toga browser zatvoriti.
//
//Obratiti paznju na "ad" koji kaze da se registrujete.
// Uzeti dugme x i kliknuti ga pre svega da ne bi ste imali problem da ne mozete da kliknete na kategoriju.
//
//Za 5+ nakon klika na kategoriju bicikli, treba izlistati sve kategorije koje pisu (Mountainbike, Gradski itd).

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Destop PC\\IdeaProjects\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.kupujemprodajem.com/");

        driver.manage().window().maximize();

        WebElement closeButton = driver.findElement(By.xpath("//*[@id='bodyTag']/div[9]/div/div[2]"));
        closeButton.click();

        List<WebElement> categoryLinks = driver.findElements(By.xpath("//*[@id='category-tree-content-goods']/a"));
        for (int i = 0; i < categoryLinks.size(); i++) {
            System.out.println(categoryLinks.get(i).getText() + " " + categoryLinks.get(i).getAttribute("href"));

        }




        for (int j = 0; j < categoryLinks.size(); j++) {
            WebElement category = categoryLinks.get(j);
            if(category.getText().equals("Bicikli")){
                category.click();

                List<WebElement> linksBicikli = driver.findElements(By.className("categoryTitle"));
                for (int i = 0; i < linksBicikli.size(); i++) {
                    System.out.println(linksBicikli.get(i).getText());
                }

                WebElement elektricni = driver.findElement(By.xpath("//*[@id='groupBox1360']/div[1]/h2/a/span"));
                elektricni.click();
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.close();
            }
        }







    }
}
