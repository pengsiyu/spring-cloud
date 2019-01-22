package com.pengsiyu.ribbon.entity;

public class SalarySum {
    private Integer salarySum;
    private Integer peopleNumber;

    public Integer getSalarySum() {
        return salarySum;
    }

    public void setSalarySum(Integer salarySum) {
        this.salarySum = salarySum;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    @Override
    public String toString() {
        return "SalarySum{" +
                "salarySum=" + salarySum +
                ", peopleNumber=" + peopleNumber +
                '}';
    }
}
