
public class UsuarioInteresado {
    String dni;
    String nombres;
    String telefono;
    String email;
    boolean esInternoUlima;
    
    public UsuarioInteresado(String dni,String nombres,String telefono,String email, boolean esInternoUlima){
        this.dni=dni;
        this.nombres=nombres;
        this.telefono = telefono;
        this.email = email;
        this.esInternoUlima = esInternoUlima;
    }
}
