//添加学生面板类
//导入系统的类包
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
//创建“添加学生面板”类，并继承Jpanel类，和动作监听器借口
public class AddStudents extends JPanel implements ActionListener 
{
	//声明一个静态变量长整型的变量serialVersionUID，此处不知什么用，但是没有这个,程序会有警告。不写下面这行，也不影响程序运行。
	private static final long serialVersionUID = 1L;
	//声明一个连接数据库的对象
	Connection conn;
	//创建一个声明，用来执行SQL语句
	Statement statement;
	/*
	 * 以下是创建组件对象：标签、文本行、单选、按钮的细节
	 */
	//创建一个标签对象stuNo用来显示学号
	JLabel stuNo=new JLabel("Student ID:");
	//创建一个文本输入框对象stuNo2用来输入学号字符串
	JTextField stuNo2=new JTextField();
	//创建一个标签对象noFormat用来显示，注意学号的格式
	JLabel noFormat=new JLabel("e.g.:20170401");
	
	JLabel stuFName=new JLabel("Student First Name:");
	JTextField stuFName2=new JTextField();
	
	JLabel stuLName=new JLabel("Student Last Name:");
	JTextField stuLName2=new JTextField();


	JLabel stuBirthDate=new JLabel("Date of Birth:");
	JTextField stuBirthDate2=new JTextField();
	JLabel BirthDateFormat=new JLabel("(DOB format:1990-02-15)");

	JLabel stuJoinDate=new JLabel("Date of Join the club:");
	JTextField stuJoinDate2=new JTextField();
	
	JLabel stuPhoNum=new JLabel("Phone Number:");
	JTextField stuPhoNum2=new JTextField();
	
	JLabel stuEmail=new JLabel("Email:");
	JTextField stuEmail2=new JTextField();
	
	JLabel stuAddress=new JLabel("Student Address:");
	JTextField stuAddress2=new JTextField();
	
	JLabel prtName=new JLabel("Parent Name:");
	JTextField prtName2=new JTextField();
	
	JLabel stuRel=new JLabel("Relationship:");
	JTextField stuRel2=new JTextField();
			
	JLabel prtPhoNum=new JLabel("Parent Phone Number:");
	JTextField prtPhoNum2=new JTextField();
	
