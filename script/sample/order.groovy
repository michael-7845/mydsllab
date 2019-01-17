package mooncake.smoke.mt.dsl.sample

@GrabConfig(systemClassLoader=true)
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7')
@Grab(group='ch.qos.logback', module='logback-core', version='1.1.7')
@Grab(group='com.hybris.caas', module='mydsl', version='0.0.1')
@GrabExclude('org.codehaus.groovy:groovy-xml')
import mooncake.smoke.mt.dsl.MyDSL
import static mooncake.smoke.constants.OrderConstants.Status.*

MyDSL.make('make order step by step ',true) {
//    id = create_order(_PRODUCT_FIRST_1, DRAFT)
    id = '0169648089'
    println "order id: ${id}"
    _order = order(id)
    println _order.total

//    //2. calculate cost
//    _total = calculate_cost(order_id: id)
//    println calculate_cost(order_id: id, shipping_method: _CA_SHIPPING_METHODS[1])

    //3. authroize payment
//    authorize_payment(order_id: id, order_total: _total)
//    assert wait_for_payauth(id)
    logging(true)
    _order.refresh(false) {
        println it.payment.authorizedAmount
        println it.response.path('.')
    }
    logging(false)

    //4. place order
//    place_order(order_id: id)
    assert wait_for_order_status(id, CLEARING)
    _order.refresh { println it.status }

    //5. run export job
//    println default_once_job_id
//    assert run_export_job()

    _order.refresh(true) {
        println it.status
    }

}
