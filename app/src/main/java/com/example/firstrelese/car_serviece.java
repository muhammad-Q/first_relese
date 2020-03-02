package com.example.firstrelese;

public class car_serviece {
    private String message;
    public String getData() {
        return message;
    }

    public void setData(String data) {
        this.message = data;
    }

    @Override
    public String toString() {
        return "UserApiResponse [data=" +message + "]";
    }
}


