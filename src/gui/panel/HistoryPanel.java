package gui.panel;

import util.ColorUtil;
import util.GUIUtil;

import java.awt.*;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;

import entity.Record;
import gui.model.MTableCellRenderer;
import gui.model.RecordTableModel;
import service.RecordService;

/**
 * 界面类 HistoryPanel 历史消费页
 * 调用了 MonthPickerPanel 和 HistoryListPanel 两个子面板
 *
 * @author xenv
 * @see MonthPickerPanel
 * @see HistoryListPanel
 */
public class HistoryPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static HistoryPanel instance = new HistoryPanel();
    
    private RecordTableModel rtm = new RecordTableModel();
    private JTable t =new JTable(rtm);

    private HistoryPanel() {
    	List<Record> rs = new RecordService().listDay(MonthPickerPanel.instance.toDay);
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
    	
        this.setLayout(new BorderLayout());
        this.add(MonthPickerPanel.instance, BorderLayout.NORTH);
        this.add(HistoryListPanel.instance, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(HistoryPanel.instance);
    }

    @Override
    public void updateData(Date date) {
        HistoryListPanel.instance.updateData(date);
    }

    @Override
    public void addListener() {

    }
}
