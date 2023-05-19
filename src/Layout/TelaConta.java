package Layout;

import Contas.ContaCorrente;

import javax.swing.*;
import java.awt.*;

public class TelaConta extends JFrame {
    JLabel titulo = new JLabel("", SwingConstants.CENTER);
    JPanel panel = new JPanel();
    JButton sacarDepo = new JButton("Sacar ou depositar");
    JButton tranferir = new JButton("Transferir");
    JButton sair = new JButton("Sair");
    JLabel numConta = new JLabel("", SwingConstants.CENTER);
    JLabel dinheiro = new JLabel("", SwingConstants.CENTER);
    JButton maisInfo = new JButton("+Info");
    public TelaConta(ContaCorrente c) {
        setLayout(new BorderLayout(20, 10));

        Color verde = new Color(0,191,99);
        Color preto = new Color(000);

        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        titulo.setForeground(verde);
        titulo.setText("Olá, " + c.getTitular().getNome());
        add(BorderLayout.NORTH, titulo);

        GridLayout grid = new GridLayout(2,3);
        grid.setHgap(10);
        grid.setVgap(6);
        panel.setLayout(grid);
        panel.setBackground(preto);

        JLabel[] lb = new JLabel[]{ numConta, dinheiro };
        for(JLabel l : lb) {
            l.setForeground(verde);
            l.setFont(new Font("Verdana", Font.BOLD, 20));
        }

        JButton[] labels = new JButton[]{ sacarDepo, tranferir, sair, maisInfo };
        for( JButton l : labels ) {
            l.setBackground(preto);
            l.setForeground(verde);
            l.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        }

        numConta.setText(c.getNumeroAgencia() + " " + c.getConta());
        String saldoS = String.valueOf(c.getSaldo());
        dinheiro.setText("R$ " + String.join(",",saldoS.split("\\.")));

        panel.add(numConta); panel.add(dinheiro); panel.add(maisInfo);
        panel.add(sacarDepo); panel.add(tranferir); panel.add(sair);

        add(BorderLayout.CENTER, panel);

        eventos(c, this);

        getContentPane().setBackground(new Color(000));
        setTitle("Boas vindas!");
        setSize(700,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void eventos(ContaCorrente c, TelaConta tela) {
        maisInfo.addActionListener(e -> {
            JOptionPane.showMessageDialog(null,
                    "** Conta de " + c.getTitular().getNome() + " **\n" +
                             "Agência: " + c.getNumeroAgencia() + "\n" +
                             "Conta: " + c.getConta() +"\n" +
                             "CPF: " + c.getTitular().getCpf() + "\n" +
                             "Data de nascimento: " + c.getTitular().getNascimento() + "\n" +
                             "Endereço: " + c.getTitular().getEndereco() +"\n" +
                             "Profissão: " + c.getTitular().getProfissao());
        });
        sair.addActionListener(e -> {
            tela.dispose();
        });
        sacarDepo.addActionListener(e -> {
            new SacarOuDepositar(c, dinheiro);
        });
        tranferir.addActionListener(e -> {
            new Transferir(c, dinheiro);
        });
    }
}
