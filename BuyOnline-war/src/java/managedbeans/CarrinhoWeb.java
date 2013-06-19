// This file is a part of dcstore project,
// licensed under GPLv2
//
// Dominik Cebula
// dominikcebula@gmail.com
package managedbeans;

import ejbStateful.PedidoBean;
import ejbStateful.PedidoProdutoBean;
import ejbStateless.ClienteBean;
import ejbStateless.ProdutoBean;
import entity.Pedido;
import entity.PedidoProduto;
import entity.Produto;
import entity.enumerador.situacaoEntrega;
import entity.enumerador.situacaoPagamento;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CarrinhoWeb {

    private List<PosicaoCarrinhoWeb> produtos = new ArrayList<PosicaoCarrinhoWeb>();
    @EJB
    private ProdutoBean produtoBean;
    @EJB
    private PedidoBean pedidoBean;
    @EJB
    private PedidoProdutoBean pedidoProdutoBean;
    @EJB
    private ClienteBean clienteBean;

    public List<PosicaoCarrinhoWeb> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<PosicaoCarrinhoWeb> produtos) {
        this.produtos = produtos;
    }

    public CarrinhoWeb() {
    }

    public int find(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).equals(produto)) {
                return i;
            }
        }
        return -1;
    }

    public void finalizar() {
        Long idCliente = 0L;
        idCliente = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));

        try {
            Pedido pedido = new Pedido();
            pedido.setCliente(clienteBean.buscar(idCliente));
            pedido.setStatusPagamento(situacaoPagamento.PENDENTE);
            pedido.setStatusEntrega(situacaoEntrega.AGUARDANDO_PAGAMENTO);

            pedido = pedidoBean.criar(pedido);

            for (PosicaoCarrinhoWeb produto : produtos) {
                CriarPedidoProduto(pedido, produto.getProduto(), produto.getQtd());
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Erro enquanto fechava pedido!"));
        }
    }

    private void CriarPedidoProduto(Pedido pedido,
            Produto produto,
            int quantidade) {
        PedidoProduto pedidoProduto = NovoPedidoProduto(pedido, produto, quantidade);

        pedidoProdutoBean.criar(pedidoProduto);
    }

    private PedidoProduto NovoPedidoProduto(Pedido pedido,
            Produto produto,
            int quantidade) {
        PedidoProduto pedidoProduto = new PedidoProduto();

        pedidoProduto.setPedido(pedido);
        pedidoProduto.setProduto(produto);
        pedidoProduto.setQuantidade(quantidade);

        return pedidoProduto;
    }

    public void addProduto() {
        Long idProduto = 0L;
        idProduto = Long.parseLong(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id"));

        try {
            Produto produto = produtoBean.buscar(idProduto);
            int idx = find(produto);
            if (idx == -1) {
                produtos.add(new PosicaoCarrinhoWeb(produto, 1));
            } else {
                produtos.get(idx).incQtd();
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Error while adding produto to cart"));
        }
    }
}
