package io.terminus.template.controller

import com.alibaba.fastjson.JSON
import io.ebean.EbeanServer
import io.terminus.template.filters.LoginFilter
import io.terminus.template.model.Address
import io.terminus.template.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.*
import java.util.concurrent.atomic.AtomicLong

@RestController
@RequestMapping("/addresses")
class AddressController {

    companion object {
        val logger = LoggerFactory.getLogger(AddressController::class.java)
    }

    @Autowired
    lateinit var userService: UserService

    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun newAddress(@RequestBody body: String) {
        var address = JSON.parseObject(body, Address::class.java)
        logger.info("address: {}", address)
        address.save()
    }

    @GetMapping("/{addressId}")
    fun getAddress(@PathVariable addressId: Long) : Address? {
        return Address.byId(addressId)
    }

    @PostMapping("/{addressId}")
    fun updateAddress(@PathVariable addressId: Long, @RequestBody body: Address) {
        var address = Address.byId(addressId)
        address!!.apply {
            this.firstName = body.firstName
            this.province = body.province
            this.phone = body.phone
        }.save()
    }

    @DeleteMapping("/{addressId}")
    fun deleteAddress(@PathVariable addressId: Long) {
        logger.info("deleting address: {}", addressId)
        Address.deleteById(addressId)
    }

    @RequestMapping(method = arrayOf(RequestMethod.GET))
    fun getAddresses(): List<Address> {
        return Address.query().where().eq("firstName", "hz").findList()
    }

    @GetMapping("/query")
    fun getAddressesByName(@RequestParam name: String?) : List<Address> {
        if (name.isNullOrBlank()) {
            return Address.query().findList()
        } else {
            return Address.query().where().eq("firstName", name).findList()
        }
    }

}

data class Greet(val id: Long, val content: String)