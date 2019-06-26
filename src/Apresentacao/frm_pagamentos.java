/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentacao;

import Dados.vpago;
import Dados.vprodutos;
import Dados.vquartos;
import Dados.vreservas;
import Logica.conexao;
import Logica.fconsumo;
import Logica.fpago;
import Logica.fprodutos;
import Logica.fquartos;
import Logica.freservas;
import java.io.File;
import java.sql.Connection;
import java.util.Calendar;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Hugo
 */
public class frm_pagamentos extends javax.swing.JInternalFrame {

    /**
     * Creates new form frm_produtos
     */
    public frm_pagamentos() {
        initComponents();
         desativar();
        mostrar(id_reserva);
        txt_id_reserva.setText(id_reserva);
        txt_cliente.setText(cliente);
        txt_quarto.setText(quarto);
        txt_id_quarto.setText(id_quarto);
        txt_total_reserva.setText(Double.toString(total_reserva));
        fconsumo func = new fconsumo();
        func.mostrar(id_reserva);
        txt_total_pgto.setText(Double.toString(total_reserva + func.totalconsumo));
    }
    
    
    private String acao="salvar";
    public static String id_reserva;
    public static String cliente;
    public static String id_quarto;
    public static String quarto;
    public static Double total_reserva;
    
    
    void ocultar_coluna(){
        TB_lista.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(0).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        TB_lista.getColumnModel().getColumn(1).setMaxWidth(0);
        TB_lista.getColumnModel().getColumn(1).setMinWidth(0);
        TB_lista.getColumnModel().getColumn(1).setPreferredWidth(0);
    }
    
     void ocultar_coluna_consumo(){
        TB_lista_consumo.getColumnModel().getColumn(0).setMaxWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(0).setMinWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(0).setPreferredWidth(0);
        
        TB_lista_consumo.getColumnModel().getColumn(1).setMaxWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(1).setMinWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        TB_lista_consumo.getColumnModel().getColumn(2).setMaxWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(2).setMinWidth(0);
        TB_lista_consumo.getColumnModel().getColumn(2).setPreferredWidth(0);
    }
    
    void desativar(){
        txt_id_pagamento.setVisible(false);
        txt_id_reserva.setVisible(false);
        txt_id_quarto.setVisible(false);
        CB_tipo_comp.setEnabled(false);
        txt_cliente.setEnabled(false);
        txt_total_pgto.setEnabled(false);
        txt_quarto.setEnabled(false);
        txt_total_reserva.setEnabled(false);
        txt_data_emissao.setEnabled(false);
        txt_data_pgto.setEnabled(false);
        txt_numero_comp.setEnabled(false);
        txt_taxa.setEnabled(false);
        
        btn_salvar.setEnabled(false);
        
        btn_cancelar.setEnabled(false);
          
        
        
        
    }
    
    void ativar(){
         txt_id_pagamento.setVisible(false);
        txt_id_reserva.setVisible(false);
        txt_id_quarto.setVisible(false);
        CB_tipo_comp.setEnabled(true);
        txt_cliente.setEnabled(false);
        txt_total_pgto.setEnabled(false);
        txt_quarto.setEnabled(false);
        txt_total_reserva.setEnabled(false);
        txt_data_emissao.setEnabled(true);
        txt_data_pgto.setEnabled(true);
        txt_numero_comp.setEnabled(true);
        txt_taxa.setEnabled(true);
        
        
        btn_salvar.setEnabled(true);
        
        btn_cancelar.setEnabled(true);
          
       
    }
    
    void mostrar (String buscar){
        
        try{
            DefaultTableModel modelo;
            fpago func=new fpago();
            modelo = func.mostrar(buscar);
            TB_lista.setModel(modelo);
            ocultar_coluna();
            LB_registros.setText("Total Registros " + Integer.toString(func.totalregistros) );
            
             //Mostrar os dados dos consumos
            fconsumo func2 = new fconsumo();
            modelo= func2.mostrar(buscar);
            TB_lista_consumo.setModel(modelo);
            ocultar_coluna_consumo();
            
            LB_registros_consumos.setText("Total Consumos " + func2.totalregistros);
            LB_total_consumo.setText("Consumo Total: R$ " + func2.totalconsumo );
            
            
            
            
        }catch (Exception e){
            JOptionPane.showConfirmDialog(null, e);
        }
    }
    
