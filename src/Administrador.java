



public class Administrador {
    private final String usuario = "admin";
    private final String clave = "1234";

    public boolean validarCredenciales(String u, String c) {
        return u.equals(usuario) && c.equals(clave);
    }

    public String getNombre() {
        return "Administrador del Sistema";
    }
}
