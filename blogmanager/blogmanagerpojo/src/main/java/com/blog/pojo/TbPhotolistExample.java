package com.blog.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbPhotolistExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbPhotolistExample() {
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

        public Criteria andPhotoIdIsNull() {
            addCriterion("photo_id is null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIsNotNull() {
            addCriterion("photo_id is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoIdEqualTo(Long value) {
            addCriterion("photo_id =", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotEqualTo(Long value) {
            addCriterion("photo_id <>", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThan(Long value) {
            addCriterion("photo_id >", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdGreaterThanOrEqualTo(Long value) {
            addCriterion("photo_id >=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThan(Long value) {
            addCriterion("photo_id <", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdLessThanOrEqualTo(Long value) {
            addCriterion("photo_id <=", value, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdIn(List<Long> values) {
            addCriterion("photo_id in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotIn(List<Long> values) {
            addCriterion("photo_id not in", values, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdBetween(Long value1, Long value2) {
            addCriterion("photo_id between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoIdNotBetween(Long value1, Long value2) {
            addCriterion("photo_id not between", value1, value2, "photoId");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleIsNull() {
            addCriterion("photo_title is null");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleIsNotNull() {
            addCriterion("photo_title is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleEqualTo(String value) {
            addCriterion("photo_title =", value, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleNotEqualTo(String value) {
            addCriterion("photo_title <>", value, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleGreaterThan(String value) {
            addCriterion("photo_title >", value, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("photo_title >=", value, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleLessThan(String value) {
            addCriterion("photo_title <", value, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleLessThanOrEqualTo(String value) {
            addCriterion("photo_title <=", value, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleLike(String value) {
            addCriterion("photo_title like", value, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleNotLike(String value) {
            addCriterion("photo_title not like", value, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleIn(List<String> values) {
            addCriterion("photo_title in", values, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleNotIn(List<String> values) {
            addCriterion("photo_title not in", values, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleBetween(String value1, String value2) {
            addCriterion("photo_title between", value1, value2, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoTitleNotBetween(String value1, String value2) {
            addCriterion("photo_title not between", value1, value2, "photoTitle");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainIsNull() {
            addCriterion("photo_explain is null");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainIsNotNull() {
            addCriterion("photo_explain is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainEqualTo(String value) {
            addCriterion("photo_explain =", value, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainNotEqualTo(String value) {
            addCriterion("photo_explain <>", value, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainGreaterThan(String value) {
            addCriterion("photo_explain >", value, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainGreaterThanOrEqualTo(String value) {
            addCriterion("photo_explain >=", value, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainLessThan(String value) {
            addCriterion("photo_explain <", value, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainLessThanOrEqualTo(String value) {
            addCriterion("photo_explain <=", value, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainLike(String value) {
            addCriterion("photo_explain like", value, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainNotLike(String value) {
            addCriterion("photo_explain not like", value, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainIn(List<String> values) {
            addCriterion("photo_explain in", values, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainNotIn(List<String> values) {
            addCriterion("photo_explain not in", values, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainBetween(String value1, String value2) {
            addCriterion("photo_explain between", value1, value2, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoExplainNotBetween(String value1, String value2) {
            addCriterion("photo_explain not between", value1, value2, "photoExplain");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesIsNull() {
            addCriterion("photo_images is null");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesIsNotNull() {
            addCriterion("photo_images is not null");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesEqualTo(String value) {
            addCriterion("photo_images =", value, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesNotEqualTo(String value) {
            addCriterion("photo_images <>", value, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesGreaterThan(String value) {
            addCriterion("photo_images >", value, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesGreaterThanOrEqualTo(String value) {
            addCriterion("photo_images >=", value, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesLessThan(String value) {
            addCriterion("photo_images <", value, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesLessThanOrEqualTo(String value) {
            addCriterion("photo_images <=", value, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesLike(String value) {
            addCriterion("photo_images like", value, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesNotLike(String value) {
            addCriterion("photo_images not like", value, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesIn(List<String> values) {
            addCriterion("photo_images in", values, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesNotIn(List<String> values) {
            addCriterion("photo_images not in", values, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesBetween(String value1, String value2) {
            addCriterion("photo_images between", value1, value2, "photoImages");
            return (Criteria) this;
        }

        public Criteria andPhotoImagesNotBetween(String value1, String value2) {
            addCriterion("photo_images not between", value1, value2, "photoImages");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
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