import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        // LECTURA E INSTANCIA DE RESULTADOS DE LA RONDA
        String archivoPartidos = "src/main/partidos.txt";
        Ronda listaPartidos = new Ronda();
        listaPartidos.lecturaPartidos(archivoPartidos);


        // LECTURA E INSTANCIA DE PERSONAS Y APUESTAS
        String archivoPronosticos = "src/main/pronosticos.txt";
        Competencia listaParticipantes = new Competencia();
        listaParticipantes.lecturaPronosticos(archivoPronosticos);


        // EJECUTO EL PRODE
        Prode prode = new Prode(listaPartidos, listaParticipantes);
        prode.ganadorProde();

        // CONSOLA
        prode.imprimirPartidos();
        listaParticipantes.mostrarParticipantes();
        prode.mostrarGanador();
    }
}
