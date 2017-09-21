import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class DelStudents extends JPanel implements ActionListener{
    private static final long serialVersionUID = 1L;
	
	Connection conn;
	Statement st;
	JLabel jLabel1=new JLabel("Please input Student ID:");
	JLabel jLabel2=new JLabel("(e.g. 20170401)");
    JTextField jTextField1=new JTextField();
    JButton jButton1=new JButton("Delete");
    JButton jButton2=new JButton("Confirm");
    JScrollPane jScrollPane1=new JScrollPane();
    JTextArea jTextArea1=new JTextArea();
    
    public DelStudents()
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
    	jLabel1.setBounds(new Rectangle(40,10,220,30));
    	jTextField1.setBounds(new Rectangle(260,10,80,25));
    	jLabel2.setBounds(new Rectangle(230,30,140,30));
    	jButton1.setBounds(new Rectangle(120,60,150,30));
    	jButton2.setBounds(new Rectangle(100,310,170,30));
    	jScrollPane1.setBounds(new Rectangle(80,60,300,230));
    	jButton1.addActionListener(this);
    	jButton2.addActionListener(this);
    	this.add(jLabel1);
    	this.add(jTextField1);
    	this.add(jLabel2);
    	this.add(jButton1);
    	this.add(jButton2);
    	jButton2.setVisible(false);
    	this.add(jScrollPane1);
    	jScrollPane1.getViewport().add(jTextArea1);
    	jScrollPane1.setVisible(false);
    }
    
    public void actionPerformed(ActionEvent e){
    	String xuehao=jTextField1.getText();
    	try{
    		ResultSet rs1=st.executeQuery("select * from student where Stu_Num='"+xuehao+"'");
    		if(!(rs1.next())){
    			JOptionPane.showMessageDialog(this,"The Student ID does not EXIST，Please Try Again！");
    			return;
    		}
    	 }catch(Exception ex){
          	ex.printStackTrace();
          }
    	if(e.getSource()==jButton1){
    		jButton1.setVisible(false);
    		jScrollPane1.setVisible(true);
    		jButton2.setVisible(true);
    		try{
    			ResultSet rs2=st.executeQuery("select * from student where Stu_Num='"+xuehao+"'");
        		if(rs2.next()){
        			jTextArea1.append("ID: "+rs2.getString("Stu_Num")+
    						"\nFirst Name: "+rs2.getString("Stu_FName")+
    						"\nLast Name: "+rs2.getString("Stu_LName")+
    						"\nDate of Birth: "+rs2.getDate("Stu_DOB")+
    						"\nDate of Join: "+rs2.getDate("Stu_Join_Date")+
    						"\nStudent Phone Number: "+rs2.getString("Stu_Pho_Num")+
    						"\nStudent Email: "+rs2.getString("Stu_Email")+
    						"\nStudent Address: "+rs2.getString("Stu_Add")+
    						"\nParent Name: "+rs2.getString("Prt_Name")+
    						"\nRelationship with students: "+rs2.getString("Stu_Rel")+
    						"\nParent Phone Number: "+rs2.getString("Prt_Pho_Num")+
    						"\nParent Email: "+rs2.getString("Prt_Email"));        		
        		}else
        			JOptionPane.showMessageDialog(this,"The Student ID does not EXIST！");
    		}catch(Exception ex){
    			JOptionPane.showMessageDialog(this,"Search Error！");
            }
    		return;
    	}
    	else{
    		try{
    			st.executeUpdate("delete from student where Stu_Num='"+xuehao+"'");
    			JOptionPane.showMessageDialog(this,"Delete success！");
    			jTextField1.setText("");
    			jTextArea1.setText("");
    			jScrollPane1.setVisible(false);
    			jButton2.setVisible(false);
    			jButton1.setVisible(true);			
    		}catch(Exception ex){
    			JOptionPane.showMessageDialog(this,"Delete fail！");
            }
    	}
    }
}

