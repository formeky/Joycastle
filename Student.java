package joyCastle;

import java.util.HashMap;

public class Student {
    // 可以抽象为寻找最近的公共祖先
    public Node findLeader(Node student1,Node student2){
        Node re = new Node();
        HashMap<Node,String> map = new HashMap<>();
        Node t = student1;
        Node p = student2;
        while(t!=null){
            map.put(t,t.value);
            t = t.father;
        }
        while(p!=null){
            if (map.containsKey(p)) {
                break;
            }
            p = p.father;
        }
        return p;
    }

    public static void main(String[] args) {
        Node node = new Node();
        node.value = "node";
        Node node2 = new Node();
        node2.value = "node2";
        Node node3 = new Node();
        node3.value = "node3";
        Node node4 = new Node();
        node4.value = "node4";
        Node node5 = new Node();
        node5.value = "node5";
        node5.father = node2;
        node4.father = node2;
        node2.father = node;
        node3.father = node;

        Student student = new Student();
        Node leader = student.findLeader(node4, node3);
        System.out.println(leader.value);
    }
}
