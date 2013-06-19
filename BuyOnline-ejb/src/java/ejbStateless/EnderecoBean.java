/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateless;

import entity.Cliente;
import entity.Endereco;
import entity.Filial;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface EnderecoBean {
    
    public List<Endereco> buscar();

    public Endereco buscar(long id);

    public Endereco editar(Endereco endereco);

    public Endereco criar(Endereco endereco);

    public Filial buscarFilial(Endereco endereco);

    public Cliente buscarCliente(Endereco endereco);
}
