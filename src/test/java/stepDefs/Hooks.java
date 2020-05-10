package stepDefs;

import allure.AllureLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pageObject.BasePage;
import video.VideoWriter;
import webDriver.ManageDriver;


public class Hooks extends AllureLogger {

    static VideoWriter videoWriter;

    @Before
    public static void setUp(){
        videoWriter = new VideoWriter();
        BasePage basePage = new BasePage();
        basePage.openUrl();
        videoWriter.startRecording();
    }

    @After
    public static  void tearDown(){
        ManageDriver manageDriver = new ManageDriver();
        videoWriter = new VideoWriter();
        manageDriver.quitDriver();
        String pathToVideo = videoWriter.stopRecording();
        getRecordedVideo(pathToVideo);
    }
}
