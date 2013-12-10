import javax.swing.*;
import java.util.Scanner;
import java.util.*;

public class LabelHelper {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                LabelScreen ls = new LabelScreen();
                ls.createAndShowGUIForMain();
            }
        });
        //create object helper, execute askUser()
        //PrepLabel helper = new PrepLabel();
        //helper.askUser();
    }
}

/*

::::::TODO::::::

class Frys extends SilenXFans{
	private String[][][] listFrys = {{{"5382968"}, {"ixp-11-14", "11-14", "1114"}},
					{{"5382988"}, {"ixp-34-08", "34-08", "3408"}},
					{{"5525440"}, {"ixp-34-16", "34-16", "3416"}},
					{{"5383048"}, {"ixp-52-11", "52-11", "5211"}},
					{{"6998377"}, {"efx-08-12", "08-12", "0812"}},
					{{"6925177"}, {"efx-08-15b", "08-15b", "0815b"}},
					{{"6925187"}, {"efx-08-15r", "08-15r", "0815r"}},
					{{"6998367"}, {"efx-09-15", "09-15", "0915"}},
					{{"6998357"}, {"efx-10-12", "10-12", "1012"}},
					{{"6925167"}, {"efx-12-12", "12-12", "1212"}},
					{{"6925157"}, {"efx-12-15t", "12-15t", "1215t"}},
					{{"6998337"}, {"efx-14-12", "14-12", "14-12"}},
					{{"6998417"}, {"efz-80ha3", "80ha3", "0}},
					{{"6998487"}, {"efz-92ha2", "92ha2", "0"}},
					{{"6998437"}, {"efz-100ha2", "100ha3", "0"}},
					{{"6998397"}, {"efz-92ha3", "92ha3", "0"}},
					{{"6973657"}, {"efz-120ha5", "120ha5", "0"}},
					{{"6469372"}, {"ixa-afk", "afk", "0"}},
					{{"6423132"}, {"ixa-ccs", "ccs", "0"}};
}

class NewEgg extends Store{
	private String store;
	private fans;
	private quantity;
	private String po;
}*/
