package gui.listener;
 
import gui.panel.HistoryListPanel;
import gui.panel.MonthPickerPanel; 
import service.RecordService; 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List; 

import entity.Record;

/**
 * MonthPickerPanel 的监听器，按钮后会修改 MonthPickerPanel.instance.date 为 选择月份的月初
 *
 * @author xenv
 * @see MonthPickerPanel
 */

public class MonthPickerListener implements ActionListener { 
    
    @Override
    public void actionPerformed(ActionEvent e) {
        MonthPickerPanel p = MonthPickerPanel.instance;
        Integer year = (Integer) p.cbYear.getSelectedItem();
        Integer month = (Integer) p.cbMonth.getSelectedItem();
        Integer day = (Integer) p.cbDay.getSelectedItem();
        //用SimpleDateFormat获取所选月月初的 Date
        try {
            p.date = new SimpleDateFormat("yyyy-MM-dd").parse(String.format("%4d-%02d-%02d", year, month,day));
            //更新 HistoryListPanel ,重新获取数据
            HistoryListPanel.instance.updateData(p.date);
            
            List<Record> rs = new RecordService().listDay(p.date);
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
