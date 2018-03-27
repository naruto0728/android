package com.application.example1;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.v4.app.FragmentActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    Instrumentation instrumentation;

    UiDevice device;
    @Before
    public void setUp(){
        instrumentation = InstrumentationRegistry.getInstrumentation();
        device = UiDevice.getInstance(instrumentation);
        try {
            device.wakeUp();
            /*for (int i = 0; i < lockkey.length(); i++) {
                String id = "com.android.keyguard:id/key" + lockkey.substring(i, i + 1);
                device.findObject(By.res(id)).click();
            }
            device.findObject(By.res("com.android.keyguard:id/key_enter")).click();*/
            SystemClock.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        startactivity();
        SystemClock.sleep(2000);

    }

    public void startactivity(){
        try{
            click_byid("button1");
        }catch (Exception e){
            e.printStackTrace();
        }
        SystemClock.sleep(1000);
        Context context = InstrumentationRegistry.getContext();
        Intent intent = context.getPackageManager().getLaunchIntentForPackage("com.application.example1");
        context.startActivity(intent);
    }

    public void click_byid(String id){
        device.findObject(By.res(id)).click();
    }
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.application.example1", appContext.getPackageName());

        device.findObject(By.res("com.application.example1:id/email_sign_in_button")).click();
        SystemClock.sleep(1000);
        //click ok
        device.findObject(By.res("com.application.example1:id/button2")).click();
        SystemClock.sleep(1000);

    }
}



