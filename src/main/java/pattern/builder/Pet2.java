package pattern.builder;

import java.time.LocalDate;

public class Pet2 {

    private Animal animal;
    private String petName;
    private String ownerName;
    private String address;
    private String telephone;
    private LocalDate dateOfBirth; //optional
    private String emailAddress; //optional

    public Pet2(Animal animal, String petName, String ownerName, String address, String telephone, LocalDate dateOfBirth, String emailAddress) {
        this.animal = animal;
        this.petName = petName;
        this.ownerName = ownerName;
        this.address = address;
        this.telephone = telephone;
        this.dateOfBirth = dateOfBirth;
        this.emailAddress = emailAddress;
    }

    public static class Builder {
        private Animal animal;
        private String petName;
        private String ownerName;
        private String address;
        private String telephone;
        private LocalDate dateOfBirth; //optional
        private String emailAddress; //optional

        public Builder withAnimal(Animal animal) {
            this.animal = animal;
            return this;
        }

        public Builder withPetName(String petName) {
            this.petName = petName;
            return this;
        }

        public Builder withOwnerName(String ownerName) {
            this.ownerName = ownerName;
            return this;
        }

        public Builder withAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder withTelephone(String telephone) {
            this.telephone = telephone;
            return this;
        }

        public Builder withDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder withEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Pet2 build() {
            //필수 멤버변수에 값이 할당되지 않으면 예외처리
            if(animal == null || petName == null || ownerName == null
                    || address == null || telephone == null) {
                throw new IllegalStateException("Cannot create Pet2");
            }

            return new Pet2(animal, petName, ownerName, address, telephone, dateOfBirth, emailAddress);
        }
    }

}
