package iza.com.estudo.view;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import iza.com.estudo.dao.PessoaDao;
import iza.com.estudo.model.*;



public class Create2View extends JFrame {
	
	private PessoaDao dao;
    private Container container;
    private JLabel lbNome;
    private JLabel lbSobrenome;
    private JLabel lbIdade;
    private JLabel lbEndereco;
    private JTextField txtNome;
    private JTextField txtSobrenome;
    private JTextField txtIdade;
    private JTextField txtEndereco;
    private JButton btnSalvar, btnDelete, btnUpdate;
    private JTable table;
    private DefaultTableModel tableModel;

    public Create2View() {
        super("Pessoa");
        setLayout(null);
       
        inicializaComponentes();
        posicionamento();

        adicionaEventos();

        ler();
        setSize(1000, 800);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    private void inicializaComponentes(){
        dao = new PessoaDao();
        container = getContentPane();
        
        lbNome =  new JLabel("Nome:");
        txtNome = new JTextField();
        
        lbSobrenome =  new JLabel("Sobrenome:");
        txtSobrenome = new JTextField();  
        
        lbIdade =  new JLabel("Idade:");
        txtIdade = new JTextField();
        
        lbEndereco =  new JLabel("Endereço:");
        txtEndereco = new JTextField();
        
        btnSalvar = new JButton("Salvar");
        btnDelete = new JButton("Deletar");
        btnUpdate = new JButton("Alterar");
        table = new JTable();
        tableModel = (DefaultTableModel)table.getModel();
        tableModel.addColumn("Id");
        tableModel.addColumn("Nome");
        tableModel.addColumn("Spbrenome");
        tableModel.addColumn("Idade");
        tableModel.addColumn("Endereco");
    }

    
    private void posicionamento() {
    	lbNome.setBounds(10, 10, 50, 20);
    	txtNome.setBounds(70, 10, 250, 20);
    	
    	lbSobrenome.setBounds(10, 35, 75, 20);
    	txtSobrenome.setBounds(80, 35, 250, 20);
    	
    	lbIdade.setBounds(10, 60, 50, 20);
    	txtIdade.setBounds(70, 60, 250, 20);
    	
    	lbEndereco.setBounds(10, 90, 70, 20);
    	txtEndereco.setBounds(70, 90, 250, 20);

    	
        
    	btnSalvar.setBounds(10, 120, 100, 20);
        table.setBounds(10,160 , 700, 300);
        btnDelete.setBounds(10, 600, 100, 20);
        btnUpdate.setBounds(115, 600, 100, 20);

        container.add(lbNome);
        container.add(txtNome);
        
        container.add(lbSobrenome);
        container.add(txtSobrenome);
        
        container.add(lbIdade);
        container.add(txtIdade);
        
        container.add(lbEndereco);
        container.add(txtEndereco);
        
        container.add(btnSalvar);
        container.add(table);
        container.add(btnDelete);
        container.add(btnUpdate);
    }

    private void adicionaEventos() {
        btnSalvar.addActionListener( new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {               
               Pessoa model = new Pessoa();
               model.setNome(txtNome.getText());
               model.setSobrenome(txtSobrenome.getText());
               int valor = ValidaNumero(txtIdade);
               model.setIdade(valor);
               if(valor == 0){
                   return;
               }
               model.setEndereco(txtEndereco.getText());
               salvar(model);               
            }
        });

        btnDelete.addActionListener( new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {               
               int id = (int)table.getValueAt(table.getSelectedRow(), 0);
               Pessoa model = new Pessoa();
               model.setId(id);
               delete(model);               
            }
        });

        btnUpdate.addActionListener( new ActionListener(){            
            @Override
            public void actionPerformed(ActionEvent e) {               
               int id = (int)table.getValueAt(table.getSelectedRow(), 0);
               String nome = (String)table.getValueAt(table.getSelectedRow(), 1);
               String sobrenome = (String)table.getValueAt(table.getSelectedRow(), 2);
               int idade = (int)table.getValueAt(table.getSelectedRow(), 3);
               String endereco = (String)table.getValueAt(table.getSelectedRow(), 4);
               Pessoa model = new Pessoa();
               model.setId(id);
               model.setNome(nome);
               model.setSobrenome(sobrenome);
               model.setIdade(idade);
               model.setEndereco(endereco);
               alterar(model);               
            }
           
        });
    }


    private void salvar(Pessoa model){
        dao.insert(model);
        JOptionPane.showMessageDialog(container, "Pessoas: "+model.getNome()+ " Salva com sucesso!" ); 
        ler(); 
    }

    private void ler(){
        tableModel.setRowCount(0);
        for (Pessoa p : dao.read()) {
            tableModel.addRow(new Object[]{p.getId(), p.getNome(),p.getSobrenome(),p.getIdade(),p.getEndereco()});
        }
    }
    
    private void delete(Pessoa model){
        dao.delete(model);
        JOptionPane.showMessageDialog(container, "Pessoa de id: "+model.getId() +" Deletada com sucesso!" );        
        ler();
    }
    
    private void alterar(Pessoa model) {
        dao.update2(model);
        JOptionPane.showMessageDialog(container, "Pessoa de id: "+model.getId() +" Alterada com sucesso!" );        
        ler();
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