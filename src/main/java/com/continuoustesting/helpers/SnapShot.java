package com.continuoustesting.helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Lazy
@Component
public class SnapShot {
    @Value("${snapshot.path}")
    private String snapPath;

    @Autowired
    private ApplicationContext ctx;

    public void shutterAs(final String filename) {
        Shutterbug.shootPage(ctx.getBean(WebDriver.class), Capture.FULL_SCROLL, 500, true).withName(filename)
                .save(snapPath);
    }

    public void shutterAs(final String filename, final WebElement element) {
        Shutterbug.shootElement(ctx.getBean(WebDriver.class), element).withName(filename).save(snapPath);
    }

    public String saveAs(final String imageName) throws IOException {
        FileUtils.copyFile(printScreen(), create(imageName));
        return create(imageName).getAbsolutePath();
    }

    public String saveAs(final String imageName, final WebElement element) throws IOException {
        // Get entire page screenshot
        File screenshot = printScreen();

        // Copy the element screenshot to disk
        var snapLocation = create(imageName);
        FileUtils.copyFile(cropElement(screenshot, element), snapLocation);
        return snapLocation.getAbsolutePath();
    }

    private File printScreen() {
        return ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
    }

    private File create(final String imageName) {
        return new File(snapPath + imageName);
    }

    private File cropElement(final File image, final WebElement element) throws IOException {
        BufferedImage fullImg = ImageIO.read(image);

        // Get the location of element on the page
        var point = element.getLocation();

        // Get width and height of the element
        int eleWidth = element.getSize().getWidth();
        int eleHeight = element.getSize().getHeight();

        // Crop the entire page screenshot to get only element screenshot
        BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
        ImageIO.write(eleScreenshot, "png", image);
        return image;
    }
}