package iza.com.estudo.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import iza.com.estudo.dao.PessoaDao;
import iza.com.estudo.model.Pessoa;

public class CreateView  extends JFrame{
    private Container container;

    public CreateView() {
        super("Pessoa");
        setLayout(null);
       
        container = getContentPane();
        JLabel lbNome =  new JLabel("Nome:");
        lbNome.setBounds(10, 10, 50, 20);

        final JTextField txtNome = new JTextField();
        txtNome.setBounds(70, 10, 250, 20);

        JLabel lbsobrenome =  new JLabel("Sobrenome:");
        lbsobrenome.setBounds(10, 35, 75, 20);

        final JTextField txtSobrenome = new JTextField();
        txtSobrenome.setBounds(80, 35, 250, 20);

        JLabel lbidade =  new JLabel("Idade:");
        lbidade.setBounds(10, 60, 50, 20);

        final JTextField txtidade = new JTextField();
        txtidade.setBounds(70, 60, 250, 20);

        

        JLabel lbendereco =  new JLabel("Endereço:");
        lbendereco.setBounds(10, 90, 70, 20);

        final JTextField txtendereco = new JTextField();
        txtendereco.setBounds(70, 90, 250, 20);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(10, 120, 100, 20);


        btnSalvar.addActionListener( new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {               
               Pessoa model = new Pessoa();
               model.setNome(txtNome.getText());
               model.setSobrenome(txtSobrenome.getText());
               int validaIdade = ValidaNumero (txtidade);
               if(validaIdade == 0){
                   return;
               }
               model.setIdade(validaIdade);
               model.setEndereco(txtendereco.getText());
               salvar(model);               
            }
        });

        container.add(lbNome);
        container.add(txtNome);
        container.add(lbsobrenome);
        container.add(txtSobrenome);
        container.add(lbidade);
        container.add(txtidade);
        container.add(lbendereco);
        container.add(txtendereco);
        container.add(btnSalvar);

        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void salvar(Pessoa model){
        PessoaDao dao = new PessoaDao();
        dao.insert(model);
        JOptionPane.showMessageDialog(container, "Pessoa:"+model.getNome()+ " Salva com sucesso!" ); 
    }

    private  int  ValidaNumero(JTextField Numero) {
        int valor = 0;

        if (Numero.getText().length() != 0){
           
            try {
                valor = Integer.parseInt(Numero.getText());
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Esse Campo só aceita números\n" +"Informação:"+JOptionPane.INFORMATION_MESSAGE);
                Numero.grabFocus();
            }
        }

        return valor;
    }
}

