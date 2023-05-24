package Layout;

import Contas.ContaCorrente;
import Contas.ContasCorrentes;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.Objects;

public class Transferir extends JFrame {
    JLabel titulo = new JLabel("", SwingConstants.CENTER);
    JPanel panel = new JPanel();
    JLabel lblAgencia = new JLabel("Agência:", SwingConstants.CENTER);
    JLabel lblConta = new JLabel("Conta:", SwingConstants.CENTER);
    JLabel lblValor = new JLabel("Valor:", SwingConstants.CENTER);
    JTextField inpAgencia = new JTextField();
    JTextField inpConta = new JTextField();
    JTextField inpValor = new JTextField();
    JButton transferir = new JButton("Transferir");
    public Transferir(ContaCorrente c, JLabel ll) {
        setLayout(new BorderLayout(20, 10));

        Color verde = new Color(0,191,99);
        Color preto = new Color(0);

        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        titulo.setForeground(verde);
        String saldoS = String.valueOf(new DecimalFormat("0.00").format(c.getSaldo()));
        titulo.setText("R$ " + String.join(",",saldoS.split("\\.")));
        add(BorderLayout.NORTH, titulo);

        GridLayout grid = new GridLayout(3,2);
        grid.setHgap(10);
        grid.setVgap(15);
        panel.setLayout(grid);
        panel.setBackground(preto);

        JLabel[] lbls = new JLabel[] { lblAgencia, lblConta, lblValor };
        for(JLabel l : lbls) {
            l.setForeground(verde);
            l.setFont(new Font("Verdana", Font.PLAIN, 18));
        }

        transferir.setBackground(preto);
        transferir.setForeground(verde);
        transferir.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));

        panel.add(lblAgencia); panel.add(inpAgencia);
        panel.add(lblConta); panel.add(inpConta);
        panel.add(lblValor); panel.add(inpValor);

        add(BorderLayout.CENTER, panel);
        add(BorderLayout.SOUTH, transferir);

        eventos(c, ll);

        getContentPane().setBackground(new Color(0));
        setTitle("Transferência!");
        setSize(700,300);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
    public void eventos(ContaCorrente c, JLabel ll) {
        transferir.addActionListener(e -> {
            try{
                int agencia = Integer.parseInt(inpAgencia.getText());
                String conta = inpConta.getText();
                String valorFormatado = inpValor.getText().contains(",") ? String.join(".",inpValor.getText().split(",")) : inpValor.getText();
                double valor = Double.parseDouble(valorFormatado);

                ContasCorrentes correntes = new ContasCorrentes();
                for(ContaCorrente cc : correntes.getContaCorrentes()) {
                    if(Objects.equals(cc.getConta(), conta)) {
                        if(cc.getNumeroAgencia() == agencia) {
                            if(c.tranferir(valor, cc)) {
                                this.dispose();
                                JOptionPane.showMessageDialog(null, "Valor transferido!");
                                String saldoS = String.valueOf(new DecimalFormat("0.00").format(c.getSaldo()));
                                String saldoFinal = "R$ " + String.join(",", saldoS.split("\\."));
                                titulo.setText(saldoFinal);
                                ll.setText(saldoFinal);
                            } else {
                                JOptionPane.showMessageDialog(null, "Saldo insuficiente!");
                            }
                        }
                    }
                }

            } catch (Exception ignored) {}
        });
    }
}
