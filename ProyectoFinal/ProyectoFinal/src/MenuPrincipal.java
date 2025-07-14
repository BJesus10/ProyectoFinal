import javax.swing.*;

public class MenuPrincipal extends JFrame {

    private GestorTramites gestor;

    public MenuPrincipal(GestorTramites gestor) {
        this.gestor = gestor;

        setTitle("Menú Principal");
        setSize(300, 300); // Aumentamos para el botón extra
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnRegistrar = new JButton("Registrar Expediente");
        JButton btnVer = new JButton("Ver Expedientes");
        JButton btnConsultar = new JButton("Consultar Expediente");
        JButton btnAlertas = new JButton("Ver Alertas");

        
        btnRegistrar.setBounds(50, 30, 200, 30);
        btnVer.setBounds(50, 80, 200, 30);
        btnConsultar.setBounds(50, 130, 200, 30);
        btnAlertas.setBounds(50, 180, 200, 30);

        
        add(btnRegistrar);
        add(btnVer);
        add(btnConsultar);
        add(btnAlertas);

        
        btnRegistrar.addActionListener(e -> new RegistroExpediente(gestor).setVisible(true));
        btnVer.addActionListener(e -> new VerExpedientes(gestor).setVisible(true));
        btnConsultar.addActionListener(e -> new ConsultaExpediente(gestor).setVisible(true));
        btnAlertas.addActionListener(e -> new VerAlertas(gestor).setVisible(true));
    }
}


    

