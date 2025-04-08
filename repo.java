TaskSchedulerErrorWarning
Filter pattern
?ERROR ?Warning
Metric
TaskMonitor  / TaskSchedularErrors 
Metric value
1
Default value
-
Applied on transformed logs
-
Unit
-
Dimensions
-
Alarms
None.


<Event xmlns='http://schemas.microsoft.com/win/2004/08/events/event'><System><Provider Name='Microsoft-Windows-TaskScheduler' Guid='{de7b24ea-73c8-4a09-985d-5bdadcfa9017}'/><EventID>101</EventID><Version>0</Version><Level>2</Level><Task>101</Task><Opcode>101</Opcode><Keywords>0x8000000000000001</Keywords><TimeCreated SystemTime='2025-04-08T12:14:34.3304118Z'/><EventRecordID>2340822</EventRecordID><Correlation/><Execution ProcessID='1496' ThreadID='8832'/><Channel>Microsoft-Windows-TaskScheduler/Operational</Channel><Computer>appcompl04d.its.corp.gwl.com</Computer><Security UserID='S-1-5-18'/></System><EventData Name='TaskStartFailedEvent'><Data Name='TaskName'>\FailingTask</Data><Data Name='UserContext'>IND\chnksv</Data><Data Name='ResultCode'>2147942402</Data></EventData><RenderingInfo Culture='en-US'><Message>Task Scheduler failed to start "\FailingTask" task for user "IND\chnksv". Additional Data: Error Value: 2147942402.</Message><Level>Error</Level><Task>Task Start Failed</Task><Opcode>Launch Failure</Opcode><Channel>Operational</Channel><Provider>Microsoft-Windows-TaskScheduler</Provider><Keywords></Keywords></RenderingInfo></Event>


{
  "logs": {
    "logs_collected": {
      "windows_events": {
        "collect_list": [
          {
            "event_name": "Application",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "EventViewer-Application",
            "log_stream_name": "{instance_id}"
          },
          {
            "event_name": "System",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "EventViewer-System",
            "log_stream_name": "{instance_id}"
          },
          {
            "event_name": "Microsoft-Windows-TaskScheduler/Operational",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "TaskScheduler-Logs",
            "log_stream_name": "{instance_id}"
          }
        ]
      }
    }
  }
}



****** processing amazon-cloudwatch-agent ******
I! Trying to detect region from ec2
D! [EC2] Found active network interface
I! imds retry client will retry 1 timesSuccessfully fetched the config and saved in C:\ProgramData\Amazon\AmazonCloudWatchAgent\Configs\file_config.json.tmp
Start configuration validation...
2025/04/08 05:31:36 Reading json config file path: C:\ProgramData\Amazon\AmazonCloudWatchAgent\Configs\file_config.json.tmp ...
2025/04/08 05:31:36 I! Valid Json input schema.
I! Trying to detect region from ec2
D! [EC2] Found active network interface
I! imds retry client will retry 1 times2025/04/08 05:31:36 Configuration validation first phase succeeded
Configuration validation second phase succeeded
Configuration validation succeeded
AmazonCloudWatchAgent has been stopped
AmazonCloudWatchAgent has been started
PS C:\Program Files\Amazon\AmazonCloudWa


{
  "logs": {
    "logs_collected": {
      "windows_events": {
        "collect_list": [
          {
            "event_name": "Application",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "EventViewer-Application",
            "log_stream_name": "{instance_id}"
          },
          {
            "event_name": "System",
            "event_levels": ["ERROR", "WARNING"],
            "log_group_name": "EventViewer-System",
            "log_stream_name": "{instance_id}"
          }
        ]
      }
    }
  }
}




 cd "C:\Program Files\Amazon\AmazonCloudWatchAgent"
>> .\amazon-cloudwatch-agent-ctl.ps1 -a fetch-config -m ec2 -c file:"C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json" -s
>> C:\Program Files\Amazon\AmazonCloudWatchAgent>
****** processing amazon-cloudwatch-agent ******
I! Trying to detect region from ec2
D! [EC2] Found active network interface
I! imds retry client will retry 1 timesSuccessfully fetched the config and saved in C:\ProgramData\Amazon\AmazonCloudWatchAgent\Configs\file_config.json.tmp
Start configuration validation...
2025/04/08 05:28:39 Reading json config file path: C:\ProgramData\Amazon\AmazonCloudWatchAgent\Configs\file_config.json.tmp ...
2025/04/08 05:28:39 E! Invalid Json input schema.
2025/04/08 05:28:39 E! Invalid Json input schema.
2025/04/08 05:28:39 Under path : /logs | Error : Must validate at least one schema (anyOf)
2025/04/08 05:28:39 Under path : /logs | Error : logs_collected is required
2025/04/08 05:28:39 Under path : /logs | Error : Additional property windows_events is not allowed
2025/04/08 05:28:39 Configuration validation first phase failed. Agent version: 1.0. Verify the JSON input is only using features supported by this version.
PS C:\Program Files\Amazon\Amazon



