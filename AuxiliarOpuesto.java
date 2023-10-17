public class AuxiliarOpuesto extends Jugador{
private int ataques; 
private int bloqueosEfectivos; 
private int bloqueosFallidos;
public AuxiliarOpuesto(int ataques, int bloqueosEfectivos, int bloqueosFallidos) {
    this.ataques = ataques;
    this.bloqueosEfectivos = bloqueosEfectivos;
    this.bloqueosFallidos = bloqueosFallidos;
}
public AuxiliarOpuesto(String nombre, String pais, int errores, int aces, int totalDeServicios, int ataques,
        int bloqueosEfectivos, int bloqueosFallidos) {
    super(nombre, pais, errores, aces, totalDeServicios);
    this.ataques = ataques;
    this.bloqueosEfectivos = bloqueosEfectivos;
    this.bloqueosFallidos = bloqueosFallidos;
}
public int getAtaques() {
    return ataques;
}
public void setAtaques(int ataques) {
    this.ataques = ataques;
}
public int getBloqueosEfectivos() {
    return bloqueosEfectivos;
}
public void setBloqueosEfectivos(int bloqueosEfectivos) {
    this.bloqueosEfectivos = bloqueosEfectivos;
}
public int getBloqueosFallidos() {
    return bloqueosFallidos;
}
public void setBloqueosFallidos(int bloqueosFallidos) {
    this.bloqueosFallidos = bloqueosFallidos;
}
@Override
public String toString() {
    return "AuxiliarOpuesto [ataques=" + ataques + ", bloqueosEfectivos=" + bloqueosEfectivos + ", bloqueosFallidos="
            + bloqueosFallidos + "]";
} 
    
public int EfectividadAuxiliar(){
    int eauxiliar = (((this.ataques + this.bloqueosEfectivos - this.bloqueosFallidos - this.errores)*100 / this.ataques + this.bloqueosEfectivos + this.bloqueosFallidos + this.errores));
    return eauxiliar; 
}

public int CalculodeEfectividad(){
    return super.CalculodeEfectividad()+EfectividadAuxiliar(); 
}

@Override
    public String[] obtenerDatosCSV() {
        String[] datos = super.obtenerDatosCSV(); // Obtener datos comunes de la clase base
        // Agregar los campos específicos de AuxiliarOpuesto en los índices adecuados
        datos[8] = String.valueOf(ataques);
        datos[9] = String.valueOf(bloqueosEfectivos);
        datos[10] = String.valueOf(bloqueosFallidos);

        return datos;
    }

}
