package com.example.firstrelese;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class charge1 {

    @SerializedName("charge_id")
    @Expose
    private Integer chargeId;
    @SerializedName("number_of_car")
    @Expose
    private Integer numberOfCar;
    @SerializedName("number_of_subject")
    @Expose
    private Integer numberOfSubject;
    @SerializedName("created_at")
    @Expose
    private Object createdAt;
    @SerializedName("updated_at")
    @Expose
    private Object updatedAt;

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

    public Object getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Object createdAt) {
        this.createdAt = createdAt;
    }

    public Object getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Object updatedAt) {
        this.updatedAt = updatedAt;
    }
    @Override
    public String toString() {
        return "User [id=" + chargeId + ", "+ "first_name=" + numberOfCar + ", " + "last_name=" + numberOfSubject + ", " ;
    }
}
