package com.hezhi3f.entity;

import java.io.Serializable;

public class Payment implements Serializable {
    private Integer id;
    private String serial;

    public Payment() {
    }

    public Payment(Integer id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
