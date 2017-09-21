//对话框类
 
//导入系统的类包
import java.awt.*;
import javax.swing.*;
//创建对话框类
public class RankBelt extends JPanel
{
	private static final long serialVersionUID = 1L;
	//创建标签对象
	JLabel jLabel1=new JLabel("Introduction of Rank Belt");
	JLabel jLabel2=new JLabel("Administrators: Min, Mica, Julia");
	JLabel jLabel3=new JLabel("Latest version: 2017-04-03");
	JScrollPane jScrollPane1=new JScrollPane();
	JTextArea jTextArea1=new JTextArea();
	
	//构造方法
	public RankBelt()
		{
			try{
				//调用初始化方法
				jbInit();
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
		}
	//界面初始化方法
	private void jbInit() throws Exception
	{
		//面板的布局
		this.setLayout(null);
		//设置标签组件的大小
		jLabel1.setBounds(new Rectangle(40,10,249,39));
		jLabel1.setFont(new java.awt.Font("Calibri",Font.BOLD,23));
		jLabel2.setBounds(new Rectangle(40,40,200,28));
		jLabel3.setBounds(new Rectangle(40,70,200,27));
		jScrollPane1.setBounds(new Rectangle(40,110,200,250));
		jTextArea1.append("01 - White Belt\n"
					+ "02 - Yellow Belt\n"
					+ "03 - Orange Belt\n"
					+ "04 - Green Belt\n"
					+ "05 - Blue Belt\n"
					+ "06 - Purple Belt\n"
					+ "07 - Brown Belt\n"
					+ "08 - Black Belt");
		jTextArea1.setFont(new java.awt.Font("Lucida Sans",Font.ITALIC,16));

		//添加标签到内容面板
		this.add(jLabel1);
		this.add(jLabel2);
		this.add(jLabel3);
		this.add(jScrollPane1);
		jScrollPane1.getViewport().add(jTextArea1);
		setSize(190,160);
	}
}

