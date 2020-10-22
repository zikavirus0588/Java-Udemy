package com.company.entities;

public class IndividualPayer extends Payer {
    private Double healthExpenditures;

    public IndividualPayer() {
        super();
    }

    public IndividualPayer(String name, Double anualIncome, Double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    public Double getHealthExpenditures() {
        return healthExpenditures;
    }

    public void setHealthExpenditures(Double healthExpenditures) {
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public Double taxPaid() {
        if (super.getAnualIncome() < 20000.0){
            return (super.getAnualIncome() * 0.15) - (healthExpenditures * 0.50);
        }
        return (super.getAnualIncome() * 0.25) - (healthExpenditures * 0.50);
    }
}
