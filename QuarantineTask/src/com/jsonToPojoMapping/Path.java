package com.jsonToPojoMapping;

public class Path {
    private Element[] element;
    private Elem[] elem;
    private String origin;
    private String target;

    // Getters and Setters
    public Element[] getElement() {
        return element;
    }

    public void setElement(Element[] element) {
        this.element = element;
    }

    public Elem[] getElem() {
        return elem;
    }

    public void setElem(Elem[] elem) {
        this.elem = elem;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }
}
