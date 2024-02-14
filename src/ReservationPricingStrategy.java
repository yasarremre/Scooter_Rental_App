/**
 * Authors
 * Emre Yasar 20210808602
 */



public class ReservationPricingStrategy extends Observable implements IPricingStrategy{
    private double costPerMinute;

    public ReservationPricingStrategy(double costPerMinute){
        this.costPerMinute = costPerMinute;
    }
    public ReservationPricingStrategy(){
        this.costPerMinute = 1;
    }
    public void setCostPerMinute(double costPerMinute) {
        if (costPerMinute <= 0) {
            System.out.println("Cost per minute cannot be nonpositive");
        } else {
            if (costPerMinute < this.getCostPerMinute()) {
                notifyObservers(costPerMinute, this.getCostPerMinute());
            }
            this.costPerMinute = costPerMinute;
        }
    }
    public double getCostPerMinute() {
        return this.costPerMinute;
    }

    public double getCost(){
        return this.costPerMinute;
    }

    @Override
    public double calculateRentalCost(double duration) {
        return duration * costPerMinute;

    }
}

