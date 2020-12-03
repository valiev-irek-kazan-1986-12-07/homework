package Person;



public class PersonList {

    private  Person[] allPerson;

    public Person[] getAllPerson(){
        return allPerson;
    }

    public  void setAllPerson(int quantity){
        allPerson = new Person[quantity];
        for (int personNumber = 0; personNumber <= quantity-1; personNumber++){
            allPerson[personNumber] = PersonCreator.personCreater(personNumber);
        }
    }

    public void printAllPerson(int quantity){
        for (int a =0; a <= quantity-1; a++){
            System.out.println(Person.personToString(allPerson[a]));
        }
    }




}
