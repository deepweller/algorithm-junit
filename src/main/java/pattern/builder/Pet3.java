package pattern.builder;

import lombok.Builder;

import java.time.LocalDate;

@Builder(builderMethodName = "hiddenBuilder")
public class Pet3 {

    private Animal animal;
    private String petName;
    private String ownerName;
    private String address;
    private String telephone;
    private LocalDate dateOfBirth; //optional
    private String emailAddress; //optional

//    public static Pet3Builder builder(Animal animal, String petName, String ownerName, String address, String telephone) {
//        return hiddenBuilder()
//                .animal(animal)
//                .petName(petName)
//                .ownerName(ownerName)
//                .address(address)
//                .telephone(telephone);
//    }
}
