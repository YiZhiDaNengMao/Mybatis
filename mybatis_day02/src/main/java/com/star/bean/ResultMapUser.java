package com.star.bean;

import java.util.Objects;

public class ResultMapUser {

    private int id;
    private String rm_name;
    private int rm_age;

    public ResultMapUser() {
    }

    public ResultMapUser(int id, String rm_name, int rm_age) {
        this.id = id;
        this.rm_name = rm_name;
        this.rm_age = rm_age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRm_name() {
        return rm_name;
    }

    public void setRm_name(String rm_name) {
        this.rm_name = rm_name;
    }

    public int getRm_age() {
        return rm_age;
    }

    public void setRm_age(int rm_age) {
        this.rm_age = rm_age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResultMapUser that = (ResultMapUser) o;
        return id == that.id && rm_age == that.rm_age && Objects.equals(rm_name, that.rm_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rm_name, rm_age);
    }

    @Override
    public String toString() {
        return "ResultMapUser{" +
                "id=" + id +
                ", rm_name='" + rm_name + '\'' +
                ", rm_age=" + rm_age +
                '}';
    }
}
