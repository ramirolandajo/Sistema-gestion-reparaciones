package gui;

import controlador.Controlador;
import excepciones.alreadyExistsExceptions.VehiculoAlreadyExistsException;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Year;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaVehiculo {

    public Controlador controlador = Controlador.getControlador();

    public void abrirVentanaRegistrarVehiculo() {
        JFrame ventanaRegistrarVehiculo = new JFrame("Registrar vehículo");
        ventanaRegistrarVehiculo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ventanaRegistrarVehiculo.setLayout(new GridLayout(5, 2));

        JLabel lblMatricula = new JLabel("Matricula");
        lblMatricula.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtMatricula = new JTextField();

        JLabel lblModelo = new JLabel("Modelo");
        lblModelo.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtModelo = new JTextField();

        JLabel lblMarca = new JLabel("Marca");
        lblMarca.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtMarca = new JTextField();

        JLabel lblAnio = new JLabel("Año");
        lblAnio.setHorizontalAlignment(SwingConstants.CENTER);
        JTextField txtAnio = new JTextField();

        JButton btnAceptar = new JButton("Aceptar");
        JButton btnBorrar = new JButton("Borrar");
        JButton btnCancelar = new JButton("Cancelar");

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 2));
        panel.add(btnAceptar);
        panel.add(btnBorrar);
        panel.add(btnCancelar);

        ventanaRegistrarVehiculo.add(lblMatricula);
        ventanaRegistrarVehiculo.add(txtMatricula);
        ventanaRegistrarVehiculo.add(lblMarca);
        ventanaRegistrarVehiculo.add(txtMarca);
        ventanaRegistrarVehiculo.add(lblModelo);
        ventanaRegistrarVehiculo.add(txtModelo);
        ventanaRegistrarVehiculo.add(lblAnio);
        ventanaRegistrarVehiculo.add(txtAnio);
        ventanaRegistrarVehiculo.add(new JLabel());
        ventanaRegistrarVehiculo.add(panel);

        ventanaRegistrarVehiculo.setVisible(true);
        ventanaRegistrarVehiculo.pack();
        ventanaRegistrarVehiculo.setLocationRelativeTo(null);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtMatricula.getText().equals("") || txtMarca.getText().equals("") || txtModelo.getText().equals("") || txtAnio.getText().equals("")){
                    JOptionPane.showMessageDialog(ventanaRegistrarVehiculo, "Alguno de los campos está vacío.");
                } else {
                    String matricula = txtMatricula.getText();
                    String marca = txtMarca.getText();
                    String modelo = txtModelo.getText();
                    int anio = Integer.parseInt(txtAnio.getText());
                    try {
                        controlador.registrarVehiculo(matricula, marca, modelo, anio);
                        JOptionPane.showMessageDialog(ventanaRegistrarVehiculo, "El vehiculo ha sido registrado exitosamente!");
                    } catch (VehiculoAlreadyExistsException ex) {
                        JOptionPane.showMessageDialog(ventanaRegistrarVehiculo, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        txtMatricula.setText("");
                        txtMarca.setText("");
                        txtModelo.setText("");
                        txtAnio.setText("");
                        throw new RuntimeException(ex);
                    }
                }
                txtMatricula.setText("");
                txtMarca.setText("");
                txtModelo.setText("");
                txtAnio.setText("");
            }
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtMatricula.setText("");
                txtMarca.setText("");
                txtModelo.setText("");
                txtAnio.setText("");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaRegistrarVehiculo.dispose();
            }
        });
    }
}
