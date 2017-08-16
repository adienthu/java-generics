package com.example;

import com.example.generics.Column;
import com.example.generics.DatabaseRow;
import com.example.generics.Stack;
import com.example.generics.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.crypto.Data;

/**
 * Based on the chapter on Generics in Effective Java
 */
public class Main {

    public static void main(String[] args) {
        // A Stack that accepts only strings
        Stack<String> stack = new Stack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");

        stack.forEach(System.out::println);

        // See the Utils.max method for an example of type parameters
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(200);
        list.add(34);

        System.out.println(Utils.max(list));

        // See the pushAll and popAll methods of Stack class
        // for the usage of bounded wildcards
        Stack<Number> stack2 = new Stack<>();
        List<Integer> list2 = Arrays.asList(10, 20, 30);
        stack2.pushAll(list2);
        List<Object> list3 = new ArrayList<>();
        stack2.popAll(list3);
        list3.forEach(System.out::println);

        // The Utils.max2 method shows the PECS rule
        List<Integer> list4 = new ArrayList<>();
        list4.add(1900);
        list4.add(220);
        list4.add(34);
        System.out.println(Utils.max2(list4));

        /**
         * The problem: To store heterogenous values in a map.
         * For eg. a database row may be a combination of strings, integers, floats etc.
         *
         * One solution is to use Object as the value class. The drawback with this approach is that down-casting is necessary
         * when values need to be retrieved. We need a solution that is type-safe as well.
         *
         * The alternative is to use a generic wrapper over the map. Internally, the DatabaseRow class maintains the value
         * as an Object instance but the methods for putting and getting values from the map are type-safe.
         * The put API ensures that the value's datatype matches the type encoded in Column: both have to be T.
         * The get API ensures that when a column of T is provided, a T instance is returned.
         *
         * Reference: https://gerardnico.com/wiki/design_pattern/typesafe_heterogeneous_container
         */
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Varun");
        map.put("age", 10);
        String name = (String) map.get("name");
        Integer age = (Integer) map.get("age");

        Column<String> nameCol = new Column<>(String.class);
        Column<Integer> ageCol = new Column<>(Integer.class);
        DatabaseRow row = new DatabaseRow();
        row.put(nameCol, "Varun");
        row.put(ageCol, 10);
        name = row.get(nameCol);
        age = row.get(ageCol);

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}