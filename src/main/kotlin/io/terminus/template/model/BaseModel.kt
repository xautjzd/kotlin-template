package io.terminus.template.model

import io.ebean.Model
import io.ebean.annotation.WhenCreated
import io.ebean.annotation.WhenModified
import java.time.Instant
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * @author zhengdong.jzd@alibaba-inc.com
 * @date 2018/7/31 4:55 PM
 *
 * 公共信息
 */
@MappedSuperclass
open class BaseModel : Model() {
    @Id
    var id: Long = 0

    @WhenModified
    lateinit var updatedAt: Instant

    @WhenCreated
    lateinit var createdAt: Instant
}