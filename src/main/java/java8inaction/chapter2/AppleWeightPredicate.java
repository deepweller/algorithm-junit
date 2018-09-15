package java8inaction.chapter2;

public class AppleWeightPredicate implements ApplePredicate {
    public boolean test(Apple apple){
        return apple.getWeight() > 150;
    }
}
