package com.blog.pojo;

import java.util.ArrayList;
import java.util.List;

public class TbSysParameterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbSysParameterExample() {
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

        public Criteria andCmsnameIsNull() {
            addCriterion("cmsName is null");
            return (Criteria) this;
        }

        public Criteria andCmsnameIsNotNull() {
            addCriterion("cmsName is not null");
            return (Criteria) this;
        }

        public Criteria andCmsnameEqualTo(String value) {
            addCriterion("cmsName =", value, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameNotEqualTo(String value) {
            addCriterion("cmsName <>", value, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameGreaterThan(String value) {
            addCriterion("cmsName >", value, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameGreaterThanOrEqualTo(String value) {
            addCriterion("cmsName >=", value, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameLessThan(String value) {
            addCriterion("cmsName <", value, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameLessThanOrEqualTo(String value) {
            addCriterion("cmsName <=", value, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameLike(String value) {
            addCriterion("cmsName like", value, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameNotLike(String value) {
            addCriterion("cmsName not like", value, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameIn(List<String> values) {
            addCriterion("cmsName in", values, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameNotIn(List<String> values) {
            addCriterion("cmsName not in", values, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameBetween(String value1, String value2) {
            addCriterion("cmsName between", value1, value2, "cmsname");
            return (Criteria) this;
        }

        public Criteria andCmsnameNotBetween(String value1, String value2) {
            addCriterion("cmsName not between", value1, value2, "cmsname");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andHomepageIsNull() {
            addCriterion("homePage is null");
            return (Criteria) this;
        }

        public Criteria andHomepageIsNotNull() {
            addCriterion("homePage is not null");
            return (Criteria) this;
        }

        public Criteria andHomepageEqualTo(String value) {
            addCriterion("homePage =", value, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageNotEqualTo(String value) {
            addCriterion("homePage <>", value, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageGreaterThan(String value) {
            addCriterion("homePage >", value, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageGreaterThanOrEqualTo(String value) {
            addCriterion("homePage >=", value, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageLessThan(String value) {
            addCriterion("homePage <", value, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageLessThanOrEqualTo(String value) {
            addCriterion("homePage <=", value, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageLike(String value) {
            addCriterion("homePage like", value, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageNotLike(String value) {
            addCriterion("homePage not like", value, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageIn(List<String> values) {
            addCriterion("homePage in", values, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageNotIn(List<String> values) {
            addCriterion("homePage not in", values, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageBetween(String value1, String value2) {
            addCriterion("homePage between", value1, value2, "homepage");
            return (Criteria) this;
        }

        public Criteria andHomepageNotBetween(String value1, String value2) {
            addCriterion("homePage not between", value1, value2, "homepage");
            return (Criteria) this;
        }

        public Criteria andRunserverIsNull() {
            addCriterion("runServer is null");
            return (Criteria) this;
        }

        public Criteria andRunserverIsNotNull() {
            addCriterion("runServer is not null");
            return (Criteria) this;
        }

        public Criteria andRunserverEqualTo(String value) {
            addCriterion("runServer =", value, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverNotEqualTo(String value) {
            addCriterion("runServer <>", value, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverGreaterThan(String value) {
            addCriterion("runServer >", value, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverGreaterThanOrEqualTo(String value) {
            addCriterion("runServer >=", value, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverLessThan(String value) {
            addCriterion("runServer <", value, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverLessThanOrEqualTo(String value) {
            addCriterion("runServer <=", value, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverLike(String value) {
            addCriterion("runServer like", value, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverNotLike(String value) {
            addCriterion("runServer not like", value, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverIn(List<String> values) {
            addCriterion("runServer in", values, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverNotIn(List<String> values) {
            addCriterion("runServer not in", values, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverBetween(String value1, String value2) {
            addCriterion("runServer between", value1, value2, "runserver");
            return (Criteria) this;
        }

        public Criteria andRunserverNotBetween(String value1, String value2) {
            addCriterion("runServer not between", value1, value2, "runserver");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionIsNull() {
            addCriterion("dataBaseVersion is null");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionIsNotNull() {
            addCriterion("dataBaseVersion is not null");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionEqualTo(String value) {
            addCriterion("dataBaseVersion =", value, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionNotEqualTo(String value) {
            addCriterion("dataBaseVersion <>", value, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionGreaterThan(String value) {
            addCriterion("dataBaseVersion >", value, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionGreaterThanOrEqualTo(String value) {
            addCriterion("dataBaseVersion >=", value, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionLessThan(String value) {
            addCriterion("dataBaseVersion <", value, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionLessThanOrEqualTo(String value) {
            addCriterion("dataBaseVersion <=", value, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionLike(String value) {
            addCriterion("dataBaseVersion like", value, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionNotLike(String value) {
            addCriterion("dataBaseVersion not like", value, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionIn(List<String> values) {
            addCriterion("dataBaseVersion in", values, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionNotIn(List<String> values) {
            addCriterion("dataBaseVersion not in", values, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionBetween(String value1, String value2) {
            addCriterion("dataBaseVersion between", value1, value2, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andDatabaseversionNotBetween(String value1, String value2) {
            addCriterion("dataBaseVersion not between", value1, value2, "databaseversion");
            return (Criteria) this;
        }

        public Criteria andPowerbyIsNull() {
            addCriterion("powerby is null");
            return (Criteria) this;
        }

        public Criteria andPowerbyIsNotNull() {
            addCriterion("powerby is not null");
            return (Criteria) this;
        }

        public Criteria andPowerbyEqualTo(String value) {
            addCriterion("powerby =", value, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyNotEqualTo(String value) {
            addCriterion("powerby <>", value, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyGreaterThan(String value) {
            addCriterion("powerby >", value, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyGreaterThanOrEqualTo(String value) {
            addCriterion("powerby >=", value, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyLessThan(String value) {
            addCriterion("powerby <", value, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyLessThanOrEqualTo(String value) {
            addCriterion("powerby <=", value, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyLike(String value) {
            addCriterion("powerby like", value, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyNotLike(String value) {
            addCriterion("powerby not like", value, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyIn(List<String> values) {
            addCriterion("powerby in", values, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyNotIn(List<String> values) {
            addCriterion("powerby not in", values, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyBetween(String value1, String value2) {
            addCriterion("powerby between", value1, value2, "powerby");
            return (Criteria) this;
        }

        public Criteria andPowerbyNotBetween(String value1, String value2) {
            addCriterion("powerby not between", value1, value2, "powerby");
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