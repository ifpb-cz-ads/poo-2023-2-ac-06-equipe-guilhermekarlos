package model;

import java.io.Serializable;
import java.util.Objects;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    private String email;
    private String senha;
    private Agenda agenda;

    public Usuario(String email, String senha) {
        this.email = email;
        this.senha = senha;
        agenda = new Agenda();
    }



    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", agenda=" + agenda +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(email, usuario.email) && Objects.equals(senha, usuario.senha) && Objects.equals(agenda, usuario.agenda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, senha, agenda);
    }
}
