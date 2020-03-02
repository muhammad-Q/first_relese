package com.example.firstrelese;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class Charge {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("properties")
    @Expose
    private Properties properties;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

} class CarNumber {

    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}


class DriverName {

    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}



class DriverNumber {

    @SerializedName("type")
    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}


class Properties {

    @SerializedName("car_number")
    @Expose
    private CarNumber carNumber;
    @SerializedName("driver_number")
    @Expose
    private DriverNumber driverNumber;
    @SerializedName("driver_name")
    @Expose
    private DriverName driverName;

    public CarNumber getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(CarNumber carNumber) {
        this.carNumber = carNumber;
    }

    public DriverNumber getDriverNumber() {
        return driverNumber;
    }

    public void setDriverNumber(DriverNumber driverNumber) {
        this.driverNumber = driverNumber;
    }

    public DriverName getDriverName() {
        return driverName;
    }

    public void setDriverName(DriverName driverName) {
        this.driverName = driverName;
    }

}