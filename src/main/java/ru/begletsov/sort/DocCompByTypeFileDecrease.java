package ru.begletsov.sort;

import ru.begletsov.docum.Docum;

import java.util.Comparator;

/**
 /* Класс-компаратор DocCompByTypeFileDecrease сортирует данные Docum по типу документа <<по убыванию>>
 * 1) создание компаратора
 * @author Sergei Begletsov
 * @since 29.06.2020
 * @version 1
 */

public class DocCompByTypeFileDecrease implements Comparator<Docum> {
    @Override
    public int compare(Docum obj1, Docum obj2) {
        return obj2.getTypeFile().compareTo(obj1.getTypeFile());
    }
}
