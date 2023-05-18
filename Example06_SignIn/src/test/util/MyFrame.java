package test.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MyFrame extends JFrame {
	public MyFrame(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("이름");
		JTextField inputName = new JTextField(10);
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		
		add(panel,BorderLayout.NORTH);
		
		panel.setBackground(Color.yellow);
		
		JTable table = new JTable();
		
		String[] colNames = {"번호", "이름", "주소"};
		//테이블에 연결할 모델객체
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);
		
		//DB에 있는 데이터를 추가
		List<MemberDto> list = new MemberDao().getList();
		for(MemberDto dto : list) {
			Object[] row = {dto.getNum(), dto.getName(), dto.getAddr()};
			model.addRow(row);
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setVisible(true);
	}
}
