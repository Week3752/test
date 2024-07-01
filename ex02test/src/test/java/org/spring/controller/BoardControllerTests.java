package org.spring.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml",
		"file:src/main/webapp/WEB-INF/spring/root-context.xml" })
@Log4j
@WebAppConfiguration
public class BoardControllerTests {

	@Autowired
	private WebApplicationContext ctx;

	// MockMvc : 컨트롤러 테스트용 클래스
	// 실제 서버를 실행하지 않고 컨트롤러에 요청과 응답을 할수있도록 함
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}

	@Test
	public void testList() throws Exception {
		// mockMvc.perform()를 사용하여 /board/list URL에 GET 요청 전송
		log.info(mockMvc.perform(MockMvcRequestBuilders.get("/board/list")).andReturn() // 요청의 결과 반환
				.getModelAndView() // 반환된 결과에서 ModelAndView 정보 추출
				.getModelMap()); // 모델에 추가된 name : value 정보를 맵으로 변환하여 추출
	}

	@Test
	public void testRegister() throws Exception {
		log.info( mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "register 테스트")
				.param("content", "register 테스트")
				.param("writer", "register 테스트"))
				.andReturn());
							
	}
}
