package com.tinshine.mkd2html;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ElemType {

    static final int DEFAULT = -1;
    static final int TITLE = 0;
    static final int ITEM_LIST = 1;
    static final int CODE = 2;
    static final int IMAGE = 3;
    static final int ITEM = 4;

    final String TITLE_PATTERN = "\\s*#{1,6} \\S";
    final String IMAGE_PATTERN = "!\\[.*]\\(.*\\)";
    final String CODE_PATTERN = "^```";
    final String ITEM_PATTERN = "^\\*\\s";
    final String ITEM_LIST_PATTERN = "^\\d\\.\\s";

    Pattern pattern;
    Matcher matcher;

    public int checkType(String line) {
        if (match(line, TITLE_PATTERN))
            return TITLE;
        if (match(line, ITEM_LIST_PATTERN))
            return ITEM_LIST;
        if (match(line, CODE_PATTERN))
            return CODE;
        if (match(line, IMAGE_PATTERN))
            return IMAGE;
        if (match(line, ITEM_PATTERN))
            return ITEM;
        return DEFAULT;
    }

    private boolean match(String line, String sample) {
        pattern = Pattern.compile(sample);
        matcher = pattern.matcher(line);
        return matcher.find();
    }
}