package com.springsecurity.springsecurity.junit;

import org.springframework.stereotype.Component;

@Component
public class Calculator {

	public int addTwoNumbers(int x, int y){
        return x+y;
    }
}
