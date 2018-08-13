package io.terminus.template

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureRestDocs
class TemplateApplicationTests {

	lateinit var mvc: MockMvc

	@Test
	fun contextLoads() {
	}

//	@Test
//	@Throws(Exception::class)
//	fun listUsers() {
//		this.mvc!!.perform(get("/myloginURL/user").accept(MediaType.TEXT_PLAIN))
//				.andExpect(status().isOk())
//				.andDo(document("list-users"))
//	}

}
