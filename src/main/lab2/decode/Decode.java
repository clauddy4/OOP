package main.lab2.decode;

public class Decode {
    public String HtmlDecode(final String text) {
        return text.replaceAll("&amp;", "&")
            .replaceAll("&quot;", "\'")
            .replaceAll("&apos;", "\'")
            .replaceAll("&lt;", "<")
            .replaceAll("&gt;", ">");
    }
}
