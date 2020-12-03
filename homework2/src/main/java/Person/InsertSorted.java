package Person;

public class InsertSorted implements SortedOrder {


    long timer;

    @Override
    public void sort(Person[] allPerson) {
        long start = System.currentTimeMillis();

        for (int out = 1; out < allPerson.length; out++) {
            Person buffer = allPerson[out];
            int in = out - 1;
            while (in >= 0 && buffer.getSex().equals(Sex.MAN) &&
                    !buffer.getSex().equals(allPerson[in].getSex())) {
                allPerson[in + 1] = allPerson[in];
                in--;
            }
            if (in >= 0 && buffer.getSex().equals(allPerson[in].getSex())) {
                while (in >= 0 && buffer.getSex().equals(allPerson[in].getSex())
                        && buffer.getAge() > allPerson[in].getAge()) {
                    allPerson[in + 1] = allPerson[in];
                    in--;
                }
            if (in >= 0 && buffer.getAge() == allPerson[in].getAge()) {
                    while (in >= 0 && buffer.getAge() == allPerson[in].getAge() &&
                            buffer.getName().compareTo(allPerson[in].getName()) < 0) {
                        allPerson[in + 1] = allPerson[in];
                        in = in - 1;
                    }
                    if (in >= 0 && buffer.getName().compareTo(allPerson[in].getName()) == 0) {
                        try {
                            throw new SortedException();
                        } catch (SortedException e) {
                            System.err.println("Имя и возраст совпали");
                        }
                    }
                }
            }
            allPerson[in+1] = buffer;
        }

        long finish = System.currentTimeMillis();
        timer = finish - start;
    }

    @Override
    public void printTimer() {
        System.out.println("Время выполнения сортировки ВСТАВКОЙ составило " + timer + " миллисекунд(ы).");
    }

}

