package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;


public class Parser {
    private static Document getPage() throws IOException {
        String url = "https://russian.rt.com/business";
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static Element getBody() throws IOException {
        Element body = getPage().selectFirst("body");
        return body;
    }


}
