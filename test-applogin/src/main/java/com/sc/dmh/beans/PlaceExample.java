package com.sc.dmh.beans;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PlaceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table place
     *
     * @mbggenerated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table place
     *
     * @mbggenerated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table place
     *
     * @mbggenerated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public PlaceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table place
     *
     * @mbggenerated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table place
     *
     * @mbggenerated
     */
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

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andPlaceNameIsNull() {
            addCriterion("place_name is null");
            return (Criteria) this;
        }

        public Criteria andPlaceNameIsNotNull() {
            addCriterion("place_name is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceNameEqualTo(String value) {
            addCriterion("place_name =", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameNotEqualTo(String value) {
            addCriterion("place_name <>", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameGreaterThan(String value) {
            addCriterion("place_name >", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameGreaterThanOrEqualTo(String value) {
            addCriterion("place_name >=", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameLessThan(String value) {
            addCriterion("place_name <", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameLessThanOrEqualTo(String value) {
            addCriterion("place_name <=", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameLike(String value) {
            addCriterion("place_name like", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameNotLike(String value) {
            addCriterion("place_name not like", value, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameIn(List<String> values) {
            addCriterion("place_name in", values, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameNotIn(List<String> values) {
            addCriterion("place_name not in", values, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameBetween(String value1, String value2) {
            addCriterion("place_name between", value1, value2, "placeName");
            return (Criteria) this;
        }

        public Criteria andPlaceNameNotBetween(String value1, String value2) {
            addCriterion("place_name not between", value1, value2, "placeName");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastIsNull() {
            addCriterion("latitude_east is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastIsNotNull() {
            addCriterion("latitude_east is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastEqualTo(BigDecimal value) {
            addCriterion("latitude_east =", value, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastNotEqualTo(BigDecimal value) {
            addCriterion("latitude_east <>", value, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastGreaterThan(BigDecimal value) {
            addCriterion("latitude_east >", value, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude_east >=", value, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastLessThan(BigDecimal value) {
            addCriterion("latitude_east <", value, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude_east <=", value, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastIn(List<BigDecimal> values) {
            addCriterion("latitude_east in", values, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastNotIn(List<BigDecimal> values) {
            addCriterion("latitude_east not in", values, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude_east between", value1, value2, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeEastNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude_east not between", value1, value2, "latitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastIsNull() {
            addCriterion("longitude_east is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastIsNotNull() {
            addCriterion("longitude_east is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastEqualTo(BigDecimal value) {
            addCriterion("longitude_east =", value, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastNotEqualTo(BigDecimal value) {
            addCriterion("longitude_east <>", value, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastGreaterThan(BigDecimal value) {
            addCriterion("longitude_east >", value, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude_east >=", value, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastLessThan(BigDecimal value) {
            addCriterion("longitude_east <", value, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude_east <=", value, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastIn(List<BigDecimal> values) {
            addCriterion("longitude_east in", values, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastNotIn(List<BigDecimal> values) {
            addCriterion("longitude_east not in", values, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude_east between", value1, value2, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLongitudeEastNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude_east not between", value1, value2, "longitudeEast");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestIsNull() {
            addCriterion("latitude_west is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestIsNotNull() {
            addCriterion("latitude_west is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestEqualTo(BigDecimal value) {
            addCriterion("latitude_west =", value, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestNotEqualTo(BigDecimal value) {
            addCriterion("latitude_west <>", value, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestGreaterThan(BigDecimal value) {
            addCriterion("latitude_west >", value, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude_west >=", value, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestLessThan(BigDecimal value) {
            addCriterion("latitude_west <", value, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude_west <=", value, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestIn(List<BigDecimal> values) {
            addCriterion("latitude_west in", values, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestNotIn(List<BigDecimal> values) {
            addCriterion("latitude_west not in", values, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude_west between", value1, value2, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLatitudeWestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude_west not between", value1, value2, "latitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestIsNull() {
            addCriterion("longitude_west is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestIsNotNull() {
            addCriterion("longitude_west is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestEqualTo(BigDecimal value) {
            addCriterion("longitude_west =", value, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestNotEqualTo(BigDecimal value) {
            addCriterion("longitude_west <>", value, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestGreaterThan(BigDecimal value) {
            addCriterion("longitude_west >", value, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude_west >=", value, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestLessThan(BigDecimal value) {
            addCriterion("longitude_west <", value, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude_west <=", value, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestIn(List<BigDecimal> values) {
            addCriterion("longitude_west in", values, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestNotIn(List<BigDecimal> values) {
            addCriterion("longitude_west not in", values, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude_west between", value1, value2, "longitudeWest");
            return (Criteria) this;
        }

        public Criteria andLongitudeWestNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude_west not between", value1, value2, "longitudeWest");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table place
     *
     * @mbggenerated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table place
     *
     * @mbggenerated
     */
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