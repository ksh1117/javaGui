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
	
	JLabel idL = new JLabel("아이디");
	JLabel pwL = new JLabel("비밀번호");
	
	JTextField id = new JTextField();
	JPasswordField pw = new JPasswordField();
	
	JButton joinBtn = new JButton("가입하기");
	JButton cancelBtn = new JButton("가입취소");
	
	Operator o = null;
	
	JoinFrame(Operator _o) {
		o = _o;
		
		setTitle("회원가입");
		

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
			
			if(b.getText().equals("가입취소")) {
				dispose();
			} else if(b.getText().equals("가입하기")) {
				if(uid.equals("") || upass.equals("")) {
					JOptionPane.showMessageDialog(null, "모든 정보를 기입해주세요", "회원가입 실패", JOptionPane.ERROR_MESSAGE);
					System.out.println("회원가입 실패 > 회원정보 미입력");
				} else if(!uid.equals("") && !upass.equals("")) {
					if(o.db.joincheck(uid, upass)) {
						System.out.println("회원가입 성공");
						JOptionPane.showMessageDialog(null, "회원가입에 성공하였씁니다.");
						dispose();
					} else {
						System.out.println("회원가입 실패");
						JOptionPane.showMessageDialog(null, "회원가입에 실패하였습니다");
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
