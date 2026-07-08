package com.G1_DSI.PPAI.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name= "usuarios")
public class Usuario {
    @Id
    @Column(name= "id")
    private int id;
    @Column(name= "nombre")
    private String nombre;
}
