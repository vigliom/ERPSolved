package jorpelu.erpsolved.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "factura", schema = "mydb", catalog = "")
public class FacturaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "id_usuario", nullable = false)
    private int id_usuario;
    @Basic
    @Column(name = "cif", nullable = false, length = 45)
    private String cif;
    @Version
    @Basic
    @Column(name = "fecha", nullable = true)
    private Timestamp fecha;
    @Basic
    @Column(name = "CV", nullable = true)
    private Byte cv;
    @ManyToOne
    @JoinColumn(name = "id_terceros", nullable = false)
    private TercerosEntity idTerceros;

    public FacturaEntity() {
    }

    public FacturaEntity(int id, int id_usuario, String cif, Timestamp fecha, TercerosEntity id_terceros) {
        this.id = id;
        this.id_usuario = id_usuario;
        this.cif = cif;
        this.fecha = fecha;
        this.idTerceros = id_terceros;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int idUsuario) {
        this.id_usuario = idUsuario;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Byte getCv() {
        return cv;
    }

    public void setCv(Byte cv) {
        this.cv = cv;
    }

    public TercerosEntity getIdTerceros() {
        return idTerceros;
    }

    public void setIdTerceros(TercerosEntity idTerceros) {
        this.idTerceros = idTerceros;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FacturaEntity that)) return false;
        return id == that.id && id_usuario == that.id_usuario && Objects.equals(cif, that.cif) && Objects.equals(fecha, that.fecha) && Objects.equals(cv, that.cv) && Objects.equals(idTerceros, that.idTerceros);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_usuario, cif, fecha, cv, idTerceros);
    }
}
