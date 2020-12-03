package Person;

public class BubbleSorted implements SortedOrder {

    Person[] allPerson;
    long timer;

    @Override
    public void sort(Person[] allPerson) {
        long start = System.currentTimeMillis();
        for (int out = allPerson.length - 1; out > 0; out--) {
            for (int in = 0; in < out; in++)
                if (Person.personGetSex(allPerson[in]).equals(Sex.WOMAN.getSex())) {
                    if (Person.personGetSex(allPerson[in + 1]).equals(Sex.MAN.getSex())) {
                        Person buffer = allPerson[in];
                        allPerson[in] = allPerson[in + 1];
                        allPerson[in + 1] = buffer;
                    } else if ((allPerson[in].getAge() - allPerson[in + 1].getAge()) < 0) {
                        Person buffer = allPerson[in];
                        allPerson[in] = allPerson[in + 1];
                        allPerson[in + 1] = buffer;
                    } else if ((allPerson[in].getAge() - allPerson[in + 1].getAge()) == 0) {
                        if (allPerson[in].getName().compareTo(allPerson[in + 1].getName()) > 0) {
                            Person buffer = allPerson[in];
                            allPerson[in] = allPerson[in + 1];
                            allPerson[in + 1] = buffer;
                        } else if (allPerson[in].getName().compareTo(allPerson[in + 1].getName()) == 0) {
                            try {
                                throw new SortedException();
                            } catch (SortedException e) {
                                System.err.println("Имя и возраст совпали");
                            }
                        }
                    }
                } else if (Person.personGetSex(allPerson[in]).equals(Sex.MAN.getSex())) {
                    if (Person.personGetSex(allPerson[in + 1]).equals(Sex.MAN.getSex())) {
                        if ((allPerson[in].getAge() - allPerson[in + 1].getAge()) < 0) {
                            Person buffer = allPerson[in];
                            allPerson[in] = allPerson[in + 1];
                            allPerson[in + 1] = buffer;
                        } else if ((allPerson[in].getAge() - allPerson[in + 1].getAge()) == 0) {
                            if (allPerson[in].getName().compareTo(allPerson[in + 1].getName()) > 0) {
                                Person buffer = allPerson[in];
                                allPerson[in] = allPerson[in + 1];
                                allPerson[in + 1] = buffer;
                            } else if (allPerson[in].getName().compareTo(allPerson[in + 1].getName()) == 0) {
                                try {
                                    throw new SortedException();
                                } catch (SortedException e) {
                                    System.err.println("Имя и возраст совпали");
                                }
                            }
                        }
                    }
                }
        }
        long finish = System.currentTimeMillis();
        timer = finish - start;
    }

    @Override
    public void printTimer() {
        System.out.println("Время выполнения сортировки ПУЗЫРЬКОМ составило " + timer + " миллисекунд(ы).");
    }

    private void swap(int one, int two) {
        Person buffer = allPerson[one];
        allPerson[one] = allPerson[two];
        allPerson[two] = buffer;
    }
}
