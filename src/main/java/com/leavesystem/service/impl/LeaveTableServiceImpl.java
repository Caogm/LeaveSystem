package com.leavesystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leavesystem.mapper.LeaveTableMapper;
import com.leavesystem.model.LeaveTable;
import com.leavesystem.model.LeaveTableExample;
import com.leavesystem.model.LeaveTableExample.Criteria;
import com.leavesystem.service.LeaveTableService;

@Service("leaveTableServiceImpl")
public class LeaveTableServiceImpl implements LeaveTableService {

	@Autowired
	private LeaveTableMapper leaveTableMapper;

	public LeaveTableMapper getLeaveTableMapper() {
		return leaveTableMapper;
	}

	public void setLeaveTableMapper(LeaveTableMapper leaveTableMapper) {
		this.leaveTableMapper = leaveTableMapper;
	}

	@Override
	public void addLeaveTable(LeaveTable leavetable) {
		leaveTableMapper.insert(leavetable);
	}

	@Override
	public List<LeaveTable> queryByName(String uname) {
		LeaveTableExample example = new LeaveTableExample();
		Criteria criteria = example.createCriteria();
		criteria.andUnameEqualTo(uname);
		return leaveTableMapper.selectByExample(example);
	}

	//模糊查询
	@Override
	public List<LeaveTable> queryByStr(String leavetype, String reason) {
		LeaveTableExample example = new LeaveTableExample();
		LeaveTableExample.Criteria criteria = example.createCriteria();
		criteria.andReasonLike("%" + reason + "%");
		criteria.andLeavetypeEqualTo(leavetype);
		example.or(criteria);

		return leaveTableMapper.selectByExample(example);
		/*System.out.println(reason);
		return leaveTableMapper.queryByKeyWords(leavetype, reason);*/
	}

	@Override
	public void updateLeaveTable(Integer id, LeaveTable leavetable) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLeaveTable(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<LeaveTable> queryByStr(String leavetype) {
		LeaveTableExample example = new LeaveTableExample();
		LeaveTableExample.Criteria criteria = example.createCriteria();
		criteria.andLeavetypeEqualTo(leavetype);

		return leaveTableMapper.selectByExample(example);
	}

}
