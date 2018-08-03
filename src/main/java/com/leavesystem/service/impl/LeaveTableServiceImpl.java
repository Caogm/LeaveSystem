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
	public LeaveTable queryByName(String uname) {
		LeaveTableExample example = new LeaveTableExample();
		Criteria criteria = example.createCriteria();
		criteria.andUnameEqualTo(uname);
		return (LeaveTable) leaveTableMapper.selectByExample(example);
	}

	@Override
	public List<LeaveTable> queryByProcessInstanceId(String ProcessInstanceId) {
		LeaveTableExample example = new LeaveTableExample();
		LeaveTableExample.Criteria criteria = example.createCriteria();
		criteria.andProcessinstanceEqualTo(ProcessInstanceId);

		return leaveTableMapper.selectByExample(example);

	}

	@Override
	public LeaveTable queryById(Integer id) {
		// TODO Auto-generated method stub

		return leaveTableMapper.selectByPrimaryKey(id);
	}

	//请假原因模糊查询
	@Override
	public List<LeaveTable> queryByLikeReason(String reason) {
		LeaveTableExample example = new LeaveTableExample();
		LeaveTableExample.Criteria criteria = example.createCriteria();
		criteria.andReasonLike("%" + reason + "%");
		return leaveTableMapper.selectByExample(example);
	}

	//请假类型+请假原因模糊查询
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
		leaveTableMapper.updateByPrimaryKey(leavetable);
	}

	@Override
	public void deleteLeaveTable(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLeaveTableByUname(String uname) {
		// TODO Auto-generated method stub
		LeaveTableExample leaveTableExample = new LeaveTableExample();
		Criteria criteria = leaveTableExample.createCriteria();
		criteria.andUnameEqualTo(uname);
		leaveTableMapper.deleteByExample(leaveTableExample);
	}

}
