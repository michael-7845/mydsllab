package mooncake.smoke.mt.dsl.jtp

@GrabConfig(systemClassLoader=true)
@Grab(group='ch.qos.logback', module='logback-classic', version='1.1.7')
@Grab(group='ch.qos.logback', module='logback-core', version='1.1.7')
@Grab(group='com.hybris.caas', module='mydsl', version='0.0.1')
@GrabExclude('org.codehaus.groovy:groovy-xml')
import mooncake.smoke.mt.dsl.MyDSL
import static mooncake.smoke.constants.OrderConstants.Status.*

MyDSL.make('inventory', true) {
    clear_then_set_inventories([(in_stock[0]):[(st[0]): 10],
                                (in_stock[1]):[(st[1]): 10],
                                (in_stock[2]):[(wh[0]): 10]])
    check_all_product_stocks()
}

MyDSL.make('store orders', true) {
    def id = create_order(_PRODUCT_FIRST_1_SECOND_2_THIRD_3, CLEARING)

    assert run_export_job()

    println "order id: ${id}"
}



