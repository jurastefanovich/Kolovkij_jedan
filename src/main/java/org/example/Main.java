package org.example;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Primjeri vezani uz koristenje consumer interfacea");
//      Primjer moguceg koristenja preko klase
        ConsumerDemo consumerDemo = new ConsumerDemo();
        consumerDemo.accept(1);

//      Primjer izravnog kosristenja consumer interfacea
        Consumer<Integer> consumer = (t) -> System.out.println("Printing t using lambda: " + t);
        consumer.accept(10);

//      Primjer koristenja consumer interfacea unutar forEach petlje koja kao argument prima consumer interface
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.forEach(consumer);


        System.out.println();

        System.out.println("Primjeri vezani uz koristenje predicate interfacea");

//      Primjeri koristenja klase koja nasljeduje Predicate sucelje
        PredicateDemo predicateDemo = new PredicateDemo();
        System.out.println(predicateDemo.test(10));
        System.out.println(predicateDemo.test(5));

//      Primjer izravnog koristenja predicate interfacea
        Predicate<Integer> predicate = p -> {return p % 2 == 0;};
        System.out.println(predicate.test(8));
        System.out.println(predicate.test(72));

//      Primjer koristenja filter metode koja prima predicate u kombinaciji sa forEach metodom koja prima consumer od prije
//      Consumer<Integer> consumer = (t) -> System.out.println("Printing t using lambda: " + t);
        List<Integer> listp = Arrays.asList(1,2,3,4,5);
        listp.stream().filter(predicate).forEach(consumer);


        System.out.println();
        System.out.println("Primjeri vezani uz koristenje supplier interfacea");

//      Primjeri koristenja klase koja nasljeduje Supplier sucelje
        SupplierDemo supplierDemo = new SupplierDemo();
        System.out.println(supplierDemo.get());

//      Primjer izravnog koristenja Supplier interfacea
        Supplier<String> supplier = () -> {return "Hi from interface";};
        System.out.println(supplier.get());

        Supplier<String> emptyListSupplier = () -> {return  "This list is empty";};
        //Punimo listu hardcodiranim elementima
        ArrayList<String> list1 = new ArrayList<>(){
            {add("a");}
            {add("b");}
        };
        //Lista nije prazna pa ce vratiti element
        System.out.println(list1.stream().findAny().orElseGet(emptyListSupplier));
        //Praznimo listu
//        list1.clear();
        //Lista vraca vrijednost supplier-a jer je prazna
        System.out.println(list1.stream().findAny().orElseGet(emptyListSupplier));


        System.out.println();

        System.out.println("Primjeri vezani uz function interface");
//      Primjer koristenja klase koja nasljeduje funkcionalno sucelje Function
        FunctionDemo functionDemo = new FunctionDemo();
        System.out.println(functionDemo.apply(10));

//      Primjer koristenja fukcionalnog sučelja Function
        Function<Integer, String> getMultiplied = integer -> {return integer*10 + " string direktno iz sucelja";};
        System.out.println(getMultiplied.apply(10));

//      Primjer koristenja sucelja Function unutar lambda metode map koja prima Functional kao parametar
        List<Integer> listf = Arrays.asList(1,2,3,4,5);
        var lista = listf.stream().map(getMultiplied);
        lista.forEach(System.out::println);
    }
}