/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.ListaDeDesejos;
import entity.Produto;
import java.util.List;


public interface ListaDeDesejosBean {

    public ListaDeDesejos buscar(long id);

    public void adicionarProduto(Produto produto);

    public void removerProduto(Produto produto);
    
    public List<Produto> getProduto();
}
