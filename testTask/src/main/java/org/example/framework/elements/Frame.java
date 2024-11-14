package org.example.framework.elements;

import org.openqa.selenium.By;

public class Frame extends BaseElement {

    public Frame(String locator, String name) {
        super(locator, name);
    }
    public Frame(By locator, String name) {
        super(locator, name);
    }
}
