package com.runoob.designpattern.visitor;

public interface ComputerPart {

	public void accept(ComputerPartVisitor computerPartVisitor);
}
