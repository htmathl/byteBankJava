package Layout;

import javax.swing.*;
import java.awt.*;

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
    public Transferir() {
        setLayout(new BorderLayout(20, 10));

        Color verde = new Color(0,191,99);
        Color preto = new Color(000);

        titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 35));
        titulo.setForeground(verde);
        titulo.setText("R$ 500,36");
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

        getContentPane().setBackground(new Color(000));
        setTitle("Transferência!");
        setSize(700,300);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
