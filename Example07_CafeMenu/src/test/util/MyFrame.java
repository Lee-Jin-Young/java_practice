package test.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dao.MenuDao;
import test.dto.MemberDto;
import test.dto.MenuDto;

public class MyFrame extends JFrame implements ActionListener {
	JTextField inputName = null;
	JTextField inputIce = null;
	JTextField inputPrice = null;
	DefaultTableModel model = null;
	JTable table = null;

	public MyFrame(String title) {
		super(title);

		setLayout(new BorderLayout());

		JLabel label1 = new JLabel("메뉴명");
		inputName = new JTextField(10);
		JLabel label2 = new JLabel("Ice|Hot");
		inputIce = new JTextField(10);
		JLabel label3 = new JLabel("가격");
		inputPrice = new JTextField(10);

		JButton addBtn = new JButton("저장");
		addBtn.setActionCommand("add");
		addBtn.addActionListener(this);
		JButton fixBtn = new JButton("수정");
		fixBtn.setActionCommand("fix");
		fixBtn.addActionListener(this);
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		JButton searchBtn = new JButton("검색");
		searchBtn.setActionCommand("search");
		searchBtn.addActionListener(this);

		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputIce);
		panel.add(label3);
		panel.add(inputPrice);
		panel.add(addBtn);
		panel.add(fixBtn);
		panel.add(deleteBtn);
		panel.add(searchBtn);

		add(panel, BorderLayout.NORTH);

		panel.setBackground(Color.yellow);

		table = new JTable();

		String[] colNames = { "메뉴", "Hot/Ice", "가격" };
		// 테이블에 연결할 모델객체
		model = new DefaultTableModel(colNames, 0);
		table.setModel(model);
		JScrollPane scroll = new JScrollPane(table);
		add(scroll, BorderLayout.CENTER);

		// DB에 있는 데이터를 추가
		List<MenuDto> list = new MenuDao().getList();
		for (MenuDto dto : list) {
			Object[] row = { dto.getName(), dto.getIce(), dto.getPrice() };
			model.addRow(row);
		}

		displayMember();

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		Boolean isSuccess = null;

		switch (cmd) {
		case "add":
			String name = inputName.getText();
			String ice = inputIce.getText();
			int price = Integer.parseInt(inputPrice.getText());

			MenuDto dto = new MenuDto();
			dto.setName(name);
			dto.setIce(ice);
			dto.setPrice(price);

			isSuccess = new MenuDao().insert(dto);

			if (isSuccess) {
				JOptionPane.showMessageDialog(this, "저장되었습니다.");
				displayMember();
			}

			return;
		case "fix":
			return;
		case "delete":
			int selectedRow = table.getSelectedRow();
			if (selectedRow == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 행을 선택하세요.");
				return;
			}
			name = (String) model.getValueAt(selectedRow, 0);
			new MenuDao().delete(name);

			isSuccess = new MenuDao().delete(name);

			if (isSuccess) {
				JOptionPane.showMessageDialog(this, "삭제되었습니다.");
				displayMember();
			}

			return;
		case "search":
			String where = "";
			if (inputName != null) {
				where = "name=" + inputName;
				new MenuDao().getData(where);
				
			} else {
				JOptionPane.showMessageDialog(this, "검색할 메뉴를 입력하세요.");
				return;
			}
			return;
		}

	}

	public void displayMember() {
		model.setRowCount(0);
		List<MenuDto> list = new MenuDao().getList();

		for (MenuDto tmp : list) {
			Object[] row = { tmp.getName(), tmp.getIce(), tmp.getPrice() };
			model.addRow(row);
		} // for
	}
}
