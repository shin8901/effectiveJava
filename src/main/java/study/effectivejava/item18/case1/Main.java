package study.effectivejava.item18.case1;

import java.util.List;

public class Main {
	public static void main(String[] args) {

		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();

		s.addAll(List.of("틱", "틱틱", "펑"));
		System.out.println(s.getAddCount());
	}	
}