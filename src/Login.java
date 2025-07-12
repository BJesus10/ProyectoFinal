

import javax.swing.*;

public class Login extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnIngresar;

    public Login() {
        setTitle("Login");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        JLabel lblClave = new JLabel("Clave:");

        txtUsuario = new JTextField();
        txtClave = new JPasswordField();
        btnIngresar = new JButton("Ingresar");

        lblUsuario.setBounds(30, 30, 80, 25);
        txtUsuario.setBounds(120, 30, 130, 25);
        lblClave.setBounds(30, 70, 80, 25);
        txtClave.setBounds(120, 70, 130, 25);
        btnIngresar.setBounds(90, 120, 100, 30);

        add(lblUsuario);
        add(txtUsuario);
        add(lblClave);
        add(txtClave);
        add(btnIngresar);

        btnIngresar.addActionListener(e -> {
            String user = txtUsuario.getText();
            String pass = new String(txtClave.getPassword());

            if (user.equals("admin") && pass.equals("123")) {
                new MenuPrincipal().setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o clave incorrectos");
            }
        });
    }
}
