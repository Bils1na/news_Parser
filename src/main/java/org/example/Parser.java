package org.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;


public class Parser {

    private static String url = "https://russian.rt.com/business";

    private static Document getPage() throws IOException {
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static Element getBody() throws IOException {
        Element body = getPage().selectFirst("body");
        return body;
    }

    public static Elements getNewsList() throws IOException {
        Elements newsList = getBody().select("ul.listing__rows.listing__rows_short-news > li");
        return newsList;
    }

    public static void printNews() throws IOException {
        Elements newsList = getNewsList();

        for (Element newsEl : newsList) {
            Elements time = newsEl.select("time.date");
            if (time.size() != 0) {
                System.out.println(newsEl.select("time.date").text());
                System.out.println(newsEl.select("a.link.link_color").text());
                System.out.println(url
                        + newsEl.select("a.link.link_color").attr("href")
                        .replaceFirst("business/", ""));
                System.out.println("-------------------------------------------------------------------------------------");
            }
        }
    }


}
