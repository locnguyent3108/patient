package com

import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import java.io.File
import java.net.URL
import java.util.concurrent.TimeUnit

import org.testng.annotations.*

class Patient_sbat_login {
    public lateinit var driver: AndroidDriver<*>
    public var fileName = "app-debug.apk"
    public var appVieVie = File("src/main/resources/$fileName")
    val serverAddress = URL("http://127.0.0.1:4723/wd/hub")



    @Test
    fun TC01_Login_via_Email() {
        val cap = DesiredCapabilities()
        cap.setCapability("app", appVieVie)
        //khai bao platform
        cap.setCapability("platformName", "ANDROID")
        //khai bao devicenName
        cap.setCapability("deviceName", "testing")
        //Tim app va cai dat app
        driver = AndroidDriver<MobileElement>(serverAddress, cap)
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.findElement(By.xpath("//android.widget.TextView[@text='ĐĂNG NHẬP']")).click()
        driver.findElement(By.xpath("//android.widget.EditText[@text='Nhập địa chỉ hộp thư']")).sendKeys("hue@yopmail.com")
        driver.findElement(By.xpath("//android.widget.EditText[@text='Nhập mật khẩu']")).sendKeys("123456")
        driver.hideKeyboard()
        Thread.sleep(3000)
        driver.findElement(By.xpath("(//android.widget.TextView[@text='ĐĂNG NHẬP'])[last()]")).click()
        driver.findElement(By.xpath("(//android.widget.TextView[@text='ĐĂNG NHẬP'])[last()]")).click()

    }

}

