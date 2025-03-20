package com.ecm1.ECM1.ui;

import com.ecm1.ECM1.controller.ECMcontroller;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelectorGUI {
    private final FileSelectionData fileData;
    private final ECMcontroller mcontroller;
    private final JFrame frame;
    private final JPanel mainPanel, postPanel, deletePanel;
    private final JTextField txtWorkingDir, txtExcelFile, txtInputDir, txtOutputReport, txtOutputDir, txtDeleteId;

    public FileSelectorGUI(ECMcontroller mcontroller) {
        this.mcontroller = mcontroller;
        this.fileData = new FileSelectionData();

        frame = new JFrame("ECM File Selector");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        postPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        deletePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        
        showMainPanel();
        frame.setVisible(true);
    }

    private void showMainPanel() {
        mainPanel.removeAll();
        JButton btnPost = new JButton("Post");
        JButton btnDelete = new JButton("Delete");

        btnPost.addActionListener(e -> showPostPanel());
        btnDelete.addActionListener(e -> showDeletePanel());

        mainPanel.add(btnPost);
        mainPanel.add(btnDelete);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showPostPanel() {
        postPanel.removeAll();

        JButton btnWorkingDir = new JButton("Select Working Dir");
        JButton btnExcelFile = new JButton("Select Excel File");
        JButton btnInputDir = new JButton("Select Input Dir");
        JButton btnOutputReport = new JButton("Select Report File");
        JButton btnOutputDir = new JButton("Select Output Dir");
        JButton btnSubmit = new JButton("Submit");
        JButton btnBack = new JButton("Back");

        txtWorkingDir = createTextField();
        txtExcelFile = createTextField();
        txtInputDir = createTextField();
        txtOutputReport = createTextField();
        txtOutputDir = createTextField();

        btnWorkingDir.addActionListener(e -> selectDirectory("Select Working Directory", txtWorkingDir));
        btnExcelFile.addActionListener(e -> selectFile("Select Excel File", txtExcelFile));
        btnInputDir.addActionListener(e -> selectDirectory("Select Input Directory", txtInputDir));
        btnOutputReport.addActionListener(e -> selectFile("Select Output Report File", txtOutputReport));
        btnOutputDir.addActionListener(e -> selectDirectory("Select Output Directory", txtOutputDir));
        btnSubmit.addActionListener(e -> runProcessing());
        btnBack.addActionListener(e -> showMainPanel());

        postPanel.add(btnWorkingDir); postPanel.add(txtWorkingDir);
        postPanel.add(btnExcelFile); postPanel.add(txtExcelFile);
        postPanel.add(btnInputDir); postPanel.add(txtInputDir);
        postPanel.add(btnOutputReport); postPanel.add(txtOutputReport);
        postPanel.add(btnOutputDir); postPanel.add(txtOutputDir);
        postPanel.add(btnSubmit);
        postPanel.add(btnBack);

        frame.add(postPanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private void showDeletePanel() {
        deletePanel.removeAll();

        JLabel lblDeleteId = new JLabel("Enter ID:");
        txtDeleteId = createTextField();
        JButton btnDelete = new JButton("Delete");
        JButton btnBack = new JButton("Back");

        btnDelete.addActionListener(e -> deleteRecord());
        btnBack.addActionListener(e -> showMainPanel());

        deletePanel.add(lblDeleteId);
        deletePanel.add(txtDeleteId);
        deletePanel.add(btnDelete);
        deletePanel.add(btnBack);

        frame.add(deletePanel, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return textField;
    }

    private void selectFile(String title, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser("C:\");
        fileChooser.setDialogTitle(title);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void selectDirectory(String title, JTextField textField) {
        JFileChooser directoryChooser = new JFileChooser("C:\");
        directoryChooser.setDialogTitle(title);
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = directoryChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void runProcessing() {
        fileData.setInputWorkingDir(txtWorkingDir.getText());
        fileData.setInputExcelFile(txtExcelFile.getText());
        fileData.setInputAllDir(txtInputDir.getText());
        fileData.setOutputReportFile(txtOutputReport.getText());
        fileData.setOutputDir(txtOutputDir.getText());

        if (!fileData.areAllFieldsSet()) {
            JOptionPane.showMessageDialog(null, "Error: Please select all required fields!", "Missing Inputs", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.processFiles(fileData.getInputExcelFile(), fileData.getInputAllDir(), fileData.getOutputDir());
        JOptionPane.showMessageDialog(null, result, "Process Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    private void deleteRecord() {
        String id = txtDeleteId.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Please enter an ID!", "Missing Input", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String result = mcontroller.deleteRecord(id);
        JOptionPane.showMessageDialog(null, result, "Delete Status", JOptionPane.INFORMATION_MESSAGE);
    }
}



package com.ecm1.ECM1.ui;

import com.ecm1.ECM1.controller.ECMcontroller;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelectorGUI {
    private final FileSelectionData fileData;
    private final ECMcontroller mcontroller;
    private final JTextField txtWorkingDir, txtExcelFile, txtInputDir, txtOutputReport, txtOutputDir;

    public FileSelectorGUI(ECMcontroller mcontroller) {
        this.mcontroller = mcontroller;
        this.fileData = new FileSelectionData();

        // Create frame
        JFrame frame = new JFrame("ECM File Selector");
        frame.setSize(500, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Main panel
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10)); // Rows, Cols, Hgap, Vgap
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15)); // Padding

        // Create components
        JButton btnWorkingDir = new JButton("Select Working Dir");
        JButton btnExcelFile = new JButton("Select Excel File");
        JButton btnInputDir = new JButton("Select Input Dir");
        JButton btnOutputReport = new JButton("Select Report File");
        JButton btnOutputDir = new JButton("Select Output Dir");
        JButton btnRun = new JButton("Run");

        // Text fields to display selected paths
        txtWorkingDir = createTextField();
        txtExcelFile = createTextField();
        txtInputDir = createTextField();
        txtOutputReport = createTextField();
        txtOutputDir = createTextField();

        // Action listeners
        btnWorkingDir.addActionListener(e -> selectDirectory("Select Working Directory", txtWorkingDir));
        btnExcelFile.addActionListener(e -> selectFile("Select Excel File", txtExcelFile));
        btnInputDir.addActionListener(e -> selectDirectory("Select Input Directory", txtInputDir));
        btnOutputReport.addActionListener(e -> selectFile("Select Output Report File", txtOutputReport));
        btnOutputDir.addActionListener(e -> selectDirectory("Select Output Directory", txtOutputDir));
        btnRun.addActionListener(e -> runProcessing());

        // Add components to panel
        panel.add(btnWorkingDir);
        panel.add(txtWorkingDir);
        panel.add(btnExcelFile);
        panel.add(txtExcelFile);
        panel.add(btnInputDir);
        panel.add(txtInputDir);
        panel.add(btnOutputReport);
        panel.add(txtOutputReport);
        panel.add(btnOutputDir);
        panel.add(txtOutputDir);

        // Button Panel for Run Button (centered)
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnRun);

        // Add panels to frame
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    // Creates a text field for displaying selected file paths
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return textField;
    }

    // Handles file selection with Working Directory as base
    private void selectFile(String title, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser();

        // Set base directory if Working Directory is selected
        if (!txtWorkingDir.getText().isEmpty()) {
            fileChooser.setCurrentDirectory(new File(txtWorkingDir.getText()));
        }

        fileChooser.setDialogTitle(title);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath();
            textField.setText(filePath);
        }
    }

    // Handles directory selection with Working Directory as base
    private void selectDirectory(String title, JTextField textField) {
        JFileChooser directoryChooser = new JFileChooser();

        // Set base directory if Working Directory is selected
        if (!txtWorkingDir.getText().isEmpty()) {
            directoryChooser.setCurrentDirectory(new File(txtWorkingDir.getText()));
        }

        directoryChooser.setDialogTitle(title);
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = directoryChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            String dirPath = directoryChooser.getSelectedFile().getAbsolutePath();
            textField.setText(dirPath);
        }
    }

    // Runs the processing logic
    private void runProcessing() {
        fileData.setInputWorkingDir(txtWorkingDir.getText());
        fileData.setInputExcelFile(txtExcelFile.getText());
        fileData.setInputAllDir(txtInputDir.getText());
        fileData.setOutputReportFile(txtOutputReport.getText());
        fileData.setOutputDir(txtOutputDir.getText());

        // Debugging: Print stored values
        System.out.println("Running process with:");
        System.out.println("Working Dir: " + fileData.getInputWorkingDir());
        System.out.println("Excel File: " + fileData.getInputExcelFile());
        System.out.println("Input Directory: " + fileData.getInputAllDir());
        System.out.println("Output Report File: " + fileData.getOutputReportFile());
        System.out.println("Output Directory: " + fileData.getOutputDir());

        if (!fileData.areAllFieldsSet()) {
            JOptionPane.showMessageDialog(null, "Error: Please select all required fields!", "Missing Inputs", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Call controller method
        String result = mcontroller.processFiles(fileData.getInputExcelFile(), fileData.getInputAllDir(), fileData.getOutputDir());

        JOptionPane.showMessageDialog(null, result, "Process Complete", JOptionPane.INFORMATION_MESSAGE);
    }
}




PS C:\compliance1\ECM1> mvn clean package
mvn : The term 'mvn' is not recognized as the name of a cmdlet, function, script file, or operable program. Check 
the spelling of the name, or if a path was included, verify that the path is correct and try again.
At line:1 char:1
+ mvn clean package
+ ~~~
    + CategoryInfo          : ObjectNotFound: (mvn:String) [], CommandNotFoundException
    + FullyQualifiedErrorId : CommandNotFoundException

PS C:\compliance1\ECM1> 



spackage com.example.firstt;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repo extends JpaRepository<PlanInfo, String>{

}
