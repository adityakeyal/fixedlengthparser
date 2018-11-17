package com.adityak.parser.fixedlength;

public class TestData {


        private String name;
        private String date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "name='" + name + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
