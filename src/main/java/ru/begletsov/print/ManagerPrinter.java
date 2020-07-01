package ru.begletsov.print;

import ru.begletsov.docum.Docum;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

/**
 /* Класс ManagerPrinter - диспетчер печати документов, принимает и распечатывает документы от пользователя
 * 1) создание класса 2) доработка функционала класса: принятие документа, остановка, отмена печати,
 * расчет продолжительности печати 3) добавил метод getDocumentList()
 * @author Sergei Begletsov
 * @since 01.07.2020
 * @version 3
 */

public class ManagerPrinter {
    //1. Поля
    volatile List<Docum> documentList;
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
        int indexCancelDocument = documentList.size() - 1;
        if (indexCancelDocument > myThread.getIndexPrintingDocument())
        {
            documentList.remove(indexCancelDocument);
        }
    }

    /**
     * Остановка диспетчера печати
     * @return список ненапечатанных документов
     */
    public List<Docum> stopPrinting() {
        //1. Останавливаю диспетчер печати
        myThread.disabled();

        //2. Формирование списка ненапечатанных документов
        List<Docum> listCancelDocum = new ArrayList<>();
        for (int indexDoc = 0; indexDoc < documentList.size(); indexDoc++) {
            if (documentList.get(indexDoc).getPrinted() == false) {
                listCancelDocum.add(documentList.get(indexDoc));
            }
        }
        return listCancelDocum;
    }

    /**
     * Рассчитать среднее время печати документов
     */
    public float calcAverageTimePrinting() {
        float avrTimePrintedDocum = 0; //средняя продолжительность печати документов
        int numPrintedDocum = 0; //кол-во напечатанных документов

        for (Docum docum: documentList) {
            if (docum.getPrinted() == true) {
                numPrintedDocum++;
                avrTimePrintedDocum += docum.getTimePrinting();
            }
        }
        if (numPrintedDocum > 0) {
            avrTimePrintedDocum /= numPrintedDocum;
        }

        return avrTimePrintedDocum;
    }

    /**
     * Получить список документов на печать
     */
    public List<Docum> getDocumentList() {
        return documentList;
    }
}
