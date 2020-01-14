package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

/**
 * 界面类 ReportPanel 月度报告页
 */

public class ReportPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static ReportPanel instance = new ReportPanel();

    public JLabel l = new JLabel();


    public ReportPanel() {
        this.add(l);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(ReportPanel.instance);
    }

    @Override
    public void updateData(Date date) {
        Image i = ChartUtil.getImage(new ReportService().listThisMonthRecords(), 400, 260);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }

    @Override
    public void addListener() {

    }
}