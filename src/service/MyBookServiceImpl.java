package service;
//fix
import java.util.ArrayList;
import entity.MyBook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.DefaultEditorKit;
import repository.MyBookRepository;
import util.ButtonEditor;

public class MyBookServiceImpl implements MyBookService {
  private MyBookRepository myBookRepository;
  private JTable tblMyBook;
    private JTable tblArchived;

  public MyBookServiceImpl(MyBookRepository myBookRepository){
    this.myBookRepository = myBookRepository;
 }
  
  @Override
    public void setTableMyBook(JTable tblMyBook) {
        this.tblMyBook = tblMyBook;
       showMyBooks("","");
    }
    
    @Override
    public void setTableArchived(JTable tblArchived) {
        this.tblArchived = tblArchived;
        System.out.println("Show table archived");
        showMyArchived("","Diarsipkan");
    }
    
     @Override 
    public MyBook getByIsbn(int isbn) {
        return myBookRepository.getBookByISBN(isbn);
    }
    
    @Override
    public void tableHandling() {

        try {
            JTable tblBuku = this.tblMyBook;
            tblMyBook.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject anEvent) {
                    return false;
                }
            });


            {

                ButtonEditor btnArchive = new ButtonEditor(new JCheckBox());
                btnArchive.button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = tblBuku.getSelectedRow();
                        int column = tblBuku.getSelectedColumn();
                        DefaultTableModel model = (DefaultTableModel) tblBuku.getModel();

                        if (row >= 0 && column == 3) {
                            int MyIsbn = (int) model.getValueAt(row, 0);
                            MyBook book = myBookRepository.getBookByISBN(MyIsbn);
                            book.setArchived(true);
                            changeStatus(MyIsbn, true);
                            showMyBooks("","");
                            
                        }

                    }
                });

                tblMyBook.getColumnModel().getColumn(3).setCellRenderer(new util.ButtonRenderer());
                tblMyBook.getColumnModel().getColumn(3).setCellEditor(btnArchive);
                // Membuat Button untuk kolom di JTable
                {
                    // Membuat Button Editor untuk ditambahkan ke kolom JTabel
                    ButtonEditor btnDeleteEditor = new ButtonEditor(new JCheckBox());
                    // Menambahkan ActionListener ke Button yang ada di Button Editor
                    btnDeleteEditor.button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int row = tblBuku.getSelectedRow();
                            int column = tblBuku.getSelectedColumn();
                            DefaultTableModel model = (DefaultTableModel) tblBuku.getModel();

                            if (row >= 0 && column == 4) {
                                int isbn = (int) model.getValueAt(row, 0);
                                removeMyBook(isbn);
                                showMyBooks("","");
                            }

                        }
                    });
                    // Menambahkan Button Editor ke JTable
                    tblBuku.getColumnModel().getColumn(4).setCellRenderer(new util.ButtonRenderer());
                    tblBuku.getColumnModel().getColumn(4).setCellEditor(btnDeleteEditor);
                }

                // Menambahkan CellEditorListener untuk menangkap perubahan pada kolom di JTable
                tblBuku.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingStopped(ChangeEvent e) {
                        int row = tblBuku.getSelectedRow();
                        int column = tblBuku.getSelectedColumn();
                        String selectedValue = tblBuku.getValueAt(row, column).toString();
                        System.out.println("Cell di baris " + row + ", kolom " + column + " diubah menjadi: " + selectedValue);
                        changeTitle((Integer) tblBuku.getValueAt(row, 0), selectedValue);
                        showMyBooks("", "");
                    }

                    @Override
                    public void editingCanceled(ChangeEvent e) {
                        // aksi jika pengiditan dibatalkan
                    }
                });
            }
        } catch (Error | Exception e) {

        }
    }
    
    @Override
    public void tableArchivedHandling() {
        try {
            JTable tblArsip = this.tblArchived;
            tblArchived.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject anEvent) {
                    return false;
                }
            });


            {

                ButtonEditor btnArchive = new ButtonEditor(new JCheckBox());
                btnArchive.button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.out.println("error");
                        int row = tblArchived.getSelectedRow();
                        int column = tblArchived.getSelectedColumn();
                        DefaultTableModel model = (DefaultTableModel) tblArsip.getModel();

                        if (row >= 0 && column == 3) {
                            int Isbn = (int) model.getValueAt(row, 0);
                            MyBook book = myBookRepository.getBookByISBN(Isbn);
                            book.setArchived(true);
                            changeStatus(Isbn, false);
                            showMyArchived ("","Diarsipkan");               
                        }

                    }
                });

                tblArchived.getColumnModel().getColumn(3).setCellRenderer(new util.ButtonRenderer());
                tblArchived.getColumnModel().getColumn(3).setCellEditor(btnArchive);
                // Membuat Button untuk kolom di JTable
                {
                    // Membuat Button Editor untuk ditambahkan ke kolom JTabel
                    ButtonEditor btnDeleteEditor = new ButtonEditor(new JCheckBox());
                    // Menambahkan ActionListener ke Button yang ada di Button Editor
                    btnDeleteEditor.button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int row = tblArsip.getSelectedRow();
                            int column = tblArsip.getSelectedColumn();
                            DefaultTableModel model = (DefaultTableModel) tblArsip.getModel();

                            if (row >= 0 && column == 4) {
                                int isbn = (int) model.getValueAt(row, 0);
                                removeMyBook(isbn);
                                showMyArchived("","");
                            }

                        }
                    });
                    // Menambahkan Button Editor ke JTable
                    tblArchived.getColumnModel().getColumn(4).setCellRenderer(new util.ButtonRenderer());
                    tblArchived.getColumnModel().getColumn(4).setCellEditor(btnDeleteEditor);
                }

                // Menambahkan CellEditorListener untuk menangkap perubahan pada kolom di JTable
                tblArsip.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingStopped(ChangeEvent e) {
                        int row = tblArsip.getSelectedRow();
                        int column = tblArsip.getSelectedColumn();
                        String selectedValue = tblArsip.getValueAt(row, column).toString();
                        System.out.println("Cell di baris " + row + ", kolom " + column + " diubah menjadi: " + selectedValue);
                        changeTitle((Integer) tblArchived.getValueAt(row, 0), selectedValue);
                        showMyArchived("", "");
                    }

                    @Override
                    public void editingCanceled(ChangeEvent e) {
                        // aksi jika pengiditan dibatalkan
                    }
                });
            }
        } catch (Error | Exception e) {

        }
    }
    
     @Override
       public void changeMyBook(Integer number, String string, boolean status) {
        System.out.println("isbn: " + number);
        
        MyBook book = new MyBook(number, string, status);
        boolean sukses = myBookRepository.change(number, book);
        System.out.println("Status: " + book.isStatus());
        if (sukses) {
            System.out.println("SUKSES MENGUBAH MY BOOK : posisi ke-" + number + " menjadi " + book.getActivity());
        } else {
            System.out.println("GAGAL MENGUBAH MY BOOK : posisi ke-" + number + " menjadi " + book.getActivity() + ". Todo tidak tersedia.");
        }
    }
       


    
    @Override
    public void loadData(String keywords, String cbxStat) {
        JTable tblBook = this.tblMyBook;
        ArrayList<MyBook> model = myBookRepository.getAll(keywords,"Tidak Archived");
        System.out.println("data table " + model.toString());
        DefaultTableModel tableModel = new DefaultTableModel(null, new Object[]{"ISBN", "Title", "Pages","Status", "Aksi"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        
        if (!model.isEmpty()) {
            for (var i = 0; i < model.size(); i++) {
              var mybook = model.get(i);
              var status = "Belum Diarsipkan";

              if (mybook != null) {
                  if (mybook.isArchived()) {
                      status = "Diarsipkan";
                  }
                  if (keywords == null || (mybook.getTitle().contains(keywords))) {
                  tableModel.addRow(new Object[]{mybook.getIsbn(), mybook.getTitle(),mybook.getTotalPages(), status, "Hapus"});
                  }
                  }
            }
        } 

        tblBook.setModel(tableModel);
        tblBook.setCellSelectionEnabled(false);
        tblBook.setRowSelectionAllowed(true);
        tblBook.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblBook.setRowHeight(40);

        TableColumnModel columnModel = tblBook.getColumnModel();

        TableColumn columnISBN = columnModel.getColumn(0);
        columnISBN.setPreferredWidth(70);

        TableColumn columnTitle = columnModel.getColumn(1);
        columnTitle.setPreferredWidth(225);
        
        TableColumn columnTotalPages = columnModel.getColumn(2);
        columnTotalPages.setPreferredWidth(70);

        TableColumn columnStatus = columnModel.getColumn(3);
        columnStatus.setPreferredWidth(110);

        TableColumn columnAksi = columnModel.getColumn(4);
        columnAksi.setPreferredWidth(100);
        
    }
    
    @Override
    public void loadDataArchived(String keywords, String cbxStat) {
        JTable tblArsip = this.tblArchived;
        ArrayList<MyBook> model = myBookRepository.getAll(keywords,"Diarsipkan");
      System.out.println("data table " + model.toString());
        DefaultTableModel tableModel = new DefaultTableModel(null, new Object[]{"ISBN", "Title", "Pages","Status", "Aksi"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };
        
        if (!model.isEmpty()) {
            for (var i = 0; i < model.size(); i++) {
              var buku = model.get(i);
              var status = "Belum Diarsipkan";

              if (buku != null) {
                  if (buku.isArchived()) {
                      status = "Diarsipkan";
                  }
                  
                  tableModel.addRow(new Object[]{buku.getIsbn(), buku.getTitle(),buku.getTotalPages(), status, "Hapus"});
              }
            }
        } 

        tblArchived.setModel(tableModel);
        tblArchived.setCellSelectionEnabled(false);
        tblArchived.setRowSelectionAllowed(true);
        tblArchived.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblArchived.setRowHeight(40);

        TableColumnModel columnModel = tblArchived.getColumnModel();

        TableColumn columnISBN = columnModel.getColumn(0);
        columnISBN.setPreferredWidth(110);

        TableColumn columnTitle = columnModel.getColumn(1);
        columnTitle.setPreferredWidth(110);
        
        TableColumn columnTotalPages = columnModel.getColumn(2);
        columnTotalPages.setPreferredWidth(110);

        TableColumn columnStatus = columnModel.getColumn(3);
        columnStatus.setPreferredWidth(110);

        TableColumn columnAksi = columnModel.getColumn(4);
        columnAksi.setPreferredWidth(110);
        
    }





  // merupakan service untuk menampilkan semua buku
 @Override
  public void showMyBooks(String keywords, String cbxStat) {
    loadData(keywords, cbxStat);
        tableHandling();
  }
  
  @Override
    public void showMyArchived(String keywords,String cbxstatus) {
        loadDataArchived(keywords,cbxstatus);
        tableArchivedHandling();
    }
 
  
  
  
  // merupakan service untuk menambahkan buku
  @Override
  public void addMyBook(Integer isbn, String title, String author,String publisher, Integer year, Integer totalPages, boolean archives) {
    MyBook myBook = new MyBook(isbn, title, author, publisher, year, totalPages, archives);

		boolean bisa = myBookRepository.tambah(myBook);

		if (bisa) {
			System.out.println("SUKSES MENAMBAH MY BOOK : " + title + " dengan isbn "  + myBook.getIsbn());
		} else {
			System.out.println("GAGAL MENAMBAH MY BOOK : isbn " + myBook.getIsbn() + " telah tersedia");
		}
     
}

// merupkan service untuk menghapus buku
  @Override
  public void removeMyBook(int isbn) {
    boolean bisa = myBookRepository.hapus(isbn);
    if (bisa) {
      System.out.println("SUKSES MENGHAPUS MY BOOK : " + isbn);
    } else {
      System.out.println("GAGAL MENGHAPUS MY BOOK : " + isbn);
    }
  }
  
  //merupakan service untuk mengubah status
  @Override
    public void changeStatus(int isbn, boolean status) {
        System.out.println("isbn: " + isbn);
        boolean hasil = myBookRepository.changeStatus(isbn, status);
        if (hasil) {
            System.out.println("SUKSES MENGUBAH MY BOOK : posisi ke-" + isbn + " menjadi " + status);
        } else {
            System.out.println("GAGAL MENGUBAH MY BOOK : posisi ke-" + isbn + " menjadi " + status + ". Buku tidak tersedia.");
        }
    }
  
    // merupakan service untuk mengubah title
   @Override
    public void changeTitle(int isbn, String judul) {
        System.out.println("isbn : " + isbn);
        boolean sukses = myBookRepository.changeTittle(isbn, judul);
        
        if (sukses) {
            System.out.println("SUKSES MENGUBAH TODO : posisi ke-" + isbn + " menjadi " + judul);
        } else {
            System.out.println("GAGAL MENGUBAH TODO : posisi ke-" + isbn + " menjadi " + judul + ". Todo tidak tersedia.");
        }
    }
    
    @Override
    public void searchMyBook(JTable tnltodo, String keywords, boolean status) {

        ArrayList<MyBook> model = myBookRepository.getAll(keywords, "");
        ArrayList<MyBook> myBook = myBookRepository.search(model, keywords);

        int count = 0;
        for (MyBook book : myBook) {
            if (book != null) {
                count++;
            } else {
                continue;
            }
        }

        if (count > 0) {
            System.out.println("Ditemukan " + count + " buku untuk hasil pencarian " + keywords);

            for (int position = 0; position < myBook.size(); position++) {
                MyBook book = myBook.get(position);
                if (book != null) {
                    System.out.println((position + 1) + ". " + book.getActivity());
                }
            }
        } else {
            System.out.println("Tidak ditemukan buku untuk hasil pencarian " + keywords);
        }
        System.out.println();
    }




  // merupakan service untuk mengupdate buku yang telah dibaca
  public void updateReadingMyBook(int isbn, int currentPages){
     System.out.println("reading book");
        
        boolean hasil = myBookRepository.updateReading(isbn, currentPages);
        
        if (hasil) {
            System.out.println("SUKSES MEMBACA");
        } else {
            System.out.println("GAGAL MEMBACA");
        }
  }

}



