package Layout;

import Contas.ContaCorrente;
import Contas.ContasCorrentes;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Objects;

public class EntrarConta extends JFrame {
    JLabel titulo = new JLabel("Insira seus dados:", SwingConstants.CENTER);
    JPanel panel = new JPanel();
    JLabel txtAgencia = new JLabel("Agência:", SwingConstants.CENTER);
    JLabel txtConta = new JLabel("Número da conta ou CPF:", SwingConstants.CENTER);
    JLabel txtSenha = new JLabel("Senha:", SwingConstants.CENTER);
    JTextField inpAgencia = new JTextField();
    JTextField inpConta = new JTextField();
    JPasswordField inpSenha = new JPasswordField(10);
    JButton entrar = new JButton("Vamos nessa!");
    public EntrarConta() {
        setLayout(new BorderLayout(20, 10));

        Color verde = new Color(0,191,99);
        Color preto = new Color(000);

        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        titulo.setForeground(verde);
        add(BorderLayout.NORTH, titulo);

        GridLayout grid = new GridLayout(3,2);
        grid.setVgap(10);
        panel.setLayout(grid);
        panel.setBackground(preto);

        JLabel[] labels = new JLabel[]{ txtAgencia, txtConta, txtSenha };
        for( JLabel l : labels ) {
            l.setForeground(verde);
            l.setFont(new Font("Verdana", Font.PLAIN, 16));
        }

        inpSenha.setEchoChar('*');

        panel.add(txtAgencia); panel.add(inpAgencia);
        panel.add(txtConta); panel.add(inpConta);
        panel.add(txtSenha); panel.add(inpSenha);

        add(BorderLayout.CENTER, panel);

        entrar.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        entrar.setBackground(preto);
        entrar.setForeground(verde);

        add(BorderLayout.SOUTH, entrar);
        entrarF();

        getContentPane().setBackground(new Color(000));
        setTitle("Tudo pronto para você");
        setSize(700,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void entrarF() {
        entrar.addActionListener(e -> {
            try {
                int agencia = Integer.parseInt(inpAgencia.getText());
                String conta = inpConta.getText();
                String senha = inpSenha.getText();

                if(Objects.equals(conta, "") || Objects.equals(senha, "")) {
                    JOptionPane.showMessageDialog(null, "Preecha todos os campos");
                    return;
                }

                ContasCorrentes correntes = new ContasCorrentes();
                if(correntes.getContaCorrentes().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Está conta não existe!");
                    return;
                };
                for (ContaCorrente c : correntes.getContaCorrentes()) {
                    if(Objects.equals(conta, c.getConta()) || Objects.equals(conta, c.getTitular().getCpf())) {
                        if(agencia == c.getNumeroAgencia()) {
                            if(Objects.equals(senha, c.getSenha())) {
                                System.out.println("Entrou!");
                                this.dispose();
                                new TelaConta(c);
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "** Confira se seu número de conta/CPF e senha estão corretos **\nDica: Se for entrar com CPF deve estar XXX.XXX.XXX-XX | para números de conta XXXX-X");
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "** Confira se seu número de conta/CPF e senha estão corretos **\nDica: Se for entrar com CPF deve estar XXX.XXX.XXX-XX | para números de conta XXXX-X");
                        break;
                    }
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Coloque uma agência válida");
            }
        });
    }
}
