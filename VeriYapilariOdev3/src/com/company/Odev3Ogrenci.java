package com.company;

import com.company.HuffmanNode;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

/**
 * FrekansKarsilastirici sınıfı Huffman ağaçlarını köklerindeki frekans değerlerine göre
 * karşılaştırır.
 */
class FrekansKarsilastirici implements Comparator<HuffmanNode> {

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {

        if((o1.frequency - o2.frequency) > 0)
            return 1;
        else if((o1.frequency - o2.frequency) < 0)
            return -1;
        else
            return 0;

    }
}

/**
 * AlfabetikKarsilastirici sınıfı Huffman ağaçlarını içlerinde bulunan en küçük karakterlere
 * göre karşılaştırır.
 */
class AlfabetikKarsilastirici implements Comparator<HuffmanNode> {
    public ArrayList<Character> listEkle(HuffmanNode node, ArrayList<Character> aL) {

        if (node == null) {
            return aL;
        } else {
            if (node.value != null) {
                aL.add(node.value);
            }

            listEkle(node.left, aL);
            listEkle(node.right, aL);

            return aL;
        }

    }

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {

        ArrayList<Character> array1 = new ArrayList<>();
        ArrayList<Character> array2 = new ArrayList<>();


        array1 = listEkle(o1, array1);
        array2 = listEkle(o2, array2);

        Collections.sort(array1);
        Collections.sort(array2);

        if(array1.get(0) > array2.get(0)) { return 1;}
        else if(array1.get(0) < array2.get(0)) { return  -1;}
        else { return 0;}


    }



}