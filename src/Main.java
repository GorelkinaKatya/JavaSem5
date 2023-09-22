import java.util.*;

public class Main {
    public static void main(String[] args) {
        TelephoneBook book = new TelephoneBook();
        book.add("Иванов","123456");
        book.add("Васильев","321456");
        book.add("Петрова","234561");
        book.add("Иванов","234432");
        book.add("Васильев","654321");
        book.add("Иванов","345678");

        System.out.println(book.sortAndPrint());
    }

    static class TelephoneBook {
        HashMap<String, ArrayList<String>> telephoneBook = new HashMap<>();

        void add(String Name, String telNum){
            //telephoneBook.get(Name).add(telNum);
            if (telephoneBook.containsKey(Name)) {
                ArrayList phoneNum = telephoneBook.get(Name);
                phoneNum.add(telNum);
                telephoneBook.put(Name, phoneNum);
            } else {
                ArrayList phoneNum = new ArrayList();
                phoneNum.add(telNum);
                telephoneBook.put(Name, phoneNum);
                }
        }
        String sortAndPrint() {
            HashMap<Integer, String> sortTelephoneBook = new HashMap<>();
            for (String Name : telephoneBook.keySet()) {
                int numTelNum = telephoneBook.get(Name).size();
                sortTelephoneBook.put(numTelNum, Name);
            }

            HashMap<String, ArrayList<String>> answerTelephoneBook = new HashMap<>();
            for (HashMap.Entry<Integer, String> entryI : sortTelephoneBook.entrySet()) {
                Integer keyI = entryI.getKey();
                String valueI = entryI.getValue();
                //System.out.println(valueI);
                for (HashMap.Entry<String, ArrayList<String>> entryJ : telephoneBook.entrySet()) {
                    String keyJ = entryJ.getKey();
                    ArrayList<String> valueJ = entryJ.getValue();
                    //System.out.println(keyJ);
                    if (valueI.equals(keyJ)) {
                        answerTelephoneBook.put(keyJ, valueJ);
                        //System.out.println(keyJ);
                        //System.out.println(answerTelephoneBook);
                    }
                }
            }

            return answerTelephoneBook.toString();
        }
    }
}