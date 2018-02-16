package com.jiangtao.cos.pojo;

import java.util.ArrayList;
import java.util.List;

public class AtmTranCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AtmTranCriteria() {
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

        public Criteria andAtmCommentIsNull() {
            addCriterion("atm_comment is null");
            return (Criteria) this;
        }

        public Criteria andAtmCommentIsNotNull() {
            addCriterion("atm_comment is not null");
            return (Criteria) this;
        }

        public Criteria andAtmCommentEqualTo(String value) {
            addCriterion("atm_comment =", value, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentNotEqualTo(String value) {
            addCriterion("atm_comment <>", value, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentGreaterThan(String value) {
            addCriterion("atm_comment >", value, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentGreaterThanOrEqualTo(String value) {
            addCriterion("atm_comment >=", value, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentLessThan(String value) {
            addCriterion("atm_comment <", value, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentLessThanOrEqualTo(String value) {
            addCriterion("atm_comment <=", value, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentLike(String value) {
            addCriterion("atm_comment like", value, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentNotLike(String value) {
            addCriterion("atm_comment not like", value, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentIn(List<String> values) {
            addCriterion("atm_comment in", values, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentNotIn(List<String> values) {
            addCriterion("atm_comment not in", values, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentBetween(String value1, String value2) {
            addCriterion("atm_comment between", value1, value2, "atmComment");
            return (Criteria) this;
        }

        public Criteria andAtmCommentNotBetween(String value1, String value2) {
            addCriterion("atm_comment not between", value1, value2, "atmComment");
            return (Criteria) this;
        }

        public Criteria andRvDpIsNull() {
            addCriterion("rv_dp is null");
            return (Criteria) this;
        }

        public Criteria andRvDpIsNotNull() {
            addCriterion("rv_dp is not null");
            return (Criteria) this;
        }

        public Criteria andRvDpEqualTo(String value) {
            addCriterion("rv_dp =", value, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpNotEqualTo(String value) {
            addCriterion("rv_dp <>", value, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpGreaterThan(String value) {
            addCriterion("rv_dp >", value, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpGreaterThanOrEqualTo(String value) {
            addCriterion("rv_dp >=", value, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpLessThan(String value) {
            addCriterion("rv_dp <", value, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpLessThanOrEqualTo(String value) {
            addCriterion("rv_dp <=", value, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpLike(String value) {
            addCriterion("rv_dp like", value, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpNotLike(String value) {
            addCriterion("rv_dp not like", value, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpIn(List<String> values) {
            addCriterion("rv_dp in", values, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpNotIn(List<String> values) {
            addCriterion("rv_dp not in", values, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpBetween(String value1, String value2) {
            addCriterion("rv_dp between", value1, value2, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvDpNotBetween(String value1, String value2) {
            addCriterion("rv_dp not between", value1, value2, "rvDp");
            return (Criteria) this;
        }

        public Criteria andRvPosiIsNull() {
            addCriterion("rv_posi is null");
            return (Criteria) this;
        }

        public Criteria andRvPosiIsNotNull() {
            addCriterion("rv_posi is not null");
            return (Criteria) this;
        }

        public Criteria andRvPosiEqualTo(Byte value) {
            addCriterion("rv_posi =", value, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiNotEqualTo(Byte value) {
            addCriterion("rv_posi <>", value, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiGreaterThan(Byte value) {
            addCriterion("rv_posi >", value, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiGreaterThanOrEqualTo(Byte value) {
            addCriterion("rv_posi >=", value, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiLessThan(Byte value) {
            addCriterion("rv_posi <", value, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiLessThanOrEqualTo(Byte value) {
            addCriterion("rv_posi <=", value, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiIn(List<Byte> values) {
            addCriterion("rv_posi in", values, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiNotIn(List<Byte> values) {
            addCriterion("rv_posi not in", values, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiBetween(Byte value1, Byte value2) {
            addCriterion("rv_posi between", value1, value2, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andRvPosiNotBetween(Byte value1, Byte value2) {
            addCriterion("rv_posi not between", value1, value2, "rvPosi");
            return (Criteria) this;
        }

        public Criteria andPkLikeInsensitive(String value) {
            addCriterion("upper(pk) like", value.toUpperCase(), "pk");
            return (Criteria) this;
        }

        public Criteria andAtmCommentLikeInsensitive(String value) {
            addCriterion("upper(atm_comment) like", value.toUpperCase(), "atmComment");
            return (Criteria) this;
        }

        public Criteria andRvDpLikeInsensitive(String value) {
            addCriterion("upper(rv_dp) like", value.toUpperCase(), "rvDp");
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