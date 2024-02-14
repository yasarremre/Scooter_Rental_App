/**
 * Author
 * Emre Yasar 20210808602
 */


public class TimeBasedPricingStrategy extends Observable implements IPricingStrategy{
    private double costPerMinute;

    public TimeBasedPricingStrategy(double costPerMinute){
        this.costPerMinute = costPerMinute;
    }

    public TimeBasedPricingStrategy(){
        this.costPerMinute = 1; // default value is 1 TL per minute
    }

    public double getCostPerMinute() {
        return this.costPerMinute;
    }
    public void setCostPerMinute(double costPerMinute) {
        if(costPerMinute <= 0){
            System.out.println("Cost per minute cannot be nonpositive");
        }
        else{
            if(costPerMinute < this.getCostPerMinute()){
                notifyObservers(costPerMinute, this.getCostPerMinute());
            }
            this.costPerMinute = costPerMinute;
        }
    }

    public double getCost(){
        return this.costPerMinute;
    }

    @Override
    public double calculateRentalCost(double duration) {
        //this duration is in seconds but we need minutes
        int minute = (int) Math.ceil(duration/60);
        return minute * getCostPerMinute(); // 1TL per minute by default.
    }
}
