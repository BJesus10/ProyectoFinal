
public class ConsultaExpediente extends javax.swing.JFrame {
    private GestorTramites gestor;

   
   public ConsultaExpediente(GestorTramites gestor) {
    this.gestor = gestor;
    initComponents();
}


    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtResultado = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtResultado.setColumns(20);
        txtResultado.setRows(5);
        jScrollPane1.setViewportView(txtResultado);

        jLabel1.setText("ID del Expdediente");

        btnBuscar.setBackground(new java.awt.Color(179, 215, 252));
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(73, 73, 73));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnVolver.setForeground(new java.awt.Color(255, 255, 255));
        btnVolver.setText("Menu");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(btnVolver))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {
        String input = txtID.getText().trim();
        StringBuilder resultado = new StringBuilder();

    if (input.isEmpty()) {
    resultado.append(" Por favor, ingresa un ID.");
    } else {
        try {
        int idBuscado = Integer.parseInt(input);
        boolean encontrado = false;

        for (int i=0; i < gestor.obtenerCantidadExpedientes(); i++) {
            Expediente e = gestor.obtenerExpedientes().obtener(i);
            
            // Verificar si el ID del expediente coincide con el ID buscado
        if (e.id == idBuscado) {
            resultado.append("ID: ").append(e.id).append("\n");
            resultado.append("DNI: ").append(e.usuario.dni).append("\n");
            resultado.append("Nombres: ").append(e.usuario.nombres).append("\n");
            resultado.append("Prioridad: ").append(e.prioridad).append("\n");
            resultado.append("Asunto: ").append(e.asunto).append("\n");
            resultado.append("Inicio: ").append(e.inicio).append("\n");
            resultado.append("Estado: ").append(e.fin == null ? "En proceso" : "Finalizado").append("\n\n");

            resultado.append("Historial de dependencias:\n");
        if (e.historialDependencias.isEmpty()) {
            resultado.append(" - No hay movimientos.\n");
        } else {
            for (String dep : e.historialDependencias) {
                resultado.append(" - ").append(dep).append("\n");
                }
            }

            encontrado = true;
            break;
            }
        }

            if (!encontrado) {
             resultado.append(" No se encontró el expediente con ID ").append(idBuscado).append(".");
         }

        } catch (NumberFormatException ex) {
            resultado.append("El ID debe ser un número entero.");
        }
        }

        txtResultado.setText(resultado.toString());

    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextArea txtResultado;
    // End of variables declaration//GEN-END:variables
}
