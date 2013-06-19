/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.enumerador.situacaoEntrega;
import entity.enumerador.situacaoPagamento;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(generator = "PEDIDO_SEQ")
    @SequenceGenerator(name = "PEDIDO_SEQ", allocationSize = 1)
    private long id;
    
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Cliente cliente;
    
    @Enumerated(EnumType.STRING)
    private situacaoPagamento statusPagamento;
    
    @Enumerated(EnumType.STRING)
    private situacaoEntrega statusEntrega;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public situacaoPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(situacaoPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public situacaoEntrega getStatusEntrega() {
        return statusEntrega;
    }

    public void setStatusEntrega(situacaoEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Pedido other = (Pedido) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
