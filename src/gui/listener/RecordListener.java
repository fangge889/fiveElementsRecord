package gui.listener;
 
import gui.panel.*;
import service.RecordService;
import util.ColorUtil;
import util.DBUtil;
import util.GUIUtil;

import javax.swing.*;

import entity.Record;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

/**
 * RecordPanel 的监听器，按钮后会 增改Record
 * 增改由 RecordPanel.instance.updateId 决定 ，默认为 -1 ，可能被 HistoryListPanel 修改
 *
 * @author xenv
 * @see RecordPanel
 * @see HistoryListPanel
 * @see HistoryListListener
 */

public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel p = RecordPanel.instance;
        Date d = p.datepick.getDate();
        
        List<Record> recordList = new RecordService().listDay(d);
        
        JButton b = (JButton) e.getSource();
        
        p = DBUtil.dataPanel(p,b,recordList);
        
		if (p.bSubmit == b) {
	        String comment1 = p.tfComment1.getText().trim();
	        if (comment1.length() <= 0) {
	            JOptionPane.showMessageDialog(null, "输入有误，数据不能为空");
	            p.grabFocus();
	            return;
	        }
	        String comment2 = p.tfComment2.getText();
	        if (comment2.length() <= 0) {
	            JOptionPane.showMessageDialog(null, "输入有误，数据不能为空");
	            p.grabFocus();
	            return;
	        }
	        String comment3 = p.tfComment3.getText();
	        if (comment3.length() <= 0) {
	            JOptionPane.showMessageDialog(null, "输入有误，数据不能为空");
	            p.grabFocus();
	            return;
	        }
	        String comment4 = p.tfComment4.getText();
	        if (comment4.length() <= 0) {
	            JOptionPane.showMessageDialog(null, "输入有误，数据不能为空");
	            p.grabFocus();
	            return;
	        }
	        String comment5 = p.tfComment5.getText();
	        if (comment5.length() <= 0) {
	            JOptionPane.showMessageDialog(null, "输入有误，数据不能为空");
	            p.grabFocus();
	            return;
	        }
	        
	        
	        //根据 updateId 确定模式
	        if (p.updateId < 0) { //默认的添加模式
	        	int num = new RecordService().findMaxNum(d);
	        	if(num == 0) {
	        		num = 1;
	        	}else {
	        		num = num + 1;
	        	}
	        	
	            new RecordService().add(num,comment1, comment2, comment3,comment4, comment5, d);
	            JOptionPane.showMessageDialog(p, "添加成功");
	
	            //MainPanel.instance.workingPanel.show(HistoryPanel.instance);
	            MainPanel mainPanel = MainPanel.instance;
	            mainPanel.workingPanel.show(HistoryPanel.instance);
	        } else { //修改模式
	            new RecordService().update(p.updateId, comment1, comment2, comment3,comment4, comment5, d);
	            JOptionPane.showMessageDialog(p, "修改成功");
	            MainPanel.instance.workingPanel.show(HistoryPanel.instance);
	            //重置p.updateId
	            p.updateId = -1;
	            //刷新 HistoryListPanel
	            HistoryListPanel.instance.updateData(MonthPickerPanel.instance.toDay);
	        }
		}
    }
     
    
}
