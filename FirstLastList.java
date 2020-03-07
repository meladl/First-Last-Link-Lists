
class FirstLastList{
    private Link first;               
    private Link last;                
    public FirstLastList(){
        first = null;                 
        last = null;
    }

    public boolean isEmpty(){ 
        return first==null; 
    }

    public int count(){
        Link current = first;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;  
        }
        return count;
    }

    public void insertFirst(long dd){
        Link newLink = new Link(dd);  

        if( isEmpty() )               
            last = newLink;             
        newLink.next = first;          
        first = newLink;               
    }

    public void insertLast(long dd){
        Link newLink = new Link(dd);   
        if( isEmpty() )                
            first = newLink;           
        else
            last.next = newLink;        
        last = newLink;                
    }

    public long deleteFirst(){                             
        long temp = first.dData;
        if(first.next == null)         
            last = null;               
        first = first.next;          
        return temp;
    }

    public void displayList(){
        System.out.print("[ ");
        Link current = first;         
        while(current != null){
            current.displayLink();     
            current = current.next;     
        }
        System.out.print("]");
        System.out.println("");
    }

    public void join(FirstLastList secondList){
        Link current = secondList.first;
        while(current != null){
            this.insertLast(current.dData);
            current = current.next;
        }
        current = secondList.first;
        while(current != null){
            secondList.deleteFirst();
            current = current.next;
        }

    }

    public void swap(){
        if( this.count() < 2){
            System.out.println("The List Contains less than 2 Elements!!!!!");
        }
        else{
            long temp = first.dData;
            long temp2= last.dData;
            first.dData = temp2;
            last.dData = temp;
            this.displayList();
        }
    }
    ////////////////////////////////////////////////////////////////
    public static void main(String[] args){                       
        FirstLastList list1 = new FirstLastList();
        FirstLastList list2 = new FirstLastList();

        list1.insertFirst(4);
        list1.insertFirst(7);
        list1.insertFirst(3);
        list1.insertFirst(1);
        System.out.print("List 1: ");
        list1.displayList();

        list2.insertFirst(6);
        list2.insertFirst(8);
        list2.insertFirst(5);
        list2.insertFirst(4);
        list2.insertFirst(2);
        System.out.print("List 2: ");
        list2.displayList();

        System.out.print("List 1 Join 2: " );
        list1.join(list2);
        list1.displayList();
        System.out.print("List 2 After Join : " );
        list2.displayList();

        System.out.print("List 1 Swap: " );
        list1.swap();
    } 
}  

