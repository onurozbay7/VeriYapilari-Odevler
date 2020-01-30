public class Main {

    public static void main(String[] args) {
	// write your code here

        Odev1LinkedList<Integer> liste = new Odev1LinkedList<>();
        Odev1LinkedList<Integer> liste2 = new Odev1LinkedList<>();

        liste.addFirst(9);
        liste.addFirst(8);
        liste.addFirst(7);
        liste.addFirst(3);
        liste.addFirst(2);
        liste.addFirst(1);

        //liste.concatenate(liste2);

        liste.insertInOrder(5);
        liste.insertInOrder(6);
        liste.insertInOrder(4);
        liste.insertInOrder(11);


        liste.print();

    }
}
