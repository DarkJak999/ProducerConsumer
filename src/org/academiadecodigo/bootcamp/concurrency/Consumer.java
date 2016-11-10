package org.academiadecodigo.bootcamp.concurrency;

import org.academiadecodigo.bootcamp.concurrency.bqueue.BQueue;

/**
 * Consumer of integers from a blocking queue
 */
public class Consumer implements Runnable {

    public static final String ANSI_RESET = "\u001B[0m";
    public String ANSI_COLOR;

    private final BQueue<Integer> queue;
    private int elementNum;

    /**
     * @param queue the blocking queue to consume elements from
     * @param elementNum the number of elements to consume
     */
    public Consumer(BQueue queue, int elementNum, String color) {
        this.queue = queue;
        this.elementNum = elementNum;
        ANSI_COLOR = color;
    }

    @Override
    public void run() {

        for(int i = 0; i < elementNum; i++){
            System.out.println("Consumer: " + ANSI_COLOR + Thread.currentThread().getName() + ANSI_RESET + " " + queue.poll());
        }

    }

}
