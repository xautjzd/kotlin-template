package io.terminus.template.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Service

/**
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2018/7/24 5:18 PM
 */
@Service
class UserServiceImpl : UserService {

    @Autowired
    private val jdbcTemplate: JdbcTemplate? = null

    override val allUsers: Int?
        get() = jdbcTemplate!!.queryForObject("select count(1) from USER", Int::class.java)

    override fun create(name: String, password: String?) {
        jdbcTemplate!!.update("insert into USER(USERNAME, PASSWORD) values(?, ?)", name, password)
    }

    override fun deleteByName(name: String) {
        jdbcTemplate!!.update("delete from USER where USERNAME = ?", name)
    }

    override fun deleteAllUsers() {
        jdbcTemplate!!.update("delete from USER")
    }
}