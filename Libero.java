
public class Libero extends Jugador{
    private int RecibosEfectivos;
    private int Efectividad; 

    public Libero(int recibosEfectivos) {
        RecibosEfectivos = recibosEfectivos;
    }

    public Libero(String nombre, String pais, int errores, int aces, int totalDeServicios, int recibosEfectivos) {
        super(nombre, pais, errores, aces, totalDeServicios);
        RecibosEfectivos = recibosEfectivos;
    }

    public int getRecibosEfectivos() {
        return RecibosEfectivos;
    }

    public void setRecibosEfectivos(int recibosEfectivos) {
        RecibosEfectivos = recibosEfectivos;
    }

    @Override
    public String toString() {
        return "Libero [RecibosEfectivos=" + RecibosEfectivos + "]";
    } 

    public int EfectividadLibero(){
        int elibero = (((this.RecibosEfectivos - this.errores)) *100  / (this.RecibosEfectivos + this.errores)); 
        return elibero; 
    }

    public int CalculodeEfectividad(){
        return super.CalculodeEfectividad()+EfectividadLibero(); 
    }

    public int getEfectividad() {
        return Efectividad;
    }

    public void setEfectividad(int efectividad) {
        Efectividad = efectividad;
    }

    @Override
    public String[] obtenerDatosCSV() {
        String[] datos = super.obtenerDatosCSV(); // Obtener datos comunes de la clase base
        // Agregar los campos específicos de Libero en los índices adecuados
        datos[7] = String.valueOf(RecibosEfectivos);

        return datos;
    }
}
