package ru.begletsov.sort;

import ru.begletsov.docum.Docum;

import java.util.Comparator;

/**
 /* Класс-компаратор DocCompByTypeFileIncrease сортирует данные Docum по типу документа <<по возрастанию>>
 * 1) создание компаратора
 * @author Sergei Begletsov
 * @since 29.06.2020
 * @version 1
 */

public class DocCompByTypeFileIncrease implements Comparator<Docum> {
    @Override
    public int compare(Docum obj1, Docum obj2) {
        return obj1.getTypeFile().compareTo(obj2.getTypeFile());
    }
}
