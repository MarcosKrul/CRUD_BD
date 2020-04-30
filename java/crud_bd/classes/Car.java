/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud_bd.classes;

import java.util.Objects;

/**
 *
 * @author marco
 */
public class Car {

    private Integer id_car;
    private Integer id_foreign;

    private String model;
    private String brand;
    private String licensePlate;
    private String color;

    public Car() {
    }

    public Car(String model, String brand, String licensePlate, String color) {
        this.model = model;
        this.brand = brand;
        this.licensePlate = licensePlate;
        this.color = color;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + Objects.hashCode(this.id_car);
        hash = 67 * hash + Objects.hashCode(this.model);
        hash = 67 * hash + Objects.hashCode(this.licensePlate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.licensePlate, other.licensePlate)) {
            return false;
        }
        if (!Objects.equals(this.id_car, other.id_car)) {
            return false;
        }
        return true;
    }

    public Integer getId_car() {
        return id_car;
    }

    public void setId_car(Integer id_car) {
        this.id_car = id_car;
    }

    public Integer getId_foreign() {
        return id_foreign;
    }

    public void setId_foreign(Integer id_foreign) {
        this.id_foreign = id_foreign;
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

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Modelo: "+model+"-"+brand+" ("+color+")"+" / Placa: "+licensePlate;
    }

}
