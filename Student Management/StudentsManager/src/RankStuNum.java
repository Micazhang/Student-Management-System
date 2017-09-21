
//按学号查询学生面板类
//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“根据等级查询学生人数”类面板
public class RankStuNum extends JPanel implements ActionListener
{
	private static final long serialVersionUID = 1L;
	Connection conn;
	Statement st;
	
	JLabel jLabel1=new JLabel("Please Input Rank ID: (See Rank Details from Rank info)");
	JTextField RankID1=new JTextField();
	JLabel RankID2=new JLabel("e.g.:01");
	JButton jButton1=new JButton("Search");
	JTextArea jTextArea1=new JTextArea();
	//构造方法
	public RankStuNum()
	{
		try{
			//调用初始化方法
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	//面板初始化方法
	private void jbInit() throws Exception
	{
		//连接数据库
		conn=DBConnect.getConn();
		st=conn.createStatement();
		//框架的布局
		this.setLayout(null);
		//设置各组件的大小
		jLabel1.setFont(new java.awt.Font("Calibri",Font.BOLD,16));
		jLabel1.setBounds(new Rectangle(46,4,400,32));
		RankID1.setBounds(new Rectangle(47,37,100,31));
		RankID2.setBounds(new Rectangle(160,37,180,30));
		jButton1.setBounds(new Rectangle(47,86,247,30));
	    jTextArea1.setBounds(new Rectangle(47,130,300,50));
		jTextArea1.setFont(new java.awt.Font("Calibri",Font.BOLD,15));
		//添加按钮动作事件
		jButton1.addActionListener(this);
		//添加组件到面板
		this.add(jTextArea1);
		this.add(jLabel1);
		this.add(RankID1);
		this.add(RankID2);
		this.add(jButton1);
	}
	//点击按钮事件
	public void actionPerformed(ActionEvent e)
	{
		
		String rankid=RankID1.getText();
	
		jTextArea1.setText("");
		try{
			ResultSet rs=st.executeQuery("select count(distinct Stu_Num) from attain where Rank_Num='"+rankid+"'");

			if(rs.next()){
				jTextArea1.append("Total Number of Students in This Rank:  \n"+rs.getString("count(distinct Stu_Num)"));

				
				RankID1.setText("");
			}
			else
				JOptionPane.showMessageDialog(this,"The Rank ID does not EXIST!");
			}
		catch(Exception ex){

			JOptionPane.showMessageDialog(this,"Search Error!");
			}
	}
}

