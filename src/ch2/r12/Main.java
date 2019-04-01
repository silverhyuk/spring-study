package ch2.r12;


/**
 *  레시피 2-12 : POJO에게 IoC 컨테이너 리소스 알려주기
 *
 *  컴포넌트가 IoC 컨테이너와 직접적 의존 관계를 가지도록 설계하는 방법은 바람직하지 않지만,
 *  때로는 빈에서 컨테이너의 리소스를 인지해야 하는 경우도 있다.
 *
 *  ->
 *      "빈이 IoC 컨테이너를 인지하게 하려면 Aware 인터페이스를 구현한다."
 *      스프링은 이 인터페이스를 구현한 빈을 감지해, 대상 리소스를 세터 메서드로 주입한다.
 *
 *      자주 쓰는 스프링 Aware 인터페이스
 *      - BeanNameAware, BeanFactoryAware, ApplicationContextAware ...
 *
 * */

/**
 * Aware 인터페이스의 세터 메서드는 스프링이 빈 프로퍼티를 설정한 이후, 초기화 콜백 메서드를 호출하기 이전에 호출한다.
 * 순서는 다음과 같다
 *
 * 1 생성자나 팩토리 메서드를 호출해 빈 인스턴스를 생성한다.
 *
 * 2 빈 프로퍼티에 값, 빈 레퍼런스를 설정한다.
 *
 * 3 Aware 인터페이스에 정의한 세터 메서드를 호출한다.
 *
 * 4 빈 인스턴스를 각 빈 후처리기에 있는 postProcessBeforeInitialization() 메서드로 넘겨 초기화 콜백 메서드를 호출한다.
 *
 * 5 빈 인스턴스를 각 빈 후처리기 postProcessAfterInitialization() 메서드로 넘긴다. 이제 빈을 사용할 준비가 끝남
 *
 * 6 컨테이너가 종료되면 폐기 콜백 메서드를 호출한다.
 *
 * */

/**
 * 주의 : Aware 인터페이스를 구현한 클래스는 스프링과 엮이게 되므로 IoC 컨테이너 외부에서는 제대로 작동하지 않는다.
 * -> 스프링에 종속된 인터페이스를 구현할 필요가 있는지 꼭 따져봐야 한다.
 *
 *      -> 사실, 최신 스프링에서는 꼭 구현할 필요 없다. 이를테면 @Autowired만 붙여도 얼마든지 ApplicationContext를 가져올 수 있기 때문.
 *      (프레임워크, 라이브러리 개발할 때는 필요할 수도~)
 *
 * */
public class Main {
}
