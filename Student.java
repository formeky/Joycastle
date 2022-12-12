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
            t = t.father;
        }
        return p;
    }

    public static void main(String[] args) {

    }
}
