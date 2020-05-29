package cn.edu.thssdb.storage;

import cn.edu.thssdb.storage.Page;
import cn.edu.thssdb.schema.*;

import java.util.ArrayList;

public interface FileHandler {
    Page readPage(PageId id);

    void writePage(Page p);

    ArrayList<Page> insertRow(Row row);

    ArrayList<Page> deleteRow(Row row);

    ArrayList<Page> updateRow(Row row);

    int getId();

    FileIterator iterator();

    RowDesc getMeta();
}
