package io.terminus.template.config

import io.ebean.EbeanServer
import io.ebean.EbeanServerFactory
import io.ebean.config.ServerConfig
import io.terminus.template.interceptors.UrlInterceptor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import javax.sql.DataSource

@Configuration
class WebConfig : WebMvcConfigurer {

    @Autowired
    lateinit private var applicationContext: ApplicationContext

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(applicationContext.getBean(UrlInterceptor::class.java))
    }

    @Bean
    fun ebeanServer(dataSource: DataSource): EbeanServer {
        val serverConfig = ServerConfig()
        serverConfig.name = "mysql"
        serverConfig.isDefaultServer = true
//        serverConfig.isDdlGenerate = true // Auto generate table
//        serverConfig.isDdlRun = true
        serverConfig.dataSource = dataSource
        serverConfig.packages = listOf(
                "io.terminus.template.model",
                "io.terminus")
        return EbeanServerFactory.create(serverConfig)
    }

    @Bean
    fun taskScheduler(): ThreadPoolTaskScheduler {
        return ThreadPoolTaskScheduler()
    }
}