package com.leavesystem.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class LeaveTable {
	private Integer id;

	private String uid;

	private String uname;

	private String upost;

	private String usys;

	private String leavetype;

	private String reason;

	private String leavetime;

	private String backtime;

	private String leavedays;

	private String state;

	private String processinstance;

	private Date createtime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid == null ? null : uid.trim();
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname == null ? null : uname.trim();
	}

	public String getUpost() {
		return upost;
	}

	public void setUpost(String upost) {
		this.upost = upost == null ? null : upost.trim();
	}

	public String getUsys() {
		return usys;
	}

	public void setUsys(String usys) {
		this.usys = usys == null ? null : usys.trim();
	}

	public String getLeavetype() {
		return leavetype;
	}

	public void setLeavetype(String leavetype) {
		this.leavetype = leavetype == null ? null : leavetype.trim();
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason == null ? null : reason.trim();
	}

	public String getLeavetime() {
		return leavetime;
	}

	public void setLeavetime(String leavetime) {
		this.leavetime = leavetime == null ? null : leavetime.trim();
	}

	public String getBacktime() {
		return backtime;
	}

	public void setBacktime(String backtime) {
		this.backtime = backtime == null ? null : backtime.trim();
	}

	public String getLeavedays() {
		return leavedays;
	}

	public void setLeavedays(String leavedays) {
		this.leavedays = leavedays == null ? null : leavedays.trim();
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state == null ? null : state.trim();
	}

	public String getProcessinstance() {
		return processinstance;
	}

	public void setProcessinstance(String processinstance) {
		this.processinstance = processinstance == null ? null : processinstance.trim();
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	@Override
	public String toString() {
		return "LeaveTable [id=" + id + ", uid=" + uid + ", uname=" + uname + ", upost=" + upost + ", usys=" + usys
				+ ", leavetype=" + leavetype + ", reason=" + reason + ", leavetime=" + leavetime + ", backtime="
				+ backtime + ", leavedays=" + leavedays + ", state=" + state + ", processinstance=" + processinstance
				+ ", createtime=" + createtime + "]";
	}

}