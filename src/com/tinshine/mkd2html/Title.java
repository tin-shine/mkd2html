package com.tinshine.mkd2html;

public class Title implements HtmlElem {

    @Override
    public String toHtml(String line) {
        int level = 0;
        StringBuilder ret = new StringBuilder();
        while (line.charAt(level) == '#') level++;
        ret.append("<h" + level + ">");
        int index = level;
        while (line.charAt(index) == ' ') index++;
        ret.append(line.substring(index));
        return ret.append("</h" + level + ">").toString();
    }

    @Override
    public String preProcess(String line) {
        ItemList.itemNum = 1;
        line = new InlineCode().toHtml(line);   // 对行内代码块进行处理
        return new Link().toHtml(line); // 对外链进行处理
    }

}
