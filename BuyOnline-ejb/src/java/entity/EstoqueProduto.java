/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="estoque_produto")
public class EstoqueProduto implements Serializable {

    @Id
    @GeneratedValue(generator = "ESTOQUEPRODUTO_SEQ")
    @SequenceGenerator(name = "ESTOQUEPRODUTO_SEQ", allocationSize = 1)
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    private Estoque estoque;
    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;
    @Column(length = 32)
    private int quantidade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}