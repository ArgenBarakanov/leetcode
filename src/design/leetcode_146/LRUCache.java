package design.leetcode_146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    Node head;//первый в кэше
    Node tail;//последний в кэше

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(){
        }

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;

        head = new Node();//создаем два пустых конца кэша и как бы закольцовываем их
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)) {//если еще нет такого значения то вставляем его в начало кеша и вернем его иначе -1
            Node n = map.get(key);
            moveToHead(n);
            return n.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {//если еще нет такого то ставим его перед началом очереди и если кеш переполнен то уберем хвост
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            setHead(newNode);
            if (map.size() > capacity) {
                popTail();
            }
        } else {
            Node node = map.get(key);//иначе переместим его в начало кеша
            node.value = value;
            moveToHead(node);
        }


    }

    private void popTail() {
        Node node = tail.prev;//убираем предпоследний элемент
        map.remove(node.key);
        removeNode(node);
    }

    private void moveToHead(Node node) {
        removeNode(node);
        setHead(node);
    }

    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;
    }
    private void setHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
}
