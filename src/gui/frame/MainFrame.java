package gui.frame;
 
import gui.panel.MainPanel;
import util.GUIUtil;
import util.reSizeEvent;

import javax.swing.JFrame; 

/**
 * 程序主窗体 设置了程序窗体的长宽标题和退出操作等
 */

public class MainFrame extends JFrame {
	static {
		GUIUtil.useLNF();
	}

	public static MainFrame instance = new MainFrame();

	private MainFrame() {
		this.setSize(750, 550);
		this.setTitle("记录本");
		this.setContentPane(MainPanel.instance);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		reSizeEvent dg = new reSizeEvent(this); 
		  /**添加两个监听器**/
		this.addMouseListener(dg); 
		this.addMouseMotionListener(dg); 
	}

	public static void main(String[] args) {
		instance.setVisible(true);
	}
}
