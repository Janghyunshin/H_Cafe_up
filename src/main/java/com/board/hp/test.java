package com.board.hp;

import java.util.ArrayList;

public class test {

	public static void main(String[] args) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		
		for(int i = 0; i < list.size(); i++) { 
			BoardDTO dto = list.get(i);
			System.out.println(dto.getBoard_date());
			System.out.println(dto.getBoard_subject());
		}
		
		System.out.println("출력이 안됨"); 
	}
}
