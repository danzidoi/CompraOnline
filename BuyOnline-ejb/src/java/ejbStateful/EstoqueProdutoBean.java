/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.EstoqueProduto;
import javax.ejb.Remote;

@Remote
public interface EstoqueProdutoBean {

    public EstoqueProduto buscar(long id);
    
    public EstoqueProduto criar(EstoqueProduto estoqueProduto);

    public EstoqueProduto editar(EstoqueProduto estoqueProduto);
}
