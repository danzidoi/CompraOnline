/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package principal;
import ejbStateful.DepartamentoBean;
import ejbStateful.EstoqueBean;
import ejbStateful.EstoqueProdutoBean;
import ejbStateful.PedidoBean;
import ejbStateful.PedidoProdutoBean;
import ejbStateless.ClienteBean;
import ejbStateless.ProdutoBean;
import entity.Pedido;
import entity.PedidoProduto;
import entity.Produto;
import java.util.Date;
import javax.naming.NamingException;
import utility.GetEJB;
/**
 *
 * @author GFactory
 */
public class testDate {
   private static GetEJB getEJB;
    private static DepartamentoBean departamentoBean;
    private static EstoqueBean estoqueBean;
    private static PedidoBean pedidoBean;
    private static EstoqueProdutoBean estoqueProdutoBean;
    private static PedidoProdutoBean pedidoProdutoBean;
    private static ProdutoBean produtoBean;
    private static ClienteBean clienteBean;
    
    private static Date dataDeHoje = new Date();

    public static void main(String[] args) throws NamingException {
        getEJB = new GetEJB();
        departamentoBean = getEJB.getDepartamento();
        estoqueBean = getEJB.getEstoque();
        pedidoBean = getEJB.getPedido();
        estoqueProdutoBean = getEJB.getEstoqueProduto();
        pedidoProdutoBean = getEJB.getPedidoProduto();
        produtoBean = getEJB.getProduto();
        clienteBean = getEJB.getCliente();    
        
        PedidoProduto pproduto = new PedidoProduto();
        
        Pedido ped = pedidoBean.buscar(1);
        Produto pro = produtoBean.buscar(1);
        
        pproduto.setPedido(ped);
        pproduto.setProduto(pro);
        pproduto.setQuantidade(12);
        pproduto.setDataVenda(dataDeHoje);
        pedidoProdutoBean.criar(pproduto);
}
}
