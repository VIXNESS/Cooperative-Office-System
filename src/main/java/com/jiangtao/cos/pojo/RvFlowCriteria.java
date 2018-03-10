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

        public Criteria andPkIsNull() {
            addCriterion("pk is null");
            return (Criteria) this;
        }

        public Criteria andPkIsNotNull() {
            addCriterion("pk is not null");
            return (Criteria) this;
        }

        public Criteria andPkEqualTo(String value) {
            addCriterion("pk =", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkNotEqualTo(String value) {
            addCriterion("pk <>", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkGreaterThan(String value) {
            addCriterion("pk >", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkGreaterThanOrEqualTo(String value) {
            addCriterion("pk >=", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkLessThan(String value) {
            addCriterion("pk <", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkLessThanOrEqualTo(String value) {
            addCriterion("pk <=", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkLike(String value) {
            addCriterion("pk like", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkNotLike(String value) {
            addCriterion("pk not like", value, "pk");
            return (Criteria) this;
        }

        public Criteria andPkIn(List<String> values) {
            addCriterion("pk in", values, "pk");
            return (Criteria) this;
        }

        public Criteria andPkNotIn(List<String> values) {
            addCriterion("pk not in", values, "pk");
            return (Criteria) this;
        }

        public Criteria andPkBetween(String value1, String value2) {
            addCriterion("pk between", value1, value2, "pk");
            return (Criteria) this;
        }

        public Criteria andPkNotBetween(String value1, String value2) {
            addCriterion("pk not between", value1, value2, "pk");
            return (Criteria) this;
        }

        public Criteria andPreIsNull() {
            addCriterion("pre is null");
            return (Criteria) this;
        }

        public Criteria andPreIsNotNull() {
            addCriterion("pre is not null");
            return (Criteria) this;
        }

        public Criteria andPreEqualTo(String value) {
            addCriterion("pre =", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotEqualTo(String value) {
            addCriterion("pre <>", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreGreaterThan(String value) {
            addCriterion("pre >", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreGreaterThanOrEqualTo(String value) {
            addCriterion("pre >=", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLessThan(String value) {
            addCriterion("pre <", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLessThanOrEqualTo(String value) {
            addCriterion("pre <=", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreLike(String value) {
            addCriterion("pre like", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotLike(String value) {
            addCriterion("pre not like", value, "pre");
            return (Criteria) this;
        }

        public Criteria andPreIn(List<String> values) {
            addCriterion("pre in", values, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotIn(List<String> values) {
            addCriterion("pre not in", values, "pre");
            return (Criteria) this;
        }

        public Criteria andPreBetween(String value1, String value2) {
            addCriterion("pre between", value1, value2, "pre");
            return (Criteria) this;
        }

        public Criteria andPreNotBetween(String value1, String value2) {
            addCriterion("pre not between", value1, value2, "pre");
            return (Criteria) this;
        }

        public Criteria andSucIsNull() {
            addCriterion("suc is null");
            return (Criteria) this;
        }

        public Criteria andSucIsNotNull() {
            addCriterion("suc is not null");
            return (Criteria) this;
        }

        public Criteria andSucEqualTo(String value) {
            addCriterion("suc =", value, "suc");
            return (Criteria) this;
        }

        public Criteria andSucNotEqualTo(String value) {
            addCriterion("suc <>", value, "suc");
            return (Criteria) this;
        }

        public Criteria andSucGreaterThan(String value) {
            addCriterion("suc >", value, "suc");
            return (Criteria) this;
        }

        public Criteria andSucGreaterThanOrEqualTo(String value) {
            addCriterion("suc >=", value, "suc");
            return (Criteria) this;
        }

        public Criteria andSucLessThan(String value) {
            addCriterion("suc <", value, "suc");
            return (Criteria) this;
        }

        public Criteria andSucLessThanOrEqualTo(String value) {
            addCriterion("suc <=", value, "suc");
            return (Criteria) this;
        }

        public Criteria andSucLike(String value) {
            addCriterion("suc like", value, "suc");
            return (Criteria) this;
        }

        public Criteria andSucNotLike(String value) {
            addCriterion("suc not like", value, "suc");
            return (Criteria) this;
        }

        public Criteria andSucIn(List<String> values) {
            addCriterion("suc in", values, "suc");
            return (Criteria) this;
        }

        public Criteria andSucNotIn(List<String> values) {
            addCriterion("suc not in", values, "suc");
            return (Criteria) this;
        }

        public Criteria andSucBetween(String value1, String value2) {
            addCriterion("suc between", value1, value2, "suc");
            return (Criteria) this;
        }

        public Criteria andSucNotBetween(String value1, String value2) {
            addCriterion("suc not between", value1, value2, "suc");
            return (Criteria) this;
        }

        public Criteria andAtmIsNull() {
            addCriterion("atm is null");
            return (Criteria) this;
        }

        public Criteria andAtmIsNotNull() {
            addCriterion("atm is not null");
            return (Criteria) this;
        }

        public Criteria andAtmEqualTo(String value) {
            addCriterion("atm =", value, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmNotEqualTo(String value) {
            addCriterion("atm <>", value, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmGreaterThan(String value) {
            addCriterion("atm >", value, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmGreaterThanOrEqualTo(String value) {
            addCriterion("atm >=", value, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmLessThan(String value) {
            addCriterion("atm <", value, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmLessThanOrEqualTo(String value) {
            addCriterion("atm <=", value, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmLike(String value) {
            addCriterion("atm like", value, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmNotLike(String value) {
            addCriterion("atm not like", value, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmIn(List<String> values) {
            addCriterion("atm in", values, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmNotIn(List<String> values) {
            addCriterion("atm not in", values, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmBetween(String value1, String value2) {
            addCriterion("atm between", value1, value2, "atm");
            return (Criteria) this;
        }

        public Criteria andAtmNotBetween(String value1, String value2) {
            addCriterion("atm not between", value1, value2, "atm");
            return (Criteria) this;
        }

        public Criteria andObjIsNull() {
            addCriterion("obj is null");
            return (Criteria) this;
        }

        public Criteria andObjIsNotNull() {
            addCriterion("obj is not null");
            return (Criteria) this;
        }

        public Criteria andObjEqualTo(String value) {
            addCriterion("obj =", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjNotEqualTo(String value) {
            addCriterion("obj <>", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjGreaterThan(String value) {
            addCriterion("obj >", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjGreaterThanOrEqualTo(String value) {
            addCriterion("obj >=", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjLessThan(String value) {
            addCriterion("obj <", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjLessThanOrEqualTo(String value) {
            addCriterion("obj <=", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjLike(String value) {
            addCriterion("obj like", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjNotLike(String value) {
            addCriterion("obj not like", value, "obj");
            return (Criteria) this;
        }

        public Criteria andObjIn(List<String> values) {
            addCriterion("obj in", values, "obj");
            return (Criteria) this;
        }

        public Criteria andObjNotIn(List<String> values) {
            addCriterion("obj not in", values, "obj");
            return (Criteria) this;
        }

        public Criteria andObjBetween(String value1, String value2) {
            addCriterion("obj between", value1, value2, "obj");
            return (Criteria) this;
        }

        public Criteria andObjNotBetween(String value1, String value2) {
            addCriterion("obj not between", value1, value2, "obj");
            return (Criteria) this;
        }

        public Criteria andPkLikeInsensitive(String value) {
            addCriterion("upper(pk) like", value.toUpperCase(), "pk");
            return (Criteria) this;
        }

        public Criteria andPreLikeInsensitive(String value) {
            addCriterion("upper(pre) like", value.toUpperCase(), "pre");
            return (Criteria) this;
        }

        public Criteria andSucLikeInsensitive(String value) {
            addCriterion("upper(suc) like", value.toUpperCase(), "suc");
            return (Criteria) this;
        }

        public Criteria andAtmLikeInsensitive(String value) {
            addCriterion("upper(atm) like", value.toUpperCase(), "atm");
            return (Criteria) this;
        }

        public Criteria andObjLikeInsensitive(String value) {
            addCriterion("upper(obj) like", value.toUpperCase(), "obj");
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