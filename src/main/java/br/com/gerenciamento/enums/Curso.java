package br.com.gerenciamento.enums;

public enum Curso {

    INFORMATICA("Informática"),
    ENFERMAGEM("Enfermagem"),
    DIREITO("Direito");

    private String curso;

    private Curso(String curso) {
        this.curso = curso;
    }

}
