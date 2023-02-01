package com.mx.springframework.test.bean;

public class Husband {

    private IWife wife;

    public String queryWife(){
        return "Husband.wife";
    }

    public IWife getWife() {
        return wife;
    }

    public void setWife(IWife wife) {
        this.wife = wife;
    }

}
