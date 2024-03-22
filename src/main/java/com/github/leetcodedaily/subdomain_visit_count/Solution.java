package com.github.leetcodedaily.subdomain_visit_count;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Dooby Kim
 * @Date 2024/3/22 下午11:28
 * @Version 1.0
 */
public class Solution {

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> domainFreq = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (String cpdomain : cpdomains) {
            final String[] cp_domain = cpdomain.split(" ");
            int cp = Integer.parseInt(cp_domain[0]);
            String domain = cp_domain[1];


            final List<String> list = processDomain(domain);
            for (String s : list) {
                if (!domainFreq.containsKey(s)) {
                    domainFreq.put(s, cp);
                } else {
                    int i = domainFreq.get(s);
                    domainFreq.put(s, i + cp);
                }
            }

        }

        for (Map.Entry<String, Integer> entry : domainFreq.entrySet()) {
            int value = entry.getValue();
            String key = entry.getKey();
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            sb.append(" ");
            sb.append(key);
            res.add(sb.toString());
        }
        return res;
    }

    private List<String> processDomain(String domain) {
        List<String> res = new ArrayList<>();
        final String[] split = domain.split("\\.");
        for (int i = 0; i < split.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < split.length; j++) {
                if (sb.length() > 0) {
                    sb.append(".");
                }
                sb.append(split[j]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        final List<String> list = solution.processDomain("google.mail.com");
//        for (String s : list) {
//            System.out.println(s);
//        }

        String[] input = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        final List<String> list = solution.subdomainVisits(input);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
