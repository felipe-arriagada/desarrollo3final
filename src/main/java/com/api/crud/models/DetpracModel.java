package com.api.crud.models;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "detalle_practica")
public class DetpracModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String descripcion_practica;

    // Solo la relación de clave foránea al ID del usuario
    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column
    private Date fecha_inicio;

    @Column
    private Date fecha_termino;

    @Column
    private Integer telefono;

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion_practica() {
        return descripcion_practica;
    }

    public void setDescripcion_practica(String descripcion_practica) {
        this.descripcion_practica = descripcion_practica;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_termino() {
        return fecha_termino;
    }

    public void setFecha_termino(Date fecha_termino) {
        this.fecha_termino = fecha_termino;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }
}
