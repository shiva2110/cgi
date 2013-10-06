package stackqueue;

import java.util.ArrayList;
import java.util.List;

public class StackPile {
	List<Stack<String>> list = new ArrayList<Stack<String>>();
	
	public List<Integer> curStackSize = new ArrayList<Integer>();
	int maxStackSize = 5;
	public int curStackIndex = 0;

	public void push(String data) {

		if(curStackSize.size()!=0 && curStackSize.get(curStackIndex)==maxStackSize) {
			curStackIndex++;
		}
		
		if(curStackIndex>=list.size()){
				list.add(new Stack<String>());
				curStackSize.add(0);
		}

		Stack<String> stack = list.get(curStackIndex);
		stack.push(data);
		int size = curStackSize.get(curStackIndex) + 1;
		curStackSize.set(curStackIndex, size);
	}

	public String pop(){
		
		if(list.size()==0 || curStackSize.size()==0){
			return null;
		}
		
		while(curStackSize.get(curStackIndex)==0) {
			list.remove(curStackIndex);
			curStackIndex--;
			
			if(curStackIndex<0){
				return null;
			}
		}

		String data = list.get(curStackIndex).pop();
		int size = curStackSize.get(curStackIndex) - 1;
		curStackSize.set(curStackIndex, size);
		return data;
	}
	
	public String pop(int index) throws Exception{
		if(index>=list.size()){
			System.out.println("index out of pile bounds");
			throw new Exception("index out of pile bounds");
		}
		
		if(curStackSize.get(index)==0){
			return null;
		}
		
		String data = list.get(index).pop();
		int size = curStackSize.get(index) - 1;
		curStackSize.set(index, size);
		return data;
	}


}
