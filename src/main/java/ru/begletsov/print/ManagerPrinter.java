package ru.begletsov.print;

import ru.begletsov.docum.Docum;
import ru.begletsov.sort.*;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 /* Класс ManagerPrinter - диспетчер печати документов, принимает и распечатывает документы от пользователя
 * 1) создание класса 2) доработка функционала класса: принятие документа, остановка, отмена печати,
 * расчет продолжительности печати 3) добавил метод getDocumentList()
 * 4) добавил методы сортировки 5) добавил метод getListPrintedDocument()
 * @author Sergei Begletsov
 * @since 01.07.2020
 * @version 5
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

    /**
     * Получить список напечатанных документов
     */
    public List<Docum> getListPrintedDocument() {
        List<Docum> listPrintedDocument = new ArrayList<>();
        for (int indexDocum = 0; indexDocum < documentList.size(); indexDocum++ ) {
            if (documentList.get(indexDocum).getPrinted() == true) {
                listPrintedDocument.add(documentList.get(indexDocum));
            }
        }
        return listPrintedDocument;
    }

    /**
     * Сортировка списка документов на печать по размеру бумаги <<по убыванию>>
     * @return список отсортированных документов
     */
    public List<Docum> getSortListDocBySizePaperDecrease() {
        //1. Остановка потока
        myThread.disabled();

        List<Docum> listPrintedDocument = this.getListPrintedDocument();

        //2. Сортировка по алгоритму и выдача результата
        Collections.sort(listPrintedDocument, new DocCompBySizePaperDecrease());
        return listPrintedDocument;
    }

    /**
     * Сортировка списка документов на печать по размеру бумаги <<по возрастанию>>
     * @return список отсортированных документов
     */
    public List<Docum> getSortListDocBySizePaperIncrease() {
        //1. Остановка потока
        myThread.disabled();

        List<Docum> listPrintedDocument = this.getListPrintedDocument();

        //2. Сортировка по алгоритму и выдача результата
        Collections.sort(listPrintedDocument, new DocCompBySizePaperIncrease());
        return listPrintedDocument;
    }

    /**
     * Сортировка списка документов на печать по времени печати <<по убыванию>>
     * @return список отсортированных документов
     */
    public List<Docum> getSortListDocByTimePrintingDecrease() {
        //1. Остановка потока
        myThread.disabled();

        List<Docum> listPrintedDocument = this.getListPrintedDocument();

        //2. Сортировка по алгоритму и выдача результата
        Collections.sort(listPrintedDocument, new DocCompByTimePrintingDecrease());
        return listPrintedDocument;
    }

    /**
     * Сортировка списка документов на печать по времени печати <<по возрастанию>>
     * @return список отсортированных документов
     */
    public List<Docum> getSortListDocByTimePrintingIncrease() {
        //1. Остановка потока
        myThread.disabled();

        List<Docum> listPrintedDocument = this.getListPrintedDocument();

        //2. Сортировка по алгоритму и выдача результата
        Collections.sort(listPrintedDocument, new DocCompByTimePrintingIncrease());
        return listPrintedDocument;
    }


    /**
     * Сортировка списка документов на печать по типу документов <<по убыванию>>
     * @return список отсортированных документов
     */
    public List<Docum> getSortListDocByTypeFileDecrease() {
        //1. Остановка потока
        myThread.disabled();

        List<Docum> listPrintedDocument = this.getListPrintedDocument();

        //2. Сортировка по алгоритму и выдача результата
        Collections.sort(listPrintedDocument, new DocCompByTypeFileDecrease());
        return listPrintedDocument;
    }

    /**
     * Сортировка списка документов на печать по типу документов <<по возрастанию>>
     * @return список отсортированных документов
     */
    public List<Docum> getSortListDocByTypeFileIncrease() {
        //1. Остановка потока
        myThread.disabled();

        List<Docum> listPrintedDocument = this.getListPrintedDocument();

        //2. Сортировка по алгоритму и выдача результата
        Collections.sort(listPrintedDocument, new DocCompByTypeFileIncrease());
        return listPrintedDocument;
    }

    /**
     * Сортировка списка документов на печать по порядку печати <<по убыванию>>
     * @return список отсортированных документов
     */
    //public List<Docum> getSortListDocByOrderDecrease() {

    //}

    /**
     * Сортировка списка документов на печать по порядку печати <<по возрастанию>>
     * @return список отсортированных документов
     */
    //public List<Docum> getSortListDocByOrderIncrease() {

    //}
}
