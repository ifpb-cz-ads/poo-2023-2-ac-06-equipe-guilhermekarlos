package view;
import java.io.*;

import dao.UsuarioDao;
import model.Agenda;
import model.Contato;
import model.Usuario;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Usuario> usuarios = new ArrayList<>();
        JOptionPane.showMessageDialog(null, "Bem-vindo");
        String[] opcoes = {"Salvar usuários", "Listar usuários", "Buscar por e-mail"};
        int opcao = JOptionPane.showOptionDialog(null, "O que deseja fazer:",
                "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                opcoes, opcoes[0]);
        while (opcao >= 0 && opcao <=2){
            if (opcao == 0){
                String email = JOptionPane.showInputDialog(null, "Informe o email do novo usuário:");
                String senha = JOptionPane.showInputDialog(null, "Informe a senha do novo usuário:");
                Usuario novoUsuario = new Usuario(email, senha);
                UsuarioDao usuarioDao = new UsuarioDao();
                boolean retorno = usuarioDao.addUsuario(novoUsuario);
                if (retorno == true){
                    JOptionPane.showMessageDialog(null, "Usuario " + email + " adicionado");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Usuário já existe!");
                }
            }
        }
    }
}
