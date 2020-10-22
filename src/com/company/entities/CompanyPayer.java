package com.company.entities;

public class CompanyPayer extends Payer {
    private Integer employeeNumber;

    public CompanyPayer() {
        super();
    }

    public CompanyPayer(String name, Double anualIncome, Integer employeeNumber) {
        super(name, anualIncome);
        this.employeeNumber = employeeNumber;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public Double taxPaid() {
        if (employeeNumber > 10){
            return super.getAnualIncome() * 0.14;
        }
        return super.getAnualIncome() * 0.16;
    }
}
