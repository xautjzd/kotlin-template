package io.terminus.template.config

import io.terminus.template.service.CacheService
import okhttp3.OkHttpClient
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2018/7/31 10:56 PM
 */
@Configuration
class RetrofitConfig {
    @Bean
    fun cacheService(): CacheService {
        val okHttpClient = OkHttpClient().newBuilder()
                .retryOnConnectionFailure(true)
                .connectTimeout(5, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(5, TimeUnit.SECONDS)
                .build()

        var retrofit = Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://bootstrap.pypa.io/")
                //.addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(CacheService::class.java)
    }
}