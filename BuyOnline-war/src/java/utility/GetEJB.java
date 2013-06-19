package utility;

//import ejbStateful.DepartamentoBean;
//import ejbStateful.EstoqueBean;
//import ejbStateful.EstoqueProdutoBean;
//import ejbStateful.PedidoBean;
//import ejbStateful.PedidoProdutoBean;
//import ejbStateless.ClienteBean;
import ejbStateless.ClienteBean;
//import ejbStateless.EnderecoBean;
//import ejbStateless.FilialBean;
//import ejbStateless.ProdutoBean;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class GetEJB {

    private InitialContext ctx;

    public GetEJB() throws NamingException {
        getContext();
    }

    private void getContext() throws NamingException {
        ctx = new InitialContext();
    }

    public ClienteBean getCliente() throws NamingException {
        getContext();
        return (ClienteBean) ctx.lookup("ejb/cliente");
    }

//    public EnderecoBean getEndereco() throws NamingException {
//        getContext();
//        return (EnderecoBean) ctx.lookup("ejb/endereco");
//    }
//
//    public FilialBean getFilial() throws NamingException {
//        getContext();
//        return (FilialBean) ctx.lookup("ejb/filial");
//    }
//
//    public ProdutoBean getProduto() throws NamingException {
//        getContext();
//        return (ProdutoBean) ctx.lookup("ejb/produto");
//    }
//
//    public EstoqueBean getEstoque() throws NamingException {
//        getContext();
//        return (EstoqueBean) ctx.lookup("ejb/estoque");
//    }
//
//    public DepartamentoBean getDepartamento() throws NamingException {
//        getContext();
//        return (DepartamentoBean) ctx.lookup("ejb/departamento");
//    }
//
//    public PedidoBean getPedido() throws NamingException {
//        getContext();
//        return (PedidoBean) ctx.lookup("ejb/pedido");
//    }
//
//    public EstoqueProdutoBean getEstoqueProduto() throws NamingException {
//        getContext();
//        return (EstoqueProdutoBean) ctx.lookup("ejb/estoqueProduto");
//    }
//
//    public PedidoProdutoBean getPedidoProduto() throws NamingException {
//        getContext();
//        return (PedidoProdutoBean) ctx.lookup("ejb/pedidoProduto");
//    }
}
