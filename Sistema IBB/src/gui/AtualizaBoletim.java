package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.net.SocketException;

import javax.swing.JLabel;

public class AtualizaBoletim extends JFrame {

	private JPanel contentPane;
	private JTextField Teste;
	private JLabel lblSelecioneOArquivo;

	/**
	 * Launch the application.
	 */

	public File arquivo;
	private JButton btnEnviar;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AtualizaBoletim frame = new AtualizaBoletim();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AtualizaBoletim() {
		setTitle("Enviar Boletim");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(
				new ColumnSpec[] { FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC, }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		lblSelecioneOArquivo = new JLabel("Selecione o Arquivo: ");
		contentPane.add(lblSelecioneOArquivo, "2, 4, right, default");

		Teste = new JTextField();
		contentPane.add(Teste, "4, 4, 13, 1, fill, default");
		Teste.setColumns(10);
		Teste.setEditable(false);

		JButton btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				final JFileChooser fileChooser = new JFileChooser();
				FileNameExtensionFilter fileFilter = new FileNameExtensionFilter(
						"PDF Files", new String[] { "pdf" });
				fileChooser.setFileFilter(fileFilter);
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.setMultiSelectionEnabled(false);
				contentPane.add(fileChooser, "4, 16, fill, default");

				int returnVal = fileChooser.showOpenDialog(Teste);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					arquivo = fileChooser.getSelectedFile();

					String nomeArquivo = arquivo.getName();
					int temp = nomeArquivo.lastIndexOf(".");
					String extensao = nomeArquivo.substring(temp);
					if (extensao.equals(".pdf")) {
						arquivo = fileChooser.getSelectedFile();

						arquivo = fileChooser.getSelectedFile();

						Teste.setText(arquivo.getAbsolutePath());
					} else {
						JOptionPane.showMessageDialog(null,
								"Arquivo não suportado", "Erro",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			}
		});
		contentPane.add(btnProcurar, "18, 4");

		btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					FuncoesSQL.atualizaBoletim(arquivo);
				} catch (SocketException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(btnEnviar, "18, 18");

	}
}