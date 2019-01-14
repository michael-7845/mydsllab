@GrabConfig(systemClassLoader=true)
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7')
@Grab(group='ch.qos.logback', module='logback-core', version='1.1.7')
@Grab(group='com.hybris.caas', module='mydsl', version='0.0.1')
@GrabExclude('org.codehaus.groovy:groovy-xml')
import mooncake.smoke.mt.dsl.MyDSL
import static mooncake.smoke.st.client.enums.ClientType.*
import static mooncake.smoke.st.client.enums.HeaderType.*
import static mooncake.smoke.st.data.OrderLines.*

MyDSL.make {

    // sanity check
//    clients.broker.method().always_logging().get('/merchants/orders/4459077454')
//    clients.broker_customer.method().always_logging().post_body('/orders', [orderLines: [_RE_FIRST_1]])

    println _RE_FIRST_1

    // create order
//    def id = ep.broker.create_order(data.order._PRODUCT_FIRST_1, 'DRAFT')
    def id = ep.broker.create_order([orderLines: [_RE_FIRST_1]], 'WAREHOUSE')
    println "order id: ${id}"

    // show order
    ep.broker.get_order_by_id(id, USER, false)
}