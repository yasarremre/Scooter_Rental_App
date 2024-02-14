/**
 * Authors
 * Deniz Mutlu 20200808042
 * Emre Yasar 20210808602
 */



public class DistanceBasedPricingStrategy extends Observable implements IPricingStrategy{
    private double costPerMeter;

    public DistanceBasedPricingStrategy(){
        this.costPerMeter = 0.5; // default value is 0.5 TL per 10 meter
    }
    public DistanceBasedPricingStrategy(double costPerMeter){
        this.costPerMeter = costPerMeter;
    }
    public double getCostPerMeter() {
        return this.costPerMeter;
    }
    public void setCostPerMeter(double costPerMeter) {
        if(costPerMeter <= 0){
            System.out.println("Cost per meter cannot be nonpositive");
        }
        else{
            if(costPerMeter < this.getCostPerMeter()){
                notifyObservers(costPerMeter, this.getCostPerMeter());
            }
            this.costPerMeter = costPerMeter;
        }
    }

    public double getCost(){
        return this.costPerMeter;
    }


    @Override
    public double calculateRentalCost(double distance) {
        //distance is in meters but we need to convert it to /100 meters type
        return Math.ceil(distance/100) * this.costPerMeter * 10;

    }


}
