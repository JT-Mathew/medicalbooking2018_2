package com.example.demotest;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.URL;
import java.util.List;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

@FixMethodOrder

public class AndroidContactsTest {

    //Driver
    private AppiumDriver<AndroidElement> driver;


    /**
     * 配置启动driver
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

        File classpathRoot = new File(System.getProperty("user.dir"));
        //app的目录
        File appDir = new File(classpathRoot, "/src/main/java/apps/");
        //app的名字，对应你apps目录下的文件
        File app = new File(appDir, "app-debug.apk");
        //创建Capabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "UiAutomator2");
        //设置要调试的模拟器的名字
        capabilities.setCapability("deviceName","Nexus");
        //设置模拟器的系统版本
        capabilities.setCapability("platformVersion", "8.1");
        //设置app的路径
        capabilities.setCapability("app", app.getAbsolutePath());
        //设置app的包名
        capabilities.setCapability("appPackage", "c.hayeon.seproject");
        //设置app的启动activity
        capabilities.setCapability("appActivity", ".LoginActivity");
        //启动driver
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    @After
    public void tearDown() throws Exception {
        //测试完毕，关闭driver，不关闭将会导致会话还存在，下次启动就会报错
        driver.quit();
    }


    /**
     * 要执行的的测试方法
     */
    @Test
    public void loginTest(){
        System.out.println("Login Test!");
        //利用Xpath的方法寻找text值为Add Contact的控件
        //WebElement el = driver.findElement(By.xpath(".//*[@text='Add Contact']"));
        //点击这个控件
        //el.click();
        //利用类名获取界面上所有的EditText
        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        //第一个EditText输入内容Some Name
        textFieldsList.get(0).sendKeys("1");
        //第三个EditText输入内容Some Name
        textFieldsList.get(1).sendKeys("1");
        //在坐(100,500)滑动到(100,100) 时间为2毫秒
        //driver.swipe(100, 500, 100, 100, 2);
        //用xpath的方式寻找到text值为Save的控件，然后点击
        driver.findElementByXPath(".//*[@text='LOGIN']").click();
        System.out.println("Login function is working.");
    }

    @Test
    public void makeAnAppointmentTest(){
        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("1");
        textFieldsList.get(1).sendKeys("1");
        driver.findElementByXPath(".//*[@text='LOGIN']").click();
        System.out.println("Make An Appointment Test!");
        WebElement el = driver.findElementByXPath(".//*[@text='Make an \nAppointment']");
        el.click();
        driver.findElement(By.xpath(".//*[@text=’11/10/2018’]")).click();
        driver.findElement(By.xpath(".//*[@text=’9:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’OK’]")).click();
        driver.findElement(By.xpath(".//*[@text=’BOOK’]")).click();
        /*driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’9:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’11:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’12/10/2018’]")).click();
        driver.findElement(By.xpath(".//*[@text=’9:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’9:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’11:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’13/10/2018’]")).click();
        driver.findElement(By.xpath(".//*[@text=’9:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’9:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’11:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’14/10/2018’]")).click();
        driver.findElement(By.xpath(".//*[@text=’9:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’9:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’11:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’15/10/2018’]")).click();
        driver.findElement(By.xpath(".//*[@text=’9:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’9:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’11:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’16/10/2018’]")).click();
        driver.findElement(By.xpath(".//*[@text=’9:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’9:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’10:30’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’11:00’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Jane Doe’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Blah Test’]")).click();
        driver.findElement(By.xpath(".//*[@text=’Third Doc’]")).click();

        driver.findElement(By.xpath(".//*[@text=’BOOK’]")).click();*/
        System.out.println("The make an appointment function is working.");
    }


    @Test
    public void manageAnAppointment() {
        System.out.println("Manage An Appointment Test!");
        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("1");
        textFieldsList.get(1).sendKeys("1");
        driver.findElementByXPath(".//*[@text='LOGIN']").click();
        WebElement el = driver.findElement(By.xpath(".//*[@text='MANAGE AN APPOINTMENT']"));
        el.click();
        System.out.println("Manage an appointment function is working.");
    }

    @Test
    public void editDetail() {
        System.out.println("Edit Details Test!");
        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("1");
        textFieldsList.get(1).sendKeys("1");
        driver.findElementByXPath(".//*[@text='LOGIN']").click();
        WebElement el = driver.findElement(By.xpath(".//*[@text='MY DETAILS']"));
        el.click();
        textFieldsList.get(0).sendKeys("Some Name");
        textFieldsList.get(1).sendKeys("Some Name");
        textFieldsList.get(4).sendKeys("Some Name");
        textFieldsList.get(5).sendKeys("Some Name");
        textFieldsList.get(7).sendKeys("Some Name");
        driver.findElement(By.xpath(".//*[@text=’UPDATE’]")).click();
        System.out.println("Edit details function is working.");
    }


    @Test
    public void pastAppointment() {
        System.out.println("Past Appointment Test!");
        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        textFieldsList.get(0).sendKeys("1");
        textFieldsList.get(1).sendKeys("1");
        driver.findElementByXPath(".//*[@text='LOGIN']").click();
        WebElement el = driver.findElement(By.xpath(".//*[@text='PAST APPOINTMENT']"));
        el.click();
        System.out.println("Past appointment function is working.");
    }

    @Test
    public void back() {
        System.out.println("Back test is not finished");
    }


    @Test
    public void exit() {
        System.out.println("Exit Test!");
        WebElement el = driver.findElement(By.xpath(".//*[@text='EXIT']"));
        el.click();
        List<AndroidElement> textFieldsList = driver.findElementsByClassName("android.widget.EditText");
        System.out.println("Exit function is working.");
    }


}