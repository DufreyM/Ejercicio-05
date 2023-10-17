public class pasador extends Jugador{
    private int pases; 
    private int fintas;

    public pasador(int pasador, int fintas) {
        this.pases = pasador;
        this.fintas = fintas;
    }
    public pasador(String nombre, String pais, int errores, int aces, int totalDeServicios, int pasador, int fintas) {
        super(nombre, pais, errores, aces, totalDeServicios);
        this.pases = pasador;
        this.fintas = fintas;
    }
    public int getPases() {
        return pases;
    }
    public void setPasador(int pasador) {
        this.pases = pasador;
    }
    public int getFintas() {
        return fintas;
    }
    public void setFintas(int fintas) {
        this.fintas = fintas;
    }
    @Override
    public String toString() {
        return "pasador [pasador=" + pases + ", fintas=" + fintas + "]";
    } 
    
    public int efectividadpasador(){
        int epasador = (((this.pases + this.fintas - this.errores)*100) / (this.pases + this.fintas + this.errores));
        //((pases + fintas – errores) * 100 / (pases + fintas + errores)) 
        return epasador; 
    }

    public int CalculodeEfectividad(){
        return super.CalculodeEfectividad()+efectividadpasador(); 
    }

    @Override
    public String[] obtenerDatosCSV() {
        String[] datos = super.obtenerDatosCSV(); // Obtener datos comunes de la clase base
        // Agregar los campos específicos de Pasador en los índices adecuados
        datos[5] = String.valueOf(pases);
        datos[6] = String.valueOf(fintas);
        return datos;
    }
}
