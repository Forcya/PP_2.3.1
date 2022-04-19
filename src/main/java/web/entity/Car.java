package web.entity;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String brand;
    private String model;
    private String body;


    public Car() {
    }

    public Car(String brand, String model, String body) {
        this.brand = brand;
        this.model = model;
        this.body = body;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
