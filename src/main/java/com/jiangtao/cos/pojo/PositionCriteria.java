package com.jiangtao.cos.pojo;

import java.util.ArrayList;
import java.util.List;

public class PositionCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PositionCriteria() {
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

        public Criteria andPosiPkIsNull() {
            addCriterion("posi_pk is null");
            return (Criteria) this;
        }

        public Criteria andPosiPkIsNotNull() {
            addCriterion("posi_pk is not null");
            return (Criteria) this;
        }

        public Criteria andPosiPkEqualTo(Byte value) {
            addCriterion("posi_pk =", value, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkNotEqualTo(Byte value) {
            addCriterion("posi_pk <>", value, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkGreaterThan(Byte value) {
            addCriterion("posi_pk >", value, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkGreaterThanOrEqualTo(Byte value) {
            addCriterion("posi_pk >=", value, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkLessThan(Byte value) {
            addCriterion("posi_pk <", value, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkLessThanOrEqualTo(Byte value) {
            addCriterion("posi_pk <=", value, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkIn(List<Byte> values) {
            addCriterion("posi_pk in", values, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkNotIn(List<Byte> values) {
            addCriterion("posi_pk not in", values, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkBetween(Byte value1, Byte value2) {
            addCriterion("posi_pk between", value1, value2, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiPkNotBetween(Byte value1, Byte value2) {
            addCriterion("posi_pk not between", value1, value2, "posiPk");
            return (Criteria) this;
        }

        public Criteria andPosiNameIsNull() {
            addCriterion("posi_name is null");
            return (Criteria) this;
        }

        public Criteria andPosiNameIsNotNull() {
            addCriterion("posi_name is not null");
            return (Criteria) this;
        }

        public Criteria andPosiNameEqualTo(String value) {
            addCriterion("posi_name =", value, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameNotEqualTo(String value) {
            addCriterion("posi_name <>", value, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameGreaterThan(String value) {
            addCriterion("posi_name >", value, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameGreaterThanOrEqualTo(String value) {
            addCriterion("posi_name >=", value, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameLessThan(String value) {
            addCriterion("posi_name <", value, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameLessThanOrEqualTo(String value) {
            addCriterion("posi_name <=", value, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameLike(String value) {
            addCriterion("posi_name like", value, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameNotLike(String value) {
            addCriterion("posi_name not like", value, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameIn(List<String> values) {
            addCriterion("posi_name in", values, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameNotIn(List<String> values) {
            addCriterion("posi_name not in", values, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameBetween(String value1, String value2) {
            addCriterion("posi_name between", value1, value2, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameNotBetween(String value1, String value2) {
            addCriterion("posi_name not between", value1, value2, "posiName");
            return (Criteria) this;
        }

        public Criteria andPosiNameLikeInsensitive(String value) {
            addCriterion("upper(posi_name) like", value.toUpperCase(), "posiName");
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