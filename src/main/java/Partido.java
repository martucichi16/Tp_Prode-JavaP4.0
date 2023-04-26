public class Partido {

    // ATRIBUTOS
    private int idPartido;
    private String equipo1;
    private String equipo2;
    private int golesEquipo1;
    private int golesEquipo2;

    // CONSTRUCTOR
    public Partido(int idPartido, String equipo1, String equipo2, int golesEquipo1, int golesEquipo2) {
        this.idPartido = idPartido;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
    }

    // GETTERs y SETTERs
    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    // MÉTODO PROPIO
    public int resultado() {
        if (golesEquipo1 == golesEquipo2) {
            return 0;
        } else {
            if (golesEquipo1 > golesEquipo2) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    public String getGanador() {
        if (golesEquipo1 == golesEquipo2) {
            return "EMPATE";
        } else {
            if (golesEquipo1 > golesEquipo2) {
                return equipo1;
            } else {
                return equipo2;
            }
        }
    }
}
