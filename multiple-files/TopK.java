/**
TopK问题
https://cloud.tencent.com/developer/article/1533920
剑指offer:不修改原有数组的情况下, 提供了O(nlogk)的复杂度
 */
public class MinHeap{
    // 堆的存储结构 - 数组
    private int[] data;

    // 将一个数组传入构造方法，并转换成一个小根堆
    public MinHeap(int[] data){
        this.data = data;
        buildHeap();
    }

    // 将数组转换成最小堆
    private void buildHeap(){
        // 完全二叉树只有数组下标小于等于数组长度一半减一的元素有孩子节点
        for(int i = (data.length)/2 - 1; i>=0; i--){
            heapify(i);
        }
    }

    private void heapify(int i){
        // 获取左右节点的数组下标
        int l = left(i);
        int r = right(i);

        // 这是一个临时变量，表示根节点、左节点、右节点中最小值的节点下标
        int smallest = i;

        // 存在左节点，且左节点的值小于根节点的值
        if(l < data.length && data[l] < data[i])
            smallest = l;
        
        // 存在右节点，且右节点的值小于以上比较的值
        if(r < data.length && data[r] < data[smallest])
            smallest = r;

        // 左右节点的值都大于根节点，直接return，不做任何操作
        if(i == smallest)
            return;
        
        // !!!交换根节点和左右节点中最小的那个值，把根节点的值替换下去
        swap(i, smallest);

        // 由于替换后左右子树会被影响，所以要对受影响的子树再进行heapify
        heapify(smallest);
    }

    // 获取右节点的数组下标
    private int right(int i){
        return (i+1) << 1;
    }

    // 获取左节点的数组下标
    private int left(int i){
        return ((i+1) << 1) - 1;
    }

    // 交换元素位置
    private void swap(int i, int j){
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    // 获取对中的最小的元素，根元素
    public int getRoot()
    {
        return data[0];
    }

    // 替换根元素，并重新heapify
    public void setRoot(int root)
    {
        data[0] = root;
        heapify(0);
    }
}

public class TopK
{
    public static void main(String[] args)
    {
        // 源数据
        int[] data = {56,275,12,6,45,478,41,1236,456,12,546,45};

        // 获取Top5
        int[] top5 = topK(data, 5);

        for(int i=0;i<5;i++)
        {
            System.out.println(top5[i]);
        }
    }

    // 从data数组中获取最大的k个数
    private static int[] topK(int[] data,int k)
    {
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k]; 
        for(int i = 0;i< k;i++)
        {
            topk[i] = data[i];
        }

        // 转换成最小堆
        MinHeap heap = new MinHeap(topk);

        // 从k开始，遍历data
        for(int i= k;i<data.length;i++)
        {
            int root = heap.getRoot();

            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if(data[i] > root)
            {
                heap.setRoot(data[i]);
            }
        }

        return topk;
    }
}