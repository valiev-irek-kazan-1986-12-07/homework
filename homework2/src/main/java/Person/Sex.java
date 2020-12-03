package Person;

public enum Sex {
    MAN ("man"),

    WOMAN ("woman");

    private String sex;


   Sex(String sex){
        this.sex = sex;
    }


    public String getSex(){
        return sex;
    }

}
