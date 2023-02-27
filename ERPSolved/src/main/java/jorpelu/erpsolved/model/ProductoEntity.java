package jorpelu.erpsolved.model;

import jakarta.persistence.*;

@Entity
@Table(name = "producto", schema = "mydb", catalog = "")
public class ProductoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "descripcion", nullable = true, length = 355)
    private String descripcion;
    @Basic
    @Column(name = "familia", nullable = true, length = 45)
    private String familia;
    @Basic
    @Column(name = "iva", nullable = true, precision = 0)
    private Double iva;
    @Basic
    @Column(name = "precio", nullable = true, length = 45)
    private String precio;
    @Basic
    @Column(name = "qty", nullable = true, precision = 0)
    private Double qty;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFamilia() {
        return familia;
    }

    public void setFamilia(String familia) {
        this.familia = familia;
    }

    public Double getIva() {
        return iva;
    }

    public void setIva(Double iva) {
        this.iva = iva;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductoEntity productoE = (ProductoEntity) o;

        if (id != productoE.id) return false;
        if (descripcion != null ? !descripcion.equals(productoE.descripcion) : productoE.descripcion != null)
            return false;
        if (familia != null ? !familia.equals(productoE.familia) : productoE.familia != null) return false;
        if (iva != null ? !iva.equals(productoE.iva) : productoE.iva != null) return false;
        if (precio != null ? !precio.equals(productoE.precio) : productoE.precio != null) return false;
        if (qty != null ? !qty.equals(productoE.qty) : productoE.qty != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (familia != null ? familia.hashCode() : 0);
        result = 31 * result + (iva != null ? iva.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (qty != null ? qty.hashCode() : 0);
        return result;
    }
}
