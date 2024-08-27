package com.restaurant.models;

import java.sql.Date;
import java.sql.Time;

public class Reservation {
    private int reservationId;
    private int userId;
    private String type;
    private Date date;
    private Time time;
    private String status;

    public Reservation() {
    }

    public Reservation(int reservationId, int userId, String type, Date date, Time time, String status) {
        this.reservationId = reservationId;
        this.userId = userId;
        this.type = type;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public Reservation(int userId, String type, Date date, Time time, String status) {
        this.userId = userId;
        this.type = type;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
