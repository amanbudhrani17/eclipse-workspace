public class BinaryHeap {
    int arr[];
    int sizeOfTree;
    public BinaryHeap(int size){
        arr = new int[size+1];
        sizeOfTree = 0;
    }
    public void heapify(int index, String heapType){
        int parent = index / 2;
        if(index<=1){
            return;
        }
        if(heapType == "Min"){
            if(arr[index] < arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        else if(heapType == "Max"){
            if(arr[index] > arr[parent]){
                int temp = arr[index];
                arr[index] = arr[parent];
                arr[parent] = temp;
            }
        }
        heapify(parent, heapType);
    }
    public void insert(int value, String typeOfHeap){
        arr[++sizeOfTree] = value;
        heapify(sizeOfTree, typeOfHeap);
        System.out.println(value + " ");
    }
    public void LevelOrder(){
        for(int i = 1; i<=sizeOfTree; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.print("\n");
    }
    public void hepifyTopToBottom(int index, String HeapType){
        int left = index*2;
        int right = index*2+1;
        int Swap = 0;
        if(sizeOfTree<left){
            return;
        }
        if(HeapType == "Max"){
            if(sizeOfTree == left) {
                if (arr[index] < arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            else {
                if (arr[left] > arr[right]) {
                    Swap = left;
                } else {
                    Swap = right;
                }
                if (arr[index] < arr[Swap]) {
                    int temp = arr[index];
                    arr[index] = arr[Swap];
                    arr[Swap] = temp;
                }
            }
        }
        else if(HeapType == "Min"){
            if(sizeOfTree == left) {
                if (arr[index] > arr[left]) {
                    int temp = arr[index];
                    arr[index] = arr[left];
                    arr[left] = temp;
                }
                return;
            }
            else {
                if (arr[left] < arr[right]) {
                    Swap = left;
                } else {
                    Swap = right;
                }
                if (arr[index] < arr[Swap]) {
                    int temp = arr[index];
                    arr[index] = arr[Swap];
                    arr[Swap] = temp;
                }
            }
        }
        hepifyTopToBottom(Swap, HeapType);

    }

}
