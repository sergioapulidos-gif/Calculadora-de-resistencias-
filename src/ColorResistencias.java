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

        cbBanda1.setModel(new DefaultComboBoxModel<>(colores));
        cbBanda2.setModel(new DefaultComboBoxModel<>(colores));
        cbMultiplicador.setModel(new DefaultComboBoxModel<>(colores));

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int banda1 = cbBanda1.getSelectedIndex();
                int banda2 = cbBanda2.getSelectedIndex();
                int multiplicador = cbMultiplicador.getSelectedIndex();

                int numero = banda1 * 10 + banda2;

                double resultado = numero * Math.pow(10, multiplicador);

                lblResultado.setText(resultado + " Ohmios");
            }
        });
    }
}
