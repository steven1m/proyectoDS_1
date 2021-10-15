/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;
import Modelo.*;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class ClienteForm extends javax.swing.JInternalFrame {

    Cliente c = new Cliente();
    ClienteDAO cdao = new ClienteDAO();
    DefaultTableModel modelo = new DefaultTableModel();
    
    public ClienteForm() {
        initComponents();
       listar();
    }
    
    void listar(){
      List<Cliente> lista = (List) cdao.listar();
      modelo = (DefaultTableModel)tablacliente.getModel();
      Object[] ob = new Object[7];
      
      for(int i = 0; i < lista.size(); i++){
          ob[0]= lista.get(i).getId();
          ob[1]= lista.get(i).getNombre();
          ob[2]= lista.get(i).getApellido();
          ob[3]= lista.get(i).getCedula();
          ob[4]= lista.get(i).getTelefono();
          ob[5]= lista.get(i).getDireccion();
          ob[6]= lista.get(i).getEstado();
          modelo.addRow(ob);
      }
     /*for(Cliente cl: lista){
            Object [] fila = {cl.getId(),cl.getNombre(),cl.getApellido(),cl.getCedula(),cl.getTelefono(),cl.getDireccion(),cl.getEstado()};
             modelo.addRow(fila);
             //cbFiltrar.addItem("");
             //cbFiltrar.addItem(cl.toString());
        }*/
    tablacliente.setModel(modelo);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtcedula = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        cbestado = new javax.swing.JComboBox<>();
        Bagreagar = new javax.swing.JButton();
        Bactualizar = new javax.swing.JButton();
        Beliminar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablacliente = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        setIconifiable(true);
        setTitle("CLIENTES");
        setPreferredSize(new java.awt.Dimension(787, 404));

        jLabel1.setText("ID");

        jLabel2.setText("NOMBRE");

        jLabel3.setText("APELLIDO");

        jLabel4.setText("CEDULA");

        jLabel5.setText("TELEFONO");

        jLabel6.setText("DIRECCION");

        jLabel7.setText("ESTADO");

        txtid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidActionPerformed(evt);
            }
        });

        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });

        cbestado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "1", "0" }));

        Bagreagar.setText("AGREGAR");
        Bagreagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BagreagarActionPerformed(evt);
            }
        });

        Bactualizar.setText("ACTUALIZAR");
        Bactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BactualizarActionPerformed(evt);
            }
        });

        Beliminar.setText("ELIMINAR");
        Beliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeliminarActionPerformed(evt);
            }
        });

        tablacliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "APELLIDO", "CEDULA", "TELEFONO", "DIRECCION", "ESTADO"
            }
        ));
        tablacliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaclienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablacliente);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 741, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtapellido, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(txtid)
                    .addComponent(txtnombre)
                    .addComponent(txtcedula)
                    .addComponent(txttelefono)
                    .addComponent(txtdireccion)
                    .addComponent(cbestado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Bagreagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bactualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(Beliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bagreagar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Bactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Beliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel6)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel7))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoActionPerformed

    private void BagreagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BagreagarActionPerformed
        agregar();
         limpiar();
        listar();
    }//GEN-LAST:event_BagreagarActionPerformed

    private void BactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BactualizarActionPerformed
        actualizar();
         limpiar();
        listar();
    }//GEN-LAST:event_BactualizarActionPerformed

    private void BeliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeliminarActionPerformed
        eliminar();
         limpiar();
        listar();
    }//GEN-LAST:event_BeliminarActionPerformed

    private void tablaclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaclienteMouseClicked
        int fila = tablacliente.getSelectedRow();
        if(fila == -1){
            JOptionPane.showMessageDialog(this,"DEBE SELECCIONAR UNA FILA");
        }
        else{
           int id = Integer.parseInt(tablacliente.getValueAt(fila, 0).toString());
        String nombre = tablacliente.getValueAt(fila,1).toString();
        String apellido = tablacliente.getValueAt(fila,2).toString();
        String cedula = tablacliente.getValueAt(fila, 3).toString();
        String direccion = tablacliente.getValueAt(fila, 4).toString();
        String telefono = tablacliente.getValueAt(fila, 5).toString();
        String estado = tablacliente.getValueAt(fila, 6).toString();
        
        txtid.setText(String.valueOf(id));
        txtnombre.setText(nombre);
        txtapellido.setText(apellido);
        txtcedula.setText(cedula);
        txtdireccion.setText(direccion);
        txttelefono.setText(telefono);
        cbestado.setSelectedItem(estado);
        }
    }//GEN-LAST:event_tablaclienteMouseClicked

    void nuevo(){}
    void agregar(){
        int id = Integer.parseInt(txtid.getText());
        String nombre = txtnombre.getText();
        String apellido = txtapellido.getText();
        String cedula = txtcedula.getText();
        String direccion = txtdireccion.getText();
        String telefono = txttelefono.getText();
        String estado = cbestado.getSelectedItem().toString();
        
        Object[] ob = new Object[7];
        ob[0]= id;
        ob[1]= nombre;
        ob[2]= apellido;
        ob[3]= cedula;
        ob[4]= direccion;
        ob[5]= telefono;
        ob[6]= estado;
        cdao.agregar(ob);
    }
    void actualizar(){
         int fila = tablacliente.getSelectedRow();
          int ids = Integer.parseInt(tablacliente.getValueAt(fila, 0).toString());
        if(fila == 1){
            JOptionPane.showMessageDialog(this,"DEBE SELECCIONAR UNA FILA");
        }
        else{
       int id = Integer.parseInt(txtid.getText());
        String nombre = txtnombre.getText();
        String apellido = txtapellido.getText();
        String cedula = txtcedula.getText();
        String direccion = txtdireccion.getText();
        String telefono = txttelefono.getText();
        String estado = cbestado.getSelectedItem().toString();
        
        Object[] ob = new Object[7];
        ob[0]= id;
        ob[1]= nombre;
        ob[2]= apellido;
        ob[3]= cedula;
        ob[4]= direccion;
        ob[5]= telefono;
        ob[6]= estado;
        cdao.actualizar(ob);
        }
    
    }
    void eliminar(){
          int fila = tablacliente.getSelectedRow();
          int ids = Integer.parseInt(tablacliente.getValueAt(fila, 0).toString());
        if(fila == 1){
            JOptionPane.showMessageDialog(this,"DEBE SELECCIONAR UNA FILA");
        }
        else{
          cdao.eliminar(ids);
        }
    }
    void limpiar(){
    
       for(int i = 0; i<modelo.getRowCount();i++){
           modelo.removeRow(i);
           i = i-1;
       }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bactualizar;
    private javax.swing.JButton Bagreagar;
    private javax.swing.JButton Beliminar;
    private javax.swing.JComboBox<String> cbestado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablacliente;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables
}
