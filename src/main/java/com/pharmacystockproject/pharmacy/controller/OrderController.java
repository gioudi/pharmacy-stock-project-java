package com.pharmacystockproject.pharmacy.controller;

import java.awt.event.*;

import javax.swing.JOptionPane;

import com.pharmacystockproject.pharmacy.model.Branch;
import com.pharmacystockproject.pharmacy.model.MedicineOrder;
import com.pharmacystockproject.pharmacy.model.MedicineType;
import com.pharmacystockproject.pharmacy.model.Provider;
import com.pharmacystockproject.pharmacy.view.MainFormView;
import com.pharmacystockproject.pharmacy.view.SummaryFormView;

public class OrderController {
    private final MainFormView view;

    public OrderController(MainFormView view) {
        this.view = view;

        this.view.addDeleteListener(new DeleteButtonListener());
        this.view.addConfirmListener(new ConfirmButtonListener());
    }

    public class DeleteButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            view.clearForm();
        }
    }

    public class ConfirmButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            StringBuilder errorMessages = new StringBuilder();

            // Validate Medicine Name
            String name = view.getMedicineNameInput();
            if (name.isEmpty()) {
                errorMessages.append("Medicine cannot be empty. \n");
            } else if (!name.matches("^[a-zA-Z0-9 ]+$")) {
                errorMessages.append("- Medicine Name must be alphanumeric (letters and numbers only)");
            }

            // Validate Medicine Type
            MedicineType type = view.getSelectedMedicineType();
            if (type == null) {
                errorMessages.append("- You must select a medicine type");
            }

            // Validate Quantity
            String quantityStr = view.getQuantityInput();
            int quantity = -1;

            if (quantityStr.isEmpty()) {
                errorMessages.append("- Quantity cannot be empty");
            } else {
                try {
                    quantity = Integer.parseInt(quantityStr);
                    if (quantity <= 0) {
                        errorMessages.append("- Quantity must be a positive integer greater than zero");
                    }
                } catch (NumberFormatException ex) {
                    errorMessages.append("- Quantity must be a valid numerical value");
                }
            }

            // Validate Provider Selection

            String providerStr = view.getSelectedProvider();
            Provider provider = null;

            if (providerStr == null) {
                errorMessages.append("- You must select a provider company");

            } else {
                provider = Provider.valueOf(providerStr);
            }

            Branch branch = null;
            if (!view.isPrimaryBranchSelected() && !view.isSecondaryBranchSelected()) {
                errorMessages.append("- You must choose at least one branch");
            } else if (view.isPrimaryBranchSelected() && view.isSecondaryBranchSelected()) {
                errorMessages.append("- Please choose ONLY one branch");
            } else {
                branch = view.isPrimaryBranchSelected() ? Branch.PRIMARIA : Branch.SECUNDARIA;
            }

            if (errorMessages.length() > 0) {
                JOptionPane.showMessageDialog(view, errorMessages.toString(), "Validation Error",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                MedicineOrder finalOrder = new MedicineOrder(name, type, quantity, provider, branch);

                processValidOrder(finalOrder);
            }

        }
    }

    private void processValidOrder(MedicineOrder order) {
        // Hide the primary input window

        view.setVisible(false);

        // Instantiate the Summary View

        SummaryFormView summaryView = new SummaryFormView(order);

        // Wire up the "Cancel Order" CTA

        summaryView.addCancelListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                summaryView.dispose();

                view.setVisible(true);
            }
        });

        // Wire up the "Send Order" CTA

        summaryView.addSendListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(summaryView, "Pedido Enviado.", "Order Dispatched",
                        JOptionPane.INFORMATION_MESSAGE);

                // Close everything down cleanly

                summaryView.dispose();
                view.dispose();

                System.exit(0);
            }
        });

        summaryView.setVisible(true);
    }

}
