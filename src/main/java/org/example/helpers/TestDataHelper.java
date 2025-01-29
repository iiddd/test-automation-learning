package org.example.helpers;

import org.example.models.db.Puppy;
import org.example.utils.UuidGenerator;

public class TestDataHelper {

    public static Puppy createDummyPuppy() {
        Puppy puppy = new Puppy();
        puppy.setId(7);
        puppy.setFirstName("New");
        puppy.setLastName("Puppy");
        puppy.setAddress("Country");
        puppy.setAccountNumber(UuidGenerator.generateUuid());
        puppy.setMobileNumber("1111");
        puppy.setEmailAddress("newpuppy@mail.com");
        puppy.setAccountBalance(1);
        puppy.setCreatedById(1);
        return puppy;
    }
}
