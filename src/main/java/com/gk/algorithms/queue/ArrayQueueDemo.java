package com.gk.algorithms.queue;

/***
 * @author gk
 * @create 2022-01-25 10:31 下午
 **/
public class ArrayQueueDemo {

    class ArrayQueue {
        /**
         * 最低长度
         */
        private int maxSize;
        /**
         * 队头指针
         */
        private int front;
        /**
         * 队尾指针
         */
        private int rear;
        /**
         * 队列
         */
        private int[] queue;

        public ArrayQueue(int maxSize) {
            this.maxSize = maxSize;
            queue = new int[maxSize];
            front = -1;
            rear = -1;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public boolean isFull() {
            return rear == maxSize - 1;
        }

        public void add(int value) {
            if (isFull()) {
                return;
            }
            queue[++rear] = value;
        }

        public int get() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，请稍候重试");
            }
            return queue[++front];
        }
    }
}

