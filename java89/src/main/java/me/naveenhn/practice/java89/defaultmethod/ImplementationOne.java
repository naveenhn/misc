/**
 * 
 */
package me.naveenhn.practice.java89.defaultmethod;

/**
 * @author naveen
 *
 */
public class ImplementationOne implements InterfaceOne, InterfaceTwo {

	@Override
	public void methodA() {
		System.out.println("method A - implementation");
		
	}
	
	@Override
	public void commonMethod() {
		//to use InterfaceOne implementation
		InterfaceOne.super.commonMethod();
	}
	
	
	public static void main(String[] args) {
		ImplementationOne implementationOne = new ImplementationOne();
		implementationOne.commonMethod();
	}

}
