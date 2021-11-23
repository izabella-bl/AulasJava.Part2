package com.atp53.atp.models;

import java.math.BigDecimal;

public class ProdutoModel {
        private int id;
        private String nome;
        private String descricao;
        private int idCategoria;
        private BigDecimal valor;
        
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

        public void setIdCategoria(int idCategoria) {
            this.idCategoria = idCategoria;
        }

        public int getIdCategoria() {
            return idCategoria;
        }

        public BigDecimal getValor() {
            return valor;
        }

        public void setValor(BigDecimal valor) {
            this.valor = valor;
        }

        @Override
        public String toString() {
            return "Prdouto [id: " + id + ", nome: " + nome + ",descricao: "+descricao+", valor: "+valor+",id da categoria: "+idCategoria+"]";
        }
    
    
    
}
