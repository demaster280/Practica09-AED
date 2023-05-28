/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptions;


@SuppressWarnings("serial")
public class ExceptionEmpty extends Exception{
	
	public ExceptionEmpty(String msg) {
		super(msg);
	}
	
	public ExceptionEmpty() {
		super();
	}
}
