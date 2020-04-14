package com.tinshine.test;

import com.tinshine.mkd2html.MainCompiler;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(new File("in.md"));
        MainCompiler compiler = new MainCompiler();
        StringBuilder str = new StringBuilder();
        while (scan.hasNext()) {
            str.append(compiler.transform(scan.nextLine()));
        }
        scan.close();
        PrintWriter printWriter = new PrintWriter(new File("out.html"));
        printWriter.print(str.toString());
        printWriter.close();
    }
}
