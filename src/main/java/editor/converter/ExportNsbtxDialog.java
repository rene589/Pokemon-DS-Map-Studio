
package editor.converter;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle;
import javax.swing.border.*;

import editor.handler.MapEditorHandler;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

import utils.Utils;
import utils.swing.*;

/**
 * @author Trifindo
 */
public class ExportNsbtxDialog extends javax.swing.JDialog {

    public static final int APPROVE_OPTION = 1, CANCEL_OPTION = 0;
    private int returnValue = CANCEL_OPTION;

    private String nsbtxFolderPath = "";
    private ArrayList<Integer> selectedAreaIndices = new ArrayList<>();
    private ArrayList<Integer> areaIndices;

    private MapEditorHandler handler;

    /**
     * Creates new form ExportImdDialog
     */
    public ExportNsbtxDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        getRootPane().setDefaultButton(jbAccept);
        jbAccept.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jScrollCheckboxList = new JScrollCheckboxList();
        jbSelectAll = new JButton();
        jbDeselectAll = new JButton();
        jbCancel = new JButton();
        jbAccept = new JButton();
        jPanel2 = new JPanel();
        jLabel3 = new JLabel();
        jtfNsbtxFolderPath = new JTextField();
        jbNsbBrowse = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Export Areas as NSBTX (Experimental)");
        setModal(true);
        Container contentPane = getContentPane();

