package gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import domain.Aeropuerto;
public class LoginControlador extends JFrame {
    private static final long serialVersionUID = 1L;
    private JTextField txtUsuario;
    private JPasswordField txtPassword;
    private JButton btnLogin;

    public LoginControlador(Aeropuerto aeropuerto) {

        setTitle("Login - Controlador Aéreo");
        setSize(350, 180);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel panelCampos = new JPanel(new GridLayout(2, 2, 10, 10));
        panelCampos.add(new JLabel("Usuario / ID:"));
        txtUsuario = new JTextField();
        panelCampos.add(txtUsuario);
        panelCampos.add(new JLabel("Contraseña:"));
        txtPassword = new JPasswordField();
        panelCampos.add(txtPassword);
        add(panelCampos, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel();
        btnLogin = new JButton("Acceder");
        panelBotones.add(btnLogin);
        add(panelBotones, BorderLayout.SOUTH);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText().trim();
                String pass = new String(txtPassword.getPassword());
                if (usuario.equals("admin") && pass.equals("1234")) {
                	new VentanaControlador(aeropuerto);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(LoginControlador.this, "Usuario o contraseña incorrectos", "Error de Login", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}