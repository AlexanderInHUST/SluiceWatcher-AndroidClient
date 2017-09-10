package com.project.tangyifeng.bigchuangiotproject.mysql;

/**
 * Author: Alexander
 * Email: yifengtang@hustunique.com
 * Since: 2017/9/10.
 */

public class MySqlColumnValue {

    private Object value;
    private Integer type;

    public MySqlColumnValue() {}

    public MySqlColumnValue(Integer type, Object value) {
        setType(type);
        setValue(value);
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object name) {
        this.value = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
