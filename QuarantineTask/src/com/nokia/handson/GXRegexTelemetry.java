package com.nokia.handson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GXRegexTelemetry {
	
	private static final String PROPERTIES_FILE = "mapping.properties";
    private final List<MappingRule> mappingRules = new ArrayList<>();

    

    public GXRegexTelemetry() throws IOException, InterruptedException {
        loadMappingsManually();
    }

    private void loadMappingsManually() throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(PROPERTIES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split("=", 2);
                if (parts.length != 2) continue;

                String key = parts[0].trim();
                String value = parts[1].trim();

                String[] keyParts = key.split("\\|", 2);
                if (keyParts.length != 2) continue;

                mappingRules.add(new MappingRule(keyParts[0].trim(), keyParts[1].trim(), value));
            }
        }
    }

    public String getWsnocMapping(String aid, String resourceType) {
        MappingRule bestMatch = null;
        Matcher bestMatcher = null;

        for (MappingRule rule : mappingRules) {
            if (!rule.resourceType.equals(resourceType)) {
                continue;
            }
            Matcher matcher = rule.regexPattern.matcher(aid);
            if (matcher.matches()) {
                if (bestMatch == null || rule.specificity > bestMatch.specificity) {
                    bestMatch = rule;
                    bestMatcher = matcher;
                }
            }
        }

        if (bestMatch != null && bestMatcher != null) {
            String result = bestMatch.wsnocPattern;
            for (int i = 1; i <= bestMatcher.groupCount(); i++) {
                result = result.replaceFirst("\\?", Matcher.quoteReplacement(bestMatcher.group(i)));
            }
            return result;
        }
        return "No mapping found";
    }

    public static void main(String[] args) throws IOException, InterruptedException {
    	GXRegexTelemetry mapper = new GXRegexTelemetry();

        System.out.println(mapper.getWsnocMapping("1-5-L2-1-ODUflexi-1", "ioa-common:ODUflexi"));
        System.out.println(mapper.getWsnocMapping("1-5-L2-1", "ioa-common:OTUCni"));
        System.out.println(mapper.getWsnocMapping("1-4-T2.1", "gx:ETH100G"));
        System.out.println(mapper.getWsnocMapping("1-FANCTRL-1", "gx:FAN-CTRL"));
        System.out.println(mapper.getWsnocMapping("1-PEM-4", "gx:PEM"));
        System.out.println(mapper.getWsnocMapping("1-5-T5", "gx:ETH100G"));
        System.out.println(mapper.getWsnocMapping("1", "gx:G42"));
        System.out.println(mapper.getWsnocMapping("1-5-L2-1-ODU4i-1", "ioa-common:ODU4i"));
        System.out.println(mapper.getWsnocMapping("1-6-L1-1-ODU4-1", "ioa-common:ODU4"));
        System.out.println(mapper.getWsnocMapping("1-5-5", "ioa-common:tom"));
    }

}

class MappingRule {
    String aidPattern;
    String resourceType;
    String wsnocPattern;
    Pattern regexPattern;
    int specificity;

    MappingRule(String aidPattern, String resourceType, String wsnocPattern) {
        this.aidPattern = aidPattern;
        this.resourceType = resourceType;
        this.wsnocPattern = wsnocPattern;
        this.regexPattern = Pattern.compile("^" + buildRegexFromPattern(aidPattern) + "$");
        this.specificity = calcSpecificity(aidPattern);
    }

    private static String buildRegexFromPattern(String pattern) {
        StringBuilder regex = new StringBuilder();
        String[] parts = pattern.split("\\?", -1);
        for (int i = 0; i < parts.length; i++) {
            regex.append(Pattern.quote(parts[i]));
            if (i < parts.length - 1) {
                regex.append("([^\\-]+)"); // match any segment (numbers, letters, dots) except dash
            }
        }
        return regex.toString();
    }

    private static int calcSpecificity(String pattern) {
        return (int) Arrays.stream(pattern.split("-"))
                .filter(part -> !part.equals("?"))
                .count();
    }
}
