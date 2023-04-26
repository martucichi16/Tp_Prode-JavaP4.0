import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
// import java.util.Collections;

public class Prode {

    // ATRIBUTOS
    private Ronda ronda;
    private Competencia competencia;

    private int documentoGanador;

    // CONSTRUCTOR
    public Prode(Ronda partidos, Competencia participantes) {
        this.ronda = partidos;
        this.competencia = participantes;
    }

    // GETTERs y SETTERs
    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public Competencia getCompetencia() {
        return competencia;
    }

    public void setCompetencia(Competencia competencia) {
        this.competencia = competencia;
    }

    // MÉTODOS PROPIOS
    private void calcularPuntos() {
        for (Participante jugador:competencia.getParticipantes().values()) {
            jugador.calcularPuntos(ronda);
        }
    }

    public int ganadorProde() {
        this.calcularPuntos();
        // Armo HashMap de documento y puntos
        HashMap<Integer, Integer> puntaje = new HashMap<>();
        int docuGanador = 0;

        for (Participante participante : competencia.getParticipantes().values()) {
            puntaje.put(participante.getDocumento(), participante.getPuntos());
        }

        // int maximoPuntaje = Collections.max(puntaje.values());
        int maximoPuntaje = 0;

        for (Integer punto:puntaje.values()) {
            if (punto > maximoPuntaje) {
                maximoPuntaje = punto;
            }
        }

        for (Participante participante : competencia.getParticipantes().values()) {
            if (participante.getPuntos() == maximoPuntaje) {
                docuGanador = participante.getDocumento();
            }
        }

        this.documentoGanador = docuGanador;

        return docuGanador;
    }


    public void imprimirPartidos() {
        System.out.println("RESULTADOS DE LA RONDA:");

        for (Partido partido:ronda.getPartidos()) {
            System.out.printf("%12s%s%s%s%s%s%-12s%5s%12s%9s", partido.getEquipo1(), " | ", partido.getGolesEquipo1(),
                    " - ", partido.getGolesEquipo2(), " | ", partido.getEquipo2(), " --> ",
                    partido.getGanador(), "\n");
        }

        System.out.println("\n");
    }

    public void mostrarGanador() {
        System.out.println("\nGANADOR: " + this.competencia.getParticipantes().get(documentoGanador).nombreCompleto());
    }

    public void verJSON () throws JsonProcessingException {
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.writerWithDefaultPrettyPrinter().writeValueAsString(this));
    }

    // Guardaría el JSON en un archivo para poder exportarlo y compartirlo
    public void exportarJSON () throws IOException {
        Path archivoJSON = Paths.get("Prode.json");

        ObjectMapper om = new ObjectMapper();
        om.writerWithDefaultPrettyPrinter().writeValue(archivoJSON.toFile(), this);
    }

}