package coopain.view;

import java.awt.Color;
import java.awt.Font;
import java.util.HashMap;
import coopain.DAO.VilleDAO;
import coopain.model.Commune;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;

public class SelectVille extends javax.swing.JDialog {
    private boolean selected;
    private final Commune selectedVille;

    /**
     * Creates new form NewJDialog
     * @param parent
     * @param modal
     * @param codePostal
     * @param numVille
     */
    
    public SelectVille(java.awt.Frame parent, boolean modal, String codePostal, String numVille) {
        super(parent, modal);
        HashMap<Integer, Commune> lesVilles;

        initComponents();
        tableVille.setDefaultRenderer(Object.class, new coopain.technic.CTableRendu());
        scrollTbVille.getViewport().setOpaque(false);
        
        JTableHeader tableHead = tableVille.getTableHeader();
        Font f = tableHead.getFont();
        tableHead.setFont(f.deriveFont(f.getStyle() | Font.BOLD));
        tableHead.setForeground(new Color(191, 0, 24));
        
        lesVilles = VilleDAO.villesPourCp(codePostal);
        DefaultTableModel uiTable = (DefaultTableModel) tableVille.getModel();
        this.selected = false;
        
        this.selectedVille = new Commune(codePostal,numVille,"");
        int i = 0;
        
        for (Integer numV : lesVilles.keySet()) {
            Object[] row = new Object[2];
            row[0] = numV;
            row[1] = lesVilles.get(numV).getNom_Commune();
            uiTable.addRow(row);
            
            // Attention aux comparaisons de chaine de caractères !!! .equals()
            if(numV.toString().equals(numVille)) {
                tableVille.setRowSelectionInterval(i, i);
                this.selectedVille.setNom_Commune(row[1].toString());
            }
            i++;
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Valider = new javax.swing.JButton();
        scrollTbVille = new javax.swing.JScrollPane();
        tableVille = new javax.swing.JTable();
        Abandonner = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(443, 306));
        setModal(true);
        setSize(new java.awt.Dimension(443, 306));
        getContentPane().setLayout(null);

        Valider.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Valider.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/valid_20.png"))); // NOI18N
        Valider.setText("Valider");
        Valider.setToolTipText("Enregister votre selection");
        Valider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ValiderMouseClicked(evt);
            }
        });
        getContentPane().add(Valider);
        Valider.setBounds(12, 231, 101, 30);
        Valider.getAccessibleContext().setAccessibleDescription("Selectionner une ville");

        scrollTbVille.setOpaque(false);

        tableVille.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num", "Selectionner une Commune"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVille.setOpaque(false);
        tableVille.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableVille.getTableHeader().setReorderingAllowed(false);
        tableVille.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVilleMouseClicked(evt);
            }
        });
        tableVille.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tableVilleKeyReleased(evt);
            }
        });
        scrollTbVille.setViewportView(tableVille);
        if (tableVille.getColumnModel().getColumnCount() > 0) {
            tableVille.getColumnModel().getColumn(0).setMinWidth(40);
            tableVille.getColumnModel().getColumn(0).setPreferredWidth(40);
            tableVille.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(scrollTbVille);
        scrollTbVille.setBounds(12, 13, 419, 212);

        Abandonner.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        Abandonner.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/escape_20.png"))); // NOI18N
        Abandonner.setText("Abandonner");
        Abandonner.setToolTipText("Sortir de la fenétre d'envoi");
        Abandonner.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                AbandonnerMouseClicked(evt);
            }
        });
        getContentPane().add(Abandonner);
        Abandonner.setBounds(286, 231, 132, 30);

        background.setDisplayedMnemonic('v');
        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ressources/fec_dark.jpg"))); // NOI18N
        background.setText("jLabel1");
        getContentPane().add(background);
        background.setBounds(-2, 4, 450, 270);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ValiderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ValiderMouseClicked
        selected=true;
        this.dispose();
    }//GEN-LAST:event_ValiderMouseClicked

    private void AbandonnerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_AbandonnerMouseClicked
        selected=false;
        this.dispose();
    }//GEN-LAST:event_AbandonnerMouseClicked

    private void tableVilleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVilleMouseClicked
        changeSelectNum();
    }//GEN-LAST:event_tableVilleMouseClicked

    private void tableVilleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableVilleKeyReleased
        changeSelectNum();
    }//GEN-LAST:event_tableVilleKeyReleased

    private void changeSelectNum() {
       int i = tableVille.getSelectedRow();
       TableModel model = tableVille.getModel();
        this.selectedVille.setNum_Postal(model.getValueAt(i, 0).toString());
        this.selectedVille.setNom_Commune(model.getValueAt(i, 1).toString());
    }
    public Commune getSelectedVille() {
        return selectedVille;
    }

    public boolean isSelected() {
        return selected;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abandonner;
    private javax.swing.JButton Valider;
    private javax.swing.JLabel background;
    private javax.swing.JScrollPane scrollTbVille;
    private javax.swing.JTable tableVille;
    // End of variables declaration//GEN-END:variables
}
