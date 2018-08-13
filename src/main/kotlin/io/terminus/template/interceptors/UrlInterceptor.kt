package io.terminus.template.interceptors

import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class UrlInterceptor : HandlerInterceptorAdapter() {
    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        if (request.method.toUpperCase() == "GET" && request.requestURI == "/hello/interceptor") {
            throw RuntimeException("not allow to access")
        }
        return true
    }
}