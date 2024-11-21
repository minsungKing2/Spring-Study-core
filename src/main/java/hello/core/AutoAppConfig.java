package hello.core;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//@ComponentScan: @Component 가 붙은 클래스들을 자동으로 스프링 Bean 으로 등록해줌.
@ComponentScan(

        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
) //이 메서드는 제외할 설정 정보를 지정해주는 것.(스프링 Bean 에 자동으로 등록되지 않도록. 기존 다른 예제와 충돌 방지. 실무에서는 굳이 이렇게 안함.)
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository")
    MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}
