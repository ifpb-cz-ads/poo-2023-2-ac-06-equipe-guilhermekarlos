package model;

import java.io.Serializable;
import java.util.*;

public class Agenda implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Contato> contatos;
    public Agenda(){
        contatos = new ArrayList<>();
    }

    public boolean adicionar(Contato contato){
        return contatos.contains(contato)?false:contatos.add(contato);
    }



    //Listar os contatos
    public List<Contato> getContatos() {
        Collections.sort(contatos);
        return contatos;
    }

    //Remover um contato
    public boolean remover(Contato contato){
        return contatos.remove(contato);
    }

    //Atualizar contatos
    public boolean atualizar(Contato atual, Contato novo){
        int posicao = contatos.indexOf(atual);
        if (posicao>=0){
            contatos.set(posicao, novo);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "contatos=" + contatos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agenda agenda = (Agenda) o;
        return Objects.equals(contatos, agenda.contatos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contatos);
    }
}
