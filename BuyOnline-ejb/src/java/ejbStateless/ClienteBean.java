/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateless;

import entity.Cliente;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ClienteBean {

    public Cliente buscar(long id);

    public List<Cliente> buscar();

    public Cliente editar(Cliente cliente);

    public Cliente criar(Cliente cliente);

    public Cliente buscar(String email, String senha);

    public Cliente buscar(String email);
}
