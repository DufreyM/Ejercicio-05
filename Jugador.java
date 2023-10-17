public class Jugador {
    protected String nombre; 
    protected String pais; 
    protected int errores; 
    protected int aces; 
    protected int totalDeServicios;

    public Jugador(){
        nombre = ""; 
        pais = ""; 
        errores = 0; 
        aces = 0; 
        totalDeServicios=0;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public int getErrores() {
        return errores;
    }
    public void setErrores(int errores) {
        this.errores = errores;
    }
    public int getAces() {
        return aces;
    }
    public void setAces(int aces) {
        this.aces = aces;
    }
    public int getTotalDeServicios() {
        return totalDeServicios;
    }
    public void setTotalDeServicios(int totalDeServicios) {
        this.totalDeServicios = totalDeServicios;
    }
    public Jugador(String nombre, String pais, int errores, int aces, int totalDeServicios) {
        this.nombre = nombre;
        this.pais = pais;
        this.errores = errores;
        this.aces = aces;
        this.totalDeServicios = totalDeServicios;
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", pais=" + pais + ", errores=" + errores + ", aces=" + aces
                + ", totalDeServicios=" + totalDeServicios + "]";
    } 

    public int CalculodeEfectividad(){
        int efectividad = aces * 100 / totalDeServicios; 
        return efectividad; 
    }

    public String[] obtenerDatosCSV() {
        // Este ejemplo es genérico y asume que todos los campos comunes están en la clase base
        // Debes personalizar este método en las subclases para incluir sus campos específicos.

        String[] datos = new String[11]; // Ajusta el tamaño del arreglo según la cantidad de campos

        datos[0] = nombre;
        datos[1] = pais;
        datos[2] = String.valueOf(errores);
        datos[3] = String.valueOf(aces);
        datos[4] = String.valueOf(totalDeServicios);

        return datos;
    }
}
