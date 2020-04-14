package com.tinshine.mkd2html;

public class InlineCode implements HtmlElem {

    @Override
    public String preProcess(String line) {
        return line;
    }

    @Override
    public String toHtml(String line) {

        // 处理行内代码块
        StringBuilder ret = new StringBuilder();
        int index = 0;
        while (index != -1 && index < line.length()) {
            int left = line.indexOf("``", index);
            int right = line.indexOf("``", left + 2);
            if (left == -1 || right == -1) break;
            ret.append(line.substring(index, left)).append("<code>")
                    .append(line.substring(left + 2, right)).append("</code>");
            index = right + 2;
        }
        line = ret.append(line.substring(index)).toString();

        // 处理字体加粗
        StringBuilder str = new StringBuilder();
        index = 0;
        while (index != -1 && index < line.length()) {
            int left = line.indexOf("**", index);
            int right = line.indexOf("**", left + 2);
            if (left == -1 || right == -1) break;
            str.append(line.substring(index, left)).append("<strong>")
                    .append(line.substring(left + 2, right)).append("</strong>");
            index = right + 2;
        }
        return str.append(line.substring(index)).toString();
    }

}