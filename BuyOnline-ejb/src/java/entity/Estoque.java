/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class Estoque implements Serializable {

    @Id
    @GeneratedValue(generator = "ESTOQUE_SEQ")
    @SequenceGenerator(name = "ESTOQUE_SEQ", allocationSize = 1)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Filial filial;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
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
        final Estoque other = (Estoque) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
