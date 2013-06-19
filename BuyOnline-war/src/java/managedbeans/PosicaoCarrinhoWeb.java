package managedbeans;

import entity.Produto;

/**
 *
 * @author mvocatore
 */
public class PosicaoCarrinhoWeb {

    private Produto produto;
    private int qtd;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public PosicaoCarrinhoWeb(Produto produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Produto) {
            Produto p = (Produto) o;
            return this.produto.equals(p);
        } else if (o instanceof Produto) {
            PosicaoCarrinhoWeb c = (PosicaoCarrinhoWeb) o;
            return this.produto.equals(c.produto);
        } else {
            return false;
        }
    }

    public void incQtd() {
        ++this.qtd;
    }
}