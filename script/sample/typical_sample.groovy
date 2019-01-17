package mooncake.smoke.mt.dsl.sample

@GrabConfig(systemClassLoader=true)
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7')
@Grab(group='ch.qos.logback', module='logback-core', version='1.1.7')
@Grab(group='com.hybris.caas', module='mydsl', version='0.0.1')
@GrabExclude('org.codehaus.groovy:groovy-xml')
import mooncake.smoke.mt.dsl.MyDSL
import static mooncake.smoke.constants.OrderConstants.Status.*

MyDSL.make('refresh environment', false) {
//    refresh_env()
    refresh_env_by_yaml()
//    println yaml.all
}

MyDSL.make('check environment', false) {
    println yaml.all.resource.candidate
    println yaml.all.resource.locations

//    check_env()
//    check_env_by_yaml()
}

MyDSL.make('use clients', true) {
//    logging(true) // after this, always logging
//    request_logging(true)
    response_logging(true)
    clients.broker.method().get('/merchants/orders?pageSize=1')
//    logging(false) // after this, only logging when assertation fail
//    request_logging(false)
    response_logging(false)
}

MyDSL.make('create order',false) {
    def id = create_order(_PRODUCT_FIRST_1, DRAFT)
    println "order id: ${id}"
}

MyDSL.make('set stocks',false) {
    _clear_then_set_inventories([(in_stock[0]):[(wh[0]): 10, (st[0]): 10],
                                 (in_stock[1]):[(wh[0]): 10, (st[0]): 10],
                                 (in_stock[2]):[(wh[0]): 10, (st[0]): 10],])
    _check_all_product_stocks()
}