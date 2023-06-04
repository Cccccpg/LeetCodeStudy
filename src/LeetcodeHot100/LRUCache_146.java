package LeetcodeHot100;

import java.util.HashMap;

/**
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * 实现 LRUCache 类：
 * LRUCache(int capacity) 以 正整数 作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字 key 已经存在，则变更其数据值 value ；
 * 如果不存在，则向缓存中插入该组 key-value 。如果插入操作导致关键字数量超过 capacity ，则应该 逐出 最久未使用的关键字。
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 *
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 *
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 *
 */
class LRUCache_146 {
    class DLinkedNode{
        int key;
        int value;
        DLinkedNode pre;
        DLinkedNode next;

        public DLinkedNode() {}
        public DLinkedNode(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, DLinkedNode> cacheMap = new HashMap<>();
    private int size;
    private int cap;
    private DLinkedNode head, tail;

    //移除node节点
    private void removeNode(DLinkedNode node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    //将节点node移动到头部
    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    //将节点node添加到头部
    private void addToHead(DLinkedNode newNode) {
        head.next.pre = newNode;
        newNode.next = head.next;
        head.next = newNode;
        newNode.pre = head;
    }

    //将尾结点删除,并获取该节点
    private DLinkedNode removeTail() {
        DLinkedNode res = tail.pre;
        removeNode(res);
        return res;
    }

    public void LRUCache(int capacity) {
        this.size = 0;
        this.cap = capacity;
        //使用伪头部和伪尾部
        head = new DLinkedNode();
        tail = new DLinkedNode();
        //连接头尾结点
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        //通过HashMap定位链表中该节点的位置
        DLinkedNode node = cacheMap.get(key);
        //如果没找到，也就是node为空时
        if (node == null){
            return -1;
        }
        //将该节点移动到头部，因为头部是经常使用的
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cacheMap.get(key);
        if (node == null){
            //如果node不存在，那就重新创建一个节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            cacheMap.put(key, newNode);
            //将新的node同样添加到头部
            addToHead(newNode);
            size++;
            //如果链表大小超出cap容量，就删除最久未使用的节点，也即尾部节点
            if (size > cap){
                DLinkedNode tail = removeTail();
                //删除HashMap中的对应节点
                cacheMap.remove(tail.key);
                size--;
            }
        }else{
            //如果key存在，那么就先通过HashMap进行定位，再修改value，最后移到头部
            node.value = value;
            moveToHead(node);
        }
    }
}
