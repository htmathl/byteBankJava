package Layout;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {
    JPanel panel = new JPanel();
    JLabel titulo = new JLabel("Byte Bank", SwingConstants.CENTER);
    JButton criarConta = new JButton("Crie sua conta!");
    JButton entrarNaConta = new JButton("Já tenho uma conta");
    JButton transferirConta = new JButton("");
    JButton sacarDepositarConta = new JButton();
    JButton consultarConta = new JButton();
    public Tela() {
        setLayout(new BorderLayout(10, 20));
        //titulo.setIcon(new ImageIcon(getClass().getResource("../img/titulo.png")));

        Color verde = new Color(0,191,99);
        Color preto = new Color(000);

        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        titulo.setForeground(verde);
        add(BorderLayout.NORTH, titulo);

        panel.setLayout(new GridLayout(1, 2));

        criarConta.setBackground(new Color(000));
        entrarNaConta.setBackground(new Color(000));
        criarConta.setForeground(verde);
        entrarNaConta.setForeground(verde);
        criarConta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        entrarNaConta.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        eventos();

        panel.add(criarConta);
        panel.add(entrarNaConta);

        add(BorderLayout.CENTER, panel);
        getContentPane().setBackground(new Color(000));
        setTitle("Byte Bank");
        setSize(700,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void eventos() {
        criarConta.addActionListener(e -> {
            new CriarConta();
        });
        entrarNaConta.addActionListener(e -> {
            new EntrarConta();
        });
    }
}
