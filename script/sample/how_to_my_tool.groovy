package mooncake.smoke.mt.dsl.sample

@GrabConfig(systemClassLoader=true)
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7')
@Grab(group='ch.qos.logback', module='logback-core', version='1.1.7')
@Grab(group='com.hybris.caas', module='mydsl', version='0.0.1')
@GrabExclude('org.codehaus.groovy:groovy-xml')
import mooncake.smoke.mt.dsl.MyDSL
import static mooncake.smoke.constants.OrderConstants.Status.*

MyDSL.make('order tool to access order field',false) {
//    id = create_order(_PRODUCT_FIRST_1, DRAFT)
    id = '1358963779'
    println "order id: ${id}"

    // order tool: ORDER(id, MERCHANT) or ORDER(id, USER); ORDER() = O() = order() = Order()
    def order = ORDER(id)

    println order.status
    println order.total
    println order.orderlines().size()
    println order.orderline(line_number: 1)
    println order.orderline(product_id: '300399821')
    println order.orderline(item_code: '300399821')
    println order.orderline(line_number: 1).itemCode
    println order.response.path('.')
    println order.r.path('.')
    order.refresh()
    println order.status
    order.refresh {
        println it.status
    }
}

MyDSL.make('response tool to access response',true) {
//    id = create_order(_PRODUCT_FIRST_1, DRAFT)
    id = '1358963779'
    println "order id: ${id}"

    // response tool: RESPONSE() = R() = response() = Response()
    def r = RESPONSE(get_order_by_id(id))
    println 'r.asString() : '+r.asString()
    println 'r.statusCode() : '+r.statusCode()
    println 'r.body() : '+r.body()
    println 'r.headers() : '+r.headers()
    println 'r.cookies() : '+r.cookies()
    println 'r.contentType() : '+r.contentType()
    println 'r.statusLine() : '+r.statusLine()
    println 'r.sessionId() : '+r.sessionId()
    println 'r.response() : '+r.response()
    println 'r.time() : '+r.time()
    println 'r.header(\'X-Vcap-Request-Id\') : '+r.header('X-Vcap-Request-Id')
    println 'r.jsonPath() : '+r.jsonPath()
    println 'r.xmlPath() : '+r.xmlPath()
    println 'r.htmlPath() : '+r.htmlPath()
    println 'r.as(Map) : '+r.as(Map)
    println 'r.path(\'status\') : '+r.path('status')
}
