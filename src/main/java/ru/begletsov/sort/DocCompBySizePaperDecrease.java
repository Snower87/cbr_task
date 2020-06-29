package ru.begletsov.sort;

import ru.begletsov.docum.Docum;

import java.util.Comparator;

public class DocCompBySizePaperDecrease implements Comparator<Docum> {
    @Override
    public int compare(Docum obj1, Docum obj2) {
        return obj2.getSizePaper().compareTo(obj1.getSizePaper());
    }
}
