package model;
/*
 * Name: Chen Lu
 * Andrew ID: chenlu
 * 08-600 Homework 8
 * 11/19/2014
 */

public class MyDAOException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public MyDAOException(Exception e) { super(e); }
	public MyDAOException(String s)    { super(s); }
}
