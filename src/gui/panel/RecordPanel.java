package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
 
import gui.listener.RecordListener; 
import util.*;

import org.jdesktop.swingx.JXDatePicker;

/**
 * 界面类 RecordPanel 记一笔页面
 *
 */

public class RecordPanel extends WorkingPanel {
    static {
        GUIUtil.useLNF();
    }

    public static RecordPanel instance = new RecordPanel();
    public int updateId = -1; //如果changeId>0则为修改模式，<0为模式的添加模式

    //private JLabel lSpend = new JLabel("花费(￥)");
    //private JLabel lCategory = new JLabel("分类");
    
    //private JLabel lComment1 = new JLabel("点击输入金");
    //private JLabel lComment2 = new JLabel("点击输入木");
    //private JLabel lComment3 = new JLabel("点击输入水");
    //private JLabel lComment4 = new JLabel("点击输入火");
    //private JLabel lComment5 = new JLabel("点击输入土");
    
    public JButton lComment1 = new JButton("金");
    public JButton lComment2 = new JButton("木");
    public JButton lComment3 = new JButton("水");
    public JButton lComment4 = new JButton("火");
    public JButton lComment5 = new JButton("土");
    
    private JLabel lDate = new JLabel("日期");

    //public JTextField tfSpend = new JTextField("0");

    //public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    //public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment1 = new JTextField();
    public JTextField tfComment2 = new JTextField();
    public JTextField tfComment3 = new JTextField();
    public JTextField tfComment4 = new JTextField();
    public JTextField tfComment5 = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());

    public JButton bSubmit = new JButton("保存");

    public RecordPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lComment1, lComment2, lComment3,lComment4,lComment5, lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit,lComment1,lComment2,lComment3,lComment4,lComment5);
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        JPanel pSubmit1 = new JPanel();
        int gap = 10;
        pInput.setLayout(new GridLayout(6, 2, gap, gap));

        //pInput.add(lSpend);
        //pInput.add(tfSpend);
        //pInput.add(lCategory);
        //pInput.add(cbCategory);
        
        pSubmit1.add(lComment1);
        pInput.add(tfComment1);
        pSubmit1.add(lComment2);
        pInput.add(tfComment2);
        pSubmit1.add(lComment3);
        pInput.add(tfComment3);
        pSubmit1.add(lComment4);
        pInput.add(tfComment4);
        pSubmit1.add(lComment5);
        pInput.add(tfComment5);
        pInput.add(lDate);
        pInput.add(datepick);

        pSubmit.add(bSubmit);

        this.setLayout(new BorderLayout());
        this.add(pInput, BorderLayout.NORTH);
        this.add(pSubmit1, BorderLayout.WEST);
        this.add(pSubmit, BorderLayout.CENTER);

        addListener();
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(RecordPanel.instance);
    }

    @Override
    public void updateData(Date date) {
        //cbModel.cs = new CategoryService().list();
        //cbCategory.updateUI();
        //tfSpend.setText("");
        tfComment1.setText("");
        tfComment2.setText("");
        tfComment3.setText("");
        tfComment4.setText("");
        tfComment5.setText("");
        datepick.setDate(new Date());
        //tfSpend.grabFocus();
    }

    //public Category getSelectedCategory() {
    //    return (Category) cbCategory.getSelectedItem();
    //}

    @Override
    public void addListener() {
        bSubmit.addActionListener(new RecordListener());
        lComment1.addActionListener(new RecordListener());
        lComment2.addActionListener(new RecordListener());
        lComment3.addActionListener(new RecordListener());
        lComment4.addActionListener(new RecordListener());
        lComment5.addActionListener(new RecordListener());
    }
}