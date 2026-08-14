package br.com.biblioteca.model;

import java.time.LocalDate;

public class Emprestimo{
    private Long id;
    private Livro livro;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private StatusEmprestimo status;
    

    public Emprestimo(long id, Livro livro, Usuario usuario) {
        
        livro.emprestar();
        this.id = id;
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.status = StatusEmprestimo.ATIVO;
    }

    public Long getId() {
        return id;
    }
    public Livro getLivro() {
        return livro;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }
    public StatusEmprestimo getStatus() {
        return status;
    }

    public void devolver() {
        this.dataDevolucao = LocalDate.now();
        this.status = StatusEmprestimo.DEVOLVIDO;
        livro.devolver();
    }

}
