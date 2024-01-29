/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author fabri
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String nombre;
    private String direccion;
    
    // TELEFONOS 
    @OneToMany(mappedBy = "cliente")
    private List<ClientesTelefonos> telefonos;

    @OneToMany(mappedBy = "clienteProblema")
    private List<Problema> problemas;
    
    public Cliente() {
    }

    public Cliente(String nombre, String direccion, List<ClientesTelefonos> telefonos) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
    }

    
    
    

    public Cliente(int id, String nombre, String direccion) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public Cliente(String nombre, String direccion, List<ClientesTelefonos> telefonos, List<Problema> problemas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.problemas = problemas;
    }

    public List<Problema> getProblemas() {
        return problemas;
    }

    public void setProblemas(List<Problema> problemas) {
        this.problemas = problemas;
    }

 
    
    

//    public Cliente(String nombre, String direccion, List<ClientesTelefonos> telefonos) {
//        this.nombre = nombre;
//        this.direccion = direccion;
//        this.telefonos = telefonos;
//    }

    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public List<ClientesTelefonos> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<ClientesTelefonos> telefonos) {
        this.telefonos = telefonos;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
    

}
