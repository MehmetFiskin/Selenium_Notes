package day03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class SinifCalismasi {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","src/resources/driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


         /*
      Bir class oluşturun: LoginTest
      Main method oluşturun ve aşağıdaki görevi tamamlayın.
      http://a.testaddressbook.com adresine gidiniz.
      Sign in butonuna basin
      email textbox,password textbox, and signin button elementlerini locate ediniz..
      Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
      Username : testtechproed@gmail.com
      Password : Test1234!
      Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
      “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
      Sayfada kac tane link oldugunu bulun.
       */

        //a. http://a.testaddressbook.com adresine gidiniz.
        driver.get("http://a.testaddressbook.com");

        //b. Sign in butonuna basin
        WebElement signInButton = driver.findElement(By.linkText("Sign in"));
        signInButton.click();

        //c. email textbox,password textbox, and signin button elementlerini locate ediniz..
        WebElement emailTextbox = driver.findElement(By.id("session_email"));
        WebElement password = driver.findElement(By.id("session_password"));
        WebElement signin = driver.findElement(By.name("commit"));

        //d. Kullanıcı adını ve şifreyi aşağıya girin ve oturum aç (sign in)buttonunu tıklayın:
        //i. Username : testtechproed@gmail.com
        //ii. Password : Test1234!

        Thread.sleep(2000);
        emailTextbox.sendKeys("testtechproed@gmail.com");
        Thread.sleep(2000);
        password.sendKeys("Test1234!");
        Thread.sleep(2000);
        signin.click();

        //e. Expected user id nin testtechproed@gmail.com oldugunu dogrulayin(verify).
        WebElement expectedUser = driver.findElement(By.className("navbar-text"));
        Thread.sleep(2000);
        if(expectedUser.isDisplayed()){
            System.out.println("ExpectedUser Testi PASSED "+expectedUser.getText());
        }else System.out.println("ExpectedUser Testi FAILED");
        //----------------------------------------------------------
        String istenenUserYazisi = "testtechproed@gmail.com";
        String actualUserYazısı = expectedUser.getText();
        if(actualUserYazısı.equals(istenenUserYazisi)){
            System.out.println("TEST PASSED");
        }else System.out.println("TEST FAILED");
        /*
         Bir Webelementin üzerindeki yaziyi konsolda yazdırabilmek için getText() methodu kullanılır
         */

        //f. “Addresses” ve “Sign Out” textlerinin görüntülendiğini( displayed) doğrulayin(verify).
        WebElement addresses = driver.findElement(By.linkText("Addresses"));
        WebElement signOut = driver.findElement(By.linkText("Sign out"));
        if (addresses.isDisplayed()){
            System.out.println("Adresses TESTİ PASSED");
        }else System.out.println("Adresses Testi FAILED");
        if (signOut.isDisplayed()){
            System.out.println("SignOut TESTİ PASSED");
        }else System.out.println("SignOut Testi FAILED");
        //3. Sayfada kac tane link oldugunu bulun.
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println("Linklerin sayısı = "+linklerListesi.size());
        System.out.println(linklerListesi);
        //4. Linkleri yazdırınız
        for (WebElement each:linklerListesi) {
            System.out.println("Linkler : "+each.getText());
        }
        //5. Linkleri LAMBDA ile yazdırınız
        linklerListesi.forEach(t-> System.out.println(t.getText()));
        //6. Sayfayı kapatınız
        driver.close();




    }
}
