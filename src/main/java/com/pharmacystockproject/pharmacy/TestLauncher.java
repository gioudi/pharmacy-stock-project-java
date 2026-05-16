package com.pharmacystockproject.pharmacy;

import com.pharmacystockproject.pharmacy.controller.OrderController;
import com.pharmacystockproject.pharmacy.view.MainFormView;

public class TestLauncher {
    public static void main(String[] args){
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            // TODO: handle exception
        }


        MainFormView view = new MainFormView();
        OrderController controller = new OrderController(view);

        view.setVisible(true);
    }
}
