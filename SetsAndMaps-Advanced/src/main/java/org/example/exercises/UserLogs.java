package org.example.exercises;

import com.sun.source.tree.Tree;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> userLogs = new TreeMap<>();

        while (!input.equals("end")) {

            String[] data = input.split(" ");

            String ip = data[0].split("=")[1];
            String user = data[2].split("=")[1];

            userLogs.putIfAbsent(user, new LinkedHashMap<>());

            Map<String, Integer> ipCount = userLogs.get(user);

            ipCount.putIfAbsent(ip, 0);
            int cnt = ipCount.get(ip);
            ipCount.put(ip, ipCount.get(ip) + 1);


            input = scanner.nextLine();
        }

        for (var entry : userLogs.entrySet()) {
            System.out.println(entry.getKey() + ":");
            StringBuilder sb = new StringBuilder();
            entry.getValue().entrySet().stream().forEach(inner -> {
                sb.append(String.format("%s => %d,%n", inner.getKey(), inner.getValue()));
            });

            String finalPrint = sb.substring(0, sb.length() - 2);
            System.out.println(finalPrint + ".");
        }
    }
}
