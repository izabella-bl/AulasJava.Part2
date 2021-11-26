package com.banco;

import com.banco.DAO.ContaCorrenteDao;
import com.banco.Model.ContaCorrente;

public class AppContaCorrente {
    public static void main( String[] args )
    {
        ContaCorrenteDao dao = new ContaCorrenteDao();
        ContaCorrente model = new ContaCorrente();
        model.setNome("Conta milhonaria que vou ter ");
        model.setDescricao("EU vou ser ricaaaaa!!!");


        dao.create(model);
    }
}
