package com.gslonim.coding.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CountSubDomains {
    public static List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> visitCounter = new HashMap<>();

        for (int i = 0; i < cpdomains.length; i++) {
            DomainVisit visit = new DomainVisit(cpdomains[i]);
            for (int count = 0; count < visit.subdomains.length; count++) {
                visitCounter
                        .merge(visit.subdomains[count], visit.getCount(), Integer::sum);
            }
        }

        return visitCounter.entrySet().stream()
                .map(entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }

    static class DomainVisit {
        private final int count;
        private final String[] subdomains;

        DomainVisit(String cpvisit) {
            String[] visitAndCount = cpvisit.split(" ");
            this.count = Integer.parseInt(visitAndCount[0]);
            this.subdomains = subdomains(visitAndCount[1]);
        }

        String[] subdomains(String domains) {
            String[] split = domains.split("\\.");
            String[] subdomains = new String[split.length];
            int maxLength = subdomains.length;
            for (int i = split.length - 1; i >= 0; i--) {
                StringBuilder subdomain = new StringBuilder();
                for (int j = 0; j < maxLength; j++) {
                    subdomain.append(split[j]).append(".");
                    j++;
                }
                maxLength--;
                subdomains[i] = subdomain.toString();
            }
            return subdomains;
        }

        int getCount() {
            return this.count;
        }
    }

    public static void main(String[] args) {
        DomainVisit visit = new DomainVisit("1 auth.palantir.com");
        for (String a : visit.subdomains) {
            System.out.println("a = " + a);
        }
    }
}

