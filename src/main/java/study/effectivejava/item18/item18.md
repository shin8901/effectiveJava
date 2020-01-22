# 18. 상속 보다는 컴포지션을 사용하라.

>> 상속은 항상 최선은 아니다
>> 메서드 호출과는 달리 상속은 캡슐화를 깨뜨린다
>> 조심하라

>> 상위클래스가 어떻게 구현되느냐에 따라 하위 클래스의 동작에
>> 이상이 생길 수도 있음

>> 예) 버전이 업그레이드 되어서 릴리즈한거를 받았드만
>> extends 했던 클래스가 바껴버리면서 하위에 애들이 컴파일오류..

```java
public class InstrumentedHashSet<E> extends HashSet<E> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -126988860240333378L;
	private int addCount;

	public InstrumentedHashSet() {

	}

	public InstrumentedHashSet(int initCap, float loadFactor) {
		super(initCap, loadFactor);
	}

	@Override
	public boolean add(E e) {
		addCount++;
		return super.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		addCount += c.size();
		return super.addAll(c);
	}	

	public int getAddCount() {
		return addCount;
	}
}
public class Main {
	public static void main(String[] args) {

		InstrumentedHashSet<String> s = new InstrumentedHashSet<>();

		s.addAll(List.of("틱", "틱틱", "펑"));
		System.out.println(s.getAddCount());
	}	
}
```
>> 몇개나 들어갔는지 확인하려 기능을 추가함
>> addCount
>> 하지만 제대로 동작하지않음.
>> hashSet의 addAll은 add를 호출하여 작동하기땜시롱..
>> addAll을 재정의 하지않으면 ok.. 지만서도
>> addAll이 add를 이용해서 구현됬구나, 하는 가정에 의한 해법
>> addAll이 변경된다면.. ? -> 완전한 해결법이 아님
>> 


>> 데코레이터 패턴
>> 예제

>> 조심안하면
>> Properties, Stack의 경우처럼 될수잇따



 
#핵심정리





