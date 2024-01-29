/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author fabri
 */
@Entity
public class Problema implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;

    public enum Estado {
        ACTIVO("Activo"),
        INACTIVO("Inactivo"),
        PENDIENTE("Pendiente");

        private final String label;

        /**
         * cada constante de la enumeración tiene asociado un label que
         * representa la cadena correspondiente al estado
         *
         * @param label
         */
        Estado(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaFin;

    @ManyToOne
    private Cliente clienteProblema;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
    name = "problemasAnidados",
    joinColumns = @JoinColumn(name = "activista_id"),
    inverseJoinColumns = @JoinColumn(name = "problema_id")
    )
    Set<Activista> activistas = new HashSet<>();

    public Problema(String nombre, Estado estado, Date fechaInicio, Date fechaFin, Cliente clienteProblema, Set<Activista> activistas) {
        this.nombre = nombre;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.clienteProblema = clienteProblema;
        this.activistas = activistas;
    }

    public String getNombre() {
        return nombre;
    }

    public Cliente getClienteProblema() {
        return clienteProblema;
    }

    public void setClienteProblema(Cliente clienteProblema) {
        this.clienteProblema = clienteProblema;
    }

    public Set<Activista> getActivistas() {
        return activistas;
    }

    public void setActivistas(Set<Activista> activistas) {
        this.activistas = activistas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cliente getCliente() {
        return clienteProblema;
    }

    public void setCliente(Cliente cliente) {
        this.clienteProblema = cliente;
    }

    public Problema(int id, String nombre, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Problema() {
    }

    public Problema(String nombre, Estado estado, Date fechaInicio, Date fechaFin) {
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreProblema() {
        return nombre;
    }

    public void setNombreProblema(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

}
