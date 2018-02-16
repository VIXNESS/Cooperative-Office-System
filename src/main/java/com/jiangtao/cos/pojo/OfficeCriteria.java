package com.jiangtao.cos.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class OfficeCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OfficeCriteria() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andStaffIsNull() {
            addCriterion("staff is null");
            return (Criteria) this;
        }

        public Criteria andStaffIsNotNull() {
            addCriterion("staff is not null");
            return (Criteria) this;
        }

        public Criteria andStaffEqualTo(String value) {
            addCriterion("staff =", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotEqualTo(String value) {
            addCriterion("staff <>", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffGreaterThan(String value) {
            addCriterion("staff >", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffGreaterThanOrEqualTo(String value) {
            addCriterion("staff >=", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffLessThan(String value) {
            addCriterion("staff <", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffLessThanOrEqualTo(String value) {
            addCriterion("staff <=", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffLike(String value) {
            addCriterion("staff like", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotLike(String value) {
            addCriterion("staff not like", value, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffIn(List<String> values) {
            addCriterion("staff in", values, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotIn(List<String> values) {
            addCriterion("staff not in", values, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffBetween(String value1, String value2) {
            addCriterion("staff between", value1, value2, "staff");
            return (Criteria) this;
        }

        public Criteria andStaffNotBetween(String value1, String value2) {
            addCriterion("staff not between", value1, value2, "staff");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNull() {
            addCriterion("department is null");
            return (Criteria) this;
        }

        public Criteria andDepartmentIsNotNull() {
            addCriterion("department is not null");
            return (Criteria) this;
        }

        public Criteria andDepartmentEqualTo(String value) {
            addCriterion("department =", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotEqualTo(String value) {
            addCriterion("department <>", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThan(String value) {
            addCriterion("department >", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentGreaterThanOrEqualTo(String value) {
            addCriterion("department >=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThan(String value) {
            addCriterion("department <", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLessThanOrEqualTo(String value) {
            addCriterion("department <=", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentLike(String value) {
            addCriterion("department like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotLike(String value) {
            addCriterion("department not like", value, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentIn(List<String> values) {
            addCriterion("department in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotIn(List<String> values) {
            addCriterion("department not in", values, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentBetween(String value1, String value2) {
            addCriterion("department between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andDepartmentNotBetween(String value1, String value2) {
            addCriterion("department not between", value1, value2, "department");
            return (Criteria) this;
        }

        public Criteria andPosiIsNull() {
            addCriterion("posi is null");
            return (Criteria) this;
        }

        public Criteria andPosiIsNotNull() {
            addCriterion("posi is not null");
            return (Criteria) this;
        }

        public Criteria andPosiEqualTo(Byte value) {
            addCriterion("posi =", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiNotEqualTo(Byte value) {
            addCriterion("posi <>", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiGreaterThan(Byte value) {
            addCriterion("posi >", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiGreaterThanOrEqualTo(Byte value) {
            addCriterion("posi >=", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiLessThan(Byte value) {
            addCriterion("posi <", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiLessThanOrEqualTo(Byte value) {
            addCriterion("posi <=", value, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiIn(List<Byte> values) {
            addCriterion("posi in", values, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiNotIn(List<Byte> values) {
            addCriterion("posi not in", values, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiBetween(Byte value1, Byte value2) {
            addCriterion("posi between", value1, value2, "posi");
            return (Criteria) this;
        }

        public Criteria andPosiNotBetween(Byte value1, Byte value2) {
            addCriterion("posi not between", value1, value2, "posi");
            return (Criteria) this;
        }

        public Criteria andInitDateIsNull() {
            addCriterion("init_date is null");
            return (Criteria) this;
        }

        public Criteria andInitDateIsNotNull() {
            addCriterion("init_date is not null");
            return (Criteria) this;
        }

        public Criteria andInitDateEqualTo(Date value) {
            addCriterionForJDBCDate("init_date =", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("init_date <>", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateGreaterThan(Date value) {
            addCriterionForJDBCDate("init_date >", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("init_date >=", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateLessThan(Date value) {
            addCriterionForJDBCDate("init_date <", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("init_date <=", value, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateIn(List<Date> values) {
            addCriterionForJDBCDate("init_date in", values, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("init_date not in", values, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("init_date between", value1, value2, "initDate");
            return (Criteria) this;
        }

        public Criteria andInitDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("init_date not between", value1, value2, "initDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIsNull() {
            addCriterion("expired_date is null");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIsNotNull() {
            addCriterion("expired_date is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredDateEqualTo(Date value) {
            addCriterionForJDBCDate("expired_date =", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("expired_date <>", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateGreaterThan(Date value) {
            addCriterionForJDBCDate("expired_date >", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expired_date >=", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateLessThan(Date value) {
            addCriterionForJDBCDate("expired_date <", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("expired_date <=", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIn(List<Date> values) {
            addCriterionForJDBCDate("expired_date in", values, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("expired_date not in", values, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expired_date between", value1, value2, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("expired_date not between", value1, value2, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andStaffLikeInsensitive(String value) {
            addCriterion("upper(staff) like", value.toUpperCase(), "staff");
            return (Criteria) this;
        }

        public Criteria andDepartmentLikeInsensitive(String value) {
            addCriterion("upper(department) like", value.toUpperCase(), "department");
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