	JLabel prtEmail=new JLabel("Parent Email:");
	JTextField prtEmail2=new JTextField();
	//创建一个按钮对象addStu用来添加学生信息到数据库
	JButton addStu=new JButton("Add the Student");
	//添加学生面板类的构造方法
	public AddStudents()
	{
		try{
			//调用添加学生的初始化函数
			jbInit();
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
	}
	
	//添加学生图形界面的初始化函数，初始化各变量，组件。
	private void jbInit() throws Exception
	{
		//调用DBConnect.java内的getConn方法,初始化conn对象，来连接数据库
		conn=DBConnect.getConn();
		//连接数据库后，初始化statement对象，来将 SQL语句发送到数据库。
		statement=conn.createStatement();
		/*
		 * 先把当前窗体容器this，的布局管理器置空，再添加新的组件到当前窗体容器中。
		 * setLayout,数以java.awt.*中的接口，详情件JAVA_API_1.6.CHM文件。
		 */
		this.setLayout(null);
		/*
		 * 设置各组件的大小和在当前窗体中的位置
		 */
		//标签：学号的大小和位置。
		//setBounds(new Rectangle(x,y,w,h)),移动组件并调整其大小。由 x 和 y 指定左上角的新位置，由 w和 h指定新的大小,使其符合新的有界矩形 。
		stuNo.setBounds(new Rectangle(21,13,85,25));
		//文本输入框：学号，的大小和位置
		stuNo2.setBounds(new Rectangle(95,13,100,25));
		//标签：学号格式，的大小和位置
		noFormat.setBounds(new Rectangle(205,13,100,25));
		//标签：姓名，的大小和位置
		
		stuFName.setBounds(new Rectangle(21,46,135,25));
		stuFName2.setBounds(new Rectangle(145,46,100,25));
		
		stuLName.setBounds(new Rectangle(21,79,135,25));
		stuLName2.setBounds(new Rectangle(145,79,100,25));
		
		stuBirthDate.setBounds(new Rectangle(21,112,110,25));
		stuBirthDate2.setBounds(new Rectangle(110,112,120,25));
		BirthDateFormat.setBounds(new Rectangle(240,112,180,25));
	    
		stuJoinDate.setBounds(new Rectangle(21,145,120,25));
		stuJoinDate2.setBounds(new Rectangle(150,145,130,25));
		
		stuPhoNum.setBounds(new Rectangle(21,178,115,25));
		stuPhoNum2.setBounds(new Rectangle(120,178,95,25));
		
		stuEmail.setBounds(new Rectangle(230,178,55,25));
		stuEmail2.setBounds(new Rectangle(270,178,180,25));
		
		prtPhoNum.setBounds(new Rectangle(21,211,130,25));
		prtPhoNum2.setBounds(new Rectangle(160,211,110,25));
		
		stuAddress.setBounds(new Rectangle(21,277,105,25));
		stuAddress2.setBounds(new Rectangle(130,277,350,25));
		
		prtName.setBounds(new Rectangle(260,46,135,25));
		prtName2.setBounds(new Rectangle(350,46,130,25));
		
		stuRel.setBounds(new Rectangle(260,79,135,25));
		stuRel2.setBounds(new Rectangle(350,79,100,25));
		
		prtEmail.setBounds(new Rectangle(21,244,75,25));
		prtEmail2.setBounds(new Rectangle(100,244,180,25));
		
	
		//按钮：添加学生，的大小和位置
		addStu.setBounds(new Rectangle(145,343,180,30));
		/** 
		 * 对“添加学生”按钮，添加动作事件监听器，监听当前窗体。
		 * 当按下“添加学生”按钮，会自动调用actionPerformed(ActionEvent e)方法
		 * */
		addStu.addActionListener(this);
		/*
		 * 把上面初始化完成的各类组件都添加到当前窗体容器内。
		 */
		//添加标签，学号
		this.add(stuNo);
		//添加文本输入框，学号
		this.add(stuNo2);
		//添加标签，学号格式
		this.add(noFormat);
		//添加标签，姓名
		this.add(stuFName);
		this.add(stuFName2);
		this.add(stuLName);
		this.add(stuLName2);
		this.add(stuBirthDate);
		this.add(stuBirthDate2);
		this.add(BirthDateFormat);
		this.add(stuJoinDate);
		this.add(stuJoinDate2);
		this.add(stuPhoNum);
		this.add(stuPhoNum2);
		this.add(stuEmail);
		this.add(stuEmail2);
		this.add(stuAddress);
		this.add(stuAddress2);
		this.add(prtName);
		this.add(prtName2);
		this.add(stuRel);
		this.add(stuRel2);
		this.add(prtPhoNum);
		this.add(prtPhoNum2);
		this.add(prtEmail);
		this.add(prtEmail2);
		//添加按钮，添加学生
		this.add(addStu);
	}
	
	
	//点击按钮添加学生，有个监听器事件监听该动作
	public void actionPerformed(ActionEvent e)
	{
		//变量ID用来搜集学号信息
		String ID=stuNo2.getText();
		String LName=stuLName2.getText();
		String FName=stuFName2.getText();
		String BirthDate=stuBirthDate2.getText();
		String JoinDate=stuJoinDate2.getText();
		String PhoNum=stuPhoNum2.getText();
		String Email=stuEmail2.getText();
		String Address=stuAddress2.getText();
		String pName=prtName2.getText();
		String sRel=stuRel2.getText();
		String pPhoNum=prtPhoNum2.getText();
		String pEmail=prtEmail2.getText();
		
		//学号已经存在的不允许插入！返回并提醒错误：该学号已经存在。
		try{
			ResultSet rs=statement.executeQuery("select * from student where Stu_Num='"+ID+"'");
			if(rs.next()){
				JOptionPane.showMessageDialog(this,"The Student ID has existed already, Please Input Again！");
				return;
				}
			}catch(Exception ex){
					//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
				ex.printStackTrace();
			}
		//调用CheckDateFormat.java中的CheckDateFormat类,创建一个对象
		//该对象调用checkDateFormat()方法检查输入的日期是否合法。
		CheckDateFormat cdf=new CheckDateFormat();
		//加一个输入检查，姓名为非空，且学号是10位数，且出生日期格式正确，否则重新输入
		if(!((ID.length())==8 && (FName.length())>0 && (LName.length())>0 &&
				cdf.checkDateFormat(BirthDate) && cdf.checkDateFormat(JoinDate))){
			JOptionPane.showMessageDialog(this,"Please follow the right FORMAT!");
			return;
		}
		
		//异常处理
		try{
			//利用statement对象，执行SQL语句，进行插入操作
			statement.executeUpdate("insert into student values('"+ID+"','"+FName+"','"+LName+"','"
					+BirthDate+"','"+JoinDate+"','"+PhoNum+"','"+Email+"','"+Address+"','"+pName+"','"+sRel+"','"+pPhoNum+"','"+pEmail+"')");
			//利用消息对话框提示插入操作成功
			//JOptionPane 有助于方便地弹出要求用户提供值或向其发出通知的标准对话框。
			JOptionPane.showMessageDialog(this,"Add the student successfully！");
			//清空文本输入框：学号、姓名、出生日期、籍贯的内容
			stuNo2.setText("");
			stuLName2.setText("");
			stuFName2.setText("");
			stuBirthDate2.setText("");
			stuJoinDate2.setText("");
			stuPhoNum2.setText("");
			stuEmail2.setText("");
			stuAddress2.setText("");
			prtName2.setText("");
			stuRel2.setText("");
			prtPhoNum2.setText("");
			prtEmail2.setText("");
		}catch(Exception ex){
			//如果捕获到异常，利用消息对话框提示不能插入，并显示异常的信息
			JOptionPane.showMessageDialog(this,"The format of data error, Please Check and Type Again！");
			ex.printStackTrace();
		}
	}
}
