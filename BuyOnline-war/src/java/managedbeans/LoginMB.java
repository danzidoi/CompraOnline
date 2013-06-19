/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejbStateless.ClienteBean;
import entity.Cliente;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "LoginMB")
@SessionScoped
public class LoginMB {

    @EJB
    private ClienteBean clienteBean;
    private Cliente cliente = new Cliente();
    private boolean logado = false;
    private String email;
    private String senha;
    private String nome;

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getNome() {
        return nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isLogado() {
        return logado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String login() {
        cliente = clienteBean.buscar(this.email, this.senha);

        if (cliente != null) {
            this.nome = cliente.getNome();
            logado = true;
        } else {
            this.nome = "";
            this.email = "";
            this.senha = "";
            logado = false;
        }

        return logado ? "login" : "falha";
    }

    public String logout() {
        if (logado) {
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.invalidate();
            cliente = null;
            logado = false;
        }
        return "logout";
    }
}
