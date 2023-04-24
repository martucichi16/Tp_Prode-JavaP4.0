import java.util.HashMap;
import java.util.Collections;

public class Prode {
    private Ronda ronda;
    private Competencia competencia;

    private int documentoGanador;

    public Prode(Ronda partidos, Competencia participantes) {
        this.ronda = partidos;
        this.competencia = participantes;
    }

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

        int maximoPuntaje = Collections.max(puntaje.values());

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
            System.out.printf("%12s%s%s%s%s%s%s%s", partido.getEquipo1(), " | ", partido.getGolesEquipo1(),
                    " - ", partido.getGolesEquipo2(), " | ", partido.getEquipo2(), "\n");
        }

        System.out.println("\n");
    }

    public void mostrarGanador() {
        System.out.println("\nGANADOR: " + this.competencia.getParticipantes().get(documentoGanador).nombreCompleto());
    }
}