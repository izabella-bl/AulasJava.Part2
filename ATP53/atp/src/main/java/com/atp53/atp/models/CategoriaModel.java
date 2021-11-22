package com.atp53.atp.models;

public class CategoriaModel {
	private int id;
    private String nome;
    private String descricao;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nome=" + nome + ", descrição: "+descricao+"]";
	}

}