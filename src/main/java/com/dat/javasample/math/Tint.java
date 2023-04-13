package com.dat.javasample.math;

import java.util.*;

public class Tint {
    public static void main(String[] args) {
        HashMap<String, Set<String>> cities = new HashMap<>();
        Set<String> a = new HashSet<>();
        a.add("C");
        a.add("D");
        a.add("G");
        a.add("F");
        a.add("I");
        Set<String> c = new HashSet<>();
        c.add("D");
        c.add("G");
        a.add("A");
        Set<String> d = new HashSet<>();
        d.add("A");
        d.add("C");
        d.add("G");
        Set<String> g = new HashSet<>();
        g.add("C");
        g.add("D");
        g.add("A");
        Set<String> b = new HashSet<>();
        b.add("H");
        b.add("K");
        b.add("L");
        Set<String> h = new HashSet<>();
        h.add("B");
        h.add("K");
        h.add("L");
        Set<String> k = new HashSet<>();
        k.add("B");
        k.add("H");
        k.add("L");
        Set<String> e = new HashSet<>();
        e.add("J");
        e.add("L");
        Set<String> j = new HashSet<>();
        j.add("E");
        j.add("L");
        Set<String> l = new HashSet<>();
        l.add("B");
        l.add("H");
        l.add("K");
        l.add("E");
        l.add("J");
        Set<String> f = new HashSet<>();
        f.add("A");
        f.add("I");
        Set<String> i = new HashSet<>();
        i.add("A");
        i.add("F");
        cities.put("A", a);
        cities.put("C", c);
        cities.put("D", d);
        cities.put("G", g);
        cities.put("B", b);
        cities.put("H", h);
        cities.put("K", k);
        cities.put("E", e);
        cities.put("J", j);
        cities.put("L", l);
        cities.put("F", f);
        cities.put("I", i);
        System.out.println(tint1(cities));
        System.out.println(tint2(cities));
    }

    public static int tint1(HashMap<String, Set<String>> cities) {
        int count = 0;
        Set<String> pass = new HashSet<>();
        for (String city : cities.keySet()) {
            if (!pass.contains(city)) {
                for (String t : cities.keySet())
                    pass.add(t);
                for (String not : cities.get(city))
                    pass.remove(not);
                count++;
            }
        }
        return count;
    }

    private static class Level {
        private String name;
        private int level;

        public Level(String name, int level) {
            this.name = name;
            this.level = level;
        }

        public String getName() {
            return name;
        }

        public int getLevel() {
            return level;
        }
    }

    public static int tint2(HashMap<String, Set<String>> cities) {
        ArrayList<Level> levels = new ArrayList<>();
        for (String city : cities.keySet())
            levels.add(new Level(city, cities.get(city).size()));
        levels.sort((o1, o2) -> {
            if (o1.getLevel() < o2.getLevel()) return 1;
            return -1;
        });
        int count = 0;
        Set<String> pass = new HashSet<>();
        for (var i : levels) {
            if (!pass.contains(i.getName())) {
                for (String t : cities.keySet())
                    pass.add(t);
                for (String not : cities.get(i.getName()))
                    pass.remove(not);
                count++;
            }
        }
        return count;
    }
}
