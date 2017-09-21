import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class ClassStu extends JPanel implements ActionListener{
	private static final long serialVersionUID = 1L;
	
	Connection conn;
	Statement st;
	JLabel jLabel1=new JLabel("Current Students ");
	JLabel jLabel2=new JLabel("(Click Search to See all Students in this Club)");
    JButton jButton1=new JButton("Search");
    JScrollPane jScrollPane1=new JScrollPane();
    JTextArea jTextArea1=new JTextArea();

    public ClassStu()
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
        jLabel1.setFont(new java.awt.Font("Calibri",Font.BOLD,20));
    	jLabel1.setBounds(new Rectangle(170,10,180,32));
        jLabel2.setFont(new java.awt.Font("Calibri",Font.ITALIC,16));
    	jLabel2.setBounds(new Rectangle(95,40,330,32));
    	jButton1.setBounds(new Rectangle(180,86,120,30));
    	jScrollPane1.setBounds(new Rectangle(90,130,305,180));
    	jButton1.addActionListener(this);
    	this.add(jScrollPane1);
    	jScrollPane1.getViewport().add(jTextArea1);
    	this.add(jLabel1);
    	this.add(jLabel2);
    	this.add(jButton1);
    }
    
    public void actionPerformed(ActionEvent e)
    {
    	jTextArea1.setText("");
    	try{
    		ResultSet rs=st.executeQuery("select * from student");
    		while(rs.next()){
    			jTextArea1.append("\n----------------\n"
    					+ "Student ID:"+rs.getString("Stu_Num")+
    					"\nFirst Name:"+rs.getString("Stu_FName")+
    					"\nLast Name:"+rs.getString("Stu_LName"));
    		}
    	
    		//JOptionPane.showMessageDialog(this,"没有这个系号！");
    	}
        catch(Exception ex){
        	JOptionPane.showMessageDialog(this,"Search Error！");
        }
    }
}
