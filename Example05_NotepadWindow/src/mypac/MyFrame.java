package mypac;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame extends JFrame {
	File openedFile;
	JTextArea ta;
	
	public MyFrame(String title) {
		super(title);
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// menuBar
		JMenuBar mb = new JMenuBar();

		JMenu menu = new JMenu("File");

		JMenuItem newItem = new JMenuItem("New");
		JMenuItem openItem = new JMenuItem("Open");
		JMenuItem saveItem = new JMenuItem("Save");
		JMenuItem saveAsItem = new JMenuItem("Save As");

		menu.add(newItem);
		menu.add(openItem);
		menu.add(saveItem);
		menu.add(saveAsItem);
		mb.add(menu);
		setJMenuBar(mb);
		// menuBar

		JPanel p1 = new JPanel();

		JTextField inputText = new JTextField(20);
		JButton saveBtn = new JButton("저장");

		p1.add(inputText);
		p1.add(saveBtn);

		ta = new JTextArea();
		add(ta, BorderLayout.CENTER);

		// 열기메뉴
		openItem.addActionListener((e2) -> {
			JFileChooser fc = new JFileChooser();
			if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
				openedFile = fc.getSelectedFile();
				
				String path = openedFile.getAbsolutePath();
				setTitle(path);
				
				FileReader fr = null;
				BufferedReader br = null;
				
				try {
					fr = new FileReader(openedFile);
					br = new BufferedReader(fr);
					while (true) {
						String line = br.readLine();
						if (line == null)
							break;
						ta.append(line); 
						ta.append("\r\n"); 
					}

				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (br != null)
							br.close();
						if (fr != null)
							fr.close();
					} catch (Exception e) {
					}
				}
			}

		});
		
		saveItem.addActionListener((e2)->{
			if(openedFile == null) {
				JOptionPane.showMessageDialog(this,"파일을 먼저 열어주세요.");
				return;
			}
			saveToFile();
		});
		
		saveAsItem.addActionListener((e2)->{
			JFileChooser fc = new JFileChooser("C:/Users/acorn/acorn202304/myFolder");
			int result = fc.showSaveDialog(this);
			if(result == JFileChooser.APPROVE_OPTION) {
				openedFile = fc.getSelectedFile();
				setTitle(openedFile.getAbsolutePath());
				
				try {
					openedFile.createNewFile();
				} catch(IOException e) {
					e.printStackTrace();
				}
				
				saveToFile() ;
			}
		});

		setVisible(true);

	}
	
	//저장메뉴
	public void saveToFile() {
		String content = ta.getText();
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(openedFile);
			bw = new BufferedWriter(fw);
			bw.write(content);
			bw.flush();
			JOptionPane.showMessageDialog(this, "저장 완료");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw!=null) bw.close();
				if(fw!=null) fw.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MyFrame("frame02");
	}
}