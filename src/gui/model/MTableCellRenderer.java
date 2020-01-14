
package gui.model;
 
import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import util.ColorUtil;

public class MTableCellRenderer extends DefaultTableCellRenderer {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		if (value instanceof String) {
			String result = (String) value;
			if (result.equals("金") || result.equals("木") || result.equals("水") || result.equals("火")
					|| result.equals("土")) {
				setForeground(ColorUtil.redColor);
				setText(result);
			} else {
				setForeground(Color.black);
				setText(result);
			}
		}
		return c;
	}
}
