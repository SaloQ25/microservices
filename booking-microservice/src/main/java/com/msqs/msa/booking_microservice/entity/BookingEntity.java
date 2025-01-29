package com.msqs.msa.booking_microservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name="booking")

public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    String lastname;
    String correo;

    public BookingEntity() {
        super();
    }
    public BookingEntity(Integer id, String name, String lastname, String correo) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.correo = correo;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
