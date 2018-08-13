package io.terminus.template.service

/**
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2018/7/24 5:18 PM
 */
interface UserService {

    /**
     * 获取用户总量
     */
    val allUsers: Int?

    /**
     * 新增一个用户
     * @param name
     * @param age
     */
    fun create(name: String, password: String?)

    /**
     * 根据name删除一个用户高
     * @param name
     */
    fun deleteByName(name: String)

    /**
     * 删除所有用户
     */
    fun deleteAllUsers()

}