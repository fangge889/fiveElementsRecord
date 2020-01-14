package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;

import entity.Record;
import gui.panel.RecordPanel;

/**
 * 工具类 DBUtil 获取数据库 Connection
 */

public class DBUtil {
    static final String database = "db/data.db";

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = String.format("jdbc:sqlite:%s", database);
        return DriverManager.getConnection(url);
    }

    public static RecordPanel dataPanel(RecordPanel p,JButton b,List<Record> recordList) {
    	if (p.lComment1 == b) {
        	p.tfComment1.setText("金");
        	
        	if(null == recordList || recordList.size() == 0) {
        		p.tfComment2.setText("1");
        		p.tfComment3.setText("1");
        		p.tfComment4.setText("1");
        		p.tfComment5.setText("1");
        	}else {
        		int count = recordList.size();
    			Record record = recordList.get(count-1);
	    		if(record.getComment2().equals("木")) {
	    			p.tfComment2.setText(1 + "");
	    		}else {
	    			p.tfComment2.setText(Integer.parseInt(record.getComment2()) + 1 + "");
	    		}
				if(record.getComment3().equals("水")) {
					p.tfComment3.setText(1 + "");		
				}else {
	    			p.tfComment3.setText(Integer.parseInt(record.getComment3()) + 1 + "");
	    		}
				if(record.getComment4().equals("火")) {
					p.tfComment4.setText(1 + "");	
				}else {
	    			p.tfComment4.setText(Integer.parseInt(record.getComment4()) + 1 + "");
	    		}
				if(record.getComment5().equals("土")) {
					p.tfComment5.setText(1 + "");	
				}else {
	    			p.tfComment5.setText(Integer.parseInt(record.getComment5()) + 1 + "");
	    		}
        	} 
        }
		if (p.lComment2 == b) {
			p.tfComment2.setText("木");
			
			if(null == recordList || recordList.size() == 0) {
        		p.tfComment1.setText("1");
        		p.tfComment3.setText("1");
        		p.tfComment4.setText("1");
        		p.tfComment5.setText("1");
        	}else {
        		int count = recordList.size();
    			Record record = recordList.get(count-1);
	    		if(record.getComment1().equals("金")) {
	    			p.tfComment1.setText(1 + "");
	    		}else {
	    			p.tfComment1.setText(Integer.parseInt(record.getComment1()) + 1 + "");
	    		}
				if(record.getComment3().equals("水")) {
					p.tfComment3.setText(1 + "");		
				}else {
	    			p.tfComment3.setText(Integer.parseInt(record.getComment3()) + 1 + "");
	    		}
				if(record.getComment4().equals("火")) {
					p.tfComment4.setText(1 + "");	
				}else {
	    			p.tfComment4.setText(Integer.parseInt(record.getComment4()) + 1 + "");
	    		}
				if(record.getComment5().equals("土")) {
					p.tfComment5.setText(1 + "");	
				}else {
	    			p.tfComment5.setText(Integer.parseInt(record.getComment5()) + 1 + "");
	    		}
        	} 
		 }
		if (p.lComment3 == b) {
			p.tfComment3.setText("水");
			
			if(null == recordList || recordList.size() == 0) {
        		p.tfComment1.setText("1");
        		p.tfComment2.setText("1");
        		p.tfComment4.setText("1");
        		p.tfComment5.setText("1");
        	}else {
        		int count = recordList.size();
    			Record record = recordList.get(count-1);
	    		if(record.getComment1().equals("金")) {
	    			p.tfComment1.setText(1 + "");
	    		}else {
	    			p.tfComment1.setText(Integer.parseInt(record.getComment1()) + 1 + "");
	    		}
				if(record.getComment2().equals("木")) {
					p.tfComment2.setText(1 + "");		
				}else {
	    			p.tfComment2.setText(Integer.parseInt(record.getComment2()) + 1 + "");
	    		}
				if(record.getComment4().equals("火")) {
					p.tfComment4.setText(1 + "");	
				}else {
	    			p.tfComment4.setText(Integer.parseInt(record.getComment4()) + 1 + "");
	    		}
				if(record.getComment5().equals("土")) {
					p.tfComment5.setText(1 + "");	
				}else {
	    			p.tfComment5.setText(Integer.parseInt(record.getComment5()) + 1 + "");
	    		}
        	} 
		}
		if (p.lComment4 == b) {
			p.tfComment4.setText("火");
			
			if(null == recordList || recordList.size() == 0) {
        		p.tfComment1.setText("1");
        		p.tfComment2.setText("1");
        		p.tfComment3.setText("1");
        		p.tfComment5.setText("1");
        	}else {
        		int count = recordList.size();
    			Record record = recordList.get(count-1);
	    		if(record.getComment1().equals("金")) {
	    			p.tfComment1.setText(1 + "");
	    		}else {
	    			p.tfComment1.setText(Integer.parseInt(record.getComment1()) + 1 + "");
	    		}
				if(record.getComment2().equals("木")) {
					p.tfComment2.setText(1 + "");		
				}else {
	    			p.tfComment2.setText(Integer.parseInt(record.getComment2()) + 1 + "");
	    		}
				if(record.getComment3().equals("水")) {
					p.tfComment3.setText(1 + "");	
				}else {
	    			p.tfComment3.setText(Integer.parseInt(record.getComment3()) + 1 + "");
	    		}
				if(record.getComment5().equals("土")) {
					p.tfComment5.setText(1 + "");	
				}else {
	    			p.tfComment5.setText(Integer.parseInt(record.getComment5()) + 1 + "");
	    		}
        	} 
		}
		if (p.lComment5 == b) {
			p.tfComment5.setText("土");
			
			if(null == recordList || recordList.size() == 0) {
        		p.tfComment1.setText("1");
        		p.tfComment2.setText("1");
        		p.tfComment3.setText("1");
        		p.tfComment4.setText("1");
        	}else {
        		int count = recordList.size();
    			Record record = recordList.get(count-1);
	    		if(record.getComment1().equals("金")) {
	    			p.tfComment1.setText(1 + "");
	    		}else {
	    			p.tfComment1.setText(Integer.parseInt(record.getComment1()) + 1 + "");
	    		}
				if(record.getComment2().equals("木")) {
					p.tfComment2.setText(1 + "");		
				}else {
	    			p.tfComment2.setText(Integer.parseInt(record.getComment2()) + 1 + "");
	    		}
				if(record.getComment3().equals("水")) {
					p.tfComment3.setText(1 + "");	
				}else {
	    			p.tfComment3.setText(Integer.parseInt(record.getComment3()) + 1 + "");
	    		}
				if(record.getComment4().equals("火")) {
					p.tfComment4.setText(1 + "");	
				}else {
	    			p.tfComment4.setText(Integer.parseInt(record.getComment4()) + 1 + "");
	    		}
        	} 
		}
    	 
    	
		return p;
    }
}
