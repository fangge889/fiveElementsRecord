package gui.panel;

import entity.Record;
import gui.listener.HistoryListListener;
import gui.model.MTableCellRenderer;
import gui.model.RecordTableModel;
import service.RecordService;
import util.Adjustment;
import util.ColorUtil;
import util.GUIUtil;

import javax.swing.*; 

import java.awt.*;
import java.awt.event.AdjustmentEvent; 
import java.util.Date;

/**
 * HistoryListPanel 是 HistoryPanel 中的历史记录面板
 * @see HistoryPanel
 *
 * @author xenv
 */
public class HistoryListPanel extends WorkingPanel{
    static {
        GUIUtil.useLNF();
    }

    public static HistoryListPanel instance = new HistoryListPanel();
    //public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");
    
    private JLabel lComment1 = new JLabel("总出");
    private JLabel lComment2 = new JLabel("不出");
    
    public JTextField tfComment1 = new JTextField();
    public JTextField tfComment2 = new JTextField();
    public JTextField tfComment3 = new JTextField();
    public JTextField tfComment4 = new JTextField();
    public JTextField tfComment5 = new JTextField();
    
    public JTextField tfComment11 = new JTextField();
    public JTextField tfComment22 = new JTextField();
    public JTextField tfComment33 = new JTextField();
    public JTextField tfComment44 = new JTextField();
    public JTextField tfComment55 = new JTextField();

    public RecordTableModel rtm = new RecordTableModel();
    public JTable t = new JTable(rtm);
    public JScrollPane sp = new JScrollPane(t);
    public JScrollBar jscrollBar = sp.getVerticalScrollBar();
    
    private HistoryListPanel(){      
        t.getColumnModel().getColumn(1).setCellRenderer(new MTableCellRenderer());
        t.getColumnModel().getColumn(2).setCellRenderer(new MTableCellRenderer());
        t.getColumnModel().getColumn(3).setCellRenderer(new MTableCellRenderer());
        t.getColumnModel().getColumn(4).setCellRenderer(new MTableCellRenderer());
        t.getColumnModel().getColumn(5).setCellRenderer(new MTableCellRenderer());
        
        GUIUtil.setColor(ColorUtil.blueColor,bEdit,bDelete,lComment1,lComment2); 
        sp.doLayout(); 
        jscrollBar.setValue(jscrollBar.getMaximum());
        JPanel pSubmit = new JPanel();
          
        pSubmit.add(lComment1);
        pSubmit.add(tfComment1);
        pSubmit.add(tfComment2);
        pSubmit.add(tfComment3);
        pSubmit.add(tfComment4);
        pSubmit.add(tfComment5); 
        
        pSubmit.add(lComment2);
        pSubmit.add(tfComment11);
        pSubmit.add(tfComment22);
        pSubmit.add(tfComment33);
        pSubmit.add(tfComment44);
        pSubmit.add(tfComment55);  
        
        pSubmit.add(bEdit);
        pSubmit.add(bDelete); 

        this.setLayout(new BorderLayout());
        this.add(sp,BorderLayout.CENTER);
        this.add(pSubmit,BorderLayout.SOUTH); 
        this.addListener();   
    }
    public static void main(String[] args) {
        GUIUtil.showPanel(HistoryListPanel.instance);
    }
    public boolean checkSelected(){
        return t.getSelectedRow()>=0;
    }
    public Record getSelectedRecord(){ 
        int index = t.getSelectedRow();
        return rtm.rs.get(index>0?index:0); 
    }
    @Override
    public void updateData(Date date) {
        rtm.rs = new RecordService().listDay(date);  
        t.updateUI(); 
    }

    @Override
    public void addListener() {   
        HistoryListListener l = new HistoryListListener();  
        
        bDelete.addActionListener(l);
        bEdit.addActionListener(l);
    }
    
    public void adjustmentValueChanged(AdjustmentEvent e) { 
		if (e.getAdjustable() == jscrollBar) { 
			if(rtm.rs.size() > 0) {
				jscrollBar.setValue(e.getValue() + 1);
			} 
		}
	}
}
