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
import entity.Cliente;
import entity.Departamento;
import entity.Endereco;
import entity.Estoque;
import entity.EstoqueProduto;
import entity.Filial;
import entity.Pedido;
import entity.PedidoProduto;
import entity.Produto;
import entity.enumerador.situacaoEntrega;
import entity.enumerador.situacaoPagamento;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.naming.InitialContext;
import utility.GetEJB;
import javax.naming.NamingException;

/**
 *
 * @author Marcelo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
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
        
        

        Departamento departamento = CriarDepartamento("departamento1");;;
        Departamento departamento2 = CriarDepartamento("departamento2");

        Random numeroRandomicos = new Random();

        List<Produto> produtos = new ArrayList();
        produtos.add(CriarProduto("produto2", numeroRandomicos.nextInt(10000), "descricao2", departamento));
        produtos.add(CriarProduto("produto3", numeroRandomicos.nextInt(10000), "descricao3", departamento));
        produtos.add(CriarProduto("produto4", numeroRandomicos.nextInt(10000), "descricao4", departamento2));
        produtos.add(CriarProduto("produto5", numeroRandomicos.nextInt(10000), "descricao5", departamento2));
        produtos.add(CriarProduto("produto6", numeroRandomicos.nextInt(10000), "descricao6", departamento2));

        CriarEstoque(1233112);
        CriarEstoque(99999112);

        Estoque estoque = BuscarEstoque(1);

        for (Produto produto : produtos) {
            CriarEstoqueProduto(estoque.getId(), produto.getId(), 1 + numeroRandomicos.nextInt(101));
        }

        CriarPedido();

        Pedido pedido = BuscarPedido(1);

        for (Produto produto : produtos) {
            CriarPedidoProduto(pedido.getId(), produto.getId(), 1 + numeroRandomicos.nextInt(4), dataDeHoje);
            
        };
        
        CriarCliente("Marcelo Vocatore");
    }

    private static void CriarCliente(String nome) throws NamingException {
        Cliente cliente = new Cliente();

        cliente.setNome(nome);
        cliente.setEmail("marcelovocatore@hotmail.com");
        cliente.setSenha("teste123");
        cliente.setTelefone("323232323");
        cliente.setCpf("00802588085");

        clienteBean.criar(cliente);
    }

    private static void CriarEstoque(int cnpj) throws NamingException {
        Estoque estoque = NovoEstoque(cnpj);

        estoqueBean.criar(estoque);

        List<Estoque> estoques = estoqueBean.buscar();
    }

    private static void CriarPedido() throws NamingException {
        Pedido pedido = NovoPedido();

        PedidoBean pedidoBean1 = getEJB.getPedido();

        pedidoBean1.criar(pedido);

        List<Pedido> pedidos = pedidoBean1.buscar();
    }

    private static void CriarEstoqueProduto(long estoqueId,
            long produtoId,
            int quantidade) throws NamingException {
        EstoqueProduto estoqueProduto = NovoEstoqueProduto(estoqueId, produtoId, quantidade);

        estoqueProdutoBean.criar(estoqueProduto);
    }

    private static void CriarPedidoProduto(long pedidoId,long produtoId, int quantidade, Date date) throws NamingException {
        PedidoProduto pedidoProduto = NovoPedidoProduto(pedidoId, produtoId, quantidade, date);

        pedidoProdutoBean.criar(pedidoProduto);
    }

    private static Departamento CriarDepartamento(String nome) throws NamingException {
        Departamento departamento = NovoDepartamento(nome);

        return departamentoBean.criar(departamento);
    }

    private static Produto CriarProduto(String nome,
            float quantidade,
            String descricao,
            Departamento departamento) throws NamingException {
        Produto produto = NovoProduto(nome, quantidade, descricao, departamento);

        return produtoBean.criar(produto);
    }

    private static Produto BuscarProduto(long produtoId) throws NamingException {
        Produto produto = produtoBean.buscar(produtoId);

        return produto;
    }

    private static Estoque BuscarEstoque(long estoqueId) throws NamingException {
        Estoque estoque = estoqueBean.buscar(estoqueId);

        return estoque;
    }

    private static Pedido BuscarPedido(long pedidoId) throws NamingException {
        Pedido pedido = pedidoBean.buscar(pedidoId);

        return pedido;
    }

    private static Produto NovoProduto(String nome,
            float quantidade,
            String descricao,
            Departamento departamento) {
        Produto produto = new Produto();

        produto.setNome(nome);
        produto.setPreco(quantidade);
        produto.setDescricao(descricao);
        produto.setDepartamento(departamento);

        return produto;
    }

    private static Estoque NovoEstoque(int cnpj) {
        Estoque estoque = new Estoque();

        estoque.setFilial(NovoFilial(cnpj));

        return estoque;
    }

    private static EstoqueProduto NovoEstoqueProduto(long estoqueId,
            long produtoId,
            int quantidade) throws NamingException {
        EstoqueProduto estoqueProduto = new EstoqueProduto();

        estoqueProduto.setEstoque(BuscarEstoque(estoqueId));
        estoqueProduto.setProduto(BuscarProduto(produtoId));
        estoqueProduto.setQuantidade(quantidade);

        return estoqueProduto;
    }

    private static PedidoProduto NovoPedidoProduto(long pedidoId,long produtoId,int quantidade, Date date) throws NamingException {
        PedidoProduto pedidoProduto = new PedidoProduto();

        pedidoProduto.setPedido(BuscarPedido(pedidoId));
        pedidoProduto.setProduto(BuscarProduto(produtoId));
        pedidoProduto.setQuantidade(quantidade);

        return pedidoProduto;
    }

    private static Departamento NovoDepartamento(String nome) {
        Departamento departamento = new Departamento();

        departamento.setNome(nome);

        return departamento;
    }

    private static Endereco NovoEndereco() {
        Endereco endereco = new Endereco();

        endereco.setCEP("880555");
        endereco.setComplemento("casa2");
        endereco.setLogradouro("rua teste");
        endereco.setNumero(12);

        return endereco;
    }

    private static Filial NovoFilial(int cnpj) {
        Filial filial = new Filial();

        filial.setCNPJ(cnpj);
        filial.setEndereco(NovoEndereco());

        return filial;
    }

    private static Pedido NovoPedido() {
        Pedido pedido = new Pedido();

        pedido.setStatusEntrega(situacaoEntrega.AGUARDANDO_PAGAMENTO);
        pedido.setStatusPagamento(situacaoPagamento.PENDENTE);

        return pedido;
    }
}
