import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class RankYearStu extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;

	Connection conn;
	Statement st;

	JLabel jLabel1=new JLabel("Please Input Joined Year:");
	JTextField joinYear=new JTextField();	
	JLabel jLabel2=new JLabel("Please Input Rank Belt Color:");
	JTextField rankbelt=new JTextField();
	JButton jButton1=new JButton("Search");
	JTextArea jTextArea1=new JTextArea();

	public RankYearStu()
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
		jLabel1.setBounds(new Rectangle(46,10,180,30));
		joinYear.setBounds(new Rectangle(250,10,70,30));		
		jLabel2.setFont(new java.awt.Font("Calibri",Font.BOLD,16));
		jLabel2.setBounds(new Rectangle(46,50,210,30));
		rankbelt.setBounds(new Rectangle(270,50,100,30));	
		jButton1.setBounds(new Rectangle(47,86,120,30));
		jTextArea1.setBounds(new Rectangle(46,130,300,100));
		jButton1.addActionListener(this);
	
		this.add(jTextArea1);
		this.add(jLabel1);
		this.add(jLabel2);
		this.add(joinYear);
		this.add(rankbelt);
		this.add(jButton1);
	}

	public void actionPerformed(ActionEvent e)
	{

		String year=joinYear.getText();
		String belt=rankbelt.getText();
		jTextArea1.setText("");
		try{
			ResultSet rs=st.executeQuery("select s.Stu_Num, s.Stu_FName,s.Stu_LName from attain a,rank r,student s where year(s.Stu_Join_Date)='"+year+"' and r.Rank_Belt='"+belt+"' and a.Rank_Num=r.Rank_Num and s.Stu_Num=a.Stu_Num");
			if(rs.next()){
				jTextArea1.append("ID: "+rs.getString("s.Stu_Num")+
						"\nFirst Name: "+rs.getString("s.Stu_FName")+
						"\nLast Name: "+rs.getString("s.Stu_LName"));
				joinYear.setText("");
				rankbelt.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"There is no student who meets those requirements!");
			}
		catch(Exception ex){
			JOptionPane.showMessageDialog(this,"Search Error!");
			}
	}
}

