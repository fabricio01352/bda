/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package collection;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author fabri
 */
@Entity
public class ClientesTelefonos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String clienteTelefonos;
    @ManyToOne 
    private Cliente cliente;

    public ClientesTelefonos(int id, String clienteTelefonos, Cliente cliente) {
        this.id = id;
        this.clienteTelefonos = clienteTelefonos;
        this.cliente = cliente;
    }

    public ClientesTelefonos(String clienteTelefonos, Cliente cliente) {
        this.clienteTelefonos = clienteTelefonos;
        this.cliente = cliente;
    }

    public ClientesTelefonos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClienteTelefonos() {
        return clienteTelefonos;
    }

    public void setClienteTelefonos(String clienteTelefonos) {
        this.clienteTelefonos = clienteTelefonos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    
    

}
