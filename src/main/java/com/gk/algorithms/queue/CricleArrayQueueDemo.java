package com.gk.algorithms.queue;

import java.util.Scanner;

/***
 * @author gk
 * @create 2022-01-25 10:31 下午
 * 这种实现，数组只能使用一次，当rear=maxSize-1的时候，即使取出数据也没办法在加数据
 **/
public class CricleArrayQueueDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayQueue arrayQueue = new ArrayQueue(3);
        boolean isContinue = true;
        while (isContinue) {
            System.out.println("请输入指令:");
            System.out.println("a：增加元素");
            System.out.println("g：获取元素");
            System.out.println("h：队头数据");
            System.out.println("all：所有数据");
            System.out.println("e：退出");
            String command = scanner.nextLine();
            switch (command) {
                case "a":
                    System.out.println("请输入数据:");
                    arrayQueue.add(scanner.nextInt());
                    break;
                case "g":
                    System.out.println("数据：" + arrayQueue.get());
                    break;
                case "h":
                    System.out.println("数据：" + arrayQueue.getHead());
                    break;
                case "all":
                    arrayQueue.printQueue();
                    break;
                case "e":
                    isContinue = false;
                    break;
            }
        }
    }

    static class ArrayQueue {
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
            front = 0;
            rear = 0;
        }

        public boolean isEmpty() {
            return rear == front;
        }

        public boolean isFull() {
            return (rear + 1) % maxSize == front;
        }

        public void add(int value) {
            if (isFull()) {
                System.out.println("队列已经满了！");
                return;
            }
            queue[rear] = value;
            rear = (rear + 1) % maxSize;
        }

        public int get() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，请稍候重试");
            }
            int value = queue[front];
            front = (front + 1) % maxSize;
            return value;
        }

        public int getHead() {
            if (isEmpty()) {
                throw new RuntimeException("队列为空，请稍候重试");
            }
            return queue[front];
        }

        public void printQueue() {
            if (isEmpty()) {
                return;
            }
            for (int i = front; i < front + getSize(); i++) {
                System.out.printf("queue[%d]=%d", i % maxSize, queue[i % maxSize]);
                System.out.println();
            }
        }

        /**
         * 获取有效长度
         *
         * @return
         */
        private int getSize() {
            return (rear + maxSize - front) % maxSize;
        }
    }
}

