package org.example.framework.elements;

import org.openqa.selenium.By;

import java.util.List;

public class Table extends  BaseElement {

    private List<TableRow> rowGroupList;

    public Table(String locator, String name) {
        super(locator, name);
    }
    public Table(By locator, String name) {
        super(locator, name);
    }

    public List<TableRow> getRowGroupList(){
        return  this.rowGroupList;
    }

    public void setRowGroupList(List<TableRow> rowGroupList) {
        this.rowGroupList = rowGroupList;
    }
}
