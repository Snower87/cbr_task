package ru.begletsov.print;

import ru.begletsov.docum.Docum;

import java.util.List;

/**
 /* Класс-поток ThreadPrinter отслеживает и задает состояние диспетчера принтера
 * 1) создание класса 2) написал рыбу алгоритма распечатки диспетчера
 * 3) переписал метод отключения потока public void disabled(), теперь отключается через режим CLOSE
 * 4) доработка алгоритма диспетчера 5) добавил метод getState() 6) добавил метод getIndexPrintingDocument()
 * 7) устранил ошибку - не выставлялся printed для последнего документа в списке
 * @author Sergei Begletsov
 * @since 01.07.2020
 * @version 7
 */

public class ThreadPrinter implements Runnable {
    //1. Поля
    Thread t;
    private boolean isActive; //активность потока: true - работает, false - не работает
    private StatePrinting state; //состояние диспетчера
    int indexDocument; //индекс документа, который печатается
    List<Docum> documentListAtThread; //список документов для печати

    //2. Конструктор
    public ThreadPrinter(List<Docum> docToPrinter) {
        t = new Thread(this, "ThreadPrinter");
        t.start();
        this.isActive = true;
        this.state = StatePrinting.WAIT;
        this.indexDocument = 0;
        this.documentListAtThread = docToPrinter;
    }

    //3. Методы:
    /**
     * 3.1 Деактивация, отключение потока
     */
    public void disabled() {
        this.state = StatePrinting.CLOSE;
    }

    /**
     * 3.2 Переопределенный метод run()
     */
    @Override
    public void run() {
        int counter = 1; //счетчик для отслеживания времени печати документа
        while (isActive) {
            try {
                Thread.sleep(100);
                switch (state) {
                    case WAIT:
                        // Алгоритм работы диспетчера в режиме ОЖИДАНИЯ:
                        //1. Если кол-во распечатанных документов отличается
                        //   от размера списка, то перехожу --> в режим диспетчера "ПЕЧАТЬ".
                        //2. Если кол-во кол-во напечатанных документов равно
                        //   размеру списка, то значит новых документов нету,
                        //   остаюсь в режиме "ОЖИДАНИЯ" до появления новых файлов.
                        if (this.indexDocument != documentListAtThread.size()) {
                            this.state = StatePrinting.PRINTING;
                        }
                        break;
                    case PRINTING:
                        // Алгоритм работы диспетчера в режиме "ПЕЧАТЬ":
                        //1. Если кол-во кол-во напечатанных документов сравнялось
                        //   с размером списка, то значит новых документов нету,
                        //   то перехожу --> в режим "ОЖИДАНИЯ" и там жду появления новых файлов.
                        //2. Если кол-во распечатанных документов отличается
                        //   от размера списка, то начинаю печатать документы
                        if (this.indexDocument == documentListAtThread.size()) {
                            this.state = StatePrinting.WAIT;
                        } else {
                            if (counter >= documentListAtThread.get(indexDocument).getTimePrinting()) {
                                if (indexDocument <= documentListAtThread.size()) {
                                    //1. Вывожу на печать что, документ полностью напечатан
                                    System.out.println(documentListAtThread.get(indexDocument).getName() + "." + documentListAtThread.get(indexDocument).getTypeFile()
                                             + " printed!");
                                    //2. Выставляю булево поле printed для документа, что он напечатан
                                    documentListAtThread.get(indexDocument).setPrinted(true);
                                    //3. Приступаю к распечатке следующего документа
                                    indexDocument++;
                                    //4. Обнуляю счетчик печати диспетчера для следующего документа
                                    counter = 0;
                                }
                            } else {
                                counter++;

                                //процент печати, кратен 10%
                                int persentPrinting = documentListAtThread.get(indexDocument).getTimePrinting() / (documentListAtThread.get(indexDocument).getTimePrinting() / 10);
                                if (counter > 0 && counter % persentPrinting == 0) {
                                    System.out.println(counter + "% of " + "printing " + documentListAtThread.get(indexDocument).getName() + "." + documentListAtThread.get(indexDocument).getTypeFile());
                                }
                            }
                        }
                        break;
                    case CLOSE:
                        // Алгоритм работы диспетчера в режиме "ЗАВЕРШЕНИЕ":
                        this.indexDocument = 0;
                        this.isActive = false;
                        break;
                    default:
                        break;
                }
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
            }
        }
    }

    /**
     * 3.3 Текущее состояние потока/диспетчера печати
     */
    public StatePrinting getState() {
        return state;
    }

    /**
     * 3.4 Получение индекса документа, который сейчас распечатывается
     */
    public int getIndexPrintingDocument() {
        return this.indexDocument;
    }
}

/**
 * Cостояние диспетчера печати документов:
 * WAIT - ожидание документов на печать,
 * PRINTING - распечатка документа,
 * CLOSE - завершение или прерывание работы, закрытие портов
 */
enum StatePrinting {
    WAIT,
    PRINTING,
    CLOSE
}