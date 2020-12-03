package Person;

import java.util.Random;

public class PersonCreator {
    public static Person personCreater(int serialNumber){
        String intermediateName = "";
        int intermediateAge = 0;
        Sex intermediateSex;
            Random numberOfLetters = new Random();
            int nameLength = numberOfLetters.nextInt(10);
            Random r = new Random();
            StringBuilder sb = new StringBuilder(nameLength);
            for(int i = 0; i < nameLength; i++) {
                char tmp = (char) ('a'+ r.nextInt(26));
                sb.append(tmp);
            }
            intermediateName= sb.toString() + "ahdb";
            Random numberOfYears = new Random();
            intermediateAge = numberOfYears.nextInt(101);
            if ((serialNumber +  intermediateAge) % 2 == 0){
                intermediateSex = Sex.WOMAN;
            } else {
                intermediateSex = Sex.MAN;
            }
        return new Person(intermediateName, intermediateAge, intermediateSex);
    }
}
