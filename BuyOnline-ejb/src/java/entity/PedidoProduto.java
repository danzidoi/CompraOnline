/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pedido_produto")
public class PedidoProduto implements Serializable {

    @Id
    @GeneratedValue(generator = "PEDIDOPRODUTO_SEQ")
    @SequenceGenerator(name = "PEDIDOPRODUTO_SEQ", allocationSize = 1)
    private long id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Pedido pedido;
    
    @OneToOne(fetch = FetchType.EAGER)
    private Produto produto;
    
    @Column(length = 32)
    private int quantidade;
    
    @Column(length = 32)
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataVenda;

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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