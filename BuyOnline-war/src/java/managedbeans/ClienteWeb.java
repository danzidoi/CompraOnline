package managedbeans;

import ejbStateless.ClienteBean;
import entity.Cliente;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class ClienteWeb {

    private Cliente cliente = new Cliente();
    @EJB
    private ClienteBean clienteBean;

    public ClienteWeb() {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void criar() {
        try {
            cliente = clienteBean.criar(cliente);
        } catch (Exception e) {
        }
    }
}
