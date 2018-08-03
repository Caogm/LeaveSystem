package com.leavesystem.mapper;

import com.leavesystem.model.LeaveTable;
import com.leavesystem.model.LeaveTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeaveTableMapper {
    int countByExample(LeaveTableExample example);

    int deleteByExample(LeaveTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(LeaveTable record);

    int insertSelective(LeaveTable record);

    List<LeaveTable> selectByExample(LeaveTableExample example);

    LeaveTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") LeaveTable record, @Param("example") LeaveTableExample example);

    int updateByExample(@Param("record") LeaveTable record, @Param("example") LeaveTableExample example);

    int updateByPrimaryKeySelective(LeaveTable record);

    int updateByPrimaryKey(LeaveTable record);
}