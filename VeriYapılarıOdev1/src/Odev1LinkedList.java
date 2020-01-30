import javax.management.NotificationEmitter;
import javax.management.relation.InvalidRelationIdException;

public class Odev1LinkedList<T extends Comparable<T>> extends AbstractLinkedList<T> {
    /**
     * Bir listede elemanları uygun konuma ekler. Boş bir listeye elemanlar eklendikten
     * sonra küçükten büyüğe sıralı olur
     * @param value eklenecek değer
     */
    @Override
    public void insertInOrder(T value) {
        Node<T> newNode = getHead();

        if(newNode == null) { addFirst(value);}

        else if (newNode.value.compareTo(value) > 0) { addFirst(value);}


        else {
            while (newNode.next != null) {

                if (value.compareTo(newNode.next.value) < 0) {

                    Node<T>  temp =new Node<T>(value,newNode.next);
                    newNode.next=temp ;
                    break;

                }

                newNode = newNode.next;

            }

            if(newNode.next == null) {
                addLast(value);

            }


        }
    }
    /**
     * Mevcut listeyi değiştirmeden, elemanların sırası ters çevrilmiş halde geri döndürür.
     * @return Ters çevrilmiş liste
     */
    @Override
    public AbstractLinkedList<T> reverse() {
        Odev1LinkedList<T> liste = new Odev1LinkedList<T>();

        Node<T> current = getHead();

        if(getHead() == null) return liste;
        /* 1. yol
        while(current.next != null){
            liste.addFirst(current.value);
            current = current.next;
        }

        liste.addFirst(current.value);*/

        // 2. yol
        Node<T> tempPrev = null;

        while (current != null){

            tempPrev = current;
            current = current.next;
            liste.addFirst(tempPrev.value);

        }

            return liste;
    }

    /**
     * Mevcut liste ile parametre olarak gelen listeyi birleştirip geriye döndürür.
     * Mevcut listede değişiklik yapılmaz.
     * @param list Mevcut listenin sonuna eklenecek liste
     * @return Birleşmiş liste
     */
    @Override
    public AbstractLinkedList<T> concatenate(AbstractLinkedList<T> list) {

        Odev1LinkedList<T> asilListe = new Odev1LinkedList<T>();
        Node<T> current = getHead();
        Node<T> listNode = list.getHead();


        if (current == null) {return list; }
        while (current != null) {
            asilListe.addLast(current.value);
            current = current.next;

        }

        while (listNode != null) {

            asilListe.addLast(listNode.value);
            listNode = listNode.next;
        }


        return asilListe;
    }

}