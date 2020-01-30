public class Odev2Ogrenci {
    /**
     * isBST metodu kökü verilen herhangi bir ağacın ikili arama ağacı olup
     * olmadığını hesaplar
     * @param node Kök düğüm
     * @param <T> karşılaştırılabilir generic tür
     * @return ikili arama ağacı mı değil mi
     */
    public static <T extends Comparable<T>> boolean isBST(BTNode<T> node) {
        boolean temp = true;
        if(node != null) {

            while(node != null) { if(node.left != null && node.left.value.compareTo(node.value) == 1)
            { temp = false; }
                node = node.left;
            }

            while(node != null){ if(node.right !=null && node.right.value.compareTo(node.value) == -1)
            { temp = false; }
                node=node.right;
            }
            
        }
        
        else {
            temp = true;
        } 
            return temp;
    }
}
