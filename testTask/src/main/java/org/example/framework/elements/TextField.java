package org.example.framework.elements;

import org.openqa.selenium.By;

public class TextField extends BaseElement {

    public TextField(String locator, String name) {
        super(locator, name);
    }
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public String getText() {
        return findElement().getText();
    }

    public void setText(String text) {
        findElement().sendKeys(text);
    }
}
