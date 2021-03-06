package ce.modelwhilework.data;

import java.util.Stack;

public class Process extends Modus{

	private Stack<Card>  MainStack, SideStack;
	
	public Process(String title) {
		super(title);
		
		MainStack = new Stack<Card>();
		SideStack = new Stack<Card>();		
	}
	
	public Process(String title, String mxlFilePath) {
		this(title);
		//todo: handle xml input
	}
	
	public boolean addCard(Card card) { return MainStack.add(card);	}
	
	public boolean putCardAside() {
		
		try {
			SideStack.add(MainStack.pop());			
		} catch (Exception e) {
			return false;
		}
		return true;
	}
	
	public boolean putBackFromAside() {
		
		try { MainStack.add(SideStack.pop()); }
		catch (Exception e) { return false;	}
		return true;
	}
	
	public boolean removeCardFromMainStack() {
		
		try { MainStack.pop();}
		catch (Exception e) { return false;	}
		return true;
	}
	
public boolean removeCardFromSideStack() {
		
		try { SideStack.pop();}
		catch (Exception e) { return false;	}
		return true;
	}
	
	public boolean isMainStackEmpty() { return MainStack.size() == 0; }
	public boolean isSideStackEmpty() { return SideStack.size() == 0; }
	
	public Card getTopCardMainStack() { 
		if(isMainStackEmpty()) { return null; }
		return MainStack.peek();
	}
	
	public Card getTopCardSideStack() { 
		if(isSideStackEmpty()) { return null; }
		return SideStack.peek();
	}
}
