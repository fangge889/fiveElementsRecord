package gui.listener;
 
import gui.model.RecordTableModel;
import gui.panel.HistoryListPanel;
import gui.panel.HistoryPanel;
import gui.panel.MainPanel;
import gui.panel.MonthPickerPanel;
import gui.panel.RecordPanel;
import service.RecordService;
import util.Adjustment;
import util.DBUtil;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import entity.Record;

/**
 * MonthPickerPanel 的监听器，按钮后会修改 MonthPickerPanel.instance.date 为 选择月份的月初
 *
 * @author xenv
 * @see MonthPickerPanel
 */

public class MonthPickerListener implements ActionListener{  
	    
    @Override
    public void actionPerformed(ActionEvent e) {
        MonthPickerPanel p = MonthPickerPanel.instance;
        
        Integer year = (Integer) p.cbYear.getSelectedItem();
        Integer month = (Integer) p.cbMonth.getSelectedItem();
        Integer day = (Integer) p.cbDay.getSelectedItem();
        //用SimpleDateFormat获取所选月月初的 Date
        try {
        	JButton b = (JButton) e.getSource();
        	if (p.bSubmit == b) {
	            p.toDay = new SimpleDateFormat("yyyy-MM-dd").parse(String.format("%4d-%02d-%02d", year, month,day));
	            //更新 HistoryListPanel ,重新获取数据
	            HistoryListPanel.instance.updateData(p.toDay);  
            
        	}else if (p.lComment1 == b || p.lComment2 == b || p.lComment3 == b
            		 || p.lComment4 == b || p.lComment5 == b) {
        		
        		Date d = p.datepick.getDate();
        		List<Record> rs = new RecordService().listDay(d);
            	p = DBUtil.dataPanel(p,b,rs);
            	
                int num = new RecordService().findMaxNum(d);
            	if(num == 0) {
            		num = 1;
            	}else {
            		num = num + 1;
            	}
            	String comment11 = p.tfComment1.getText().trim();
            	String comment22 = p.tfComment2.getText().trim();
            	String comment33 = p.tfComment3.getText().trim();
            	String comment44 = p.tfComment4.getText().trim();
            	String comment55 = p.tfComment5.getText().trim();
                new RecordService().add(num,comment11, comment22, comment33,comment44, comment55, d);
                 
                MainPanel mainPanel = MainPanel.instance; 
                mainPanel.workingPanel.show(HistoryPanel.instance);
                
                JScrollBar jscrollBar = HistoryListPanel.instance.jscrollBar;
                JScrollPane sp = HistoryListPanel.instance.sp;
                Point point = new Point();  
                point.setLocation(0,jscrollBar.getValue()+500);  
    		    sp.getViewport().setViewPosition(point);  
            }  
        	
        	List<Record> rs = new RecordService().listDay(p.toDay);
        	int comment1 = 0;
        	int comment2 = 0;
        	int comment3 = 0;
        	int comment4 = 0;
        	int comment5 = 0;
        	for(Record record : rs) {
        		if(record.getComment1().equals("金")) {
        			comment1 = comment1 + 1;
        		}
    			if(record.getComment2().equals("木")) {
    				comment2 = comment2 + 1;			
    			}
    			if(record.getComment3().equals("水")) {
    				comment3 = comment3 + 1;
    			}
    			if(record.getComment4().equals("火")) {
    				comment4 = comment4 + 1;
    			}
    			if(record.getComment5().equals("土")) {
    				comment5 = comment5 + 1;
    			}
        	}
        	
            HistoryListPanel.instance.tfComment1.setText(comment1 + "");
            HistoryListPanel.instance.tfComment2.setText(comment2 + "");
            HistoryListPanel.instance.tfComment3.setText(comment3 + "");
            HistoryListPanel.instance.tfComment4.setText(comment4 + "");
            HistoryListPanel.instance.tfComment5.setText(comment5 + "");
            
            HistoryListPanel.instance.tfComment11.setText(rs.size() - comment1 + "");
            HistoryListPanel.instance.tfComment22.setText(rs.size() - comment2 + "");
            HistoryListPanel.instance.tfComment33.setText(rs.size() - comment3 + "");
            HistoryListPanel.instance.tfComment44.setText(rs.size() - comment4 + "");
            HistoryListPanel.instance.tfComment55.setText(rs.size() - comment5 + "");   
            
        } catch (ParseException e1) {
            e1.printStackTrace();
        } 
    }
    
}