>>
****** processing amazon-cloudwatch-agent ******
I! Trying to detect region from ec2
D! [EC2] Found active network interface
I! imds retry client will retry 1 times2025/04/08 05:19:44 E! Fail to fetch/remove json config: open C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json: The system cannot find the file specified.
E! Fail to fetch/remove json config: open C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json: The system cannot find the file specified.
Fail to fetch the config!
PS C:\Program Files\Amazon\AmazonCloudWatchAgent>


cd "C:\Program Files\Amazon\AmazonCloudWatchAgent"
.\amazon-cloudwatch-agent-ctl.ps1 -a fetch-config -m ec2 -c file:"C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json" -s



{
  "logs": {
    "windows_events": [
      {
        "event_name": "Application",
        "event_levels": ["ERROR", "WARNING"],
        "log_group_name": "EventViewer-Application",
        "log_stream_name": "{instance_id}"
      },
      {
        "event_name": "System",
        "event_levels": ["ERROR", "WARNING"],
        "log_group_name": "EventViewer-System",
        "log_stream_name": "{instance_id}"
      }
    ]
  }
}



C:\Program Files\Amazon\AmazonCloudWatchAgent\config.json


cd "C:\Temp\CWAgent"
.\install.ps1


Expand-Archive -Path "C:\Temp\AmazonCloudWatchAgent.zip" -DestinationPath "C:\Temp\CWAgent"


Invoke-WebRequest https://s3.amazonaws.com/amazoncloudwatch-agent/windows/amd64/latest/AmazonCloudWatchAgent.zip -OutFile "C:\Temp\AmazonCloudWatchAgent.zip"


