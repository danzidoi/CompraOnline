/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPontoVenda;

import ejbStateful.DepartamentoBean;
import ejbStateful.EstoqueBean;
import ejbStateful.EstoqueProdutoBean;
import ejbStateful.PedidoBean;
import ejbStateful.PedidoProdutoBean;
import ejbStateless.ProdutoBean;
import entity.Pedido;
import entity.PedidoProduto;
import entity.Produto;
import entity.enumerador.situacaoEntrega;
import entity.enumerador.situacaoPagamento;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import utility.GetEJB;
import java.util.Date;

/**
 *
 * @author GFactory
 */
public class DesktopStart extends javax.swing.JFrame {

    /**
     * Creates new form DesktopStart, and initializes beans!
     */
    private FechamentoPedidoBalcaoGUI fechamentoPedidoBalcaoGUI;
    private static GetEJB getEJB;
    private static DepartamentoBean departamentoBean;
    private static EstoqueBean estoqueBean;
    private static PedidoBean pedidoBean;
    private static EstoqueProdutoBean estoqueProdutoBean;
    private static PedidoProdutoBean pedidoProdutoBean;
    private static ProdutoBean produtoBean;
    private static Date dataDeHoje = new Date();
    
    List<Produto> produtos = new ArrayList<Produto>();
    List<Integer> qtd = new ArrayList<Integer>();
    
    
    public DesktopStart() throws NamingException {
    

        getEJB = new GetEJB();
        departamentoBean = getEJB.getDepartamento();
        estoqueBean = getEJB.getEstoque();
        pedidoBean = getEJB.getPedido();
        estoqueProdutoBean = getEJB.getEstoqueProduto();
        pedidoProdutoBean = getEJB.getPedidoProduto();
        produtoBean = getEJB.getProduto();
        
        this.fechamentoPedidoBalcaoGUI = new FechamentoPedidoBalcaoGUI();
        
        //this.fechamentoPedidoBalcaoGUI.setMenuAdmin(this);
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NovoPedido = new javax.swing.JFrame();
        labelProduto1 = new javax.swing.JLabel();
        LabelDepto1 = new javax.swing.JLabel();
        butonFecharPedido = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jScrollPane1 = new javax.swing.JScrollPane();
        pedidosTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        CodProdutoField = new javax.swing.JTextField();
        QtdProdutoField = new javax.swing.JTextField();
        qtdLabel = new javax.swing.JLabel();
        fieldVarTotalItems = new javax.swing.JTextField();
        labelTotal = new javax.swing.JLabel();
        menuMain = new javax.swing.JMenuBar();
        vendasMenu = new javax.swing.JMenu();
        CriarPedidoMenu = new javax.swing.JMenuItem();
        EmissaoRelatoriosMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        ManutencaoEstoqueMenu = new javax.swing.JMenu();
        AdicionarProdutoMenu = new javax.swing.JMenuItem();
        ReposicaoEstoqueMenu = new javax.swing.JMenuItem();
        ConsultaPedidosMenu = new javax.swing.JMenu();

        NovoPedido.setTitle("Novo Pedido");
        NovoPedido.setBounds(new java.awt.Rectangle(250, 250, 400, 400));
        NovoPedido.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        NovoPedido.addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                NovoPedidoWindowStateChanged(evt);
            }
        });

        labelProduto1.setText("Produto 1:");

        LabelDepto1.setText("Cod.:");

        butonFecharPedido.setText("Fechar Pedido");
        butonFecharPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butonFecharPedidoActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        pedidosTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Produto", "Pre�o", "Quantidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pedidosTable);
        pedidosTable.getColumnModel().getColumn(2).setResizable(false);
        pedidosTable.getColumnModel().getColumn(3).setResizable(false);

        jButton1.setText("Adicionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        qtdLabel.setText("Qtd.:");

        fieldVarTotalItems.setEditable(false);

        labelTotal.setText("Total R$:");

        javax.swing.GroupLayout NovoPedidoLayout = new javax.swing.GroupLayout(NovoPedido.getContentPane());
        NovoPedido.getContentPane().setLayout(NovoPedidoLayout);
        NovoPedidoLayout.setHorizontalGroup(
            NovoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NovoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NovoPedidoLayout.createSequentialGroup()
                        .addComponent(labelProduto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(NovoPedidoLayout.createSequentialGroup()
                        .addComponent(LabelDepto1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(CodProdutoField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(qtdLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QtdProdutoField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(NovoPedidoLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(NovoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotal)
                            .addComponent(fieldVarTotalItems, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, NovoPedidoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butonFecharPedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonCancelar)
                .addGap(18, 18, 18))
        );
        NovoPedidoLayout.setVerticalGroup(
            NovoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NovoPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(NovoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelProduto1)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(NovoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelDepto1)
                    .addComponent(CodProdutoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(QtdProdutoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtdLabel))
                .addGroup(NovoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(NovoPedidoLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(NovoPedidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                        .addComponent(labelTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldVarTotalItems, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(NovoPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butonFecharPedido)
                    .addComponent(buttonCancelar))
                .addGap(55, 55, 55))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Desktop Sales Manager");

        vendasMenu.setMnemonic('v');
        vendasMenu.setText("Vendas");
        vendasMenu.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                vendasMenuComponentAdded(evt);
            }
        });

        CriarPedidoMenu.setText("Criar Pedido");
        CriarPedidoMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CriarPedidoMenuActionPerformed(evt);
            }
        });
        vendasMenu.add(CriarPedidoMenu);

        menuMain.add(vendasMenu);

        EmissaoRelatoriosMenu.setText("Emiss�o de Relat�rios");

        jMenuItem1.setText("jMenuItem1");
        EmissaoRelatoriosMenu.add(jMenuItem1);

        menuMain.add(EmissaoRelatoriosMenu);

        ManutencaoEstoqueMenu.setText("Manuten��o de Estoque");

        AdicionarProdutoMenu.setText("Adicionar Produtos");
        ManutencaoEstoqueMenu.add(AdicionarProdutoMenu);

        ReposicaoEstoqueMenu.setText("Reposi��o Estoque");
        ManutencaoEstoqueMenu.add(ReposicaoEstoqueMenu);

        menuMain.add(ManutencaoEstoqueMenu);

        ConsultaPedidosMenu.setText("Consulta de Pedidos");
        menuMain.add(ConsultaPedidosMenu);

        setJMenuBar(menuMain);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 602, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 422, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vendasMenuComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_vendasMenuComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_vendasMenuComponentAdded

    private void CriarPedidoMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CriarPedidoMenuActionPerformed
          NovoPedido.setVisible(true);
 
    }//GEN-LAST:event_CriarPedidoMenuActionPerformed

    private void NovoPedidoWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_NovoPedidoWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_NovoPedidoWindowStateChanged

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        NovoPedido.setVisible(false);
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void butonFecharPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butonFecharPedidoActionPerformed
        //variavel de controle pro for each.
        int quantidadeAtual = 0;
        
        //Instancia um pedido novo e j� persiste.
        Pedido pedido = new Pedido();
        pedido.setCliente(null);
        pedido.setStatusEntrega(situacaoEntrega.ENVIADO);
        pedido.setStatusPagamento(situacaoPagamento.PAGO);
        //pedido instanciado para come�ar a criar as relacoes produto_pedido.
        pedido = pedidoBean.criar(pedido);
        //pedido produto instanciado para percorrer vetor de produtos e adicionar!
        
        PedidoProduto pproduto = new PedidoProduto();
        pproduto.setPedido(pedido);
        pproduto.setDataVenda(dataDeHoje);
        
        for (Produto p : produtos){
           
            
            pproduto.setPedido(pedido);
            pproduto.setProduto(p);
            pproduto.setQuantidade(qtd.get(quantidadeAtual));
            pproduto.setDataVenda(dataDeHoje);
            pedidoProdutoBean.criar(pproduto);
            quantidadeAtual++;
        }
        quantidadeAtual = 0;
        produtos.clear();
        
        //limpa produtos da tabela.
        DefaultTableModel model = (DefaultTableModel) pedidosTable.getModel(); 
           while (model.getRowCount() !=0){
               model.removeRow(0);
           }

        
        JOptionPane.showMessageDialog(null, "Pedido Fechado com Sucesso!");
        //   NovoPedido.setVisible(false);
        //   pedidosTable.removeRowSelectionInterval(0, pedidosTable.getRowCount()-1);

    }//GEN-LAST:event_butonFecharPedidoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.AdicionarTablePedidos();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
 public void AdicionarTablePedidos() {
        DefaultTableModel model = (DefaultTableModel) pedidosTable.getModel(); 
        
                
       // Integer totalToRemover = model.getRowCount();
       // for (int i=0; i<totalToRemover; i++)
       //     model.removeRow(0);

        Produto prod = new Produto();
        prod = produtoBean.buscar(Integer.parseInt(CodProdutoField.getText()));
        
        //Lista dos produtos sendo adicionados ao pedido para no final de tudo, assosciar ao pedido.
        
        produtos.add(prod);
        qtd.add(Integer.parseInt(QtdProdutoField.getText()));
        
                        
            //abaixo, estrutura para satisfazer apenas a GUI.
            Vector<Object> vector = new Vector<Object>();
            vector.add(prod.getId()); 
            
            vector.add(prod.getDescricao());
            vector.add(prod.getPreco());
            vector.add(Integer.parseInt(QtdProdutoField.getText()));
            model.addRow(vector);
            
         
         // Ver porque essa merda abaixo da pau com contas de float... que inferno   
         //   if (fieldVarTotalItems == null){
         //     fieldVarTotalItems.setText(String.valueOf(prod.getPreco()));
         //   } else {
         //       float totalPedido = Float.parseFloat(fieldVarTotalItems.getText()) + prod.getPreco();
         //       fieldVarTotalItems.setText(String.valueOf(totalPedido));
         //   }
            
            
            }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DesktopStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DesktopStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DesktopStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DesktopStart.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new DesktopStart().setVisible(true);
                } catch (NamingException ex) {
                    Logger.getLogger(DesktopStart.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AdicionarProdutoMenu;
    private javax.swing.JTextField CodProdutoField;
    private javax.swing.JMenu ConsultaPedidosMenu;
    private javax.swing.JMenuItem CriarPedidoMenu;
    private javax.swing.JMenu EmissaoRelatoriosMenu;
    private javax.swing.JLabel LabelDepto1;
    private javax.swing.JMenu ManutencaoEstoqueMenu;
    private javax.swing.JFrame NovoPedido;
    private javax.swing.JTextField QtdProdutoField;
    private javax.swing.JMenuItem ReposicaoEstoqueMenu;
    private javax.swing.JButton butonFecharPedido;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JTextField fieldVarTotalItems;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelProduto1;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JMenuBar menuMain;
    private javax.swing.JTable pedidosTable;
    private javax.swing.JLabel qtdLabel;
    private javax.swing.JMenu vendasMenu;
    // End of variables declaration//GEN-END:variables
}
