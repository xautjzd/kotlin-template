package io.terminus.template.controller

import com.google.common.cache.CacheBuilder
import com.google.common.cache.CacheLoader
import io.terminus.template.service.CacheService
import org.apache.commons.lang3.StringUtils
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.TimeUnit

/**
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2018/7/31 10:36 PM
 */
@RestController
@RequestMapping("/cache")
class CacheController {

    @Autowired
    lateinit var cacheService: CacheService

    var pipCache = CacheBuilder.newBuilder()
            .maximumSize(100)
            .expireAfterWrite(10, TimeUnit.MINUTES)
            .build(object : CacheLoader<String, Any>() {
                override fun load(key: String): Any {
                    return cacheService.getPip().execute().body() ?: StringUtils.EMPTY
                }
            })

    @GetMapping("/pip")
    fun getPip(): String {
        return pipCache.get("pip").toString()
    }
}