package com.tinshine.mkd2html;

public interface HtmlElem {
    String preProcess(String line);
    String toHtml(String line);
}
