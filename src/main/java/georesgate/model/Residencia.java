package georesgate.model;

import jakarta.persistence.*;

@Entity
@Table(name = "residencia")
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;
    private String numero;
    private String cep;

    @Column(name = "tipo") // Corrigido: o nome real da coluna é "tipo"
    private String tipoResidencia;

    @Column(name = "numero_andares")
    private Integer numeroAndares;

    @Column(name = "garagem_subterranea")
    private String garagemSubterranea;

    @OneToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    // Getters e Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTipoResidencia() {
        return tipoResidencia;
    }

    public void setTipoResidencia(String tipoResidencia) {
        this.tipoResidencia = tipoResidencia;
    }

    public Integer getNumeroAndares() {
        return numeroAndares;
    }

    public void setNumeroAndares(Integer numeroAndares) {
        this.numeroAndares = numeroAndares;
    }

    public String getGaragemSubterranea() {
        return garagemSubterranea;
    }

    public void setGaragemSubterranea(String garagemSubterranea) {
        this.garagemSubterranea = garagemSubterranea;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}