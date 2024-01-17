package service;

import entity.MyBook;
import javax.swing.JTable;

public interface MyBookService {

  public void showMyBooks(String keywords, String cbxStat);
  
  public void showMyArchived(String keyword,String cbxstatus);
   
  
  void setTableMyBook (JTable tblMyBook);
  
  public void setTableArchived(JTable tblArchived);
  
  public MyBook getByIsbn(int isbn);
        
  void tableHandling();
  
  public void tableArchivedHandling();
  
  void loadData(String keywords, String cbxStat);
  
  public void loadDataArchived(String keywords, String cbxStat);

  public void addMyBook(Integer isbn, String title, String author,String publisher, Integer year, Integer totalPages, boolean archives);

  public void removeMyBook(int isbn);
  
  public void changeStatus(int isbn, boolean status);

  public void changeTitle(int isbn, String judul);
          
  public void updateReadingMyBook(int isbn, int currentPages);
  
  void searchMyBook(JTable tnltodo, String keywords, boolean status);
  
  void changeMyBook(Integer ISBN, String buku, boolean status);
}
