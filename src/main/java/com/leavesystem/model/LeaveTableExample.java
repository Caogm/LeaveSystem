package com.leavesystem.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LeaveTableExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LeaveTableExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUpostIsNull() {
            addCriterion("upost is null");
            return (Criteria) this;
        }

        public Criteria andUpostIsNotNull() {
            addCriterion("upost is not null");
            return (Criteria) this;
        }

        public Criteria andUpostEqualTo(String value) {
            addCriterion("upost =", value, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostNotEqualTo(String value) {
            addCriterion("upost <>", value, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostGreaterThan(String value) {
            addCriterion("upost >", value, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostGreaterThanOrEqualTo(String value) {
            addCriterion("upost >=", value, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostLessThan(String value) {
            addCriterion("upost <", value, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostLessThanOrEqualTo(String value) {
            addCriterion("upost <=", value, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostLike(String value) {
            addCriterion("upost like", value, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostNotLike(String value) {
            addCriterion("upost not like", value, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostIn(List<String> values) {
            addCriterion("upost in", values, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostNotIn(List<String> values) {
            addCriterion("upost not in", values, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostBetween(String value1, String value2) {
            addCriterion("upost between", value1, value2, "upost");
            return (Criteria) this;
        }

        public Criteria andUpostNotBetween(String value1, String value2) {
            addCriterion("upost not between", value1, value2, "upost");
            return (Criteria) this;
        }

        public Criteria andUsysIsNull() {
            addCriterion("usys is null");
            return (Criteria) this;
        }

        public Criteria andUsysIsNotNull() {
            addCriterion("usys is not null");
            return (Criteria) this;
        }

        public Criteria andUsysEqualTo(String value) {
            addCriterion("usys =", value, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysNotEqualTo(String value) {
            addCriterion("usys <>", value, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysGreaterThan(String value) {
            addCriterion("usys >", value, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysGreaterThanOrEqualTo(String value) {
            addCriterion("usys >=", value, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysLessThan(String value) {
            addCriterion("usys <", value, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysLessThanOrEqualTo(String value) {
            addCriterion("usys <=", value, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysLike(String value) {
            addCriterion("usys like", value, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysNotLike(String value) {
            addCriterion("usys not like", value, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysIn(List<String> values) {
            addCriterion("usys in", values, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysNotIn(List<String> values) {
            addCriterion("usys not in", values, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysBetween(String value1, String value2) {
            addCriterion("usys between", value1, value2, "usys");
            return (Criteria) this;
        }

        public Criteria andUsysNotBetween(String value1, String value2) {
            addCriterion("usys not between", value1, value2, "usys");
            return (Criteria) this;
        }

        public Criteria andLeavetypeIsNull() {
            addCriterion("leavetype is null");
            return (Criteria) this;
        }

        public Criteria andLeavetypeIsNotNull() {
            addCriterion("leavetype is not null");
            return (Criteria) this;
        }

        public Criteria andLeavetypeEqualTo(String value) {
            addCriterion("leavetype =", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeNotEqualTo(String value) {
            addCriterion("leavetype <>", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeGreaterThan(String value) {
            addCriterion("leavetype >", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeGreaterThanOrEqualTo(String value) {
            addCriterion("leavetype >=", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeLessThan(String value) {
            addCriterion("leavetype <", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeLessThanOrEqualTo(String value) {
            addCriterion("leavetype <=", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeLike(String value) {
            addCriterion("leavetype like", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeNotLike(String value) {
            addCriterion("leavetype not like", value, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeIn(List<String> values) {
            addCriterion("leavetype in", values, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeNotIn(List<String> values) {
            addCriterion("leavetype not in", values, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeBetween(String value1, String value2) {
            addCriterion("leavetype between", value1, value2, "leavetype");
            return (Criteria) this;
        }

        public Criteria andLeavetypeNotBetween(String value1, String value2) {
            addCriterion("leavetype not between", value1, value2, "leavetype");
            return (Criteria) this;
        }

        public Criteria andReasonIsNull() {
            addCriterion("reason is null");
            return (Criteria) this;
        }

        public Criteria andReasonIsNotNull() {
            addCriterion("reason is not null");
            return (Criteria) this;
        }

        public Criteria andReasonEqualTo(String value) {
            addCriterion("reason =", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotEqualTo(String value) {
            addCriterion("reason <>", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThan(String value) {
            addCriterion("reason >", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reason >=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThan(String value) {
            addCriterion("reason <", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLessThanOrEqualTo(String value) {
            addCriterion("reason <=", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonLike(String value) {
            addCriterion("reason like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotLike(String value) {
            addCriterion("reason not like", value, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonIn(List<String> values) {
            addCriterion("reason in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotIn(List<String> values) {
            addCriterion("reason not in", values, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonBetween(String value1, String value2) {
            addCriterion("reason between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andReasonNotBetween(String value1, String value2) {
            addCriterion("reason not between", value1, value2, "reason");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIsNull() {
            addCriterion("leavetime is null");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIsNotNull() {
            addCriterion("leavetime is not null");
            return (Criteria) this;
        }

        public Criteria andLeavetimeEqualTo(String value) {
            addCriterion("leavetime =", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotEqualTo(String value) {
            addCriterion("leavetime <>", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeGreaterThan(String value) {
            addCriterion("leavetime >", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeGreaterThanOrEqualTo(String value) {
            addCriterion("leavetime >=", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeLessThan(String value) {
            addCriterion("leavetime <", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeLessThanOrEqualTo(String value) {
            addCriterion("leavetime <=", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeLike(String value) {
            addCriterion("leavetime like", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotLike(String value) {
            addCriterion("leavetime not like", value, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeIn(List<String> values) {
            addCriterion("leavetime in", values, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotIn(List<String> values) {
            addCriterion("leavetime not in", values, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeBetween(String value1, String value2) {
            addCriterion("leavetime between", value1, value2, "leavetime");
            return (Criteria) this;
        }

        public Criteria andLeavetimeNotBetween(String value1, String value2) {
            addCriterion("leavetime not between", value1, value2, "leavetime");
            return (Criteria) this;
        }

        public Criteria andBacktimeIsNull() {
            addCriterion("backtime is null");
            return (Criteria) this;
        }

        public Criteria andBacktimeIsNotNull() {
            addCriterion("backtime is not null");
            return (Criteria) this;
        }

        public Criteria andBacktimeEqualTo(String value) {
            addCriterion("backtime =", value, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeNotEqualTo(String value) {
            addCriterion("backtime <>", value, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeGreaterThan(String value) {
            addCriterion("backtime >", value, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeGreaterThanOrEqualTo(String value) {
            addCriterion("backtime >=", value, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeLessThan(String value) {
            addCriterion("backtime <", value, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeLessThanOrEqualTo(String value) {
            addCriterion("backtime <=", value, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeLike(String value) {
            addCriterion("backtime like", value, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeNotLike(String value) {
            addCriterion("backtime not like", value, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeIn(List<String> values) {
            addCriterion("backtime in", values, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeNotIn(List<String> values) {
            addCriterion("backtime not in", values, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeBetween(String value1, String value2) {
            addCriterion("backtime between", value1, value2, "backtime");
            return (Criteria) this;
        }

        public Criteria andBacktimeNotBetween(String value1, String value2) {
            addCriterion("backtime not between", value1, value2, "backtime");
            return (Criteria) this;
        }

        public Criteria andLeavedaysIsNull() {
            addCriterion("leavedays is null");
            return (Criteria) this;
        }

        public Criteria andLeavedaysIsNotNull() {
            addCriterion("leavedays is not null");
            return (Criteria) this;
        }

        public Criteria andLeavedaysEqualTo(String value) {
            addCriterion("leavedays =", value, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysNotEqualTo(String value) {
            addCriterion("leavedays <>", value, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysGreaterThan(String value) {
            addCriterion("leavedays >", value, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysGreaterThanOrEqualTo(String value) {
            addCriterion("leavedays >=", value, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysLessThan(String value) {
            addCriterion("leavedays <", value, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysLessThanOrEqualTo(String value) {
            addCriterion("leavedays <=", value, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysLike(String value) {
            addCriterion("leavedays like", value, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysNotLike(String value) {
            addCriterion("leavedays not like", value, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysIn(List<String> values) {
            addCriterion("leavedays in", values, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysNotIn(List<String> values) {
            addCriterion("leavedays not in", values, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysBetween(String value1, String value2) {
            addCriterion("leavedays between", value1, value2, "leavedays");
            return (Criteria) this;
        }

        public Criteria andLeavedaysNotBetween(String value1, String value2) {
            addCriterion("leavedays not between", value1, value2, "leavedays");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("state like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("state not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("state not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceIsNull() {
            addCriterion("processInstance is null");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceIsNotNull() {
            addCriterion("processInstance is not null");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceEqualTo(String value) {
            addCriterion("processInstance =", value, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceNotEqualTo(String value) {
            addCriterion("processInstance <>", value, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceGreaterThan(String value) {
            addCriterion("processInstance >", value, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceGreaterThanOrEqualTo(String value) {
            addCriterion("processInstance >=", value, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceLessThan(String value) {
            addCriterion("processInstance <", value, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceLessThanOrEqualTo(String value) {
            addCriterion("processInstance <=", value, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceLike(String value) {
            addCriterion("processInstance like", value, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceNotLike(String value) {
            addCriterion("processInstance not like", value, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceIn(List<String> values) {
            addCriterion("processInstance in", values, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceNotIn(List<String> values) {
            addCriterion("processInstance not in", values, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceBetween(String value1, String value2) {
            addCriterion("processInstance between", value1, value2, "processinstance");
            return (Criteria) this;
        }

        public Criteria andProcessinstanceNotBetween(String value1, String value2) {
            addCriterion("processInstance not between", value1, value2, "processinstance");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}