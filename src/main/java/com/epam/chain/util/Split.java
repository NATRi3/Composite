package com.epam.chain.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
    public static String[] splitIncludingDelimiters(String regex, String text) {
        List<String> list = new ArrayList<>();
        Matcher matcher = Pattern.compile(regex).matcher(text);
        int end = 0;
        while(matcher.find()){
            list.add( text.substring(end, matcher.start()) );
            list.add(matcher.group());
            end = matcher.end();
        }
        if (end < text.length()){
            list.add(text.substring(end));
        }
        return list.toArray(new String[0]);
    }
}
