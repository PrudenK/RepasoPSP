package org.pruden.RecogidaDatos;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class RecogerDatos {
    public static void main(String[] args) throws IOException {
        String url = "https://mural.uv.es/franpevi/index.html";

        Document doc = Jsoup.connect(url).get();

        System.out.println("<===================HTML======================>\n\n");

        System.out.println(doc.html());

        System.out.println("\n\n<===================<p>======================>\n\n");

        System.out.println(doc.select("p"));

        System.out.println("\n\n<===================p.class======================>\n\n");

        for (Element p : doc.select("p[class]")) {
            System.out.println(p.className());
        }

        System.out.println("\n\n<===================Img======================>\n\n");

        for (Element img : doc.select("img")) {
            System.out.println(img.attr("src"));
        }

        System.out.println("\n\n<===================Contenido p======================>\n\n");

        for (Element p : doc.select("p")) {
            System.out.println(p.text());
        }
    }
}
