package util;

import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane; 

public class Adjustment implements AdjustmentListener{
	
	JScrollBar jscrollBar = new JScrollBar();
	JScrollPane sp = new JScrollPane();
	public Adjustment(JScrollBar bar,JScrollPane jScrollPane){
		jscrollBar = bar;
		sp = jScrollPane;
	}

	@Override
	public void adjustmentValueChanged(AdjustmentEvent e) { 
		if (e.getAdjustable() == jscrollBar) { 
			//jscrollBar.setValue(e.getValue() + 1);
		    Point p = new Point();  
		    p.setLocation(0,e.getValue()+1);  
		    sp.getViewport().setViewPosition(p);  
		}
	}

}
