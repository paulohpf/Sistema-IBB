package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.DocumentParser;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class NovoPost extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldTitle;
	private final JLabel lblNewLabel = new JLabel("Categoria: ");
	public MaskFormatter ftmData;

	/**
	 * Launch the application.
	 */

	public int compareTo(Date datecompare){
		
		
		
		return (Integer) null;
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NovoPost frame = new NovoPost();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws ParseException
	 */
	public NovoPost() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane
				.setLayout(new FormLayout(new ColumnSpec[] {
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						FormFactory.DEFAULT_COLSPEC,
						FormFactory.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), }, new RowSpec[] {
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						RowSpec.decode("default:grow"),
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC,
						FormFactory.RELATED_GAP_ROWSPEC,
						FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblTitulo = new JLabel("Titulo: ");
		contentPane.add(lblTitulo, "4, 2, left, default");

		textFieldTitle = new JTextField();
		contentPane.add(textFieldTitle, "6, 2, fill, default");
		textFieldTitle.setColumns(10);

		JLabel lblConteudo = new JLabel("Conteudo: ");
		contentPane.add(lblConteudo, "4, 4");

		HTMLEditorKit kit = new HTMLEditorKit();
		HTMLDocument doc = new HTMLDocument();
		final JEditorPane editorPaneConteudo = new JEditorPane();
		contentPane.add(editorPaneConteudo, "6, 4, 1, 12, fill, fill");
		editorPaneConteudo.setEditorKit(kit);
		doc.putProperty("IgnoreCharsetDirective", new Boolean(true));
		editorPaneConteudo.setDocument(doc);
		contentPane.add(lblNewLabel, "4, 16");

		final JCheckBox chckbxBlog = new JCheckBox("Blog");
		contentPane.add(chckbxBlog, "6, 16, left, top");

		final JCheckBox chckbxMensagemDoMes = new JCheckBox(
				"Mensagem do M\u00EAs");
		contentPane.add(chckbxMensagemDoMes, "6, 18");

		final JCheckBox chckboxano2011 = new JCheckBox("2011");
		chckboxano2011.setEnabled(false);
		contentPane.add(chckboxano2011, "6, 20");

		final JCheckBox chckboxano2012 = new JCheckBox("2012");
		chckboxano2012.setEnabled(false);
		contentPane.add(chckboxano2012, "6, 22");

		final JCheckBox chckboxano2013 = new JCheckBox("2013");
		chckboxano2013.setEnabled(false);
		contentPane.add(chckboxano2013, "6, 24, default, top");

		chckbxMensagemDoMes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					chckboxano2011.setEnabled(true);
					chckboxano2012.setEnabled(true);
					chckboxano2013.setEnabled(true);
				} else if (e.getStateChange() == ItemEvent.DESELECTED) {
					chckboxano2011.setEnabled(false);
					chckboxano2012.setEnabled(false);
					chckboxano2013.setEnabled(false);
				}

				validate();
				repaint();
			}
		});

		JLabel lblPostData = new JLabel("Data de envio:");
		contentPane.add(lblPostData, "4, 26, right, default");

		ftmData = new MaskFormatter("####/##/## ##:##");
		final JFormattedTextField formattedData = new JFormattedTextField(
				ftmData);
		contentPane.add(formattedData, "6, 26, fill, default");

		final DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm");
		final Date date = new Date();

		formattedData.setText(dateFormat.format(date).toString());
	
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String title = textFieldTitle.getText();

				String conteudo = editorPaneConteudo.getText();

				conteudo = Funcoes.removeHTML(conteudo);

				String data = formattedData.getText();

				String guid = title;

				guid = Funcoes.removeLetrasGuid(guid).toLowerCase();
				

				System.out.println(title);
				System.out.println(conteudo);
				System.out.println(data);
				System.out.println(guid);			

				FuncoesSQL.inserePost(title, conteudo, data);

			}
		});
		contentPane.add(btnNewButton, "6, 28, right, default");
	}
}