package me.naveenhn.practice.java89.defaultmethod;

public interface InterfaceOne {
	
	
	void methodA();
	
	default void commonMethod() {
		System.out.println("Common method called - Interface One");
	}

}
