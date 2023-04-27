import java.sql.*;

public class Database {
	Connection con = null;
	Statement stmt = null;
	String url = "jdbc:mysql://localhost/dbstudy?serverTimezone=Asia/Seoul";	//dbstudy ��Ű��
	String user = "root";
	String passwd = "1234";		
	
	Database() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, passwd);
			stmt = con.createStatement();
			System.out.println("MySQL ���� ���� ����");
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("MySQL ���� ���� ���� > " + e.toString());
		}
	}

	/* �α��� ������ Ȯ�� */
	boolean logincheck(String _i, String _p) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		
		try {
			String checkingStr = "SELECT password FROM member WHERE id='" + id + "'";
			ResultSet result = stmt.executeQuery(checkingStr);
			
			int count = 0;
			while(result.next()) {
				if(pw.equals(result.getString("password"))) {
					flag = true;
					System.out.println("�α��� ����");
				}
				
				else {
					flag = false;
					System.out.println("�α��� ����");
				}
				count++;
			}
		} catch(Exception e) {
			
			flag = false;
			System.out.println("�α��� ���� > " + e.toString());
		}
		
		return flag;
	}
	
	boolean joincheck(String _i, String _p) {
		boolean flag = false;
		
		String id = _i;
		String pw = _p;
		
		try {
			String insertStr = "INSERT INTO member VALUES('" + id + "', '" + pw + "')";
			stmt.executeUpdate(insertStr);
			
			flag = true;
			System.out.println("ȸ������ ����");
		} catch (Exception e) {
			e.printStackTrace();
			flag = false;
			System.out.println("ȸ������ ���� > " + e.toString());
		}
		
		return flag;
	}
}