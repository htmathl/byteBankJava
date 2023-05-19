package Layout;

import Contas.ContaCorrente;

import javax.swing.*;
import java.awt.*;

public class SacarOuDepositar extends JFrame {
    JLabel titulo = new JLabel("", SwingConstants.CENTER);
    JPanel panel = new JPanel();
    JLabel txtQuanto = new JLabel("Valor (XXX,XX):", SwingConstants.CENTER);
    JTextField inpQuanto = new JTextField();
    JButton btnDepositar = new JButton("Depositar");
    JButton btnSacar = new JButton("Sacar");
    public SacarOuDepositar(ContaCorrente c) {
        setLayout(new BorderLayout(20, 10));

        Color verde = new Color(0,191,99);
        Color preto = new Color(000);

        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        titulo.setForeground(verde);
        String saldoS = String.valueOf(c.getSaldo());
        titulo.setText("R$ " + String.join(",",saldoS.split("\\.")));
        add(BorderLayout.NORTH, titulo);

        GridLayout grid = new GridLayout(2,2);
        grid.setHgap(10);
        grid.setVgap(6);
        panel.setLayout(grid);
        panel.setBackground(preto);

        txtQuanto.setForeground(verde);
        txtQuanto.setFont(new Font("Verdana", Font.PLAIN, 18));
        JButton[] labels = new JButton[]{ btnDepositar, btnSacar };
        for( JButton l : labels ) {
            l.setBackground(preto);
            l.setForeground(verde);
            l.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
        }

        panel.add(txtQuanto); panel.add(inpQuanto);
        panel.add(btnDepositar); panel.add(btnSacar);

        add(panel);

        getContentPane().setBackground(new Color(000));
        setTitle("Saque e depósito!");
        setSize(700,200);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
