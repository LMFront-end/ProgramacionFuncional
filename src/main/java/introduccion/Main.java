package introduccion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static introduccion.Main.Gender.FEMALE;
import static introduccion.Main.Gender.MALE;

public class Main {

    public static void main(String[] args) {
        // programación imperativa -> es decir, como una secuencia de operaciones a realizar.
        // programación declarativa -> es decir, se especifica el resultado deseado, no cómo lograrlo.

        List<Student> students = List.of(
            new Student("Lina", "Guerrero", 23, FEMALE),
            new Student("Mateo", "Vlad", 25, MALE),
            new Student("Santiago", "Vlad", 30, MALE),
            new Student("Camila", "Savaraín", 24, FEMALE),
            new Student("Juan Pablo", "0'Brien", 27, MALE),
            new Student("Pablo", "Saavedra", 23, MALE)
        );

        // forma imperativa
        for (Student student: students){
            // se deja a la izquierda el valor fijo, no el variable

            // imprimir todos los hombres de la lista
            if(MALE.equals(student.gender)){
                System.out.println(student);
            }
        }

        List<Student> females = new ArrayList<>();
        for (Student student: students){
            // se deja a la izquierda el valor fijo, no el variable
            // imprimir todos los hombres de la lista
            if(FEMALE.equals(student.gender)){
                females.add(student);
            }
        }
        System.out.println("Estudiantes mujeres: \n" );
        for(Student student: females){
            System.out.println(student);
        }

        //forma declarativa
        System.out.println("Programación declarativa");

        students.stream()
                // expresión lambda
                .filter(student ->  MALE.equals(student.gender))
                // colección
                .collect(Collectors.toList())
                // imprima el elemento que estoy iterando
                .forEach(System.out::println);

        System.out.println("*************");

        // generar una lista de solo mujeres
        students.stream().filter(student -> FEMALE.equals(student.gender))
                .collect(Collectors.toList())
                .forEach(System.out::println);


        // ********************************************

        System.out.println("***********************");
        // forma imperativa
        List<Person> people = new ArrayList<>();
        for(Student student: students){
            Person person = new Person(student.name, student.lastName);
            people.add(person);
        }

        for(Person person: people){
            System.out.println(person);
        }

        // forma declarativa
        System.out.println("Programacion declarativa");
        students.stream()
                .map(student ->
                    new Person(student.name, student.lastName))
                .collect(Collectors.toList())
                .forEach(System.out::println);


    }
    static class Person{
        private final String firstName;
        private final String lastName;
        //private final String email;

        public Person(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
            //this.email = email;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }


    static class Student{
        private final String name;
        private final String lastName;
        private final int age;
        private final Gender gender;

        // Se crea un constructor
        public Student(String name, String lastName, int age, Gender gender) {
            this.name = name;
            this.lastName = lastName;
            this.age = age;
            this.gender = gender;
        }

        // sobre escribir el metodo a string
        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        FEMALE,
        MALE
    }
}
