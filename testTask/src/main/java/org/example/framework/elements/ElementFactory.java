package org.example.framework.elements;

public enum ElementFactory {
    BUTTON {
        @Override
        public BaseElement createElement(String locator, String name) {
          return new Button(locator, name);
        }

    },
    TABLE {
        @Override
        public BaseElement createElement(String locator, String name) {
            return new Table(locator, name);
        }

    },
    TABLEROW {
        @Override
        public BaseElement createElement(String locator, String name) {
            return new TableRow(locator, name);
        }

    };

    public abstract BaseElement createElement(String locator, String name);
}
