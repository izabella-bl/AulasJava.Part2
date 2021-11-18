package iza.com.estudo.view;

import java.util.Scanner;

import iza.com.estudo.model.*;
import iza.com.estudo.dao.*;

public class UpdateView {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        PessoaDao dao = new PessoaDao();
        Pessoa p = new Pessoa();
        boolean continuar = true;

        dao.select();
      
        do{
            System.out.println("\nDigite  o id que deseja atulizar");
            int id = Integer.parseInt(sc.nextLine());
            p.setId(id);

            System.out.println("Oque deseja atulizar?");
            System.out.println("1 - Nome | 2 - Sobrenome | 3 - Idade | 4 - endereco");
            int op = Integer.parseInt(sc.nextLine());

            switch(op){

                case 1:
                    System.out.println("Digite o nome Atualizado:");
                    String nome = sc.nextLine();
                    p.setNome(nome);
                    dao.update(p,"nome");
                    dao.select();
                break;

                case 2:
                    System.out.println("Digite o sobrenome Atualizado:");
                    String sobrenome = sc.nextLine();
                    p.setSobrenome(sobrenome);
                    dao.update(p,"sobrenome");
                    dao.select();
                break;

                case 3:
                    System.out.println("Digite a idade Atualizada:");
                    int idade = Integer.parseInt(sc.nextLine());
                    p.setIdade(idade);
                    dao.update(p,"idade");
                    dao.select();
                break;

                case 4:
                    System.out.println("Digite o endereco Atualizado:");
                    String endereco = sc.nextLine();
                    p.setEndereco(endereco);
                    dao.update(p,"endereco");
                    dao.select();
                break;

                default:
                    System.out.println("Não possui essa opção!");
                break;
                
            }

            continuar = desejarContinuar();

        }while(continuar == true);
        
        
    }

    public static boolean desejarContinuar() {
        boolean retorno = true;
        char op ;

        do{
            System.out.println("Desejar continuar ? S - sim | N - Não");
            op = sc.nextLine().toUpperCase().charAt(0);
            retorno = ((op == 'S') ? true: false);
        }while(op != 'S' && op != 'N');

        return retorno;  
    }
    
   
   
    
}
