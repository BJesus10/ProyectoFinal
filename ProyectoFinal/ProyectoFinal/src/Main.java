
public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            GestorTramites gestor = new GestorTramites(); 
            Login login = new Login(gestor);            
            login.setVisible(true);                     
        });
    }
}


