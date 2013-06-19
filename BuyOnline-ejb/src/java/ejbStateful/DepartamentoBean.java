/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejbStateful;

import entity.Departamento;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface DepartamentoBean {

    public Departamento buscar(long id);

    public Departamento criar(Departamento departamento);

    public List<Departamento> buscar();
}
