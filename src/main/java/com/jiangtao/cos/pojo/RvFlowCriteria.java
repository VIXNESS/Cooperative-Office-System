package com.jiangtao.cos.pojo;

import java.util.ArrayList;
import java.util.List;

public class RvFlowCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RvFlowCriteria() {
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

        public Criteria andRobjPkIsNull() {
            addCriterion("robj_pk is null");
            return (Criteria) this;
        }

        public Criteria andRobjPkIsNotNull() {
            addCriterion("robj_pk is not null");
            return (Criteria) this;
        }

        public Criteria andRobjPkEqualTo(String value) {
            addCriterion("robj_pk =", value, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkNotEqualTo(String value) {
            addCriterion("robj_pk <>", value, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkGreaterThan(String value) {
            addCriterion("robj_pk >", value, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkGreaterThanOrEqualTo(String value) {
            addCriterion("robj_pk >=", value, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkLessThan(String value) {
            addCriterion("robj_pk <", value, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkLessThanOrEqualTo(String value) {
            addCriterion("robj_pk <=", value, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkLike(String value) {
            addCriterion("robj_pk like", value, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkNotLike(String value) {
            addCriterion("robj_pk not like", value, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkIn(List<String> values) {
            addCriterion("robj_pk in", values, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkNotIn(List<String> values) {
            addCriterion("robj_pk not in", values, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkBetween(String value1, String value2) {
            addCriterion("robj_pk between", value1, value2, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkNotBetween(String value1, String value2) {
            addCriterion("robj_pk not between", value1, value2, "robjPk");
            return (Criteria) this;
        }

        public Criteria andRbojSerialIsNull() {
            addCriterion("rboj_serial is null");
            return (Criteria) this;
        }

        public Criteria andRbojSerialIsNotNull() {
            addCriterion("rboj_serial is not null");
            return (Criteria) this;
        }

        public Criteria andRbojSerialEqualTo(Byte value) {
            addCriterion("rboj_serial =", value, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialNotEqualTo(Byte value) {
            addCriterion("rboj_serial <>", value, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialGreaterThan(Byte value) {
            addCriterion("rboj_serial >", value, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialGreaterThanOrEqualTo(Byte value) {
            addCriterion("rboj_serial >=", value, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialLessThan(Byte value) {
            addCriterion("rboj_serial <", value, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialLessThanOrEqualTo(Byte value) {
            addCriterion("rboj_serial <=", value, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialIn(List<Byte> values) {
            addCriterion("rboj_serial in", values, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialNotIn(List<Byte> values) {
            addCriterion("rboj_serial not in", values, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialBetween(Byte value1, Byte value2) {
            addCriterion("rboj_serial between", value1, value2, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andRbojSerialNotBetween(Byte value1, Byte value2) {
            addCriterion("rboj_serial not between", value1, value2, "rbojSerial");
            return (Criteria) this;
        }

        public Criteria andAtPkIsNull() {
            addCriterion("at_pk is null");
            return (Criteria) this;
        }

        public Criteria andAtPkIsNotNull() {
            addCriterion("at_pk is not null");
            return (Criteria) this;
        }

        public Criteria andAtPkEqualTo(String value) {
            addCriterion("at_pk =", value, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkNotEqualTo(String value) {
            addCriterion("at_pk <>", value, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkGreaterThan(String value) {
            addCriterion("at_pk >", value, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkGreaterThanOrEqualTo(String value) {
            addCriterion("at_pk >=", value, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkLessThan(String value) {
            addCriterion("at_pk <", value, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkLessThanOrEqualTo(String value) {
            addCriterion("at_pk <=", value, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkLike(String value) {
            addCriterion("at_pk like", value, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkNotLike(String value) {
            addCriterion("at_pk not like", value, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkIn(List<String> values) {
            addCriterion("at_pk in", values, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkNotIn(List<String> values) {
            addCriterion("at_pk not in", values, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkBetween(String value1, String value2) {
            addCriterion("at_pk between", value1, value2, "atPk");
            return (Criteria) this;
        }

        public Criteria andAtPkNotBetween(String value1, String value2) {
            addCriterion("at_pk not between", value1, value2, "atPk");
            return (Criteria) this;
        }

        public Criteria andRobjPkLikeInsensitive(String value) {
            addCriterion("upper(robj_pk) like", value.toUpperCase(), "robjPk");
            return (Criteria) this;
        }

        public Criteria andAtPkLikeInsensitive(String value) {
            addCriterion("upper(at_pk) like", value.toUpperCase(), "atPk");
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