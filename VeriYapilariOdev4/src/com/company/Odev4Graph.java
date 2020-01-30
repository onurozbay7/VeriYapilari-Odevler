package com.company;

import com.company.Edge;
import com.company.Odev4AbstractGraph;
import com.company.Vertex;

public class Odev4Graph<T> extends Odev4AbstractGraph<T> {
    /**
     * Mevcut çizgenin komşuluk matrisini hesaplayıp geri döndürür
     * @return Komşuluk matrisi(iki boyutlu tamsayı dizisi)
     */
    @Override
    public int[][] adjacencyMatrix() {

        int tablo[][] = new int[vertices.size()][vertices.size()];

        int i = 0;
        for (Vertex<T> v : vertices) {
            for (Edge<T> e : v.edges) {
                for (int k = 0; k < vertices.size(); k++) {
                    if (e.to == vertices.get(k)) {

                        tablo[i][k] = e.weight;

                    }

                }

            }
            i++;
        }


        return tablo;
    }

    /**
     * Mevcut çizgenin parametre olarak gönderilen çizge ile eşit olup
     * olmadığını döndürür. İki çizgenin birbirine eşit olması için düğümlerin
     * (vertex) referansları farklı olsa bile değerlerinin eşit olması ve de
     * tüm kenarların her iki çizgede de aynı düğümler arasında olması gerekir
     * @param g2 Eşitlik kontrolü için gönderilen çizge parametresi
     * @return Eşit için true aksi halde false döner
     */
    @Override
    public boolean equals(Odev4AbstractGraph<T> g2) {

        boolean sonuc=true;

        int tablo[][] = g2.adjacencyMatrix();
        int tablo2[][] = adjacencyMatrix();

        if(g2.vertices.size() != vertices.size()){
            sonuc = false;
        }
        else {

            for (int i = 0; i < tablo.length; i++) {
                for (int j = 0; j < tablo.length; j++) {

                    if (tablo[i][j] != tablo2[i][j]) {
                        sonuc = false;
                    }

                }
            }

        }
        return sonuc;

    }
}