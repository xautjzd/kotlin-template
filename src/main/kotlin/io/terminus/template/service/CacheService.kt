package io.terminus.template.service

import retrofit2.Call
import retrofit2.http.GET

/**
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2018/7/31 10:52 PM
 */
interface CacheService {
    @GET("/get-pip.py")
    fun getPip(): Call<String>
}