package org.example;

public class CouriersOrderRequest {
    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public CouriersOrderRequest(int courierId) {
        this.courierId = courierId;
    }

    private int courierId;

    public String getNearestStation() {
        return nearestStation;
    }

    public void setNearestStation(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    public CouriersOrderRequest(int courierId, String nearestStation) {
        this.courierId = courierId;
        this.nearestStation = nearestStation;
    }

    public CouriersOrderRequest(String nearestStation) {
        this.nearestStation = nearestStation;
    }

    private String nearestStation;
}