    void limpar() {
      
       
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        CB_tipo_comp = new javax.swing.JComboBox<>();
        btn_novo = new javax.swing.JButton();
        btn_salvar = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        txt_id_pagamento = new javax.swing.JTextField();
        txt_id_reserva = new javax.swing.JTextField();
        txt_id_quarto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_quarto = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_numero_comp = new javax.swing.JTextField();
        txt_taxa = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_total_pgto = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txt_data_emissao = new com.toedter.calendar.JDateChooser();
        txt_data_pgto = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txt_total_reserva = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TB_lista_consumo = new javax.swing.JTable();
        LB_registros_consumos = new javax.swing.JLabel();
        LB_total_consumo = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TB_lista = new javax.swing.JTable();
        btn_sair1 = new javax.swing.JButton();
        btn_apagar1 = new javax.swing.JButton();
        LB_registros = new javax.swing.JLabel();
        btn_nota = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Cadastro de Pagamentos");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Cadastro de Pagamentos");

        jLabel3.setText("Cliente");

        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });

        jLabel4.setText("Tipo Comp");

        CB_tipo_comp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NOTA", "FATURA", "TICKET", "OUTRO" }));
        CB_tipo_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB_tipo_compActionPerformed(evt);
            }
        });

        btn_novo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/novo.GIF"))); // NOI18N
        btn_novo.setText("Novo");
        btn_novo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_novoActionPerformed(evt);
            }
        });

        btn_salvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/salvar.png"))); // NOI18N
        btn_salvar.setText("Salvar");
        btn_salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salvarActionPerformed(evt);
            }
        });

        btn_cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/cancelar.png"))); // NOI18N
        btn_cancelar.setText("Limpar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Número Quarto");

        txt_quarto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quartoActionPerformed(evt);
            }
        });

        jLabel8.setText("Número Comp");

        txt_numero_comp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_numero_compActionPerformed(evt);
            }
        });

        txt_taxa.setText("0");
        txt_taxa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_taxaActionPerformed(evt);
            }
        });

        jLabel9.setText("Taxa");

        txt_total_pgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_pgtoActionPerformed(evt);
            }
        });

        jLabel14.setText("Total Pgto");

        jLabel15.setText("Data Emissão");

        jLabel16.setText("Data Pgto");

        jLabel7.setText("Total Reserva");

        txt_total_reserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_reservaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(33, 33, 33)
                                .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_id_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_id_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btn_novo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_salvar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_total_pgto)
                                    .addComponent(txt_data_emissao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_data_pgto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel16)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(CB_tipo_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_total_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt_numero_comp, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(txt_taxa, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_id_pagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_reserva, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_quarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_total_reserva, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(CB_tipo_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_numero_comp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_taxa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txt_total_pgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txt_data_emissao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(txt_data_pgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_novo)
                    .addComponent(btn_salvar)
                    .addComponent(btn_cancelar))
                .addContainerGap(83, Short.MAX_VALUE))
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setText("Lista de Consumos");

        TB_lista_consumo.setBackground(new java.awt.Color(204, 204, 204));
        TB_lista_consumo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TB_lista_consumo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_lista_consumoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TB_lista_consumo);

        LB_registros_consumos.setText("Registros");

        LB_total_consumo.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_total_consumo)
                .addGap(136, 136, 136)
                .addComponent(LB_registros_consumos)
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LB_registros_consumos)
                    .addComponent(LB_total_consumo))
                .addGap(46, 46, 46))
        );

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Lista de Pagamentos");

        TB_lista.setBackground(new java.awt.Color(204, 204, 204));
        TB_lista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TB_lista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TB_listaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(TB_lista);

        btn_sair1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/cancelar.png"))); // NOI18N
        btn_sair1.setText("Sair");
        btn_sair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sair1ActionPerformed(evt);
            }
        });

        btn_apagar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Files/images/icones/salvar.png"))); // NOI18N
        btn_apagar1.setText("Apagar");
        btn_apagar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_apagar1ActionPerformed(evt);
            }
        });

        LB_registros.setText("Registros");

        btn_nota.setText("Nota Fiscal");
        btn_nota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_notaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btn_nota, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(btn_apagar1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_sair1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(LB_registros)
                .addGap(28, 28, 28))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_apagar1)
                    .addComponent(btn_sair1)
                    .addComponent(btn_nota))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LB_registros)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clienteActionPerformed
        txt_cliente.transferFocus();
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void CB_tipo_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB_tipo_compActionPerformed
        CB_tipo_comp.transferFocus();
    }//GEN-LAST:event_CB_tipo_compActionPerformed

    private void btn_novoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_novoActionPerformed
        ativar();
        btn_salvar.setText("Salvar");
        acao="salvar";
        
    }//GEN-LAST:event_btn_novoActionPerformed

    private void btn_salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salvarActionPerformed
        if (txt_cliente.getText().length() == 0){
            JOptionPane.showMessageDialog(rootPane, "Insira o nome do produto");
            txt_cliente.requestFocus();
            return;
        }

       
        vpago dts = new vpago();
        fpago func = new fpago();

        dts.setIdreserva(Integer.parseInt(txt_id_reserva.getText()));
        dts.setNum_comprovante(txt_numero_comp.getText());
        dts.setTaxa(Double.parseDouble(txt_taxa.getText()));
        dts.setTotal_pagamento(Double.parseDouble(txt_total_pgto.getText()));
       
        
        Calendar cal;
        int d,m,a;
        
        cal=txt_data_pgto.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setData_pagamento(new Date (a,m,d));
        
        
        cal=txt_data_emissao.getCalendar();
        d=cal.get(Calendar.DAY_OF_MONTH);
        m=cal.get(Calendar.MONTH);
        a=cal.get(Calendar.YEAR) - 1900;
        
        dts.setData_emissao(new Date (a,m,d));
        

        int selecionado = CB_tipo_comp.getSelectedIndex();
        dts.setTipo_comprovante((String) CB_tipo_comp.getItemAt(selecionado));

        

        if(acao.equals("salvar")){
            if(func.inserir(dts)){
                JOptionPane.showMessageDialog(rootPane, "O pagamento foi registrado com sucesso!");
                mostrar(id_reserva);
                desativar();
                
                 //Desocupar o quarto
                fquartos func2 = new fquartos();
                vquartos dts2 = new vquartos();
                
                dts2.setIdquartos(Integer.parseInt(txt_id_quarto.getText()));
                func2.desocupar(dts2);
                
                //Cancelar ou Pagar a reserva
                
                freservas func3 = new freservas();
                vreservas dts3 = new vreservas();
                
                dts3.setIdreserva(Integer.parseInt(txt_id_reserva.getText()));
                func3.pagar(dts3);
                
            }
        }
        else if(acao.equals("editar")){
            dts.setIdpagamento(Integer.parseInt(txt_id_pagamento.getText()));

            if(func.editar(dts)){
                JOptionPane.showMessageDialog(rootPane, "O pagamento foi editado com sucesso!");
                mostrar(id_reserva);
                desativar();
            }
        }
    }//GEN-LAST:event_btn_salvarActionPerformed

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        limpar();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void TB_lista_consumoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_lista_consumoMouseClicked
     
      
    }//GEN-LAST:event_TB_lista_consumoMouseClicked

    private void TB_listaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TB_listaMouseClicked
        btn_salvar.setText("Editar");
        ativar();
        btn_apagar1.setEnabled(true);
        acao="editar";
        int linha = TB_lista.rowAtPoint(evt.getPoint());

        txt_id_pagamento.setText(TB_lista.getValueAt(linha, 0).toString());
        txt_id_reserva.setText(TB_lista.getValueAt(linha, 1).toString());
        CB_tipo_comp.setSelectedItem(TB_lista.getValueAt(linha, 2).toString());
        txt_numero_comp.setText(TB_lista.getValueAt(linha, 3).toString());
        txt_taxa.setText(TB_lista.getValueAt(linha, 4).toString());
        txt_total_pgto.setText(TB_lista.getValueAt(linha, 5).toString());
        txt_data_emissao.setDate(Date.valueOf(TB_lista.getValueAt(linha, 6).toString()));
        txt_data_pgto.setDate(Date.valueOf(TB_lista.getValueAt(linha, 7).toString()));
        
    }//GEN-LAST:event_TB_listaMouseClicked

    private void btn_sair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_sair1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_sair1ActionPerformed

    private void btn_apagar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_apagar1ActionPerformed
       
        if (!txt_id_pagamento.getText().equals("")) {
            int confirmacao = JOptionPane.showConfirmDialog(rootPane, "Deseja realmente excluir este registro", "Exluir", 2);

            if (confirmacao==0) {
                fpago func = new fpago ();
                vpago dts= new vpago();

                dts.setIdpagamento(Integer.parseInt(txt_id_pagamento.getText()));
                func.deletar(dts);
                mostrar(id_reserva);
                desativar();

            }

        }
                                   
    }//GEN-LAST:event_btn_apagar1ActionPerformed

    private void txt_quartoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quartoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quartoActionPerformed

    private void txt_numero_compActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_numero_compActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_numero_compActionPerformed

    private void txt_taxaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_taxaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_taxaActionPerformed

    private void txt_total_pgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_pgtoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_pgtoActionPerformed

    private void txt_total_reservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_reservaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_total_reservaActionPerformed

    private Connection connection=new conexao().conectar();
    
    private void btn_notaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_notaActionPerformed
        if(!txt_id_pagamento.getText().equals("")){ 
        Map p=new HashMap();
         p.put("id_pagamento", txt_id_pagamento.getText());
      JasperReport relatorio;
      JasperPrint impressao;
      
      try{
          relatorio = JasperCompileManager.compileReport(new File("").getAbsolutePath()+
          "/src/Relatorios/rel_nota.jrxml");
          impressao = JasperFillManager.fillReport(relatorio, p, connection);
          JasperViewer view = new JasperViewer(impressao, false);
          view.setTitle("Nota Fiscal");
          view.setVisible(true);
      }catch(Exception e){
          e.printStackTrace();
      }
        }
    }//GEN-LAST:event_btn_notaActionPerformed

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
            java.util.logging.Logger.getLogger(frm_pagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_pagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_pagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_pagamentos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_pagamentos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_tipo_comp;
    private javax.swing.JLabel LB_registros;
    private javax.swing.JLabel LB_registros_consumos;
    private javax.swing.JLabel LB_total_consumo;
    private javax.swing.JTable TB_lista;
    private javax.swing.JTable TB_lista_consumo;
    private javax.swing.JButton btn_apagar1;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_nota;
    private javax.swing.JButton btn_novo;
    private javax.swing.JButton btn_sair1;
    private javax.swing.JButton btn_salvar;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField txt_cliente;
    private com.toedter.calendar.JDateChooser txt_data_emissao;
    private com.toedter.calendar.JDateChooser txt_data_pgto;
    private javax.swing.JTextField txt_id_pagamento;
    private javax.swing.JTextField txt_id_quarto;
    private javax.swing.JTextField txt_id_reserva;
    private javax.swing.JTextField txt_numero_comp;
    private javax.swing.JTextField txt_quarto;
    private javax.swing.JTextField txt_taxa;
    private javax.swing.JTextField txt_total_pgto;
    private javax.swing.JTextField txt_total_reserva;
    // End of variables declaration//GEN-END:variables
}
