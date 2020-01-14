package service;

import dao.RecordDAO;
import entity.Record;
import util.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * 业务类 RecordService 对 record 数据库的业务进行封装
 *
 * @author xenv
 */

public class RecordService {
    private static RecordDAO dao = new RecordDAO();

    public void add(int num, String comment1, String comment2, String comment3,String comment4,String comment5, Date date) {
        Record r = new Record();
        r.setNum(num);
        r.setComment1(comment1);
        r.setComment2(comment2);
        r.setComment3(comment3);
        r.setComment4(comment4);
        r.setComment5(comment5);
        r.setDate(date);
        dao.add(r);
    }

    public void update(int id, String comment1, String comment2, String comment3,String comment4,String comment5, Date date) {
        Record r = new Record(); 
        r.setId(id);
        r.setComment1(comment1);
        r.setComment2(comment2);
        r.setComment3(comment3);
        r.setComment4(comment4);
        r.setComment5(comment5);
        r.setDate(date);
        dao.update(r);
    }

    public void delete(int id) {
        dao.delete(id);
    }

    /**
     * 获取指定月的 record 数据
     *
     * @param startDay 指定月的第一天的 Date
     * @return record 的列表
     */
    public List<Record> listMonth(Date startDay) {
        Date endDay = DateUtil.monthEnd(startDay);
        return dao.list(startDay, endDay);
    }
    
    
    /**
     * 获取指定天的 record 数据
     *
     * @param startDay 指定天的 Date
     * @return record 的列表
     */
    public List<Record> listDay(Date day) {
        return dao.list(day);
    }
    
    public int findMaxNum(java.util.Date day) {
    	return dao.findMaxNum(day);
    }
}
