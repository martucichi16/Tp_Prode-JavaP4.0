import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Ronda {

    private ArrayList<Partido> partidos;

    public Ronda() {
        partidos = new ArrayList<Partido>();
    }

    public Ronda(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    public void agregarPartido(Partido partido) {
        this.partidos.add(partido);
    }

    public void lecturaPartidos(String nombreArchivo) throws IOException {
        Path archivoPartidos = Paths.get(nombreArchivo);
        Scanner lectorPartidos = new Scanner(archivoPartidos);

        while(lectorPartidos.hasNext()) {
            String [] partidoSplit = lectorPartidos.nextLine().split(";");

            int idPartido = Integer.parseInt(partidoSplit[0]);
            String primerEquipo = partidoSplit[1];
            String segundoEquipo = partidoSplit[2];
            int golesPrimerEquipo = Integer.parseInt(partidoSplit[3]);
            int golesSegundoEquipo = Integer.parseInt(partidoSplit[4]);

            Partido partido = new Partido(idPartido, primerEquipo, segundoEquipo, golesPrimerEquipo,
                    golesSegundoEquipo);

            this.agregarPartido(partido);
        }

        lectorPartidos.close();
    }
}
