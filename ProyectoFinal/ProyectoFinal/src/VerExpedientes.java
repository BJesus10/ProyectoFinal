
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class VerExpedientes extends javax.swing.JFrame {

  
    private GestorTramites gestor;

    public VerExpedientes(GestorTramites gestor) {
        this.gestor = gestor;
        initComponents();
    }

    
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaExpedientes = new javax.swing.JTable();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); 
        jLabel1.setText("VER EXPEDIENTES");

        tablaExpedientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                
            }
        ));
        jScrollPane1.setViewportView(tablaExpedientes);

        btnActualizar.setBackground(new java.awt.Color(204, 204, 255));
        btnActualizar.setForeground(new java.awt.Color(255, 51, 51));
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnVolver.setText("VOLVER AL MENU");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 750, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(291, 291, 291)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVolver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
         btnActualizar.setEnabled(false); // Desactiva el botón temporalmente

        new Thread(() -> {
            DefaultTableModel modelo = new DefaultTableModel();
            modelo.addColumn("ID");
            modelo.addColumn("Prioridad");
            modelo.addColumn("DNI");
            modelo.addColumn("Nombres");
            modelo.addColumn("Asunto");
            modelo.addColumn("Inicio");
            modelo.addColumn("Estado");
            modelo.addColumn("Última dependencia");

        for (int i= 0; i < gestor.obtenerCantidadExpedientes(); i++) {
            Expediente e = gestor.obtenerExpedientes().obtener(i);
            String estado = (e.fin == null) ? "En proceso" : "Finalizado";
            String ultimaDependencia = "Ninguna";

            if (!e.historialDependencias.isEmpty()) {
                ultimaDependencia = e.historialDependencias.get(e.historialDependencias.size() - 1);
            }

            modelo.addRow(new Object[]{
                e.id,
                e.prioridad,
                e.usuario.dni,
                e.usuario.nombres,
                e.asunto,
                e.inicio.toString(),
                estado,
                ultimaDependencia
            });

        }
    
        
        
        // Actualiza la tabla en el hilo de la interfaz
        SwingUtilities.invokeLater(() -> {
            tablaExpedientes.setModel(modelo);
            btnActualizar.setEnabled(true); // Reactiva el botón
        });
    }).start();
    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
      this.dispose();
    }

   
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaExpedientes;
   
}
