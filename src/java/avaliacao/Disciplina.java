/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package avaliacao;

import java.util.ArrayList;

/**
 *
 * @author Victor
 */
public class Disciplina {
    private String nome;
    private String ementa;
    private int ciclo;
    private double nota;

    public Disciplina(String nome, String ementa, int ciclo) {
        this.nome = nome;
        this.ementa = ementa;
        this.ciclo = ciclo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public int getCiclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo = ciclo;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
    
    public static ArrayList<Disciplina> getList(){
        
        ArrayList<Disciplina> minhasDisciplinas = new ArrayList<>();
        
        minhasDisciplinas.add(new Disciplina("Banco de Dados","Conceitos de Base de Dados. Modelos conceituais de informações.",4));
        minhasDisciplinas.add(new Disciplina("Engenharia de Software III","Conceitos, evolução e importância de arquitetura de software.",4));
        minhasDisciplinas.add(new Disciplina("Programação Orientada a Objetos","Conceitos e evolução da tecnologia de orientação a objetos.",4));
        minhasDisciplinas.add(new Disciplina("Linguagem de Programação IV","Comandos de linguagens usadas na construção e estruturação de sites.",4));
        minhasDisciplinas.add(new Disciplina("Sistemas Operacionais II","Apresentação de um sistema operacional específico utilizado em ambiente corporativo.",4));
        minhasDisciplinas.add(new Disciplina("Inglês IV","Consolidação da compreensão e produção oral e escrita por meio da integração.",4));
        minhasDisciplinas.add(new Disciplina("Metodologia da Pesquisa Científico-Tecnológica","O Papel da ciência e da tecnologia. Tipos de conhecimento. Método e técnica.",4));
        
        return minhasDisciplinas;
    }
}
