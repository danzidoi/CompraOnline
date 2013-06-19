/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateless;

import entity.Produto;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ProdutoBean {

    public Produto buscar(long id);

    public List<Produto> buscar();

    public Produto editar(Produto produto);

    public Produto criar(Produto produto);
}
