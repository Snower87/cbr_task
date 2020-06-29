package ru.begletsov.sort;

import ru.begletsov.docum.Docum;

import java.util.Comparator;

/**
 /* Класс-компаратор DocCompBySizePaperDecrease сортирует данные Docum по размеру бумаги <<по убыванию>>
 * 1) создание компаратора
 * @author Sergei Begletsov
 * @since 29.06.2020
 * @version 1
 */

public class DocCompBySizePaperDecrease implements Comparator<Docum> {
    @Override
    public int compare(Docum obj1, Docum obj2) {
        return obj2.getSizePaper().compareTo(obj1.getSizePaper());
    }
}
