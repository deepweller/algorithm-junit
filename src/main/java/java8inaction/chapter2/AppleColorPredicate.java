package java8inaction.chapter2;

public class AppleColorPredicate implements ApplePredicate {
    public boolean test(Apple apple){
        return "green".equals(apple.getColor());
    }
}
