package com.zyf.demo;

import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * @author zyf  
 * @Email  zhuyunfeng@zafh.com.cn
 */

public class TuoCheTest {


	private AppiumDriver driver; 
    @Before
    public void setUp() throws Exception {
        //设置apk的路径
        File classpathRoot = new File("src/test/resources");
        File appDir = new File(classpathRoot, "apps");
        File app = new File(appDir, "cheguo_1.0_1_201611230900_official.apk");
        
        //设置自动化相关参数
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "1edf94f5");
        
        //设置安卓系统版本
        capabilities.setCapability("platformVersion", "4.3");
        //设置apk路径
        capabilities.setCapability("app", app.getAbsolutePath()); 
        
        //设置app的主包名和主类名
        capabilities.setCapability("appPackage", "com.cheguo.tuoche");
        capabilities.setCapability("appActivity", "com.cheguo.tuoche.ui.activity.AppStart");
        
        //重置输入法
        capabilities.setCapability("unicodeKeyboard", true);//使用 Unicode 输入法  
        capabilities.setCapability("resetKeyboard", true);  //重置输入法到原有状态
        
        //初始化
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);       
    }
 
    @Test
    public void addContact() throws Throwable{
//        WebElement el = driver.findElement(By.name("Add Contact"));
//        el.click();
//        List<WebElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
//        textFieldsList.get(0).sendKeys("Some Name");
//        textFieldsList.get(2).sendKeys("Some@example.com");
//        driver.swipe(100, 500, 100, 100, 2);
//        driver.findElementByName("Save").click();
      
//      WebElement el = driver.findElement(By.id("account"));
//      el.click();
      Thread.sleep(2000);
      List<WebElement> textFieldsList = driver.findElements(By.className("android.widget.EditText"));
//      Thread.sleep(3000);
      textFieldsList.get(0).sendKeys("15068129031");
//      Thread.sleep(3000);
//      String pwd = "123456a";
//      System.out.println(pwd);
      textFieldsList.get(1).sendKeys("123456a");
      driver.findElement(By.id("bton")).click();
    	
//    	System.out.println(textFieldsList.size());
        
     
    	
    }    
    
    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

	
}
