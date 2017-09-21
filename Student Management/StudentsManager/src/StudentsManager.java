import java.awt.*;

public class StudentsManager {
	public static void main(String[] args) {
		MainInterface frame=new MainInterface();
		Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize =frame.getSize();
		if(frameSize.height>screenSize.height)
			frameSize.height=screenSize.height;
		if(frameSize.width>screenSize.width)
			frameSize.width=screenSize.width;
		frame.setLocation((screenSize.width-frameSize.width)/2,(screenSize.height-frameSize.height)/2);
		frame.setVisible(true);
	}
}