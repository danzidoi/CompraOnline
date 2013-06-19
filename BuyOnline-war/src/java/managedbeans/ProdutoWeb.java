/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import ejbStateless.ProdutoBean;
import entity.Produto;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Marcelo
 */
@ManagedBean
@RequestScoped
public class ProdutoWeb {

    @EJB
    private ProdutoBean produtoBean;
    private Produto produto;

    public ProdutoWeb() {
    }

    public Produto getProduto() {
        return produto;
    }

    public List<Produto> getTodos() {
        List<Produto> ret = null;

        try {
            ret = produtoBean.buscar();
        } catch (Exception e) {
        }

        return ret;
    }

    public void buscarProduto(Long id) {
        try {
            produto = produtoBean.buscar(id);
        } catch (Exception e) {
        }
    }
}
