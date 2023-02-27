package jorpelu.erpsolved.model;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.Objects;

@Entity
@Table(name = "linea_de_factura", schema = "mydb", catalog = "")
public class LineaDeFacturaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "id_prod", nullable = true)
    private ProductoEntity idProd;
    @Basic
    @Column(name = "id_fact", nullable = false)
    private int idFact;
    @Basic
    @Column(name = "cantidad", nullable = true)
    private Integer cantidad;
    @Basic
    @Column(name = "id_tipo_desc", nullable = false)
    private int idTipoDesc;
    @Basic
    @Column(name = "precio_linea", nullable = true, precision = 0)
    private Double precioLinea;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ProductoEntity getIdProd() {
        return idProd;
    }

    public void setIdProd(ProductoEntity idProd) {
        this.idProd = idProd;
    }

    public int getIdFact() {
        return idFact;
    }

    public void setIdFact(int idFact) {
        this.idFact = idFact;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdTipoDesc() {
        return idTipoDesc;
    }

    public void setIdTipoDesc(int idTipoDesc) {
        this.idTipoDesc = idTipoDesc;
    }

    public Double getPrecioLinea() {
        return precioLinea;
    }

    public void setPrecioLinea(Double precioLinea) {
        this.precioLinea = precioLinea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineaDeFacturaEntity that)) return false;
        return id == that.id && idFact == that.idFact && idTipoDesc == that.idTipoDesc && Objects.equals(idProd, that.idProd) && Objects.equals(cantidad, that.cantidad) && Objects.equals(precioLinea, that.precioLinea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idProd, idFact, cantidad, idTipoDesc, precioLinea);
    }
}
