import Reminder.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();

        Employee e1 = new Employee("Zbigniew", "Niemiec", 12, List.of("Skala", "Java"));
        Employee e2 = new Employee("Andrzej", "Stonoga", 12, List.of("HTML", "CSS"));
        Employee e3 = new Employee("Krzysztof", "Niski", 12, List.of("Angular", "React"));
        Employee e4 = new Employee("Krystian", "Wysoki", 12, List.of("Spring", "Java"));
        Employee e5 = new Employee("Klaudiusz", "Kawowiec", 12, List.of("Hibernate", "C#"));
        Employee e6 = new Employee("Szymon", "Laptopowy", 12, List.of("C++"));

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);
        employeeList.add(e5);
        employeeList.add(e6);

        quiz3();

//        minOperator(employeeList);
//        infiniteStreaam();

    }

    //Przeiteruj po każdym obiekcie przy pomocy streamu
    public static void forEach(List<Employee> employeeList) {
        employeeList.stream()
                .forEach(System.out::println);
    }

    //Z listy pracwoników wyświetl wszystkie imiona przy pomocy streamów
    public static void mapping(List<Employee> employeeList) {
        employeeList.stream()
                .map(employee -> employee.getName())
                .forEach(e -> System.out.println(e));
        //Inny zapis
        employeeList.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }

    public static void mappingNameAndSurname(List<Employee> employeeList) {
        employeeList.stream()
                .map(employee -> employee.getName() + " " + employee.getSurname())
                .forEach(System.out::println);
    }

    //Flatmap służy do spłaszczania, czyli np. wydobywania elementów z listy
    public static void flatMapExample(List<Employee> employeeList) {
        employeeList.stream()
                .map(Employee::getSkils)
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    public static void getListOfSkils(List<Employee> employeeList) {
        employeeList.stream()
                .map(Employee::getSkils)
                .distinct()
                .forEach(System.out::println);
    }

    public static void filtering(List<Employee> employeeList) {
        employeeList.stream()
                .map(Employee::getName)
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);

    }

    public static void limiting(List<Employee> employeeList) {
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getAge))
                .map(Employee::getName)
                .limit(10)
                .forEach(System.out::println);
    }

    public static void skip(List<Employee> employeeList) {
        employeeList.stream()
                .sorted(Comparator.comparing(Employee::getSurname))
                .skip(10)
                .forEach(System.out::println);
    }

    public static void count(List<Employee> employeeList) {
        employeeList.stream()
                .filter(element -> element.getSurname().startsWith("A"))
                .map(Employee::getSurname)
                .distinct()
                .count();
    }

    public static void minOperator(List<Employee> employeeList) {
        Employee youngest = employeeList.stream()
                .min(Comparator.comparing(Employee::getAge)).get();

        System.out.println(youngest);
    }

    public static void maxOperator(List<Employee> employeeList) {
        Employee oldest = employeeList.stream()
                .min(Comparator.comparing(Employee::getAge)).get();

        System.out.println(oldest);
    }

    //FindAny and FindFirst zwraca dowolny, albo pierwszy element spełniający kryterium
    public static void findFirstOperator(List<Employee> employeeList) {
        Employee startsWith = employeeList.stream()
                .filter(employee -> employee.getSurname().startsWith("A"))
                .findFirst()
                .get();
    }

    //AllMach zwraca booleana, czy dane założenie jest spełnione, czy nie
    public static void allMachOperator(List<Employee> employeeList) {
        boolean resoult = employeeList.stream()
                .allMatch((emp) -> emp.getSurname().startsWith("A"));
    }

    public static void anyMachOperator(List<Employee> employeeList) {
        boolean resoult = employeeList.stream()
                .allMatch((emp) -> emp.getSurname().startsWith("A"));
        System.out.println(resoult);
    }

    public static void reduceOperator(List<Employee> employeeList) {
        Integer sumOfAges = employeeList.stream()

                .map(Employee::getAge)
                .reduce((age1, age2) -> age1 + age2)
                .get();
        System.out.println(sumOfAges);
    }

    public static void reduceOperatorwithInitializedValue(List<Employee> employeeList) {
        Integer sumOfAges = employeeList.stream()
                .map(Employee::getAge)
                .reduce(0, Integer::sum);
        System.out.println(sumOfAges);
    }

    public static void infiniteStreaam() {
        Stream<Integer> stream = Stream.iterate(1, previous -> previous + 1);
        stream.forEach(System.out::println);
    }

    //Policzenie ilości pracowników
    public static void countQuantityOfEmplyes(List<Employee> employeeList) {
        long count = employeeList.stream()
                .count();
        System.out.println(count);
    }

    public static void findAny(List<Employee> employeeList) {
        try {
            Employee employee = employeeList.stream()
                    .findAny()
                    .get();
        } catch (Exception e) {
            System.err.println("Exeptiono occured" + e);
        }
    }

    public static void linkedHashSet(List<Employee> employeeList) {
        employeeList.stream()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    public static void toTreeSet() {
        Set<String> mySet = Set.of("String");
        mySet.stream()
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public static void collectortJoining() {
        List<String> example = List.of("Hello", "world");
        String resoult = example.stream()
                .collect(Collectors.joining(",", "Begin", "Exit"));

        System.out.println(resoult);

    }

    public static void ownCollectors(List<String> chars) {
        Set<String> collect = chars.stream()
                .collect(
                        () -> new TreeSet<>(),
                        (existingSet, nextElement) -> existingSet.add(nextElement),
                        (leftColl, rightColl) -> leftColl.addAll(rightColl)
                );
        //.collect(
        // TreeSet::new,
        // TreeSet::add,
        // TreeSet::addAll
        //);
        System.out.println(collect);
    }

    public static void peeakIntermediadeMethod(List<String> employeeList) {
        //CDN.
    }

    public static void example1() {
        /*
        Rezultat:
        1.W pierwszej kolejności wykonuje na każdym elemenice po kolei filter. Ponieważ następne jest sorted, to wykonuje filter na każdym obiekcie po koleji
        2. Sortuje w zakedlarowanej kolejności,t o drukuje jednocześnie implementując skipa i limita.
         */

        List<String> cities = Arrays.asList("Warszawa", "Gdańsk", "Łódź", "Wrocław", "Szczecin", "Zakopane");
        List<String> resoult = cities.stream()
                .peek(System.out::println)
                .filter(element -> element.length() > 5)
                .peek(System.out::println)
                .sorted(Comparator.<String>naturalOrder().reversed())
                .peek(System.out::println)
                .skip(1)
                .peek(System.out::println)
                .limit(2)
                .peek(System.out::print)
                .collect(Collectors.toList());
        System.out.println(resoult);
    }

    ;


    // IntStream, LongStream.DoubleStream
    public static void primitiveStreams() {
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7);
        //Counting sum
        integers.stream().mapToInt(value -> value).sum();
        //IntStream toInt
        IntStream myresoult = integers.stream().mapToInt(i -> i);
        System.out.println(myresoult.average());
    }

    public static void quiz1() {
        Stream<String> stream = Stream.generate(() -> "zajavka");
        Predicate<String> somePredicate = a -> a.contains("avka");
        System.out.printf("step1");
        boolean b = stream.anyMatch(somePredicate);
        System.out.printf("step2");
        boolean c = stream.allMatch(somePredicate);
        System.out.printf("step3");
        boolean d = stream.noneMatch(somePredicate);
        System.out.printf("step4");
        System.out.println("1,2,3,4,5");

    }

    public static void quiz2() {
        List<String> cities = List.of("Opole", "Niemodlin", "Szczecin");
        List<String> cities2 = List.of("Opole", "Warszawa", "Szczecin");
        List<String> cities3 = List.of("Opole", "Gdansk", "Szczecin");

        Stream.of(cities, cities2, cities3)
                .distinct()
                .peek(System.out::println);

//        System.out.println(Stream.of(cities,cities2,cities3)
//                .distinct()
//                .collect(Collectors.toList()));
//                  [[Opole, Niemodlin, Szczecin], [Opole, Warszawa, Szczecin], [Opole, Gdansk, Szczecin]]
//Collectors.partitioningBy()
    }

    public static void quiz3() {
      Stream<Integer> integerStream = Stream.of(1,2,3,4,10,2);
      Stream<Integer> filtered = integerStream.filter( a-> a>5);
        Optional<Integer> max = filtered.max((a, b) -> b - a);



    }

}























