package org.example.framework.util;

import org.example.framework.driver.DriverManager;
import org.example.framework.elements.BaseElement;
import org.example.framework.elements.ElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/*
* Class for parsing lists of elements
* */
public class ElementsListGatherer {

    private List<BaseElement> elementsList = new ArrayList<>();
    private String locator;
    private String elementName;
    private String elementType;


    public ElementsListGatherer(String locator, String elementName, String elementType) {
        this.locator = locator;
        this.elementName = elementName;
        this.elementType = elementType;
        init();
    }

    private void init() {
        List<WebElement> webElementList = DriverManager.getInstance().findElements(By.xpath(locator));
        for (int i = 0; i < webElementList.size(); i++) {
            String elementLocator = locator + String.format("[%d]", i+1);
            BaseElement element = ElementFactory.valueOf(elementType.toUpperCase()).createElement(elementLocator,
                    elementName + i);
            elementsList.add(element);
        }
    }

    public List<? extends BaseElement> getElementsList(){
        return elementsList;
    }

    public BaseElement get(Integer i) {
        return elementsList.get(i);
    }
}
