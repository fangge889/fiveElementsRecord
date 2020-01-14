package gui.model;
 
import entity.Record;
import gui.panel.MonthPickerPanel;
import service.RecordService;
import util.ColorUtil;

import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import java.awt.Component;
import java.util.Calendar;
import java.util.List;

/**
 * HistoryListPanel 的 Table 的数据模型，实现了 TableModel 接口
 *
 * @author xenv
 * @see gui.panel.HistoryListPanel
 */

public class RecordTableModel implements TableModel {
    private String[] columnNames = new String[]{"期号", "金", "木", "水", "火", "土"};
    public List<Record> rs = new RecordService().listDay(MonthPickerPanel.instance.toDay);
     
    @Override
    public int getRowCount() {
        return rs.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
    	
        if (0 == columnIndex) {
            return rs.get(rowIndex).getNum();
        }
        if (1 == columnIndex) { 
            return rs.get(rowIndex).getComment1();
        }
        if (2 == columnIndex) { 
            return rs.get(rowIndex).getComment2();
        }
        if (3 == columnIndex) { 
            return rs.get(rowIndex).getComment3();
        }
        if (4 == columnIndex) { 
            return rs.get(rowIndex).getComment4();
        }
        if (5 == columnIndex) { 
            return rs.get(rowIndex).getComment5();
        } 
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
