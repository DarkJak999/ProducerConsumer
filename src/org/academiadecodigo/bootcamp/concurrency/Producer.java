package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Produces and stores integers into a blocking queue
 */
public class Producer implements Runnable {

    public static final String ANSI_RESET = "\u001B[0m";
    public String ANSI_COLOR;

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to add elements to
     * @param elementNum the number of elements to produce
     */
    public Producer(BQueue queue, int elementNum, String color) {
        this.queue = queue;
        this.elementNum = elementNum;
        ANSI_COLOR = color;
    }

    @Override
    public void run() {

        for(int i = 0; i < elementNum; i++){

            System.out.println("Producer: " + ANSI_COLOR + Thread.currentThread().getName() + ANSI_RESET + " " + i);
            queue.offer(i);

        }

    }

}
