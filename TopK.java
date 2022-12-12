package joyCastle;

import java.util.Arrays;

public class TopK {


    public int[] topK(int[] arr,int k){
        int[] re = new int[k];
        int count = 0;
        //初次构建大顶堆
        for(int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        //调整堆结构，并用剩下的元素重复构建大顶堆
        for(int j=arr.length-1;j>=0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
            // 这里要特殊判断一下，有可能会出现分数相同的情况
            if(count==0||arr[j]!=re[count-1]){
                re[count] = arr[j];
                count++;
                if(count==k){
                    break;
                }
            }
        }
        return re;
    }

    /**
     * 构建大顶堆
     */
    public void adjustHeap(int []arr,int i,int length){
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    /**
     * 交换元素
     */
    public void swap(int []arr,int a ,int b){
        int temp=arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9,6,11,4,65,34,788,7,55,7,7,1,2,3,4,5};
        int[] ints = new TopK().topK(arr, 13);
        System.out.println(Arrays.toString(ints));
    }
}