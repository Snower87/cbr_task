package ru.begletsov.print;

import ru.begletsov.docum.Docum;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

/**
 /* Класс ManagerPrinter - диспетчер печати документов, принимает и распечатывает документы от пользователя
 * 1) создание класса
 * @author Sergei Begletsov
 * @since 01.07.2020
 * @version 1
 */

public class ManagerPrinter {
    //1. Поля
    List<Docum> documentList;
    ThreadPrinter myThread;
    int nFile = 0; //номер файла

    //2. Конструктор
    public ManagerPrinter(List<Docum> docToPrinter) {
        this.documentList = new ArrayList<>();
        documentList = docToPrinter;
        this.myThread = new ThreadPrinter(this.documentList);
    }

    //3. Методы
    /**
     * Добавление документа в список на печать
     * @param docum новый документ на печать
     */
    public void addDocum(Docum docum) {
        documentList.add(docum);
    }

    /**
     * Отменить печать принятого документа,
     * если он еще не был напечатан
     */
    public void cancelPrintingDocument() {

    }

    /**
     * Остановка диспетчера печати
     * @return список ненапечатанных документов
     */
    /*public List<Docum> stopPrinting() {
        return new Docum;
    }*/

    /**
     * Рассчитать среднюю продолжительность печати напечатанных документов
     */
    public float calcAverageTimePrinting() {
        return 0;
    }
}
