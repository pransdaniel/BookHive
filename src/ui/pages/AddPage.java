
package ui.pages;


import entity.MyBook;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import service.MyBookService;

public class AddPage extends javax.swing.JPanel {
 
    private MyBookService myBookService;
    private DefaultTableModel tableModel;
    private JTable tblMyBook;
    private MyBook myBook;
    private boolean archives;
    
    public AddPage() {
        initComponents();
        
        tblMyBook = new JTable(tableModel);
        tableModel = new DefaultTableModel(new Object[]{"ISBN", "Title", "Author", "Publisher", "Year", "Pages"}, 0);
        tblMyBook.setModel(tableModel);
        myBook = new MyBook();
        
    }    
    
    /*public void reset () {
        lblActivityError.setText("");
    }
    */
    
   /* public void setTodolistView(TodolistView todolistView) {
        this.todolistView = todolistView;

    }
    */
    
    public void setMyBookService(MyBookService myBookService) {
        this.myBookService = myBookService;
      
    }
    
        public void setTableMyBook(JTable tblMyBook) {
        this.tblMyBook = tblMyBook;
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        txtAddIsbn = new javax.swing.JTextField();
        lblTitle = new javax.swing.JLabel();
        lblisbn = new javax.swing.JLabel();
        txtTitle = new javax.swing.JTextField();
        txtPages = new javax.swing.JTextField();
        lblPages = new javax.swing.JLabel();
        txtAuthor = new javax.swing.JTextField();
        txtPublisher = new javax.swing.JTextField();
        txtYear = new javax.swing.JTextField();
        lblYear = new javax.swing.JLabel();
        lblPublisher = new javax.swing.JLabel();
        lblAuthor = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(600, 567));

        jPanel1.setBackground(new java.awt.Color(224, 196, 164));

        jLabel1.setFont(new java.awt.Font("YouYuan", 1, 30)); // NOI18N
        jLabel1.setText("  Add Your Book Here!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(224, 196, 164));

        btnAdd.setBackground(new java.awt.Color(91, 137, 236));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtAddIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddIsbnActionPerformed(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("Title ");

        lblisbn.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        lblisbn.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblisbn.setText("ISBN ");

        txtTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTitleActionPerformed(evt);
            }
        });

        txtPages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPagesActionPerformed(evt);
            }
        });

        lblPages.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        lblPages.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPages.setText("Pages");

        txtAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAuthorActionPerformed(evt);
            }
        });

        txtPublisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPublisherActionPerformed(evt);
            }
        });

        txtYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtYearActionPerformed(evt);
            }
        });

        lblYear.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        lblYear.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblYear.setText("Year");

        lblPublisher.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        lblPublisher.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPublisher.setText("Publisher");

        lblAuthor.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        lblAuthor.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblAuthor.setText("Author");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAuthor)
                    .addComponent(lblTitle)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblisbn))
                    .addComponent(lblPublisher)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblYear)
                            .addComponent(lblPages))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAddIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                    .addComponent(txtTitle)
                    .addComponent(txtAuthor)
                    .addComponent(txtPublisher)
                    .addComponent(txtYear)
                    .addComponent(txtPages))
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAdd)
                .addGap(193, 193, 193))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblisbn))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTitle))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAuthor))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPublisher))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblYear))
                        .addGap(18, 18, 18)
                        .addComponent(txtPages, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPages))
                .addGap(28, 28, 28)
                .addComponent(btnAdd)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    public void reset () {
        txtAddIsbn.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtPublisher.setText("");
        txtYear.setText("");
        txtPages.setText("");
    }
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        
        String isbnStr = txtAddIsbn.getText();
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String publisher = txtPublisher.getText();
        String yearStr = txtYear.getText();
        String totalPagesStr = txtPages.getText();
        try {
            int isbn = Integer.parseInt(isbnStr);
            int year = Integer.parseInt(yearStr);
            int totalPages = Integer.parseInt(totalPagesStr);
            
            Object[] rowData = {isbn, title, author, publisher, year, totalPages, archives};
            tableModel.addRow(rowData);
            
            myBookService.addMyBook(isbn, title, author, publisher, year, totalPages, archives);
            reset(     );
            
        } catch (NumberFormatException e) {
            // Handle the case where ISBN, year, or totalPages cannot be parsed as integers
            System.out.println("Invalid number format");
        } 
        
       
       
        
       
    }//GEN-LAST:event_btnAddActionPerformed

    private void txtAddIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddIsbnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddIsbnActionPerformed

    private void txtTitleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTitleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTitleActionPerformed

    private void txtPagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPagesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPagesActionPerformed

    private void txtAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAuthorActionPerformed

    private void txtPublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPublisherActionPerformed

    private void txtYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtYearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblAuthor;
    private javax.swing.JLabel lblPages;
    private javax.swing.JLabel lblPublisher;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblYear;
    private javax.swing.JLabel lblisbn;
    private javax.swing.JTextField txtAddIsbn;
    private javax.swing.JTextField txtAuthor;
    private javax.swing.JTextField txtPages;
    private javax.swing.JTextField txtPublisher;
    private javax.swing.JTextField txtTitle;
    private javax.swing.JTextField txtYear;
    // End of variables declaration//GEN-END:variables

    
}
