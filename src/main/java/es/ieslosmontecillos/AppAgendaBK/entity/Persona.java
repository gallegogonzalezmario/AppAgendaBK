package es.ieslosmontecillos.AppAgendaBK.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "PERSONA")
public class Persona implements Serializable {

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // Columnas de la tabla Persona
    @Id
    @Column(name = "ID", nullable = false)
    private Long id;

    @Basic
    @Column(name = "NOMBRE", nullable = false, length = 20)
    private String nombre;

    @Basic
    @Column(name = "APELLIDOS", nullable = false, length = 40)
    private String apellidos;

    @Basic
    @Column(name = "TELEFONO", nullable = true, length = 15)
    private String telefono;

    @Basic
    @Column(name = "EMAIL", nullable = true, length = 30)
    private String email;

    @ManyToOne
    @JoinColumn(name = "PROVINCIA", nullable = false)
    private Provincia provincia;

    @Basic
    @Column(name = "FECHA_NACIMIENTO", nullable = true)
    private Date fechaNac;

    @Basic
    @Column(name = "NUM_HIJOS", nullable = true)
    private short numHijos;

    @Basic
    @Column(name = "ESTADO_CIVIL", nullable = true)
    private char estadoCivil;

    @Basic
    @Column(name = "SALARIO", nullable = true, precision = 9, scale = 2)
    private BigDecimal salario;

    @Basic
    @Column(name = "JUBILADO", nullable = true)
    private short jubilado;

    @Basic
    @Column(name = "FOTO", nullable = true, length = 30)
    private String foto;

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public short getNumHijos() {
        return numHijos;
    }

    public void setNumHijos(short numHijos) {
        this.numHijos = numHijos;
    }

    public char getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(char estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public short getJubilado() {
        return jubilado;
    }

    public void setJubilado(short jubilado) {
        this.jubilado = jubilado;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
