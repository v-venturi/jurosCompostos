import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Objects;

/**
 * The type Calc form.
 */
public class CalcForm {
    /**
     * The Capital.
     */
    double capital;
    /**
     * The Montante.
     */
    double montante;
    /**
     * The Tx juros ao mes.
     */
    double txJurosAoMes;
    /**
     * The Prazo em meses.
     */
    double prazoEmMeses;
    /**
     * The Total juros.
     */
    double totalJuros;
    /**
     * The formatter.
     */
    DecimalFormat fmt = new DecimalFormat("#,##0.00");
    private OnlyNumbersTxtField valorInicialTxt;
    private OnlyNumbersTxtField txJurosTxt;
    private OnlyNumbersTxtField prazoTxt;
    private JLabel prazoEmMesesLabel;
    private JLabel taxaDeJurosAoLabel;
    private JLabel valorInicialLabel;
    private JTextField resultadoTxt;
    private JButton calcularButton;
    private JPanel CalcForm;
    private JButton limparButton;
    private JTextField jurosTotalTxt;
    private JLabel totalDeJurosLabel;

    /**
     * Instantiates a new Calculator form.
     */
    public CalcForm() {
        valorInicialTxt.setText("");
        txJurosTxt.setText("");
        prazoTxt.setText("");
        txJurosTxt.setToolTipText("Digite a taxa de juros ao mês (Ex: 1.99) ");
        valorInicialTxt.setMaximoCaracteres(12);
        txJurosTxt.setMaximoCaracteres(5);
        prazoTxt.setMaximoCaracteres(3);
        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((Objects.equals(valorInicialTxt.getText(), ""))
                        || (Objects.equals(txJurosTxt.getText(), "")) ||
                        (Objects.equals(prazoTxt.getText(), ""))) {
                    JOptionPane.showMessageDialog(null, "Digite os valores");
                    return;
                }
                capital = Double.parseDouble(valorInicialTxt.getText());
                txJurosAoMes = Double.parseDouble(txJurosTxt.getText()) / 100;
                prazoEmMeses = Double.parseDouble(prazoTxt.getText());
                montante = capital * (Math.pow(1 + txJurosAoMes, prazoEmMeses));
                totalJuros = montante - capital;
                resultadoTxt.setText(fmt.format(montante));
                jurosTotalTxt.setText(fmt.format(totalJuros));
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                valorInicialTxt.setText("");
                txJurosTxt.setText("");
                prazoTxt.setText("");
                resultadoTxt.setText("");
                jurosTotalTxt.setText("");

            }
        });
    }

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        ImageIcon imageIcon = new ImageIcon("src/img/percent.ico");
        JFrame frame = new JFrame("Calculadora de Juros Compostos");
        frame.setContentPane(new CalcForm().CalcForm);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setIconImage(imageIcon.getImage());

    }
}
