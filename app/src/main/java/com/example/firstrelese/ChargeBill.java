package com.example.firstrelese;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChargeBill {

    @SerializedName("data")
    @Expose
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
 class Data {
    @SerializedName("charge_id")
    @Expose
    private Integer chargeId;
    @SerializedName("number_of_car")
    @Expose
    private Integer numberOfCar;
    @SerializedName("number_of_subject")
    @Expose
    private Integer numberOfSubject;

    public Integer getChargeId() {
        return chargeId;
    }

    public void setChargeId(Integer chargeId) {
        this.chargeId = chargeId;
    }

    public Integer getNumberOfCar() {
        return numberOfCar;
    }

    public void setNumberOfCar(Integer numberOfCar) {
        this.numberOfCar = numberOfCar;
    }

    public Integer getNumberOfSubject() {
        return numberOfSubject;
    }

    public void setNumberOfSubject(Integer numberOfSubject) {
        this.numberOfSubject = numberOfSubject;
    }

}