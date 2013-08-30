package jark.levelgen;

import jark.entity.EntityBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class EditorWindow {

	private static final int WIDTH = 800 + 6 + 200;
	private static final int HEIGHT = 558;

	public static LevelEditor editor = new LevelEditor();

	private JFrame frame;
	private JPanel controlPanel;
	private JPanel editorPanel;
	private JPanel palettePanel;

	private JButton saveButton;
	private JButton btnEraseTool;
	private JButton btnRedBrick;
	private JButton btnBlueBrick;
	private JButton btnGreenBrick;
	private JButton btnYellowBrick;
	private JButton btnVioletBrick;
	private JButton btnGoldenBrick;
	private JButton btnMetalBrick_1;
	private JButton btnMetalBrick_2;
	private JButton btnMetalBrick_3;
	private JButton btnLightGreenBrick;
	private JButton btnCyanBrick;
	private JButton btnLightCyanBrick;
	private JButton btnPinkBrick;
	private JButton btnLightPinkBrick;
	private JButton btnDarkYellowBrick;
	private JButton btnExplosingBrick;
	private JButton btnInvisibleBrick;
	private JTextField textField;
	private JTextField textField_1;
	private JButton loadButton;
	private JLabel lblEnterNameOf;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditorWindow window = new EditorWindow();
					window.frame.setVisible(true);
					editor.start();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditorWindow() {
		setSystemLookAndFeel();
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		initFrame();

		editorPanel = new JPanel();
		editorPanel.setBounds(0, 0, 800, 450);
		editorPanel.setLayout(new BorderLayout());
		editorPanel.add(editor, BorderLayout.CENTER);
		frame.getContentPane().add(editorPanel);

		palettePanel = new JPanel();
		palettePanel.setBounds(0, 450, 800, 78);
		frame.getContentPane().add(palettePanel);

		initPalette();
		initSettingsPanel();

	}

	private void initSettingsPanel() {
		controlPanel = new JPanel();
		controlPanel.setBounds(800, 0, 210, 528);
		controlPanel.setLayout(null);
		frame.getContentPane().add(controlPanel);

		SettingsActionHandler settingsHandler = this.new SettingsActionHandler();

		saveButton = new JButton("Save Level");
		saveButton.setBounds(10, 11, 173, 26);
		saveButton.addActionListener(settingsHandler);
		controlPanel.add(saveButton);

		loadButton = new JButton("Load Level");
		loadButton.setBounds(10, 121, 173, 23);
		loadButton.addActionListener(settingsHandler);
		controlPanel.add(loadButton);

		textField = new JTextField();
		textField.setBounds(10, 90, 173, 20);
		textField.setColumns(10);
		controlPanel.add(textField);

		lblEnterNameOf = new JLabel();
		lblEnterNameOf
				.setText("<html>\r\n\tEnter name of your level here <br/>\r\n(name length must be less than 12):\r\n<html>");
		lblEnterNameOf.setBounds(10, 50, 173, 29);
		controlPanel.add(lblEnterNameOf);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 155, 173, 20);
		controlPanel.add(textField_1);
	}

	private void initPalette() {
		PaletteActionHandler paletteHandler = this.new PaletteActionHandler();

		btnRedBrick = new JButton("red");
		btnRedBrick.setBounds(266, 0, 133, 25);
		btnRedBrick.addActionListener(paletteHandler);
		palettePanel.setLayout(null);
		palettePanel.add(btnRedBrick);

		btnBlueBrick = new JButton("blue");
		btnBlueBrick.setBounds(399, 0, 133, 25);
		btnBlueBrick.addActionListener(paletteHandler);
		palettePanel.add(btnBlueBrick);

		btnGreenBrick = new JButton("green");
		btnGreenBrick.setBounds(266, 25, 133, 25);
		btnGreenBrick.addActionListener(paletteHandler);
		palettePanel.add(btnGreenBrick);

		btnYellowBrick = new JButton("yellow");
		btnYellowBrick.setBounds(532, 0, 133, 25);
		btnYellowBrick.addActionListener(paletteHandler);
		palettePanel.add(btnYellowBrick);

		btnLightGreenBrick = new JButton("lightgreen");
		btnLightGreenBrick.setBounds(266, 50, 133, 25);
		btnLightGreenBrick.addActionListener(paletteHandler);
		palettePanel.add(btnLightGreenBrick);

		btnCyanBrick = new JButton("cyan");
		btnCyanBrick.setBounds(399, 25, 133, 25);
		btnCyanBrick.addActionListener(paletteHandler);
		palettePanel.add(btnCyanBrick);

		btnLightCyanBrick = new JButton("lightcyan");
		btnLightCyanBrick.setBounds(399, 50, 133, 25);
		btnLightCyanBrick.addActionListener(paletteHandler);
		palettePanel.add(btnLightCyanBrick);

		btnPinkBrick = new JButton("pink");
		btnPinkBrick.setBounds(133, 25, 133, 25);
		btnPinkBrick.addActionListener(paletteHandler);
		palettePanel.add(btnPinkBrick);

		btnLightPinkBrick = new JButton("lightpink");
		btnLightPinkBrick.setBounds(133, 50, 133, 25);
		btnLightPinkBrick.addActionListener(paletteHandler);
		palettePanel.add(btnLightPinkBrick);

		btnDarkYellowBrick = new JButton("darkyellow");
		btnDarkYellowBrick.setBounds(532, 25, 133, 25);
		btnDarkYellowBrick.addActionListener(paletteHandler);
		palettePanel.add(btnDarkYellowBrick);

		btnVioletBrick = new JButton("violet");
		btnVioletBrick.setBounds(133, 0, 133, 25);
		btnVioletBrick.addActionListener(paletteHandler);
		palettePanel.add(btnVioletBrick);

		btnGoldenBrick = new JButton("golden");
		btnGoldenBrick.setBounds(532, 50, 133, 25);
		btnGoldenBrick.addActionListener(paletteHandler);
		palettePanel.add(btnGoldenBrick);

		btnMetalBrick_1 = new JButton("metal1");
		btnMetalBrick_1.setBounds(665, 0, 135, 25);
		btnMetalBrick_1.addActionListener(paletteHandler);
		palettePanel.add(btnMetalBrick_1);

		btnMetalBrick_2 = new JButton("metal2");
		btnMetalBrick_2.setBounds(665, 25, 135, 25);
		btnMetalBrick_2.addActionListener(paletteHandler);
		palettePanel.add(btnMetalBrick_2);

		btnMetalBrick_3 = new JButton("metal3");
		btnMetalBrick_3.setBounds(665, 50, 135, 25);
		btnMetalBrick_3.addActionListener(paletteHandler);
		palettePanel.add(btnMetalBrick_3);

		btnEraseTool = new JButton("Erase tool");
		btnEraseTool.setBounds(0, 50, 133, 25);
		btnEraseTool.addActionListener(paletteHandler);
		palettePanel.add(btnEraseTool);

		btnExplosingBrick = new JButton("explosing");
		btnExplosingBrick.setBounds(0, 0, 133, 25);
		// btnExplosingBrick.addActionListener(this);
		palettePanel.add(btnExplosingBrick);

		btnInvisibleBrick = new JButton("invisible");
		btnInvisibleBrick.setBounds(0, 25, 133, 25);
		// btnInvisibleBrick.addActionListener(this);
		palettePanel.add(btnInvisibleBrick);
	}

	private void initFrame() {
		frame.setBounds(100, 100, WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(
				EditorWindow.class.getResource("/images/favicon.png")));
		frame.setResizable(false);
	}

	private void setSystemLookAndFeel() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
	}

	private boolean valideName(String s) {
		return s.length() > 0 && s.length() <= 12;
	}

	private class PaletteActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton src = (JButton) e.getSource();
			if (src == btnEraseTool) {
				editor.setBuildMode(false);
				editor.setEraseMode(true);
			} else {
				editor.setCurrentBrick(EntityBuilder.getInstance(src.getText()));
				editor.setBuildMode(true);
				editor.setEraseMode(false);
			}
		}

	}

	private class SettingsActionHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton src = (JButton) e.getSource();
			if (src == saveButton) {
				String s = textField.getText();
				if (valideName(s)) {
					try {
						textField
								.setText(editor.getLevel().saveAs(s) ? "Level "
										+ s + " was succesfully saved"
										: "Saving failed");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			} else if (src == loadButton) {
				String s = textField_1.getText();
				if (valideName(s)) {
					try {
						editor.setLevel((Level.load(s)));
					} catch (IOException e1) {
						textField_1.setText("Cannot load level");
						e1.printStackTrace();
					}
				}
			}
		}

	}
}