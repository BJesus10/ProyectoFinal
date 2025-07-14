
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import javax.swing.table.DefaultTableModel;


public class VerAlertas extends javax.swing.JFrame {

   private final GestorTramites gestor;

    public VerAlertas(GestorTramites gestor) {
     this.gestor = gestor;
     initComponents();
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnActualizar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAlertas = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24));
        jLabel1.setText("Expedientes en alertas");

        btnActualizar.setBackground(new java.awt.Color(196, 228, 218));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 15)); 
        btnActualizar.setText("ACTUALIZAR");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnVolver.setBackground(new java.awt.Color(230, 230, 230));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); 
        btnVolver.setText("Menu");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        tablaAlertas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tablaAlertas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(293, 293, 293))
            .addGroup(layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(207, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        pack();
    }

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {
         DefaultTableModel modelo = new DefaultTableModel(new String[]{
        "ID", "Prioridad", "Asunto", "Inicio", "Días transcurridos"
    }, 0); // crea tabla sin filas pero con columnas

    LocalDate hoy = LocalDate.now();

    for (int i = 0; i < gestor.obtenerCantidadExpedientes(); i++) {
        Expediente e = gestor.obtenerExpedientes().obtener(i);
        if (e.fin == null) {
            long dias = ChronoUnit.DAYS.between(e.inicio, hoy);
            boolean enAlerta = false;

            switch (e.prioridad.toLowerCase()) {
                case "alta":
                    enAlerta = dias > 1;
                    break;
                case "media":
                    enAlerta = dias > 3;
                    break;
                case "baja":
                    enAlerta = dias > 5;
                    break;
            }

            if (enAlerta) {
                modelo.addRow(new Object[]{
                    e.id,
                    e.prioridad,
                    e.asunto,
                    e.inicio.toString(),
                    dias
                });
            }
        }
    }

    tablaAlertas.setModel(modelo); // actualiza la tabla                             
  
    }

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {
      this.dispose();
    }

  
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAlertas;

}