import com.ecm1.ECM1.controller.ECMcontroller;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelectorGUI {
    private final ECMcontroller mcontroller;
    private final JPanel mainPanel, postPanel, deletePanel, buttonPanel;
    private final JTextField txtWorkingDir, txtExcelFile, txtInputDir, txtOutputReport, txtOutputDir, txtDeleteId;
    private final JButton btnRunPost, btnRunDelete;

    public FileSelectorGUI(ECMcontroller mcontroller) {
        this.mcontroller = mcontroller;

        // Create Frame
        JFrame frame = new JFrame("ECM File Selector");
        frame.setSize(550, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // ** Card Layout to Switch Between Panels **
        CardLayout cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        // ** Post Panel **
        postPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        postPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton btnWorkingDir = new JButton("Select Working Dir");
        JButton btnExcelFile = new JButton("Select Excel File");
        JButton btnInputDir = new JButton("Select Input Dir");
        JButton btnOutputReport = new JButton("Select Report File");
        JButton btnOutputDir = new JButton("Select Output Dir");
        btnRunPost = new JButton("Run Post");

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
        btnRunPost.addActionListener(e -> runProcessing());

        postPanel.add(btnWorkingDir); postPanel.add(txtWorkingDir);
        postPanel.add(btnExcelFile); postPanel.add(txtExcelFile);
        postPanel.add(btnInputDir); postPanel.add(txtInputDir);
        postPanel.add(btnOutputReport); postPanel.add(txtOutputReport);
        postPanel.add(btnOutputDir); postPanel.add(txtOutputDir);
        postPanel.add(new JLabel()); postPanel.add(btnRunPost);

        // ** Delete Panel **
        deletePanel = new JPanel(new GridLayout(2, 2, 10, 10));
        deletePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblDeleteId = new JLabel("Enter ID to Delete:");
        txtDeleteId = createTextField();
        btnRunDelete = new JButton("Run Delete");
        btnRunDelete.addActionListener(e -> runDelete());

        deletePanel.add(lblDeleteId);
        deletePanel.add(txtDeleteId);
        deletePanel.add(new JLabel());
        deletePanel.add(btnRunDelete);

        // ** Button Panel (Post/Delete) **
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
        JButton btnPost = new JButton("Post");
        JButton btnDelete = new JButton("Delete");

        btnPost.setPreferredSize(new Dimension(150, 40));
        btnDelete.setPreferredSize(new Dimension(150, 40));

        btnPost.addActionListener(e -> cardLayout.show(mainPanel, "Post"));
        btnDelete.addActionListener(e -> cardLayout.show(mainPanel, "Delete"));

        buttonPanel.add(btnPost);
        buttonPanel.add(btnDelete);

        // Add to main layout
        mainPanel.add(new JPanel(), "Empty"); // Placeholder
        mainPanel.add(postPanel, "Post");
        mainPanel.add(deletePanel, "Delete");

        frame.add(buttonPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);
        cardLayout.show(mainPanel, "Empty");

        frame.setVisible(true);
    }

    // Helper method to create text fields
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(200, 25));
        return textField;
    }

    private void selectFile(String title, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser(new File("C:\\"));
        fileChooser.setDialogTitle(title);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void selectDirectory(String title, JTextField textField) {
        JFileChooser directoryChooser = new JFileChooser(new File("C:\\"));
        directoryChooser.setDialogTitle(title);
        directoryChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = directoryChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(directoryChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void runProcessing() {
        if (txtExcelFile.getText().isEmpty() || txtInputDir.getText().isEmpty() || txtOutputDir.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select all required fields!", "Missing Inputs", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.processFiles(txtExcelFile.getText(), txtInputDir.getText(), txtOutputDir.getText());
        JOptionPane.showMessageDialog(null, result, "Process Complete", JOptionPane.INFORMATION_MESSAGE);
    }

    private void runDelete() {
        String deleteId = txtDeleteId.getText().trim();
        if (deleteId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an ID!", "Missing ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.deleteFile(deleteId);
        JOptionPane.showMessageDialog(null, result, "Delete Complete", JOptionPane.INFORMATION_MESSAGE);
    }
}




import com.ecm1.ECM1.controller.ECMcontroller;
import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileSelectorGUI {
    private final FileSelectionData fileData;
    private final ECMcontroller mcontroller;
    private final JTextField txtWorkingDir, txtExcelFile, txtInputDir, txtOutputReport, txtOutputDir, txtDeleteId;
    private final JButton btnPost, btnDelete, btnRunPost, btnRunDelete;
    private final JPanel postPanel, deletePanel;

    public FileSelectorGUI(ECMcontroller mcontroller) {
        this.mcontroller = mcontroller;
        this.fileData = new FileSelectionData();

        // Create frame
        JFrame frame = new JFrame("ECM File Selector");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Main selection panel (Post/Delete)
        JPanel selectionPanel = new JPanel();
        btnPost = new JButton("Post");
        btnDelete = new JButton("Delete");
        selectionPanel.add(btnPost);
        selectionPanel.add(btnDelete);

        // Post Panel
        postPanel = new JPanel();
        postPanel.setLayout(new GridLayout(6, 2, 10, 10));
        postPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JButton btnWorkingDir = new JButton("Select Working Dir");
        JButton btnExcelFile = new JButton("Select Excel File");
        JButton btnInputDir = new JButton("Select Input Dir");
        JButton btnOutputReport = new JButton("Select Report File");
        JButton btnOutputDir = new JButton("Select Output Dir");
        btnRunPost = new JButton("Run Post");

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
        btnRunPost.addActionListener(e -> runProcessing());

        postPanel.add(btnWorkingDir);
        postPanel.add(txtWorkingDir);
        postPanel.add(btnExcelFile);
        postPanel.add(txtExcelFile);
        postPanel.add(btnInputDir);
        postPanel.add(txtInputDir);
        postPanel.add(btnOutputReport);
        postPanel.add(txtOutputReport);
        postPanel.add(btnOutputDir);
        postPanel.add(txtOutputDir);
        postPanel.add(new JLabel()); // Empty cell
        postPanel.add(btnRunPost);

        // Delete Panel
        deletePanel = new JPanel();
        deletePanel.setLayout(new GridLayout(2, 2, 10, 10));
        deletePanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel lblDeleteId = new JLabel("Enter ID to Delete:");
        txtDeleteId = createTextField();
        btnRunDelete = new JButton("Run Delete");
        btnRunDelete.addActionListener(e -> runDelete());

        deletePanel.add(lblDeleteId);
        deletePanel.add(txtDeleteId);
        deletePanel.add(new JLabel()); // Empty cell
        deletePanel.add(btnRunDelete);

        // Initially hide both panels
        postPanel.setVisible(false);
        deletePanel.setVisible(false);

        // Button actions
        btnPost.addActionListener(e -> {
            postPanel.setVisible(true);
            deletePanel.setVisible(false);
        });

        btnDelete.addActionListener(e -> {
            deletePanel.setVisible(true);
            postPanel.setVisible(false);
        });

        // Main layout
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(selectionPanel, BorderLayout.NORTH);
        mainPanel.add(postPanel, BorderLayout.CENTER);
        mainPanel.add(deletePanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    // Creates a text field for displaying selected file paths
    private JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setEditable(false);
        return textField;
    }

    private void selectFile(String title, JTextField textField) {
        JFileChooser fileChooser = new JFileChooser(new File("C:\\")); // Default to C:\ drive
        fileChooser.setDialogTitle(title);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
        }
    }

    private void selectDirectory(String title, JTextField textField) {
        JFileChooser directoryChooser = new JFileChooser(new File("C:\\")); // Default to C:\ drive
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

    private void runDelete() {
        String deleteId = txtDeleteId.getText().trim();
        if (deleteId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Error: Please enter an ID!", "Missing ID", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String result = mcontroller.deleteFile(deleteId);
        JOptionPane.showMessageDialog(null, result, "Delete Complete", JOptionPane.INFORMATION_MESSAGE);
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
