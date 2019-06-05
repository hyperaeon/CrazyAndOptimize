package com.boast.chain;

public abstract class Manager {

    protected String name;

    protected Manager superior;

    public Manager(String name) {
        this.name = name;
    }

    public void setSuperior(Manager superior) {
        this.superior = superior;
    }

    abstract public void requestApplication(Request request);
}
