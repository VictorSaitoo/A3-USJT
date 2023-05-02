import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SistemaAtendimento extends JFrame implements ActionListener {
    // Declaração dos componentes da interface gráfica
    private JTextField usuarioField;
    private JPasswordField senhaField;
    private JTextField cpfField;
    private JComboBox<String> tipoAtendimentoComboBox;
    private JButton abrirTokenButton;
    private JButton logarPacienteButton;
    private JButton gerarSenhaButton;

    public SistemaAtendimento() {
        super("Sistema de Atendimento"); // Título da janela principal

        // Criação dos componentes da interface gráfica
        JLabel usuarioLabel = new JLabel("Usuário:");
        JLabel senhaLabel = new JLabel("Senha:");
        usuarioField = new JTextField(20);
        senhaField = new JPasswordField(20);
        abrirTokenButton = new JButton("Abrir Token");

        // Adiciona os componentes à janela principal
        JPanel loginPanel = new JPanel(new GridLayout(3, 2));
        loginPanel.add(usuarioLabel);
        loginPanel.add(usuarioField);
        loginPanel.add(senhaLabel);
        loginPanel.add(senhaField);
        loginPanel.add(new JLabel());
        loginPanel.add(abrirTokenButton);
        add(loginPanel, BorderLayout.NORTH);

        // Configuração dos eventos dos botões
        abrirTokenButton.addActionListener(this);

        // Configurações da janela principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == abrirTokenButton) {
            // Verifica se o usuário e senha estão corretos
            String usuario = usuarioField.getText();
            String senha = new String(senhaField.getPassword()); // A senha deve ser convertida para String
            if (usuario.equals("atendente") && senha.equals("1234")) {
                // Abre a janela de login do paciente
               abrirJanelaPaciente();
            } else {
                JOptionPane.showMessageDialog(this, "Usuário ou senha incorretos.");
            }
        } else if (e.getSource() == logarPacienteButton) {
            // Gera a senha do atendimento
            String cpf = cpfField.getText();
            String tipoAtendimento = (String) tipoAtendimentoComboBox.getSelectedItem();
            int senha = gerarSenha(cpf, tipoAtendimento);
            JOptionPane.showMessageDialog(this, "Senha gerada: " + senha);
        }
    }

       // Método para gerar a senha do atendimento
       public static int gerarSenha(String cpf, String tipoAtendimento) {
        return (int)(Math.random() * 900) + 100;
    }



private void abrirJanelaPaciente() {
    // Criação dos componentes da interface gráfica
    JLabel cpfLabel = new JLabel("CPF:");
    JLabel tipoAtendimentoLabel = new JLabel("Tipo de Atendimento:");
    cpfField = new JTextField(20);
    tipoAtendimentoComboBox = new JComboBox<>(new String[] {"Preferencial", "Emergência", "Urgência", "Outros"});
    logarPacienteButton = new JButton("Logar");
    gerarSenhaButton = new JButton("Gerar Senha");

    // Adiciona os componentes à janela de login do paciente
    JPanel pacientePanel = new JPanel(new GridLayout(3, 2));
    pacientePanel.add(cpfLabel);
    pacientePanel.add(cpfField);
    pacientePanel.add(tipoAtendimentoLabel);
    pacientePanel.add(tipoAtendimentoComboBox);
    pacientePanel.add(new JLabel());
    pacientePanel.add(gerarSenhaButton);
    add(pacientePanel, BorderLayout.CENTER);

    // Configuração dos eventos dos botões
    gerarSenhaButton.addActionListener(this);

    // Configurações da janela principal
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(400, 200);
    setLocationRelativeTo(null);
    setVisible(true);
    
}

}