        //======== jPanel1 ========
        {
            jPanel1.setBorder(new TitledBorder("NSBTX settings"));

            //---- jLabel1 ----
            jLabel1.setText("Select the areas that will be exported as NSBTX:");

            //---- jScrollCheckboxList ----
            jScrollCheckboxList.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            jScrollCheckboxList.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

            //---- jbSelectAll ----
            jbSelectAll.setText("Select All");
            jbSelectAll.addActionListener(e -> jbSelectAllActionPerformed(e));

            //---- jbDeselectAll ----
            jbDeselectAll.setText("Deselect All");
            jbDeselectAll.addActionListener(e -> jbDeselectAllActionPerformed(e));

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                    jPanel1Layout.createParallelGroup()
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel1Layout.createParallelGroup()
                                            .addComponent(jScrollCheckboxList, GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                    .addGroup(jPanel1Layout.createParallelGroup()
                                                            .addComponent(jLabel1)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                    .addComponent(jbSelectAll)
                                                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                    .addComponent(jbDeselectAll)))
                                                    .addGap(0, 0, Short.MAX_VALUE)))
                                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                    jPanel1Layout.createParallelGroup()
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollCheckboxList, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jbSelectAll)
                                            .addComponent(jbDeselectAll))
                                    .addContainerGap())
            );
        }

        //---- jbCancel ----
        jbCancel.setText("Cancel");
        jbCancel.addActionListener(e -> jbCancelActionPerformed(e));

        //---- jbAccept ----
        jbAccept.setText("OK");
        jbAccept.setPreferredSize(new Dimension(65, 23));
        jbAccept.addActionListener(e -> jbAcceptActionPerformed(e));

        //======== jPanel2 ========
        {
            jPanel2.setBorder(new TitledBorder("NSBTX settings"));

            //---- jLabel3 ----
            jLabel3.setText("NSBTX destination folder path:");

            //---- jtfNsbtxFolderPath ----
            jtfNsbtxFolderPath.setEditable(false);

            //---- jbNsbBrowse ----
            jbNsbBrowse.setText("Browse...");
            jbNsbBrowse.addActionListener(e -> jbNsbBrowseActionPerformed(e));

            GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
            jPanel2.setLayout(jPanel2Layout);
            jPanel2Layout.setHorizontalGroup(
                    jPanel2Layout.createParallelGroup()
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jtfNsbtxFolderPath, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jbNsbBrowse)
                                    .addContainerGap())
            );
            jPanel2Layout.setVerticalGroup(
                    jPanel2Layout.createParallelGroup()
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(jtfNsbtxFolderPath, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jbNsbBrowse))
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jPanel1, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(contentPaneLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jbAccept, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jbCancel)))
                                .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
                contentPaneLayout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jbCancel)
                                        .addComponent(jbAccept, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
    }// </editor-fold>//GEN-END:initComponents

    private void jbAcceptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAcceptActionPerformed
        if (!new File(nsbtxFolderPath).exists()) {
            JOptionPane.showMessageDialog(this,
                    "Please select a valid output folder for exporting the NSBTX files.",
                    "Invalid NSBTX folder",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            DefaultListModel<JCheckBox> model = (DefaultListModel<JCheckBox>) jScrollCheckboxList.getCheckboxList().getModel();
            selectedAreaIndices = new ArrayList<>(model.getSize());
            for (int i = 0; i < model.getSize(); i++) {
                if (model.get(i).isSelected()) {
                    selectedAreaIndices.add(areaIndices.get(i));
                }
            }
            if (selectedAreaIndices.size() > 0) {
                returnValue = APPROVE_OPTION;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this,
                        "There are no Areas selected for converting into NSBTX.\n"
                                + "Select at least one Area from the list.", "No Areas selected",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jbAcceptActionPerformed

    private void jbCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelActionPerformed
        returnValue = CANCEL_OPTION;
        dispose();
    }//GEN-LAST:event_jbCancelActionPerformed

    private void jbSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSelectAllActionPerformed
        DefaultListModel<JCheckBox> model = (DefaultListModel<JCheckBox>) jScrollCheckboxList.getCheckboxList().getModel();
        for (int i = 0; i < model.getSize(); i++) {
            model.get(i).setSelected(true);
        }
        jScrollCheckboxList.repaint();
    }//GEN-LAST:event_jbSelectAllActionPerformed

    private void jbDeselectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbDeselectAllActionPerformed
        DefaultListModel<JCheckBox> model = (DefaultListModel<JCheckBox>) jScrollCheckboxList.getCheckboxList().getModel();
        for (int i = 0; i < model.getSize(); i++) {
            model.get(i).setSelected(false);
        }
        jScrollCheckboxList.repaint();
    }//GEN-LAST:event_jbDeselectAllActionPerformed

    private void jbNsbBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNsbBrowseActionPerformed
        final JFileChooser fc = new JFileChooser();
        File folder = new File(Utils.removeExtensionFromPath(handler.getMapMatrix().filePath)).getParentFile();
        fc.setCurrentDirectory(folder);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.setApproveButtonText("Select folder");
        fc.setDialogTitle("Select the folder for exporting the IMD files");

        final int returnValOpen = fc.showOpenDialog(this);
        if (returnValOpen == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            if (file.exists() && file.isDirectory()) {
                nsbtxFolderPath = file.getPath();
                jtfNsbtxFolderPath.setText(nsbtxFolderPath);
            }
        }
    }//GEN-LAST:event_jbNsbBrowseActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JPanel jPanel1;
    private JLabel jLabel1;
    private JScrollCheckboxList jScrollCheckboxList;
    private JButton jbSelectAll;
    private JButton jbDeselectAll;
    private JButton jbCancel;
    private JButton jbAccept;
    private JPanel jPanel2;
    private JLabel jLabel3;
    private JTextField jtfNsbtxFolderPath;
    private JButton jbNsbBrowse;
    // End of variables declaration//GEN-END:variables

    public void init(MapEditorHandler handler) {
        this.handler = handler;

        loadAreaIndices();

        String nsbtxFolderPath = new File(Utils.removeExtensionFromPath(handler.getMapMatrix().filePath)).getParent();
        if (isFolderPathValid(nsbtxFolderPath)) {
            this.nsbtxFolderPath = nsbtxFolderPath;
            jtfNsbtxFolderPath.setText(nsbtxFolderPath);
        }

    }

    private boolean isFolderPathValid(String folderPath) {
        try {
            File file = new File(folderPath);
            return file.isDirectory();
        } catch (Exception ex) {
            return false;
        }
    }

    private void loadAreaIndices() {

        TreeSet<Integer> areaIndicesSet = handler.getMapMatrix().getAreaIndices();

        areaIndices = new ArrayList();
        areaIndices.addAll(areaIndicesSet);

        try {
            DefaultListModel<JCheckBox> model = new DefaultListModel();
            this.jScrollCheckboxList.getCheckboxList().setModel(model);
            for (Integer areaIndex : areaIndicesSet) {
                model.addElement(new JCheckBox("Area " + String.valueOf(areaIndex)));
            }

            for (int i = 0; i < model.getSize(); i++) {
                model.get(i).setSelected(true);
            }
            jScrollCheckboxList.getCheckboxList().setModel(model);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private boolean hasMatrixCoordsInImdName(String imdName) {
        String name = Utils.removeExtensionFromPath(imdName);
        try {
            String[] splitName = name.split("_");
            return (hasCoordInName(splitName[splitName.length - 2])
                    && hasCoordInName(splitName[splitName.length - 1]));
        } catch (Exception ex) {
            return false;
        }
    }

    private boolean hasCoordInName(String name) {
        try {
            Integer.parseInt(name);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public int getReturnValue() {
        return returnValue;
    }

    public String getNsbtxFolderPath() {
        return nsbtxFolderPath;
    }

    public ArrayList<Integer> getSelectedAreaIndices() {
        return selectedAreaIndices;
    }


}