import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonListener;


public class JoinFrame extends JFrame{
	
	JPanel panel = new JPanel();
	
	JLabel idL = new JLabel("���̵�");
	JLabel pwL = new JLabel("��й�ȣ");
	
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();
	
	JButton joinBtn = new JButton("�����ϱ�");
	JButton cancelBtn = new JButton("�������");
	
	Operator o = null;
	
	JoinFrame(Operator _o) {
		o = _o;
		
		setTitle("ȸ������");
		

		idL.setPreferredSize(new Dimension(50, 30));
		pwL.setPreferredSize(new Dimension(50, 30));
		
		id.setPreferredSize(new Dimension(140, 30));
		pw.setPreferredSize(new Dimension(140, 30));
		
		
		joinBtn.setPreferredSize(new Dimension(95, 25));
		cancelBtn.setPreferredSize(new Dimension(95, 25));
		
		setContentPane(panel);
		
		panel.add(idL);
		panel.add(id);
		
		panel.add(pwL);
		panel.add(pw);
		
		panel.add(cancelBtn);
		panel.add(joinBtn);
		
		ButtonListener bl = new ButtonListener();
		
		cancelBtn.addActionListener(bl);
		joinBtn.addActionListener(bl);
		
		
		setSize(250, 150);
		setLocationRelativeTo(null);
		setResizable(false);
	}
	
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			
			String uid = id.getText();
			String upass = "";
			for(int i = 0; i < pw.getPassword().length; i++) {
				upass = upass + pw.getPassword()[i];
			}
			
			if(b.getText().equals("�������")) {
				dispose();
			} else if(b.getText().equals("�����ϱ�")) {
				if(uid.equals("") || upass.equals("")) {
					JOptionPane.showMessageDialog(null, "��� ������ �������ּ���", "ȸ������ ����", JOptionPane.ERROR_MESSAGE);
					System.out.println("ȸ������ ���� > ȸ������ ���Է�");
				} else if(!uid.equals("") && !upass.equals("")) {
					if(o.db.joincheck(uid, upass)) {
						System.out.println("ȸ������ ����");
						JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�.");
						dispose();
					} else {
						System.out.println("ȸ������ ����");
						JOptionPane.showMessageDialog(null, "ȸ�����Կ� �����Ͽ����ϴ�");
						id.setText("");
						pw.setText("");
					}
				}
 			}
		}
	}

	public void setVisiable(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
