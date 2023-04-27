import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MainFrame extends JFrame{
	
	JPanel basePanel = new JPanel(new BorderLayout());
	JPanel centerPanel = new JPanel(new BorderLayout());
	JPanel westPanel = new JPanel();
	JPanel eastPanel = new JPanel();
	JPanel southPanel = new JPanel();
	
	
	JLabel idL = new JLabel("���̵�");
	JLabel pwL = new JLabel("��й�ȣ");
	
	JTextField id = new JTextField();
	JTextField pw = new JPasswordField();
	
	JButton loginBtn = new JButton("�α���");
	JButton joinBtn = new JButton("ȸ������");
	JButton exitBtn = new JButton("���α׷� ����");
	
	Operator o = null;
	
	
	public MainFrame(Operator _o) {
		
		o = _o;
		
		setTitle("�α���");
		
		centerPanel.setPreferredSize(new Dimension(260, 80));
		westPanel.setPreferredSize(new Dimension(210, 75));
		eastPanel.setPreferredSize(new Dimension(90, 75));
		southPanel.setPreferredSize(new Dimension(290, 40));
		
		idL.setPreferredSize(new Dimension(50, 30));
		pwL.setPreferredSize(new Dimension(50, 30));
		
		id.setPreferredSize(new Dimension(140, 30));
		pw.setPreferredSize(new Dimension(140, 30));
		
		loginBtn.setPreferredSize(new Dimension(75, 63));
		joinBtn.setPreferredSize(new Dimension(135, 25));
		exitBtn.setPreferredSize(new Dimension(135, 25));
		
		setContentPane(basePanel);
		
		basePanel.add(centerPanel, BorderLayout.CENTER);
		basePanel.add(southPanel, BorderLayout.SOUTH);
		centerPanel.add(westPanel, BorderLayout.WEST);
		centerPanel.add(eastPanel, BorderLayout.EAST);
		
		westPanel.setLayout(new FlowLayout());
		eastPanel.setLayout(new FlowLayout());
		southPanel.setLayout(new FlowLayout());
		
		westPanel.add(idL);
		westPanel.add(id);
		westPanel.add(pwL);
		westPanel.add(pw);
		
		eastPanel.add(loginBtn);
		
		southPanel.add(exitBtn);
		southPanel.add(joinBtn);
		
		ButtonListener bl = new ButtonListener();
		
		loginBtn.addActionListener(bl);
		exitBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		
		setSize(310, 150);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			String uid = id.getText();
			String upass = "";
			for(int i=0; i<((JPasswordField) pw).getPassword().length; i++) {
				upass = upass + ((JPasswordField) pw).getPassword()[i];
			}

			if(b.getText().equals("���α׷� ����")) {
				System.out.println("���α׷� ����");
				System.exit(0);
			} else if(b.getText().equals("ȸ������")) {
				o.jf.setVisible(true);
				
			} else if(b.getText().equals("�α���")) {
				if(uid.equals("") || upass.equals("")) {
					JOptionPane.showMessageDialog(null, "���̵�� ��й�ȣ ��� �Է����ּ���", "�α��� ����", JOptionPane.ERROR_MESSAGE);
					System.out.println("�α��� ���� > �α��� ���� ���Է�");
				} else if(uid != null && upass != null) {
					if(o.db.logincheck(uid, upass)) {
						System.out.println("�α��� ����");
						JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�");
					} else {
						System.out.println("�α��� ���� > �α��� ���� ����ġ");
						JOptionPane.showMessageDialog(null, "�α��ο� �����Ͽ����ϴ�");
					}
				}
			}
		}
	}

}
