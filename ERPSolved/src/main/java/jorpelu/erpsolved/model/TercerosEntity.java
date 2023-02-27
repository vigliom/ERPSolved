package jorpelu.erpsolved.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "terceros", schema = "mydb", catalog = "")
public class TercerosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = true, length = 45)
    private String name;
    @Basic
    @Column(name = "apellidos", nullable = true, length = 45)
    private String apellidos;
    @Basic
    @Column(name = "email", nullable = true, length = 45)
    private String email;
    @Basic
    @Column(name = "direccion", nullable = true, length = 45)
    private String direccion;
    @Basic
    @Column(name = "CIF", nullable = true, length = 45)
    private String cif;
    @Basic
    @Column(name = "Cliente", nullable = true)
    private Byte cliente;
    @Basic
    @Column(name = "prov", nullable = true)
    private Byte prov;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String nom) {
        this.name = nom;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public Byte getCliente() {
        return cliente;
    }

    public void setCliente(Byte cliente) {
        this.cliente = cliente;
    }

    public Byte getProv() {
        return prov;
    }

    public void setProv(Byte prov) {
        this.prov = prov;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TercerosEntity that)) return false;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(apellidos, that.apellidos) && Objects.equals(email, that.email) && Objects.equals(direccion, that.direccion) && Objects.equals(cif, that.cif) && Objects.equals(cliente, that.cliente) && Objects.equals(prov, that.prov);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, apellidos, email, direccion, cif, cliente, prov);
    }

    @Override
    public String toString() {
        return "TercerosEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", email='" + email + '\'' +
                ", direccion='" + direccion + '\'' +
                ", cif='" + cif + '\'' +
                ", cliente=" + cliente +
                ", prov=" + prov +
                '}';
    }
}
