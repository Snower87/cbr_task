package ru.begletsov.sort;

import ru.begletsov.docum.Docum;

import java.util.Comparator;

/**
 /* Класс-компаратор DocCompBySizePaperIncrease сортирует данные Docum по размеру бумаги <<по возрастанию>>
 * 1) создание компаратора
 * @author Sergei Begletsov
 * @since 29.06.2020
 * @version 1
 */

public class DocCompBySizePaperIncrease implements Comparator<Docum> {
    @Override
    public int compare(Docum obj1, Docum obj2) {
        return obj1.getSizePaper().compareTo(obj2.getSizePaper());
    }
}
