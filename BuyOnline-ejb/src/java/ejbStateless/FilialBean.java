/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateless;

import entity.Estoque;
import entity.Filial;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface FilialBean {

    public List<Filial> buscar();

    public Filial buscar(long id);

    public Filial criar(Filial filial);

    public Filial editar(Filial filial);

    public Estoque buscarEstoque(Filial filial);
}
