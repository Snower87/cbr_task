package ru.begletsov.sort;

import ru.begletsov.docum.Docum;

import java.util.Comparator;

/**
 /* Класс-компаратор DocCompByTimePrintingIncrease сортирует данные Docum по времени печати <<по возрастанию>>
 * 1) создание компаратора
 * @author Sergei Begletsov
 * @since 29.06.2020
 * @version 1
 */

public class DocCompByTimePrintingIncrease implements Comparator<Docum> {
    @Override
    public int compare(Docum obj1, Docum obj2) {
        return Integer.compare(obj1.getTimePrinting(), obj2.getTimePrinting());
    }
}
