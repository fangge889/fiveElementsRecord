package dao;

import entity.Record;
import util.DBUtil;
import util.DateUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO类-Record，对 record 表进行增改删查操作，还做了一些冗余的方法，不再过多注释
 */

public class RecordDAO {
    public void add(Record record) {
        String sql = "insert into record (`num`,`comment1`,`comment2`,`comment3`,`comment4`,`comment5`,`date`) values (?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setInt(1, record.getNum());
        	ps.setString(2, record.getComment1());
        	ps.setString(3, record.getComment2());
            ps.setString(4, record.getComment3());
            ps.setString(5, record.getComment4());
            ps.setString(6, record.getComment5());
            ps.setDate(7, DateUtil.util2sql(record.getDate()));

            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                record.setId(id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int update(Record record) {
        String sql = "update record set `comment1` = ? ,`comment2` = ? , `comment3` = ? ,`comment4` = ? ,`comment5` = ? , `date` = ? where id = ?";
        int result = 0;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
        	ps.setString(1, record.getComment1());
        	ps.setString(2, record.getComment2());
            ps.setString(3, record.getComment3());
            ps.setString(4, record.getComment4());
            ps.setString(5, record.getComment5());
            ps.setDate(6, DateUtil.util2sql(record.getDate()));
            ps.setInt(7, record.getId());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int delete(int id) {
        String sql = "delete from record where id = ?";
        int result = 0;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    public Record get(int id) {
        Record record = null;
        String sql = "select * from record where id = ?";
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	record = new Record(rs.getInt("id"),
            			rs.getInt("num"),
                		rs.getString("comment1"),
                        rs.getString("comment2"),
                        rs.getString("comment3"),
                        rs.getString("comment4"),
                        rs.getString("comment5"),
                        rs.getDate("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return record;
    }


    public List<Record> list(int start, int count) {
        String sql = "select * from record order by id desc limit ?,?";
        List<Record> records = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, start);
            ps.setInt(2, count);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record(rs.getInt("id"),
                		rs.getInt("num"),
                		rs.getString("comment1"),
                        rs.getString("comment2"),
                        rs.getString("comment3"),
                        rs.getString("comment4"),
                        rs.getString("comment5"),
                        rs.getDate("date"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<Record> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Record> list(int cid) {
        String sql = "select * from record where `cid` = ?";
        List<Record> records = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, cid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record(rs.getInt("id"),
                		rs.getInt("num"),
                		rs.getString("comment1"),
                        rs.getString("comment2"),
                        rs.getString("comment3"),
                        rs.getString("comment4"),
                        rs.getString("comment5"),
                        rs.getDate("date"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<Record> list(java.util.Date day) {
        String sql = "select * from record where `date` = ?";
        List<Record> records = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, DateUtil.util2sql(day));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record(rs.getInt("id"),
                		rs.getInt("num"),
                		rs.getString("comment1"),
                        rs.getString("comment2"),
                        rs.getString("comment3"),
                        rs.getString("comment4"),
                        rs.getString("comment5"),
                        rs.getDate("date"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<Record> listToday() {
        return list(new java.util.Date());
    }

    public List<Record> list(java.util.Date start, java.util.Date end) {
        String sql = "select * from record where `date` >= ? and `date` <= ?";
        List<Record> records = new ArrayList<>();
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, DateUtil.util2sql(start));
            ps.setDate(2, DateUtil.util2sql(end));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Record record = new Record(rs.getInt("id"),
                		rs.getInt("num"),
                		rs.getString("comment1"),
                        rs.getString("comment2"),
                        rs.getString("comment3"),
                        rs.getString("comment4"),
                        rs.getString("comment5"),
                        rs.getDate("date"));
                records.add(record);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return records;
    }

    public List<Record> listThisMonth() {
        return list(DateUtil.monthBegin(), DateUtil.monthEnd());
    }

    public int getTotal() {
        String sql = "select count(*) from record";
        try (Connection c = DBUtil.getConnection();
             Statement s = c.createStatement()) {
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int findMaxNum(java.util.Date day) {
        String sql = "select max(num) as num from record where `date` = ?";
        int result = 0;
        try (Connection c = DBUtil.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setDate(1, DateUtil.util2sql(day));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	result = rs.getInt("num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

}