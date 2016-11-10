package org.academiadecodigo.bootcamp.concurrency.bqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Blocking Queue
 * @param <T> the type of elements stored by this queue
 */
public class BQueue<T> {

    private LinkedList<T> queue;
    private int limit;

    /**
     * Constructs a new queue with a maximum size
     * @param limit the queue size
     */
    public BQueue(int limit) {

        this.queue = new LinkedList<T>();
        this.limit = limit;

    }

    /**
     * Inserts the specified element into the queue
     * Blocking operation if the queue is full
     * @param data the data to add to the queue
     */
    public synchronized void offer(T data) {
        while(queue.size() >= limit) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*if(queue.size() == 0)
            notifyAll();*/

        queue.addLast(data); //this is the same as a simple add
        notifyAll();
    }

    /**
     * Retrieves and removes data from the head of the queue
     * Blocking operation if the queue is empty
     * @return the data from the head of the queue
     */
    public synchronized T poll() {

        while(queue.size() <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        /*if(queue.size() == limit)
            notifyAll();*/

        notifyAll();
        return queue.poll();

    }

}
