
package vista;

/*import Modelo.DetalleFactura;
import Modelo.Factura; */
import Modelo.Producto;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;



public class Facturacion extends javax.swing.JFrame {

    public Facturacion() {
       initComponents();
       iniciarVentana();
    }
    
    private void iniciarVentana(){
        /*this.setLocationRelativeTo(null);
        this.setTitle("Panel Facturacion");
        this.setVisible(true);*/
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.btnAumentarCantidad.setActionCommand("aumentar");
        this.btnRestarCantidad.setActionCommand("restar");
        this.btnBorrarProducto.setActionCommand("borrar");
        selecionTabla();
    }
    
    private void selecionTabla(){
        this.jTablePrincipal.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
           if (this.jTablePrincipal.getSelectedRow()!= -1){
               int fila  = jTablePrincipal.getSelectedRow();
               this.txtCantidadIncremento.setText(this.jTablePrincipal.getValueAt
                                               (fila, 2).toString());
            }
       });
    }
    
    public JTable getjTablePrincipal() {
        return jTablePrincipal;
    }

    public JTextField getTxtIdFactura() {
        return txtIdFactura;
    }
    
    public int getCantidad(){
        int cantidad = 0;
        try{
            cantidad = Integer.parseInt(this.txtCantidadProd.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cantidad;
    }
    
    public int getCantidadIncremento(){
        int cantidad = 0;
        try{
            cantidad = Integer.parseInt(this.txtCantidadIncremento.getText());
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return cantidad;
    }
    
    public String getCodigoProducto(){
        try{
             Integer.parseInt( this.txtCodigoProd.getText());
             return this.txtCodigoProd.getText();
        }catch(Exception ex ){
            return "0" ;
        }
    }
    
    public void limparPanel(){
        this.txtCantidadIncremento.setText("");
        this.txtCantidadProd.setText("");
        this.txtCodigoProd.setText("");
        this.txtIdCliente.setText("");
        this.txtIdEmpleado.setText("");
        try{
            int nuevoNumFact = Integer.parseInt(this.txtIdFactura.getText());
            this.txtIdFactura.setText(String.valueOf(nuevoNumFact+1));
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        this.txtTotal.setText("");
        
        DefaultTableModel dtmProductos =(DefaultTableModel)this.jTablePrincipal.getModel();
         
        if (dtmProductos.getRowCount() != 0)
            {
              int d = dtmProductos.getRowCount();
              for (int y = 0; y < d; y++)
                {
                  dtmProductos.removeRow(0);
                }
            }
        this.jTablePrincipal.setModel(dtmProductos);
    }

    public void setListeners(ActionListener listener){
        this.bntBuscarProducto.addActionListener(listener);
        this.btnAgregar.addActionListener(listener);
        this.btnFinalizarVenta.addActionListener(listener);
        this.btnAumentarCantidad.addActionListener(listener);
    }
    
    public void calcularTotal (){
        
        DefaultTableModel dtmTabla =(DefaultTableModel)this.jTablePrincipal.getModel();
        float total = 0;
        if (dtmTabla.getRowCount() != 0)
            {
              int filas = dtmTabla.getRowCount();
              for (int i = 0; i < filas; i++)
                {
                  try{
                      float valor = Float.parseFloat(dtmTabla.getValueAt(i, 4).toString());
                      total = total + valor;
                  }catch(NumberFormatException ex){
                      JOptionPane.showMessageDialog(null, ex.getMessage());
                  }
                    
                }
              this.txtTotal.setText(String.valueOf(total));
            }
    }
            
         
    public void agregarProductoTabla(Producto producto, int cantidad){
        DefaultTableModel dtmTabla =(DefaultTableModel)this.jTablePrincipal.getModel();
      
        int filas = dtmTabla.getRowCount();
        boolean estado = true;
        int contador = 0;
        do{
            if ( contador != filas  ){
                int tempoId = Integer.valueOf(dtmTabla.getValueAt(contador, 0).toString());
                if (producto.getId() == tempoId ){
                    int tempoCant = Integer.valueOf(dtmTabla.getValueAt(contador, 2).toString());
                    
                    if (producto.getCantidad() < (tempoCant + cantidad)){
                        JOptionPane.showMessageDialog(null, "Stock insuficiente");
                    }else {
                        int nuevaCantida = tempoCant + cantidad;
                        dtmTabla.setValueAt(nuevaCantida, contador, 2);
                        Double subTotal = nuevaCantida * producto.getPrecio();
                        dtmTabla.setValueAt(subTotal, contador, 4);
                    }
                    estado = false;
                }
            }else {
                estado = false;
                this.jTablePrincipal.setModel(dtmTabla);
                Double subTotal = producto.getPrecio() * cantidad;
                dtmTabla.addRow(new Object[]
                      {
                      producto.getId(),
                      producto.getNombre(),
                      cantidad,
                      producto.getPrecio(),
                      subTotal
                      });
            }
            contador ++;
        }while (estado);

        calcularTotal();
        
        this.jTablePrincipal.setModel(dtmTabla);
    }
    
    /*public ArrayList<DetalleFactura> listaDetalleFactura( ){
        
        ArrayList<DetalleFactura> listaDetalle = new ArrayList(); 
        DefaultTableModel dtmTabla =(DefaultTableModel)this.jTablePrincipal.getModel();
            int filas = dtmTabla.getRowCount();
            
            for (int i = 0; i < filas; i++){
                DetalleFactura detalle = new DetalleFactura();
                detalle.setIdFactura(Integer.valueOf(this.txtIdFactura.getText()));
                detalle.setIdProducto(Integer.valueOf(dtmTabla.getValueAt(i, 0).toString()));
                detalle.setCantidad(Integer.valueOf(dtmTabla.getValueAt(i, 2).toString()));
                detalle.setPrecio(Float.valueOf(dtmTabla.getValueAt(i, 3).toString()));
                
                listaDetalle.add(detalle);
            }
            
            return listaDetalle;
    }*/

    /*public Factura crearObjetoFactura(){
        Factura factura = new Factura();
        
        try{
            
            factura.setId(Integer.valueOf(this.txtIdFactura.getText()));
            factura.setClienteId(this.txtIdCliente.getText());
            factura.setEmpleadoId(Integer.valueOf(this.txtIdEmpleado.getText()));
            factura.setPagoId(Integer.valueOf(this.txtIdFactura.getText()));
            int tipoVenta = this.boxTipoVenta.getSelectedIndex() + 1;
            factura.setTipoVentaId(tipoVenta);
            factura.setFecha(new Date().toString());
        
        }catch (NumberFormatException ex ){ 
            JOptionPane.showMessageDialog(null,"Error : " + 
                    ex.getMessage());
        }
       
        return factura;
    }*/
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePrincipal = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bntBuscarProducto = new javax.swing.JButton();
        btnCancelarVenta = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnFinalizarVenta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        boxTipoVenta = new javax.swing.JComboBox<>();
        txtIdFactura = new javax.swing.JTextField();
        txtIdEmpleado = new javax.swing.JTextField();
        txtIdCliente = new javax.swing.JTextField();
        txtCodigoProd = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnCargarVenta = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtCantidadProd = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnBorrarProducto = new javax.swing.JButton();
        btnRestarCantidad = new javax.swing.JButton();
        txtCantidadIncremento = new javax.swing.JTextField();
        btnAumentarCantidad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Venta");
        setBackground(new java.awt.Color(203, 240, 220));

        jTablePrincipal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTablePrincipal.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Cantidad", "Precio und", "Sub. Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTablePrincipal);
        if (jTablePrincipal.getColumnModel().getColumnCount() > 0) {
            jTablePrincipal.getColumnModel().getColumn(0).setResizable(false);
            jTablePrincipal.getColumnModel().getColumn(1).setResizable(false);
            jTablePrincipal.getColumnModel().getColumn(2).setResizable(false);
            jTablePrincipal.getColumnModel().getColumn(3).setResizable(false);
            jTablePrincipal.getColumnModel().getColumn(4).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(203, 240, 220));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bntBuscarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bntBuscarProducto.setText("Buscar Prod.");
        bntBuscarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntBuscarProductoActionPerformed(evt);
            }
        });

        btnCancelarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelarVenta.setText("Cancelar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnCancelarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bntBuscarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bntBuscarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );

        jPanel2.setBackground(new java.awt.Color(203, 240, 220));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Total");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(180, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnFinalizarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnFinalizarVenta.setText("Finalizar Venta");

        jPanel3.setBackground(new java.awt.Color(203, 240, 220));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Factura:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Cajero:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Cliente:");

        boxTipoVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxTipoVenta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mostrador", "Pedido" }));

        txtIdEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(boxTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIdFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(boxTipoVenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        txtCodigoProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btnAgregar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAgregar.setText("Agregar");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Agregar Producto:");

        btnCargarVenta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCargarVenta.setText("Cargar Pedido");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Cant.");

        txtCantidadProd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidadProd.setText("1");

        jPanel6.setBackground(new java.awt.Color(203, 240, 220));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnBorrarProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnBorrarProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete_delete_exit_1577.png"))); // NOI18N

        btnRestarCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnRestarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/arrowdown_flech_1539.png"))); // NOI18N

        txtCantidadIncremento.setEditable(false);
        txtCantidadIncremento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidadIncremento.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtCantidadIncremento.setText("0");

        btnAumentarCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAumentarCantidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/uparrow_arriba_1538.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtCantidadIncremento)
                    .addComponent(btnBorrarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnRestarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAumentarCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantidadIncremento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAumentarCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBorrarProducto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestarCantidad, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnFinalizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCantidadProd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAgregar)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnCargarVenta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigoProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidadProd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAgregar)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCargarVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnFinalizarVenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntBuscarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntBuscarProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bntBuscarProductoActionPerformed

    private void txtIdEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdEmpleadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdEmpleadoActionPerformed

    /**
     * @param args the command line arguments
     */
    /* public static void main(String args[]) {
      java.awt.EventQueue.invokeLater(() -> {
            new PanelProduccion().setVisible(true);
        });
    } */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntBuscarProducto;
    private javax.swing.JComboBox<String> boxTipoVenta;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAumentarCantidad;
    private javax.swing.JButton btnBorrarProducto;
    private javax.swing.JButton btnCancelarVenta;
    private javax.swing.JButton btnCargarVenta;
    private javax.swing.JButton btnFinalizarVenta;
    private javax.swing.JButton btnRestarCantidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePrincipal;
    private javax.swing.JTextField txtCantidadIncremento;
    private javax.swing.JTextField txtCantidadProd;
    private javax.swing.JTextField txtCodigoProd;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtIdEmpleado;
    private javax.swing.JTextField txtIdFactura;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
