package java8inaction.chapter2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.*;

import static org.hamcrest.CoreMatchers.is;

public class AppleFilteringTest {

    AppleFilter appleFilter;
    List<Apple> inventory;

    @Before
    public void setInventory() {
        appleFilter = new AppleFilter();

        inventory = Arrays.asList(
                new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"),
                new Apple(70, "red")
        );
    }

    @Test
    public void 사과_필터링() {
        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = appleFilter.filterApplesByColor(inventory, "green");
        Assert.assertThat(greenApples.get(0).getColor(), is("green"));

        // [Apple{color='red', weight=120}]
        List<Apple> redApples = appleFilter.filterApplesByColor(inventory, "red");
        Assert.assertThat(redApples.get(0).getColor(), is("red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = appleFilter.filter(inventory, new AppleColorPredicate());
        // 클래스로 감싸긴 하지만 boolean 을 리턴하는 메서드(동작)를 전달함
        Assert.assertThat(greenApples2.get(0).getColor(), is("green"));

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples = appleFilter.filter(inventory, new AppleWeightPredicate());
        Assert.assertTrue(heavyApples.get(0).getWeight() > 150);

        // []
        List<Apple> redAndHeavyApples = appleFilter.filter(inventory, new AppleRedAndHeavyPredicate());
        Assert.assertTrue(redAndHeavyApples.size() == 0);

        // [Apple{color='red', weight=120}]
        List<Apple> redApples2 = appleFilter.filter(inventory, new ApplePredicate() {
            public boolean test(Apple a){
                return a.getColor().equals("red");
            }
        });
        Assert.assertThat(redApples2.get(0).getColor(), is("red"));


    }

    @Test
    public void 사과_필터링_java8() {
        //java8
        List<Apple> result = appleFilter.filter(inventory, (Apple apple) -> "red".equals(apple.getColor()));
        Assert.assertThat(result.get(0).getColor(), is("red"));
    }

    @Test
    public void 사과_정렬_java8() {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
        Assert.assertThat(inventory.get(0).getWeight(), is(70));

        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        Assert.assertThat(inventory.get(0).getWeight(), is(70));

        inventory.sort(Comparator.comparing(Apple::getWeight));
        Assert.assertThat(inventory.get(0).getWeight(), is(70));
    }

    @Test
    public void 폴더_숨김항목_필터링() {
        File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isHidden();
            }
        });
        File[] hiddenFiles2 = new File(".").listFiles(File::isHidden);
        File[] hiddenFiles3 = new File(".").listFiles(file -> file.isHidden());
    }
}
