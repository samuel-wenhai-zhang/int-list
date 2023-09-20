import java.util.Iterator;

public class GenericListRunner {
    public static void main(String[] args) {
        GenericList<String> list = new GenericList<String>();
        list.add("H");
        list.add("O");
        list.add("RNETS");

        System.out.println(list);
        for (String s : list) {
            System.out.println(s);
            list.add(s);
        }
    }    
}
