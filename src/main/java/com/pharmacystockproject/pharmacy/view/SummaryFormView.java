package com.pharmacystockproject.pharmacy.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import com.pharmacystockproject.pharmacy.model.MedicineOrder;

public class SummaryFormView extends JFrame {
    private JLabel lblHeader;
    private JLabel lblOrderDetails;
    private JLabel lblAddress;

    private JButton btnCancel;
    private JButton btnSend;

    public SummaryFormView(MedicineOrder order) {
        setTitle("Order Summary");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new GridLayout(5, 1, 10, 10));

        initializeComponents(order);
        addComponentsToFrame();
    }

    private void initializeComponents(MedicineOrder order) {
        // Header

        lblHeader = new JLabel("Summary of the 'shopping cart' Order to provider " + order.getProvider(),
                SwingConstants.CENTER);
        lblHeader.setFont(new Font("Arial", Font.BOLD, 14));

        // Medicine details
        String detailsText = String.format("Text of medicine requested: %d units of %s (%s)",
                order.getQuantity(),
                order.getMedicineType().toString(),
                order.getMedicineName());

        lblOrderDetails = new JLabel(detailsText, SwingConstants.CENTER);

        // Dynamic Address based on Branch selection

        String addressText = "Delivery Address: " + order.getBranch().getAddress();
        lblAddress = new JLabel(addressText, SwingConstants.CENTER);
        lblAddress.setForeground(Color.BLUE);

        // Action

        btnCancel = new JButton("Cancel Order");
        btnSend = new JButton("Send Order");

    }

    private void addComponentsToFrame() {
        add(lblHeader);
        add(lblOrderDetails);
        add(lblAddress);

        // Sub-pannel

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        buttonPanel.add(btnCancel);
        buttonPanel.add(btnSend);
        add(buttonPanel);
    
    }


    /* CONTROLLER ACTION LISTENER */
    public void addCancelListener(ActionListener listener){
        btnCancel.addActionListener(listener);
    }

    public void addSendListener(ActionListener listener){
        btnSend.addActionListener(listener);
    }


}
