package co.com.sofka.factura;

import java.util.Date;

public class Factura {
    private int facturaID;
    private String descripcion;
    private int precio;
    private int cantidadProducto;
    private Date fecha;

    public Factura() {
    }

    public Factura(int facturaID, String descripcion, int precio, int cantidadProducto, Date fecha) {
        this.facturaID = facturaID;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidadProducto = cantidadProducto;
        this.fecha = fecha;
    }

    public int getFacturaID() {
        return facturaID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "\n" + "Factura{" +
                "facturaID=" + facturaID +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", cantidadProducto=" + cantidadProducto +
                ", fecha=" + fecha +
                '}';
    }
}
