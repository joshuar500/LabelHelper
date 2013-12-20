package console;


import console.Fans;
import gui.LabelHelper;
import java.util.ArrayList;
import java.util.Scanner;

public class PrepLabel {
    ArrayList<StoreLabel> labelMaker = new ArrayList<StoreLabel>();
    ArrayList<String> fanNames = new ArrayList<String>();
    ArrayList<String> fansQuantity = new ArrayList<String>();
    ArrayList<String> poNum = new ArrayList<String>();
    Scanner reader = new Scanner(System.in);
    String store = null;
    String done;
    StoreLabel cLabel;

    public void askUser() {

        // ask user what store we will be processing
        // ask what fans, quantity, PO#
        // TODO: match slx fans with other stores fans, build gui, print label

        storeName();
        askFans();
        enterPO();
        isUserDone();

    }

    void askFans() {
        Scanner reader = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a SilenX fan or type 'next': ");
            String fan = reader.nextLine();
            if (fan.equals("next")) {
                break;
            } else {
                fan = fan.toLowerCase();
                Fans slxFans = new Fans(); // this should be 'store' instead of silenx fans
                slxFans.getFans(fan);
                fanNames.add(fan); //there is a pretty huge bug that does not test if fan actually exists and will add the input anyway
            }
            System.out.println("Enter a quantity: ");
            String quantity = reader.nextLine();
            fansQuantity.add(quantity);
        }
    }

    void storeName() {
        //check this against all frys orders... might need some refining
        if (store == null) {
            System.out.println("Enter the store: ");
            store = reader.nextLine();
            store = store.toLowerCase();

            while (true) {

                if (store.equals("frys")) {
                    System.out.println("You chose Frys");
                    break;
                }
                if (store.equals("newegg")) {
                    System.out.println("You chose NewEgg");
                    break;
                } else {
                    System.out.println("Sorry, please try again");
                    LabelHelper helper = new LabelHelper();
                    askUser();
                }
            }
        } else {
            return;
        }
    }

    void enterPO() {
        System.out.println("Enter the PO number: ");
        String poInput = reader.nextLine();
        poNum.add(poInput);
    }

    void isUserDone() {
        System.out.println("Is that all? y/n : ");
        done = reader.nextLine();

        if (done.equals("y")) {
            createLabel(store, fanNames, fansQuantity, poNum);
            System.out.println("Printing labels...");
            //TODO: print out all store objects
        }
        if (done.equals("n")) {

            createLabel(store, fanNames, fansQuantity, poNum);
            System.out.println(store + " " + fanNames + " " + fansQuantity + " " + poNum);
            System.out.println("Label Created and Saved");
            System.out.println(labelMaker.size());
            askUser();
        }
    }

    public void createLabel(String s, ArrayList<String> f, ArrayList<String> q, ArrayList<String> p) {
        cLabel = new StoreLabel(s, f, q, p);
        labelMaker.add(cLabel);
    }
}