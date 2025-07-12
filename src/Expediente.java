/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Expediente {
    int id;
    String prioridad;
    UsuarioInteresado usuario;
    String asunto;
    String docReferencia;
    LocalDateTime inicio;
    LocalDateTime fin;

    ArrayList<String> historialDependencias = new ArrayList<>();

    public Expediente(int id, String prioridad, UsuarioInteresado usuario, String asunto, String docReferencia) {
        this.id = id;
        this.prioridad = prioridad;
        this.usuario = usuario;
        this.asunto = asunto;
        this.docReferencia = docReferencia;
        this.inicio = LocalDateTime.now();
        this.fin = null;
    }

    public void moverADependencia(String nombreDependencia) {
        String registro = "Movido a: " + nombreDependencia + " el " + LocalDateTime.now();
        historialDependencias.add(registro);
    }

    public void mostrarHistorial() {
        for (String evento : historialDependencias) {
            System.out.println(evento);
        }
    }
}
