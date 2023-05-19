package Layout;

import Contas.ContaCorrente;
import Contas.ContasCorrentes;
import TItular.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

public class CriarConta extends JFrame {
    public ContasCorrentes correntes;
    JLabel titulo = new JLabel("Insira seus dados:", SwingConstants.CENTER);
    JPanel panel = new JPanel();
    JLabel lblNome = new JLabel("Nome:", SwingConstants.CENTER);
    JLabel lblCpf = new JLabel("CPF(XXX.XXX.XXX-XX):", SwingConstants.CENTER);
    JLabel lblNasc = new JLabel("Data de nascimento(XX/XX/XXXX):", SwingConstants.CENTER);
    JLabel lblEnd = new JLabel("Endereço:", SwingConstants.CENTER);
    JLabel lblProf = new JLabel("Profissão:", SwingConstants.CENTER);
    JLabel lblSenha = new JLabel("Senha:", SwingConstants.CENTER);
    JTextField inpNome = new JTextField();
    JTextField inpCpf = new JTextField();
    JTextField inpNasc = new JTextField();
    JTextField inpEnd = new JTextField();
    JTextField inpProf = new JTextField();
    JPasswordField inpSenha = new JPasswordField(10);
    JPanel btnPanel = new JPanel();
    JButton criar = new JButton("Vamos nessa!");
    public CriarConta() {
        setLayout(new BorderLayout(20, 10));

        Color verde = new Color(0,191,99);
        Color preto = new Color(000);

        titulo.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        titulo.setForeground(verde);
        add(BorderLayout.NORTH, titulo);

        GridLayout grid = new GridLayout(6,2);
        grid.setVgap(5);
        panel.setLayout(grid);
        panel.setBackground(preto);

        JLabel[] labels = {lblNome, lblCpf, lblNasc, lblEnd, lblProf, lblSenha};
        for(JLabel l : labels) {
            l.setForeground(verde);
            l.setFont(new Font("Verdana", Font.PLAIN, 15));
        }

        inpSenha.setEchoChar('*');

        panel.add(lblNome); panel.add(inpNome);
        panel.add(lblCpf); panel.add(inpCpf);
        panel.add(lblNasc); panel.add(inpNasc);
        panel.add(lblEnd); panel.add(inpEnd);
        panel.add(lblProf); panel.add(inpProf);
        panel.add(lblSenha); panel.add(inpSenha);

        GridLayout grid2 = new GridLayout(1,1);
        btnPanel.setLayout(grid2);
        criar.setFont(new Font("Comic Sans MS", Font.PLAIN, 30));
        criar.setBackground(preto);
        criar.setForeground(verde);
        btnPanel.add(criar);

        add(BorderLayout.CENTER, panel);
        add(BorderLayout.SOUTH, btnPanel);

        getContentPane().setBackground(new Color(000));
        setTitle("Nova conta");
        setSize(700,470);
        setLocationRelativeTo(null);
        setVisible(true);

        criarConta();
    }
    private void criarConta() {
        criar.addActionListener(e -> {
            try {
                String nome = inpNome.getText().toUpperCase();
                String CPF = inpCpf.getText();
                String nasc = inpNasc.getText();
                String end = inpEnd.getText();
                String prof = inpProf.getText();
                String senha = inpSenha.getText();

                String[] conj = new String[]{ nome, CPF, nasc, end, prof };
                for(String s : conj) {
                    if(Objects.equals(s, "")) {
                        JOptionPane.showMessageDialog(null, "Preencha todos os campos");
                        return;
                    }
                }

                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int verificaIdade = Integer.parseInt(nasc.split("/")[2]);
                if(year - verificaIdade < 18 || year - verificaIdade > 99) {
                    JOptionPane.showMessageDialog(null, "Você precisa ser maior de idade e ter uma idade válida");
                    return;
                }

                int ponto = CPF.split("\\.").length;
                int traco = CPF.split("-").length;
                int numCpf = CPF.split("").length;
                if(numCpf < 14 || ponto < 3 || traco < 2) {
                    JOptionPane.showMessageDialog(null, "CPF inválido");
                    return;
                }

                Cliente novo = new Cliente(nome, CPF, prof, end, nasc);

                int contaP = (int)(Math.random() * (99 - 10) + 10);
                int contaM = (int)(Math.random() * (99 - 10) + 10);
                String[] ctSg = {"-X", "-0", "-M", "-K", "-9"};
                String contaF = "" + contaM + contaP + ctSg[(int)(Math.random() * ctSg.length)];
                ContaCorrente ct = new ContaCorrente(((int)(Math.random() * 12)), contaF, novo, senha);
                correntes = new ContasCorrentes(ct);

                correntes.showContas();
                this.dispose();
                JOptionPane.showMessageDialog(null, "Esperamos que esteja bem, " + nome + ".\nConta Criada com sucesso!\n ** Lembre destes dados **\nNúmero da conta: " + ct.getConta() + "\nAgência: " + ct.getNumeroAgencia());

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Insira uma data válida!");
            }
        });
    }
}
