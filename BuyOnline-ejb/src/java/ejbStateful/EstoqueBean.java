/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.Estoque;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface EstoqueBean {

    public Estoque buscar(long id);

    public Estoque criar(Estoque estoque);

    public List<Estoque> buscar();
}
