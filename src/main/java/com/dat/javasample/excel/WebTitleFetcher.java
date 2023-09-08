package com.dat.javasample.excel;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class WebTitleFetcher {
    public static String getTitleFromUrl(String url) {
        try {
            // Kết nối đến URL và lấy nội dung trang web dưới dạng Document
            Document doc = Jsoup.connect(url).get();

            // Lấy tiêu đề (title) của trang web từ thẻ <title>
            String title = doc.title();

            return title;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String url = "https://www.vinamilk.com.vn/cong-bo-san-pham/"; // Thay bằng URL của trang web bạn muốn lấy tiêu đề

        String title = getTitleFromUrl(url);
        if (title != null) {
            System.out.println("Tiêu đề của trang web là: " + title);
        } else {
            System.out.println("Không thể lấy tiêu đề của trang web.");
        }
    }
}
