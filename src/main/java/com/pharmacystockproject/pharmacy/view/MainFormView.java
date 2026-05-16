package com.pharmacystockproject.pharmacy.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.pharmacystockproject.pharmacy.model.MedicineType;

import java.awt.*;

import java.awt.event.ActionListener;

public class MainFormView extends JFrame {

    // Ui components
    private JTextField txtMedicineName;
    private JComboBox<MedicineType> comboMedicineType;
    private JTextField txtQuantity;

    // Provider Radio Buttons

    private JRadioButton radioCofara;
    private JRadioButton radioEmpsephar;
    private JRadioButton radioCemefar;
    private ButtonGroup providerGroup;

    // Branch Checkboxes

    private JCheckBox chkPrimaryBranch;
    private JCheckBox chkSecondaryBranch;

    // Buttons (CTAs)

    private JButton btnDelete;
    private JButton btnConfirm;

    public MainFormView() {
        // Frame properties

        setTitle("Pharmacy Stock - Order Request");
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new GridLayout(7, 2, 10, 15));

        initializeComponents();
        addComponentsToFrame();
    }

    private void initializeComponents() {
        txtMedicineName = new JTextField();

        // (Populated automatically from our Enum)
        comboMedicineType = new JComboBox<>(MedicineType.values());

        txtQuantity = new JTextField();

        radioCofara = new JRadioButton("Cofara");
        radioEmpsephar = new JRadioButton("Empsephar");
        radioCemefar = new JRadioButton("Cemefar");

        // Group of radios so only one can be selected

        providerGroup = new ButtonGroup();
        providerGroup.add(radioCofara);
        providerGroup.add(radioEmpsephar);
        providerGroup.add(radioCemefar);

        // Checkboxes

        chkPrimaryBranch = new JCheckBox("Primaria");
        chkSecondaryBranch = new JCheckBox("Secunadaria");

        // Call to actions

        btnDelete = new JButton("Delete");
        btnConfirm = new JButton("Confirm");
    }

    public void addComponentsToFrame() {

        add(new JLabel(" Medicine Name:"));
        add(txtMedicineName);

        add(new JLabel("Type of Medicine:"));
        add(comboMedicineType);

        add(new JLabel("Quantity / Amount:"));
        add(txtQuantity);

        add(new JLabel(" Provider Company:"));
        JPanel providerPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        providerPanel.add(radioCofara);
        providerPanel.add(radioEmpsephar);
        providerPanel.add(radioCemefar);
        add(providerPanel);

        add(new JLabel(" Branch:"));
        JPanel branchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        branchPanel.add(chkPrimaryBranch);
        branchPanel.add(chkSecondaryBranch);
        add(branchPanel);

        add(new JLabel(""));
        add(new JLabel(""));

        add(btnDelete);
        add(btnConfirm);

    }

    public String getMedicineNameInput() {
        return txtMedicineName.getText().trim();
    }

    public MedicineType getSelectedMedicineType() {
        return (MedicineType) comboMedicineType.getSelectedItem();
    }

    public String getQuantityInput() {
        return txtQuantity.getText().trim();
    }

    public String getSelectedProvider() {
        if (radioCofara.isSelected())
            return "COFARA";
        if (radioEmpsephar.isSelected())
            return "EMPSEPHAR";
        if (radioCemefar.isSelected())
            return "CEMEFAR";

        return null;
    }

    public boolean isPrimaryBranchSelected() {
        return chkPrimaryBranch.isSelected();
    }

    public boolean isSecondaryBranchSelected() {
        return chkSecondaryBranch.isSelected();
    }

    public void addConfirmListener(ActionListener listener) {
        btnConfirm.addActionListener(listener);
    }

    public void addDeleteListener(ActionListener listener) {
        btnDelete.addActionListener(listener);
    }


    public void clearForm() {
        txtMedicineName.setText("");
        comboMedicineType.setSelectedIndex(0);
        txtQuantity.setText("");
        providerGroup.clearSelection();
        chkPrimaryBranch.setSelected(false);
        chkSecondaryBranch.setSelected(false);
    }
}
