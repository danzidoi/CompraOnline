/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ListaDeDesejos implements Serializable {

    @Id
    @GeneratedValue(generator = "CLIENTE_SEQ")
    @SequenceGenerator(name = "CLIENTE_SEQ", allocationSize = 1)
    private long id;
//    @ManyToMany(mappedBy = "desejadores", fetch = FetchType.EAGER)
//    private Set<Produto> desejados = new HashSet<Produto>();
    @OneToOne(fetch = FetchType.EAGER)
    private Cliente cliente;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public Set<Produto> getDesejados() {
//        return desejados;
//    }
//
//    public void setDesejados(Set<Produto> produtos) {
//        this.desejados = produtos;
//    }
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final ListaDeDesejos other = (ListaDeDesejos) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
