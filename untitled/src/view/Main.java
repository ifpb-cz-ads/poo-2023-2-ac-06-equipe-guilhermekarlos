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
            else if (opcao == 1) {
                UsuarioDao usuarioDao = new UsuarioDao();
                List<Usuario> lista = usuarioDao.listarUsuarios();
                for (int i = 0; i < lista.size(); i++){
                    JOptionPane.showMessageDialog(null, lista.get(i).getEmail());
                }
            }
            else {
                UsuarioDao usuarioDao = new UsuarioDao();
                String emailBusca = JOptionPane.showInputDialog(null, "Informe o email:");
                UsuarioDao usuarioBusca = new UsuarioDao();
                Usuario retorno = usuarioBusca.buscarPorEmail(emailBusca);
                if (retorno != null){
                    JOptionPane.showMessageDialog(null, "Usuário encontrado!");
                }
                else {
                    JOptionPane.showMessageDialog(null, "Usuário não encontrado!");
                    int yesOrNo = JOptionPane.showConfirmDialog(null, "Deseja adicionar o usuário " +
                            emailBusca, "Adicionar novo usuário", JOptionPane.YES_NO_OPTION);
                    if (yesOrNo == 0){
                        String senha = JOptionPane.showInputDialog(null, "Informe a senha do novo usuário:");
                        Usuario novoUsuario = new Usuario(emailBusca, senha);
                        UsuarioDao usuarioAdicionado = new UsuarioDao();
                        usuarioAdicionado.addUsuario(novoUsuario);
                        JOptionPane.showMessageDialog(null, "Usuário " + emailBusca + " adicionado!");
                    }
                }
            }
            opcao = JOptionPane.showOptionDialog(null, "O que deseja fazer:",
                    "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                    opcoes, opcoes[0]);
        }
    }
}
