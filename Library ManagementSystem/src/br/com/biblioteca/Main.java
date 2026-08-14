package br.com.biblioteca;

import br.com.biblioteca.model.Emprestimo;
import br.com.biblioteca.model.Livro;
import br.com.biblioteca.model.Usuario;
import br.com.biblioteca.exception.LivroIndisponivelException;

public class Main {

    public static void main(String[] args) {

        Livro livro = new Livro(
                1L,
                "Clean Code",
                "Robert C. Martin",
                2008
        );

        Usuario usuario = new Usuario(
                1L,
                "Augusto",
                "augusto@email.com"
        );



        Emprestimo emprestimo = new Emprestimo(
                1L,
                livro,
                usuario);

        try {

         Emprestimo segundoEmprestimo = new Emprestimo(
            2L,
            livro,
            usuario
        );

        } catch (LivroIndisponivelException e) {

                System.out.println("Não foi possível realizar o empréstimo.");
                 System.out.println("Motivo: " + e.getMessage());
        }


        

        System.out.println("===== EMPRÉSTIMO =====");

        System.out.println("Livro: "
                + emprestimo.getLivro().getTitulo());

        System.out.println("Usuário: "
                + emprestimo.getUsuario().getNome());

        System.out.println("Data: "
                + emprestimo.getDataEmprestimo());

        System.out.println("Status: "
                + emprestimo.getStatus());

        emprestimo.devolver();

        System.out.println();
        System.out.println("===== APÓS DEVOLUÇÃO =====");

        System.out.println("Data de devolução: "
                + emprestimo.getDataDevolucao());

        System.out.println("Status: "
                + emprestimo.getStatus());
    }
}
