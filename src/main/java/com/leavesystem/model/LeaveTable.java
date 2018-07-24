package com.leavesystem.model;

import java.util.Date;

public class LeaveTable {
    private Integer id;

    private String uid;

    private String uname;

    private String upost;

    private String usys;

    private String phone;

    private String leavetype;

    private String reason;

    private String leavetime;

    private String backtime;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
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

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}