package com.worldance.test.stream;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class StreamApplicationTests {

    @Test
    void contextLoads() {
        TestClass1 inst1 = new TestClass1();
        Student student = new Student();
        student.setName("name1");
        student.setAge(1);

        inst1.setA("1");
        inst1.setB(2L);
        inst1.setC(3);
        inst1.setB1(2L);
        inst1.setC1(3);
        inst1.setD(4L);
        inst1.setStudent(student);


        TestClass1 inst2 =  (TestClass1) inst1.clone();
        inst2.setA("11");
        inst2.setB(22L);
        inst2.setC(33);
        inst2.setB1(22L);
        inst2.setC1(33);
        inst2.setD(44L);
        inst2.getStudent().setName("name2");
        inst2.getStudent().setAge(2);

        System.out.println(inst1.toString());
        System.out.println(inst2.toString());
    }

    class Student implements Cloneable {
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    class TestClass1 extends TestClass {
        private Long d;
        private Student student;

        public Long getD() {
            return d;
        }

        public void setD(Long d) {
            this.d = d;
        }

        public Student getStudent() {
            return student;
        }

        public void setStudent(Student student) {
            this.student = student;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(super.toString());
            sb.append("d:").append(this.d).append(";");
            sb.append("student.name:").append(this.student.getName()).append(";");
            sb.append("student.age:").append(this.student.getAge()).append(";");
            return sb.toString();
        }
    }

    class TestClass implements Cloneable {
        private String a;
        private long b;
        private int c;
        private Long b1;
        private Integer c1;

        public String getA() {
            return a;
        }

        public void setA(String a) {
            this.a = a;
        }

        public int getC() {
            return c;
        }

        public void setC(int c) {
            this.c = c;
        }

        public void setB(long b) {
            this.b = b;
        }

        public Long getB1() {
            return b1;
        }

        public void setB1(Long b1) {
            this.b1 = b1;
        }

        public Integer getC1() {
            return c1;
        }

        public void setC1(Integer c1) {
            this.c1 = c1;
        }

        @Override
        public String toString() {
            StringBuffer strsb = new StringBuffer();
            strsb.append("a:").append(this.a).append(";");
            strsb.append("b:").append(this.b).append(";");
            strsb.append("c:").append(this.c).append(";");
            strsb.append("b1:").append(this.b1).append(";");
            strsb.append("c1:").append(this.c1).append(";");
            return strsb.toString();
        }

        public TestClass clone() {
            TestClass cloneObject = null;
            try {
                cloneObject = (TestClass) super.clone();
            }
            catch (CloneNotSupportedException e) {
            }
            return cloneObject;
        }
    }

    @Test
    void streamCreate() {
        // ???????????????
        List<String> list = Arrays.asList("a", "b", "c", "d");
        Stream<String> listStream = list.stream();
        Stream<String> listParallelStream = list.parallelStream();

        // ???????????????
        String[] array = {"a", "b", "c", "d"};
        Stream<String> arrayStream = Arrays.stream(array);

        // ??????Stream???????????????
        Stream<Integer> ofStream = Stream.of(1, 2, 3, 4, 5);

        Stream<Integer> iterateStream = Stream.iterate(1, x -> x + 3).limit(5);
        iterateStream.forEach(x -> System.out.println(x));

        Stream<Integer> generateStream = Stream.generate(() -> {
            Random r = new Random();
            return r.nextInt(3);
        }).limit(10);
        generateStream.forEach(System.out :: println);
    }

    @Test
    void testMatch(List<Person> personList ) {
        System.out.println("###########????????????/?????????foreach/find/match???###########");

        System.out.println();
        System.out.println("????????????????????????30????????????????????????");
        Optional<Person> person1 = personList.stream().filter(person -> person.age == 30).findFirst();
        System.out.println(person1.get().name + ":" + person1.get().age);


        System.out.println();
        System.out.println("???????????????????????????30????????????????????????");
        Optional<Person> person2 = personList.stream().filter(person -> person.age == 30).findAny();
        System.out.println(person2.get().name + ":" + person2.get().age);

        System.out.println();
        System.out.println("?????????????????????30?????????:");
        Boolean flag = personList.stream().anyMatch(person -> person.age == 30);
        System.out.print(flag);
    }

    void testFilter(List<Person> personList) {
        System.out.println("###########???????????????filter???###########");
        System.out.print("??????????????????8000???????????????:");
        List<String> persons = personList.stream().filter(person -> person.salary > 8000).map(person -> person.name).collect(Collectors.toList());
        System.out.println(persons);
    }

    @Test
    void testAggregation(List<Person> personList) {
        System.out.println("###########??????3.3 ?????????max/min/count)###########");
        System.out.print("??????????????????????????????:");
        Optional<Person> maxPerson = personList.stream().max(Comparator.comparing(Person :: getSalary));
        System.out.println(maxPerson.get().name + ":" + maxPerson.get().salary);

        System.out.print("??????????????????????????????:");
        Optional<Person> minPerson = personList.stream().min((person1, person2) -> {
            if (person1.salary < person2.salary) {
                return -1;
            }
            return 1;
        });
        System.out.println(minPerson.get().name + ":" + minPerson.get().salary);

        System.out.print("??????????????????8500???????????????:");
        Long count = personList.stream().filter(person -> person.salary > 8500).count();
        System.out.println(count);
    }

    @Test
    void testMap(List<Person> personList) {
        System.out.println("###########??????3.4 ??????(map/flatMap)###########");
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        System.out.println("????????????????????????????????????????????????" + Arrays.asList(strArr));
        List<String> newStrList = Arrays.stream(strArr).map(String :: toUpperCase).collect(Collectors.toList());
        System.out.println("map,????????????????????????????????????????????????" + newStrList);

        List<String> newStrList1 =  Arrays.stream(strArr).flatMap(s -> {
            return Arrays.stream(s.toUpperCase().split(","));
        }).collect(Collectors.toList());
        System.out.println("flatMap????????????????????????????????????????????????" + newStrList1);

        System.out.println("????????????????????????1000???????????????????????????");
        personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).forEach(person -> {
            System.out.println(person.getName() + ": " + person.getSalary());
        });
    }

    @Test
    void testReduce(List<Person> personList) {
        System.out.println("###########????????????(reduce??????/??????/??????/??????)###########");
        Integer[] nums = {1, 4, 5, 6, 8};
        System.out.print("?????????????????????,??????1???");
        Optional<Integer> sumValue1 = Arrays.asList(nums).stream().reduce((a, b) -> a + b);
        System.out.println(sumValue1.get());

        System.out.print("?????????????????????,??????2???");
        Optional<Integer> sumValue2 = Arrays.asList(nums).stream().reduce(Integer::sum);
        System.out.println(sumValue2.get());

        System.out.print("????????????????????????");
        Optional<Integer> prodValue = Arrays.asList(nums).stream().reduce((a, b) -> a * b);
        System.out.println(prodValue.get());

        System.out.print("????????????????????????,??????1???");
        Optional<Integer> max1 = Arrays.asList(nums).stream().reduce((a, b) -> a > b ? a : b);
        System.out.println(max1.get());
        System.out.print("????????????????????????,??????2???");
        Integer max2 = Arrays.asList(nums).stream().reduce(1, Integer::max);
        System.out.println(max2);

        System.out.print("????????????????????????,??????1???");
        Optional<Integer> min1 = Arrays.asList(nums).stream().reduce((a, b) -> a < b ? a : b);
        System.out.println(min1.get());
        System.out.print("????????????????????????,??????2???");
        Integer min2 = Arrays.asList(nums).stream().reduce(-5, Integer::min);
        System.out.println(min2);
        System.out.print("????????????????????????,??????3???");
        Optional<Integer> min3 = Arrays.asList(nums).stream().reduce(Integer::min);
        System.out.println(min3.get());

        System.out.print("???????????????????????????,??????1???");
        Optional<Integer> maxSalary1 = personList.stream().map(Person::getSalary).reduce(Integer::max);
        System.out.println(maxSalary1.get());

        System.out.print("???????????????????????????,??????2???");
        Integer maxSalary2 = personList.stream().reduce(0, (max, person) -> max > person.getSalary() ? max : person.getSalary(), Integer::max);
        System.out.println(maxSalary2);

        System.out.print("???????????????????????????,??????1???");
        Optional<Integer> sumSalary1 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println(sumSalary1.get());

        System.out.print("???????????????????????????,??????2???");
        Integer sumSalary2 = personList.stream().reduce(0, (sum, person) -> sum + person.getSalary(), Integer::sum);
        System.out.println(sumSalary2);

    }

    @Test
    void testCollect(List<Person> personList) {
        System.out.println("###########??????3.6 ??????(collect)###########");
        System.out.println("###########??????3.6.1 ??????(toList/toSet/toMap)###########");
        System.out.print("List?????????????????????????????????20????????????");
        List<Integer> list1 = personList.parallelStream().filter(person -> person.getAge() > 20).map(Person::getAge).collect(Collectors.toList());
        System.out.println(list1);
        System.out.print("Set?????????????????????????????????20????????????");
        Set<Integer> list2 = personList.parallelStream().filter(person -> person.getAge() > 20).map(Person::getAge).collect(Collectors.toSet());
        System.out.println(list2);

        System.out.print("toMap?????????????????????????????????20????????????");
        Map<Integer, Person> map3 = personList.parallelStream().filter(person -> person.getAge() > 20).collect(Collectors.toMap(Person::getAge, Function
            .identity()));
        System.out.println(map3);


        System.out.println("###########??????3.6.2 ??????(count/averaging)###########");
        System.out.print("?????????????????????");
        Long count = personList.stream().collect(Collectors.counting());
        System.out.println(count);

        System.out.print("?????????????????????");
        Optional<Integer> maxSalary = personList.stream().map(Person::getSalary).collect(Collectors.maxBy(Integer::compare));
        Optional<Integer> maxSalary1 = personList.stream().map(Person::getSalary).collect(Collectors.maxBy((a, b) -> a > b ? 1 : -1));
        System.out.println(maxSalary.get() + "  " + maxSalary1.get());

        System.out.print("?????????????????????");
        Optional<Integer> minSalary = personList.stream().map(Person::getSalary).collect(Collectors.minBy(Integer::compareTo));
        System.out.println(minSalary.get());

        System.out.print("?????????????????????");
        Double averageSalary = personList.stream().collect(Collectors.averagingInt(Person::getSalary));
        System.out.println(averageSalary);

        System.out.print("?????????????????????");
        Integer totalSalary = personList.stream().collect(Collectors.summingInt(Person::getSalary));
        System.out.println(totalSalary);

        System.out.print("???????????????????????????");
        IntSummaryStatistics salaryStatic = personList.stream().collect(Collectors.summarizingInt(Person::getSalary));
        System.out.println(salaryStatic);

        System.out.println("###########??????3.6.3 ??????(partitioningBy/groupingBy)###########");
        System.out.print("partitioningBy??????????????????");
        Map<Boolean, List<Person>> groupMap1 = personList.stream().collect(Collectors.partitioningBy(person -> "male".equals(person.getSex())));
        System.out.println(groupMap1);

        System.out.print("groupingBy????????????????????????2???");
        Map<String, List<Person>> groupMap2 = personList.stream().collect(Collectors.groupingBy(Person::getSex));
        System.out.println(groupMap2);

        System.out.print("groupingBy?????????,???????????????");
        Map<String, Map<String, List<Person>>> groupMap3 = personList.stream().collect(Collectors.groupingBy(Person::getSex, Collectors.groupingBy(Person::getArea)));
        System.out.println(groupMap3);

        System.out.println("###########??????3.6.4 ??????(joining)###########");
        System.out.print("?????????????????????????????????????????????");
        String names = personList.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(names);


        System.out.println("###########??????3.6.5 ??????(reducing)###########");
        System.out.print("?????????????????????????????????");
        Integer sumSalary1 = personList.stream().collect(Collectors.reducing(0, person -> person.getSalary(), Integer::sum));
        Integer sumSalary2 = personList.stream().reduce(0, (sum, person) -> sum += person.getSalary(), Integer::sum);
        Optional<Integer> sumSalary3 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println(sumSalary1 + " " + sumSalary2 + " " + sumSalary3.get());

    }

    @Test
    void testSort(List<Person> personList) {
        System.out.println("###########??????3.7 ??????(sorted)###########");
        System.out.print("???????????????????????????????????????");
        List<Person> sortBySalaryAsc = personList.stream().sorted((a, b) -> a.getSalary() > b.getSalary() ? 1 : -1).collect(
            Collectors.toList());
        String sortBySalaryAscInfo = sortBySalaryAsc.stream().map(person -> person.getName() + ":" + person.getSalary()).collect(Collectors.joining(","));
        System.out.println(sortBySalaryAscInfo);

        System.out.print("???????????????????????????????????????");
        String sortBySalaryDescInfo = personList.stream().sorted(Comparator.comparing(Person::getSalary).reversed()).map(a -> a.getName() + ":" + a.getSalary()).collect(Collectors.joining(","));
        System.out.println(sortBySalaryDescInfo);

        System.out.print("??????????????????????????????????????????????????????????????????????????????");
        String sortBySalaryInfo = personList.stream().sorted((a, b) -> {
            if (a.getSalary() == b.getSalary()) {
                return a.getAge() - b.getAge();
            }
            else {
                return a.getSalary() - b.getSalary();
            }
        }).map(person -> person.getName() + ":" + person.getSalary() + "," + person.getAge())
            .collect(Collectors.joining(";"));
        System.out.println(sortBySalaryInfo);
    }

    @Test
    void testDistinctAndConcat(List<Person> personList) {
        System.out.println("###########??????3.8 ??????/??????###########");
        String[] arr1 = { "a", "b", "c", "d" };
        String[] arr2 = { "d", "e", "f", "g" };

        Stream<String> stream1 = Arrays.stream(arr1);
        Stream<String> stream2 = Arrays.stream(arr2);

        System.out.print("??????????????????????????????????????????");
        String disctintVal = Stream.concat(stream1, stream2).distinct().collect(Collectors.joining(","));
        System.out.println(disctintVal);

        Stream<String> stream3 = Arrays.stream(arr1);
        Stream<String> stream4 = Arrays.stream(arr2);
        System.out.print("???????????????????????????????????????,?????????????????????,?????????3????????????");
        String disctintVal1 = Stream.concat(stream3, stream4).distinct().skip(1).limit(3).collect(Collectors.joining(","));
        System.out.println(disctintVal1);
    }




    @Test
    void test() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 35, "male", "New York"));
        personList.add(new Person("Jack", 7000,50, "male", "Washington"));
        personList.add(new Person("Lily", 7000, 14, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 15, "female", "New York"));
        personList.add(new Person("Owen", 9500, 30, "male", "New York"));
        personList.add(new Person("Alisa", 8900, 40, "female", "New York"));
//        testMatch(personList);
//        testFilter(personList);
//        testAggregation(personList);
//        testMap(personList);
//        testReduce(personList);
//        testCollect(personList);
//        testSort(personList);
        testDistinctAndConcat(personList);
    }


    class Person {
        private String name;  // ??????

        private int salary; // ??????

        private int age; // ??????

        private String sex; //??????

        private String area;  // ??????

        // ????????????
        public Person(String name, int salary, int age, String sex, String area) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.sex = sex;
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }
    }
}
