import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Welcome to the Ashkelon Academic College");
        System.out.println("Pleas enter your name: ");
        String name = scanner.nextLine();
        System.out.println("Pleas enter your password: ");
        String password=scanner.nextLine();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\יהונתן\\Desktop\\javaAutomation\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.aac.ac.il/");
        List<WebElement> elementList=driver.findElements(By.className("top-header-menu"));
        WebElement menu =elementList.get(0);
        List<WebElement>menuItem=menu.findElements(By.tagName("li"));
            WebElement personalInfo = menuItem.get(20);
            personalInfo.click();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            WebElement userNameInput = driver.findElement(By.id("Ecom_User_ID"));
            if (userNameInput!=null){
                userNameInput.sendKeys(name);
            }
            WebElement passwordInput = driver.findElement(By.id("Ecom_Password"));
            if (passwordInput!=null){
                passwordInput.sendKeys(password);
            }
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            WebElement loginEnter = driver.findElement(By.id("wp-submit"));
            loginEnter.click();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            List<WebElement> element=driver.findElements(By.className("col-sm-6"));
            WebElement modelButton=element.get(6);
            try {
               Thread.sleep(5000);
            }catch (InterruptedException e){
               e.printStackTrace();
            }
            modelButton.click();
            try {
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            List<WebElement>modelMenu=driver.findElements(By.className("multiline"));
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
            System.out.println("This is a list of all your course");
            for (int i=0;i<(modelMenu.size());i++){
                System.out.println(i+1+":"+modelMenu.get(i).getText());
            }
            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Pleas enter a number course: ");
            int userCourseInput=scanner.nextInt();
            for (int i=0;i<(modelMenu.size());i++){
                if (userCourseInput==i+1){
                    WebElement selectedCourse=modelMenu.get(i);
                    selectedCourse.click();
                }
            }

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.className("dropdown-toggle")).click();
        driver.findElement(By.cssSelector(".dropdown-menu .dropdown-item:last-of-type")).click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(By.id("menu-top-header")).findElements(By.tagName("li")).get(1).click();






    }
}
