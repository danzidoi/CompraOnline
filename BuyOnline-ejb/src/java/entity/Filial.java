/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Filial implements Serializable {

    @Id
    @GeneratedValue(generator = "FILIAL_SEQ")
    @SequenceGenerator(name = "FILIAL_SEQ", allocationSize = 1)
    private long id;
    @Column(length = 32)
    private int cnpj;
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCNPJ() {
        return cnpj;
    }

    public void setCNPJ(int CNPJ) {
        this.cnpj = CNPJ;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Filial other = (Filial) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
}
