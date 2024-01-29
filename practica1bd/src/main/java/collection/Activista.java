/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author fabri
 */
@Entity
public class Activista implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String telefono;
    private Date fechaInicio;
    
    @ManyToMany(mappedBy = "activistas")
    Set<Problema> problemas = new HashSet<>();

    public Activista(int id, String nombre, String telefono, Date fechaInicio) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
    }

    public Activista(String nombre, String telefono, Date fechaInicio, Set<Problema> problemas) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
        this.problemas = problemas;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(Set<Problema> problemas) {
        this.problemas = problemas;
    }

    
    
    
    public Activista(String nombre, String telefono, Date fechaInicio) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.fechaInicio = fechaInicio;
    }

    public Activista() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString() {
        return "Activista{" + "id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", fechaInicio=" + fechaInicio + ", problemas=" + problemas + '}';
    }

}
