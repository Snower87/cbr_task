package ru.begletsov.sort;

import ru.begletsov.docum.Docum;

import java.util.Comparator;

public class DocCompBySizePaperIncrease implements Comparator<Docum> {
    @Override
    public int compare(Docum obj1, Docum obj2) {
        return obj1.getSizePaper().compareTo(obj2.getSizePaper());
    }
}
