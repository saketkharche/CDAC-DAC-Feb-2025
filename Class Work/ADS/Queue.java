

class Queue{
	int size = 5;
	int Q[] = new int[size];
	int rear, front;
	
	Queue(){
		//default value 
		front = -1;
		rear = -1;
	}
	
	boolean isEmpty(){
		if(front == -1)
			return true;
		else
			return false;
		
	}
	
	boolean isFull(){
		if(front == 0 && rear == size-1)
			return true;
		else
			return false;
	}
	
	void enqueue(int x){
		if(isFull())
		{
			System.out.println("Queue is full!");
		}
		else{
			if(front == -1)
				front = 0;
			rear++;
			Q[rear] = x;
			System.out.println(x+ "Insertion is done!");
		
			
		}
		
	}
	
	int dequeue(){
		int x;
		if(isEmpty()){
			System.out.println("Queue is empty!!!");
			return -1;
		}
		else{
			x = Q[front];
			if(front >= rear)
			{
				front = -1;
				rear = -1;
			}
			else{
				front++;
			}
			System.out.println("Deleted "+x);
			return x;
			
		}
		
	}
	
	void display()
	{
		if(isEmpty())
			System.out.println("Queue is Empty!");
		else
			for(int i=front; i<=rear ; i++){
			System.out.print(Q[i]+ " ");
			}
	}
	
	
	
	public static void main(String[] args) {
		
		Queue q1 = new Queue();
		q1.enqueue(11);
		q1.enqueue(12);
		q1.enqueue(13);
		q1.enqueue(14);
		q1.enqueue(15);
		q1.enqueue(5);
		q1.display();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		q1.display();
		q1.dequeue();
		q1.display();
	}		
}