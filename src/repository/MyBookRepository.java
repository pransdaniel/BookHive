package repository;

import java.util.ArrayList;

import entity.MyBook;

public interface MyBookRepository {
    
  public ArrayList<MyBook> getAll(String keyword,String status);

  public boolean tambah(MyBook myBook);

  public boolean hapus(int isbn);
  
  public boolean changeStatus(int isbn, boolean status);
  
  public boolean changeTittle(int isbn, String judul);

  public boolean updateReading(int isbn, int currentPages);

  
  ArrayList<MyBook> search(ArrayList<MyBook> myBook, String keywords);
  
  public MyBook getBookByISBN(int isbn);
  
  boolean change(int isbn, MyBook buku);
}
