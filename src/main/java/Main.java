import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        /* LECTURA CON ARCHIVOS DE TEXTO
        // LECTURA E INSTANCIA DE RESULTADOS DE LA RONDA
        String archivoPartidos = "src/main/partidos.txt";
        Ronda listaPartidos = new Ronda();
        listaPartidos.lecturaPartidos(archivoPartidos);



        // LECTURA E INSTANCIA DE PERSONAS Y APUESTAS
        String archivoPronosticos = "src/main/pronosticos.txt";
        Competencia listaParticipantes = new Competencia();
        listaParticipantes.lecturaPronosticos(archivoPronosticos);
         */

        // CONEXIÓN BASE DE DATOS
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/Prode", "root",
                "");
        Statement st = con.createStatement();


        // INSTANCIAS DE PARTIDOS
        Ronda partidos = new Ronda();
        partidos.leerTablaPartidos(st, "partidos");


        // INSTANCIA DE PARTICIPANTES Y APUESTAS
        Competencia competencia = new Competencia();
        competencia.leerTablaPronosticos(st, "pronosticos");

        con.close();

        // ---------------------------------------------------------------------------------------------

        // EJECUTO EL PRODE
        Prode prode = new Prode(partidos, competencia);
        prode.ganadorProde();

        // ---------------------------------------------------------------------------------------------

        // CONSOLA
        prode.imprimirPartidos();
        competencia.mostrarParticipantes();
        prode.mostrarGanador();


    }
}
