package com.idea.spbmodeldemo.entity.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VehicleModelPOExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VehicleModelPOExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIsNull() {
            addCriterion("energy_type is null");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIsNotNull() {
            addCriterion("energy_type is not null");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeEqualTo(Integer value) {
            addCriterion("energy_type =", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotEqualTo(Integer value) {
            addCriterion("energy_type <>", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeGreaterThan(Integer value) {
            addCriterion("energy_type >", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("energy_type >=", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLessThan(Integer value) {
            addCriterion("energy_type <", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeLessThanOrEqualTo(Integer value) {
            addCriterion("energy_type <=", value, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeIn(List<Integer> values) {
            addCriterion("energy_type in", values, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotIn(List<Integer> values) {
            addCriterion("energy_type not in", values, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeBetween(Integer value1, Integer value2) {
            addCriterion("energy_type between", value1, value2, "energyType");
            return (Criteria) this;
        }

        public Criteria andEnergyTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("energy_type not between", value1, value2, "energyType");
            return (Criteria) this;
        }

        public Criteria andCarCodeIsNull() {
            addCriterion("car_code is null");
            return (Criteria) this;
        }

        public Criteria andCarCodeIsNotNull() {
            addCriterion("car_code is not null");
            return (Criteria) this;
        }

        public Criteria andCarCodeEqualTo(String value) {
            addCriterion("car_code =", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeNotEqualTo(String value) {
            addCriterion("car_code <>", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeGreaterThan(String value) {
            addCriterion("car_code >", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeGreaterThanOrEqualTo(String value) {
            addCriterion("car_code >=", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeLessThan(String value) {
            addCriterion("car_code <", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeLessThanOrEqualTo(String value) {
            addCriterion("car_code <=", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeLike(String value) {
            addCriterion("car_code like", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeNotLike(String value) {
            addCriterion("car_code not like", value, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeIn(List<String> values) {
            addCriterion("car_code in", values, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeNotIn(List<String> values) {
            addCriterion("car_code not in", values, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeBetween(String value1, String value2) {
            addCriterion("car_code between", value1, value2, "carCode");
            return (Criteria) this;
        }

        public Criteria andCarCodeNotBetween(String value1, String value2) {
            addCriterion("car_code not between", value1, value2, "carCode");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNull() {
            addCriterion("crt_time is null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIsNotNull() {
            addCriterion("crt_time is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTimeEqualTo(Date value) {
            addCriterion("crt_time =", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotEqualTo(Date value) {
            addCriterion("crt_time <>", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThan(Date value) {
            addCriterion("crt_time >", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("crt_time >=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThan(Date value) {
            addCriterion("crt_time <", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeLessThanOrEqualTo(Date value) {
            addCriterion("crt_time <=", value, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeIn(List<Date> values) {
            addCriterion("crt_time in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotIn(List<Date> values) {
            addCriterion("crt_time not in", values, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeBetween(Date value1, Date value2) {
            addCriterion("crt_time between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtTimeNotBetween(Date value1, Date value2) {
            addCriterion("crt_time not between", value1, value2, "crtTime");
            return (Criteria) this;
        }

        public Criteria andCrtUidIsNull() {
            addCriterion("crt_uid is null");
            return (Criteria) this;
        }

        public Criteria andCrtUidIsNotNull() {
            addCriterion("crt_uid is not null");
            return (Criteria) this;
        }

        public Criteria andCrtUidEqualTo(Integer value) {
            addCriterion("crt_uid =", value, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidNotEqualTo(Integer value) {
            addCriterion("crt_uid <>", value, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidGreaterThan(Integer value) {
            addCriterion("crt_uid >", value, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("crt_uid >=", value, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidLessThan(Integer value) {
            addCriterion("crt_uid <", value, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidLessThanOrEqualTo(Integer value) {
            addCriterion("crt_uid <=", value, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidIn(List<Integer> values) {
            addCriterion("crt_uid in", values, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidNotIn(List<Integer> values) {
            addCriterion("crt_uid not in", values, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidBetween(Integer value1, Integer value2) {
            addCriterion("crt_uid between", value1, value2, "crtUid");
            return (Criteria) this;
        }

        public Criteria andCrtUidNotBetween(Integer value1, Integer value2) {
            addCriterion("crt_uid not between", value1, value2, "crtUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidIsNull() {
            addCriterion("upd_uid is null");
            return (Criteria) this;
        }

        public Criteria andUpdUidIsNotNull() {
            addCriterion("upd_uid is not null");
            return (Criteria) this;
        }

        public Criteria andUpdUidEqualTo(Integer value) {
            addCriterion("upd_uid =", value, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidNotEqualTo(Integer value) {
            addCriterion("upd_uid <>", value, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidGreaterThan(Integer value) {
            addCriterion("upd_uid >", value, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidGreaterThanOrEqualTo(Integer value) {
            addCriterion("upd_uid >=", value, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidLessThan(Integer value) {
            addCriterion("upd_uid <", value, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidLessThanOrEqualTo(Integer value) {
            addCriterion("upd_uid <=", value, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidIn(List<Integer> values) {
            addCriterion("upd_uid in", values, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidNotIn(List<Integer> values) {
            addCriterion("upd_uid not in", values, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidBetween(Integer value1, Integer value2) {
            addCriterion("upd_uid between", value1, value2, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdUidNotBetween(Integer value1, Integer value2) {
            addCriterion("upd_uid not between", value1, value2, "updUid");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNull() {
            addCriterion("upd_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIsNotNull() {
            addCriterion("upd_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdTimeEqualTo(Date value) {
            addCriterion("upd_time =", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotEqualTo(Date value) {
            addCriterion("upd_time <>", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThan(Date value) {
            addCriterion("upd_time >", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("upd_time >=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThan(Date value) {
            addCriterion("upd_time <", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeLessThanOrEqualTo(Date value) {
            addCriterion("upd_time <=", value, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeIn(List<Date> values) {
            addCriterion("upd_time in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotIn(List<Date> values) {
            addCriterion("upd_time not in", values, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeBetween(Date value1, Date value2) {
            addCriterion("upd_time between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andUpdTimeNotBetween(Date value1, Date value2) {
            addCriterion("upd_time not between", value1, value2, "updTime");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapIsNull() {
            addCriterion("fuel_tank_cap is null");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapIsNotNull() {
            addCriterion("fuel_tank_cap is not null");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapEqualTo(Integer value) {
            addCriterion("fuel_tank_cap =", value, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapNotEqualTo(Integer value) {
            addCriterion("fuel_tank_cap <>", value, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapGreaterThan(Integer value) {
            addCriterion("fuel_tank_cap >", value, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapGreaterThanOrEqualTo(Integer value) {
            addCriterion("fuel_tank_cap >=", value, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapLessThan(Integer value) {
            addCriterion("fuel_tank_cap <", value, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapLessThanOrEqualTo(Integer value) {
            addCriterion("fuel_tank_cap <=", value, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapIn(List<Integer> values) {
            addCriterion("fuel_tank_cap in", values, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapNotIn(List<Integer> values) {
            addCriterion("fuel_tank_cap not in", values, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapBetween(Integer value1, Integer value2) {
            addCriterion("fuel_tank_cap between", value1, value2, "fuelTankCap");
            return (Criteria) this;
        }

        public Criteria andFuelTankCapNotBetween(Integer value1, Integer value2) {
            addCriterion("fuel_tank_cap not between", value1, value2, "fuelTankCap");
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