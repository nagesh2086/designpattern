package org.me.design.pattern;
import java.util.*;

/* Interface for Strategy */
interface OfferStrategy {
    public String getName();
    public double getDiscountPercentage();
}
/* Concrete implementation of base Strategy */
class NoDiscountStrategy implements OfferStrategy{
    public String getName(){
        return this.getClass().getName();
    }
    public double getDiscountPercentage(){
        return 0;
    }
}
/* Concrete implementation of base Strategy */
class QuarterDiscountStrategy implements OfferStrategy{
    public String getName(){
        return this.getClass().getName();
    }
    public double getDiscountPercentage(){
        return 0.25;
    }
}
/* Context is optional. But if it is present, it acts as single point of contact
   for client. 

   Multiple uses of Context
   1. It can populate data to execute an operation of strategy
   2. It can take independent decision on Strategy creation. 
   3. In absence of Context, client should be aware of concrete strategies. Context acts a wrapper and hides internals
   4. Code re-factoring will become easy
*/
class StrategyContext {
    double price; // price for some item or air ticket etc.
    Map<String,OfferStrategy> strategyContext = new HashMap<String,OfferStrategy>();
    StrategyContext(double price){
        this.price= price;
        strategyContext.put(NoDiscountStrategy.class.getName(),new NoDiscountStrategy());
        strategyContext.put(QuarterDiscountStrategy.class.getName(),new QuarterDiscountStrategy());        
    }
    public void applyStrategy(OfferStrategy strategy){
        /* 
        Currently applyStrategy has simple implementation. You can use Context for populating some more information,
        which is required to call a particular operation            
        */
        System.out.println("Price before offer :"+price);
        double finalPrice = price - (price*strategy.getDiscountPercentage());
        System.out.println("Price after offer:"+finalPrice);
    }
    public OfferStrategy getStrategy(int monthNo){
        /*
            In absence of this Context method, client has to import relevant concrete Strategies everywhere.
            Context acts as single point of contact for the Client to get relevant Strategy
        */
        if ( monthNo < 6 )  {
        	return strategyContext.get(NoDiscountStrategy.class.getName());
        }else{
            return strategyContext.get(QuarterDiscountStrategy.class.getName());
        }

    }
}
public class StrategyDemo{    
    public static void main(String args[]){
        StrategyContext context = new StrategyContext(100);
        //System.out.println("Enter month number between 1 and 12");
        //int month = Integer.parseInt(args[0]);
        
        int month = new Integer(1);
        System.out.println("Month ="+month);
        OfferStrategy strategy = context.getStrategy(month);
        context.applyStrategy(strategy);
        
        System.out.println("\n\n");
        
        int month1 = new Integer(11);
        System.out.println("Month ="+month1);
        OfferStrategy strategy1 = context.getStrategy(month1);
        context.applyStrategy(strategy1);
    }

}