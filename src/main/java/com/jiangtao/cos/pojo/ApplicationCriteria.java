package com.jiangtao.cos.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ApplicationCriteria {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ApplicationCriteria() {
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

        public Criteria andApPkIsNull() {
            addCriterion("ap_pk is null");
            return (Criteria) this;
        }

        public Criteria andApPkIsNotNull() {
            addCriterion("ap_pk is not null");
            return (Criteria) this;
        }

        public Criteria andApPkEqualTo(String value) {
            addCriterion("ap_pk =", value, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkNotEqualTo(String value) {
            addCriterion("ap_pk <>", value, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkGreaterThan(String value) {
            addCriterion("ap_pk >", value, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkGreaterThanOrEqualTo(String value) {
            addCriterion("ap_pk >=", value, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkLessThan(String value) {
            addCriterion("ap_pk <", value, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkLessThanOrEqualTo(String value) {
            addCriterion("ap_pk <=", value, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkLike(String value) {
            addCriterion("ap_pk like", value, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkNotLike(String value) {
            addCriterion("ap_pk not like", value, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkIn(List<String> values) {
            addCriterion("ap_pk in", values, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkNotIn(List<String> values) {
            addCriterion("ap_pk not in", values, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkBetween(String value1, String value2) {
            addCriterion("ap_pk between", value1, value2, "apPk");
            return (Criteria) this;
        }

        public Criteria andApPkNotBetween(String value1, String value2) {
            addCriterion("ap_pk not between", value1, value2, "apPk");
            return (Criteria) this;
        }

        public Criteria andApActorIsNull() {
            addCriterion("ap_actor is null");
            return (Criteria) this;
        }

        public Criteria andApActorIsNotNull() {
            addCriterion("ap_actor is not null");
            return (Criteria) this;
        }

        public Criteria andApActorEqualTo(String value) {
            addCriterion("ap_actor =", value, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorNotEqualTo(String value) {
            addCriterion("ap_actor <>", value, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorGreaterThan(String value) {
            addCriterion("ap_actor >", value, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorGreaterThanOrEqualTo(String value) {
            addCriterion("ap_actor >=", value, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorLessThan(String value) {
            addCriterion("ap_actor <", value, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorLessThanOrEqualTo(String value) {
            addCriterion("ap_actor <=", value, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorLike(String value) {
            addCriterion("ap_actor like", value, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorNotLike(String value) {
            addCriterion("ap_actor not like", value, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorIn(List<String> values) {
            addCriterion("ap_actor in", values, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorNotIn(List<String> values) {
            addCriterion("ap_actor not in", values, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorBetween(String value1, String value2) {
            addCriterion("ap_actor between", value1, value2, "apActor");
            return (Criteria) this;
        }

        public Criteria andApActorNotBetween(String value1, String value2) {
            addCriterion("ap_actor not between", value1, value2, "apActor");
            return (Criteria) this;
        }

        public Criteria andRvPkIsNull() {
            addCriterion("rv_pk is null");
            return (Criteria) this;
        }

        public Criteria andRvPkIsNotNull() {
            addCriterion("rv_pk is not null");
            return (Criteria) this;
        }

        public Criteria andRvPkEqualTo(String value) {
            addCriterion("rv_pk =", value, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkNotEqualTo(String value) {
            addCriterion("rv_pk <>", value, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkGreaterThan(String value) {
            addCriterion("rv_pk >", value, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkGreaterThanOrEqualTo(String value) {
            addCriterion("rv_pk >=", value, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkLessThan(String value) {
            addCriterion("rv_pk <", value, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkLessThanOrEqualTo(String value) {
            addCriterion("rv_pk <=", value, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkLike(String value) {
            addCriterion("rv_pk like", value, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkNotLike(String value) {
            addCriterion("rv_pk not like", value, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkIn(List<String> values) {
            addCriterion("rv_pk in", values, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkNotIn(List<String> values) {
            addCriterion("rv_pk not in", values, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkBetween(String value1, String value2) {
            addCriterion("rv_pk between", value1, value2, "rvPk");
            return (Criteria) this;
        }

        public Criteria andRvPkNotBetween(String value1, String value2) {
            addCriterion("rv_pk not between", value1, value2, "rvPk");
            return (Criteria) this;
        }

        public Criteria andApDateIsNull() {
            addCriterion("ap_date is null");
            return (Criteria) this;
        }

        public Criteria andApDateIsNotNull() {
            addCriterion("ap_date is not null");
            return (Criteria) this;
        }

        public Criteria andApDateEqualTo(Date value) {
            addCriterion("ap_date =", value, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateNotEqualTo(Date value) {
            addCriterion("ap_date <>", value, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateGreaterThan(Date value) {
            addCriterion("ap_date >", value, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateGreaterThanOrEqualTo(Date value) {
            addCriterion("ap_date >=", value, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateLessThan(Date value) {
            addCriterion("ap_date <", value, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateLessThanOrEqualTo(Date value) {
            addCriterion("ap_date <=", value, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateIn(List<Date> values) {
            addCriterion("ap_date in", values, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateNotIn(List<Date> values) {
            addCriterion("ap_date not in", values, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateBetween(Date value1, Date value2) {
            addCriterion("ap_date between", value1, value2, "apDate");
            return (Criteria) this;
        }

        public Criteria andApDateNotBetween(Date value1, Date value2) {
            addCriterion("ap_date not between", value1, value2, "apDate");
            return (Criteria) this;
        }

        public Criteria andApCommentIsNull() {
            addCriterion("ap_comment is null");
            return (Criteria) this;
        }

        public Criteria andApCommentIsNotNull() {
            addCriterion("ap_comment is not null");
            return (Criteria) this;
        }

        public Criteria andApCommentEqualTo(String value) {
            addCriterion("ap_comment =", value, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentNotEqualTo(String value) {
            addCriterion("ap_comment <>", value, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentGreaterThan(String value) {
            addCriterion("ap_comment >", value, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentGreaterThanOrEqualTo(String value) {
            addCriterion("ap_comment >=", value, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentLessThan(String value) {
            addCriterion("ap_comment <", value, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentLessThanOrEqualTo(String value) {
            addCriterion("ap_comment <=", value, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentLike(String value) {
            addCriterion("ap_comment like", value, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentNotLike(String value) {
            addCriterion("ap_comment not like", value, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentIn(List<String> values) {
            addCriterion("ap_comment in", values, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentNotIn(List<String> values) {
            addCriterion("ap_comment not in", values, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentBetween(String value1, String value2) {
            addCriterion("ap_comment between", value1, value2, "apComment");
            return (Criteria) this;
        }

        public Criteria andApCommentNotBetween(String value1, String value2) {
            addCriterion("ap_comment not between", value1, value2, "apComment");
            return (Criteria) this;
        }

        public Criteria andApStatIsNull() {
            addCriterion("ap_stat is null");
            return (Criteria) this;
        }

        public Criteria andApStatIsNotNull() {
            addCriterion("ap_stat is not null");
            return (Criteria) this;
        }

        public Criteria andApStatEqualTo(Byte value) {
            addCriterion("ap_stat =", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotEqualTo(Byte value) {
            addCriterion("ap_stat <>", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatGreaterThan(Byte value) {
            addCriterion("ap_stat >", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatGreaterThanOrEqualTo(Byte value) {
            addCriterion("ap_stat >=", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatLessThan(Byte value) {
            addCriterion("ap_stat <", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatLessThanOrEqualTo(Byte value) {
            addCriterion("ap_stat <=", value, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatIn(List<Byte> values) {
            addCriterion("ap_stat in", values, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotIn(List<Byte> values) {
            addCriterion("ap_stat not in", values, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatBetween(Byte value1, Byte value2) {
            addCriterion("ap_stat between", value1, value2, "apStat");
            return (Criteria) this;
        }

        public Criteria andApStatNotBetween(Byte value1, Byte value2) {
            addCriterion("ap_stat not between", value1, value2, "apStat");
            return (Criteria) this;
        }

        public Criteria andApPkLikeInsensitive(String value) {
            addCriterion("upper(ap_pk) like", value.toUpperCase(), "apPk");
            return (Criteria) this;
        }

        public Criteria andApActorLikeInsensitive(String value) {
            addCriterion("upper(ap_actor) like", value.toUpperCase(), "apActor");
            return (Criteria) this;
        }

        public Criteria andRvPkLikeInsensitive(String value) {
            addCriterion("upper(rv_pk) like", value.toUpperCase(), "rvPk");
            return (Criteria) this;
        }

        public Criteria andApCommentLikeInsensitive(String value) {
            addCriterion("upper(ap_comment) like", value.toUpperCase(), "apComment");
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