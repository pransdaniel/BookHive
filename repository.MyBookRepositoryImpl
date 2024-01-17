package repository;
//fix

import java.util.ArrayList;

import entity.MyBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.mariadb.jdbc.message.client.BulkExecutePacket;
import util.DB;

public class MyBookRepositoryImpl implements MyBookRepository {

    public ArrayList<MyBook> data = new ArrayList<MyBook>();

    private final DB db;
    private String keywords;

    public MyBookRepositoryImpl() {
        db = new DB();
    }

    @Override
    public ArrayList<MyBook> getAll(String keyword, String status) {
        String query = "SELECT * FROM USERS";
        ResultSet resultSet = db.getAllData(query, null);
        ArrayList<MyBook> model = new ArrayList<>();

        if (resultSet != null) {

            try {
                while (resultSet.next()) {

                    Integer isbn = resultSet.getInt("isbn");

                    String title = resultSet.getString("title");

                    String author = resultSet.getString("authors");

                    String publhiser = resultSet.getString("publhiser");

                    int year = resultSet.getInt("year");

                    int totalPages = resultSet.getInt("pages");

                    boolean archives = resultSet.getBoolean("archives");

                    if (status.equalsIgnoreCase("Diarsipkan")) {
                        MyBook myBook = new MyBook(isbn, title, author, publhiser, year, totalPages, true);
                        model.add(myBook);
                    } else {
                        MyBook myBook = new MyBook(isbn, title, author, publhiser, year, totalPages, archives);
                        model.add(myBook);
                    }
//                    MyBook myBook = new MyBook(isbn, title, author, publhiser, year, totalPages, archives);
//                    model.add(myBook);
                    System.out.println(model);
                }
            } catch (SQLException ex) {
                //Terjadi kesalahan pada JDBC
            }
        }

        return model;
    }

    @Override
    public ArrayList<MyBook> search(ArrayList<MyBook> myBook, String keywords) {

        ArrayList<MyBook> cari_data = new ArrayList<MyBook>();

        for (MyBook book : data) {

            if (book.getActivity().contains(keywords)) {
                cari_data.add(book);

            } else {
                cari_data.add(null);
            }

        }

        return cari_data;
    }

    @Override
    public MyBook getBookByISBN(int ISBN) {
        MyBook myBook = null;
        String query = "SELECT * FROM users WHERE isbn = ?";
        ResultSet resultSet = db.getByISBN(query, ISBN);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {

                    myBook = new MyBook(resultSet.getInt("isbn"), resultSet.getString("title"), resultSet.getString("authors"), resultSet.getString("publhiser"), resultSet.getInt("year"), resultSet.getInt("pages"), resultSet.getBoolean("archives"));
                    myBook.setCurrentPages(resultSet.getInt("current_pages"));
                    break;
                }
            } catch (Exception e) {
                //Terjadi kesalahan pada JDBC
                System.out.println(e);
                System.out.println("Book Tidak ditemukan");
            }
        } else {
            System.out.println("Book tetap tidak ditemukan");
        }
        return myBook;
    }

    @Override
    public boolean tambah(MyBook myBook) {
        String query = "INSERT INTO users (isbn,title,pages,year, archives,authors,publhiser, current_pages) VALUES (?,?,?, ?,?, ?, ?, ?)";

        String status = "Tidak Archived";
        if (myBook.isArchived()) {
            status = "1";
        } else {
            status = "0";
        }
        String[] values = new String[]{String.valueOf(myBook.getIsbn()), myBook.getTitle(), String.valueOf(myBook.getTotalPages()), String.valueOf(myBook.getYear()), String.valueOf(status), myBook.getAuthor(), myBook.getPublisher(), String.valueOf(myBook.getCurrentPages())};

        return db.update(query, values);

    }

    @Override
    public boolean hapus(int isbn) {
        String query = "DELETE FROM users WHERE isbn = ?";
        String[] values = new String[]{String.valueOf(isbn)};
        return db.update(query, values);
    }

    @Override
    public boolean changeStatus(int isbn, boolean status) {
        String query = "UPDATE users SET archives = ? WHERE isbn= ?";
        String stat = "Tidak Diarsipkan";
        if (status) {
            stat = "Diarsipkan";
        }
        String[] values = new String[]{stat, String.valueOf(isbn)};
        return db.update(query, values);

    }

    @Override
    public boolean changeTittle(int isbn, String judul) {
        String query = "UPDATE users SET title = ? WHERE isbn= ?";
        String[] values = new String[]{judul, String.valueOf(isbn)};
        return db.update(query, values);

    }

    @Override
    public boolean change(int isbn, MyBook buku) {

        String query = "UPDATE users SET title = ?, status = ? WHERE isbn= ?";
        String status = "Tidak Diarsipkan";
        if (buku.isStatus()) {
            status = "Diarsipkan";
        }
        String[] values = new String[]{buku.getActivity(), status, String.valueOf(isbn)};
        return db.update(query, values);
    }

    @Override
    public boolean updateReading(int isbn, int currentPages) {
        String query = "UPDATE users SET current_pages = LEAST(?, pages) WHERE isbn = ?";

        String[] values = new String[]{String.valueOf(currentPages), String.valueOf(isbn)};
        return db.update(query, values);
    }



  
}
