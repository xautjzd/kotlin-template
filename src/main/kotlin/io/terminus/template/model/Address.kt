package io.terminus.template.model

import io.ebean.Finder
import io.ebean.Model
import io.ebean.annotation.EnumValue
import org.apache.commons.lang3.builder.ToStringBuilder
import org.apache.commons.lang3.builder.ToStringStyle
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "address")
class Address : BaseModel() {
    var firstName: String? = null

    var phone: String? = null

    var province: String? = null

    var status: Status? = null

    enum class Status {
        @EnumValue("Init")
        INIT,
        @EnumValue("Running")
        RUNNING,
        @EnumValue("Ready")
        READY,
    }

    companion object Find : Finder<Long, Address>(Address::class.java)

    override fun toString(): String {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE)
    }

//    companion object Find : AddressFinder()
}

/**
 * 可自定义查询方法
 */
//open class AddressFinder : Finder<Long, Address>(Address::class.java) {
//    fun test() : Address? {
//        return this.byId(2)
//    }
//}