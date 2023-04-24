import java.util.ArrayList;

public class Participante {
    private int documento;
    private String nombre;
    private String apellido;

    private ArrayList<Partido> apuestas;
    private int puntos = 0;

    public Participante(int documento, String nombre, String apellido, ArrayList<Partido> apuestas) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.apuestas = apuestas;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Partido> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Partido> apuestas) {
        this.apuestas = apuestas;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public void sumarPunto() {
        this.puntos = puntos + 1;
    }

    public String nombreCompleto() {
        return this.nombre + " " + this.apellido;
    }

    public void calcularPuntos(Ronda partidos) {
        for (Partido partido : partidos.getPartidos()) {
            for (Partido apuesta : this.getApuestas()) {
                if ((partido.getIdPartido() == apuesta.getIdPartido() && (partido.resultado() ==
                        apuesta.resultado()))) {
                    this.sumarPunto();
                    break;
                }
            }
        }
    }
}
