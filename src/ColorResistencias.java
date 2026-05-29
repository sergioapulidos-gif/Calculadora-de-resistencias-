import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorResistencias {
    private JPanel panel1;
    private JComboBox cbMultiplicador;
    private JButton btnCalcular;
    private JComboBox cbBanda2;
    private JComboBox cbBanda1;
    private JLabel lblResultado;
    private JComboBox cbTolerancia;

    public ColorResistencias() {

        String[] colores = {
                "Negro",
                "Marron",
                "Rojo",
                "Naranja",
                "Amarillo",
                "Verde",
                "Azul",
                "Violeta",
                "Gris",
                "Blanco"
        };

        String[] tolerancias = {
                "Marron ±1%",
                "Rojo ±2%",
                "Verde ±0.5%",
                "Azul ±0.25%",
                "Violeta ±0.1%",
                "Gris ±0.05%",
                "Dorado ±5%",
                "Plateado ±10%"
        };

        cbTolerancia.setModel(new DefaultComboBoxModel<>(tolerancias));
        cbBanda1.setModel(new DefaultComboBoxModel<>(colores));
        cbBanda2.setModel(new DefaultComboBoxModel<>(colores));
        cbMultiplicador.setModel(new DefaultComboBoxModel<>(colores));

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String tolerancia;

                switch (cbTolerancia.getSelectedIndex()) {
                    case 0:
                        tolerancia = "±1%";
                        break;
                    case 1:
                        tolerancia = "±2%";
                        break;
                    case 2:
                        tolerancia = "±0.5%";
                        break;
                    case 3:
                        tolerancia = "±0.25%";
                        break;
                    case 4:
                        tolerancia = "±0.1%";
                        break;
                    case 5:
                        tolerancia = "±0.05%";
                        break;
                    case 6:
                        tolerancia = "±5%";
                        break;
                    default:
                        tolerancia = "±10%";
                }

                int banda1 = cbBanda1.getSelectedIndex();
                int banda2 = cbBanda2.getSelectedIndex();
                int multiplicador = cbMultiplicador.getSelectedIndex();

                int numero = banda1 * 10 + banda2;

                double resultado = numero * Math.pow(10, multiplicador);

                lblResultado.setText(resultado + " Ω " + tolerancia);
            }
        });
    }
    public static void main(String[] args) {

        JFrame frame = new JFrame("Calculadora de Resistencias");

        frame.setContentPane(new ColorResistencias().panel1);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();

        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }
}
