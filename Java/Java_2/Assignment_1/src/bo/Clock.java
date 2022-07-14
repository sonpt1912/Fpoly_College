/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import view.Main;

/**
 *
 * @author son45
 */
public class Clock {

    public void clock(JLabel time) {
        Thread t = new Thread() {
            public void run() {
                while (true) {
                    try {
                        Calendar cal = Calendar.getInstance();
                        int check = cal.get(Calendar.AM);
                        int h = cal.get(Calendar.HOUR);
                        int m = cal.get(Calendar.MINUTE);
                        int s = cal.get(Calendar.SECOND);
                        int am = cal.get(Calendar.AM_PM);
                        String am_pm = am == 0 ? "AM" : "PM";
                        String gio = "", phut = "", giay = "";
                        if (h <= 9) {
                            gio = "0" + h;
                        } else {
                            gio = "" + h;
                        }
                        if (m <= 9) {
                            phut = "0" + m;
                        } else {
                            phut = "" + m;
                        }
                        if (s <= 9) {
                            giay = "0" + s;
                        } else {
                            giay = " " + s;
                        }
                        time.setText(gio + ':' + phut + ':' + giay + " " + am_pm);
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        t.start();
    }
    
    
//    public void run() {
//        while (true) {
//            try {
//                Calendar cal = Calendar.getInstance();
//                int h = cal.get(Calendar.HOUR);
//                int m = cal.get(Calendar.MINUTE);
//                int s = cal.get(Calendar.SECOND);
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//    }
}
