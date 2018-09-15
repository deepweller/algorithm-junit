package java8inaction.chapter2;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    public boolean test(Apple apple){
        return "red".equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
