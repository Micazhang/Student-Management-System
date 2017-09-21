import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class InquireOnStuID extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;

	Connection conn;
	Statement st;
	JLabel jLabel1=new JLabel("Please Input Student ID:");
	JTextField xueHAO=new JTextField();
	JLabel xueHAO2=new JLabel("e.g. 20170401");
	JButton jButton1=new JButton("Search");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();

	public InquireOnStuID()
	{
		try{
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}

	private void jbInit() throws Exception
	{
		conn=DBConnect.getConn();
		st=conn.createStatement();
		this.setLayout(null);
		jLabel1.setFont(new java.awt.Font("Calibri",Font.BOLD,16));
		jLabel1.setBounds(new Rectangle(46,4,222,32));
		xueHAO.setBounds(new Rectangle(47,37,100,31));
		xueHAO2.setBounds(new Rectangle(160,37,180,30));
		jButton1.setBounds(new Rectangle(47,86,247,30));
		jScrollPane1.setBounds(new Rectangle(24,130,400,200));
		jButton1.addActionListener(this);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		this.add(jLabel1);
		this.add(xueHAO);
		this.add(xueHAO2);
		this.add(jButton1);
	}

	public void actionPerformed(ActionEvent e)
	{
		String xuehao=xueHAO.getText();
		jTextArea1.setText("");
		try{
			ResultSet rs=st.executeQuery("select * from student where Stu_Num='"+xuehao+"'");
			if(rs.next()){
				jTextArea1.append("ID: "+rs.getString("Stu_Num")+
						"\nFirst Name: "+rs.getString("Stu_FName")+
						"\nLast Name: "+rs.getString("Stu_LName")+
						"\nDate of Birth: "+rs.getDate("Stu_DOB")+
						"\nDate of Join: "+rs.getDate("Stu_Join_Date")+
						"\nStudent Phone Number: "+rs.getString("Stu_Pho_Num")+
						"\nStudent Email: "+rs.getString("Stu_Email")+
						"\nStudent Address: "+rs.getString("Stu_Add")+
						"\nParent Name: "+rs.getString("Prt_Name")+
						"\nRelationship with students: "+rs.getString("Stu_Rel")+
						"\nParent Phone Number: "+rs.getString("Prt_Pho_Num")+
						"\nParent Email: "+rs.getString("Prt_Email"));
				
				xueHAO.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"The Student ID does not EXIST!");
			}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this,"Search Error!");
			}
	}
}

