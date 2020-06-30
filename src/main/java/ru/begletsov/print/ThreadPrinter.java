package ru.begletsov.print;

import ru.begletsov.docum.Docum;

import java.util.List;

/**
 /* Класс-поток ThreadPrinter отслеживает и задает состояние диспетчера принтера
 * 1) создание класса 2) написал рыбу алгоритма распечатки диспетчера
 * 3) переписал метод отключения потока public void disabled(), теперь отключается через режим CLOSE
 * @author Sergei Begletsov
 * @since 30.06.2020
 * @version 2
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
        int counter = 1;
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
                        //   b перехожу --> в режим "ОЖИДАНИЯ" и там жду появления новых файлов.
                        if (this.indexDocument == documentListAtThread.size()) {
                            this.state = StatePrinting.WAIT;
                        } else {
                            //2. Если кол-во распечатанных документов отличается
                            //   от размера списка, то начинаю печатать документы
                            if (counter >= documentListAtThread.get(indexDocument).getTimePrinting()) {
                                if (indexDocument < documentListAtThread.size()) {
                                    indexDocument++; //приступаю к распечатке следующего документа
                                }
                            } else {
                                counter++;
                            }
                        }
                        break;
                    case CLOSE:
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
}

/**
 * Cостояние диспетчера печати документов:
 * WAIT - ожидание документов на печать,
 * PRINTING - распечатка документа,
 * CLOSE - прерывание работы, закрытие портов
 */
enum StatePrinting {
    WAIT,
    PRINTING,
    CLOSE
}