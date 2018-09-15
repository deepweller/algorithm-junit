package pattern;

import org.junit.Before;
import org.junit.Test;
import pattern.builder.Animal;
import pattern.builder.Pet;
import pattern.builder.Pet2;
import pattern.builder.Pet3;

public class BuilderTest {

    @Before
    public void makeInstanceTest() {

        Pet pet = new Pet();
        pet.setAnimal(Animal.Cat);
        pet.setPetName("멍멍이");
        pet.setOwnerName("Jinyeong");
        pet.setAddress("Seoul");
        pet.setTelephone("01012341234");

        Pet3 pet3 = Pet3.builder(Animal.Cat, "멍멍이","Jinyeong", "Seoul", "01012341234")
                .build();
    }

    @Test(expected = IllegalStateException.class)
    public void errorTest() {

        //withtTelephone 누락
        Pet2 pet2 = new Pet2.Builder()
                .withAnimal(Animal.Cat)
                .withPetName("멍멍이")
                .withOwnerName("Jinyeong")
                .withAddress("Seoul")
                .build();
    }

}
