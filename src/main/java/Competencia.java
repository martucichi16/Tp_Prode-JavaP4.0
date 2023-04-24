import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Competencia  {

    private HashMap<Integer, Participante> participantes;

    public Competencia() {
        this.participantes = new HashMap<Integer, Participante>();
    }

    public HashMap<Integer, Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(HashMap<Integer, Participante> participantes) {
        this.participantes = participantes;
    }

    // public void ordenarPorPuntos() {}

    public void agregarParticipante(Participante participante) {
        this.participantes.put(participante.getDocumento(), participante);
    }

    public void lecturaPronosticos(String nombreArchivo) throws IOException {

        Path archivoPronosticos = Paths.get(nombreArchivo);
        Scanner lectorPronosticos = new Scanner(archivoPronosticos);


        // Guardo todas las líneas en un arreglo para poder recorrerlo muchas veces, porque con scanner
        // necesito crear un lector por cada vuelta que quiera darle al archivo
        ArrayList<String> lineasPronosticos = new ArrayList<>();
        while (lectorPronosticos.hasNextLine()) {
            lineasPronosticos.add(lectorPronosticos.nextLine());
        }
        lectorPronosticos.close();


        // Guardo los documentos
        ArrayList<Integer> documentos = new ArrayList<>();
        for (String linea:lineasPronosticos) {
            String[] pronosticoSplit = linea.split(";");
            Integer documento = Integer.parseInt(pronosticoSplit[0]);

            if (!documentos.contains(documento)) {
                documentos.add(documento);
            }
        }

        // Creo los participantes y sus apuestas, y los guardo en un objeto competencia
        for(Integer documento:documentos) {
            String nombre = "";
            String apellido = "";

            ArrayList<Partido> apuestas = new ArrayList<>();

            for (String linea:lineasPronosticos) {
                String[] pronosticoSplit = linea.split(";");
                int id = Integer.parseInt(pronosticoSplit[0]);

                if (id == documento) {
                    nombre = pronosticoSplit[1];
                    apellido = pronosticoSplit[2];
                    int idPartido = Integer.parseInt(pronosticoSplit[3]);
                    String equipo1 = pronosticoSplit[4];
                    String equipo2 = pronosticoSplit[5];
                    int golesEquipo1 = Integer.parseInt(pronosticoSplit[6]);
                    int golesEquipo2 = Integer.parseInt(pronosticoSplit[7]);

                    Partido apuesta = new Partido(idPartido, equipo1, equipo2, golesEquipo1, golesEquipo2);
                    apuestas.add(apuesta);
                }
            }

            Participante jugador = new Participante(documento, nombre, apellido,
                    apuestas);

            this.agregarParticipante(jugador);

        }
    }

    public void mostrarParticipantes() {

        System.out.println("LISTA DE PARTICIPANTES DEL PRODE:");

        for (Participante persona:participantes.values()) {
            System.out.printf("%16s%s%s%s%s%s", persona.nombreCompleto(), "(", persona.getDocumento(),
                    "): ", persona.getPuntos(), " puntos\n");
        }
    }
}
