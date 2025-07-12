import javax.swing.*;

public class MenuPrincipal extends JFrame {
    public MenuPrincipal() {
        setTitle("Menú Principal");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JButton btnRegistrar = new JButton("Registrar Expediente");
        JButton btnVer = new JButton("Ver Expedientes");

        btnRegistrar.setBounds(50, 40, 200, 30);
        btnVer.setBounds(50, 90, 200, 30);

        add(btnRegistrar);
        add(btnVer);

        btnRegistrar.addActionListener(e -> new RegistroExpediente().setVisible(true));
        btnVer.addActionListener(e -> new VerExpedientes().setVisible(true));
    }
}
