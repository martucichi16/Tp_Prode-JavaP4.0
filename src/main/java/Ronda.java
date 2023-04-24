import java.sql.*;
import java.util.ArrayList;

public class Ronda {

    // ATRIBUTOS
    private ArrayList<Partido> partidos;

    // CONSTRUCTOR
    public Ronda() {
        partidos = new ArrayList<>();
    }

    // GETTER Y SETTER
    public ArrayList<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(ArrayList<Partido> partidos) {
        this.partidos = partidos;
    }

    // MÉTODOS PROPIOS
    public void agregarPartido(Partido partido) {
        this.partidos.add(partido);
    }

    // MÉTODO PARA LEER ARCHIVOS DE TEXTO
    /*
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
     */

    public void leerTablaPartidos(Statement st, String nombreTabla) throws SQLException {
        ResultSet rs = st.executeQuery("SELECT * FROM " + nombreTabla);

        while(rs.next()) {
            int idPartido = rs.getInt("idPartido");
            String primerEquipo = rs.getString("equipo1");
            String segundoEquipo = rs.getString("equipo2");
            int golesPrimerEquipo = rs.getInt("golesEquipo1");
            int golesSegundoEquipo = rs.getInt("golesEquipo2");

            Partido partido = new Partido(idPartido, primerEquipo, segundoEquipo, golesPrimerEquipo,
                    golesSegundoEquipo);

            this.agregarPartido(partido);
        }

        rs.close();
    }
}
