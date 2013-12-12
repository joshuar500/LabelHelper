import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fans{



    protected String[][][] listIXP = {{{"ixp-11-14"}, {"ixp-11-14", "11-14", "1114"}},
                                    {{"ixp-13-14"}, {"ixp-13-14", "13-14", "1314"}},
                                    {{"ixp-34-08"}, {"ixp-34-08", "34-08", "3408"}},
                                    {{"ixp-52-11"}, {"ixp-52-11", "52-11", "5211"}},
                                    {{"efx-08-12"}, {"efx-08-12", "08-12", "812"}},
                                    {{"efx-08-15b"}, {"efx-08-15b", "08-15b", "815b"}},
                                    {{"efx-08-15r"}, {"efx-08-15r", "08-15r", "815r"}},
                                    {{"efx-09-15"}, {"efx-09-15", "09-15", "915"}},
                                    {{"efx-10-12"}, {"efx-10-12", "10-12", "1012"}},
                                    {{"efx-12-12"}, {"efx-12-12", "12-12", "1212"}},
                                    {{"efx-12-15t"}, {"efx-12-15t", "12-15t", "1215t"}},
                                    {{"efx-14-12"}, {"efx-14-12", "14-12", "1412"}},
                                    {{"efz-80ha3"}, {"efz-80ha3", "80ha3", "0"}},
                                    {{"efz-92ha2"}, {"efz-92ha2", "92ha2", "0"}},
                                    {{"efz-100ha2"}, {"efz-100ha2", "100ha2", "0"}},
                                    {{"efz-92ha3"}, {"efz-92ha3", "92ha3", "0"}},
                                    {{"efz-120ha5"}, {"efz-120ha5", "120ha5", "0"}},
                                    {{"ixa-afk"}, {"ixa-afk", "afk", "0"}},
                                    {{"ixa-ccs"}, {"ixa-ccs", "ccs", "0"}}};


    public String getFans(String f) {
        String newFan = f;

        for (int i = 0; i < listIXP.length; i++) {
            for (int j = 0; j < listIXP[i].length; j++) {
                for (int k = 0; k < listIXP[i][j].length; k++) {


                    if (newFan.equals(listIXP[i][j][k])) {
                        return listIXP[i][0][0];//listIXP[i][j][k];
                    }
                }
            }
        } return "";
    }
}