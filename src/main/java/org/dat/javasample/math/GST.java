package org.dat.javasample.math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class GST {
    private static void gst1(String start, HashMap<String, HashMap<String, Double>> cities) {
        String index = start;
        ArrayList<String> tour = new ArrayList<>();
        double cost = 0;
        Set<String> pass = new HashSet<>();
        pass.add(start);
        for (int i = 0; i < cities.size() - 1; i++) {
            String w = null;
            double min = Double.MAX_VALUE;
            for (String k : cities.get(index).keySet()) {
                double v = cities.get(index).get(k);
                if (v < min && !pass.contains(k)) {
                    min = v;
                    w = k;
                }
            }
            System.out.println(index + " -" + min + "-> " + w);
            pass.add(w);
            tour.add(w);
            cost += min;
            index = w;
        }
        tour.add(start);
        cost += cities.get(index).get(start);
        System.out.println(tour);
        System.out.println(cost);
    }

    public static void gst2(ArrayList<String> starts, HashMap<String, HashMap<String, Double>> cities) {
        double bestCost=Double.MAX_VALUE;
        ArrayList<String> bestTour=new ArrayList<>();
        for (String start : starts) {
            String index = start;
            ArrayList<String> tour = new ArrayList<>();
            double cost = 0;
            Set<String> pass = new HashSet<>();
            pass.add(start);
            for (int i = 0; i < cities.size() - 1; i++) {
                String w = null;
                double min = Double.MAX_VALUE;
                for (String k : cities.get(index).keySet()) {
                    double v = cities.get(index).get(k);
                    if (v < min && !pass.contains(k)) {
                        min = v;
                        w = k;
                    }
                }
                System.out.println(index + " -" + min + "-> " + w);
                pass.add(w);
                tour.add(w);
                cost += min;
                index = w;
            }
            tour.add(start);
            cost += cities.get(index).get(start);
            if(cost<bestCost){
                bestCost=cost;
                bestTour=tour;
            }
        }
        System.out.println(bestTour);
        System.out.println(bestCost);
    }

    public static void main(String[] args) {
        HashMap<String, HashMap<String, Double>> cities = new HashMap<>();
        HashMap<String, Double> a = new HashMap<>();
        a.put("2", 20.0);
        a.put("3", 42.0);
        a.put("4", 31.0);
        a.put("5", 6.0);
        a.put("6", 24.0);
        HashMap<String, Double> b = new HashMap<>();
        b.put("1", 10.0);
        b.put("3", 17.0);
        b.put("4", 6.0);
        b.put("5", 35.0);
        b.put("6", 18.0);
        HashMap<String, Double> c = new HashMap<>();
        c.put("1", 25.0);
        c.put("2", 5.0);
        c.put("4", 27.0);
        c.put("5", 14.0);
        c.put("6", 9.0);
        HashMap<String, Double> d = new HashMap<>();
        d.put("1", 12.0);
        d.put("2", 9.0);
        d.put("3", 24.0);
        d.put("5", 30.0);
        d.put("6", 12.0);
        HashMap<String, Double> e = new HashMap<>();
        e.put("1", 14.0);
        e.put("2", 7.0);
        e.put("3", 21.0);
        e.put("4", 15.0);
        e.put("6", 38.0);
        HashMap<String, Double> f = new HashMap<>();
        f.put("1", 40.0);
        f.put("2", 15.0);
        f.put("3", 16.0);
        f.put("4", 5.0);
        f.put("5", 20.0);
        cities.put("1", a);
        cities.put("2", b);
        cities.put("3", c);
        cities.put("5", e);
        cities.put("4", d);
        cities.put("6", f);
        ArrayList p=new ArrayList<>();
        p.add("1");
        p.add("2");
        p.add("3");
        p.add("4");
        p.add("5");
        p.add("6");
        gst2(p, cities);
    }
}