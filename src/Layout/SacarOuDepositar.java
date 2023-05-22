package Layout;

import Contas.ContaCorrente;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class SacarOuDepositar extends JFrame {
    JLabel titulo = new JLabel("", SwingConstants.CENTER);
    JPanel panel = new JPanel();
    JLabel txtQuanto = new JLabel("Valor (XXX.XX):", SwingConstants.CENTER);
    JTextField inpQuanto = new JTextField();
    JButton btnDepositar = new JButton("Depositar");
    JButton btnSacar = new JButton("Sacar");
    public SacarOuDepositar(ContaCorrente c, JLabel ll) {
        setLayout(new BorderLayout(20, 10));

        Color verde = new Color(0,191,99);
        Color preto = new Color(000);

        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        titulo.setForeground(verde);
        String saldoS = String.valueOf(new DecimalFormat("0.00").format(c.getSaldo()));
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

        eventos(c, ll);
        getContentPane().setBackground(new Color(000));
        setTitle("Saque e depósito!");
        setSize(700,200);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private void eventos(ContaCorrente c, JLabel ll) {
        btnDepositar.addActionListener(e -> {
            try {
                double valor = Double.parseDouble(inpQuanto.getText());
                c.depositar(valor);
                String saldoS = String.valueOf(new DecimalFormat("0.00").format(c.getSaldo()));
                titulo.setText("R$ " + String.join(",",saldoS.split("\\.")));
                ll.setText(saldoS);
            } catch (Exception ex) {}
        });
        btnSacar.addActionListener(e -> {
            double valor = Double.parseDouble(inpQuanto.getText());
            c.sacar(valor);
            String saldoS = String.valueOf(new DecimalFormat("0.00").format(c.getSaldo()));
            titulo.setText("R$ " + String.join(",",saldoS.split("\\.")));
            ll.setText(saldoS);
        });
    }
}
