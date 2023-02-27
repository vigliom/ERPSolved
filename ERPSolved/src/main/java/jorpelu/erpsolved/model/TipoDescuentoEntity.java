package jorpelu.erpsolved.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_descuento", schema = "mydb", catalog = "")
public class TipoDescuentoEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "porcentaje", nullable = true, precision = 0)
    private Double porcentaje;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoDescuentoEntity that = (TipoDescuentoEntity) o;

        if (id != that.id) return false;
        if (porcentaje != null ? !porcentaje.equals(that.porcentaje) : that.porcentaje != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (porcentaje != null ? porcentaje.hashCode() : 0);
        return result;
    }
}
